package com.gas.entity;

/**
 * ��ҳ�˵����
 * @author xinqi
 *
 */
public class Menu {
	
	//�˵��ı��
	private Integer mId;
	
	//�˵�������
	private String mName;
	
	//�˵������URL��ַ
	private String mUrl;
	
	//����ID
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
