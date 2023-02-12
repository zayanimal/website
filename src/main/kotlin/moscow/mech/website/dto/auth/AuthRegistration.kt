package moscow.mech.website.dto.auth

data class AuthRegistration(
    val username: String,

    val password: String,

    val address: List<AuthAddress>,

    val contact: List<AuthContact>,

    val recipient: List<AuthRecipient>
)
