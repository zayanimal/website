package moscow.mech.website.dto.auth

import com.fasterxml.jackson.annotation.JsonIgnore

data class AuthResponse(

    val username: String,

    val role: List<String>,

    @JsonIgnore
    val token: String? = null
)
