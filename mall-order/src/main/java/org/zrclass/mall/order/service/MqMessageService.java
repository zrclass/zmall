package org.zrclass.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.zrclass.common.utils.PageUtils;
import org.zrclass.mall.order.entity.MqMessageEntity;

import java.util.Map;

/**
 * 
 *
 * @author zhourui
 * @email 1312311306@qq.com
 * @date 2021-05-15 19:06:07
 */
public interface MqMessageService extends IService<MqMessageEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

