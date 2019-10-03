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
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接对象
			conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/407","root","123456");
			//创建sql命令
			String sql="select * from t_user where uname=? and pwd=?";
			//创建sql命令对象
			ps=(PreparedStatement) conn.prepareStatement(sql);
			
			//给占位符赋值
			ps.setString(1,uname);
			ps.setString(2,pwd);
			//执行
			rs=ps.executeQuery();
			//System.out.println(rs.next());
			//遍历执行结果
			while(rs.next()){
				u=new User();
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setPwd(rs.getString("pwd"));
			}
			//关闭资源
			//返回	

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
