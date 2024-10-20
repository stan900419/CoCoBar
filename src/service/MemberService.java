package service;


import java.util.List;

import model.Member;

public interface MemberService 
{
	void addMember(Member m);	
	Member Login(String account,String password);
	
	boolean findAccount(String account);
	boolean findEmail(String email);
	
	void setPassword(String account,String password);
	
	List<Member> showAllMember();
	List<Member> showMemberUseAccount(String account);
	
	void updateMember(Member m);
	
	void deleteMember(int id);
		
}
