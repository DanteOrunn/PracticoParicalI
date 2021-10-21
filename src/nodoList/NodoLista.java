package nodoList;

import dominio.Proveedor;

public class NodoLista {
    
    private Proveedor dato;
    private NodoLista ps;

    public NodoLista(Proveedor elem) {
        dato = elem;
        ps = null;
    }

    /**
     * @return el dato
     */
    public Proveedor getDato() {
        return dato;
    }

    /**
     * @param dato el dato a establecer
     */
    public void setDato(Proveedor dato) {
        this.dato = dato;
    }

    /**
     * @return el ps
     */
    public NodoLista getPs() {
        return ps;
    }

    /**
     * @param ps el ps a establecer
     */
    public void setPs(NodoLista ps) {
        this.ps = ps;
    }

}
