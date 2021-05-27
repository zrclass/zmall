package org.zrclass.mall.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.zrclass.mall.product.entity.CategoryEntity;
import org.zrclass.mall.product.service.CategoryService;
import org.zrclass.common.utils.PageUtils;
import org.zrclass.common.utils.R;



/**
 * 商品三级分类
 *
 * @author zhourui
 * @email 1312311306@qq.com
 * @date 2021-05-15 14:58:30
 */
@RestController
@RequestMapping("product/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 列表
     */
    @RequestMapping("/list/tree")
    //@RequiresPermissions("product:category:list")
    public R list(){

        List<CategoryEntity> entities =categoryService.listWithTree();
        // 筛选出所有一级分类
        List<CategoryEntity> level1Menus = entities.stream().
                filter((categoryEntity) -> categoryEntity.getParentCid() == 0)
                .map((menu) -> {
                    menu.setChildren(getChildrens(menu, entities));
                    return menu;
                }).sorted((menu1, menu2) -> {
                    return (menu1.getSort() == null? 0 : menu1.getSort()) - (menu2.getSort() == null? 0 : menu2.getSort());
                })
                .collect(Collectors.toList());
        return R.ok().put("data", level1Menus);
    }

    /**
     * 递归找所有的子菜单、中途要排序
     */
    private List<CategoryEntity> getChildrens(CategoryEntity root, List<CategoryEntity> all){
        List<CategoryEntity> children = all.stream().filter(categoryEntity ->
                categoryEntity.getParentCid() == root.getCatId()
        ).map(categoryEntity -> {
            categoryEntity.setChildren(getChildrens(categoryEntity, all));
            return categoryEntity;
        }).sorted((menu1,menu2) -> {
            return (menu1.getSort() == null? 0 : menu1.getSort()) - (menu2.getSort() == null? 0 : menu2.getSort());
        }).collect(Collectors.toList());
        return children;
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    //@RequiresPermissions("product:category:info")
    public R info(@PathVariable("catId") Long catId){
		CategoryEntity category = categoryService.getById(catId);

        return R.ok().put("category", category);
    }
    /**
     * 批量修改层级
     */
    @RequestMapping("/update/sort")
    public R updateSort(@RequestBody CategoryEntity[] category){
        categoryService.updateBatchById(Arrays.asList(category));
        return R.ok();
    }
    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:category:save")
    public R save(@RequestBody CategoryEntity category){
		categoryService.save(category);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:category:update")
    public R update(@RequestBody CategoryEntity category){
		categoryService.updateById(category);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("${moduleNamez}:category:delete")
    public R delete(@RequestBody Long[] catIds){
		//categoryService.removeByIds(Arrays.asList(catIds));
        // 检查当前节点是否被别的地方引用
        categoryService.removeMenuByIds(Arrays.asList(catIds));

        return R.ok();
    }

}
