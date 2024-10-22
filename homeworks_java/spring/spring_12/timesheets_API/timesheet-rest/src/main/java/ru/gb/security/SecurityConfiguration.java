package ru.gb.security;

import org.h2.engine.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;
import java.util.Map;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfiguration {

  @Bean
  GrantedAuthorityDefaults grantedAuthorityDefaults() {
    return new GrantedAuthorityDefaults("");
  }
  

//@Bean
//  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//    return http
//            .csrf(AbstractHttpConfigurer::disable)
//      .authorizeHttpRequests(it-> it.anyRequest().permitAll()
////              requests -> requests
////         .requestMatchers("/home/projects/**").hasAuthority("admin")
////                      .requestMatchers("/home/timesheets/**").hasAuthority("user") // MY_ROLE_PREFIX_admin
////         .requestMatchers("/timesheets/**").hasAuthority("rest")
////                      .anyRequest().authenticated()
//      )
//   // .formLogin(Customizer.withDefaults())
//      .build();
//  }

   @Bean
   PasswordEncoder passwordEncoder() {
     return new BCryptPasswordEncoder();
   }

     @Bean
     SecurityFilterChain oauth2Security(HttpSecurity http) throws Exception {
       return http
         .csrf(AbstractHttpConfigurer::disable)
         .authorizeHttpRequests(it -> it

                 /* я здесь поменяла на рандомную realm роль, которую взяла из токена.
                 В keycloack, в юзере её не видно, а в токене она есть. Только так и пошло.

                 Рилм-роли почему-то в юзере не отображались вообще,
                 потом что-то накликала и отобразились какие то, но не  timesheet.
                  A "timesheet" хоть и успешно создалась, но keycloack не хочет её отдавать юзеру.
                 В гайдах по keycloack не нашла ничего, там старый интерфейс описывают.
                 Конечно, если ещё потыкать, то возможно, разобралась бы.
                 Но увы...
                  */

           .requestMatchers("/timesheets/**").hasRole("uma_authorization")
           .anyRequest().authenticated()
         )
         .oauth2ResourceServer(oAuth2ResourceServerConfigurer -> oAuth2ResourceServerConfigurer
           .jwt(jwtConfigurer -> {
             JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
             converter.setJwtGrantedAuthoritiesConverter(jwt -> {
               Map<String, List<String>> realmAccess = jwt.getClaim("realm_access");
               List<String> roles = realmAccess.get("roles");

               return roles.stream()
                 .map(SimpleGrantedAuthority::new)
                 .map(it -> (GrantedAuthority) it)
                 .toList();
             });
             jwtConfigurer.jwtAuthenticationConverter(converter);
           })
         )
         .build();
    }


}
