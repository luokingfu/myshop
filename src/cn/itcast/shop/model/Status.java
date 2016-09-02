package cn.itcast.shop.model;

import java.io.Serializable;

public class Status implements Serializable {

	private static final long serialVersionUID = 6191339913953487780L;

	private Integer id;

    private String status;
    
    public Status() {
		super();
	}

	public Status(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}