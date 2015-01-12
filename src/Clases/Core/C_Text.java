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
public class C_Text extends C_Validation{
    
    public boolean TextStartWith(String CompleateString, String BeginString){
        /*
        Parametros:
            -CompleateString: es el texto completo que analizaremos.
            -BeginString: es el conjunto de caracteres ordenados con el que 
             debe comenzar CompleateString.
        Resultante:
            Nos retornara un booleano que indica si determinado texto comienza 
            con cierto conjunto de caracteres ordenados.  
        */
        return CompleateString.substring(0,BeginString.length()).toUpperCase().equals(BeginString.toUpperCase());
    }
    public boolean TextEndWith(String CompleateString, String EndString){
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
    public String DelimitedReplaceCaractersInText(String CompleteText,String LeftText, String RigthText, String Caracteres){
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
    public int CountTextAtStartLineInBlockTextDelimited(String BlockText, String StartOfLine, char Token){
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
    public String GetTextFromOneCharterToAnother(String CompleteText, String BeginDelimiter, int FewTimeBeginDelimiter, String EndDelimiter, int FewTimeEndDelimiter, boolean BeginsFromTheLeft){
        /*
        Parametros:
            -CompleteText: es un texto cualquiera.
            -BeginDelimiter: es el caracter anterior apartir del cual se tomara como el inicio 
             del texto deseado como resultado.
            -FewTimeBeginDelimiter: es el numero de ocurrencias del caracter apartir
             del cual se tomara como inicio del texto deseado como resultado.
            -EndDelimiter:es el caracter posterior apartir del cual se tomara como el fin 
             del texto deseado como resultado.
            -FewTimeEndDelimiter:es el numero de ocurrencias del caracter apartir
             del cual se tomara como fin del texto deseado como resultado.
            -BeginsFromTheLeft: indica si la busqueda comenzara por la izquierda si es true y 
             por la derecha si es false;
        Resultante:
            Nos retornara una cadena de texto que esta ontenida en "CompleteText" dependiendo 
            del caracter de incio y fin que delimitan al texto resultante.
        Nota:
            Si no encuentra una ocurrencia de los caracteres delimitantes "BeginDelimiter", y 
            "EndDelimiter" tomara como defecto en "BeginDelimiter" el valo de 0 y en "EndDelimiter"
            el valor de (la longitud de CompleteText -1).
        */
        int indexBeginDelimiter;
        int indexEndDelimiter;
        
        int countBeginDelimiter = 0;
        int countEndDelimiter = 0;
        if(BeginDelimiter.equals("") && EndDelimiter.equals("")){
            return "";
        }else{
            if(BeginsFromTheLeft){
                indexBeginDelimiter = 0;
                indexEndDelimiter = CompleteText.length()-1;

                for(int i=0; i<= CompleteText.length()-1; i++){
                    if(String.valueOf(CompleteText.charAt(i)).equals(BeginDelimiter)){
                        countBeginDelimiter++;
                    }
                    if(countBeginDelimiter == FewTimeBeginDelimiter){
                        indexBeginDelimiter = i+1;
                        i = CompleteText.length();
                    }
                }
                for(int j = (indexBeginDelimiter==0?0:indexBeginDelimiter+1); j<= CompleteText.length()-1;j++){
                    if(String.valueOf(CompleteText.charAt(j)).equals(EndDelimiter)){
                        countEndDelimiter++;
                    }
                    if(countEndDelimiter == FewTimeEndDelimiter){
                        indexEndDelimiter = j;
                        j = CompleteText.length();
                    }
                }
                return CompleteText.substring(indexBeginDelimiter, indexEndDelimiter);
            }else{
                indexBeginDelimiter = CompleteText.length()-1;
                indexEndDelimiter = 0;

                for(int i=CompleteText.length()-1; i>=0; i--){
                    if(String.valueOf(CompleteText.charAt(i)).equals(BeginDelimiter)){
                        countBeginDelimiter++;
                    }
                    if(countBeginDelimiter == FewTimeBeginDelimiter){
                        indexBeginDelimiter = i;
                        i = -1;
                    }
                }
                for(int j = (indexBeginDelimiter==CompleteText.length()-1?CompleteText.length()-1:indexBeginDelimiter-1); j>= 0;j--){
                    if(String.valueOf(CompleteText.charAt(j)).equals(EndDelimiter)){
                        countEndDelimiter++;
                    }
                    if(countEndDelimiter == FewTimeEndDelimiter){
                        indexEndDelimiter = (j==CompleteText.length()-1?j:j+1);
                        j = -1;
                    }
                }
                return CompleteText.substring(indexEndDelimiter, indexBeginDelimiter);
            }
        }
        
    }
    public int CountLetersInText(String CompleteText, char CharacterCount){
        /*
        Parametros:
            -CompleteText: es un texto cualquiera.
            -CharacterCount: es el carcater que se contara cuantas veces la encontramos en CompleteText.
        Resultante:
            Nos retornara un entero que representa el numero de veces se repite el caracter "CharacterCount"
            en el texto "CompleteText".  
        */
        int count=0;
        for(int i=0; i<= CompleteText.length()-1; i++){    
            if(CharacterCount == CompleteText.charAt(i)){
                count++;
            }
        }
        return count;
    }
}
