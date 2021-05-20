package compiler.syntax.nonTerminal;

public class Var extends NonTerminal{
	
	private String id;
	private String tipo;
	private String valor;

	public Var() {
		super();
	}
	
	public Var(String tipo) {
		super();
		this.tipo = tipo;
	}
	
	public Var(String tipo, String valor) {
		super();
		this.tipo = tipo;
		this.valor = valor;
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
		return "Variable[name:" + this.id + " type:" + this.tipo+" value:" + this.valor+"]";
	}


}