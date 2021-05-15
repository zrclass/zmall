package org.zrclass.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.zrclass.common.utils.PageUtils;
import org.zrclass.mall.product.entity.ProductAttrValueEntity;

import java.util.Map;

/**
 * spu属性值
 *
 * @author zhourui
 * @email 1312311306@qq.com
 * @date 2021-05-15 14:58:29
 */
public interface ProductAttrValueService extends IService<ProductAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

