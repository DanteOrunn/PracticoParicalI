package principal;

import utilidad.*;
import arbolApp.*;
import dominio.*;

public class Principal {
    
    public static void main(String[] args) {
        
        ArbolBBAPP arbol = new ArbolBBAPP();
        ListaOrdenada list = new ListaOrdenada();
        int op = 0;

        do{

            menu();
            op = Consola.leerInt();

            switch(op){
                case 1:
                    Proveedor prov = new Proveedor();
                    prov.cargarInformacion();
                    int concidencia = prov.getDni();

                    if (!buscarClaveRepetida(concidencia, list)) {
                        list.insertar(prov);    
                    }
                    break;
                case 2:
                    if (!list.listaVacia()) {
                        arbol.generarArbol(list);
                    } else {
                        Consola.emitirMensajeLN("Lista Vaica!!");
                    }
                    break;
                case 3:
                    Consola.emitirMensaje("DNI:");
                    int dniBuscado = Consola.leerInt();

                    if (buscarDni(dniBuscado, list)) {
                        buscarYMostrar(dniBuscado, list);
                    }
                    break;
                case 4:
                    break;
                case 0:
                    break;
                default:
                    break;
            }

        }while(op != 0);

    }

    public static void menu(){
        System.out.println("====================================");
        System.out.println("**        MENU DE OPCIONES        **");
        System.out.println("====================================");
        System.out.println("** 1-Crear Lista de Proveedores   **");
        System.out.println("** 2-Generar Arbol de Proveedores **");
        System.out.println("** 3-Buscar Proveedor             **");
        System.out.println("** 4-Listar Proveedores           **");
        System.out.println("** 0-Salir                        **");
        System.out.println("====================================");
        System.out.println("Opcion:");
    }

    public static boolean buscarClaveRepetida(int dni, ListaOrdenada list){
        boolean busqueda = false;
        ListaOrdenada ax = list;

        if (ax.listaVacia()) {
            Consola.emitirMensajeLN("Lista Vacia!!");
        } else {
            while (!ax.listaVacia()) {
                Proveedor prov = ax.eliminar().getDato();
                if (prov.getDni() == dni) {
                    busqueda = true;
                }
            }
        }

        if (busqueda) {
            Consola.emitirMensajeLN("Elemento existente");
        } else {
            Consola.emitirMensajeLN("Elemento no encontrado");
        }

        return busqueda;
    }

    public static boolean buscarDni(int dni, ListaOrdenada list){
        boolean busqueda = false;
        ListaOrdenada ax = list;

        if (ax.listaVacia()) {
            Consola.emitirMensajeLN("Lista Vacia");
        } else {
            while (!ax.listaVacia()) {
                Proveedor prov = ax.eliminar().getDato();
                if (prov.getDni() == dni) {
                    busqueda = true;
                }
            }
        }

        return busqueda;
    }

    public static void buscarYMostrar(int dni, ListaOrdenada list){
        ListaOrdenada ax = list;
        boolean busqueda = false;

        if (ax.listaVacia()) {
            Consola.emitirMensajeLN("Lista Vacia");
        } else {
            while(!ax.listaVacia()){
                Proveedor prov = ax.eliminar().getDato();
                if (prov.getDni() == dni) {
                    Consola.emitirMensajeLN("\tInformacion del Proveedor\n" + prov.toString());
                    busqueda = true;
                }
            }
        }
    }

}
