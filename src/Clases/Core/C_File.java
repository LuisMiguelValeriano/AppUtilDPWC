/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases.Core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author LuisMiguel
 */
public class C_File extends C_General{
    protected FileReader ReturnArchiveInMemory(String FilePath){
        File archivo = null;
        FileReader fr = null;
        //BufferedReader br = null;
        try {
            archivo = new File(FilePath);
            fr = new FileReader(archivo);
            //br = new BufferedReader(fr);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"No se encontro el archivo .txt en la ruta indicada. "+ ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return fr;
    }
    protected FileWriter ReturnArchiveReadyToWrite(String FilePath){
        FileWriter archivo = null;
        //PrintWriter pw = null;
        try {
            archivo = new FileWriter(FilePath);
            //pw = new PrintWriter(archivo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"No se creo el archivo .txt resultante en la ruta indicada. "+ ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return archivo;
    }
}
