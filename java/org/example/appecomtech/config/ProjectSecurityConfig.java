package org.example.appecomtech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf((csrf)->csrf.disable())

                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/login", "/inscription"
                        ).authenticated()
                        .requestMatchers("/", "/produits/allproduits", "/webjars/**","/h2-console/**" , "/recherche" ,"/Apple" ,
                                "/panier","/panier/ajouter","/panier/viewpanier" , "/panier/passer-commande" ,"/Smartphones","/Accessoires"
                                ,"/Tablettes","/Samsung","/Huawei","/panier","/css/**", "/js/**", "/image/**","/admin/admin" ,"/profiles",
                                "/utilisateurs/list","/produits/gererproduits","/admin/commande-admin","/panier/supprimer","/commande/passer-commande",
                                "/panier","/commande/confirmation","/utilisateurs/ajouter","/utilisateurs/details/{id}","/utilisateurs/modifier/{id}",
                                "/produits/details/{id}","/produits/modifier/{id}","/produits/ajouter",
                                "/produits/supprimer/{id}","/utilisateurs/supprimer/{id}"
                        ).permitAll())
//                .formLogin((form -> form.loginPage("/loginpage").permitAll()))
                .formLogin(form -> form
                        .defaultSuccessUrl("/", true))
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}


