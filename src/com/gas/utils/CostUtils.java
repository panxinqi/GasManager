package com.gas.utils;

/**
 * 用于定义标识
 * @author xinqi
 *
 */
public interface CostUtils {
	
	//用户标识符  1表示有效用户   0表示无效用户
	public String MARK_YES = "1";
	public String MARK_NO = "0";
	
	//用户缴费单的标识符
	/**
	 * 表示缴费成功
	 */
	public String PAY_MARK_YES = "1"; 
	/**
	 * 表示已经有缴费单但是还没有缴费
	 */
	public String PAY_MARK_NO = "0";    
	/**
	 * 表示缴费单还没有确认
	 */
	public String PAY_MARK_AUTO = "-1"; 
	
}
