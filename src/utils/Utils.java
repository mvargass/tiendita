/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;
import model.Cliente;
import model.DbData;

/**
 *
 * @author Mario
 */
public class Utils {
    
    public static Cliente findCliente(String codigo) throws FileNotFoundException, NoSuchElementException{
        DbData<Cliente> clienteController=new DbData(Cliente.class, "cliente.txt");
        List<Cliente> clients = clienteController.getAll();
        boolean exist = clients.stream()
                .filter(x -> x.getCodigoCliente().toLowerCase().equals(codigo.toLowerCase()))
                .findFirst().isPresent();
        if(exist){
            return clients.stream()
                .filter(x -> x.getCodigoCliente().toLowerCase().equals(codigo.toLowerCase()))
                .findFirst().get();
        }else return null;
    }
    
}
