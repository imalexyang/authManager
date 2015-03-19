package com.platform.shiro.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Observable;

/**
 * author yanqiang
 */
@SuppressWarnings("serial")
public class BaseEntity extends Observable implements Serializable {
	/**
	 * fdid
	 */
	private String fdid;
	/**
	 * 创建时间
	 */
	private Date createtime;
	/**
	 * 创建�?
	 */
	private String creator;
	private String creatorid;
	private String hasvalid = "1";
	private Date updatetime;
	private String updator;
	private String updatorid;

	public String getFdid() {
		return fdid;
	}

	public void setFdid(String fdid) {
		this.fdid = fdid;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCreatorid() {
		return creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}

	public String getHasvalid() {
		return hasvalid;
	}

	public void setHasvalid(String hasvalid) {
		this.hasvalid = hasvalid;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public String getUpdator() {
		return updator;
	}

	public void setUpdator(String updator) {
		this.updator = updator;
	}

	public String getUpdatorid() {
		return updatorid;
	}

	public void setUpdatorid(String updatorid) {
		this.updatorid = updatorid;
	}

}
