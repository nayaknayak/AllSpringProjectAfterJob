package com.dtx.mail.services;

public interface IPurchaseOrder {
	
	public String purchase(String [] items,double[] price, String []emails) throws Exception;

}
