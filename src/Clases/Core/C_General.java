/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases.Core;

import java.io.PrintWriter;

/**
 *
 * @author LuisMiguel
 */
public class C_General {
    protected void MultilaneWriteArchive(PrintWriter pw, String Cadena, char Token){
    //Se recive un PrintWriter que se encargara de escribir y una cadena de 
    //texto el cual debemos escribir cada seccion de esta,la cual esta
    //delimitada por el token indicado como parametro, con un salto de linea.
        String Line = "";
        for(int i=0;i<Cadena.length();i++){
            if(Cadena.charAt(i) == Token){
                pw.println(Line);
                Line="";
            }else{
                Line+=Cadena.charAt(i);
            }
        }
    }
}
