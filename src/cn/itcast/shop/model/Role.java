package cn.itcast.shop.model;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.GrantedAuthority;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */

public class Role implements GrantedAuthority,ConfigAttribute,java.io.Serializable {

	private static final long serialVersionUID = 970188058466345702L;

	private Integer id;
	private String name;
	private String detail;
	
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return name;
	}
	
	@Override
	public String getAttribute() {
		// TODO Auto-generated method stub
		return name;
	}

	
	
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", detail=" + detail + "]";
	}

	/** default constructor */
	public Role() {
	}

	/** full constructor */
	public Role(String name, String detail) {
		this.name = name;
		this.detail = detail;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}