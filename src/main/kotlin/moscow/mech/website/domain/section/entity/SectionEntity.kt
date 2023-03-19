package moscow.mech.website.domain.section.entity

import javax.persistence.*

@Entity
@Table(name = "SECTION")
class SectionEntity (

    @Id
    val id: Long,

    val name: String,

    @OneToMany
    @JoinColumn(name = "section_id")
    val category: List<CategoryEntity>,

    val enabled: Boolean
)
