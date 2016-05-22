/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Sofia y Leonardo
 */
public class ArchivosCursos {
   ObjectOutputStream archivoSalida;
    ObjectInputStream archivoEntrada;
    
    public ArchivosCursos(){
    
    }
    
    
    public void crearArchivo(){
        try{
        archivoSalida = new ObjectOutputStream(new FileOutputStream("cursos.dato"));
        System.out.println("Archivo creado");
        }
        catch(Exception e){
            System.out.println("Error al crear el archivo: "+e);
        }
    }
    
    public void escribirInformacionEnELArhivo(Cursos cursos){
        try{
            archivoSalida.writeObject(cursos);
            System.out.println("Se escribió la información de forma correcta");
        }
        catch(Exception e){
            System.out.println("Error al escribir en el archivo");
        }
    
    }
    
    public String leerInformacion(){
        Cursos curso = null;
        try{
            archivoEntrada  = new ObjectInputStream(new FileInputStream("cursos.dato"));
            curso = (Cursos)archivoEntrada.readObject();
        }
        catch(Exception e){
            System.out.println("Error al leer información del archivo");
        }
        return curso.getInformacion();
    }
    
     public ArrayList<Cursos> leerInformacionCompleta(){
        
        ArrayList <Cursos> arrayCursos = new ArrayList <Cursos>();
       
        try{
            archivoEntrada  = new ObjectInputStream(new FileInputStream("cursos.dato"));
            while(true){
            arrayCursos.add((Cursos)archivoEntrada.readObject());
            }
        }
        catch(Exception e){
            System.out.println("Fin del archivo"+e);
        }
        return arrayCursos;
                
    } 
}