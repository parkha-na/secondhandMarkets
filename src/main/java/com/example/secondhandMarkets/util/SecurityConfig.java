package com.example.secondhandMarkets.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
	
	@SuppressWarnings("removal")
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors(cors -> cors.disable())			//cors 방지
                .csrf(csrf -> csrf.disable())			//csrf 방지
                .formLogin(login -> login.disable())		//기본 로그인페이지 없애기
                .headers(headers -> headers.frameOptions().disable())
             // .formLogin은 스프링 시큐리티의 로그인 설정을 담당하는 메서드
                .formLogin((formLogin) -> formLogin
                				// 로그인페이지의 url은 "/user/login"
                              .loginPage("/select.do")
                				// 로그인 성공 시 이동하는 페이지는 루트
                              .defaultSuccessUrl("/")
                              .usernameParameter("id"))
                .logout((logout) -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout.do"))
          				// 성공하면 루트 페이지로 이동
                        .logoutSuccessUrl("/")
          				// 로그아웃 시 생성된 사용자 세션 삭제
                        .deleteCookies("JESSIONID", "remember-me"))
                ;
 
		return http.build();
	}
	
}