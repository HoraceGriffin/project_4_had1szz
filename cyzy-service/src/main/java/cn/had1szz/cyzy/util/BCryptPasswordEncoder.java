package cn.had1szz.cyzy.util;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

/**
 * @author : Horace Leoi
 * @since : 2024/3/7
 */
@Component
public class BCryptPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(String rawPassword) {
        return BCrypt.hashpw(rawPassword, BCrypt.gensalt());
    }

    @Override
    public boolean match(String rawPassword, String encoded) {
        return BCrypt.checkpw(rawPassword, encoded);
    }
}
