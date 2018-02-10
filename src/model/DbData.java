
package model;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Mario
 * Clase que se encarga de guardar los datos en archivos de texto en formato 
 * JSON
 */
public class DbData <T> {
    private String ruta;
    private Class<T> type;
    
    /**
     * Constructor, inializa las propiedades de la clase
     * @param t Clase que servira de modelo para serializar y deserializar los 
     * objetos json
     * @param ruta ruta y nombre del archivo en el que se guardan los datos
     */
    public DbData(Class<T> t, String ruta){
        this.ruta = ruta;
        type = t;
    }
    
    /**
     * Agrega un nuevo registro al archivo seleccionado
     * @param t objeto generico de la clase que se guardara en formato JSON
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void add(T t) throws FileNotFoundException, IOException{
        File file = new File(this.ruta);
        List<String> lines = new ArrayList<>();
        Gson gson = new Gson();
        if(file.exists()){
            Scanner s = new Scanner(file);
            while(s.hasNextLine()){
                lines.add(s.nextLine());
            }
        }
        FileWriter fileWriter = new FileWriter(file);
        for(String line: lines){
            fileWriter.write(line+ System.getProperty("line.separator"));
        }
        fileWriter.append(gson.toJson(t));
        fileWriter.flush();
        fileWriter.close();
    }
    
    /**
     * Devuelve una lista con el conjunto de datos almacenados en el archivo
     * seleccionado 
     * @return List de tipo generico
     * @throws FileNotFoundException 
     */
    public List<T> getAll() throws FileNotFoundException{
        File file = new File(this.ruta);
        List<T> generic = new ArrayList<>();
        Gson gson = new Gson();
        if(file.exists()){
            Scanner s = new Scanner(file);
            while(s.hasNextLine()){
                generic.add(gson.fromJson(s.nextLine(), this.type));
            }
        }
        return generic;
    }
}
