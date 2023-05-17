import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sn = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		ArrayList<String> peliculasTexto= new ArrayList<String>();
		ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
		
		String ruta = "peliculas.txt";
		File fichero = new File(ruta);

		// Hago esto para crear fisicamente el fichero si no existe.
		if (!fichero.exists()) {
			try {
				fichero.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// Leemos el fichero y lo volcamos en un arraylist de nombres

		String linea = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(ruta));
			try {
				linea = br.readLine();
				String[] lineaSeparada = linea.split(" || ");
				while (linea != null) {
					peliculas.add(new Pelicula(Integer.parseInt(lineaSeparada[0]), lineaSeparada[1],
							Integer.parseInt(lineaSeparada[2]), lineaSeparada[3],
							Integer.parseInt(lineaSeparada[4])));
					peliculasTexto.add(linea);
					linea = br.readLine();
				}
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int opcion=0;
		int pos = 0;
		Pelicula pelicula = new Pelicula();
		int cod;
		String titulo;
		int anioEstreno;
		String nombeProtagonista;
		int costeProduccion;
		
		do{
			menu();
			System.out.println("Introduce opcion:");
			opcion=sn.nextInt();
			switch(opcion) {
			case 1:	
				System.out.println("Introduce el código de la pelicula");
				cod=sn.nextInt();
				System.out.println("Introduce el título de la pelicula");
				titulo=sc.nextLine();
				System.out.println("Introduce el año de estreno");
				anioEstreno=sn.nextInt();
				System.out.println("Introduce el nombre del protagonista");
				nombeProtagonista=sc.nextLine();
				System.out.println("Introduce el coste de produccion");
				costeProduccion=sn.nextInt();
				pelicula=altaPelicula(cod, titulo, anioEstreno, nombeProtagonista, costeProduccion);
				peliculas.add(pelicula);
				peliculasTexto.add(pelicula.datosPelicula());
				break;
			case 2:
				System.out.println("Introduce el código de la película:");
				cod=sc.nextInt();
				pos=posBajaPelicula(peliculas, cod);
				peliculas.remove(pos);
				peliculasTexto.remove(pos);
				break;
			case 3:
				mostrarPeliculas(peliculas);
				break;
			case 4:
				System.out.println("Introduce el código de la película:");
				cod=sc.nextInt();
				mostrardatosPelicula(peliculas, cod);
				break;
			case 5:
				//Ahora volcamos el contenido del arraylist en el archivo de texto para que 
				//asl volver al ejecutar el programa los datos de nombres estén actualizados.
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, false));
					for (String pt: peliculasTexto) {
						bw.write(pt);
						bw.newLine();
					}
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}while(opcion!=5);
	}

	public static void menu() {
		System.out.println("1. Alta de película.");
		System.out.println("2. Baja de película.");
		System.out.println("3. Consulta de todas las películas.");
		System.out.println("4. Consulta de dato de una película por cod_pelicula.");
		System.out.println("5. Salir");
	}
	
	public static Pelicula altaPelicula(int cod, String nombre, int fechaEstreno, String nombreProtagonista, int costeProduccion) {
		Pelicula pelicula = new Pelicula(cod, nombre, fechaEstreno, nombreProtagonista, costeProduccion);
		return pelicula;
	}
	
	public static int posBajaPelicula(ArrayList<Pelicula>peliculas, int cod) {
		int pos=0;
		for(int i=0; i<peliculas.size(); i++) {
			if(peliculas.get(i).getCod()==cod) {
				pos=i;
			}
		}
		return pos;
	}
	
	
	
	public static void mostrarPeliculas(ArrayList<Pelicula> peliculas) {
		for(Pelicula p:peliculas) {
			System.out.println(p.datosPelicula());
		}
	}
	
	public static void mostrardatosPelicula(ArrayList<Pelicula> peliculas, int cod) {
		for(Pelicula p:peliculas) {
			if(p.getCod()==cod) {
				p.datosPelicula();
			}
		}
	}
	
	
}
