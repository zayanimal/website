package moscow.mech.website.user

import moscow.mech.website.user.dto.Address
import moscow.mech.website.user.dto.Contact
import moscow.mech.website.user.dto.Recipient
import moscow.mech.website.user.dto.User
import moscow.mech.website.user.repositories.AddressRepository
import moscow.mech.website.user.repositories.ContactRepository
import moscow.mech.website.user.repositories.RecipientRepository
import moscow.mech.website.user.repositories.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.streams.toList

@Service
class UserService @Autowired constructor(
    val userRepository: UserRepository,
    val addressRepository: AddressRepository,
    val contactRepository: ContactRepository,
    val recipientRepository: RecipientRepository
) {

    private val log = LoggerFactory.getLogger(this.javaClass)

    fun get(id: Long): User {
        val user = userRepository.findById(id).get()

        log.info(user.toString())

        return User(
            user.login,
            user.role.name,
            user.address.stream().map {a ->  Address(a.id, a.idx, a.city.name, a.street, a.home, a.flat)}.toList(),
            user.contact.stream().map {c -> Contact(c.id, c.phone, c.email)}.toList(),
            user.recipient.stream().map {f -> Recipient(f.id, f.surname, f.name, f.middleName)}.toList(),
            user.defaultAddressId,
            user.defaultContactId,
            user.defaultRecipientId
        )
    }
}
