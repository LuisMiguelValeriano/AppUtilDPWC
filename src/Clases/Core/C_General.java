/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases.Core;

import java.util.ArrayList;

/**
 *
 * @author lvaleriano
 */
public class C_General {
    public String AddToInteger(String myNumber, int numberToAdd){
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
}
