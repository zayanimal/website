package moscow.mech.website.service

import moscow.mech.website.domain.user.entity.AddressEntity
import moscow.mech.website.domain.user.entity.ContactEntity
import moscow.mech.website.domain.user.entity.RecipientEntity
import moscow.mech.website.domain.user.repository.AddressRepository
import moscow.mech.website.domain.user.repository.ContactRepository
import moscow.mech.website.domain.user.repository.RecipientRepository
import moscow.mech.website.domain.user.repository.UserRepository
import moscow.mech.website.dto.user.Address
import moscow.mech.website.dto.user.Contact
import moscow.mech.website.dto.user.Recipient
import moscow.mech.website.dto.user.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.streams.toList

@Service
class UserService @Autowired constructor (
    val addressRepository: AddressRepository,
    val contactRepository: ContactRepository,
    val recipientRepository: RecipientRepository,
    val userRepository: UserRepository,
    val securityService: SecurityService
) {

    fun get(): User {
        val user = userRepository.findById(securityService.getUserId()).get()

        return User(
            user.login,
            user.role.map { it.name },
            user.address.stream().map {Address(it.id!!, it.idx, it.city, it.street, it.home, it.flat)}.toList(),
            user.contact.stream().map {Contact(it.id!!, it.phone, it.email)}.toList(),
            user.recipient.stream().map {Recipient(it.id!!, it.surname, it.name, it.middleName)}.toList()
        )
    }

    fun createAddress(address: Address) = addressRepository.save(
        AddressEntity(
            address.index,
            address.city,
            address.street,
            address.home,
            address.flat
        )
    )

    fun createContact(contact: Contact) = contactRepository.save(
        ContactEntity(
            contact.phone,
            contact.email
        )
    )

    fun createRecipient(recipient: Recipient) = recipientRepository.save(
        RecipientEntity(
            recipient.surname,
            recipient.name,
            recipient.middleName
        )
    )
}
