package cn.had1szz.cyzy.vo;

import cn.had1szz.cyzy.domain.SysUser;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author : Horace Leoi
 * @since : 2024/3/7
 */
@Data
@AllArgsConstructor
public class UserLoginVO {
    private SysUser sysUser;
    private String token;

    @Data
    public static final class UserBuilder {
        private SysUser sysUser;
        private String token;

        private UserBuilder() {}

        private UserBuilder(SysUser user) {
            this.sysUser = user;
        }

        public UserLoginVO build() {
            return new UserLoginVO(sysUser, token);
        }

        public UserBuilder token(String token) {
            this.token = token;
            return this;
        }
    }

    public static UserBuilder withSysUser(SysUser user) {
        return new UserBuilder(user);
    }
}
