/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases.Core;

import Clases.Entity.E_File;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author LuisMiguel
 */
public class C_File extends C_Text{
    public FileReader ReturnObjectOfArchiveReadyToRead(String FilePath){
        /*
        Parametros:
            -FilePath: es la ruta fisica en la cual se encuentra el archivo con el formato 
             siguiente "Ruta de archivo\Nombre del archivo.Su extencion".
        Resultante:
            Nos devuelve un objeto del archivo indicado en "FilePath" del cual podamos 
            leer su contenido si existe el archivo, si no existe lo crea en la ruta indicada.  
        */
        File archivo = null;
        FileReader fr = null;
        //E_File OE_File = new E_File();
        try {
            //OE_File.setArchivo(new File(FilePath));
            //OE_File.setFr(new FileReader(OE_File.getArchivo()));
            
            archivo = new File(FilePath);
            fr = new FileReader(archivo);
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"No se encontro el archivo .txt en la ruta indicada. "+ ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return fr;
        //return OE_File.getFr();
    }
    public FileWriter ReturnCreatedObjectOfArchiveToWrite(String FilePath){
        /*
        Parametros:
            -FilePath: es la ruta fisica en la cual se encuentra el archivo con el formato 
             siguiente "Ruta de archivo\Nombre del archivo.Su extencion".
        Resultante:
            Nos devuelve un objeto del archivo indicado en "FilePath" del cual remplazara el archivo
            en la ruta indicada si existe el archivo, en el caso no exista este creara uno nuevo en 
            la ruta especificada.  
        */
        FileWriter archivo = null;
        try {
            archivo = new FileWriter(FilePath);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"No se creo el archivo .txt resultante en la ruta indicada. "+ ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return archivo;
    }
    public void CreateObjectOfArchiveReadyToRead(E_File OE_File, String FilePath){
        try {
            OE_File.setArchivoToRead(new File(FilePath));
            OE_File.setFr(new FileReader(OE_File.getArchivoToRead()));
            OE_File.setBr(new BufferedReader(OE_File.getFr()));
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"No se encontro el archivo .txt en la ruta indicada. "+ ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void CreateObjectOfArchiveToWrite(E_File OE_File, String FilePath, boolean WriteInArchiveExist){
        try {
            OE_File.setFw(new FileWriter(FilePath,WriteInArchiveExist));
            OE_File.setPw(new PrintWriter(OE_File.getFw()));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"No se creo el archivo .txt resultante en la ruta indicada. "+ ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void MultilaneWriteArchive(PrintWriter pw, String Cadena, char Token){
        /*
        Parametros:
            -PrintWriter: es el objeto un archivo el cual esta listo para escibirse en el.
            -Cadena: Es una linea que contiene varias lineas delimitadas con un token.
            -Token: es el caracter que indica que acaba una linea.
        Resultante:
            Nos escribe en el archivo, del cual pertenece el objeto "PrintWriter", varias lineas
            con salto de linea que son las lineas contenidas en "Cadena" y delimitadas con "Token".  
        */
        String Line = "";
        while(Cadena.length()>0){
            if(Cadena.contains(String.valueOf(Token))){
                if(Cadena.length() == 1){
                    Line = "";
                    Cadena = "";
                    pw.println(Line);
                }else{
                    Line = Cadena.substring(0, Cadena.indexOf(String.valueOf(Token)));
                    Cadena = Cadena.substring(Cadena.indexOf(String.valueOf(Token))+1);
                    pw.println(Line);
                }
            }else{
                Line = Cadena.substring(0);
                Cadena = "";
                if(Line.charAt(Line.length()-1) == ';'){
                    Line = Line.replace(";", "");
                }
                pw.println(Line);
            }
        }
    }
}
