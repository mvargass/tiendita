package model;

import java.util.Date;

/**
 *
 * @author Mario
 */
public class CuentaCorriente {
    private int id;
    private Persona cliente;
    private Documento Documento;
    private double cargo;
    private double abono;
    private Date fecha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Persona getCliente() {
        return cliente;
    }

    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }

    public Documento getDocumento() {
        return Documento;
    }

    public void setDocumento(Documento Documento) {
        this.Documento = Documento;
    }

    public double getCargo() {
        return cargo;
    }

    public void setCargo(double cargo) {
        this.cargo = cargo;
    }

    public double getAbono() {
        return abono;
    }

    public void setAbono(double abono) {
        this.abono = abono;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    @Override
    public int hashCode(){
        return this.id;
    }
}
