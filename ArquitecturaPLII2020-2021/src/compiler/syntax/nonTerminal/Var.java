package compiler.syntax.nonTerminal;

import java.util.List;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;
import es.uned.lsi.compiler.semantic.type.TypeIF;

public class Var extends NonTerminal{
	
	private List<QuadrupleIF> code;
	private TypeIF type;
	private String id;
	private String tipo;
	private String valor;

	public Var() {
		super();
	}
	
	public Var(TypeIF type) {
		super();
		this.type = type;
	}
	
	public Var(String type) {
		super();
		this.tipo = type;
	}
	
	public Var(TypeIF type, String valor) {
		super();
		this.type = type;
		this.valor = valor;
	}
	
	/*public Var(String tipo, String valor) {
		super();
		this.tipo = tipo;
		this.valor = valor;
	}*/
	
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
		return "Variable[name:" + this.id + " type:" + this.type+" value:" + this.valor+"]";
	}


}