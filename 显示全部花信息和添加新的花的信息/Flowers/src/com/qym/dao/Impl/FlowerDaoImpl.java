package com.qym.dao.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qym.dao.FlowerDao;
import com.qym.pojo.Flowers;

public class FlowerDaoImpl implements FlowerDao{
	@Override
	public List<Flowers> seleAll() {
		//数据访问层的方法具体实现，访问mysql显示所有花
		//创建连接对象
		 Connection conn=null;
		 PreparedStatement ps=null;
		 ResultSet rs=null;
		 
		List<Flowers> list=new ArrayList<>();
		Flowers flower=null;
		try {
			//加载类
			Class.forName("com.mysql.jdbc.Driver");
			//连接mysql
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/407","root","123456");
			String sql="select * from t_flower";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
			flower=new Flowers(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4));
			list.add(flower);				
			}
			
					
		} catch (Exception e) {
				e.printStackTrace();;
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
		return list;
	}
	@Override
	public Flowers insertFlower(Flowers flower) {
		 Connection conn=null;
		 PreparedStatement ps=null;
		 ResultSet rs=null;
		//添加输入的花到mysql
		
		try {
			//加载类
			Class.forName("com.mysql.jdbc.Driver");
			//连接mysql
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/407","root","123456");
			String sql="select * from t_flower where uname=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, flower.getUname());
			rs=ps.executeQuery();
			System.out.println("查询这一步已经完成，接下来进行添加数据"+rs);
			if(rs.next()){
			flower=null;
			System.out.println("已经有该类花，添加失败"+flower);
			}else{
				sql="insert into t_flower (uname,price,production) values(?,?,?)";
				ps=conn.prepareStatement(sql);
				System.out.println("开始添加数据");
				ps.setString(1, flower.getUname());
				ps.setDouble(2, flower.getPrice());
				ps.setString(3, flower.getProduction());
				ps.execute();
				System.out.println("花种添加完成");
			}
			sql="select * from t_flower where uname=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, flower.getUname());
			rs=ps.executeQuery();
			while(rs.next()){
				flower=new Flowers(rs.getInt("num"), rs.getString("uname"), rs.getDouble("price"), rs.getString("production"));
			}
		}catch(Exception e){
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
		return flower;
	}
}
