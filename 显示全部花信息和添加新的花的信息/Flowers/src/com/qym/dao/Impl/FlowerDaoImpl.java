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
		//���ݷ��ʲ�ķ�������ʵ�֣�����mysql��ʾ���л�
		//�������Ӷ���
		 Connection conn=null;
		 PreparedStatement ps=null;
		 ResultSet rs=null;
		 
		List<Flowers> list=new ArrayList<>();
		Flowers flower=null;
		try {
			//������
			Class.forName("com.mysql.jdbc.Driver");
			//����mysql
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
		//�������Ļ���mysql
		
		try {
			//������
			Class.forName("com.mysql.jdbc.Driver");
			//����mysql
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/407","root","123456");
			String sql="select * from t_flower where uname=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, flower.getUname());
			rs=ps.executeQuery();
			System.out.println("��ѯ��һ���Ѿ���ɣ������������������"+rs);
			if(rs.next()){
			flower=null;
			System.out.println("�Ѿ��и��໨�����ʧ��"+flower);
			}else{
				sql="insert into t_flower (uname,price,production) values(?,?,?)";
				ps=conn.prepareStatement(sql);
				System.out.println("��ʼ�������");
				ps.setString(1, flower.getUname());
				ps.setDouble(2, flower.getPrice());
				ps.setString(3, flower.getProduction());
				ps.execute();
				System.out.println("����������");
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
