package app.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import app.models.BaseModel;

@Entity
public class MemberLogin extends BaseModel {

	public String loginId;// 登陆id 用户名或邮箱
	public String password;// 登陆密码
	
	@ManyToOne
	 public Member member;
	@Enumerated(EnumType.STRING)
	public LoginType type;

	public enum LoginType {
		UserName, Email
	}

}
