/*
 * To1 change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador_FRM_Matricula;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.MetodosMatricula;

/**
 *
 * @author Sofia y Leonardo
 */
public class FRM_Matricula extends javax.swing.JFrame {

    /**
     * Creates new form FRM_Matricula
     */
    DefaultTableModel modelo;
    Controlador_FRM_Matricula controlador;
    MetodosMatricula metodosMatricula;
    FRM_Login frm_login;

    public FRM_Matricula(FRM_MantenimientoEstudiantes frm_MantenimientoEstufiantes, FRM_MantenimientoCursos frm_MantenimientoCursos, FRM_Login frm_login) {
        initComponents();
        setLocation(200, 200);
        this.frm_login = frm_login;
        controlador = new Controlador_FRM_Matricula(frm_MantenimientoEstufiantes, frm_MantenimientoCursos, this, frm_login);
        agregarEventos();
        metodosMatricula = controlador.metodosMatricula;
        modelo = new DefaultTableModel();
        colocarTitulosTabla();
        
    }

    public void agregarInformacionTabla() {
        String arreglo[] = new String[4];
        arreglo[0] = this.jt_CodigoMatricula.getText();
        arreglo[1] = this.jt_Cedula.getText();
        arreglo[2] = this.jt_NombreEstudiante.getText();
        arreglo[3] = this.jt_Sigla.getText();
        modelo.addRow(arreglo);
    }

    public void agregarInformacionTabla(String arreglo[]) {
        modelo.addRow(arreglo);
        colocarNombreEstudiante(arreglo[2]);
        this.jt_Cedula.setText(arreglo[1]);
    }

    public void agregarEventos() {
        this.btn_ConsultaRapidaCedula.addActionListener(controlador);
        this.btn_ConsultaRapidaSigla.addActionListener(controlador);
        this.btn_Finalizar.addActionListener(controlador);
        this.panel_Botones1.agregarEventos(controlador);
    }

    public void resetearVentana() {
        this.jt_Cedula.setText("");
        this.jt_NombreEstudiante.setText("");
        this.jt_Sigla.setText("");
        this.jt_NombreCurso.setText("");

        int tamanio = modelo.getRowCount();

        for (int contador = 0; contador < tamanio; contador++) {
            modelo.removeRow(0);

        }
    }

    public void cargarInformacionTabla(String arreglo[]) {
        modelo.addRow(arreglo);
    }

    public void limpiar() {
        this.jt_Cedula.setText("");
        this.jt_NombreEstudiante.setText("");
        this.jt_Sigla.setText("");
        this.jt_NombreCurso.setText("");

        for (int contador = 0; contador < modelo.getRowCount(); contador++) {
            modelo.removeRow(contador);

        }
    }

    public int devolverFilaSeleccionada() {
        return this.tbl_Tabla.getSelectedRow();
    }

    public void limpiarSigla() {
        this.jt_Sigla.setText("");
        this.jt_NombreCurso.setText("");
    }

    public String devolverCedula() {
        return this.jt_Cedula.getText();
    }

    public String devolverSigla() {
        return this.jt_Sigla.getText();
    }

    public String devolverCodigo() {
        return this.jt_CodigoMatricula.getText();
    }

    public void colocarNombreEstudiante(String nombre) {
        this.jt_NombreEstudiante.setText(nombre);
    }

    public String devolverDato(int fila, int columna) {
        return "" + modelo.getValueAt(fila, columna);
    }

