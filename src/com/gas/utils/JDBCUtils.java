package com.gas.utils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;


/**
 * 数据库操的的工具类
 * 1.初始化c3p0连接池
 * 2.创建dbUtils核心工具类 QueryRunner类
 * @author xinqi
 *
 */

	public class JDBCUtils {
		//创建c3p0连接池的核心工具类，
		//他会自动加载src目录下的c3p0配置文件(c3p0-config.xml)名称不能变
		private static ComboPooledDataSource dataSource = null;
		static {
			dataSource = new ComboPooledDataSource();
		}
		
		/**
		 * 获取数据库连接
		 * @return COnnection
		 * @throws SQLException 
		 */
		public static Connection getConnection() throws SQLException{
			return dataSource.getConnection();
		}
		
		/**
		 * 数据库操作的核心类
		 * @return QueryRunner
		 */
		public static QueryRunner getQueryRunner(){
			
			//创建queryRunner对象 并且传入连接池对象
			//会自动从数据源获取链接（不需要手动关闭）
			return new QueryRunner(dataSource);
		}
		
		/**
		 * 通用的增删改方法
		 * @param sql  sql语句
		 * @param obj  对象数组传入的是条件与sql中的？对应一致
		 * @return   boolean
		 * @throws SQLException 
		 */
		public static boolean audObject(String sql,Object[] arrs) throws SQLException{
			
			//获取数据库操作对象
			QueryRunner qr = getQueryRunner();
			
			int i = qr.update(sql,arrs);
			
			if(i>0){
				return true;
			}else{
				return false;
			}
		}
}
