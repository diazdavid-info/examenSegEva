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
	 * La agenda almacenará tanto personas como empresas y el programa lo diferenciará.
	 * Los datos se almacenaran en una BDD y en un fichero.
	 * Al iniciar el programa, el programa sincronizará el fichero con la BDD y viceversa.
	 * Tendrá un menú donde se le dará al usuario las diferentes alternativas.
	 * El programa podrá funcionar con una BDD o sin ella.
	 * Abrá una "interface" con métodos para obligar a las diferentes clase implementarlos.
	 */
	public static void main(String[] args) {
		Persona p = new Persona(TipoUsuario.PARTICULAR, "David", 123456789, "david@example.org");
		System.out.println(p);

	}

}
