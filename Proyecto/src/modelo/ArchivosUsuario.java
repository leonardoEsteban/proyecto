/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Sofia y Leonardo
 */
public class ArchivosUsuario {

    ObjectOutputStream archivoSalida;
    ObjectInputStream archivoEntrada;

    public ArchivosUsuario() {

    }

    public void crearArchivo() {
        try {
            archivoSalida = new ObjectOutputStream(new FileOutputStream("usuarios.dato"));
            System.out.println("Archivo creado");
        } catch (Exception e) {
            System.out.println("Error al crear el archivo: " + e);
        }
    }

    public void escribirInformacionEnELArhivo(Usuario usuario) {
        try {
            archivoSalida.writeObject(usuario);
            System.out.println("Se escribió la información de forma correcta");
        } catch (Exception e) {
            System.out.println("Error al escribir en el archivo");
        }

    }

    public String leerInformacion() {
        Usuario usuario = null;
        try {
            archivoEntrada = new ObjectInputStream(new FileInputStream("usuarios.dato"));
            usuario = (Usuario) archivoEntrada.readObject();
        } catch (Exception e) {
            System.out.println("Error al leer información del archivo");
        }
        return usuario.getInformacion();
    }

    public ArrayList<Usuario> leerInformacionCompleta() {

        ArrayList<Usuario> arrayUsuarios = new ArrayList<Usuario>();

        try {
            archivoEntrada = new ObjectInputStream(new FileInputStream("usuarios.dato"));
            while (true) {
                arrayUsuarios.add((Usuario) archivoEntrada.readObject());
            }
        } catch (Exception e) {
            System.out.println("Fin del archivo" + e);
        }
        return arrayUsuarios;
    }
}
