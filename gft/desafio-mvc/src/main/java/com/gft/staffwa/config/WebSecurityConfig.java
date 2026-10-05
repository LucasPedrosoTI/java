package com.gft.staffwa.config;

import com.gft.staffwa.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  @Autowired
  UsuarioService usuarioService;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(usuarioService).passwordEncoder(passwordEncoder);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    //@formatter:off
    http.csrf().disable()
      .authorizeRequests().antMatchers("/cadastrar").permitAll()
      .antMatchers("/acessoNegado.jsp").permitAll()
      .antMatchers("/usuarios/novo").permitAll()
      .antMatchers("/**/cadastrar").hasRole("ADMIN")
      .antMatchers("/**/funcionarios/{\\d+}").hasRole("ADMIN")
      .antMatchers("/**/vagas/{\\d+}").hasRole("ADMIN")
      .anyRequest().authenticated()
      .and()
      .formLogin().loginPage("/login").permitAll()
      .usernameParameter("email")
      .passwordParameter("senha")
      .defaultSuccessUrl("/", true).failureUrl("/login?erro=true")
      .and()
      .logout()
        .invalidateHttpSession(true)
        .logoutSuccessUrl("/login?logout=true").permitAll()
        .logoutUrl("/logout")
        .deleteCookies("JSESSIONID")
      .and()
	      .exceptionHandling().accessDeniedPage("/accessDenied");
  //@formatter:on
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/img/**");
  }

}
