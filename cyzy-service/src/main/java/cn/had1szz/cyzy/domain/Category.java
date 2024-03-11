package cn.had1szz.cyzy.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author : Horace Leoi
 * @since : 2024/3/11
 */
@Data
@TableName("tb_categories")
public class Category {

    @TableId(value = "category_id", type = IdType.AUTO)
    private Integer categoryId;
    private String categoryName;
    private Integer parentId;

}
