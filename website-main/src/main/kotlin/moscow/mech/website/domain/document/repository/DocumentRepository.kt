package moscow.mech.website.domain.document.repository

import moscow.mech.website.domain.document.entity.DocumentEntity
import org.springframework.data.repository.CrudRepository

interface DocumentRepository : CrudRepository<DocumentEntity, Long> {}
