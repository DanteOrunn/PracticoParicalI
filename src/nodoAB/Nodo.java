package nodoAB;

public class Nodo {

    private Object dato;
    private int dni;
    private Nodo izdo;
    private Nodo dcho;

    public Nodo(Object valor, int dni) {
        this.dato = valor;
        this.dni = dni;
        this.izdo = dcho = null;
    }

    public Nodo(Nodo ramaIzdo, Object valor, Nodo ramaDcho, int dni) {
        this.dato = valor;
        this.dni = dni;
        this.izdo = ramaIzdo;
        this.dcho = ramaDcho;
    }
    //  operaciones de acceso

    public Object getDato() {
        return dato;
    }

    public Nodo getIzdo() {
        return izdo;
    }

    public Nodo getDcho() {
        return dcho;
    }

    public int getDni(){
        return dni;
    }

    public void setDato(Object d) {
        dato = d;
    }

    public void setIzdo(Nodo n) {
        izdo = n;
    }

    public void setDcho(Nodo n) {
        dcho = n;
    }

    public void setDni(int dni){
        this.dni = dni;
    }

    public void imprimirDato() {
        System.out.print(dato.toString() + "\n\n");
    }
}
