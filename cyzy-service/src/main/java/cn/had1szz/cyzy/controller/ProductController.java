package cn.had1szz.cyzy.controller;

import cn.had1szz.cyzy.domain.Product;
import cn.had1szz.cyzy.dto.ProductDTO;
import cn.had1szz.cyzy.response.Result;
import cn.had1szz.cyzy.service.ProductService;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author : Horace Leoi
 * @since : 2024/3/11
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final ThreadLocal<Long> threadLocal;

    public ProductController(ProductService productService, ThreadLocal<Long> threadLocal) {
        this.productService = productService;
        this.threadLocal = threadLocal;
    }

    @PostMapping
    public Result<?> createProduct(@RequestBody @Valid ProductDTO productDTO) {
        Product product = new Product();
        product.setUserId(threadLocal.get());
        BeanUtils.copyProperties(productDTO, product);

        boolean save = productService.save(product);

        if (!save) {
            throw new RuntimeException("商品保存失败");
        }

        return Result.ok(null);
    }

    @GetMapping("/list")
    public Result<Page<Product>> listProducts(Page<Product> page) {
        Page<Product> paged = productService.page(page);
        return Result.ok(paged);
    }

    @GetMapping("/{productId}")
    public Result<Product> readProduct(@PathVariable("productId") Long productId) {
        Product byId = productService.getById(productId);
        return Result.ok(byId);
    }

    @PutMapping
    public Result<ProductDTO> updateProduct(@RequestBody Product product) {
        boolean result = productService.updateById(product);
        if (!result) {
            throw new RuntimeException("商品更新失败");
        }

        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(product, productDTO);

        return Result.ok(productDTO);
    }

    @DeleteMapping("/{productId}")
    public Result<Product> deleteProduct(@PathVariable("productId") Long productId) {
        boolean result = productService.removeById(productId);

        if (!result) {
            throw new RuntimeException("商品删除失败");
        }

        return Result.ok(null);
    }

}
