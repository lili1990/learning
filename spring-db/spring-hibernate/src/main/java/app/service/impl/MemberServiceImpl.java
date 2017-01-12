package app.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import app.dao.MemberDao;
import app.dao.MemberLoginDao;
import app.models.member.Member;
import app.service.MemberService;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Resource
	private MemberDao memberDao;
	@Resource
	private MemberLoginDao memberLoginDao;

	@Override
	public void save(Member member) {
		memberDao.saveMember(member);
		memberLoginDao.addLogin(member);
	}

}
