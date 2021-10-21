package compiler.syntax.nonTerminal;

public class Referencia extends NonTerminal{
	
	private String tipo;
	private String valor;

	public Referencia() {
		super();
	}
	
	public Referencia(String tipo, String valor) {
		super();
		this.tipo = tipo;
		this.valor = valor;
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
		return "Expresion[type:" + this.tipo+" value:" + this.valor+"]";
	}
}