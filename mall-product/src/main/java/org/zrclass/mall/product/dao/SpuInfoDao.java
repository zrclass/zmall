package org.zrclass.mall.product.dao;

import org.apache.ibatis.annotations.Param;
import org.zrclass.mall.product.entity.SpuInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * spu信息
 * 
 * @author zhourui
 * @email 1312311306@qq.com
 * @date 2021-05-15 14:58:29
 */
@Mapper
public interface SpuInfoDao extends BaseMapper<SpuInfoEntity> {
    /**
     * 修改上架成功的商品的状态
     */
    void updateSpuStatus(@Param("spuId") Long spuId, @Param("code") int code);
	
}
