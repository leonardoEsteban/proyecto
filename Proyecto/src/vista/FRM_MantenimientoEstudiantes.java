/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador_FRM_MantenimientoEstudiantes;
import javax.swing.JOptionPane;

/**
 *
 * @author Sofia y Leonardo
 */
public class FRM_MantenimientoEstudiantes extends javax.swing.JFrame {

    public Controlador_FRM_MantenimientoEstudiantes controlador_FRM_MantenimientoEstudiantes;
    FRM_Login frm_login;

    public FRM_MantenimientoEstudiantes(FRM_Login frm_login) {
        initComponents();
        setVisible(false);
        this.setLocation(250, 200);
        this.frm_login = frm_login;
        controlador_FRM_MantenimientoEstudiantes = new Controlador_FRM_MantenimientoEstudiantes(this, frm_login);
        this.panel_Botones1.agregarEventos(controlador_FRM_MantenimientoEstudiantes);
        this.panel_InformacionBasica1.agregarEventos(controlador_FRM_MantenimientoEstudiantes);
        
        this.habilitarBotonBuscar();
        this.habilitarBusquedaRapida();
        this.habilitarCedula();
        this.deshabilitarCampos();
        
    }

    public String[] devolverInformacion() {
        return this.panel_InformacionBasica1.devolverInformacion();
    }

    public String devolverCedula() {
        return this.panel_InformacionBasica1.devolverCedula();

    }

    public void mostrarInformacionBD_AP(String arreglo[]) {
        this.panel_InformacionBasica1.mostrarInformacionBD_AP(arreglo);
    }
    
    public void mostrarInformacionXML(String arreglo[]) {
        this.panel_InformacionBasica1.mostrarInformacionXML(arreglo);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public void limpiar() {
        this.panel_InformacionBasica1.limpiar();
    }
    
    ////////////////////////////////////////////////////////////////////////////
    public void habilitarCampos() {
        this.panel_InformacionBasica1.habilitarCampos();
    }

    public void deshabilitarCampos() {
        this.panel_InformacionBasica1.deshabilitarCampos();
    }

    

    public void deshabilitarCedula() {
        this.panel_InformacionBasica1.deshabilitarCedula();
    }

    public void habilitarCedula() {
        this.panel_InformacionBasica1.habilitarCedula();
    }

    /////////////////////////////////////////////////////
    public void deshabilitarBusquedaRapida() {
        this.panel_InformacionBasica1.deshabilitarBusquedaRapida();
    }

    public void habilitarBusquedaRapida() {
        this.panel_InformacionBasica1.habilitarBusquedaRapida();
    }
    
    public void habilitarAgregar() {
        this.panel_Botones1.habilitarAgregar();
    }

    public void habilitarBotones() {
        this.panel_Botones1.habilitarBotones();
    }
    
    public void habilitarBotonBuscar() {
        this.panel_Botones1.habilitarBotonBuscar();
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_Botones1 = new vista.Panel_Botones();
        panel_InformacionBasica1 = new vista.Panel_InformacionBasica();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(panel_InformacionBasica1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(panel_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_InformacionBasica1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private vista.Panel_Botones panel_Botones1;
    private vista.Panel_InformacionBasica panel_InformacionBasica1;
    // End of variables declaration//GEN-END:variables
}
