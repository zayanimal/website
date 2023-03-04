package moscow.mech.website.domain.document.entity

import javax.persistence.*

@Entity
@Table(name = "DOCUMENT_TYPE")
class DocumentTypeEntity (

    @Id
    val id: Long,

    val name: String
)
