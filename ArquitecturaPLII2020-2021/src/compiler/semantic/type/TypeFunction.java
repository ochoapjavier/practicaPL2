package compiler.semantic.type;

import java.util.ArrayList;
import java.util.List;

import compiler.semantic.symbol.SymbolParameter;
import es.uned.lsi.compiler.semantic.ScopeIF;

/**
 * Class for TypeFunction.
 */

// TODO: Student work
//       Include properties to characterize function declarations

public class TypeFunction
    extends TypeProcedure
{
	private List<SymbolParameter> listaParametros;
	private String retorno;
    
    /**
     * Constructor for TypeFunction.
     * @param scope The declaration scope.
     */
    public TypeFunction (ScopeIF scope)
    {
        super (scope);
        this.listaParametros = new ArrayList<SymbolParameter>();
    }

    /**
     * Constructor for TypeFunction.
     * @param scope The declaration scope
     * @param name The name of the function.
     */
    public TypeFunction (ScopeIF scope, String name)
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

	public List<SymbolParameter> getListaParametros() {
		return listaParametros;
	}

	public void setListaParametros(List<SymbolParameter> listaParametros) {
		this.listaParametros = listaParametros;
	}

	public String getRetorno() {
		return retorno;
	}

	public void setRetorno(String retorno) {
		this.retorno = retorno;
	}
}
