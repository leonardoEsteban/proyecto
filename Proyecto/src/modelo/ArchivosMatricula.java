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
public class ArchivosMatricula {
   ObjectOutputStream archivoSalida;
    ObjectInputStream archivoEntrada;
    
    public ArchivosMatricula(){
    
    }
    
    
    public void crearArchivo(){
        try{
        archivoSalida = new ObjectOutputStream(new FileOutputStream("matricula.dato"));
        System.out.println("Archivo creado");
        }
        catch(Exception e){
            System.out.println("Error al crear el archivo: "+e);
        }
    }
    
    public void escribirInformacionEnELArhivo(Matricula matricula){
        try{
            archivoSalida.writeObject(matricula);
            System.out.println("Se escribió la información de forma correcta");
        }
        catch(Exception e){
            System.out.println("Error al escribir en el archivo");
        }
    
    }
    
    public String leerInformacion(){
        Matricula matricula = null;
        try{
            archivoEntrada  = new ObjectInputStream(new FileInputStream("matricula.dato"));
            matricula = (Matricula)archivoEntrada.readObject();
        }
        catch(Exception e){
            System.out.println("Error al leer información del archivo");
        }
        return matricula.getInformacion();
    }
    
    public ArrayList<Matricula> leerInformacionCompleta(){
        
        ArrayList <Matricula> arrayMatricula = new ArrayList <Matricula>();
       
        try{
            archivoEntrada  = new ObjectInputStream(new FileInputStream("estudiantes.dato"));
            while(true){
            arrayMatricula.add((Matricula)archivoEntrada.readObject());
            }
        }
        catch(Exception e){
            System.out.println("Fin del archivo"+e);
        }
        return arrayMatricula;
    } 
}
