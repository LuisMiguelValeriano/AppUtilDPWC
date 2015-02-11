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
            el valor de (la longitud de CompleteText -1). Ademas si BeginDelimiter y EndDelimiter son
            iguales entonces apartir de BeginDelimiter se volvera a contar el numero de ocurrencias para
            encontrar a EndDelimiter.
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
        /*
        Parametros:
            -Array: es un array de String.
            -MaximumLines: se eliminara los duplicados hasta tener una cierta
             cantidad de elementos en el Array diferentes de vacio y este es
             MaixumumLines.
            -DeleteUpToDown: Indicara si eliminara los repetidos de arriba hacia
             abajo si es true y caso contrario cuando sea false se eliminara desde
             abajo hacia arriba.
        Resultante:
            Nos retornara un nuevo Array de Strings ya habiendo eliminados los 
            repetidos hasta llegar a un cierto numero de lineas en el cual deja
            de eliminar repetidos.
        Nota:
            La funcion eliminara todos los repetidos del Array solo cuando MaximumLines 
            sea igual a 0, cuando MaximumLines es menor a 0 o es mayor a la cantidad 
            de elementos en el Array retornara el mismo Array sin modificacion alguna,
            y cuando MaximumLines sea mayor o igual a 1 y a su vez sea menor a la cantidad 
            de elementos en el Array este metodo eliminara segun DeleteUpToDown los 
            elementos del Array hasta llegar a un numero de elementos igual a MaximumLines.
            Entonces no siempre eliminara todos los repetidos del Array.
        */
        if(Array.length > MaximumLines && MaximumLines >= 0){
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
        /*
        Parametros:
            -Array: es un array de String.
            -MaximumLines: es un entero que indica que cantidad de elementos deben 
             permanecer en el Array.
            -DeleteUpToDown: Indicara si eliminara los lementos de arriba hacia
             abajo si es true y caso contrario cuando sea false se eliminara desde
             abajo hacia arriba.
        Resultante:
            Nos retornara un nuevo Array de Strings habiendole eliminado elementos
            hasta llegar al numero de lineas igual a MaximumLines y eliminara de
            arriba hacia abajo si DeleteUpToDown es true y caso contrario eliminara
            en direccion opuesta.
        Nota:
            La funcion eliminara del Array elementos cuando cumpla que La cantidad
            de elementos es mayor que MaximumLines y cuando asu vez MaximumLines
            sea mayor a 0. Si MaximumLines es menor a 0 o MaximumLines es mayor a
            la cantidad de elemento en Array retornara el mismo Array sin
            modificacion alguna.
        */
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
    public String PutStringElementsOfArrayInBlockText(String[] Array, char Token){
        /*
        Parametros:
            -Array: es un array de String.
            -Token: es un char que separara cada elemento del Array.
        Resultante:
            Nos retornara una cadena de String el cual contiene todos los elementos
            del Array pero separados por Token.
        */
        String result="";
        for(int i=0; i<Array.length; i++){
            if(i == Array.length - 1){
                result += Array[i];
            }else{
                result += Array[i] + String.valueOf(Token);
            }
        }
        return result;
    }
    public String DeleteDuplicateLinesToMinimumOfThem(String BlockText, char Token, int MaximumLines, boolean DeleteUpToDown){
        /*
        Parametros:
            -BlockText: Es el conjunto de lineas dibididas por Token en una sola cadena de String.
            -Token: Es el caracter que separa cada linea dentro de BlockText.
            -MaximumLines: se eliminara los duplicados hasta tener una cierta
             cantidad de elementos en BlockText.
            -DeleteUpToDown: Indicara si eliminara los repetidos de izquierda hacia
             derecha si es true y caso contrario cuando sea false se eliminara desde
             derecha hacia izquierda.
        Resultante:
            Nos retornara una cadena de String habiendole eliminado elementos
            hasta llegar al numero de lineas igual a MaximumLines.
        Nota:
            La funcion eliminara de BlockText elementos cuando cumpla que la cantidad
            de elementos es mayor que MaximumLines y cuando asu vez MaximumLines
            sea mayor a 0. Si MaximumLines es menor a 0 o MaximumLines es mayor a
            la cantidad de elementos en BlockText retornara el mismo BlockText sin
            modificacion alguna.
        */
        String result = "";
        int numLines=CountCharacterInText(BlockText, Token) +1;
        if (numLines == 1){
            result = BlockText;
        }else{
            String[] Lines = PutLinesDelimitedInArray(BlockText, numLines, Token);
            Lines = DeleteDuplicateLinesInArrayToMinimumOfThem(Lines,MaximumLines,DeleteUpToDown);
            result = PutStringElementsOfArrayInBlockText(Lines,Token);
        }
        return result;
    }
    public String DeleteLinesToMinimumOfThem(String BlockText, char Token, int MaximumLines, boolean DeleteUpToDown){
        /*
        Parametros:
            -BlockText: es una cadena String que contiene lineas separadas por un Token.
            -Token: Es el caracter que separa cada linea dentro de BlockText.
            -MaximumLines: es un entero que indica que cantidad de elementos deben 
             permanecer en BlockText.
            -DeleteUpToDown: Indicara si eliminara los lementos de arriba hacia
             abajo si es true y caso contrario cuando sea false se eliminara desde
             abajo hacia arriba.
        Resultante:
            Nos retornara una nueva cadena String habiendole eliminado elementos
            a BlockText hasta llegar al numero de lineas igual a MaximumLines y eliminara de
            izquierda a derecha si DeleteUpToDown es true y caso contrario eliminara
            en direccion opuesta.
        Nota:
            La funcion eliminara de BlockText elementos cuando cumpla que La cantidad
            de elementos es mayor que MaximumLines y cuando asu vez MaximumLines
            sea mayor a 0. Si MaximumLines es menor a 0 o MaximumLines es mayor a
            la cantidad de elementos en BlockText retornara el mismo BlockText sin
            modificacion alguna.
        */
        String result = "";
        int numLines=CountCharacterInText(BlockText, Token) +1;
        if (numLines == 1){
            result = BlockText;
        }else{
            String[] Lines = PutLinesDelimitedInArray(BlockText, numLines, Token);
            Lines = DeleteLinesInArrayToMinimumOfThem(Lines,MaximumLines,DeleteUpToDown);
            result = PutStringElementsOfArrayInBlockText(Lines, Token);
        }
        return result;
    }
    public String[] DeleteNullStringsInArray(String[] Array){
        /*
        Parametros:
            -Array : Es un array de Strings
        Resultante:
            Nos retornara un nuevo array de Strings el cual contendra todos los 
            elementos de Array pero sin los elementos vacios.
        */
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
        /*
        Parametros:
            -BlockText: es una cadena String que contiene lineas separadas por un Token.
            -ArraySize: es un entero que representara el tamaño del array que vamos
            a devolver y deberia ser la cantidad de lineas separadas por el Token que
            contiene BlockText.
            -Token: Es el caracter que separa cada linea dentro de BlockText.
        Resultante:
            Nos retornara un array de Strings el cual contendra todas las lineas
            delimitadas por el token que contiene BlockText.
        */
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
    public String ReturnLineUNBaddDeterminateMinuteAndSecond(String Line, int NumberOfMinutesAndSecond){
        if(TextStartWith(Line,"UNB")){
            String secondsUNB = AddToInteger(GetTextFromOneCharterToAnother(Line,"'",1,"+",1,false),NumberOfMinutesAndSecond);
            String minutesUNB = AddNMinutesDWPC(GetTextFromOneCharterToAnother(Line,"+",1,":",1,false),NumberOfMinutesAndSecond);
            Line = Line.replace(GetTextFromOneCharterToAnother(Line,"'",1,"+",1,false), secondsUNB);
            Line = Line.replace(GetTextFromOneCharterToAnother(Line,"+",1,":",1,false), minutesUNB);
        }
        return Line;
    }
}
