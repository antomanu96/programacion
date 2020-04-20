package Ejercicio01;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import Utilidades.Entrada;;

public class Ejercicio01 {
	public static String ruta() {
		System.out.println("Introduce la ruta del archivo");
		String ruta=Entrada.cadena();
		return ruta;
	}
	
	public static String fichero() {
		System.out.println("Introduce la ruta del archivo");
		String fichero=Entrada.cadena();
		return fichero;
	}
	public 	static void menu() {
		System.out.println("Selecciona una opcion 1-6");
		System.out.println("1-Contar el numero de lineas en blanco ");
		System.out.println("2-Frecuencia de aparición de cada una de las vocales");
		System.out.println("3-Número de líneas en las que aparece una palabra determinada, dicha palabra se introduce desde teclado");
		System.out.println("4-Crear un nuevo fichero en el cual el contenido estará en mayúsculas");
		System.out.println("5-Añadir al fichero inicial las líneas");
		System.out.println("6-Salir");
	}
	
	public static void lineasBlanco(String ruta,String fichero) {
		try (BufferedReader bf=new BufferedReader(new FileReader(ruta+File.separator+fichero))){
			String sCadena="";
			long lNumeroLineasVacias=0;

			while ((sCadena = bf.readLine())!=null) {
			  if (sCadena.isEmpty())
			    lNumeroLineasVacias++;
			}
			System.out.println("El numero de lineas en blanco es "+lNumeroLineasVacias);
		}catch(IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}
	
	public static void vocales(String ruta, String fichero1) {
	

			int a=0, e=0, i=0, o=0, u=0;
			int n=0;
			int todas=0;
			
		 	try {
		 		FileInputStream fichero = new FileInputStream(ruta+File.separator+fichero1);
				while (n!=-1) { // n és igual a -1 al final del
				
					todas++;
					n=fichero.read();
					switch( n ) {

						case 65 : a+=1; break;	//A
						case 97 : a+=1; break; //a
						case 101 : e+=1; break; //e
						case 69 : e+=1; break; //E
						case 105 : i+=1; break; //i
						case 73 : i+=1; break; //I
						case 111 : o+=1; break; //o
						case 79 : o+=1; break; //O
						case 117 : u+=1; break; //u
						case 85 : u+=1; break; //U
					}
				}
				
				System.out.println("El fichero contiene:");
				System.out.println("'a': "+(a*100/todas)+"%");
				System.out.println("'e': "+(e*100/todas)+"%");
				System.out.println("'i': "+(i*100/todas)+"%");
				System.out.println("'o': "+(o*100/todas)+"%");
				System.out.println("'u': "+(u*100/todas)+"%");
				
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			} 
		   
	}
	
	public static void palabra(String ruta, String fichero) {
		System.out.println("Introduce la palabra que desea buscar");
		String palabra =Entrada.cadena();	
		
		
		
	}
	
	public static void seleccionarOpc(int opc) {
		switch (opc) {
		case 1:
			lineasBlanco(ruta(),fichero());
			break;
		case 2:
			vocales(ruta(),fichero());
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		case 5:
			
			break;
		case 6:
			
			break;

		default:
			System.out.println("Fin del programa");
			break;
		}
	}
	public static void main(String[] args) {
		int opc;
		do {
			menu();
			opc=Entrada.entero();
			seleccionarOpc(opc);
		}while(opc!=6);

	}

}
