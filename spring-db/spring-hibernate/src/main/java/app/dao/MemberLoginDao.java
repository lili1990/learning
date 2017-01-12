package app.dao;

import java.util.List;


import app.models.Member;
import app.models.MemberLogin;

public interface MemberLoginDao {
	
	public  void addLogin(Member member);
    public  void addByEmail(Member member) ;
    public void addByUserName(Member member);
    public  void editByEmail(Member member);
    public  void editPassword(Member member);
    public  List<MemberLogin> fetchByMember(Member member) ;
    public MemberLogin findEmailByMember(Member member);
    public  MemberLogin findByLoginId(String username) ;
    public void deleteMemberLogin(MemberLogin mLogin);
    public void deleteByMemeber(Member member) ;


}
