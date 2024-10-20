package dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.DbConnection;
import dao.MemberDao;
import model.Member;

public class MemberDaoImpl implements MemberDao
{

	public static void main(String[] args) {
//		new MemberDaoImpl().insertMember(new Member("Bow","sunny","0210","sunny@gmail.com"));
		
//		List<Member> l=new MemberDaoImpl().selectAllMember();
//		for(Member u:l)
//		{
//			System.out.println(u.getId()+"\t"+u.getName());
//		}
//		List<Member> l=new MemberDaoImpl().selectByAccount("stan419", "0419");
//		for(Member u:l)
//			{
//				System.out.println(u.getId()+"\t"+u.getName());
//			}
		
		
		/*List<Member> l=new MemberDaoImpl().selectByMemberId(1);
		Member m=l.get(0);
		m.setName("Stanley");
		m.setAccount("stan419");
		m.setPassword("0419");
		m.setEmail("stan@gamil.com");
		new MemberDaoImpl().updateMember(m);*/
		
//		List<Member> l=new MemberDaoImpl().selectJustAccount("coco");
//		Member m=l.get(0);
//		m.setPassword("441199");
//		m.setId(m.getId());
//		
//		new MemberDaoImpl().updatePassword(m);
		List<Member> l=new MemberDaoImpl().selectAllMember();
		for(Member u:l)
		{
			System.out.println(u.getName());
		}
		

	}

	Connection conn=DbConnection.getDb();
	
	@Override
	public void insertMember(Member m) {		
		String sql="insert into member(name,account,password,email)values(?,?,?,?)";
		
		try {			
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps.setString(1, m.getName());
			ps.setString(2, m.getAccount());
			ps.setString(3, m.getPassword());
			ps.setString(4, m.getEmail());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<Member> selectAllMember() {
		String sql="select * from member";
		List<Member> l=new ArrayList<>();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				Member m=new Member();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setAccount(rs.getString("account"));
				m.setPassword(rs.getString("password"));
				m.setEmail(rs.getString("email"));
				
				l.add(m);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Member> selectByMemberId(int id) {
		String sql="select * from member where id=?";
		List<Member> l=new ArrayList<>();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Member m=new Member();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setAccount(rs.getString("account"));
				m.setPassword(rs.getString("password"));
				m.setEmail(rs.getString("email"));
				
				l.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public void updateMember(Member m) {
		String sql="update member set name=?,account=?,password=?,email=? where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, m.getName());
			ps.setString(2, m.getAccount());
			ps.setString(3, m.getPassword());
			ps.setString(4, m.getEmail());
			ps.setInt(5, m.getId());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public void deleteMember(int id) {
		String sql="delete from cocobar.member where id=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Member> selectByAccount(String account, String password) {
		String sql="select * from member where account=? and password=?";
		List<Member> l=new ArrayList<>();
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, account);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Member m=new Member();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setAccount(rs.getString("account"));
				m.setPassword(rs.getString("password"));
				m.setEmail(rs.getString("email"));
				
				l.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public List<Member> selectByEmail(String email) 
	{
		String sql="select * from member where email=?";
		List<Member> l=new ArrayList<>();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,email);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Member m=new Member();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setAccount(rs.getString("account"));
				m.setPassword(rs.getString("password"));
				m.setEmail(rs.getString("email"));
				
				l.add(m);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
		return l;
	}

	@Override
	public List<Member> selectJustAccount(String account) 
	{
		String sql="select * from member where account=?";
		List<Member> l=new ArrayList<>();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,account);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Member m=new Member();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setAccount(rs.getString("account"));
				m.setPassword(rs.getString("password"));
				m.setEmail(rs.getString("email"));
				
				l.add(m);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
		return l;
	}

	@Override
	public void updatePassword(Member m) {
		String sql="update member set password=? where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps.setString(1, m.getPassword());
			ps.setInt(2, m.getId());
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
