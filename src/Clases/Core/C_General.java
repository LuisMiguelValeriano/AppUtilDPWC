/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases.Core;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lvaleriano
 */
public class C_General {
    public String AddToInteger(String myNumber, int numberToAdd){
        /*
        Parametros:
            -myNumber: es un String que representa a un entero al cual se le sumara
             en un futuro numberToAdd.
            -numberToAdd: es un entero al cual se le sumara a myNumber.
        Resultante:
            Nos retornara la sumatoria de myNumber y numberToAdd pero le agregaremos
            si es necesario ceros a la izquierda si el resultado tiene una longitud
            menor al String myNumber.
        */
        try {
            int number = Integer.parseInt(myNumber);
            number += numberToAdd;
            if(myNumber.length() > String.valueOf(number).length()){
                String numberWithoutZeros = "" + number;
                for(int i = 0; i < myNumber.length()-String.valueOf(number).length(); i++){
                    numberWithoutZeros = "0" + numberWithoutZeros;
                }
                return numberWithoutZeros;
            }else{
                return "" + number;
            }
        } catch (Exception e) {
            return "ERROR - No se puede sumar los numeros";
        }
    }
    public String AddOneSecondDWPC(String mySecond){
        /*
        Parametros:
            -mySecond: es un String que representa a los segundos que van de 00 a 59.
        Resultante:
            Nos retornara un String con el formato SS sumandole un segundo a mySecond.
        */
        try {
            int secondResult = Integer.parseInt(AddToInteger(mySecond,1));
            if(secondResult >= 60){
                return "00";
            }else{
                return AddToInteger(mySecond,1);
            }
        } catch (Exception e) {
            return "ERROR - No se puede sumar un segundo al numero";
        }
    }
    public String AddNMinutesDWPC(String HHMM, int minutesToAdd){
        /*
        Parametros:
            -HHMM: es un String que representa los dos primero digitos a la hora
             desde 00 a 23 y los dos digitos siguientes a los minutos de 00 a 59.
            -minutesToAdd: es un entero al cual se le sumara a solo a los minutos.
        Resultante:
            Nos retornara un String con el formato HHMM habiendole sumado la cantidad
            de minutos que es representada por minutesToAdd.
        Nota:
            Tener en cuenta que si HHMM es 2359 el resultante sera 0000.
        */
        try {
            if(HHMM.length()!=4){
                return "ERROR - No se puede sumar "+minutesToAdd+" minutos al numero con mas de 4 digitos.";
            }else{
                String HH = HHMM.substring(0, 2);
                String MM = HHMM.substring(2, 4);
                int secondResult = Integer.parseInt(AddToInteger(MM,minutesToAdd));
                if(secondResult >= 60){
                    if(Integer.parseInt(HH) == 23){
                        HH="00";
                    }else{
                        HH = AddToInteger(HH, minutesToAdd);
                    }
                    if(secondResult%60 < 10){
                        return HH+"0"+(secondResult%60);
                    }
                    return HH+(secondResult%60);
                }else{
                    return HH+AddToInteger(MM, minutesToAdd);
                }
            }
        } catch (Exception e) {
            return "ERROR - No se puede sumar "+minutesToAdd+" minutos al numero.";
        }
    }
    public String ReturnDateYYYYMMDDHHSS(String Date){
        Date = Date.replace("-", "");
        Date = Date.replace(" ", "");
        Date = Date.replace(":", "");
        return Date;
    }
}
