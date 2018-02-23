package view;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.table.DefaultTableModel;
import model.DbData;
import model.Documento;
import model.TipoPago;
import utils.Utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Erick
 */
public class ReporteCredito extends javax.swing.JFrame {

    private final DbData<Documento> controller;
    private ArrayList<Documento> lista;
    private int i;
    /**
     * Creates new form ReporteCredito
     */
    public ReporteCredito() {
        initComponents();
        controller = new DbData(Documento.class, "documento.txt");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Inicio = new javax.swing.JButton();
        tituloPrincipal = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        creditos = new javax.swing.JTable();
        ImportarDatos = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Inicio.setText("Pagina Principal");
        Inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InicioActionPerformed(evt);
            }
        });

        tituloPrincipal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tituloPrincipal.setText("Detalle de Creditos");

        creditos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo cliente", "Nombre Cliente", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        creditos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                creditosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(creditos);

        ImportarDatos.setText("Importar Datos");
        ImportarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImportarDatosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(tituloPrincipal))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ImportarDatos)
                            .addComponent(Inicio))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(tituloPrincipal)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(ImportarDatos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Inicio)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InicioActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_InicioActionPerformed

    private void ImportarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImportarDatosActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            lista = controller.getAll()
                    .stream()
                    .filter(x -> x.getTipoPago().get(0) == TipoPago.CxC)
                    .collect(Collectors.toCollection(()-> new ArrayList<>()));
            lista.sort((x1,x2)-> x1.getCliente().getCodigoCliente().compareTo(x2.getCliente().getCodigoCliente()));
            mostrar();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReporteContado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_ImportarDatosActionPerformed

    private void creditosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_creditosMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() ==2){
            CuentaCorrienteDetalle detalle = new CuentaCorrienteDetalle(creditos.getValueAt(creditos.getSelectedRow(), 0).toString());
            detalle.setVisible(true);
        }
    }//GEN-LAST:event_creditosMouseClicked

    public void mostrar(){
        
        Map<String, Double> list = lista.stream().collect(Collectors.groupingBy((x) -> x.getCliente().getCodigoCliente(), Collectors.summingDouble(x->x.getTotalDocumento())));
        System.out.println(list);
        System.out.println(list.size());
        i=0;
        String matris[][]=new String[list.size()][3];
        list.forEach((k,v)->  {
            try {
                System.out.println(k + " " + v);
                matris[i][0]= k;
                matris[i][1] = Utils.findCliente(k).getNombre();
                matris[i][2] = String.valueOf(v);
                i++;
            } catch (FileNotFoundException | NoSuchElementException ex) {
                Logger.getLogger(ReporteCredito.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        DefaultTableModel model = new DefaultTableModel(matris, new String [] {
                "Codigo Cliente", "Nombre Cliente", "Total "
            }){
                @Override
                public boolean isCellEditable(int row, int column){
                    return false;
                }  
            };
          creditos.setModel(model);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReporteCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReporteCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReporteCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReporteCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReporteCredito().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ImportarDatos;
    private javax.swing.JButton Inicio;
    private javax.swing.JTable creditos;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel tituloPrincipal;
    // End of variables declaration//GEN-END:variables
}
