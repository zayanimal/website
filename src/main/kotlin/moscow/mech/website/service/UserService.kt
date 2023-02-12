package moscow.mech.website.service

import moscow.mech.website.constant.Role
import moscow.mech.website.domain.user.entity.AddressEntity
import moscow.mech.website.domain.user.entity.ContactEntity
import moscow.mech.website.domain.user.entity.RecipientEntity
import moscow.mech.website.domain.user.entity.UserEntity
import moscow.mech.website.domain.user.repository.*
import moscow.mech.website.dto.auth.AuthRegistration
import moscow.mech.website.dto.user.Address
import moscow.mech.website.dto.user.Contact
import moscow.mech.website.dto.user.Recipient
import moscow.mech.website.dto.user.User
import moscow.mech.website.dto.auth.AuthAddress
import moscow.mech.website.dto.auth.AuthContact
import moscow.mech.website.dto.auth.AuthRecipient
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import kotlin.streams.toList

@Service
class UserService @Autowired constructor(
    val userRepository: UserRepository,
    val roleRepository: RoleRepository,
    val addressRepository: AddressRepository,
    val contactRepository: ContactRepository,
    val recipientRepository: RecipientRepository,
    val passwordEncoder: PasswordEncoder
) {

    private val log = LoggerFactory.getLogger(this.javaClass)

    fun get(id: Long): User {
        val user = userRepository.findById(id).get()

        return User(
            user.login,
            user.role.map { it.name },
            user.address.stream().map {Address(it.id!!, it.idx, it.city, it.street, it.home, it.flat)}.toList(),
            user.contact.stream().map {Contact(it.id!!, it.phone, it.email)}.toList(),
            user.recipient.stream().map {Recipient(it.id!!, it.surname, it.name, it.middleName)}.toList()
        )
    }

    fun create(registration: AuthRegistration): UserEntity {
        val user = UserEntity(
            registration.username,
            passwordEncoder.encode(registration.password),
            listOf(roleRepository.findByName(Role.CUSTOMER.toString()).get()),
            registration.address.map { AddressEntity(it.index, it.city, it.street, it.home, it.flat) },
            registration.contact.map { ContactEntity(it.phone, it.email) },
            registration.recipient.map { RecipientEntity(it.surname, it.name, it.middleName) }
        )

        return userRepository.save(user)
    }

    fun createAddress(address: AuthAddress) = addressRepository.save(AddressEntity(
        address.index,
        address.city,
        address.street,
        address.home,
        address.flat
    ))

    fun createContact(contact: AuthContact) = contactRepository.save(ContactEntity(
        contact.phone,
        contact.email
    ))

    fun createRecipient(recipient: AuthRecipient) = recipientRepository.save(RecipientEntity(
        recipient.surname,
        recipient.name,
        recipient.middleName
    ))
}
