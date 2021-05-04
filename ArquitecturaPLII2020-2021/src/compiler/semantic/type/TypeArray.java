package compiler.semantic.type;

import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.type.TypeBase;
import es.uned.lsi.compiler.semantic.type.TypeIF;

/**
 * Class for TypeArray.
 */

// TODO: Student work
//       Include properties to characterize array type

public class TypeArray
    extends TypeBase
{   
	private int min;
    private int max;
    private int size;
    private String tipo;
    
	/**
     * Constructor for TypeArray.
     * @param scope The declaration scope.
     */
    public TypeArray (ScopeIF scope)
    {
        super (scope);
    }

	/**
     * Constructor for TypeArray.
     * @param scope The declaration scope.
     * @param name The name of the type.
     */
    public TypeArray (ScopeIF scope, String name)
    {
        super (scope, name);
    }
    
    public TypeArray (ScopeIF scope, String name, int min, int max, String tipo)
    {
        super (scope, name);
        this.min = min;
        this.max = max;
        this.tipo = tipo;
        this.size = max - min + 1;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setSize(int size) {
		this.size = size;
	}
    /**
     * Returns the size of the type.
     * @return the size of the type.
     */
    @Override
    public int getSize ()
    {
        // TODO: Student work
        return this.size;
    }
}
