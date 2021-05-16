package compiler.semantic.type;

import java.util.ArrayList;
import java.util.List;

import compiler.semantic.symbol.SymbolParameter;
import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.type.TypeBase;

/**
 * Class for TypeProcedure.
 */

// TODO: Student work
//       Include properties to characterize procedure declarations

public class TypeProcedure
    extends TypeBase
{   
	private List<SymbolParameter> listaParametros;

   /**
     * Constructor for TypeProcedure.
     * @param scope The declaration scope.
     */
    public TypeProcedure (ScopeIF scope)
    {
        super (scope);
        this.listaParametros = new ArrayList<SymbolParameter>();
    }

    /**
     * Constructor for TypeProcedure.
     * @param scope The declaration scope
     * @param name The name of the procedure.
     */
    public TypeProcedure (ScopeIF scope, String name)
    {
        super (scope, name);
        this.listaParametros = new ArrayList<SymbolParameter>();
    }     
    
    public void addParametro(SymbolParameter parametro) {
    	this.listaParametros.add(parametro);
    }
    
    /**
     * Returns the size of the type.
     * @return the size of the type.
     */
    @Override
    public int getSize ()
    {
        // TODO: Student work
        return 1;
    }
}
