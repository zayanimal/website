package moscow.mech.website.service

import moscow.mech.website.domain.section.repository.SectionRepository
import moscow.mech.website.dto.section.Category
import moscow.mech.website.dto.section.Section
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SectionService @Autowired constructor(
    val sectionRepository: SectionRepository
) {

    fun getSections(): List<Section> {
        val section = sectionRepository.findAll()

        return section
            .filter { s -> s.enabled }
            .map { s1 -> Section(
                s1.id,
                s1.name,
                s1.category
                    .filter { c -> c.enabled }
                    .map { c1 -> Category(c1.id, c1.name) }) }
    }
}
