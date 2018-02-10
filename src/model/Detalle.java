package model;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Mario
 * modelo que contiene el detalle de las transacciones de la compra
 */
public class Detalle {
    private int id;
    private Documento documento;
    private int cantidad;
    private Producto producto;
    @SerializedName("subtotal")
    private double total;
    private TipoTransaccion tipoTransaccion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }
    
    
}
