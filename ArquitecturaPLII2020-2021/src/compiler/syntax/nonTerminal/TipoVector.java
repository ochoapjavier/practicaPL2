package compiler.syntax.nonTerminal;

import java.util.List;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;
import es.uned.lsi.compiler.semantic.type.TypeIF;

public class TipoVector extends NonTerminal{
	
	private List<QuadrupleIF> code;
	private TypeIF type;
	private String tipo;

	public TipoVector() {
		super();
	}
	
	public TipoVector(String tipo) {
		super();
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String toString(){
		return "TipoVector[type:" + this.tipo+"]";
	}
}