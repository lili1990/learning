package app.models;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import app.listeners.BaseModelListener;

@MappedSuperclass
@EntityListeners(BaseModelListener.class)
@Access(AccessType.FIELD)
public class BaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	public Long getId() {
		return id;
	}

	public boolean isDeleted = false;// 标记是否删除
	// @Version
	// public long version;
	/*
	 * 格式化日期 TemporalType.DATE 2014-10-31 TemporalType.TIME 22:20:00
	 * TemporalType.TIMESTAMP 2014-10-31 22:20:00
	 */
	@Temporal(TemporalType.TIMESTAMP)
	public Date createTime = new Date();
	@Temporal(TemporalType.TIMESTAMP)
	public Date lastModifyTime = new Date();

}
