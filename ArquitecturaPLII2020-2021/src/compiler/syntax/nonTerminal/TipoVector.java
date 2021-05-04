package compiler.syntax.nonTerminal;

public class TipoVector extends NonTerminal{
	
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