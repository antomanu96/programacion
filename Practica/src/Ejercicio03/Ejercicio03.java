package Ejercicio03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Utilidades.Entrada;

public class Ejercicio03 {
	private static String ruta1;
	private static String fichero;
	private static String ruta2;
	private static String fichero2;
	private static String fichero3;
	private static String ruta3;
	
	
	
	
	
	public static String ruta() {
		System.out.println("Introduce la ruta del archivo");
		String ruta=Entrada.cadena();
		return ruta;
	}
	
	public static String fichero() {
		System.out.println("Introduce el nombre del archivo");
		String fichero=Entrada.cadena();
		return fichero;
	}
	
	public 	static void menu() {
		System.out.println("Selecciona una opcion 1-6");
		System.out.println("1-Introduce los datos del primer fichero ");
		System.out.println("2-Introduce los datos del segundo fichero");
		System.out.println("3-Introduce los datos del tercer fichero");
		System.out.println("6-Salir");
	}
	
	public static void crearArchivo(String ruta, String fichero) {
	    		
		File r=new File(ruta);
	        if(!r.isDirectory())
	            r.mkdirs();
	        File f=new File(r,fichero);
	        if(!f.exists())
	            try {
	                f.createNewFile();
	            }catch(IOException ioe) {
	                System.out.println("NO SE HA PODIDO CREAR EL ARCHIVO");
	            }
	}
	

	public static void leerArchivo(String ruta, String fichero, String ruta2, String fichero2, String ruta3, String fichero3) {
	

		try 
		{
			BufferedReader bf=new BufferedReader(new FileReader(ruta+File.separator+fichero));
			BufferedReader bf2=new BufferedReader(new FileReader(ruta2+File.separator+fichero2));
		    BufferedReader bf3=new BufferedReader(new FileReader(ruta3+File.separator+fichero3));
		    
		   FileWriter fw = new FileWriter(ruta3+File.separator+fichero3, true);
		   BufferedWriter fw3 = new BufferedWriter(fw);
		   
		   
		
	

			do  {
			
			  fw3.newLine();
			  fw3.write(bf.readLine());
			  fw3.write(bf2.readLine());
				  
				  
			} while(bf.readLine()!= null || bf2.readLine()!= null);
			
			if(bf.readLine()!= null)
				do {
					  fw3.newLine();
					  fw3.write(bf.readLine());
				} while(bf.readLine()!= null);
			else if(bf2.readLine()!= null)
				do {
					  fw3.newLine();
					  fw3.write(bf2.readLine());
				} while(bf2.readLine()!= null);
			else {
					
				fw3.close();
				fw.close();
				bf.close();
				bf2.close();
				bf3.close();
			}
			
		
			
		}catch(IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		
		
		
		   
	}
	

	
	public static void seleccionarOpc(int opc) {
		switch (opc) {
		case 1:
			ruta1 = ruta(); fichero = fichero();
			crearArchivo(ruta1, fichero);
			break;
		case 2:
			ruta2 = ruta(); fichero2 = fichero();
			crearArchivo(ruta2,fichero2);
			break;
		case 3:
			ruta3 = ruta(); fichero3 = fichero();
			crearArchivo(ruta3,fichero3);
			break;
		case 4:
			leerArchivo(ruta1, fichero, ruta2, fichero2, ruta3, fichero3);
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
