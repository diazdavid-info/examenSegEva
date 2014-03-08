/**
 * 
 */
package Examen;

/**
 * @author David
 *
 */
public class Principal {

	/**
	 * Se requiere un programa que recoja una agenda. 
	 * La agenda almacenar� tanto personas como empresas y el programa lo diferenciar�.
	 * Los datos se almacenaran en una BDD y en un fichero.
	 * Al iniciar el programa, el programa sincronizar� el fichero con la BDD y viceversa.
	 * Tendr� un men� donde se le dar� al usuario las diferentes alternativas.
	 * El programa podr� funcionar con una BDD o sin ella.
	 * Abr� una "interface" con m�todos para obligar a las diferentes clase implementarlos.
	 */
	public static void main(String[] args) {
		Persona p = new Persona(TipoUsuario.PARTICULAR, "David", 123456789, "david@example.org");
		System.out.println(p);

	}

}
