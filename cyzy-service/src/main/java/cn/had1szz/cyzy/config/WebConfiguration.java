package cn.had1szz.cyzy.config;

import cn.had1szz.cyzy.interceptor.CorsInterceptor;
import cn.had1szz.cyzy.interceptor.JwtInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author : Horace Leoi
 * @since : 2024/3/7
 */
@Component
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    private final JwtInterceptor jwtInterceptor;
    private final CorsInterceptor corsInterceptor;

    public WebConfiguration(JwtInterceptor jwtInterceptor, CorsInterceptor corsInterceptor) {
        this.jwtInterceptor = jwtInterceptor;
        this.corsInterceptor = corsInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor)
                .excludePathPatterns("/users/login")
                .excludePathPatterns("/static/**");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 所有接口
                .allowCredentials(true) // 是否发送 Cookie
                .allowedOriginPatterns("http://localhost:5173/", "http://127.0.0.1:5173/") // 支持域
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 支持方法
                .allowedHeaders("authorization", "content-type");
    }

}
