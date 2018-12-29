package app.service;

import app.models.Member;

import java.util.List;

public interface MemberService {
	
	public void save(Member m);

	public Member findById(Long memberId);

	public List<Member> fetchMembers(Integer page,Integer pageSize);

}
