package cn.had1szz.cyzy.service.impl;

import cn.had1szz.cyzy.domain.Category;
import cn.had1szz.cyzy.mapper.CategoryMapper;
import cn.had1szz.cyzy.service.CategoryService;
import cn.had1szz.cyzy.dto.CategoryDTO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Horace Leoi
 * @since : 2024/3/11
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
        implements CategoryService {

    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryMapper categoryMapper) {this.categoryMapper = categoryMapper;}

    @Override
    public List<CategoryDTO> listCategories() {
        return categoryMapper.listCategories();
    }
}
