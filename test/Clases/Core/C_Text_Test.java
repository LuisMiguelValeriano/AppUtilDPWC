package Clases.Core;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author lvaleriano
 */
public class C_Text_Test extends C_Text{
    
    public C_Text_Test() {
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
    public void DelimitedReplaceCaractersInText(){
        System.out.println("Resultado 1: " + DelimitedReplaceCaractersInText("DTM+203:201412221801:203'", "", "DTM", "201412221802")); 
        System.out.println("Resultado 2: " + DelimitedReplaceCaractersInText("DTM+203:201412221801:203'", "DTM+", ":", "LUISMI")); 
    }
    @Test
    public void GetTextFromOneCharterToAnother(){
        String CompleteText = "UNB+UNOA:2+UNIMAR+CMA+150101:0701+1727472311'";
        
        System.out.println("Resultado 1 : " + GetTextFromOneCharterToAnother(CompleteText, "", 1, "U", 1, true));
        System.out.println("Resultado 2 : " + GetTextFromOneCharterToAnother(CompleteText, "", 1, "'", 1, false));
        System.out.println("Resultado 3 : " + GetTextFromOneCharterToAnother(CompleteText, "", 1, "", 1, true));
        System.out.println("Resultado 4 : " + GetTextFromOneCharterToAnother(CompleteText, "", 1, "", 1, false));
        
        System.out.println("Resultado 5 : " + GetTextFromOneCharterToAnother(CompleteText, "+", 1, ":", 1, true));
        System.out.println("Resultado 6 : " + GetTextFromOneCharterToAnother(CompleteText, "+", 1, "+", 1, true));
        System.out.println("Resultado 7 : " + GetTextFromOneCharterToAnother(CompleteText, "", 1, "+", 1, true));

        System.out.println("Resultado 8 : " + GetTextFromOneCharterToAnother(CompleteText, "'", 1, "+", 1, false));
        System.out.println("Resultado 9 : " + GetTextFromOneCharterToAnother(CompleteText, "+", 1, "+", 1, false));
        System.out.println("Resultado 10 : " + GetTextFromOneCharterToAnother(CompleteText, "", 1, "+", 1, false));
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
