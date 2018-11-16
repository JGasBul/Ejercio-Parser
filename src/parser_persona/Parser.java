package parser_persona;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Parser {

	private Document dom = null;
	private ArrayList<Libro> libros = null;

	public Parser() {
		libros = new ArrayList<Libro>();
	}

	public void parseFicheroXml(String fichero) {
		// creamos una factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {
			// creamos un documentbuilder
			DocumentBuilder db = dbf.newDocumentBuilder();

			// parseamos el XML y obtenemos una representación DOM
			dom = db.parse(fichero);
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (SAXException se) {
			se.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

	public void parseDocument() {
		// obtenemos el elemento raíz
		Element docEle = dom.getDocumentElement();

		// obtenemos el nodelist de elementos
		NodeList nl = docEle.getElementsByTagName("libro");
		if (nl != null && nl.getLength() > 0) {
			for (int i = 0; i < nl.getLength(); i++) {

				// obtenemos un elemento de la lista (persona)
				Element el = (Element) nl.item(i);
				// obtenemos una persona
				Libro l = getLibro(el);
				// lo añadimos al array
				libros.add(l);
			}
		}
	}
	
	private Libro getLibro(Element LibroEle){
		ArrayList<String> nombres=new ArrayList<String>();
		int anyo=0;
		//para cada elemento persona, obtenemos su nombre y su edad
		String titulo = getTextValue(LibroEle,"titulo");
		
		NodeList nl=LibroEle.getElementsByTagName("titulo");
		if (nl != null && nl.getLength() > 0) {
			for (int i = 0; i < nl.getLength(); i++) {
				Element el = (Element) nl.item(i);
				String temp=el.getAttribute("anyo");
				anyo=Integer.parseInt(temp);
			}
		}
		
		NodeList nl1=LibroEle.getElementsByTagName("autor");
		if (nl1 != null && nl1.getLength() > 0) {
				Element autorele = (Element) nl1.item(0);
				
				NodeList nl2=autorele.getElementsByTagName("nombre");
				if (nl2 != null && nl2.getLength() > 0) {
					for (int i = 0; i < nl2.getLength(); i++) {
						Element nombreele = (Element) nl2.item(i);
						String nombre = nombreele.getFirstChild().getNodeValue();
						nombres.add(nombre);
					}
				}
				
		}
		String editor=getTextValue(LibroEle, "editor");
		int paginas=getIntValue(LibroEle,"paginas");
		
		Libro l = new Libro(titulo,editor,paginas,nombres,anyo);

		return l;		
		
	}
	
	private String getTextValue(Element ele, String tagName) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if(nl != null && nl.getLength() > 0) {
			Element el = (Element)nl.item(0);
			textVal = el.getFirstChild().getNodeValue();
		}		
		return textVal;
	}
	
	private int getIntValue(Element ele, String tagName) {				
		return Integer.parseInt(getTextValue(ele,tagName));
	}
	
	public void print(){

		Iterator it = libros.iterator();
		while(it.hasNext()) {
			Libro l=(Libro) it.next();
			System.out.println(l.toString());
		}
	}
	
	

}
