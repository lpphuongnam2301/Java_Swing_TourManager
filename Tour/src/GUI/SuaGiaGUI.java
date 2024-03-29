/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import BLL.GiatourBLL;
import DTO.GiaTourDTO;
import static GUI.GiaGUI.table;
import static GUI.GiaGUI.row;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author nngia
 */
public class SuaGiaGUI extends javax.swing.JFrame {

    /**
     * Creates new form ThemGiaGUI
     */
    public static int row;
    public SuaGiaGUI() {
        initComponents();
        load();
        setLocationRelativeTo(null);
    }
    public void load(){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        tientxt.setText(model.getValueAt(table.getSelectedRow(),1).toString());
        try{
            date.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(table.getSelectedRow(),2).toString()));
        }catch(Exception e){
            System.out.println(e);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        date = new com.toedter.calendar.JDateChooser();
        tientxt = new javax.swing.JTextField();
        btn = new javax.swing.JButton();
        label = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        date.setDateFormatString("dd/MM/yyyy");
        getContentPane().add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 178, 30));

        tientxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tientxtActionPerformed(evt);
            }
        });
        getContentPane().add(tientxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 178, 31));

        btn.setText("Xác nhận");
        btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });
        getContentPane().add(btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 113, 35));

        label.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N
        label.setForeground(new java.awt.Color(255, 0, 0));
        label.setText("Sửa giá tour");
        getContentPane().add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 270, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel12.setText("Từ ngày:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, 30));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel13.setText("Số tiền:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tientxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tientxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tientxtActionPerformed

    private void btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionPerformed
        // TODO add your handling code here:
        String tb = "",ngay="";
        double tien=0;
        try{
            if(!date.getDate().after(new Date())){
                tb+="Ngày đã qua.Kiểm tra lại\n";
            }else{
                ngay = new SimpleDateFormat("yyyy-MM-dd").format(date.getDate());
            }
        }catch(Exception e){
            tb+="Ngày không được để trống\n";
        }
       
        if(tientxt.getText().equals("")){
            tb+="Tiền không được để trống\n";
        }else{
            try{
                tien = Double.parseDouble(tientxt.getText().toString());
            }catch(Exception e){
                tb+="Số tiền không hợp lệ\n";
            }
        }
        if(!tb.equals("")){
             JOptionPane.showMessageDialog(null,tb);
        }else{
            if(new GiatourBLL().sua(new GiaTourDTO(Integer.parseInt(table.getValueAt(table.getSelectedRow(),0).toString()),row,Double.parseDouble(tientxt.getText().toString()),ngay))){
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setValueAt(Double.toString(tien),table.getSelectedRow(),1);
                model.setValueAt(ngay,table.getSelectedRow(),2);
                table.setModel(model);
                JOptionPane.showMessageDialog(null,"Thành công");
                this.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null,"Thất bại");
            }
        }
    }//GEN-LAST:event_btnActionPerformed

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
            java.util.logging.Logger.getLogger(SuaGiaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SuaGiaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SuaGiaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SuaGiaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SuaGiaGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel label;
    private javax.swing.JTextField tientxt;
    // End of variables declaration//GEN-END:variables
}
