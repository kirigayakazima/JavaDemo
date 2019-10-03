package com.bjsxt.dao.Impl;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bjsxt.dao.RegisterDao;
import com.bjsxt.pojo.User;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class RegisterDaoImpl implements RegisterDao{
	@Override
	public User checkregisterdao(String rname, String rpwd) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		User u=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/407","root","123456");
			String sql="select * from t_user where uname=?";
			ps=(PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, rname);
			rs=ps.executeQuery();
			if(rs.next()){
			u=null;	
			}else{
				sql="insert into t_user (uname,pwd) values(?,?)";
				ps=(PreparedStatement) conn.prepareStatement(sql);
				ps.setString(1, rname);
				ps.setString(2, rpwd);
				ps.execute();
				
				System.out.println("�˺Ŵ������");
			}
			sql="select * from t_user where uname=? and pwd=?";
			//����sql�������
			ps=(PreparedStatement) conn.prepareStatement(sql);
			
			//��ռλ����ֵ
			ps.setString(1,rname);
			ps.setString(2,rpwd);
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
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
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
