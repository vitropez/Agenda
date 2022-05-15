package procesos;
import gui.Miventana;
public class Contactos {

	private String nombre;
	private int telefono;
	private String poblacion;
	public Contactos(String nombre, int telefono, String poblacion) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.poblacion = poblacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	@Override
	public String toString() {
		return "Contacto " + nombre + ", telefono: " + telefono + ", poblacion: " + poblacion+"\n" ;
	}
	
	
	
		
	
}
