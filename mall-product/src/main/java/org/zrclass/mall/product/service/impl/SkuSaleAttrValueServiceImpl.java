package org.zrclass.mall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.zrclass.common.utils.PageUtils;
import org.zrclass.common.utils.Query;

import org.zrclass.mall.product.dao.SkuSaleAttrValueDao;
import org.zrclass.mall.product.entity.SkuSaleAttrValueEntity;
import org.zrclass.mall.product.service.SkuSaleAttrValueService;
import org.zrclass.mall.product.vo.ItemSaleAttrVo;


@Service("skuSaleAttrValueService")
public class SkuSaleAttrValueServiceImpl extends ServiceImpl<SkuSaleAttrValueDao, SkuSaleAttrValueEntity> implements SkuSaleAttrValueService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SkuSaleAttrValueEntity> page = this.page(
                new Query<SkuSaleAttrValueEntity>().getPage(params),
                new QueryWrapper<SkuSaleAttrValueEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<ItemSaleAttrVo> getSaleAttrsBuSpuId(Long spuId) {

        SkuSaleAttrValueDao dao = this.baseMapper;
        return dao.getSaleAttrsBuSpuId(spuId);
    }

    @Override
    public List<String> getSkuSaleAttrValuesAsStringList(Long skuId) {

        SkuSaleAttrValueDao dao = this.baseMapper;
        return dao.getSkuSaleAttrValuesAsStringList(skuId);
    }
}