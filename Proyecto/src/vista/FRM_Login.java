/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador_FRM_Login;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import modelo.ArchivosUsuario;

/**
 *
 * @author Sofia y Leonardo
 */
public class FRM_Login extends javax.swing.JFrame {

    public Controlador_FRM_Login controlador_frm_login;
    ArchivosUsuario archivo;
    ButtonGroup botones;
    FRM_VentanaPrincipal frm_ventanaPrincipal;
    FRM_MantenimientoUsuarios frm_mantenimientoUsuarios;

    public FRM_Login() {
        initComponents();
        archivo = new ArchivosUsuario();
        frm_ventanaPrincipal = new FRM_VentanaPrincipal(this);
        frm_mantenimientoUsuarios = new FRM_MantenimientoUsuarios(this);
        controlador_frm_login = new Controlador_FRM_Login(this, archivo,frm_ventanaPrincipal,frm_mantenimientoUsuarios);
        
        agregarEventos(controlador_frm_login);
        
        botones = new ButtonGroup();
        botones.add(jrbArchivosPlanos);
        botones.add(jrbBD);
        botones.add(jrbXML);
    }

    public String botones() {
        String dato = "";
        if (jrbArchivosPlanos.isSelected() == true) {
            dato = "ArchivosPlanos";
        }
        if (jrbBD.isSelected() == true) {
            dato = "BaseDeDatos";
        }
        if (jrbXML.isSelected() == true) {
            dato = "XML";
        }

        return dato;
    }

    public String[] devolverInformacionLogin() {
        String arreglo[] = new String[2];
        arreglo[0] = this.jtNombreUsuario.getText();
        arreglo[1] = this.jpfContrasena.getText();

        return arreglo;
    }

    public void agregarEventos(Controlador_FRM_Login controlador_frm_login) {
        this.btnAceptar.addActionListener(controlador_frm_login);
        this.btnCancelar.addActionListener(controlador_frm_login);
        this.btnRegistro.addActionListener(controlador_frm_login);
    }

    public String[] devolverInformacionDeInicioDeSesion() {
        String arreglo[] = new String[2];
        arreglo[0] = this.jtNombreUsuario.getText();
        arreglo[1] = this.jpfContrasena.getText();
        return arreglo;
    }

    public void mensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public String getJpfContrasena() {
        return jpfContrasena.getText().trim();
    }

    public String getJtNombreUsuario() {
        return jtNombreUsuario.getText().trim();
    }
    
    public void limpiar(){
        this.jtNombreUsuario.setText("");
        this.jpfContrasena.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jlNombreUsuario = new javax.swing.JLabel();
        jlContrasena = new javax.swing.JLabel();
        jtNombreUsuario = new javax.swing.JTextField();
        jpfContrasena = new javax.swing.JPasswordField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnRegistro = new javax.swing.JButton();
        jrbArchivosPlanos = new javax.swing.JRadioButton();
        jrbBD = new javax.swing.JRadioButton();
        jrbXML = new javax.swing.JRadioButton();
        jlMensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlNombreUsuario.setText("Nombre Usuario: ");

        jlContrasena.setText("Contraseña:");

        jtNombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtNombreUsuarioActionPerformed(evt);
            }
        });

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ok.png"))); // NOI18N
        btnAceptar.setActionCommand("Aceptar");
        btnAceptar.setBorderPainted(false);
        btnAceptar.setContentAreaFilled(false);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        btnCancelar.setActionCommand("Cancelar");
        btnCancelar.setBorderPainted(false);
        btnCancelar.setContentAreaFilled(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel1.setText("LOGIN");

        btnRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/users.png"))); // NOI18N
        btnRegistro.setActionCommand("Registro");
        btnRegistro.setBorderPainted(false);
        btnRegistro.setContentAreaFilled(false);

        jrbArchivosPlanos.setText("Archivos Planos.");

        jrbBD.setText("Base de Datos.");

        jrbXML.setText("XML.");

        jlMensaje.setText("Tpo de almacenamiento:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jlMensaje)
                            .addGap(167, 167, 167))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(9, 9, 9)
                            .addComponent(btnAceptar)
                            .addGap(33, 33, 33)
                            .addComponent(btnCancelar)
                            .addGap(18, 18, 18)
                            .addComponent(btnRegistro))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jlNombreUsuario)
                                .addComponent(jlContrasena))
                            .addGap(22, 22, 22)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtNombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                                    .addComponent(jpfContrasena)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jrbArchivosPlanos)
                        .addGap(18, 18, 18)
                        .addComponent(jrbXML)
                        .addGap(18, 18, 18)
                        .addComponent(jrbBD)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNombreUsuario)
                    .addComponent(jtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlContrasena)
                    .addComponent(jpfContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlMensaje)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbArchivosPlanos)
                    .addComponent(jrbXML)
                    .addComponent(jrbBD))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtNombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtNombreUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtNombreUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(FRM_VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRM_VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRM_VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRM_VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRM_Login().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistro;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jlContrasena;
    private javax.swing.JLabel jlMensaje;
    private javax.swing.JLabel jlNombreUsuario;
    private javax.swing.JPasswordField jpfContrasena;
    private javax.swing.JRadioButton jrbArchivosPlanos;
    private javax.swing.JRadioButton jrbBD;
    private javax.swing.JRadioButton jrbXML;
    private javax.swing.JTextField jtNombreUsuario;
    // End of variables declaration//GEN-END:variables
}
