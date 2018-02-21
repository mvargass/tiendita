package view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Erick
 */
public class Persona2 {
 String numero, nombre, total, fecha;   

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTotal() {
        return total;
    }

    public String getFecha() {
        return fecha;
    }

    public Persona2(String numero, String nombre, String total, String fecha) {
        this.numero = numero;
        this.nombre = nombre;
        this.total = total;
        this.fecha = fecha;
    }
}
