package moscow.mech.website.configuration

import moscow.mech.website.auth.JwtTokenFilter
import moscow.mech.website.domain.auth.repository.AuthRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.ProviderManager
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter
import javax.servlet.http.HttpServletResponse

@Configuration
@EnableWebSecurity
class AuthConfiguration(
    @Autowired val authRepository: AuthRepository,
    @Autowired val jwtTokenFilter: JwtTokenFilter
) {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authenticationManager(authenticationManager())
            // CORS и CSRF
            .cors().and()
            .csrf().disable()
            // Сессия
            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            // Обработка ошибок аутентификации
            .exceptionHandling()
                .authenticationEntryPoint { _, response, e ->
                    response.sendError(
                        HttpServletResponse.SC_UNAUTHORIZED,
                        e.message
                    )
                }.and()
            // Авторизация запросов
            .authorizeRequests()
                .antMatchers("/login", "/register").permitAll()
                .anyRequest()
                .authenticated().and()
            // Фильтр JWT токенов перед username/password фильтром
            .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter::class.java)

        return http.build()
    }

    @Bean
    fun authenticationManager(): AuthenticationManager {
        val authProvider = DaoAuthenticationProvider()
        authProvider.setUserDetailsService { username ->
            val user = authRepository.findByLogin(username)
                .orElseThrow{ UsernameNotFoundException("Пользователь не найден") }

            User.builder()
                .username(user.login)
                .password(user.password)
                .authorities(user.role.map { SimpleGrantedAuthority(it.name) })
                .build()
        }
        authProvider.setPasswordEncoder(passwordEncoder())

        return ProviderManager(authProvider)
    }

    @Bean
    fun corsFilter(): CorsFilter {
        val source = UrlBasedCorsConfigurationSource()
        val config = CorsConfiguration()

        config.allowCredentials = true
        config.addAllowedOrigin("*")
        config.addAllowedHeader("*")
        config.addAllowedMethod("*")
        source.registerCorsConfiguration("/**", config)

        return CorsFilter(source)
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}
