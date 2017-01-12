package app.service;



import app.models.Member;
import app.models.MemberLogin;



public interface MemberLoginService {
	
	public MemberLogin findByLoginId(String loginId);
	
	public void addLogin(Member m);
	









}
