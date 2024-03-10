package cn.had1szz.cyzy.util;

/**
 * @author : Horace Leoi
 * @since : 2024/3/7
 */
public interface PasswordEncoder {

    String encode(String rawPassword);

    boolean match(String rawPassword, String encoded);

}
