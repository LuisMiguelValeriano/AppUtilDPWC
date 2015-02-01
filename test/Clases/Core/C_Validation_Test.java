/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases.Core;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author LuisMiguel
 */
public class C_Validation_Test extends C_Validation{
    
    public C_Validation_Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    
    @Test
    public void IsInteger(){
        System.out.println("Resultado ' 2014': " + IsInteger(" 2014"));
        System.out.println("Resultado '01' : " + IsInteger("01"));
        System.out.println("Resultado '01' : " + Integer.parseInt("01"));
    }
    
    @Test
    public void ComparePosibleIntegers(){
        System.out.println("Resultado : " + ComparePosibleIntegers("2014a",">",2015)); 
    }

    @Test
    public void FormatOfTheYearLessThanOrEqualToTheCurrentYYYY(){
        
        Calendar fecha = Calendar.getInstance();
        
        System.out.println("año de sistema: "+fecha.get(Calendar.YEAR));
        System.out.println("Resultado de 2014 : " + FormatOfTheYearLessThanOrEqualToTheCurrentYYYY("2014")); 
        System.out.println("Resultado de 2015: " + FormatOfTheYearLessThanOrEqualToTheCurrentYYYY("2015")); 
        System.out.println("Resultado de 2016: " + FormatOfTheYearLessThanOrEqualToTheCurrentYYYY("2016")); 
        System.out.println("Resultado de 201a: " + FormatOfTheYearLessThanOrEqualToTheCurrentYYYY("201a")); 
        System.out.println("Resultado de 14: " + FormatOfTheYearLessThanOrEqualToTheCurrentYYYY("14"));
        System.out.println("Resultado de 2016a: " + FormatOfTheYearLessThanOrEqualToTheCurrentYYYY("2016a"));
        System.out.println("Resultado de abcd: " + FormatOfTheYearLessThanOrEqualToTheCurrentYYYY("abcd"));
        System.out.println("-----------------------------------------------------");
        System.out.println("Resultado de 201a: " + FormatOfTheYearLessThanOrEqualToTheCurrentYYYY("201a",1,3)); 
        System.out.println("Resultado de 14: " + FormatOfTheYearLessThanOrEqualToTheCurrentYYYY("14",2,3));
        System.out.println("Resultado de 2016a: " + FormatOfTheYearLessThanOrEqualToTheCurrentYYYY("2016a",1,2,3));
        
    }
    
    @Test
    public void FormatOfTheMonth(){
        System.out.println("Resultado de 01: "+ FormatOfTheMonth("01"));
        System.out.println("Resultado de 1: "+ FormatOfTheMonth("1"));
        System.out.println("Resultado de aa: "+ FormatOfTheMonth("aa",1,3,4));
        System.out.println("Resultado de 13: "+ FormatOfTheMonth("13",3));
        System.out.println("Resultado de -1: "+ FormatOfTheMonth("-1",4));
        System.out.println("Resultado de 13: "+ FormatOfTheMonth("13"));
    }
    
    @Test
    public void FormatOfTheDayYYYY_MM_DD(){
        
        System.out.println("Fecha 2015-02-29 11:50 : "+FormatOfDateYYYY_MM_DD_HH_SS("2015-02-29 11:50"));
        System.out.println("Fecha 2015-02-28 13:50 : "+FormatOfDateYYYY_MM_DD_HH_SS("2015-02-28 13:50"));
        System.out.println("Fecha 2015-02-27 25:50 : "+FormatOfDateYYYY_MM_DD_HH_SS("2015-02-27 25:50"));
        System.out.println("Fecha 2015-02-27 24:00 : "+FormatOfDateYYYY_MM_DD_HH_SS("2015-02-27 24:00"));
        System.out.println("Fecha 2015-02-26 00:00 : "+FormatOfDateYYYY_MM_DD_HH_SS("2015-02-26 00:00"));
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
