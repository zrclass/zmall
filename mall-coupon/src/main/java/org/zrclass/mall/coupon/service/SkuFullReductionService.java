package org.zrclass.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.zrclass.common.to.SkuReductionTO;
import org.zrclass.common.utils.PageUtils;
import org.zrclass.mall.coupon.entity.SkuFullReductionEntity;

import java.util.Map;

/**
 * 商品满减信息
 *
 * @author zhourui
 * @email 1312311306@qq.com
 * @date 2021-05-15 18:49:58
 */
public interface SkuFullReductionService extends IService<SkuFullReductionEntity> {

    PageUtils queryPage(Map<String, Object> params);
    void saveSkuReduction(SkuReductionTO skuReductionTO);
}

