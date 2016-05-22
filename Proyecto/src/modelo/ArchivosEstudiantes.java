/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Sofia y Leonardo
 */
public class ArchivosEstudiantes {
    
    ObjectOutputStream archivoSalida;
    ObjectInputStream archivoEntrada;
    
    public ArchivosEstudiantes(){
    
    }
    
    
    public void crearArchivo(){
        try{
        archivoSalida = new ObjectOutputStream(new FileOutputStream("estudiantes.dato"));
        System.out.println("Archivo creado");
        }
        catch(Exception e){
            System.out.println("Error al crear el archivo: "+e);
        }
    }
    
    public void escribirInformacionEnELArhivo(Estudiante estudiante){
        try{
            archivoSalida.writeObject(estudiante);
            System.out.println("Se escribió la información de forma correcta");
        }
        catch(Exception e){
            System.out.println("Error al escribir en el archivo");
        }
    
    }
    
    public String leerInformacion(){
        Estudiante estudiante = null;
        try{
            archivoEntrada  = new ObjectInputStream(new FileInputStream("estudiantes.dato"));
            estudiante = (Estudiante)archivoEntrada.readObject();
        }
        catch(Exception e){
            System.out.println("Error al leer información del archivo");
        }
        return estudiante.getInformacion();
    }
    
    public ArrayList<Estudiante> leerInformacionCompleta(){
        
        ArrayList <Estudiante> arrayEstudiantes = new ArrayList <Estudiante>();
       
        try{
            archivoEntrada  = new ObjectInputStream(new FileInputStream("estudiantes.dato"));
            while(true){
            arrayEstudiantes.add((Estudiante)archivoEntrada.readObject());
            }
        }
        catch(Exception e){
            System.out.println("Fin del archivo"+e);
        }
        return arrayEstudiantes;
    }
     
}