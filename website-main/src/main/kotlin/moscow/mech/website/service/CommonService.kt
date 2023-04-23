package moscow.mech.website.service

import moscow.mech.website.domain.product.entity.PictureEntity
import org.springframework.stereotype.Service

@Service
class CommonService {

    fun getPicture(pictures: List<PictureEntity>): String {
        return if (pictures.isEmpty()) "" else pictures.first().identification
    }
}
