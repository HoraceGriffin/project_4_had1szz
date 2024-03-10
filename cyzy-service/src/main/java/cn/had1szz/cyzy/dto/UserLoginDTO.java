package cn.had1szz.cyzy.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author : Horace Leoi
 * @since : 2024/3/7
 */
@Data
public class UserLoginDTO {
    @NotBlank(message = "用户名不可为空")
    private String username;
    @NotBlank(message = "密码不可为空")
    private String password;
}
