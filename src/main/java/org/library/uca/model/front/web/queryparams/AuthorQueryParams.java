package org.library.uca.model.front.web.queryparams;

import java.io.Serializable;

public class AuthorQueryParams implements Serializable {

	private static final long serialVersionUID = 3572013661659348645L;
	
	private String fullname;
	private String idCard;
	private String email;
	
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
