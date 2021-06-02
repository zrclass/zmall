package org.zrclass.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.zrclass.common.utils.PageUtils;
import org.zrclass.mall.product.entity.SkuSaleAttrValueEntity;
import org.zrclass.mall.product.vo.ItemSaleAttrVo;

import java.util.List;
import java.util.Map;

/**
 * sku销售属性&值
 *
 * @author zhourui
 * @email 1312311306@qq.com
 * @date 2021-05-15 14:58:28
 */
public interface SkuSaleAttrValueService extends IService<SkuSaleAttrValueEntity> {
    PageUtils queryPage(Map<String, Object> params);

    List<ItemSaleAttrVo> getSaleAttrsBuSpuId(Long spuId);

    List<String> getSkuSaleAttrValuesAsStringList(Long skuId);
}

