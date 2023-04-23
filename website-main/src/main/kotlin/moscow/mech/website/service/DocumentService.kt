package moscow.mech.website.service

import moscow.mech.website.domain.document.repository.DocumentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DocumentService @Autowired constructor(
    val documentRepository: DocumentRepository
) {

    fun create() {

    }

    fun delete() {

    }
}
