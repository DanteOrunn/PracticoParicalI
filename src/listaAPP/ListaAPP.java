package listaAPP;

import dominio.*;
import nodoList.NodoLista;
import utilidad.*;

public class ListaAPP {

    ListaOrdenada miLista;

    public ListaAPP() {
        miLista = new ListaOrdenada();
    }

    public void generar() {
        boolean continuar = true;
        while (continuar) {
            prt("Ingrese la informacion del Proveedor");
            Proveedor elem = new Proveedor();
            elem.cargarInformacion();
            miLista.insertar(elem);
            continuar = Consola.confirmar();
        }
    }

    
    public void borrar() {
        boolean continuar = true;
        while (continuar) {
            prt("Ingrese el DNI:");
            int elem = Consola.leerInt();
            NodoLista x = miLista.eliminar((elem));
            System.out.println("\tElemento eliminado\n" + x.getDato().toString());
            continuar = Consola.confirmar();
        }
    }

    public void imprimir() {
        NodoLista p = miLista.inicio();
        while (p != null) {
            prt(p.getDato().toString() + "");
            p = p.getPs();
        }
    }

    public boolean verificar() {
        if (miLista.listaVacia()) {
            prt("Lista vacía!");
            return false;
        }
        return true;
    }

    public void menu() {
        int opcion = 9;
        do {
            switch (opcion) {
                case 1:
                    generar();
                    break;
                case 2:
                    if (verificar()) {
                        imprimir();
                    }
                    break;
                case 3:
                    if (verificar()) {
                        borrar();
                    }
                    break;

            }
            mostrarOpciones();
            opcion = Consola.leerInt();
            prt("--------->");

        } while (opcion != 0);
    }

    public void mostrarOpciones() {
        prt("Manejo de listas simples enlazadas");
        prt("1- Cargar");
        prt("2- Imprimir");
        prt("3- Borrar");
        prt("0- Salir");
        prt("--------->");

    }

    public void prt(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {

        ListaAPP miListaApp = new ListaAPP();
        miListaApp.menu();

    }

}