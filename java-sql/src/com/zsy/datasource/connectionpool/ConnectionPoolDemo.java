package com.zsy.datasource.connectionpool;

import com.zsy.datasource.utils.JdbcUtil;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * ģ�����ݿ����ӳ�
 */
public class ConnectionPoolDemo {

	//׼��һ����������Ϊ�����������
	private static List<Connection> pool = new ArrayList<Connection>();

	//ʹ�þ�̬����飬���ؼ�������
	static{
		try {
			for(int i=0;i<10;i++){
				Connection conn = JdbcUtil.getConnection();
				pool.add(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//�Ժ��ٻ�ȡ���ӵ�ʱ�򣬱���ʹ���������
	public synchronized static Connection getConnection(){//�����ӵķ������뱣֤��ͬ����
		if(pool.size()>0){
			return pool.remove(0);//�Ƚ��ȳ�
		}else{
			throw new RuntimeException("��������æ��");
		}
	}

	//���س��У���ʵ����׷�ӵ����ӳؼ��ϵ�ĩβ
	public static void release(Connection conn){
		pool.add(conn);
	}

}
