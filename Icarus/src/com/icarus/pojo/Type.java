package com.icarus.pojo;

import java.io.Serializable;

public class Type extends PersistentPojo implements Serializable {
	
	private long typeId;
	private String title;
	public long getTypeId() {
		return typeId;
	}
	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Type [typeId=" + typeId + ", title=" + title + "]";
	}

}
