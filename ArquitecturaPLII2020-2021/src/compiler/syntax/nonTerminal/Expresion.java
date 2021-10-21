package compiler.syntax.nonTerminal;

import java.util.List;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;
import es.uned.lsi.compiler.semantic.type.TypeIF;

public class Expresion extends NonTerminal{
	
	private List<QuadrupleIF> code;
	private TypeIF type;
	private String tipo;
	private String valor;
	private String rango;
	private String id;

	public Expresion() {
		super();
	}
	
	public Expresion(TypeIF type, String valor) {
		super();
		this.type = type;
		this.valor = valor;
	}
	
	public Expresion(String tipo, String valor) {
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

	public String getRango() {
		return rango;
	}

	public void setRango(String rango) {
		this.rango = rango;
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
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String toString(){
		return "Expresion[type:" + this.type+" value:" + this.valor+" id:"+this.id+"]";
	}
}