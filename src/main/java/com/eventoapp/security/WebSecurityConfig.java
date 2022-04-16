package com.eventoapp.security;


import com.eventoapp.controlles.IndexController;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private ImplementsUserDetailsService userDetailsService;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/login", "/telaCadastro").permitAll() // Permito que toda requisição feita para / ou telacadastro seja permitida sem autenticação
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").permitAll() //Para todas as demais precisa de autenticação e direciona para a página "/"
                .defaultSuccessUrl("/eventos")
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication() //User, senha e controle de acesso para autenticação em memória.
                .withUser("admin")
                    .password("{noop}admin")
                        .roles("ADMIN")

                .and()

                .withUser("user")
                    .password("{noop}user")
                        .roles("USER");
    }


/*    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());

    }*/

    @Override //Método para não bloquear as páginas Staticas
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/materialize/**", "/style/**");

    }

}
