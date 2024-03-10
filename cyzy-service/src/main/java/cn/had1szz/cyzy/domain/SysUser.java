package cn.had1szz.cyzy.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author : Horace Leoi
 * @since : 2024/3/7
 */
@Data
@TableName("tb_sys_user")
public class SysUser {
    @TableId(value = "uid", type = IdType.AUTO)
    private Integer uid;
    private String username;
    private String password;
}
