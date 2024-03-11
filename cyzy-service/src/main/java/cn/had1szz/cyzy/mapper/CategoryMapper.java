package cn.had1szz.cyzy.mapper;

import cn.had1szz.cyzy.domain.Category;
import cn.had1szz.cyzy.dto.CategoryDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author : Horace Leoi
 * @since : 2024/3/11
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

    List<CategoryDTO> listCategories();

}
