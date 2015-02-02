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
        if(CompleateString.length() > BeginString.length()){
            return CompleateString.substring(0,BeginString.length()).toUpperCase().equals(BeginString.toUpperCase());
        }else{
            return false;
        }
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
    public String GetTextAtStartLineInBlockTextDelimited(String BlockText, String StartOfLine, char Token){
        /*
        Parametros:
            -BlocText: Son el conjunto de lineas que fueron juntadas en una sola linea con un 
             separador que indicara el fin de las lineas.
            -StartOfLine: es el texto con el que verificaremos que hallan comenzado las lineas que se
             juntaron en una sola linea con un separador.
            -Token: Es el separador que tiene BlockText que indica el final de cada linea que se
             junto en una sola linea.
        Resultante:
            Nos retornara el conjunto de lineas que comienzan con StartOfLine y que seran delimitadas por
            Token.  
        */
        String result = "";
        while(BlockText.contains(String.valueOf(Token))){
            if(TextStartWith(BlockText,StartOfLine)){
                result += BlockText.substring(0,BlockText.indexOf(Token))+";";
            }
            BlockText = BlockText.substring(BlockText.indexOf(Token)+1);
        }
        if(TextStartWith(BlockText,StartOfLine)){
                result += BlockText;
        }
        if((result.length()>0) && (result.charAt(result.length()-1) == ';')){
            result = result.substring(0,result.length()-1);
        }
        return result;
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
        int countOccurrencesOfLines = 0;
        while(BlockText.contains(String.valueOf(Token))){
            if(TextStartWith(BlockText,StartOfLine)){
                countOccurrencesOfLines++;
            }
            BlockText = BlockText.substring(BlockText.indexOf(Token)+1);
        }
        if(TextStartWith(BlockText,StartOfLine)){
                countOccurrencesOfLines++;
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
                indexEndDelimiter = CompleteText.length();

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
                indexBeginDelimiter = CompleteText.length();
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
                        indexEndDelimiter = j+1;
                        j = -1;
                    }
                }
                return CompleteText.substring(indexEndDelimiter, indexBeginDelimiter);
            }
        }
        
    }
    public int CountCharacterInText(String CompleteText, char CharacterCount){
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
    public String[] DeleteDuplicateLinesInArrayToMinimumOfThem (String[] Array, int MaximumLines, boolean DeleteUpToDown){
        if(Array.length > MaximumLines){
            int AuxNumLines = Array.length;
            if(DeleteUpToDown){
                for(int i=0; i<Array.length; i++){
                    if(!"".equals(Array[i])){
                        for(int k=0; k<Array.length;k++){
                            if(i!=k && Array[i].equals(Array[k])){
                                Array[i]="";
                                AuxNumLines--;
                                k=Array.length;
                                if(AuxNumLines == MaximumLines && MaximumLines>=0){
                                    i=Array.length;
                                }
                            }
                        }
                    }
                }
            }else{
                for(int i=Array.length-1; i>=0; i--){
                    if(!"".equals(Array[i])){
                        for(int k=Array.length-1; k>=0; k--){
                            if(i!=k && Array[i].equals(Array[k])){
                                Array[i]="";
                                AuxNumLines--;
                                k=-1;
                                if(AuxNumLines == MaximumLines && MaximumLines>=0){
                                    i=-1;
                                }
                            }
                        }
                    }
                }
            }
            return DeleteNullStringsInArray(Array);
        }else{
            return Array;
        }
        
    }
    public String[] DeleteLinesInArrayToMinimumOfThem (String[] Array, int MaximumLines, boolean DeleteUpToDown){
        if(Array.length > MaximumLines && MaximumLines>0){
            String[] ArrayWithMaximumLength = new String[MaximumLines];
            int numLines = Array.length;
            if(DeleteUpToDown){
                int countLines=0;
                for(int j=Array.length-1; j>=0; j--){
                    ArrayWithMaximumLength[j-1] = Array[j];
                    if(MaximumLines == countLines+1){
                        j=-1;
                    }
                    countLines++;
                }
            }else{
                for(int i=0; i<Array.length; i++){
                    ArrayWithMaximumLength[i] = Array[i];
                    if(MaximumLines == i+1){
                        i=Array.length;
                    }
                }
            }
            return ArrayWithMaximumLength;
        }else{
            return Array;
        }
    }
    public String PutStringElementsOfArrayInBlockText(String[] Array){
        String result="";
        for(int i=0; i<Array.length; i++){
            if(i == Array.length - 1){
                result += Array[i];
            }else{
                result += Array[i] + ";";
            }
        }
        return result;
    }
    public String DeleteDuplicateLinesToMinimumOfThem(String BlockText, char Token, int MaximumLines, boolean DeleteUpToDown){
        
        String result = "";
        int numLines=CountCharacterInText(BlockText, Token) +1;
        if (numLines == 1){
            result = BlockText;
        }else{
            String[] Lines = PutLinesDelimitedInArray(BlockText, numLines, Token);
            Lines = DeleteDuplicateLinesInArrayToMinimumOfThem(Lines,MaximumLines,DeleteUpToDown);
            result = PutStringElementsOfArrayInBlockText(Lines);
        }
        return result;
    }
    public String DeleteLinesToMinimumOfThem(String BlockText, char Token, int MaximumLines, boolean DeleteUpToDown){
        
        String result = "";
        int numLines=CountCharacterInText(BlockText, Token) +1;
        if (numLines == 1){
            result = BlockText;
        }else{
            String[] Lines = PutLinesDelimitedInArray(BlockText, numLines, Token);
            Lines = DeleteLinesInArrayToMinimumOfThem(Lines,MaximumLines,DeleteUpToDown);
            result = PutStringElementsOfArrayInBlockText(Lines);
        }
        return result;
    }
    public String[] DeleteNullStringsInArray(String[] Array){
        int countNotNullString = 0;
        for(int i = 0; i<Array.length; i++){
            if(!Array[i].equals("")){
                countNotNullString++;
            }
        }
        String[] ArrayWithOutNullString = new String[countNotNullString];
        int countArrayWithOutNullString = 0;
        for(int i = 0; i<Array.length; i++){
            if(!Array[i].equals("")){
                ArrayWithOutNullString[countArrayWithOutNullString] = Array[i];
                countArrayWithOutNullString++;
            }
        }
        return ArrayWithOutNullString;
    }
    public String[] PutLinesDelimitedInArray (String BlockText,int ArraySize, char Token){
        String[] Array = new String[ArraySize];
        for(int i=0;i<ArraySize;i++){
            if(i == ArraySize-1){
                Array[i] = BlockText;
            }else{
                Array[i] = GetTextFromOneCharterToAnother(BlockText,"",1,String.valueOf(Token),1,true);
                BlockText = GetTextFromOneCharterToAnother(BlockText,String.valueOf(Token),1,"",1,true);
            }
        }
        return Array;
    }
}
