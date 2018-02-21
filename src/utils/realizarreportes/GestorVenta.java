
package utils.realizarreportes;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import model.Cliente;
import utils.Rps.Reports;

public class GestorVenta {
    private Venta nodo;
    private Cliente nodo2;
    private Reports re;
    private Scanner sc;
    public ArrayList<Venta> arrg;
    public ArrayList<Cliente> arrg2;
    private Date dato;

    /* PARTE DE GENERAR REPORTE DE VENTA EN EXCEL GRUPO 1*/
    
    public GestorVenta(Venta nodo, ArrayList<Venta> arrg, Cliente nodo2) {
        this.nodo = nodo;
        this.arrg = arrg;
        this.nodo2 = nodo2;
        this.arrg2 = arrg2;
    }

    public ArrayList<Venta> getArrg() {
        return arrg;
    }
    
    public GestorVenta(){
    nodo = new Venta();
    nodo2 = new Cliente();
    arrg = new ArrayList<Venta>();
    arrg2 = new ArrayList<Cliente>();
    re = new Reports();
    sc = new Scanner(System.in);
    dato = new Date();
    }
    
    public void generar_reporte(){
        re.generar_(arrg, arrg2);
    }
    
    
    public void crear_reporte(){
    for(int i=0; i<4; i++){
        System.out.println("Bienvenido");
    nodo2 = new Cliente();
    nodo2.setId(i+1);
    nodo2.setCodigoCliente("FSFSF " + i);
    nodo2.setNit(i+" 0101"); 
    nodo2.setNombre("Juan "+i);
    arrg2.add(nodo2);
    }
    
    for(int i=0; i<4; i++){
    System.out.println("Bienvenido2");
    nodo = new Venta();
    nodo.setNumero(i+1);
    nodo.setSerie("FASDFAS "+i);
    nodo.setTotal(210.00 + i);
    nodo.setFecha(dato);
    arrg.add(nodo);}
    }
    
    
}
