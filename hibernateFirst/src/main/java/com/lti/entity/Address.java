package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TBL_ADDR")
public class Address {
	
	@Id
	@Column(name="ADDR_ID")
	int addrId;
	
	@Column(name="ADDR_LINE")
	String addrLine;
	
	@OneToOne(mappedBy = "address")
	@JoinColumn(name="USER_ID")
	User user;

	public int getAddrId() {
		return addrId;
	}

	public void setAddrId(int addrId) {
		this.addrId = addrId;
	}

	public String getAddrLine() {
		return addrLine;
	}

	public void setAddrLine(String addrLine) {
		this.addrLine = addrLine;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
