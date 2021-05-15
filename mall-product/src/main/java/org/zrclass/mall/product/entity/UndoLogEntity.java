//package org.zrclass.mall.product.entity;
//
//import com.baomidou.mybatisplus.annotation.TableId;
//import com.baomidou.mybatisplus.annotation.TableName;
//
//import java.io.Serializable;
//import java.util.Date;
//import lombok.Data;
//
///**
// *
// *
// * @author zhourui
// * @email 1312311306@qq.com
// * @date 2021-05-15 14:58:28
// */
//@Data
//@TableName("undo_log")
//public class UndoLogEntity implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//	/**
//	 *
//	 */
//	@TableId
//	private Long id;
//	/**
//	 *
//	 */
//	private Long branchId;
//	/**
//	 *
//	 */
//	private String xid;
//	/**
//	 *
//	 */
//	private String context;
//	/**
//	 *
//	 */
//	private Longblob rollbackInfo;
//	/**
//	 *
//	 */
//	private Integer logStatus;
//	/**
//	 *
//	 */
//	private Date logCreated;
//	/**
//	 *
//	 */
//	private Date logModified;
//	/**
//	 *
//	 */
//	private String ext;
//
//}
