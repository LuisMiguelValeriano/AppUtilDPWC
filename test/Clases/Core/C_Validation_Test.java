/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases.Core;

import java.util.Calendar;
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
        System.out.println("Resultado : " + IsInteger(" 2014")); 
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
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
