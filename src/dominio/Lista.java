package dominio;

import nodoList.*;

public class Lista {

    protected NodoLista list;

//	************************************* CONSTRUCTOR ******************************************************
    public Lista() {
        list = null;
    }

//	***************************************** INICIO *******************************************************
    public NodoLista inicio() {
        return list;
    }

//	***************************************** INICIO *******************************************************
    public boolean listaVacia() {
        return (list == null);
    }

//	********************************** INSERTAR AL PRINCIPIO ***********************************************
    public void insertarPri(Proveedor elem) {
        NodoLista x = new NodoLista(elem);
        if (list == null) {
            list = x;
        } else {
            x.setPs(list);
            list = x;
        }
    }

    public void prt(String s) {
        System.out.println(s);
    }

//	******************************************** QUITAR ****************************************************
    public NodoLista quitar(NodoLista p, NodoLista ant) {
        NodoLista x = p;

        if (p == list) {
            list = p.getPs();
        } else {
            ant.setPs(p.getPs());
        }
        return x;
    }

    public NodoLista eliminar(Proveedor elem) {
        NodoLista x = null;
        NodoLista p = list;
        NodoLista ant = null;
        if(list == null)
            return x;
        boolean band = false;
        while (p != null && !band) {
            if (p.getDato() == elem) {
                band = true;
            } else {
                ant = p;
                p = p.getPs();

            }
        }
        if (band == true) {
            quitar(p, ant);
            x = p;
        }
        return x;
    }

    public void visualizar() {
        NodoLista p = inicio();
        while (p != null) {
            prt(p.getDato() + "");
            p = p.getPs();
        }
    }

}
