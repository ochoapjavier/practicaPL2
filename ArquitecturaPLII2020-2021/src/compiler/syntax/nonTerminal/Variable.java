package compiler.syntax.nonTerminal;

public class Variable extends NonTerminal{
	
	private String tipo;

	public Variable() {
		super();
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String toString(){
		return "Constante[type:" + this.tipo+"]";
	}

}