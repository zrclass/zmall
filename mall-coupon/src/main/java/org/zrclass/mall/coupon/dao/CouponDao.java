package org.zrclass.mall.coupon.dao;

import org.zrclass.mall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author zhourui
 * @email 1312311306@qq.com
 * @date 2021-05-15 18:50:00
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
