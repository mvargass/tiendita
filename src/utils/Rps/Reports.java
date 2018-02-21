
package utils.Rps;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utils.realizarreportes.Venta;
import java.util.ArrayList;
import java.util.Random;

/* PARTE DE GUILLERMO MARROQUIN PARA GENERAR REPORTE DE VENTA EN EXCEL GRUPO 1*/

import java.util.Date;
import model.Cliente;
public class Reports {

    
    
    public void generar_( ArrayList<Venta> ge, ArrayList<Cliente> cl){      
    generar_reportes(ge, cl);
    }
    
    
    public static void generar_reportes(ArrayList<Venta> ge, ArrayList<Cliente> cl){
        Random r = new Random();
        Date mes = new Date();
        Workbook book = new XSSFWorkbook();
        Double cantidadtotal;
        int a;
        
        Sheet sheet = book.createSheet("Productos");
            try{
                InputStream is = new FileInputStream("src\\imagenes\\icono.png");
                byte[] bytes = IOUtils.toByteArray(is);
                int imgIndex = book.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
                is.close();
                    
                CreationHelper help = book.getCreationHelper();
                Drawing draw = sheet.createDrawingPatriarch();
        
                ClientAnchor anchor = help.createClientAnchor();
                anchor.setCol1(0);
                anchor.setRow1(1);
                Picture pict = draw.createPicture(anchor, imgIndex);
                pict.resize(1, 3);
                    
                
                //FORMATO DEL TITULO 1
                CellStyle tituloEstilo = book.createCellStyle();
                tituloEstilo.setAlignment(HorizontalAlignment.CENTER);
                Font fuenteTitulo = book.createFont();
                fuenteTitulo.setBold(true);
                fuenteTitulo.setFontHeightInPoints((short)22);
                tituloEstilo.setFont(fuenteTitulo);
                
                //FORMATO DEL TITULO 2
                CellStyle tituloEstilo2 = book.createCellStyle();
                tituloEstilo2.setAlignment(HorizontalAlignment.CENTER);
                Font fuenteTitulo2 = book.createFont();
                fuenteTitulo2.setBold(true);
                fuenteTitulo2.setFontHeightInPoints((short)18);
                tituloEstilo2.setFont(fuenteTitulo2);
                
                //FORMATO DEL TITULO 3
                CellStyle tituloEstilo3 = book.createCellStyle();
                tituloEstilo3.setAlignment(HorizontalAlignment.CENTER);
                Font fuenteTitulo3 = book.createFont();
                fuenteTitulo3.setBold(false);
                fuenteTitulo3.setFontHeightInPoints((short)14);
                tituloEstilo3.setFont(fuenteTitulo3);
                
                
                //POSICIONAMIENTO DEL TITULO 1
                Row filaTitulo = sheet.createRow(1);
                Cell celdaTitulo = filaTitulo.createCell(1);
                celdaTitulo.setCellStyle(tituloEstilo);
                celdaTitulo.setCellValue("Empresa La ''Tiendita'' S. A.");
                sheet.addMergedRegion(new CellRangeAddress(1, 2, 1, 7));//MARGEN DE TITULO 1
                
                //POSICIONAMIENTO DEL TITULO 2
                Row filaTitulo2 = sheet.createRow(3);
                Cell celdaTitulo2 = filaTitulo2.createCell(1);//fila
                celdaTitulo2.setCellStyle(tituloEstilo2);
                celdaTitulo2.setCellValue("Reporte de Venta");
                sheet.addMergedRegion(new CellRangeAddress(3, 4, 1, 7));//MARGEN DE TITULO 2
                  
                //POSICIONAMIENTO DEL TITULO 3
                Row filaTitulo3 = sheet.createRow(5);
                Cell celdaTitulo3 = filaTitulo3.createCell(1);
                celdaTitulo3.setCellStyle(tituloEstilo3);
                celdaTitulo3.setCellValue(mes.toString());
                sheet.addMergedRegion(new CellRangeAddress(5, 5, 1, 7));//MARGEN DE TITULO 3
                
                //FORMATO DEL ENCABEZADO Y LOS ENCABEZADOS
                String[] cabecera = new String [] {"Numero",  "Id", "Codigo", "Nombre", "Nit", "Serie", "Total", "Fecha"};
                    
                CellStyle headerStyle = book.createCellStyle();
                headerStyle.setFillForegroundColor (IndexedColors.LIGHT_BLUE.getIndex());
                headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                headerStyle.setBorderBottom(BorderStyle.THIN);
                headerStyle.setBorderLeft(BorderStyle.THIN);
                headerStyle.setBorderRight(BorderStyle.THIN);
                headerStyle.setBorderBottom(BorderStyle.THIN);
                
                //FORMATO DEL ENCABEZADO DE LA TABLA
                Font font = book.createFont();
                font.setFontName("Arial");
                font.setBold(true);
                font.setColor(IndexedColors.WHITE.getIndex());
                font.setFontHeightInPoints((short)12);
                headerStyle.setFont(font);
                    
                Row filaEncabezados = sheet.createRow(7);
                
                
                //ESCRIBE LOS ENCABEZADOS DE LA TABLA
                for(int i=0; i< cabecera.length; i++){
                Cell celdaEnzabezado = filaEncabezados.createCell(i);
                celdaEnzabezado.setCellStyle(headerStyle);
                celdaEnzabezado.setCellValue(cabecera[i]);
                }
                    
                CellStyle datos = book.createCellStyle();
                datos.setFillForegroundColor (IndexedColors.WHITE.getIndex());
                datos.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                datos.setBorderBottom(BorderStyle.THIN);
                datos.setBorderLeft(BorderStyle.THIN);
                datos.setBorderRight(BorderStyle.THIN);
                datos.setBorderBottom(BorderStyle.THIN);

                
                int filaDatos = 8;
                cantidadtotal = 0.0;
                
                //EXTRACCION DE LOS OBJETOS DE CLIENTE Y VENTA
                for (int i=0; i<ge.size(); i++){
                    
                    Row folaDatos = sheet.createRow(filaDatos);
                
                //INGRESOS DE LOS DATOS CON OBJETOS DE VENTA Y CLIENTE
                    Cell numero = folaDatos.createCell(0);
                    Cell id = folaDatos.createCell(1);
                    Cell codigo = folaDatos.createCell(2);
                    Cell nit = folaDatos.createCell(4);
                    Cell nombre = folaDatos.createCell(3);
                    Cell serie = folaDatos.createCell(5);
                    Cell total = folaDatos.createCell(6);
                    Cell fecha = folaDatos.createCell(7);
                
                    numero.setCellStyle(datos);//VENTA
                    numero.setCellValue(ge.get(i).getNumero());//VENTA
                    
                    id.setCellStyle(datos);//CLIENTE
                    id.setCellValue(cl.get(i).getId());//CLIENTE

                    codigo.setCellStyle(datos);//CLIENTE
                    codigo.setCellValue(cl.get(i).getCodigoCliente());//CLIENTE

                    nit.setCellStyle(datos);//CLIENTE 
                    nit.setCellValue(cl.get(i).getNit());//CLIENTE
                    
                    nombre.setCellStyle(datos);//CLIENTE
                    nombre.setCellValue(cl.get(i).getNombre());//CLIENTE

                    serie.setCellStyle(datos);//VENTA
                    serie.setCellValue(ge.get(i).getSerie());//VENTA
                    
                    total.setCellStyle(datos);//VENTA
                    total.setCellValue(ge.get(i).getTotal());//VENTA
                    cantidadtotal = cantidadtotal + ge.get(i).getTotal(); 
                    fecha.setCellStyle(datos);//VENTA
                    fecha.setCellValue((ge.get(i).getFecha().toString()));//VENTA
                    filaDatos = filaDatos+1;

                }
                
              
                ////MARGEN DE Venta TOTAL
                 a= 8+ge.size();
                Row filatotal = sheet.createRow(8+ge.size());//y
                
                Cell TotalVenta = filatotal.createCell(6);//x
                TotalVenta.setCellStyle(datos);
                TotalVenta.setCellValue(cantidadtotal);
                Cell Rotulacion = filatotal.createCell(0);
                Rotulacion.setCellStyle(headerStyle);
                Rotulacion.setCellValue("Total Venta");
                Cell Rotulacion2 = filatotal.createCell(7);
                Rotulacion2.setCellStyle(headerStyle);
                Rotulacion2.setCellValue("");
                sheet.addMergedRegion(new CellRangeAddress(a, a, 0, 5));//MARGEN DE TITULO 3
                
                //ajusta la columna al tamaño de los datos
                sheet.autoSizeColumn(0);
                sheet.autoSizeColumn(1);
                sheet.autoSizeColumn(2);
                sheet.autoSizeColumn(3);
                sheet.autoSizeColumn(4);
                sheet.autoSizeColumn(5);
                sheet.autoSizeColumn(6);
                sheet.autoSizeColumn(7);
                
                //COLOCA EL ZOOM A DOCUMENTO
                sheet.setZoom(200);
                
                
                
                r.ints(1, 99999999);//GENERA EL NUMERO DEL DOCUMENTO
                FileOutputStream fileOut = new FileOutputStream("ReporteProductos "+r.nextInt()+".xlsx");
                // ASIGNA EL NOMBRE AL REPORTE DE VENTAS
                book.write(fileOut);//ESCRIBE EL REPORTE .xlsx
                fileOut.close();//CIERRA EL REPORTE

                } catch (FileNotFoundException ex){
                Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
        }
    }        
    }
   

