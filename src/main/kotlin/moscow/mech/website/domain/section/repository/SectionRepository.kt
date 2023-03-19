package moscow.mech.website.domain.section.repository

import moscow.mech.website.domain.section.entity.SectionEntity
import org.springframework.data.repository.CrudRepository

interface SectionRepository : CrudRepository<SectionEntity, Long> {}
