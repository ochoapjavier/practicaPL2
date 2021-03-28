package compiler.syntax.nonTerminal;

public class Constante extends NonTerminal{
	
	private String tipo;

	public Constante() {
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
	
	public void imprimeTipo() {
	 System.out.println(getTipo());
	}

}