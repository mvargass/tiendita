
package utils.realizarreportes;

import java.util.Date;

/* PARTE DE GENERAR REPORTE DE VENTA EN EXCEL GRUPO 1*/

public class Venta {
    private Integer numero;
    private Integer Id;
    private String codigo;
    private String nombre;
    private String nit;
    private String serie;
    private Double total;
    private Date fecha;

    public Venta(Integer numero, Integer Id, String codigo, String nombre, String nit, String serie, Double total, Date fecha) {
        this.numero = numero;
        this.Id = Id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.nit = nit;
        this.serie = serie;
        this.total = total;
        this.fecha = fecha;
    }

    public Venta(){
    this.numero = 0;
        this.Id = 0;
        this.codigo = "";
        this.nombre = "";
        this.nit = "";
        this.serie = "";
        this.total = 0.00;
    
    }
    
    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    
}
