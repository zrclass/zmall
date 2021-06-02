package org.zrclass.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.zrclass.common.utils.PageUtils;
import org.zrclass.mall.ware.entity.WareInfoEntity;
import org.zrclass.mall.ware.vo.FareVo;

import java.util.Map;

/**
 * 仓库信息
 *
 * @author zhourui
 * @email 1312311306@qq.com
 * @date 2021-05-15 18:59:55
 */
public interface WareInfoService extends IService<WareInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 根据收获地址计算运费
     */
    FareVo getFare(Long addrId);
}


