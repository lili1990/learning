package app.dao;

import app.models.Member;

public interface MemberDao {

	public void saveMember(Member m);

	Member getMember(Long id);

}
