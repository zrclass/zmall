package org.zrclass.mall.product.service.impl;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.zrclass.common.utils.PageUtils;
import org.zrclass.common.utils.Query;

import org.zrclass.mall.product.dao.CategoryDao;
import org.zrclass.mall.product.entity.CategoryEntity;
import org.zrclass.mall.product.service.CategoryService;


@Service("categoryService")
@Slf4j
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        List<CategoryEntity> categoryEntities = baseMapper.selectList(null);
        return categoryEntities;
    }

    private List<CategoryEntity> getTree(List<CategoryEntity> categoryEntities) {
        Set<Long> collect = categoryEntities.stream().map(e -> e.getCatId()).collect(Collectors.toSet());
        List<CategoryEntity> bodyList = Lists.newArrayList();
        List<CategoryEntity> rootList = Lists.newArrayList();
        categoryEntities.forEach(e->{
            if (collect.contains(e.getParentCid())){
                bodyList.add(e);
            }else{
                rootList.add(e);
            }
        });

        if (bodyList!=null && !bodyList.isEmpty()){
            rootList.forEach(rootCategory-> getChild(rootCategory,bodyList));
            return rootList;
        }
        return rootList;
    }


    private void  getChild(CategoryEntity rootCategory,List<CategoryEntity> bodyList){
        List<CategoryEntity> childList = Lists.newArrayList();
        bodyList.forEach(categoryEntity -> {
            if (categoryEntity.getParentCid().equals(rootCategory.getCatId())){
                //继续向下递归构建子树
                getChild(categoryEntity,bodyList);
                //把子树加入到chileList
                childList.add(categoryEntity);
            }
        });
        if (childList!=null&&childList.size()>0){
            rootCategory.setPatent(true);
            rootCategory.setChildren(childList);
        }

    }
}