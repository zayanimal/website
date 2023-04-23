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
import moscow.mech.website.exception.BadUserException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
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
            address.flat,
            securityService.getUserId()
        )
    )

    fun createContact(contact: Contact) = contactRepository.save(
        ContactEntity(
            contact.phone,
            contact.email,
            securityService.getUserId()
        )
    )

    fun createRecipient(recipient: Recipient) = recipientRepository.save(
        RecipientEntity(
            recipient.surname,
            recipient.name,
            recipient.middleName,
            securityService.getUserId()
        )
    )

    fun deleteAddress(id: Long) {
        val address = addressRepository.findById(id).get()
        address.userId?.let { securityService.checkUser(it) {
            address.id?.let { it1 -> addressRepository.deleteById(it1) }
        } }
    }

    fun deleteContact(id: Long) {
        val contact = contactRepository.findById(id).get()
        contact.userId?.let { securityService.checkUser(it) {
            contact.id?.let { it1 -> contactRepository.deleteById(it1) }
        } }
    }

    fun deleteRecipient(id: Long) {
        val recipient = recipientRepository.findById(id).get()
        recipient.userId?.let { securityService.checkUser(it) {
            recipient.id?.let { it1 -> recipientRepository.deleteById(it1)}
        } }
    }
}
