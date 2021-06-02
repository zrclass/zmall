package org.zrclass.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.zrclass.common.to.es.SkuHasStockVo;
import org.zrclass.common.to.mq.OrderTo;
import org.zrclass.common.to.mq.StockLockedTo;
import org.zrclass.common.utils.PageUtils;
import org.zrclass.mall.ware.entity.WareSkuEntity;
import org.zrclass.mall.ware.vo.WareSkuLockVo;

import java.util.List;
import java.util.Map;

/**
 * 商品库存
 *
 * @author zhourui
 * @email 1312311306@qq.com
 * @date 2021-05-15 18:59:56
 */
public interface WareSkuService extends IService<WareSkuEntity> {

    void unlockStock(StockLockedTo to);

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存库存的时候顺便查到商品价格
     */
    double addStock(Long skuId, Long wareId, Integer skuNum);

    /**
     * 查询是否有库存
     */
    List<SkuHasStockVo> getSkuHasStock(List<Long> skuIds);

    /**
     * 为某个订单锁定库存
     */
    Boolean orderLockStock(WareSkuLockVo vo);

    /**
     * 由于订单超时而自动释放订单之后来解锁库存
     */
    void unlockStock(OrderTo to);
}

