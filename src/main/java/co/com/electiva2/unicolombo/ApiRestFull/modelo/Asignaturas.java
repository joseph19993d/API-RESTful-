package co.com.electiva2.unicolombo.ApiRestFull.modelo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Asignaturas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String nombreCompleto;
    private String descripcion;
    private String areaConocimiento;
    private String carrera;
    private int numeroCreditos;
    private String contenidoTematico;
    private int semestre;
    private String profesor;
    
	public Asignaturas(int id, String nombre, String nombreCompleto, String descripcion, String areaConocimiento,
			String carrera, int numeroCreditos, String contenidoTematico, int semestre, String profesor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.nombreCompleto = nombreCompleto;
		this.descripcion = descripcion;
		this.areaConocimiento = areaConocimiento;
		this.carrera = carrera;
		this.numeroCreditos = numeroCreditos;
		this.contenidoTematico = contenidoTematico;
		this.semestre = semestre;
		this.profesor = profesor;
	}
	public Asignaturas( String nombre, String nombreCompleto, String descripcion, String areaConocimiento,
			String carrera, int numeroCreditos, String contenidoTematico, int semestre, String profesor) {
		super();
		this.nombre = nombre;
		this.nombreCompleto = nombreCompleto;
		this.descripcion = descripcion;
		this.areaConocimiento = areaConocimiento;
		this.carrera = carrera;
		this.numeroCreditos = numeroCreditos;
		this.contenidoTematico = contenidoTematico;
		this.semestre = semestre;
		this.profesor = profesor;
	}
	
	public Asignaturas( ) {
		super();
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getAreaConocimiento() {
		return areaConocimiento;
	}
	public void setAreaConocimiento(String areaConocimiento) {
		this.areaConocimiento = areaConocimiento;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public int getNumeroCreditos() {
		return numeroCreditos;
	}
	public void setNumeroCreditos(int numeroCreditos) {
		this.numeroCreditos = numeroCreditos;
	}
	
	public String getContenidoTematico() {
		return contenidoTematico;
	}
	
	public void setContenidoTematico(String contenidoTematico) {
		this.contenidoTematico = contenidoTematico;
	}
	
	public int getSemestre() {
		return semestre;
	}
	
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
	
	public String getProfesor() {
		return profesor;
	}
	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}
	
	
    
    
    
    
}
