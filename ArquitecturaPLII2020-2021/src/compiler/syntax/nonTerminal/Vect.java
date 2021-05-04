package compiler.syntax.nonTerminal;

public class Vect extends NonTerminal{
	
	private String tipo;
	private int min;
	private int max;

	public Vect() {
		super();
	}
	
	public Vect(String tipo) {
		super();
		this.tipo = tipo;
	}
	
	public Vect(int min, int max, String tipo){
		super();
		this.min = min;
		this.max = max;
		this.tipo = tipo;
		
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
		
	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}
	
	public String toString(){
		return "Vector[type:" + this.tipo+" min:" + this.min+" max:" + this.max+"]";
	}

}