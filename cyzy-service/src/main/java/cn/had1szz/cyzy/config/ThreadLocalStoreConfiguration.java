package cn.had1szz.cyzy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Horace Leoi
 * @since : 2024/3/11
 */
@Configuration
public class ThreadLocalStoreConfiguration {

    @Bean
    public ThreadLocal<Long> uidThreadLocal() {
        return new ThreadLocal<>();
    }


}
