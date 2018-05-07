package com.gas.utils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;


/**
 * ���ݿ�ٵĵĹ�����
 * 1.��ʼ��c3p0���ӳ�
 * 2.����dbUtils���Ĺ����� QueryRunner��
 * @author xinqi
 *
 */

	public class JDBCUtils {
		//����c3p0���ӳصĺ��Ĺ����࣬
		//�����Զ�����srcĿ¼�µ�c3p0�����ļ�(c3p0-config.xml)���Ʋ��ܱ�
		private static ComboPooledDataSource dataSource = null;
		static {
			dataSource = new ComboPooledDataSource();
		}
		
		/**
		 * ��ȡ���ݿ�����
		 * @return COnnection
		 * @throws SQLException 
		 */
		public static Connection getConnection() throws SQLException{
			return dataSource.getConnection();
		}
		
		/**
		 * ���ݿ�����ĺ�����
		 * @return QueryRunner
		 */
		public static QueryRunner getQueryRunner(){
			
			//����queryRunner���� ���Ҵ������ӳض���
			//���Զ�������Դ��ȡ���ӣ�����Ҫ�ֶ��رգ�
			return new QueryRunner(dataSource);
		}
		
		/**
		 * ͨ�õ���ɾ�ķ���
		 * @param sql  sql���
		 * @param obj  �������鴫�����������sql�еģ���Ӧһ��
		 * @return   boolean
		 * @throws SQLException 
		 */
		public static boolean audObject(String sql,Object[] arrs) throws SQLException{
			
			//��ȡ���ݿ��������
			QueryRunner qr = getQueryRunner();
			
			int i = qr.update(sql,arrs);
			
			if(i>0){
				return true;
			}else{
				return false;
			}
		}
}
