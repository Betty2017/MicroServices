package com.microservice.limitservice.currencyconversionservice.bean;

import java.math.BigDecimal;

public class CurrencyConversion {
	
	private Long id;
	private String from;
	private String to;
	private BigDecimal converstionMultiple;
	private BigDecimal quantity;
	private BigDecimal totalAmount;
	private int port;
	
	
	protected CurrencyConversion() {
		
	}
	
	public CurrencyConversion(Long id, String from, String to, BigDecimal converstionMultiple, BigDecimal quantity,
			BigDecimal totalAmount, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.converstionMultiple = converstionMultiple;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
		this.port = port;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getConverstionMultiple() {
		return converstionMultiple;
	}
	public void setConverstionMultiple(BigDecimal converstionMultiple) {
		this.converstionMultiple = converstionMultiple;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	
	

}
