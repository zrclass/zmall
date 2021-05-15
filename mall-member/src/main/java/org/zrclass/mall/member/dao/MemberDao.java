package org.zrclass.mall.member.dao;

import org.zrclass.mall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author zhourui
 * @email 1312311306@qq.com
 * @date 2021-05-15 18:10:34
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
