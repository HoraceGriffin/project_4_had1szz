package cn.had1szz.cyzy.service.impl;

import cn.had1szz.cyzy.domain.Product;
import cn.had1szz.cyzy.mapper.ProductMapper;
import cn.had1szz.cyzy.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author : Horace Leoi
 * @since : 2024/3/11
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>
        implements ProductService {

}
