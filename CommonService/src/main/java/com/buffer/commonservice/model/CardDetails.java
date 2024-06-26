package com.buffer.commonservice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CardDetails {
    private String name;
    private String cardNumber;
    private Integer validUntilMonth;
    private Integer validUntilYear;
    private Integer cvv;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Integer getValidUntilMonth() {
		return validUntilMonth;
	}
	public void setValidUntilMonth(Integer validUntilMonth) {
		this.validUntilMonth = validUntilMonth;
	}
	public Integer getValidUntilYear() {
		return validUntilYear;
	}
	public void setValidUntilYear(Integer validUntilYear) {
		this.validUntilYear = validUntilYear;
	}
	public Integer getCvv() {
		return cvv;
	}
	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}
	@Override
	public String toString() {
		return "CardDetails [name=" + name + ", cardNumber=" + cardNumber + ", validUntilMonth=" + validUntilMonth
				+ ", validUntilYear=" + validUntilYear + ", cvv=" + cvv + "]";
	}
	public CardDetails(String name, String cardNumber, Integer validUntilMonth, Integer validUntilYear, Integer cvv) {
		super();
		this.name = name;
		this.cardNumber = cardNumber;
		this.validUntilMonth = validUntilMonth;
		this.validUntilYear = validUntilYear;
		this.cvv = cvv;
	}
	public CardDetails() {
		super();
	}
	
}