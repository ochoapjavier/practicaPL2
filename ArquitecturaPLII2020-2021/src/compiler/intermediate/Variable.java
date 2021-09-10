package compiler.intermediate;

import java.util.Iterator;
import java.util.List;

import compiler.semantic.symbol.SymbolVariable;
import es.uned.lsi.compiler.intermediate.VariableIF;
import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.symbol.SymbolIF;

/**
 * Class for variables in intermediate code.
 */

public class Variable
    implements VariableIF 
{
    private String  name     = null;
    private ScopeIF scope    = null;
    private int address;
        
    /**
     * Constructor for Variable.
     * @param name The name.
     * @param scope The scope index.
     */
    public Variable (String name, ScopeIF scope)
    {
        super ();
        this.name = name;
        this.scope = scope;
    }

    public void setAddress(int address) {
		this.address = address;
	}

	/**
     * Returns the name.
     * @return Returns the name.
     */
    @Override
    public final String getName ()
    {
        return name;
    }

    /**
     * Returns the scope.
     * @return Returns the scope.
     */
    @Override
    public final ScopeIF getScope ()
    {
        return scope;
    }

    /**
     * Returns the address.
     * @return Returns the address.
     */
    @Override
    public final int getAddress ()
    {
        // TODO : Student Work
    	int address = 0;
    	List<SymbolIF> simbolos = scope.getSymbolTable().getSymbols();
    	for (int i = 0; i < simbolos.size(); i++) {
    		if (simbolos.get(i) instanceof SymbolVariable && simbolos.get(i).getName().equals(this.name)) {
    			SymbolVariable sv = (SymbolVariable) simbolos.get(i);
    			address =sv.getAddress();
			}	
		}
    	return address;
    }

    /**
     * Indicates whether the address is a global address.
     * @return true if the address is a global address.
     */
    @Override
    public final boolean isGlobal ()
    {
        // TODO : Student Work
        return true;
    }

    /**
     * Compares this object with another one.
     * @param other the other object.
     * @return true if both objects has the same properties.
     */
    @Override
    public final boolean equals (Object other)
    {
        if (other == null) 
        {
            return false;
        }
        if (this == other)
        {
            return true;
        }
        if (!(other instanceof Variable))
        {
            return false;
        }
        
        final Variable aVariable = (Variable) other;
        return ((scope   == null) ? (aVariable.scope == null) : (aVariable.scope.equals (scope))) && 
               ((name    == null) ? (aVariable.name  == null) : (aVariable.name.equals (name)));
    }

    /**
     * Returns a hash code for the object.
     */
    @Override
    public final int hashCode ()
    {
        return 31 * scope.hashCode() +
                  ((name == null)? 0 : name.hashCode ());
    } 

    /**
     * Return a string representing the object.
     * @return a string representing the object.
     */
    @Override
    public final String toString ()
    {    
        return name;
    }
}
