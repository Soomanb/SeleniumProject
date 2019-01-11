package com.training.bean;

public class UserBean {
	private String orderID;
	private String Customer;
	private String firstName;
	private String lastName;
	private String emailID;
	private String Phone;
	private String Product;
	private String Model;

	public UserBean() {
	}

	public UserBean(String orderID, String Customer, String firstName, String lastName, String emailID, String Phone, String Product, String Model) {
		super();
		this.orderID = orderID;
		this.Customer = Customer;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailID = emailID;
		this.Phone = Phone;
		this.Product = Product;
		this.Model = Model;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getCustomer() {
		return Customer;
	}

	public void setCustomer(String Customer) {
		this.Customer = Customer;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String Phone) {
		this.Phone = Phone;
	}

	public String getProduct() {
		return Product;
	}

	public void setProduct(String Product) {
		this.Product = Product;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String Model) {
		this.Model = Model;
	}

	@Override
	public String toString() {
	//	return "UserBean [orderID=" + orderID + ", Customer=" + Customer + ", firstName=" + firstName + ", lastName=" + lastName + ", emailID=" + emailID + ", phone=" + Phone + ", product=" + Product + ", model=" + Model+ "]";
		return orderID + Customer + firstName + lastName + emailID + Phone + Product + Model;  // concatenate the values of 1st row of the Userdata table
	}

}
