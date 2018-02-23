
package utils.realizarreportes;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import model.Cliente;
import model.DbData;
import model.Documento;
import model.TipoPago;
import utils.Rps.Reports;

public class GestorVenta {
    private Reports re;
    private Scanner sc;
    public List<Documento> arrg;
    private Calendar today;
    private DbData<Documento> controller;
    /* PARTE DE GENERAR REPORTE DE VENTA EN EXCEL GRUPO 1*/
    
    public GestorVenta(List<Documento> arrg, Cliente nodo2) {
        this.arrg = arrg;
        this.controller = new DbData(Documento.class, "documento.txt");
    }

    public List<Documento> getArrg() {
        return arrg;
    }
    
    public GestorVenta(){
        arrg = new ArrayList<>();
        re = new Reports();
        sc = new Scanner(System.in);
        today = Calendar.getInstance();
        this.controller = new DbData(Documento.class, "documento.txt");
    }
    
    public String parseDate(Date date){
        Calendar c = Calendar.getInstance();
        SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd"); 
        c.setTime(date);
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE,0);
        c.set(Calendar.MILLISECOND, 0);
        System.out.println(c.getTime());
        return dt.format(c.getTime());
    }
    
    public void generar_reporte() throws FileNotFoundException{
        today.set(Calendar.HOUR, 0);
        today.set(Calendar.MINUTE,0);
        today.set(Calendar.MILLISECOND, 0);
        SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd");
        System.out.println(today.getTime());
        arrg = controller.getAll().stream()
                .filter((x)-> x.getTipoPago().get(0)!= TipoPago.CxC && parseDate(x.getFecha()).equals(dt.format(today.getTime())))
                .collect(Collectors.toCollection(()->new ArrayList<>()));
        
        arrg.forEach(x-> System.out.println());
        re.generar_(arrg);
    }
}
