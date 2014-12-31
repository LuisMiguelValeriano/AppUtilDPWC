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

/**
 *
 * @author LuisMiguel
 */
public class C_Exception_Test extends C_Exception{
    
    public C_Exception_Test() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
