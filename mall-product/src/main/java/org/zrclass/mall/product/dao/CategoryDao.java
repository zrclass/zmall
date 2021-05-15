package org.zrclass.mall.product.dao;

import org.zrclass.mall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author zhourui
 * @email 1312311306@qq.com
 * @date 2021-05-15 14:58:30
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
