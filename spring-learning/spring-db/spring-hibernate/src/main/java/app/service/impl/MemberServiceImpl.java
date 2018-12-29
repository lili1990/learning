package app.service.impl;

import javax.annotation.Resource;

import app.dao.BaseDao;
import app.dao.Dao;
import org.springframework.stereotype.Service;

import app.dao.MemberDao;
import app.models.Member;
import app.service.MemberService;

import java.util.List;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Resource
	private MemberDao memberDao;

	@Resource
	private Dao dao;


	@Override
	public void save(Member member) {
		dao.save(member);
	}

	public Member findById(Long memberId){
		return (Member) dao.get(Member.class, memberId);
	}

	public List<Member> fetchMembers(Integer page, Integer pageSize){
		return dao.find("select * from member ",(Object[])null,page,pageSize);
	}

}
