package com.lw.bootdemo.pojo.db;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @author langwei
 * @date 2019-01-14 09:14:17
 */
@Data
public class Answer implements Serializable {

	/**
	 * 接单人ID
	 */
	private Integer id;
	/**
	 * 接单人账号(门店编号)
	 */
	private String account;
	/**
	 * 接单人密码
	 */
	private String password;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 手机号
	 */
	private String phoneNumber;
	/**
	 * 状态(A 可用 S 不可用)
	 */
	private String status;
	/**
	 * 所属组织类型( P 预售部 ，S 普通门店)
	 */
	private String ownerType;
	/**
	 * 所属的组织(预售部或者门店)ID
	 */
	private Integer ownerDepId;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 最后更新时间
	 */
	private Date lastUpdate;
	/**
	 * 门店账号类型（S为子账号，M主账号）
	 */
	private String answerType;

}
