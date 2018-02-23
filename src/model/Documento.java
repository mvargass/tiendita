package model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Mario
 */
public class Documento {
    @SerializedName("numero")
    private int id;
    private Cliente cliente;
    private String serie;
    @SerializedName("total")
    private double totalDocumento;
    private Date fecha;
    private List<TipoPago> tipoPago;
    @SerializedName("documento relacionado")
    private String documento;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public double getTotalDocumento() {
        return totalDocumento;
    }

    public void setTotalDocumento(double totalDocumento) {
        this.totalDocumento = totalDocumento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<TipoPago> getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(List<TipoPago> tipoPago) {
        this.tipoPago = tipoPago;
    }
    
    @Override
    public int hashCode(){
        return this.id;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}
