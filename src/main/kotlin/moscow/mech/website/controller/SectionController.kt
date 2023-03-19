package moscow.mech.website.controller

import moscow.mech.website.dto.section.Section
import moscow.mech.website.service.SectionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("section")
class SectionController @Autowired constructor(val sectionService: SectionService) {

    @GetMapping
    fun getSections(): List<Section> {
        return sectionService.getSections()
    }
}
