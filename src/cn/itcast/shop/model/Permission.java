package cn.itcast.shop.model;

import java.util.Set;

import org.springframework.security.access.ConfigAttribute;

/**
 * Permission entity. @author MyEclipse Persistence Tools
 */

public class Permission implements java.io.Serializable {

	private static final long serialVersionUID = -7209742155618625292L;
	private Integer id;
	private String name;
	private Set<ConfigAttribute> roleSet;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<ConfigAttribute> getRoleSet() {
		return roleSet;
	}

	public void setRoleSet(Set<ConfigAttribute> roleSet) {
		this.roleSet = roleSet;
	}

	/** default constructor */
	public Permission() {
	}

	/** full constructor */
	public Permission(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}