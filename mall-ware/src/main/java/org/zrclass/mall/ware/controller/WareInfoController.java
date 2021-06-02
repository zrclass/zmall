package org.zrclass.mall.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.zrclass.mall.ware.entity.WareInfoEntity;
import org.zrclass.mall.ware.service.WareInfoService;
import org.zrclass.common.utils.PageUtils;
import org.zrclass.common.utils.R;
import org.zrclass.mall.ware.vo.FareVo;


/**
 * 仓库信息
 *
 * @author zhourui
 * @email 1312311306@qq.com
 * @date 2021-05-15 18:59:55
 */
@RestController
@RequestMapping("ware/wareinfo")
public class WareInfoController {
    @Autowired
    private WareInfoService wareInfoService;

    @GetMapping("/fare")
    public R getFare(@RequestParam("addrId") Long addrId){
        FareVo fare = wareInfoService.getFare(addrId);
        return R.ok().setData(fare);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = wareInfoService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WareInfoEntity wareInfo = wareInfoService.getById(id);

        return R.ok().put("wareInfo", wareInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WareInfoEntity wareInfo){
        wareInfoService.save(wareInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody WareInfoEntity wareInfo){
        wareInfoService.updateById(wareInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        wareInfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
