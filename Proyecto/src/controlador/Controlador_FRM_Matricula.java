/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import BaseDatos.ConexionBD;
import XML.Metodos_XML_Cursos;
import XML.Metodos_XML_Estudiantes;
import XML.Metodos_XML_Matricula;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.MetodosCursos;
import modelo.MetodosEstudiantes;
import modelo.MetodosMatricula;
import vista.FRM_Login;
import vista.FRM_MantenimientoCursos;
import vista.FRM_MantenimientoEstudiantes;
import vista.FRM_Matricula;

/**
 *
 * @author Sofia y Leonardo
 */
public class Controlador_FRM_Matricula implements ActionListener {

    MetodosCursos metodosCursos;
    MetodosEstudiantes metodosEstudiantes;
    public MetodosMatricula metodosMatricula;
    FRM_Matricula frm_matricula;
    boolean encontroEstudiante = false;
    boolean encontroCurso = false;
    FRM_Login frm_login;
    ConexionBD conexion;
    Metodos_XML_Estudiantes metodos_XML_Estudiantes;
    Metodos_XML_Cursos metodos_XML_Cursos;
    Metodos_XML_Matricula metodos_XML_Matricula;

    public Controlador_FRM_Matricula(FRM_MantenimientoEstudiantes frm_MantenimientoEstudiantes, FRM_MantenimientoCursos frm_MantenimientoCursos, FRM_Matricula frm_matricula, FRM_Login frm_login) {
        this.metodosCursos = frm_MantenimientoCursos.controlador.metodosCursos;
        this.metodosEstudiantes = frm_MantenimientoEstudiantes.controlador_FRM_MantenimientoEstudiantes.metodosEstudiantes;
        this.frm_matricula = frm_matricula;

        this.metodos_XML_Estudiantes = frm_MantenimientoEstudiantes.controlador_FRM_MantenimientoEstudiantes.metodos_xml;
        this.metodos_XML_Cursos = frm_MantenimientoCursos.controlador.metodos_xml;
        this.metodosMatricula = new MetodosMatricula(metodosEstudiantes, metodosCursos, this);
        this.metodos_XML_Matricula = new Metodos_XML_Matricula(frm_matricula);
        this.frm_login = frm_login;
        conexion = new ConexionBD();
    }

