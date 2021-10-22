package principal;

import utilidad.*;
import dominio.*;
import estructuras.ArbolBinarioBusqueda;
import nodoAB.*;

public class Principal {

    public static void main(String[] args) {

        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();
        ListaOrdenada list = new ListaOrdenada();
        int op = 0;

        do {

            menu();
            op = Consola.leerInt();

            switch (op) {
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
                    ListaOrdenada p = list;
                    ArbolBinarioBusqueda b = arbol;
                    arbol = cargarArbol(p, b);
                    Consola.emitirMensajeLN("\n=================================");
                    Consola.emitirMensajeLN("=         Arbol Generado        =");
                    Consola.emitirMensajeLN("=================================\n");
                } else {
                    Consola.emitirMensajeLN("\n=================================");
                    Consola.emitirMensajeLN("=          Lista Vacia          =");
                    Consola.emitirMensajeLN("=================================\n");
                }
                break;
            case 3:
                if (!arbol.esVacio()) {
                    Proveedor provBuscado = new Proveedor();
                    
                    Consola.emitirMensaje("DNI:");
                    int dniBuscado = Consola.leerInt();
                    provBuscado.setDni(dniBuscado);

                    Nodo nodoBuscado = arbol.buscar(provBuscado);
                    
                    if (nodoBuscado != null){
                        Proveedor muestra = (Proveedor) nodoBuscado.getDato();
                        Consola.emitirMensajeLN("=========================================");
                        Consola.emitirMensajeLN("        Informacion del Proveedor        ");
                        Consola.emitirMensajeLN("=========================================");
                        muestra.mostrarDatos();

                        if (validarActualizacion()) {
                            muestra.actualizarDatos();
                            list.insertar(muestra);
                            arbol.insertar(muestra, dniBuscado);
                        }

                    } else {
                        Consola.emitirMensajeLN("Proveedor no encontrado en el arbol");
                    }

                } else {
                    Consola.emitirMensajeLN("\n=================================");
                    Consola.emitirMensajeLN("=          Arbol Vacio!          =");
                    Consola.emitirMensajeLN("=================================\n");
                }
                break;
            case 4:
                if (!arbol.esVacio()) {
                    mostrarXCodigoRubro(arbol);
                } else {
                    Consola.emitirMensajeLN("\n=================================");
                    Consola.emitirMensajeLN("=          Arbol Vacio!          =");
                    Consola.emitirMensajeLN("=================================\n");
                }
                break;
            case 0:
                break;
            default:
                break;
            }

        } while (op != 0);

    }

    public static void menu() {
        System.out.println("====================================");
        System.out.println("**        MENU DE OPCIONES        **");
        System.out.println("====================================");
        System.out.println("** 1-Crear Lista de Proveedores   **");
        System.out.println("** 2-Generar Arbol de Proveedores **");
        System.out.println("** 3-Buscar Proveedor             **");
        System.out.println("** 4-Listar Proveedores           **");
        System.out.println("** 0-Salir                        **");
        System.out.println("====================================");
        System.out.print("Opcion:");
    }

    public static boolean validarActualizacion(){
        Consola.emitirMensaje("¿Desea actualizar los Datos?\n");
        boolean validar = Consola.confirmar();

        return validar;
    }

    public static boolean buscarClaveRepetida(int dni, ListaOrdenada lista) {
        boolean busqueda = false;
        ListaOrdenada ax = lista;

        if (ax.listaVacia()) {
            Consola.emitirMensajeLN("\n=================================");
            Consola.emitirMensajeLN("=          Lista Vacia          =");
            Consola.emitirMensajeLN("=================================\n");
        } else {
            while (!ax.listaVacia()) {
                Proveedor prov = ax.eliminar().getDato();
                if (prov.getDni() == dni) {
                    busqueda = true;
                }
            }
        }

        if (busqueda) {
            Consola.emitirMensajeLN("\n=================================");
            Consola.emitirMensajeLN("=      Elemento existente       =");
            Consola.emitirMensajeLN("=================================\n");
        } else {
            Consola.emitirMensajeLN("\n=================================");
            Consola.emitirMensajeLN("=      Agregacion Realizada      =");
            Consola.emitirMensajeLN("==================================\n");
        }

        return busqueda;
    }

    public static boolean buscarDni(int dni, ListaOrdenada lista) {
        boolean busqueda = false;
        ListaOrdenada ax = lista;

        if (ax.listaVacia()) {
            Consola.emitirMensajeLN("\n=================================");
            Consola.emitirMensajeLN("=          Lista Vacia          =");
            Consola.emitirMensajeLN("=================================\n");
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

    public static void buscarYMostrar(int dni, ListaOrdenada lista) {
        ListaOrdenada ax = lista;

        if (ax.listaVacia()) {
            Consola.emitirMensajeLN("\n=================================");
            Consola.emitirMensajeLN("=          Lista Vacia          =");
            Consola.emitirMensajeLN("=================================\n");
        } else {
            while (!ax.listaVacia()) {
                Proveedor prov = ax.eliminar().getDato();
                if (prov.getDni() == dni) {
                    Consola.emitirMensajeLN("\tInformacion del Proveedor\n");
                    prov.mostrarDatos();
                }
            }
        }
    }

    public static ArbolBinarioBusqueda cargarArbol(ListaOrdenada lista, ArbolBinarioBusqueda arbolBB){
        while (!lista.listaVacia()) {
            Proveedor prov = lista.eliminar().getDato();
            int axDni = prov.getDni();
            arbolBB.insertar(prov, axDni);
        }
        return arbolBB;
    }

    public static void mostrarXCodigoRubro(ArbolBinarioBusqueda arbolBB){
        ArbolBinarioBusqueda axArbol = arbolBB;

        Consola.emitirMensaje("Codigo de Rubro:");
        int codigoBuscado = Consola.leerInt();

        while (!axArbol.esVacio()) {
            
        }
    }

}
