// ARBOL DE BUSQUEDA BINARIA
package arbolApp;

import nodoAB.Nodo;
import estructuras.ArbolBinarioBusqueda;
import dominio.*;
import utilidad.Consola;

public class ArbolBBAPP {

    private ArbolBinarioBusqueda abb;

    public ArbolBBAPP() {
        abb = new ArbolBinarioBusqueda();
    }

    public void menuDeOpciones(ListaOrdenada list) {
        int option;

        do {
            System.out.println("===============================");
            System.out.println("**      MENU DE OPCIONES     **");
            System.out.println("===============================");
            System.out.println("** 1-Generar Arbol           **");
            System.out.println("** 2-Eliminar Proveedor      **");
            System.out.println("** 3-Imprimir Proveedor/es   **");
            System.out.println("** 0-Salir                   **");
            System.out.println("===============================");
            System.out.print("Ingrese Opcion:");
            option = Consola.leerInt();

            switch (option) {
                case 1:
                    generarArbol(list);
                    break;
                case 2:
                    borrar();
                    break;
                case 3:
                    imprimir();
                    break;
                case 0:
                    Consola.emitirMensajeLN("Adios!!");
                    break;
                default:
                    Consola.emitirMensajeLN("Operacion invalida...");
                    break;
            }
        } while (option != 0);
    }

    public void generarArbol(ListaOrdenada list) {
        while (list.listaVacia()) {
            Proveedor prov = list.eliminar().getDato();
            int axDni = prov.getDni();
            abb.insertar(prov, axDni);
        }
    }

    public boolean continuar() {
        System.out.print("Desea Continuar? Confime S/N");
        String op = Consola.leerString();
        op = op.equalsIgnoreCase("") ? "S" : op;
        return op.toUpperCase().charAt(0) != 'N';
    }

    public void borrar() {
        Proveedor prov = new Proveedor();
        boolean continuar = true;
        Nodo b = null;
        while (continuar) {
            System.out.print("Ingrese el Documento:");
            int docBuscado = Consola.leerInt();
            prov.setDni(docBuscado);
            b = abb.borrar(abb.getRaiz(), null, prov, b);
            if (b != null) {
                System.out.println("EL ELEMENTO ELMINADOS ES: \n" + b.getDato());
            } else {
                System.out.println("EL ELEMENTO NO EXISTE");
            }
            continuar = continuar();
        }
    }

    public void imprimir() {
        int option;
        do {
            System.out.println("================================");
            System.out.println("**     MENU DE IMPRESION      **");
            System.out.println("================================");
            System.out.println("** 1-Imprimir EntreOrden      **");
            System.out.println("** 2-Imprimir PreOrden        **");
            System.out.println("** 3-Imprimir PostOrden       **");
            System.out.println("** 4-Volver al Menu Principal **");
            System.out.println("================================");
            System.out.print("Ingrese Opcion:");
            option = Consola.leerInt();
            switch (option) {
                case 1:
                    abb.entreorden();
                    break;
                case 2:
                    abb.preorden();
                    break;
                case 3:
                    abb.postorden();
                    break;
                case 4:
                    break;
            }
        } while (option != 4);
    }

    public void imprimirPorCodigoRubro(int codigoRubro){
        Proveedor prov = new Proveedor();
        boolean bus = true;
        Nodo b = null;

        while (bus) {
            System.out.print("Ingrese Codigo de Rubro:");
            int codigoBuscado = Consola.leerInt();
            prov.setCodigoRubro(codigoRubro);
            
        }
    }

    public void imprimirAscendente(){
        abb.preorden();
    }
    /*
    public static void main(String[] args) {
        ArbolBBAPP MiArbol = new ArbolBBAPP();
        MiArbol.menuDeOpciones();
    }*/
}