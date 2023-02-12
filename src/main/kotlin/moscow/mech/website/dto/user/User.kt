package moscow.mech.website.dto.user

data class User(
    val login: String,

    val role: List<String>,

    val address: List<Address>,

    val contact: List<Contact>,

    val recipient: List<Recipient>
)
