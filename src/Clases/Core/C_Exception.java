/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases.Core;

/**
 *
 * @author lvaleriano
 */
public class C_Exception {
    
    protected boolean IsInteger(String posibleInteger){
        try {
            int intPosibleInteger = Integer.parseInt(posibleInteger.trim());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    protected boolean ComparePosibleIntegers(String posibleNumber, String compareSymbol, int compareNumber){
        if(IsInteger(posibleNumber)){
            int intPosibleNumber = Integer.parseInt(posibleNumber.trim());
            switch(compareSymbol){
                case "=":
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
        return ComparePosibleIntegers(String.valueOf(Text.trim().length()), compareSymbol, compareNumber);
    }
}
