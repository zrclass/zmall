package org.zrclass.mall.product.vo;

import lombok.Data;
import org.zrclass.mall.product.entity.AttrEntity;

import java.util.List;

/**
 * <p>Title: AttrGroupWithAttrsVo</p>
 * Description：
 * date：2020/6/5 11:46
 */
@Data
public class AttrGroupWithAttrsVo {

    /**
     * 分组id
     */
    private Long attrGroupId;
    /**
     * 组名
     */
    private String attrGroupName;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 描述
     */
    private String descript;
    /**
     * 组图标
     */
    private String icon;
    /**
     * 所属分类id
     */
    private Long catelogId;

	/**
	 * 保存整个实体信息
	 */
	private List<AttrEntity> attrs;
}
