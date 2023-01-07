package moscow.mech.website.user

import moscow.mech.website.user.dto.Address
import moscow.mech.website.user.dto.Contact
import moscow.mech.website.user.dto.User
import moscow.mech.website.user.repositories.AddressRepository
import moscow.mech.website.user.repositories.ContactRepository
import moscow.mech.website.user.repositories.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService @Autowired constructor(
    val userRepository: UserRepository,
    val addressRepository: AddressRepository,
    val contactRepository: ContactRepository
) {

    private val log = LoggerFactory.getLogger(this.javaClass)

    fun get(id: Long): User {
        val user = userRepository.findById(id).get()

        log.info(user.toString())

        return User(
            user.login,
            user.surname,
            user.name,
            user.middleName,
            user.role.name,

            Address(
                user.address.idx,
                user.address.city.name,
                user.address.street,
                user.address.home,
                user.address.flat
            ),

            Contact(
                user.contact.phone,
                user.contact.email
            )
        )
    }
}
