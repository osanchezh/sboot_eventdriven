package com.buffer.commonservice.queries;

import java.util.Objects;

import lombok.Data;

@Data
public class GetUserPaymentDetailsQuery {
    private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public GetUserPaymentDetailsQuery(String userId) {
		super();
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "GetUserPaymentDetailsQuery [userId=" + userId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GetUserPaymentDetailsQuery other = (GetUserPaymentDetailsQuery) obj;
		return Objects.equals(userId, other.userId);
	}

	public GetUserPaymentDetailsQuery() {
		super();
	}    
	
}