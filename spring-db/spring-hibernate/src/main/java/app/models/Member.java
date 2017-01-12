package app.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import app.models.BaseModel;

@Entity
public class Member extends BaseModel {

    public String username;
    public String password;

    public String email;
    public String fullName; //

    public String avatarUrl; // 头像路径 add
    public String profileName; // 个人主页 url
    public String phone; // 手机号码
    public String validatePhone; // 在论坛首次发帖时用于验证的手机号码
    public Boolean isValidateInBBS; // 在论坛是否发帖验证过

    public String fullNamePinyin; // 拼音
    public String fullNameShoupin; // 汉字首拼

    public String lastLoginIp; // 最后登录ip地址

    public String intro;
    public Long loginCount = 0l; // 登录次数
    public Long bbsItemCount = 0L; // 发帖数

    public Long uploads = 0L; // 上传文件字节总大小

    public String quickSend;

    @Temporal(TemporalType.TIMESTAMP)
    public Date lastLoginTime = new Date();

    @Enumerated(EnumType.STRING)
    public Sex sex = Sex.NoPoint;
    @Temporal(TemporalType.TIMESTAMP)
    public Date birthday;

    public String weiboUrl;

    public String sendEmails; // 要发送的邮箱，存放String 用" "进行分隔

    public enum Sex {
	NoPoint {
	    @Override
	    public String getName() {
		return "";
	    }
	},
	Female {
	    @Override
	    public String getName() {
		return "女";
	    }
	},
	Male {

	    @Override
	    public String getName() {
		return "男";
	    }

	};

	public abstract String getName();

	public static Sex convertToEnum(String sex) {
	    if ("男".equals(sex)) {
		return Male;
	    } else if ("女".equals(sex)) {
		return Female;
	    } else {
		return NoPoint;
	    }
	}
    }

}
