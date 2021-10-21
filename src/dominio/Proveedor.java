package dominio;

import utilidad.Consola;
import interfaces.Comparador;

/**
 * @author Luis Roberto Cruz
 * @version 1.0.0
 * 
 * Clase que hace referencia a un Proveedor
 */

public class Proveedor implements Comparador{
    
    private int dni;
    private int codigoRubro;
    private String apellido;
    private String direccion;
    private String contacto;
    private String eMail;

    public Proveedor(){
        this.dni = 0;
        this.codigoRubro = 0;
        this.apellido = "";
        this.direccion = "";
        this.contacto = "";
        this.eMail = "";
    }

    public Proveedor(int dni, String apellido, String direccion, String contacto, String eMail, int codigoRubro){
        this.dni = dni;
        this.codigoRubro = codigoRubro;
        this.apellido = apellido;
        this.direccion = direccion;
        this.contacto = contacto;
        this.eMail = eMail;
    }

    public void setDni(int dni){
        this.dni = dni;
    }

    public void setCodigoRubro(int codigoRubro){
        this.codigoRubro = codigoRubro;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

    public void setContacto(String contacto){
        this.contacto = contacto;
    }

    public void setEMail(String eMail){
        this.eMail = eMail;
    }

    public int getDni(){
        return dni;
    }

    public int getCodigoRubro(){
        return codigoRubro;
    }

    public String getApellido(){
        return apellido;
    }

    public String getDireccion(){
        return direccion;
    }

    public String getContacto(){
        return contacto;
    }

    public String getEMail(){
        return eMail;
    }

    public void cargarInformacion(){
        cargarDni();
        cargarCodigoRubro();
        cargarApellido();
        cargarDireccion();
        cargarContacto();
        cargarEMail();
    }

    public void actualizarDatos(){
        int op = 0;

        do {
            menuActualizacion();
            op = Consola.leerInt();

            switch(op){
                case 1:
                    cargarDni();
                    break;
                case 2:
                    cargarCodigoRubro();
                    break;
                case 3:
                    cargarApellido();
                    break;
                case 4:
                    cargarDireccion();
                    break;
                case 5:
                    cargarContacto();
                    break;
                case 6:
                    cargarEMail();
                    break;
                case 7:
                    cargarInformacion();
                    break;
                case 0:
                    Consola.emitirMensajeLN("Actualizacion cerrada");
                    break;
                default:
                    Consola.emitirMensajeLN("Operacion Invalida...");
                    break;
            }

        } while (op != 0);
    }

    private void menuActualizacion(){
        Consola.emitirMensajeLN("=====================================");
        Consola.emitirMensajeLN("        Menu de Actualizacion        ");
        Consola.emitirMensajeLN("=====================================");
        Consola.emitirMensajeLN("= 1. DNI                            =");
        Consola.emitirMensajeLN("= 2. Codigo de Rubro                =");
        Consola.emitirMensajeLN("= 3. Apellido                       =");
        Consola.emitirMensajeLN("= 4. Direccion                      =");
        Consola.emitirMensajeLN("= 5. Contacto                       =");
        Consola.emitirMensajeLN("= 6. EMail                          =");
        Consola.emitirMensajeLN("= 7. Todos los Datos                =");
        Consola.emitirMensajeLN("=====================================");
        Consola.emitirMensaje("Operacion:");
    }

    private void cargarDni(){
        Consola.emitirMensaje("DNI:");
        this.dni = Consola.leerInt();
    }

    private void cargarCodigoRubro(){
        Consola.emitirMensaje("Codigo de Rubro:");
        this.codigoRubro = Consola.leerInt();
    }

    private void cargarApellido(){
        Consola.emitirMensaje("Apellido:");
        this.apellido = Consola.leerString();
    }

    private void cargarDireccion(){
        Consola.emitirMensaje("Direccion:");
        this.direccion = Consola.leerString();
    }

    private void cargarContacto(){
        Consola.emitirMensaje("Contacto:");
        this.contacto = Consola.leerString();
    }

    private void cargarEMail(){
        Consola.emitirMensaje("EMail:");
        this.eMail = Consola.leerString();
    }

    @Override
    public String toString(){
        return "\tInformacion del Proveedor\n"
                + "DNI:" + dni + "\n"
                + "Codigo de Rubro:" + codigoRubro + "\n"
                + "Apellido:" + apellido + "\n"
                + "Direccion:" + direccion + "\n"
                + "Contacto:" + contacto + "\n"
                + "EMail:" + eMail + "\n";
    }

    @Override
    public boolean igualQue(Object op2){
        Proveedor x = (Proveedor) op2;
        return this.dni == x.getDni();
    }

    @Override
    public boolean menorQue(Object op2){
        Proveedor x = (Proveedor) op2;
        return this.dni < x.getDni();
    }

    @Override
    public boolean menorIgualQue(Object op2){
        Proveedor x = (Proveedor) op2;
        return this.dni <= x.getDni();
    }

    @Override
    public boolean mayorQue(Object op2){
        Proveedor x = (Proveedor) op2;
        return this.dni > x.getDni();
    }

    @Override
    public boolean mayorIgualQue(Object op2){
        Proveedor x = (Proveedor) op2;
        return this.dni >= x.getDni();
    }

}
