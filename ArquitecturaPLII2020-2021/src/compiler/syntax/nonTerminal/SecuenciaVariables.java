package compiler.syntax.nonTerminal;

import java.util.ArrayList;
import java.util.List;

public class SecuenciaVariables extends NonTerminal{
	
	private List<IdVar> listaVariables;

	public SecuenciaVariables() {
		super();
		this.listaVariables = new ArrayList<IdVar>();
	}
	
	public IdVar getVariable(int index) {
		return this.listaVariables.get(index);	
	}
	
	public void addVariable(IdVar idVar) {
		this.listaVariables.add(idVar);
	}
	
	public List<IdVar> getListaVariables() {
		return listaVariables;
	}

	public void setListaVariables(List<IdVar> listaVariables) {
		this.listaVariables = listaVariables;
	}
	
	public int size() {
		return this.listaVariables.size();
	}
	
	public String toString(){
		return "SecuenciaVariables[lista:" + this.listaVariables+"]";
	}
}