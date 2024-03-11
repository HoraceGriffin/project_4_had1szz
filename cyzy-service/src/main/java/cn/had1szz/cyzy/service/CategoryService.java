package cn.had1szz.cyzy.service;

import cn.had1szz.cyzy.domain.Category;
import cn.had1szz.cyzy.dto.CategoryDTO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author : Horace Leoi
 * @since : 2024/3/11
 */
public interface CategoryService extends IService<Category> {
    List<CategoryDTO> listCategories();
}
