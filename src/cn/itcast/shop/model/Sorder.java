package cn.itcast.shop.model;

import java.io.Serializable;
import java.math.BigDecimal;


public class Sorder implements Serializable {

	private static final long serialVersionUID = -721312536435989443L;

	private Integer id;

    private String name;

    private BigDecimal price;

    private Integer number;

    private Product product;
    
    private Forder forder;
    
	public Forder getForder() {
		return forder;
	}

	public void setForder(Forder forder) {
		this.forder = forder;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
    
    

}