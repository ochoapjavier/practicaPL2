package compiler.code;

import java.util.Arrays;
import java.util.List;

import compiler.intermediate.Label;
import compiler.intermediate.Temporal;
import compiler.intermediate.Value;
import compiler.intermediate.Variable;
import compiler.semantic.type.TypeSimple;

import es.uned.lsi.compiler.code.ExecutionEnvironmentIF;
import es.uned.lsi.compiler.code.MemoryDescriptorIF;
import es.uned.lsi.compiler.code.RegisterDescriptorIF;
import es.uned.lsi.compiler.intermediate.OperandIF;
import es.uned.lsi.compiler.intermediate.QuadrupleIF;

/**
 * Class for the ENS2001 Execution environment.
 */

public class ExecutionEnvironmentEns2001 
    implements ExecutionEnvironmentIF
{    
    private final static int      MAX_ADDRESS = 65535; 
    private final static String[] REGISTERS   = {
       ".PC", ".SP", ".SR", ".IX", ".IY", ".A", 
       ".R0", ".R1", ".R2", ".R3", ".R4", 
       ".R5", ".R6", ".R7", ".R8", ".R9"
    };
    
    private RegisterDescriptorIF registerDescriptor;
    private MemoryDescriptorIF   memoryDescriptor;
    
    /**
     * Constructor for ENS2001Environment.
     */
    public ExecutionEnvironmentEns2001 ()
    {       
        super ();
    }
    
    /**
     * Returns the size of the type within the architecture.
     * @return the size of the type within the architecture.
     */
    @Override
    public final int getTypeSize (TypeSimple type)
    {      
        return 1;  
    }
    
    /**
     * Returns the registers.
     * @return the registers.
     */
    @Override
    public final List<String> getRegisters ()
    {
        return Arrays.asList (REGISTERS);
    }
    
    /**
     * Returns the memory size.
     * @return the memory size.
     */
    @Override
    public final int getMemorySize ()
    {
        return MAX_ADDRESS;
    }
           
    /**
     * Returns the registerDescriptor.
     * @return Returns the registerDescriptor.
     */
    @Override
    public final RegisterDescriptorIF getRegisterDescriptor ()
    {
        return registerDescriptor;
    }

    /**
     * Returns the memoryDescriptor.
     * @return Returns the memoryDescriptor.
     */
    @Override
    public final MemoryDescriptorIF getMemoryDescriptor ()
    {
        return memoryDescriptor;
    }

    /**
     * Translate a quadruple into a set of final code instructions. 
     * @param cuadruple The quadruple to be translated.
     * @return a quadruple into a set of final code instructions. 
     */
    @Override
    public final String translate (QuadrupleIF quadruple)
    {      
        //TODO: Student work
    	if(quadruple.getOperation().equals("HALT")) {
    		StringBuffer b = new StringBuffer();
    		b.append(";" + quadruple.toString() + "\n");
    		b.append("HALT");
    		return b.toString();
    	}
    	
    	if(quadruple.getOperation().equals("VARGLOBAL")) {
    		StringBuffer b = new StringBuffer();
    		String o1 = operacion(quadruple.getFirstOperand());
    		String r = operacion(quadruple.getResult());
    		b.append(";" + quadruple.toString() + "\n");
    		b.append("MOVE " + o1 + "," + r);
    		return b.toString();
    	}
    	
    	if(quadruple.getOperation().equals("PRINTE")) {
    		StringBuffer b = new StringBuffer();
    		String r = operacion(quadruple.getResult());
    		System.out.println("resultado de PRINTE" +r);
    		b.append(";" + quadruple.toString() + "\n");
    		b.append("WRINT " + r);
    		return b.toString();
    	}
    	
    	if(quadruple.getOperation().equals("ADD")) {
    		StringBuffer b = new StringBuffer();
    		String o1 = operacion(quadruple.getFirstOperand());
    		String o2 = operacion(quadruple.getSecondOperand());
    		String r = operacion(quadruple.getResult());
    		b.append(";" + quadruple.toString() + "\n");
    		b.append("ADD " + o1 + "," + o2 + "\n");
    		b.append("MOVE " + ".A" + "," + r);
    		return b.toString();
    	}
    	
    	if(quadruple.getOperation().equals("MUL")) {
    		StringBuffer b = new StringBuffer();
    		String o1 = operacion(quadruple.getFirstOperand());
    		String o2 = operacion(quadruple.getSecondOperand());
    		String r = operacion(quadruple.getResult());
    		b.append(";" + quadruple.toString() + "\n");
    		b.append("MUL " + o1 + "," + o2 + "\n");
    		b.append("MOVE " + ".A" + "," + r);
    		return b.toString();
    	}
    	
    	if(quadruple.getOperation().equals("MV")) {
    		StringBuffer b = new StringBuffer();
    		String o1 = operacion(quadruple.getFirstOperand());
    		String r = operacion(quadruple.getResult());
    		b.append(";" + quadruple.toString() + "\n");
    		b.append("MOVE " + o1 + "," + r);
    		return b.toString();
    	}
    	
    	if(quadruple.getOperation().equals("MVA")) {
    		System.out.println("Estoy en MVA");
    		StringBuffer b = new StringBuffer();
    		String o1 = operacionComp(quadruple.getFirstOperand());
    		System.out.println(o1);
    		String r = operacion(quadruple.getResult());
    		System.out.println(r);
    		b.append(";" + quadruple.toString() + "\n");
    		b.append("MOVE " + o1 + "," + r);
    		return b.toString();
    	}
    	
    	//Quadruple - [STP T_1, T_0, null]
    	if(quadruple.getOperation().equals("STP")) {
    		System.out.println("Estoy en STP");
    		StringBuffer b = new StringBuffer();
    		//o1 = T_0
    		String o1 = operacion(quadruple.getFirstOperand());
    		System.out.println(o1);
    		//r = T_1
    		String r = operacion(quadruple.getResult());
    		System.out.println(r);
    		b.append(";" + quadruple.toString() + "\n");
    		b.append("MOVE " + r+ "," + ".R1" + "\n");
    		b.append("MOVE " + o1 + "," + "[.R1]");
    		return b.toString();
    	}
    	
    	/*
		;Quadruple - [MVP T_9, T_8, null]
		t8  = 65520
		MOVE /65519, .R1
		MOVE [.R1], /65519
    	 */
    	if(quadruple.getOperation().equals("MVP")) {
    		System.out.println("Estoy en MVP");
    		StringBuffer b = new StringBuffer();
    		//o1 = T_0
    		String o1 = operacion(quadruple.getFirstOperand());
    		System.out.println(o1);
    		//r = T_1
    		String r = operacion(quadruple.getResult());
    		System.out.println(r);
    		b.append(";" + quadruple.toString() + "\n");
    		b.append("MOVE " + o1 + ", " + r);
    		return b.toString();
    	}
    	
    	
        return quadruple.toString(); 
    }
    
    public String operacion(OperandIF o) {
    	System.out.println("Estoy en operacion "+o);
    	if (o instanceof Variable) {
    		System.out.println("Variable "+o);
    		System.out.println(((Variable) o).getAddress());
    		return "/" + ((Variable)o).getAddress();
    	}
    	if (o instanceof Value) {
    		System.out.println("Value "+o);
    		return "#" + ((Value)o).getValue();
    	}
    	if (o instanceof Temporal) {
    		System.out.println("Temporal "+o);
    		return "/" + ((Temporal)o).getAddress();
    	}
    	if (o instanceof Label) {
    		System.out.println("Label "+o);
    		return  ((Label)o).getName();
    	}
    	return null;
    }
    
    public String operacionComp(OperandIF o) {
    	System.out.println("Estoy en operacion "+o);
    	if (o instanceof Variable) {
    		System.out.println("Variable "+o);
    		System.out.println(((Variable) o).getAddress());
    		return "#" + ((Variable)o).getAddress();
    	}
    	if (o instanceof Value) {
    		System.out.println("Value "+o);
    		return "/" + ((Value)o).getValue();
    	}
    	if (o instanceof Temporal) {
    		System.out.println("Temporal "+o);
    		return "#" + ((Temporal)o).getAddress();
    	}
    	if (o instanceof Label) {
    		System.out.println("Label "+o);
    		return  ((Label)o).getName();
    	}
    	return null;
    }
}
