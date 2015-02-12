/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases.Core;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author LuisMiguel
 */
public class C_General_Test extends C_General{
    
    public C_General_Test() {
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
    public void ReturnDateYYYYMMDDHHSS(){
        System.out.println("Fecha 2015-02-28 11:50 : "+ ReturnDateYYYYMMDDHHSS("2015-02-28 11:50"));
    }
    @Test
    public void AddNMinutesDWPC(){
        System.out.println("Resultado 0552: " + AddNMinutesDWPC("0552", 1));
        System.out.println("Resultado 1259: " + AddNMinutesDWPC("1259", 1));
        System.out.println("Resultado 2359: " + AddNMinutesDWPC("2359", 1));
        System.out.println("Resultado 2300: " + AddNMinutesDWPC("2300", 1));
        System.out.println("Resultado 0000: " + AddNMinutesDWPC("0000", 1));
    }
    @Test
    public void AddToInteger(){
        System.out.println("Resultado 0059: " + AddToInteger("0059", 1));
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
