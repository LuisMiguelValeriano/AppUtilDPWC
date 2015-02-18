/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases.Generic;

import Clases.Core.C_File;
import Interfaces.I_File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author LuisMiguel
 */
public class G_File extends C_File  implements  I_File {

    FileReader fr = null;
    FileWriter fw = null;
    String Linea="";
    boolean Print=false;
    @Override
    public void LogicExtractFileByVesselName(String FilePath, String VesselName) {
        try {
            fr = ReturnObjectOfArchiveReadyToRead(FilePath);
            BufferedReader br = new BufferedReader(fr);
            String Resultado="";
            fw = ReturnCreatedObjectOfArchiveToWrite(FilePath.substring(0, FilePath.length()-4)+"_RESULT.edi");
            PrintWriter pw = new PrintWriter(fw);
            if((Linea = br.readLine())!=null){
                //GetTextFromOneCharterToAnother(Linea,"'",1,"+",1,false);
                //GetTextFromOneCharterToAnother(Linea,"+",1,":",1,false);
                pw.println(Linea);
            }
            while((Linea=br.readLine())!=null){
                if(TextStartWith(Linea,"UNH")){
                    Resultado="";
                    Print=false;
                }
                if(TextStartWith(Linea,"TDT+20")){ 
                    if(TextEndWith(Linea, VesselName)){
                        Print=true;
                    }
                }
                if(TextStartWith(Linea,"UNT")){
                    Resultado+=Linea+";";
                    if(Print){
                        MultilaneWriteArchive(pw, Resultado, ';');
                    }
                }else{
                    Resultado+=Linea+";";
                }
                if(TextStartWith(Linea,"UNZ")){
                    pw.println(Linea);
                }
            }
            fr.close();
            fw.close();
            JOptionPane.showMessageDialog(null,"Se Genero Exitosamente el archivo resultante", "Resultado", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"Se produjo un error en la generacion del archivo resultante. "+ ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
