package compiler.syntax.nonTerminal;

public class IdVar extends NonTerminal{
	
	private String id;

	public IdVar() {
		super();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public IdVar(String id) {
		super();
		this.id = id;
	}
	
	public String toString(){
		return "SecuenciaVariables[value:" + this.id+"]";
	}
}