package moscow.mech.website.dto.section

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class Section (

    val id: Long,

    val name: String,

    val categories: List<Category>
)
