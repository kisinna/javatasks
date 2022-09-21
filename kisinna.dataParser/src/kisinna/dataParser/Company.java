package kisinna.dataParser;

import java.time.LocalDate;
import java.util.List;

public class Company {
 private Integer id;
 private String name;
 private String address;
 private String phoneNumber;
 private String inn;
 private LocalDate founded;
 private List<Security> securities;
public Integer getId() {
	return id;
}
public Company(Integer id, String name, String address, String phoneNumber, String inn, LocalDate founded, List<Security> securities) {
	super();
	this.id = id;
	this.name = name;
	this.address = address;
	this.phoneNumber = phoneNumber;
	this.inn = inn;
	this.founded = founded;
	this.securities = securities;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public String getInn() {
	return inn;
}
public void setInn(String inn) {
	this.inn = inn;
}
public LocalDate getFounded() {
	return founded;
}
public void setFounded(LocalDate founded) {
	this.founded = founded;
}
public List<Security> getSecurities() {
	return securities;
}
public void setSecurities(List<Security> securities) {
	this.securities = securities;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
 
}
