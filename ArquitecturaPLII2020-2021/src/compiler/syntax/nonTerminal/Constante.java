package compiler.syntax.nonTerminal;

import java.util.List;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;
import es.uned.lsi.compiler.semantic.type.TypeIF;

public class Constante extends NonTerminal{
	
	private List<QuadrupleIF> code;
	private TypeIF type;
	private String tipo;
	private String valor;

	public Constante() {
		super();
	}
	
	//Contructor pasando la interfaz type
	public Constante (TypeIF type, String valor) {
		this.setType(type);
		this.valor = valor;
	}
	
	public Constante(String tipo, String valor) {
		super();
		this.tipo = tipo;
		this.valor = valor;
	}

	public TypeIF getType() {
		return type;
	}

	public void setType(TypeIF type) {
		this.type = type;
	}

	public List<QuadrupleIF> getCode() {
		return code;
	}

	public void setCode(List<QuadrupleIF> code) {
		this.code = code;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
	public String toString(){
		return "Constante[type:" + this.tipo+" value:" + this.valor+"]";
	}
}