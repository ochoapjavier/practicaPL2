package compiler.syntax.nonTerminal;

import java.util.ArrayList;
import java.util.List;

public class ListaSentencias extends NonTerminal{
	
	private List<Sentencia> listaSentencias;

	public ListaSentencias() {
		super();
		this.listaSentencias = new ArrayList<Sentencia>();
	}
	
	public ListaSentencias(ListaSentencias sv) {
		super();
		this.listaSentencias = (List<Sentencia>) sv;
	}
	
	public Sentencia getSentencia(int index) {
		return this.listaSentencias.get(index);	
	}
	
	public void addSentencia(Sentencia sentencia) {
		this.listaSentencias.add(sentencia);
	}
	
	public void addLista(List<Sentencia> lista) {
		for (int i = 0; i < lista.size(); i++) {
			this.listaSentencias.add(lista.get(i));
		}
	}
	
	public List<Sentencia> getListaSentencias() {
		return listaSentencias;
	}

	public void setListaSentencias(List<Sentencia> listaSentencias) {
		this.listaSentencias = listaSentencias;
	}
	
	public int size() {
		return this.listaSentencias.size();
	}
	
	public String toString(){
		return "ListaSentencias[lista:" + this.listaSentencias+"]";
	}
}
