package com.bridegelabz.addressbookcsv;
import com.opencsv.bean.CsvBindByName;
public class ContactsCsv {
	@CsvBindByName
	public String firstLastName;
	@CsvBindByName
	public String address;
	@CsvBindByName
	public String city;
	@CsvBindByName
	public String state;
	@CsvBindByName
	public long zip;
	@CsvBindByName
	public long phoneNum;
	@CsvBindByName
	public String email;
	public String getFirstLastName() {
		return firstLastName;
	}
	public String getAddress() {
		return address;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public long getZip() {
		return zip;
	}
	public long getPhoneNum() {
		return phoneNum;
	}
	public String getEmail() {
		return email;
	}
	public void setFirstLastName(String firstLastName) {
		this.firstLastName = firstLastName;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setZip(long zip) {
		this.zip = zip;
	}
	public void setPhoneNum(long phoneNum) {
		this.phoneNum = phoneNum;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Name="+this.firstLastName+",Address="+this.address+",City="+this.city+",State="+this.state+
				",Zip="+this.zip+",Mobile Number="+this.phoneNum+",Email="+this.email;
	}
}
