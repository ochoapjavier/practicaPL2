package compiler.syntax.nonTerminal;

public class Constante extends NonTerminal{
	
	private String tipo;
	private String valor;

	public Constante() {
		super();
	}
	
	public Constante(String tipo, String valor) {
		super();
		this.tipo = tipo;
		this.valor = valor;
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