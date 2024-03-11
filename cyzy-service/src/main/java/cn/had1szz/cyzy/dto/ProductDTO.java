package cn.had1szz.cyzy.dto;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author : Horace Leoi
 * @since : 2024/3/11
 */
@Data
public class ProductDTO {


    /**
     * 商品名称
     */
    @NotBlank(message = "商品名称不能为空")
    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY, insertStrategy = FieldStrategy.NOT_EMPTY)
    private String name;

    /**
     * 分类ID
     */
    @NotNull(message = "分类ID不能为空")
    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY, insertStrategy = FieldStrategy.NOT_EMPTY)
    private Integer categoryId;

    /**
     * 商品描述
     */
    @NotNull(message = "商品描述不能为空")
    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY, insertStrategy = FieldStrategy.NOT_EMPTY)
    private String description;

    /**
     * 商品库存
     */
    @Min(value = 0, message = "库存数量不能小于0")
    @NotNull(message = "库存数量不能为空")
    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY, insertStrategy = FieldStrategy.NOT_EMPTY)
    private Integer stock;

    /**
     * 折扣
     */
    @Min(value = 0, message = "折扣不能小于0")
    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY, insertStrategy = FieldStrategy.NOT_EMPTY)
    private Integer discount;

    /**
     * 商品价格
     */
    @Min(value = 0, message = "价格不能小于0")
    @NotNull(message = "商品价格不能为空")
    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY, insertStrategy = FieldStrategy.NOT_EMPTY)
    private Long price;

}
