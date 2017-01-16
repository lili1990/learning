package app.models;

import java.util.Date;

import javax.persistence.*;

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
	 @Version
	public long version;

	public long createTime =System.currentTimeMillis();

	public long lastModifyTime = System.currentTimeMillis();


	public void setId(Long id) {
		this.id = id;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean deleted) {
		isDeleted = deleted;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public long getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(long lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}
}
