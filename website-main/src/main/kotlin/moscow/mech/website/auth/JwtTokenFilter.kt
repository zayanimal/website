package moscow.mech.website.auth

import moscow.mech.website.domain.auth.repository.AuthRepository
import org.aspectj.util.LangUtil.isEmpty
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JwtTokenFilter(
    @Autowired val jwtTokenService: JwtTokenService,
    @Autowired val authRepository: AuthRepository
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val header = request.getHeader(HttpHeaders.AUTHORIZATION)
        if (isEmpty(header) || !header.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        val token = header.split(" ")[1].trim()
        if (jwtTokenService.isExpired(token)) {
            filterChain.doFilter(request, response);
            return;
        }

        val userDetails = authRepository.findByLogin(jwtTokenService.getUsername(token)).orElse(null)
        val authentication = UsernamePasswordAuthenticationToken(
            userDetails,
            null,
            userDetails?.role?.map { role -> SimpleGrantedAuthority(role.name) } ?: listOf()
        )

        authentication.details = WebAuthenticationDetailsSource().buildDetails(request)

        SecurityContextHolder.getContext().authentication = authentication;
        filterChain.doFilter(request, response);
    }
}
