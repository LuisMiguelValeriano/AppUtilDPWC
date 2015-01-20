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
 * @author lvaleriano
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void AddNMinutesDWPC(){
        System.out.println("Resultado 01 : " +  AddNMinutesDWPC("01", 1));
        System.out.println("Resultado 1 : " +  AddNMinutesDWPC("1", 1));
        System.out.println("Resultado 59 : " +  AddNMinutesDWPC("59", 1));
        System.out.println("Resultado 0a : " +  AddNMinutesDWPC("0a", 1));
    }
}
