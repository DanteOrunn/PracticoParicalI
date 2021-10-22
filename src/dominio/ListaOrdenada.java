package dominio;

import nodoList.NodoLista;

public class ListaOrdenada extends Lista {

    public ListaOrdenada() {
        super();
    }

    public void insertarMedio(NodoLista p, NodoLista ant, NodoLista x) {
        x.setPs(p);
        ant.setPs(x);
    }

    public void insertarFin(NodoLista ant, NodoLista p, NodoLista x) {
        if (p == null) {
            x.setPs(null);
            ant.setPs(x);
        }
    }

    public void insertar(Proveedor elem) {
        NodoLista p = inicio();
        NodoLista ant = null;
        int b = 0;

        while (p != null && b == 0) {
            if (p.getDato().getDni() > elem.getDni()) {
                b = 1;
            } else {
                ant = p;
                p = p.getPs();
            }
        }
        NodoLista x = new NodoLista(elem);
        if (b == 1) {
            if (p == list) {
                insertarPri(elem);
            } else {
                insertarMedio(p, ant, x);
            }
        } else {
            if (ant == null) {
                list = x;
            } else {
                insertarFin(ant, p, x);
            }
        }
    }

    public NodoLista eliminar(){
        NodoLista x = null;
        NodoLista p = inicio();
        NodoLista ant = null;

        if (listaVacia()) {
            prt("Lista Vacia!!");
            return x;
        }

        boolean band = false;

        while (p != null && !band) {
            x = quitar(p, ant);
            band = true;
        }

        return x;
    }

    public NodoLista eliminar(int elem) {
        NodoLista x = null;
        NodoLista p = inicio();
        NodoLista ant = null;
        if (listaVacia()) {
            prt("Lista Vacía!!!");
            return x;
        }
        boolean band = false;
        while (p != null && !band) {
            if (p.getDato().getDni() >= elem) {
                if (p.getDato().getDni() == elem) {
                    x = quitar(p, ant);
                    band = true;
                } else {
                    p = null;
                }
            } else {
                ant = p;
                p = p.getPs();
            }
        }
        if (band == true) {
            prt("Elemento eliminado!");
        } else {
            prt("Elemento inexistente!!!");
        }
        return x;
    }

    public void buscarYMostrar(int dni){
        
    }
}
