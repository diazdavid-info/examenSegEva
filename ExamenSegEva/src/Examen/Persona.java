/**
 * 
 */
package Examen;

/**
 * @author David
 *
 */
public class Persona implements Obligatorio {
	//Atributos
	private TipoUsuario tipo;
	private String nombre;
	private int telefono;
	private String correo;
	
	//COnstructores
	public Persona(TipoUsuario type, String name, int phone){
		tipo = type;
		nombre = name;
		telefono = phone;
		correo = null;
	}
	public Persona(TipoUsuario type, String name, int phone, String email){
		tipo = type;
		nombre = name;
		telefono = phone;
		correo = email;
	}
	
	
	
	
	//Métodos rescritos
	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public TipoUsuario getTipo() {
		return tipo;
	}

	@Override
	public void setNombre(String name) {
		nombre = name;
	}

	@Override
	public void setTipo(TipoUsuario type) {
		tipo = type;
		
	}
	
	@Override
	public String toString(){
		return "El usuario "+nombre+" con telefono "+telefono+", con correo electrónico "+correo+" y es de tipo "+tipo;
	}
	

}
