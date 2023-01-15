package moscow.mech.website.dto.auth

data class AuthRegistration(
    val username: String,

    val password: String,

    val address: AuthAddress,

    val contact: AuthContact,

    val recipient: AuthRecipient
)
