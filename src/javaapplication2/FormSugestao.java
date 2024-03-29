/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication2;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nit0
 */
public class FormSugestao extends javax.swing.JFrame {

    /**
     * Creates new form FormSugestao
     */
    Manipulacao m = new Manipulacao();
    public FormSugestao() throws ClassNotFoundException, SQLException {
        Banco bd = new Banco();
        bd.consultarSugetao();
        initComponents();
        String msg = m.getSugestao();
        if (msg != null)
            txtOpiniao.setText("\""+m.getSugestao()+"\" \n\n"+m.getNome());
        else
            txtOpiniao.setText("");
        
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtOpiniao = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setText("Opiniões dos participantes");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, -1, -1));

        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(240, 240, 240));
        jScrollPane1.setToolTipText("");
        jScrollPane1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtOpiniao.setEditable(false);
        txtOpiniao.setBackground(new java.awt.Color(240, 240, 240));
        txtOpiniao.setColumns(18);
        txtOpiniao.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtOpiniao.setLineWrap(true);
        txtOpiniao.setRows(5);
        txtOpiniao.setWrapStyleWord(true);
        txtOpiniao.setBorder(null);
        txtOpiniao.setSelectedTextColor(new java.awt.Color(240, 240, 240));
        txtOpiniao.setSelectionColor(new java.awt.Color(240, 240, 240));
        jScrollPane1.setViewportView(txtOpiniao);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 960, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FormSugestao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormSugestao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormSugestao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormSugestao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FormSugestao().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FormSugestao.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(FormSugestao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtOpiniao;
    // End of variables declaration//GEN-END:variables
}
