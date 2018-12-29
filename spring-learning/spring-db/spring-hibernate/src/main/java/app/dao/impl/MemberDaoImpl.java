package app.dao.impl;

import org.springframework.stereotype.Repository;

import app.dao.MemberDao;
import app.models.Member;

@Repository("memberDao")
@SuppressWarnings("all")
public class MemberDaoImpl extends BaseDaoImpl implements MemberDao {

	@Override
	public void saveMember(Member m) {
		save(m);
	}

	@Override
	public Member getMember(Long id) {
		return (Member) find(Member.class, id);
	}

}
