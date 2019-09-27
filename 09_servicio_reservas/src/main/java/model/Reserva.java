package model;

public class Reserva {
	private int idReserva;
	private String nombre;
	private String dni;
	private int hotel;
	private int vuelo;
	public Reserva(int idReserva, String nombre, String email, int hotel, int vuelo) {
		super();
		this.idReserva = idReserva;
		this.nombre = nombre;
		this.dni = dni;
		this.hotel = hotel;
		this.vuelo = vuelo;
	}
	public Reserva() {
		super();
	}
	public int getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getHotel() {
		return hotel;
	}
	public void setHotel(int hotel) {
		this.hotel = hotel;
	}
	public int getVuelo() {
		return vuelo;
	}
	public void setVuelo(int vuelo) {
		this.vuelo = vuelo;
	}
	
}
