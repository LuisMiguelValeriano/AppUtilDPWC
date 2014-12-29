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
        return CompleateString.substring(BeginString.length()).toUpperCase().equals(BeginString.toUpperCase());
    }
    protected boolean TextEndWith(String CompleateString, String EndString){
        return CompleateString.substring(((CompleateString.length()-1)-EndString.length()),CompleateString.length()-1).toUpperCase().equals(EndString.toUpperCase());
    }
    protected String DelimitedReplaceCaractersInText(String CompleteText,String LeftText, String RigthText, String Caracteres){
        if(CompleteText.contains(LeftText) && CompleteText.indexOf(RigthText,CompleteText.indexOf(LeftText)+LeftText.length())>=0){
            int FirstIndexCaracaters = CompleteText.indexOf(LeftText) + LeftText.length();
            int LastIndexCaracters  = CompleteText.indexOf(RigthText,CompleteText.indexOf(LeftText)+LeftText.length()) - 1;
            return CompleteText.substring(0, FirstIndexCaracaters)+Caracteres+CompleteText.substring(LastIndexCaracters+1, CompleteText.length());
        }
        return "ERROR";
    }
}
