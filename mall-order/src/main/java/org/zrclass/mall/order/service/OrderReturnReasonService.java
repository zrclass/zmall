package org.zrclass.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.zrclass.common.utils.PageUtils;
import org.zrclass.mall.order.entity.OrderReturnReasonEntity;

import java.util.Map;

/**
 * ้่ดงๅๅ 
 *
 * @author zhourui
 * @email 1312311306@qq.com
 * @date 2021-05-15 19:06:06
 */
public interface OrderReturnReasonService extends IService<OrderReturnReasonEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

