package cn.had1szz.cyzy.mapper;

import cn.had1szz.cyzy.domain.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : Horace Leoi
 * @since : 2024/3/7
 */
@Mapper
public interface UserMapper extends BaseMapper<SysUser> {
}
