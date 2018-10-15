package com.wx.books;
/**
 * 服务员类
 *
 */
public class Service {
	private String name;
	private String kind;
	public String getName() {
		return name;
	}
	public Service() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Service(String kind) {
		super();
		this.name = name;
		this.kind = kind;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	@Override
	public String toString() {
		return "Service [name=" + name + ", kind=" + kind + "]";
	}
	
	
}
