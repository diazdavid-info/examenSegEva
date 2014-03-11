/**
 * 
 */
package Examen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

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
	//Atributos BDD
	final static String HOST = "localhost/";
	final static String USUARIO = "root";
	final static String PASS = "";
	final static String BDD = "examen2eva";
	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	
	static Scanner t = new Scanner(System.in);
	
	public static void main(String[] args) {
		//Atributos
		
		
		opcionBDD();
		cerrarConexion();
		
		
		
		
		
		
		

	}

	private static void opcionBDD() {
		String respuesta;
		String[] datos;
		System.out.println("Quieres trabaja con una base de datos?(s/n)");
		respuesta = t.next();
		if (respuesta == "s") {
			respuesta = null;
			System.out.println("Los valores por defecto de la BDD son:");
			System.out.println("Nombre host: "+HOST+", base de datos: "+BDD+", usuario: "+USUARIO+" y la contraseña: "+PASS);
			System.out.println("Desea trabajar con esos valores?(s/n)");
			respuesta = t.next();
			if (respuesta == "s") {
				crearConexionBdd();
				sincronizarBddFichero();
			} else {
				System.out.println("Digame el host, la BDD, el usuario y la contraseña todo junto separado por comas");
				System.out.println("Si la contraseña esta vacia ponga null");
				System.out.println("Ejemplo: localhost/,prueba,david,null");
				respuesta = t.nextLine();
				datos = respuesta.split(",");
				crearConexionBdd(datos[0], datos[1], datos[2], datos[3]);
			}
		}
	}

	private static void sincronizarBddFichero() {
		BufferedReader brp = null;
		BufferedReader bre = null;
		boolean existeFicheroPersona = true;
		boolean existeFicheroEmpresa = true;
		String linea = null;
		String[] valores;
		try {
			brp = new BufferedReader(new FileReader(new File("persona.txt")));
		} catch (FileNotFoundException e) {
			existeFicheroPersona = false;
		}
		if (existeFicheroPersona) {
			try {
				linea = brp.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			while (linea != null) {
				linea = linea.toLowerCase();
				valores = linea.split(" ");
				rs = null;
				consultaBdd("SELECT * FROM persona WHERE nombre = "+valores[1]+" AND telefono = "+valores[2]+" AND correo = "+valores[3]);
				
				
			}
		}
		try {
			bre = new BufferedReader(new FileReader(new File("empresa.txt")));
		} catch (FileNotFoundException e) {
			existeFicheroPersona = false;
		}
		
	}

	private static void consultaBdd(String consulta) {
		try {
			rs = stmt.executeQuery(consulta);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void crearConexionBdd() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://"+HOST+BDD, USUARIO, PASS);
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	private static void crearConexionBdd(String host,String bdd,String user,String pass) {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://"+host+bdd, user, (pass == "null")? PASS : pass);
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	private static void cerrarConexion() {
		try {
			conn.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
