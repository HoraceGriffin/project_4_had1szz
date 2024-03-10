package cn.had1szz.cyzy.controller;

import cn.had1szz.cyzy.domain.SysUser;
import cn.had1szz.cyzy.dto.UserLoginDTO;
import cn.had1szz.cyzy.response.Result;
import cn.had1szz.cyzy.service.UserService;
import cn.had1szz.cyzy.util.TokenGenerator;
import cn.had1szz.cyzy.vo.UserLoginVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author : Horace Leoi
 * @since : 2024/3/7
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final TokenGenerator tokenGenerator;

    public UserController(UserService userService, TokenGenerator tokenGenerator) {
        this.userService = userService;
        this.tokenGenerator = tokenGenerator;
    }

    @PostMapping("/login")
    public Result<UserLoginVO> userLogin(@Valid @RequestBody UserLoginDTO userLoginDTO) {
        SysUser sysUser = userService.doLogin(userLoginDTO);
        sysUser.setPassword(null);

        UserLoginVO vo = UserLoginVO
                .withSysUser(sysUser)
                .token(tokenGenerator.getToken(sysUser.getUid()))
                .build();
        return Result.ok(vo);
    }

}
