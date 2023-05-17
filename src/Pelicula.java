public class Pelicula {
	private int cod;
	private String titulo;
	private int anioEstreno;
	private String nombeProtagonista;
	private int costeProduccion;

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnioEstreno() {
		return anioEstreno;
	}

	public void setAnioEstreno(int anioEstreno) {
		this.anioEstreno = anioEstreno;
	}

	public String getNombeProtagonista() {
		return nombeProtagonista;
	}

	public void setNombeProtagonista(String nombeProtagonista) {
		this.nombeProtagonista = nombeProtagonista;
	}

	public int getCosteProduccion() {
		return costeProduccion;
	}

	public void setCosteProduccion(int costeProduccion) {
		this.costeProduccion = costeProduccion;
	}

	public Pelicula() {
		super();
	}

	public Pelicula(int cod, String titulo, int anioEstreno, String nombeProtagonista, int costeProduccion) {
		super();
		this.cod = cod;
		this.titulo = titulo;
		this.anioEstreno = anioEstreno;
		this.nombeProtagonista = nombeProtagonista;
		this.costeProduccion = costeProduccion;
	}

	public String datosPelicula() {
		String pelicula="";
		pelicula = this.cod + " || " + this.titulo + " || " + this.anioEstreno + " || " + this.nombeProtagonista
				+ " || " + this.costeProduccion;
		return pelicula;
	}
}
