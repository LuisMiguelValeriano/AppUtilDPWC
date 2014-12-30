/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases.Core;

/**
 *
 * @author LuisMiguel
 */
public class C_General {
    
    protected boolean TextStartWith(String CompleateString, String BeginString){
        /*
        Parametros:
            -CompleateString: es el texto completo que analizaremos.
            -BeginString: es el conjunto de caracteres ordenados con el que 
             debe comenzar CompleateString.
        Resultante:
            Nos retornara un booleano que indica si determinado texto comienza 
            con cierto conjunto de caracteres ordenados.  
        */
        return CompleateString.substring(BeginString.length()).toUpperCase().equals(BeginString.toUpperCase());
    }
    protected boolean TextEndWith(String CompleateString, String EndString){
        /*
        Parametros:
            -CompleateString: es el texto completo que analizaremos.
            -EndString: es el conjunto de caracteres ordenados con el que 
             debe terminar CompleateString.
        Resultante:
            Nos retornara un booleano que indica si determinado texto termina 
            con cierto conjunto de caracteres ordenados.  
        */
        return CompleateString.substring(((CompleateString.length()-1)-EndString.length()),CompleateString.length()-1).toUpperCase().equals(EndString.toUpperCase());
    }
    protected String DelimitedReplaceCaractersInText(String CompleteText,String LeftText, String RigthText, String Caracteres){
        /*
        Parametros:
            -CompleateString: es el texto completo que analizaremos.
            -LeftText: es el conjunto de caracteres ordenados que estan incluidos en "CompleateString"
             en el cual a continuacion a este introduciremos "Caracteres".
            -RigthText: es el conjunto de caracteres ordenados que estan incluidos en "CompleateString"
             en el cual anterior a este introduciremos "Caracteres".
            -Caracteres: es el conjunto de caracteres ordenados que introduciremos en el texto 
             completo teniendo en cuenta LeftText y RigthText como limites.
        Resultante:
            Nos retornara un texto al cual hemos introducido un texto despues de LeftText y 
            antes de RigthText.  
        */
        if(CompleteText.contains(LeftText) && CompleteText.indexOf(RigthText,CompleteText.indexOf(LeftText)+LeftText.length())>=0){
            int FirstIndexCaracaters = CompleteText.indexOf(LeftText) + LeftText.length();
            int LastIndexCaracters  = CompleteText.indexOf(RigthText,CompleteText.indexOf(LeftText)+LeftText.length()) - 1;
            return CompleteText.substring(0, FirstIndexCaracaters)+Caracteres+CompleteText.substring(LastIndexCaracters+1, CompleteText.length());
        }
        return "ERROR";
    }
    protected int CountTextAtStartLineInBlockTextDelimited(String BlockText, String StartOfLine, char Token){
        /*
        Parametros:
            -BlocText: Son el conjunto de lineas que fueron juntadas en una sola linea con un 
             separador que indicara el fin de las lineas.
            -StartOfLine: es el texto con el que verificaremos que hallan comenzado las lineas que se
             juntaron en una sola linea con un separador.
            -Token: Es el separador que tiene BlockText que indica el final de cada linea que se
             junto en una sola linea.
        Resultante:
            Nos retornara un entero que representa el numero de lineas que anteriormente se juntaron 
            en una sola que comenzaron con determinado texto.  
        */
        int countChars = 0;
        int countOccurrencesOfLines = 0;
        while(countChars <= BlockText.length() && StartOfLine.length() <= (BlockText.length()-countChars)){
            countChars++;
            if(BlockText.charAt(countChars-1)==Token && TextStartWith(BlockText.substring(countChars),StartOfLine)){
                countOccurrencesOfLines++;
                countChars += (StartOfLine.length() - 1);
            }
        }
        return countOccurrencesOfLines;
    }
}
