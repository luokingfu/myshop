package cn.itcast.shop.model;

/**
 * Url entity. @author MyEclipse Persistence Tools
 */

public class Url implements java.io.Serializable {

	private static final long serialVersionUID = 5401776652896559058L;

	private Integer id;
	private String address;
	private Permission permission;
	
	public Url() {
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

}