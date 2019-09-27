package model;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the cursos database table.
 * 
 */

public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int idCurso;

	private String denominacion;

	private int duracion;

	
	private Date fechaInicio;

	public Curso() {
	}

	public Curso(int idCurso, String denominacion, int duracion, Date fechaInicio) {
		super();
		this.idCurso = idCurso;
		this.denominacion = denominacion;
		this.duracion = duracion;
		this.fechaInicio = fechaInicio;
	}

	public int getIdCurso() {
		return this.idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public String getDenominacion() {
		return this.denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public int getDuracion() {
		return this.duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

}