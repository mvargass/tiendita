/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacion;

import java.io.FileNotFoundException;
import model.Cliente;
import model.DbData;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Documento;
import model.TipoTransaccion;

/**
 *
 * @author Mario
 */
public class Facturacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Documento documento = new Documento();
        DbData<Cliente> clientController = new DbData(Cliente.class,"cliente.txt");
        DbData<Documento> documentController = new DbData(Documento.class,"documento.txt");
        Calendar c = Calendar.getInstance();
        
        try {
            documento = documentController.getAll().get(0);
            System.out.print(documento.getCliente().getNombre());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Facturacion.class.getName()).log(Level.SEVERE, null, ex);
        } 
       
        
    }
    
}
