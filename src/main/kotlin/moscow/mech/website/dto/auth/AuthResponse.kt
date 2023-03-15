package moscow.mech.website.dto.auth

data class AuthResponse(

    val username: String,

    val role: List<String>,

    val token: String
)
