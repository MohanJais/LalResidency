package com.TransTech.LalResidency.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

//@Configuration
//@EnableWebSecurity
//public class MySecurityConfig extends WebSecurityConfiguration {
/*public class MySecurityConfig extends WebSecurityConfigurer {

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.cors().and().csrf().disable()
			.authorizeRequest()
			.antMatchers("/api/public/**").permitAll()
			.antMatchers("/api/private/**").authenticated()
			.anyRequest().authenticated()
			.and()
			.apply(new JwtConfigurer(jwtTockenProvider));
	}
*/
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests()
//                .antMatchers("/public/**").permitAll() // URLs accessible to all
//                .antMatchers("/admin/**").hasRole("ADMIN") // URLs restricted to users with "ADMIN" role
//                .anyRequest().authenticated() // Any other URL requires authentication
//            .and()
//            .formLogin() // Enable form-based login
//                .loginPage("/login") // Custom login page
//                .defaultSuccessURL("/dashboard")
//            .and()
//            .logout() // Enable logout
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/login?logout")
//            .and()
//            .csrf().disable(); // Disable CSRF for simplicity (enable it in production)
//    }
//    
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//            .inMemoryAuthentication()
//                .withUser("user").password("{noop}password").roles("USER")
//                .and()
//                .withUser("admin").password("{noop}admin").roles("USER", "ADMIN");
//    }
}
