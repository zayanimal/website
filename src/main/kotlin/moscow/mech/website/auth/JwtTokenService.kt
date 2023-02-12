package moscow.mech.website.auth

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import java.util.Date

@Service
class JwtTokenService {

    private val JWT_TOKEN_VALIDITY = (5 * 60 * 60).toLong()

    @Value("\${jwt.secret}")
    private val secret: String? = null

    fun generate(userDetails: UserDetails): String = doGenerateToken(HashMap(), userDetails.username)

    private fun doGenerateToken(claims: Map<String, Any>, subject: String): String = Jwts.builder()
        .setClaims(claims)
        .setSubject(subject)
        .setIssuedAt(Date(System.currentTimeMillis()))
        .setExpiration(Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
        .signWith(SignatureAlgorithm.HS512, secret).compact()

    fun validate(token: String, userDetails: UserDetails): Boolean {
        return getUsername(token) == userDetails.username && !isExpired(token)
    }

    fun isExpired(token: String): Boolean = getExpirationDate(token).before(Date())

    fun getUsername(token: String): String = getClaim(token, Claims::getSubject)

    fun getExpirationDate(token: String): Date = getClaim(token, Claims::getExpiration)

    private fun <T> getClaim(token: String, claimsResolver: (Claims) -> T): T = claimsResolver.invoke(
        Jwts.parser()
            .setSigningKey(secret)
            .parseClaimsJws(token)
            .body)
}
