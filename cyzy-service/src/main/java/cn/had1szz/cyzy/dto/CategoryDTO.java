package cn.had1szz.cyzy.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author : Horace Leoi
 * @since : 2024/3/11
 */
@Data
@JsonPropertyOrder({"categoryId", "categoryName", "parentId", "children"})
public class CategoryDTO {

    @NotNull
    private Integer categoryId;
    @NotBlank
    private String categoryName;
    private List<CategoryDTO> children;
    private Integer parentId;

}
