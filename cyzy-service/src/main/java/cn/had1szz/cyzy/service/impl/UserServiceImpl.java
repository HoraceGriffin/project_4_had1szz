package cn.had1szz.cyzy.service.impl;

import cn.had1szz.cyzy.domain.SysUser;
import cn.had1szz.cyzy.dto.UserLoginDTO;
import cn.had1szz.cyzy.mapper.UserMapper;
import cn.had1szz.cyzy.service.UserService;
import cn.had1szz.cyzy.util.PasswordEncoder;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @author : Horace Leoi
 * @since : 2024/3/7
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, SysUser> implements UserService {

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(PasswordEncoder passwordEncoder) {this.passwordEncoder = passwordEncoder;}

    @Override
    public SysUser loadUserByUsername(String username) {
        return query().eq("username", username).one();

    }

    @Override
    public SysUser doLogin(UserLoginDTO userLoginDTO) {
        SysUser sysUser = loadUserByUsername(userLoginDTO.getUsername());
        if (ObjectUtils.isEmpty(sysUser)) {
            throw new RuntimeException("用户数据不存在");
        }

        if (!passwordEncoder.match(userLoginDTO.getPassword(), sysUser.getPassword())) {
            throw new RuntimeException("用户名或密码错误");
        }

        return sysUser;
    }

}
