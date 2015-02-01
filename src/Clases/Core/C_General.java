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
    public String AddNMinutesDWPC(String mySecond, int minutesToAdd){
        try {
            int secondResult = Integer.parseInt(AddToInteger(mySecond,minutesToAdd));
            if(secondResult >= 60){
                if(secondResult%60 < 10){
                    return "0"+(secondResult%60);
                }
                return ""+(secondResult%60);
            }else{
                return AddToInteger(mySecond,1);
            }
        } catch (Exception e) {
            return "ERROR - No se puede sumar "+minutesToAdd+" minutos al numero.";
        }
    }
}
