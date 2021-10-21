package compiler.syntax.nonTerminal;

import java.util.ArrayList;
import java.util.List;

public class SecuenciaVariables extends NonTerminal{
	
	private List<Var> listaVariables;

	public SecuenciaVariables() {
		super();
		this.listaVariables = new ArrayList<Var>();
	}
	
	public SecuenciaVariables(SecuenciaVariables sv) {
		super();
		this.listaVariables = (List<Var>) sv;
	}
	
	public Var getVariable(int index) {
		return this.listaVariables.get(index);	
	}
	
	public void addVariable(Var var) {
		this.listaVariables.add(var);
	}
	
	public void addLista(List<Var> lista) {
		for (int i = 0; i < lista.size(); i++) {
			this.listaVariables.add(lista.get(i));
		}
	}
	
	public List<Var> getListaVariables() {
		return listaVariables;
	}

	public void setListaVariables(List<Var> listaVariables) {
		this.listaVariables = listaVariables;
	}
	
	public int size() {
		return this.listaVariables.size();
	}
	
	public String toString(){
		return "SecuenciaVariables[lista:" + this.listaVariables+"]";
	}
}