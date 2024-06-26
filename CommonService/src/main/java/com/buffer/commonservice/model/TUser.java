package com.buffer.commonservice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TUser {
    private String userId;
    private String firstName;
    private String lastName;
    private CardDetails cardDetails;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public CardDetails getCardDetails() {
		return cardDetails;
	}
	public void setCardDetails(CardDetails cardDetails) {
		this.cardDetails = cardDetails;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", cardDetails="
				+ cardDetails + "]";
	}
	public TUser(String userId, String firstName, String lastName, CardDetails cardDetails) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cardDetails = cardDetails;
	}
	public TUser() {
		super();
	}
	
}