package cn.had1szz.cyzy.service;

import cn.had1szz.cyzy.domain.SysUser;
import cn.had1szz.cyzy.dto.UserLoginDTO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author : Horace Leoi
 * @since : 2024/3/7
 */
public interface UserService extends IService<SysUser> {

    SysUser loadUserByUsername(String username);

    SysUser doLogin(UserLoginDTO userLoginDTO);

}
