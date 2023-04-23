package moscow.mech.website.dto.auth

import moscow.mech.website.dto.user.Address
import moscow.mech.website.dto.user.Contact
import moscow.mech.website.dto.user.Recipient

data class AuthRegistration(

    val username: String,

    val password: String,

    val address: List<Address>,

    val contact: List<Contact>,

    val recipient: List<Recipient>
)
