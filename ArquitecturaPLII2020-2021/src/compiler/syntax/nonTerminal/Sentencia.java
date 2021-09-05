package compiler.syntax.nonTerminal;

import es.uned.lsi.compiler.semantic.type.TypeIF;

public class Sentencia extends NonTerminal{
	
	private TypeIF type;
	private String tipo;
	private String valor;

	public Sentencia() {
		super();
	}
	
	public Sentencia(String tipo, String valor) {
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

	public void setValor(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public String toString(){
		return "Sentencia[type:" + this.tipo+" value:" + this.valor+"]";
	}
}
