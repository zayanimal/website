package moscow.mech.website.user.dto

data class User(
    val login: String,

    val role: String,

    val address: List<Address>,

    val contact: List<Contact>,

    val recipient: List<Recipient>,

    val defaultAddressId: Long,

    val defaultContactId: Long,

    val defaultRecipientId: Long
)
