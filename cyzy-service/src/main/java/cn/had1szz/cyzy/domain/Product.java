package cn.had1szz.cyzy.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author : Horace Leoi
 * @since : 2024/3/11
 *         product_id     bigint primary key,
 *         name           varchar(255)      not null,
 *         category_id    int               not null,
 *         description    text,
 *         stock          int     default 0 not null,
 *         discount       int     default 0,
 *         price          bigint  default 0 not null,
 *         product_status tinyint default 0 not null,
 */
@Data
@TableName("tb_products")
public class Product {

    /** 商品ID */
    @TableId(value = "product_id", type = IdType.AUTO)
    @TableField(updateStrategy = FieldStrategy.NEVER)
    private Long productId;

    /**
     * 商品名称
     */
    @NotBlank(message = "商品名称不能为空")
    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY)
    private String name;

    /**
     * 上传者ID
     */
    @TableField(updateStrategy = FieldStrategy.NEVER)
    private Long userId;


    /**
     * 分类ID
     */
    @NotNull(message = "分类ID不能为空")
    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY)
    private Integer categoryId;

    /**
     * 商品描述
     */
    @NotNull(message = "商品描述不能为空")
    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY)
    private String description;

    /**
     * 商品库存
     */
    @Min(value = 0, message = "库存数量不能小于0")
    @NotNull(message = "库存数量不能为空")
    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY)
    private Integer stock;

    /**
     * 折扣
     */
    @Min(value = 0, message = "折扣不能小于0")
    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY)
    private Integer discount;

    /**
     * 商品价格
     */
    @Min(value = 0, message = "价格不能小于0")
    @NotNull(message = "商品价格不能为空")
    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY)
    private Long price;
    
    /**
     * 商品状态
     */
    private Integer productStatus;

}
