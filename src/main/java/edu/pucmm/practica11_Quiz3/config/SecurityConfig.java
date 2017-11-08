package edu.pucmm.practica11_Quiz3.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Properties;

@Configurable
//@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter implements ApplicationContextAware {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/","/css/**", "/js/**","/static/**").permitAll() //permitiendo llamadas a esas urls.
                .antMatchers("/addNewUserAccount/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/Users/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/dbconsole/**").permitAll()
                .and()
                .formLogin()
                .loginPage("/login") //indicando la ruta que estaremos utilizando.
                .failureUrl("/login?error")
                .permitAll()
                .and()
                .logout()
                .permitAll();

        http.headers().frameOptions().disable();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //Cargando los usuarios en memoria.
//        auth.userDetailsService(inMemoryUserDetailsManager());
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("admin")
//                .withUser("vacax")
//                .password("1234")
                .roles("ADMIN","USER")
                .and()
                .withUser("usuario")
                .password("1234")
                .roles("USER");
    }


//    @Bean
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
//        final Properties users = new Properties();
//        users.put("admin","admin,ADMIN,enabled"); //add whatever other user you need
//        users.put("uno","1234,USER,enabled");
//        return new InMemoryUserDetailsManager(users);
//    }


}