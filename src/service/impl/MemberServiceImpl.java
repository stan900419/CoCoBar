package service.impl;

import java.util.List;

import dao.impl.MemberDaoImpl;
import model.Member;
import service.MemberService;

public class MemberServiceImpl implements MemberService
{

	public static void main(String[] args) {
		

	}
	
	MemberDaoImpl mdi=new MemberDaoImpl();

	@Override
	public void addMember(Member m) {
		mdi.insertMember(m);
	}

	
	
	@Override
	public Member Login(String account, String password) {
		List<Member> l=mdi.selectByAccount(account, password);
		Member m=null;
		if(l.size()!=0) 
		{
			m=l.get(0);
		}
				
		return m;
	}

	@Override
	public boolean findAccount(String account) {
		List<Member> l=mdi.selectJustAccount(account);
		boolean x=false;
		if(l.size()!=0)
		{
			x=true;
		}
		return x;
	}

	@Override
	public boolean findEmail(String email) {
		List<Member> l=mdi.selectByEmail(email);
		boolean x=false;
		if(l.size()!=0)
		{
			x=true;
		}
		return x;
	}



	@Override
	public void setPassword(String account,String password) {
		List<Member> l=new MemberDaoImpl().selectJustAccount(account);
		Member m=l.get(0);
		m.setPassword(password);
		m.setId(m.getId());
		new MemberDaoImpl().updatePassword(m);
		
	}



	@Override
	public List<Member> showAllMember() {
		
		return mdi.selectAllMember();
	}



	@Override
	public List<Member> showMemberUseAccount(String account) {
		List<Member> l=mdi.selectJustAccount(account);
		return l;
	}



	@Override
	public void updateMember(Member m) {
		mdi.updateMember(m);
//		List<Member> l=mdi.selectJustAccount(account);
//		Member m=l.get(0);
//		m.setName(name);
//		m.setAccount(account);
//		m.setPassword(password);
//		m.setEmail(email);
//		m.setId(m.getId());
//		mdi.updateMember(m);
	}



	@Override
	public void deleteMember(int id) {
		mdi.deleteMember(id);
		
	}
	
}