    public void colocarNombreCurso(String nombre) {
        this.jt_NombreCurso.setText(nombre);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public void colocarTitulosTabla() {
        this.tbl_Tabla.setModel(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("Cédula");
        modelo.addColumn("Nombre Est.");
        modelo.addColumn("Sigla");
    }

    /////////////////////////////////////////////////
    public void habilitarAgregar() {
        this.panel_Botones1.habilitarAgregar();
    }

    public void habilitarBotones() {
        this.panel_Botones1.habilitarBotones();
    }

    public void habilitarBotonBuscar() {
        this.panel_Botones1.habilitarBotonBuscar();
    }

     //////////////////////////////////////////////////////
    public void colocarCodigo() {
        this.jt_CodigoMatricula.setText(metodosMatricula.devolverCodigo());

    }

    public int getCantidadFilas() {
        return modelo.getRowCount();
    }

    public void mostrarInformacion(String arreglo[]) {
        this.jt_Cedula.setText(arreglo[0]);
        this.jt_NombreEstudiante.setText(arreglo[1]);
        this.jt_Sigla.setText(arreglo[2]);
    }

    public String[] devolverMatriculaSeleccionada() {
        String arreglo[] = new String[2];
        arreglo[0] = "" + modelo.getValueAt(tbl_Tabla.getSelectedRow(), 0);
        arreglo[1] = "" + modelo.getValueAt(tbl_Tabla.getSelectedRow(), 3);

        return arreglo;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jt_Cedula = new javax.swing.JTextField();
        btn_ConsultaRapidaCedula = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jt_NombreEstudiante = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jt_Sigla = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jt_NombreCurso = new javax.swing.JTextField();
        btn_ConsultaRapidaSigla = new javax.swing.JButton();
        panel_Botones1 = new vista.Panel_Botones();
        jl_codigoMatricula = new javax.swing.JLabel();
        jt_CodigoMatricula = new javax.swing.JTextField();
        btn_Finalizar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        tbl_Tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbl_Tabla);

        jLabel1.setText("Cédula");

        btn_ConsultaRapidaCedula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        btn_ConsultaRapidaCedula.setActionCommand("ConsultaRapidaCedula");
        btn_ConsultaRapidaCedula.setBorderPainted(false);
        btn_ConsultaRapidaCedula.setContentAreaFilled(false);

        jLabel2.setText("Nombre Estudiante");

        jt_NombreEstudiante.setEnabled(false);

        jLabel3.setText("Sigla");

        jLabel4.setText("Nombre Curso");

        jt_NombreCurso.setEnabled(false);

        btn_ConsultaRapidaSigla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        btn_ConsultaRapidaSigla.setActionCommand("ConsultaRapidaSigla");
        btn_ConsultaRapidaSigla.setBorderPainted(false);
        btn_ConsultaRapidaSigla.setContentAreaFilled(false);

        jl_codigoMatricula.setText("Código Matrícula");

        btn_Finalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ok.png"))); // NOI18N
        btn_Finalizar.setText("Finalizar Matrícula");
        btn_Finalizar.setActionCommand("Finalizar");
        btn_Finalizar.setBorderPainted(false);
        btn_Finalizar.setContentAreaFilled(false);

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel5.setText("Registro de Matrícula");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Finalizar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jt_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jt_NombreEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jl_codigoMatricula))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btn_ConsultaRapidaCedula)
                                        .addGap(41, 41, 41)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jt_Sigla, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jt_NombreCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_ConsultaRapidaSigla))
                                    .addComponent(jt_CodigoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(275, 275, 275)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 20, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(panel_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jt_CodigoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_codigoMatricula))
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_ConsultaRapidaSigla)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jt_Sigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jt_NombreCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(71, 71, 71))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jt_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jt_NombreEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btn_ConsultaRapidaCedula, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panel_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Finalizar)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ConsultaRapidaCedula;
    private javax.swing.JButton btn_ConsultaRapidaSigla;
    private javax.swing.JButton btn_Finalizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jl_codigoMatricula;
    private javax.swing.JTextField jt_Cedula;
    private javax.swing.JTextField jt_CodigoMatricula;
    private javax.swing.JTextField jt_NombreCurso;
    private javax.swing.JTextField jt_NombreEstudiante;
    private javax.swing.JTextField jt_Sigla;
    private vista.Panel_Botones panel_Botones1;
    private javax.swing.JTable tbl_Tabla;
    // End of variables declaration//GEN-END:variables
}
