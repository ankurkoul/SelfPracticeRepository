package com.quiz.feesreportgenerator.domain;

public class Client {
	
	/**
	 * 
	 */
	private String clientId;
	
	private  String securityId;
	
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getSecurityId() {
		return securityId;
	}
	/**
	 * @param securityId
	 */
	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}
	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", securityId=" + securityId + "]";
	}

	
}
