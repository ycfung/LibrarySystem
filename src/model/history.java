package model;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

public class history extends RecursiveTreeObject<history>{
	private String id;
	private String barcode;
	private String name;
	private String category;
	private String price;
	private String address;
	private String bdate;
	private String rdate;
	private String state;
	public history(String[] s) {
		id = s[0];
		barcode = s[1];
		name = s[2];
		category = s[3];
		price = s[4];
		address = s[5];
		bdate = s[6];
		rdate = s[7];
		state = "hello";
	}
	public String getid () {
		return id;	
	}
	public String getbarcode () {
		return barcode;	
	}
	public String getname () {
		return name;	
	}
	public String getcategory () {
		return category;	
	}
	public String getprice () {
		return price;	
	}
	public String getaddress () {
		return address;	
	}
	public String getbdate () {
		return bdate;	
	}
	public String getrdate () {
		return rdate;	
	}
	public String getstate () {
		return state;	
	}
	public void setstate(String s) {
		state = s;
	}
}
