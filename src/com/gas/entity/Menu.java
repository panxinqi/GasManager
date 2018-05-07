package com.gas.entity;

/**
 * 首页菜单类别
 * @author xinqi
 *
 */
public class Menu {
	
	//菜单的编号
	private Integer mId;
	
	//菜单的名称
	private String mName;
	
	//菜单请求的URL地址
	private String mUrl;
	
	//父级ID
	private Integer superId;

	
	
	public Integer getmId() {
		return mId;
	}

	public void setmId(Integer mId) {
		this.mId = mId;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmUrl() {
		return mUrl;
	}

	public void setmUrl(String mUrl) {
		this.mUrl = mUrl;
	}

	public Integer getSuperId() {
		return superId;
	}

	public void setSuperId(Integer superId) {
		this.superId = superId;
	}

	public Menu(Integer mId, String mName, String mUrl, Integer superId) {
		super();
		this.mId = mId;
		this.mName = mName;
		this.mUrl = mUrl;
		this.superId = superId;
	}

	public Menu() {
		
	}
	
	
}
