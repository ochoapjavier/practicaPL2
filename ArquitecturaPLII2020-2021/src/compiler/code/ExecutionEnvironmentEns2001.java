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
import es.uned.lsi.compiler.intermediate.LabelFactory;
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
    private LabelFactory lf = new LabelFactory();
    
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
    		b.append(";" + quadruple.toString() + "\n");
    		b.append("WRINT " + r + "\n");
    		b.append("WRCHAR #10");
    		return b.toString();
    	}
    	
    	if(quadruple.getOperation().equals("PRINTC")) {
    		StringBuffer b = new StringBuffer();
    		String op = operacion(quadruple.getFirstOperand());
    		b.append(";" + quadruple.toString() + "\n");
    		b.append("WRSTR /" + op + "\n");
    		b.append("WRCHAR #10");
    		return b.toString();
    	}
    	
    	if(quadruple.getOperation().equals("PRINTCV")) {
    		StringBuffer b = new StringBuffer();
    		b.append(";" + quadruple.toString() + "\n");
    		b.append("WRCHAR #10");
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
    	
    	if(quadruple.getOperation().equals("AND")) {
    		StringBuffer b = new StringBuffer();
    		String o1 = operacion(quadruple.getFirstOperand());
    		String o2 = operacion(quadruple.getSecondOperand());
    		String r = operacion(quadruple.getResult());
    		b.append(";" + quadruple.toString() + "\n");
    		b.append("AND " + o1 + "," + o2 + "\n");
    		b.append("MOVE " + ".A" + "," + r);
    		return b.toString();
    	}
    	
    	if(quadruple.getOperation().equals("LS")) {
    		StringBuffer b = new StringBuffer();
    		String o1 = operacion(quadruple.getFirstOperand());
    		String o2 = operacion(quadruple.getSecondOperand());
    		String r = operacion(quadruple.getResult());
    		Label cierto = (Label) lf.create();
    		Label falso = (Label) lf.create();
    		b.append(";" + quadruple.toString() + "\n");
    		b.append("CMP " + o1 + "," + o2 + "\n");
    		b.append("BN /" + cierto + "\n");
    		b.append("MOVE #0 ," + r + "\n");
    		b.append("BR /" + falso + "\n");
    		b.append(cierto + ": MOVE #1," + r + "\n");
    		b.append(falso + ": NOP" + "\n");
    		

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
    	
    	if(quadruple.getOperation().equals("BRF")) {
    		StringBuffer b = new StringBuffer();
    		String o1 = operacion(quadruple.getFirstOperand());
    		String r = operacion(quadruple.getResult());
    		b.append(";" + quadruple.toString() + "\n");
    		b.append("CMP " + r + ", #0" + "\n");
    		b.append("BZ /" + o1);
    		return b.toString();
    	}
    	
    	if(quadruple.getOperation().equals("BR")) {
    		StringBuffer b = new StringBuffer();
    		String r = operacion(quadruple.getResult());
    		b.append(";" + quadruple.toString() + "\n");
    		b.append("BR /" + r);
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
    		StringBuffer b = new StringBuffer();
    		String o1 = operacionComp(quadruple.getFirstOperand());
    		String r = operacion(quadruple.getResult());
    		b.append(";" + quadruple.toString() + "\n");
    		b.append("MOVE " + o1 + "," + r);
    		return b.toString();
    	}
    	
    	//Quadruple - [STP T_1, T_0, null]
    	if(quadruple.getOperation().equals("STP")) {
    		StringBuffer b = new StringBuffer();
    		//o1 = T_0
    		String o1 = operacion(quadruple.getFirstOperand());
    		//r = T_1
    		String r = operacion(quadruple.getResult());
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
    		StringBuffer b = new StringBuffer();
    		//o1 = T_0
    		String o1 = operacion(quadruple.getFirstOperand());
    		//r = T_1
    		String r = operacion(quadruple.getResult());
    		b.append(";" + quadruple.toString() + "\n");
    		b.append("MOVE " + o1 + ", " + r);
    		return b.toString();
    	}
    	
    	if(quadruple.getOperation().equals("INL")) {
            StringBuffer buffer = new StringBuffer();
            String resultado = operacion(quadruple.getResult());
            buffer.append(";" + quadruple.toString() + "\n");
            buffer.append(resultado + ": ");
            return buffer.toString();
    	}
    	
    	if(quadruple.getOperation().equals("CADENA")) {
            StringBuffer buffer = new StringBuffer();
            String op = operacion(quadruple.getFirstOperand());
            String r = operacion(quadruple.getResult());
            buffer.append(";" + quadruple.toString() + "\n");
            buffer.append(op + ": ");
            buffer.append("DATA " + r);
            return buffer.toString();
          }
    	
    	
        return quadruple.toString(); 
    }
    
    public String operacion(OperandIF o) {
    	if (o instanceof Variable) {
    		return "/" + ((Variable)o).getAddress();
    	}
    	if (o instanceof Value) {
    		return "#" + ((Value)o).getValue();
    	}
    	if (o instanceof Temporal) {
    		return "/" + ((Temporal)o).getAddress();
    	}
    	if (o instanceof Label) {
    		return  ((Label)o).getName();
    	}
    	return null;
    }
    
    public String operacionComp(OperandIF o) {
    	if (o instanceof Variable) {
    		return "#" + ((Variable)o).getAddress();
    	}
    	if (o instanceof Value) {
    		return "/" + ((Value)o).getValue();
    	}
    	if (o instanceof Temporal) {
    		return "#" + ((Temporal)o).getAddress();
    	}
    	if (o instanceof Label) {
    		return  ((Label)o).getName();
    	}
    	return null;
    }
}
