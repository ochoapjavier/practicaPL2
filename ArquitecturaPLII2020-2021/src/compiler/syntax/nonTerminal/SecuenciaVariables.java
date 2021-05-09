package compiler.syntax.nonTerminal;

import java.util.ArrayList;
import java.util.List;

public class SecuenciaVariables extends NonTerminal{
	
	private List<Var> listaVariables;

	public SecuenciaVariables() {
		super();
		this.listaVariables = new ArrayList<Var>();
	}
	
	public Var getVariable(int index) {
		return this.listaVariables.get(index);	
	}
	
	public void addVariable(Var var) {
		this.listaVariables.add(var);
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