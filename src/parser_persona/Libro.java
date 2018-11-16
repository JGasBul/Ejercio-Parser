package parser_persona;

import java.util.ArrayList;
import java.util.Iterator;

public class Libro {
	private String titulo,editor;
	private int pg,año;
	private ArrayList<String> nombres;

	public Libro() {
		// TODO Auto-generated constructor stub
	}

	public Libro(String titulo, String editor, int pg, ArrayList<String> nombres,int año) {
		this.titulo = titulo;
		this.editor = editor;
		this.pg = pg;
		this.nombres = nombres;
		this.año=año;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getEditor() {
		return editor;
	}

	public int getPg() {
		return pg;
	}

	public String getNombres() {
		Iterator it=nombres.iterator();
		String result="";
		int x=0;
		while(it.hasNext()) {
			String temp=(String) it.next();
			result=result+" Nombre "+x+" = "+temp+" ";
			x++;
		}
		return result;
	}

	public int getAño() {
		return año;
	}

	@Override
	public String toString() {
		return "Libro [Titulo=" + titulo + ", "+getNombres()+" editor=" + editor + ", Paginas=" + pg + ", Año= "+año+"]";
	}
	

}
