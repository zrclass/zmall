package org.zrclass.mall.product.dao;

import org.apache.ibatis.annotations.Param;
import org.zrclass.mall.product.entity.SkuSaleAttrValueEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.zrclass.mall.product.vo.ItemSaleAttrVo;

import java.util.List;

/**
 * sku销售属性&值
 * 
 * @author zhourui
 * @email 1312311306@qq.com
 * @date 2021-05-15 14:58:28
 */
@Mapper
public interface SkuSaleAttrValueDao extends BaseMapper<SkuSaleAttrValueEntity> {
    List<ItemSaleAttrVo> getSaleAttrsBuSpuId(@Param("spuId") Long spuId);

    List<String> getSkuSaleAttrValuesAsStringList(@Param("skuId") Long skuId);
}
