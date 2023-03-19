package moscow.mech.website.domain.section.entity

import javax.persistence.*

@Entity
@Table(name = "CATEGORIES")
class CategoryEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val name: String,

    val enabled: Boolean
)
