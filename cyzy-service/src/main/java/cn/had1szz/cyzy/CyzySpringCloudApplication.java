package cn.had1szz.cyzy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author : Horace Leoi
 * @since : 2024/3/9
 */
@SpringBootApplication
@EnableAspectJAutoProxy
public class CyzySpringCloudApplication {
    public static void main(String[] args) {
        SpringApplication.run(CyzySpringCloudApplication.class, args);
    }
}

