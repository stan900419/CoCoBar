package dao;

import java.util.List;

import model.Member;

public interface MemberDao 
{
	//insert
	void insertMember(Member m);
	
	//read
	List<Member> selectAllMember();
	List<Member> selectByAccount(String account,String password);
	List<Member> selectByEmail(String email);
	List<Member> selectJustAccount(String account);
	List<Member> selectByMemberId(int id);
	
	//update
	void updateMember(Member m);
	void updatePassword(Member m);
	
	//delete
	void deleteMember(int id);

}
