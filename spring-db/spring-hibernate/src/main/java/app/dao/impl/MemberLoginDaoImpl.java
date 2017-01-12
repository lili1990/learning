package app.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import app.dao.MemberLoginDao;
import app.models.Member;
import app.models.MemberLogin;
import app.models.MemberLogin.LoginType;

@Repository("memberLoginDao")
@SuppressWarnings({ "all" })
public class MemberLoginDaoImpl extends BaseDaoImpl implements MemberLoginDao {

	@Override
	public void addLogin(Member member) {
		addByUserName(member);
		addByEmail(member);
	}

	public void addByUserName(Member member) {
		if (StringUtils.isNotBlank(member.username)) {
			MemberLogin mLogin = findByLoginId(member.username);
			if (mLogin == null) {
				mLogin = new MemberLogin();
				mLogin.loginId = member.username;
				mLogin.password = member.password;
				mLogin.member = member;
				mLogin.type = LoginType.UserName;
				save(mLogin);
			}
		}
	}

	@Override
	public void addByEmail(Member member) {
		if (StringUtils.isNotBlank(member.email)) {
			MemberLogin mLogin = findByLoginId(member.email);
			if (mLogin == null) {
				mLogin = new MemberLogin();
				mLogin.loginId = member.email;
				mLogin.password = member.password;
				mLogin.member = member;
				mLogin.type = LoginType.Email;
				save(mLogin);
			}

		}
	}

	@Override
	public void editByEmail(Member member) {
		MemberLogin mLogin = findEmailByMember(member);
		if (mLogin == null) {
			addByEmail(member);
		} else {
			if (StringUtils.isNotBlank(member.email)) {
				mLogin.loginId = member.email;
				save(mLogin);
			} else {
				delete(mLogin);
			}
		}
	}

	@Override
	public void editPassword(Member member) {
		for (MemberLogin mLogin : fetchByMember(member)) {
			mLogin.password = member.password;
			save(mLogin);
		}
	}

	@Override
	public List<MemberLogin> fetchByMember(Member member) {
		return fetch(
				"select ml from MemberLogin ml where ml.isDeleted = false and ml.member = ?",
				member);
	}

	@Override
	public MemberLogin findEmailByMember(Member member) {
		return (MemberLogin) find(
				"select ml from MemberLogin ml where ml.isDeleted = false and ml.member = ?",
				member);
	}

	@Override
	public MemberLogin findByLoginId(String username) {
		return (MemberLogin) find(
				"select ml from MemberLogin ml where ml.isDeleted = false and ml.loginId = ?",
				username);
	}

	@Override
	public void deleteMemberLogin(MemberLogin mLogin) {
		mLogin.isDeleted = true;
		save(mLogin);
	}

	@Override
	public void deleteByMemeber(Member member) {
		for (MemberLogin mLogin : fetchByMember(member)) {
			delete(mLogin);
		}
	}

}
