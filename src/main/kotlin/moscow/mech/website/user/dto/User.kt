package moscow.mech.website.user.dto

data class User(
    val login: String,

    val surname: String,

    val name: String,

    val middleName: String,

    val role: String,

    val address: Address,

    val contact: Contact
)
