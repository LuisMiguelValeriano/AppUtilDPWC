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
            fr = ReturnArchiveInMemory(FilePath);
            BufferedReader br = new BufferedReader(fr);
            String Resultado="";
            fw = ReturnArchiveReadyToWrite(FilePath.substring(0, FilePath.length()-4)+"_RESULT.txt");
            PrintWriter pw = new PrintWriter(fw);
            if((Linea = br.readLine())!=null){
                pw.println(Linea);
            }
            while((Linea=br.readLine())!=null){
                if(TextStartWith(Linea,"UNH")){//Linea.substring(0,3).equals("UNH")){
                    Resultado="";
                    Print=false;
                }
                if(TextStartWith(Linea,"TDT+20")){ //Linea.substring(0,6).equals("TDT+20")){Linea.substring(((Linea.length()-1)-VesselName.length()),Linea.length()-1).equals(VesselName)
                    if(TextEndWith(Linea, VesselName)){//Linea.substring(((Linea.length()-1)-VesselName.length()),Linea.length()-1).equals(VesselName)){
                        Print=true;
                    }
                }
                if(TextStartWith(Linea,"UNT")){//Linea.substring(0,3).equals("UNT")){
                    Resultado+=Linea+";";//Resultado+=Linea;
                    if(Print){
                        MultilaneWriteArchive(pw, Resultado, ';');
                        //pw.println(Resultado);
                    }
                }else{
                    Resultado+=Linea+";";
                }
                if(TextStartWith(Linea,"UNZ")){//Linea.substring(0,3).equals("UNZ")){
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
