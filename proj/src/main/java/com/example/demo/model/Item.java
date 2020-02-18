package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item 
{
	@Id
	private int itemNo;
	private int inventoryCode;
	private int amount;
	private String name;
	
	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public int getInventoryCode() {
		return inventoryCode;
	}
	public void setInventoryCode(int inventoryCode) {
		this.inventoryCode = inventoryCode;
	}

	
	public int getAmount(){ 
		return amount; 
	 } 
	 
	public void setAmount(int amount) {
		this.amount = amount;
	 }
	 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
