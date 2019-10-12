package com.bjsxt.dao.Impl;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bjsxt.dao.UserDao;
import com.bjsxt.vo.User;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class UserDaoImpl implements UserDao {

	@Override
	public User getUserInfo(String name) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		User u=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//连接数据库
			conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/407","root","123456");
			//创建sql语句，进行查找
			String sql="select * from t_img where name=?";
			ps=(PreparedStatement) conn.prepareStatement(sql);
			if ("".equals(name)) {
				name="Ami";
			}
			ps.setString(1, name);
			rs=ps.executeQuery();
			while(rs.next()){
				u=new User();
				u.setUid(rs.getInt("uid"));
				u.setName(rs.getString("name"));
				u.setPower(rs.getDouble("power"));
				u.setMoney(rs.getDouble("money"));
				u.setLoca(rs.getString("loca"));
				u.setDec(rs.getString("dec"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return u;
	}

}