    public void actionPerformed(ActionEvent e) {

        //Consulta rapida Base de datos
        if (e.getActionCommand().equals("ConsultaRapidaCedula")) {
            if (frm_login.botones().equals("BaseDeDatos")) {
                if (conexion.consultarEstudiante(frm_matricula.devolverCedula())) {
                    String arreglo[] = conexion.arregloInformacionEstudiante;
                    frm_matricula.colocarNombreEstudiante(arreglo[0]);
                    encontroEstudiante = true;
                } else {
                    frm_matricula.mostrarMensaje("El estudiante no se encuentra, favor dirigirse al módulo de Mantenimiento Estudiantes");
                }
            } //Consulta rapida Archivos planos
            else if (frm_login.botones().equals("ArchivosPlanos")) {
                if (metodosEstudiantes.consultarEstudiante(frm_matricula.devolverCedula())) {
                    String arreglo[] = metodosEstudiantes.getArregloInformacion();
                    frm_matricula.colocarNombreEstudiante(arreglo[0]);
                    encontroEstudiante = true;
                    
                } else {
                    frm_matricula.mostrarMensaje("El estudiante no se encuentra, favor dirigirse al módulo de Mantenimiento Estudiantes");
                }
            } //Consulta rapida XML
            else {
                buscarEstudianteXML();
            }

        }

        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Consulta rapida sigla
        if (e.getActionCommand().equals("ConsultaRapidaSigla")) {
            if (frm_login.botones().equals("BaseDeDatos")) {
                if (conexion.consultarCurso(frm_matricula.devolverSigla())) {
                    String arreglo[] = conexion.arregloInformacionCurso;
                    frm_matricula.colocarNombreCurso(arreglo[0]);
                    encontroCurso = true;
                } else {
                    frm_matricula.mostrarMensaje("El curso no se encuentra, favor dirigirse al módulo de Mantenimiento Cursos");
                }
            } //Consulta rapida archivos planos
            else if (frm_login.botones().equals("ArchivosPlanos")) {
                if (metodosCursos.consultarCurso(frm_matricula.devolverSigla())) {
                    String arreglo[] = metodosCursos.getArregloInformacion();
                    frm_matricula.colocarNombreCurso(arreglo[0]);
                    encontroCurso = true;
                } else {
                    frm_matricula.mostrarMensaje("El curso no se encuentra, favor dirigirse al módulo de Mantenimiento Cursos");
                }
            } //Consulta rapida XML
            else {
                buscarCursoXML();
            }
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (e.getActionCommand().equals("Agregar")) {
            frm_matricula.agregarInformacionTabla();
            
        }

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Finalizar matricula Base de datos
        if (e.getActionCommand().equals("Finalizar")) {
            if (frm_login.botones().equals("BaseDeDatos")) {
                String arreglo[] = new String[2];
                for (int contador = 0; contador < frm_matricula.getCantidadFilas(); contador++) {
                    arreglo[0] = frm_matricula.devolverCodigo();
                    arreglo[1] = frm_matricula.devolverDato(contador, 1);
                    conexion.registrarMatricula(arreglo);
                    guardarMatriculaDetalle();
                    frm_matricula.habilitarBotonBuscar();
                }

                frm_matricula.resetearVentana();
                encontroEstudiante = false;
                encontroCurso = false;
                frm_matricula.mostrarMensaje("Matricula finalizada exitosamente");
            } //Finalizar matricula Archivos planos
            else if (frm_login.botones().equals("ArchivosPlanos")) {
                String arreglo[] = new String[3];
                for (int contador = 0; contador < frm_matricula.getCantidadFilas(); contador++) {
                    arreglo[0] = frm_matricula.devolverCodigo();
                    arreglo[1] = frm_matricula.devolverDato(contador, 1);
                    arreglo[2] = frm_matricula.devolverDato(contador, 3);
                    metodosMatricula.agregarMatricula(arreglo);
                    metodosMatricula.escribirEnArchivo();
                    frm_matricula.habilitarBotonBuscar();
                }
                frm_matricula.colocarCodigo();
                frm_matricula.resetearVentana();
                encontroEstudiante = false;
                encontroCurso = false;

            } //Finalizar matricula XML
            else {
                String arreglo[] = new String[2];
                for (int contador = 0; contador < frm_matricula.getCantidadFilas(); contador++) {
                    arreglo[0] = frm_matricula.devolverCodigo();
                    arreglo[1] = frm_matricula.devolverDato(contador, 1);
                    metodos_XML_Matricula.agregarMatricula(arreglo);
                    frm_matricula.resetearVentana();
                    frm_matricula.habilitarBotonBuscar();
                }

            }
        }

            /////////////////////////////////////////////////////////////////////////////////////////////////////
            if (e.getActionCommand().equals("Finalizar")) {
                if (frm_login.botones().equals("BaseDeDatos")) {
                    String arreglo[] = new String[3];
                    for (int contador = 0; contador < frm_matricula.getCantidadFilas(); contador++) {
                        arreglo[0] = frm_matricula.devolverCodigo();
                        arreglo[1] = frm_matricula.devolverDato(contador, 1);
                        arreglo[2] = frm_matricula.devolverDato(contador, 3);
                        metodosMatricula.agregarMatricula(arreglo);
                    }
                    frm_matricula.colocarCodigo();
                    frm_matricula.resetearVentana();
                    encontroEstudiante = false;
                    encontroCurso = false;
                }
            }
            /////////////////////////////////////////////////////////////////////////////////////////////////////

            if (e.getActionCommand().equals("Consultar")) {
                if (frm_login.botones().equals("BaseDeDatos")) {
                    if (conexion.consultarMatriculaDetallada(frm_matricula.devolverCodigo(), frm_matricula)) {
                        frm_matricula.mostrarInformacion(conexion.arregloInformacionMatriculaDetallada);     
                    } 
                    else if(frm_login.botones().equals("XML")){
                    metodos_XML_Matricula.consultarMatricula(frm_matricula.devolverCodigo());
                    }
                    else{
                    metodosMatricula.consultarMatricula(frm_matricula.devolverCodigo());
                    }
                }
            }

        /////////////////////////////////////////////////////////////////////////////////////////////////
            if (e.getActionCommand().equals("Limpiar")) {
                frm_matricula.limpiar();
            }
            
            /////////////////////////////////////////////////////////////////////////////////////////////////
            if (e.getActionCommand().equals("Eliminar")) {
                //Eliminar base de datos 
                if (frm_login.botones().equals("BaseDeDatos")) {
                    conexion.eliminarMatriculaDetallada(frm_matricula.devolverCodigo());
                    conexion.eliminarMatricula(frm_matricula.devolverCodigo());
                    frm_matricula.limpiar();
                    frm_matricula.habilitarBotonBuscar();
                }
                
                //Eliminar  archivos planos
                else if (frm_login.botones().equals("Archivos planos")) {
                    metodosMatricula.eliminarMatricula(frm_matricula.devolverMatriculaSeleccionada());
                    metodosMatricula.escribirEnArchivo();
                    frm_matricula.limpiar();
                    frm_matricula.habilitarBotonBuscar();
                }
                
                //Eliminar XML
                else {
                    metodos_XML_Matricula.eliminarMatricula(frm_matricula.devolverMatriculaSeleccionada());
                    frm_matricula.limpiar();
                    frm_matricula.habilitarBotonBuscar();
                }
            }

            verificarConsultas();
        }

    

    public void verificarConsultas() {
        if (encontroEstudiante && encontroCurso) {
            this.frm_matricula.habilitarAgregar();
        }
    }

    public void guardarMatriculaDetalle() {
        String arreglo[] = new String[2];
        for (int contador = 0; contador < frm_matricula.getCantidadFilas(); contador++) {
            arreglo[0] = frm_matricula.devolverCodigo();
            arreglo[1] = frm_matricula.devolverDato(contador, 3);
            conexion.registrarMatriculaDetallada(arreglo);

        }
    }

    public void buscarEstudianteXML() {
        if (metodos_XML_Estudiantes.consultarEstudiante(frm_matricula.devolverCedula())) {
            frm_matricula.colocarNombreEstudiante(metodos_XML_Estudiantes.getNombreEstudiante());
           
        } else {
            frm_matricula.mostrarMensaje("La cédula buscada no se encuentra.");
            
        }
    }

    public void buscarCursoXML() {
        if (metodos_XML_Cursos.consultarCurso(frm_matricula.devolverSigla())) {
            frm_matricula.colocarNombreCurso(metodos_XML_Cursos.getNombreCurso());
            
            
        } else {
            frm_matricula.mostrarMensaje("La sigla buscada no se encuentra.");

        }
    }
}
