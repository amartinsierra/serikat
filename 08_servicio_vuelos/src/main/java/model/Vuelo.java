package model;

public class Vuelo {
	private int idVuelo;
	private String company;
	private double precio;
	private int plazas;
	public Vuelo(int idVuelo, String company, double precio, int plazas) {
		super();
		this.idVuelo = idVuelo;
		this.company = company;
		this.precio = precio;
		this.plazas = plazas;
	}
	public Vuelo() {
		super();
	}
	public int getIdVuelo() {
		return idVuelo;
	}
	public void setIdVuelo(int idVuelo) {
		this.idVuelo = idVuelo;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getPlazas() {
		return plazas;
	}
	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}
	
}
