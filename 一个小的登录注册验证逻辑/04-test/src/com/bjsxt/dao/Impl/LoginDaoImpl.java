package com.bjsxt.dao.Impl;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bjsxt.dao.LoginDao;
import com.bjsxt.pojo.User;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


public class LoginDaoImpl implements LoginDao{
	@Override
	public User checklogindao(String uname, String pwd) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null; 
		User u=null;
		try {
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			//��ȡ���Ӷ���
			conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/407","root","123456");
			//����sql����
			String sql="select * from t_user where uname=? and pwd=?";
			//����sql�������
			ps=(PreparedStatement) conn.prepareStatement(sql);
			
			//��ռλ����ֵ
			ps.setString(1,uname);
			ps.setString(2,pwd);
			//ִ��
			rs=ps.executeQuery();
			//System.out.println(rs.next());
			//����ִ�н��
			while(rs.next()){
				u=new User();
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setPwd(rs.getString("pwd"));
			}
			//�ر���Դ
			//����	

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}try {
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return u;
	}
}
