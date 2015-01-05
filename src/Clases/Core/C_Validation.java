/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases.Core;

import java.util.Calendar;

/**
 *
 * @author lvaleriano
 */
public class C_Validation {
    
    protected boolean IsInteger(String posibleInteger){
        /*
        Parametros:
            -posibleInteger: es un texto cualquiera el cual se tratara de
             convertir a entero.
        Resultante:
            Nos devuelve verdadero en el caso que el texto pueda ser transformado
            a entero y falso en caso contrario.  
        */
        try {
            int intPosibleInteger = Integer.parseInt(posibleInteger.trim());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    protected boolean ComparePosibleIntegers(String posibleNumber, String compareSymbol, int compareNumber){
        /*
        Parametros:
            -posibleNumber: es un texto cualquiera el cual se tratara de
             convertir a entero.
            -compareSymbol: es un texto que servira como simbolo de comparación.
            -compareNumber: es un entero con el cual compararemos "posibleNumber".
        Resultante:
            Nos devuelve verdadero en el caso que la comparacion segun el simbolo
            que contenga "compareSymbol" entre "posibleNumber" y "compareNumber"
            sea correcto, y ademas debe cumplir que "posibleNumber" se pueda transformar
            de String a int. En caso no cumplira las ya mencionadas retornara falso.
        */
        if(IsInteger(posibleNumber)){
            int intPosibleNumber = Integer.parseInt(posibleNumber.trim());
            switch(compareSymbol){
                case "==":
                    return intPosibleNumber == compareNumber;
                case "<":
                    return intPosibleNumber < compareNumber;
                case "<=":
                    return intPosibleNumber <= compareNumber;
                case ">":
                    return intPosibleNumber > compareNumber;
                case ">=":
                    return intPosibleNumber >= compareNumber;
                case "!=":
                    return intPosibleNumber != compareNumber;
                default:
                    return false;
            }
        }else{
            return false;
        }
    }
    protected boolean compareTextLength(String Text, String compareSymbol, int compareNumber ){
        /*
        Parametros:
            -Text: es un texto cualquiera.
            -compareSymbol: es un texto que servira como simbolo de comparación.
            -compareNumber:en el caso que la comparacion segun el simbolo
             que contenga "compareSymbol" entre es un entero con el cual compararemos la longitud del
             String "Text".
        Resultante:
            Nos devuelve verdadero en el caso que la comparacion segun el simbolo
            que contenga "compareSymbol" entre que la longitud del string "Text" y
            el entero "compareNumber" sea correcto, y falso en caso contrario.  
        */
        return ComparePosibleIntegers(String.valueOf(Text.trim().length()), compareSymbol, compareNumber);
    }
    protected boolean FormatOfTheMonth(String Month, int... Exceptions){
        /*
        Parametros:
            -Month: es un texto cualquiera que representa un mes en numeros.
            -Exceptions: es el conjunto de paramateros siguientes que representan el numero 
             identificador de cada validacion que no se tomaran en cuenta. 
             Siendo los siguientes:
                1 - Month es un numero
                2 - Month tiene longitud de 2
                3 - Month es menor o igual que 12
                4 - Month es mayor o igual que 1
        Resultante:
            Nos devuelve verdadero en el caso que cumpla todas las validaciones ya habiendo
            omitido algunas de estas dictadas por "Exceptions".
        */
        int NumberOfValidation = 3;//Si se decea modificar la cantidad de validaciones debemos modificar el numero de validaciones en esta linea
        String ListOfExceptions = "0";
        if(Exceptions.length>0){
            for(int ActualException : Exceptions){
                ListOfExceptions += ","+ActualException;
            }
        }
        for (int i = 1; i <= NumberOfValidation; i++) {
            switch(i){
                //en este switch si modificamos la cantidad de validaciones agregaremos una case mas o quitaremos segun sea el caso.
                case 1:
                    if(!IsInteger(Month) && !ListOfExceptions.contains(","+String.valueOf(i))){
                        return false;
                    } 
                    break;
                case 2:
                    if(!compareTextLength(Month,"==", 2) && !ListOfExceptions.contains(","+String.valueOf(i))){
                        return false;
                    } 
                    break;
                case 3:
                    if(!ComparePosibleIntegers(Month, "<=", 12) && !ListOfExceptions.contains(","+String.valueOf(i))){
                        return false;
                    } 
                    break;
                case 4:
                    if(!ComparePosibleIntegers(Month, ">=", 1) && !ListOfExceptions.contains(","+String.valueOf(i))){
                        return false;
                    } 
                    break;
            }
        }
        return true;
    }
    protected boolean FormatOfTheYearLessThanOrEqualToTheCurrentYYYY(String Year, int... Exceptions){
        /*
        Parametros:
            -Year: es un texto cualquiera que representa un año.
            -Exceptions: es el conjunto de paramateros siguientes que representan el numero 
             identificador de cada validacion que no se tomaran en cuenta. 
             Siendo los siguientes:
                1 - Year es un numero
                2 - Year es un numero positivo
                3 - Year tiene longitud de 4
                4 - Year es menor o igual al año actual
        Resultante:
            Nos devuelve verdadero en el caso que cumpla todas las validaciones ya habiendo
            omitido algunas de estas dictadas por "Exceptions".
        */
        int NumberOfValidation = 4;//Si se decea modificar la cantidad de validaciones debemos modificar el numero de validaciones en esta linea
        String ListOfExceptions = "0";
        if(Exceptions.length>0){
            for(int ActualException : Exceptions){
                ListOfExceptions += ","+ActualException;
            }
        }
        for (int i = 1; i <= NumberOfValidation; i++) {
            switch(i){
                //en este switch si modificamos la cantidad de validaciones agregaremos una case mas o quitaremos segun sea el caso.
                case 1:
                    if(!IsInteger(Year) && !ListOfExceptions.contains(","+String.valueOf(i))){
                        return false;
                    } 
                    break;
                case 2:
                    if(!ComparePosibleIntegers(Year, ">=", 1) && !ListOfExceptions.contains(","+String.valueOf(i))){
                        return false;
                    }
                    break;
                case 3:
                    if(!compareTextLength(Year,"==", 4) && !ListOfExceptions.contains(","+String.valueOf(i))){
                        return false;
                    } 
                    break;
                case 4:
                    Calendar fecha = Calendar.getInstance();
                    if(!ComparePosibleIntegers(Year, "<=", fecha.get(Calendar.YEAR)) && !ListOfExceptions.contains(","+String.valueOf(i))){
                        return false;
                    } 
                    break;
            }
        }
        return true;
    }
}
