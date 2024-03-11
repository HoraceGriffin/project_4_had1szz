package cn.had1szz.cyzy.controller;

import cn.had1szz.cyzy.domain.Category;
import cn.had1szz.cyzy.mapper.CategoryMapper;
import cn.had1szz.cyzy.response.Result;
import cn.had1szz.cyzy.dto.CategoryDTO;
import cn.had1szz.cyzy.service.CategoryService;
import cn.hutool.core.bean.BeanUtil;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : Horace Leoi
 * @since : 2024/3/11
 */
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping("/list")
    public Result<List<CategoryDTO>> listCategories() {
        List<CategoryDTO> categories = categoryService.listCategories();
        return Result.ok(categories);
    }

    @PostMapping
    public Result<?> createCategory(@RequestBody @Valid CategoryDTO categoryDTO) {
        List<CategoryDTO> children = categoryDTO.getChildren();
        boolean result = false;
        if (ObjectUtils.isEmpty(children)) {
            List<Category> collect = children.stream()
                    .map(el -> BeanUtil.copyProperties(el, Category.class)).collect(Collectors.toList());
            result = categoryService.saveBatch(collect);
        } else {
            Category category = BeanUtil.copyProperties(categoryDTO, Category.class);
            result = categoryService.save(category);
        }

        if (!result) {
            throw new RuntimeException("分类添加失败");
        }

        return Result.ok();
    }

}
