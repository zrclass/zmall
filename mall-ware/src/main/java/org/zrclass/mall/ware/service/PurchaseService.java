package org.zrclass.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.zrclass.common.utils.PageUtils;
import org.zrclass.mall.ware.entity.PurchaseEntity;
import org.zrclass.mall.ware.vo.MergeVo;
import org.zrclass.mall.ware.vo.PurchaseDoneVo;

import java.util.List;
import java.util.Map;

/**
 * 采购信息
 *
 * @author zhourui
 * @email 1312311306@qq.com
 * @date 2021-05-15 18:59:56
 */
public interface PurchaseService extends IService<PurchaseEntity> {
    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryPageUnreceivePurchase(Map<String, Object> params);

    void mergePurchase(MergeVo mergeVo);

    void received(List<Long> ids);

    void done(PurchaseDoneVo doneVo);
}


