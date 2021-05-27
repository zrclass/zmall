package org.zrclass.mall.product.vo;

import lombok.Data;
import org.zrclass.mall.product.entity.SkuImagesEntity;
import org.zrclass.mall.product.entity.SkuInfoEntity;
import org.zrclass.mall.product.entity.SpuInfoDescEntity;

import java.util.List;

/**
 * <p>Title: SkuItemVo</p>
 * Description：
 * date：2020/6/24 13:33
 */
@Data
public class SkuItemVo {

	/**
	 * 基本信息
	 */
	SkuInfoEntity info;

	boolean hasStock = true;

	/**
	 * 图片信息
	 */
	List<SkuImagesEntity> images;

	/**
	 * 销售属性组合
	 */
	List<ItemSaleAttrVo> saleAttr;

	/**
	 * 介绍
	 */
	SpuInfoDescEntity desc;

	/**
	 * 参数规格信息
	 */
	List<SpuItemAttrGroup> groupAttrs;

	/**
	 * 秒杀信息
	 */
	SeckillInfoVo seckillInfoVo;
}
