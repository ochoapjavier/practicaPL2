package compiler.syntax.nonTerminal;

import java.util.List;

public class AxiomImp extends Axiom {
	
	private List intermediateCode;
	public AxiomImp(){
		super();
	}
	
	 public List getIntermediateCode() {
	    return intermediateCode;
	    }
	   
	 public void setIntermediateCode(List intermediateCode) {
	    this.intermediateCode = intermediateCode;
	    }

}