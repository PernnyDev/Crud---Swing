package br.com.recoleta.model;

//localização do resíduo
public class WasteLocation {
	
	private Integer id;
	private String street;
	private String number;
	private String neighborhood;
	private String complement;
	private String city;
	private String state;
	private String country;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	
	public String getComplement() {
		return complement;
	}
	public void setComplement(String complement) {
		this.complement = complement;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public WasteLocation(Integer id, String street, String number, String neighborhood, String complement, String city, String state, String country) {
		this.id = id;
		this.street = street;
		this.number = number;
		this.neighborhood = neighborhood;
		this.complement = complement;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	
}
