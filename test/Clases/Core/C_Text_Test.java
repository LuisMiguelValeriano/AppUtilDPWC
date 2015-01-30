package Clases.Core;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;
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
    public void TextStartWith(){
        System.out.println("Resultado 1: " + TextStartWith("DTM+203:201412221801:203'","DTM")); 
        System.out.println("Resultado 2: " + TextStartWith("","DTM"));
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
        System.out.println("Resultado 4.5 : " + GetTextFromOneCharterToAnother(CompleteText, "+", 1, "", 1, true));
        
        System.out.println("Resultado 5 : " + GetTextFromOneCharterToAnother(CompleteText, "+", 1, ":", 1, true));
        System.out.println("Resultado 6 : " + GetTextFromOneCharterToAnother(CompleteText, "+", 1, "+", 1, true));
        System.out.println("Resultado 7 : " + GetTextFromOneCharterToAnother(CompleteText, "", 1, "+", 1, true));

        System.out.println("Resultado 8 : " + GetTextFromOneCharterToAnother(CompleteText, "'", 1, "+", 1, false));
        System.out.println("Resultado 9 : " + GetTextFromOneCharterToAnother(CompleteText, "+", 1, "+", 1, false));
        System.out.println("Resultado 10 : " + GetTextFromOneCharterToAnother(CompleteText, "", 1, "+", 1, false));
        
    }
    
    @Test
    public void CountTextAtStartLineInBlockTextDelimited(){
        String BlockText1 = "UNH+93767+COARRI:D:95B:UN:ITG10';BGM+270++9';TDT+20+449N+1++HSD:172:166+++9227273:146::CAP TALBOT'\n" +
";DTM+132:201501030700:203';DTM+133:201501032300:203';NAD+CA+HSD:160:166';NAD+CF+HSD:160:166';EQD+CN+SUDU1910806+22G1:102:5++2+5'\n" +
";RFF+BN:4LIMES7540';RFF+ABT';TMD+3';DTM+203:201501032209:203';LOC+147+0191006:139:5';LOC+11+NLRTM:139:6'\n" +
";LOC+9+PECLL:139:6';MEA+AAE+G+KGM:23700';SEL+AFZ5046+SH+1';SEL+AHB6615+CA+1';SEL+AFL0243+CU+1'\n" +
";TDT+10+B5V764+3+31+20508368276:172:87:20508368276+++B5V764';CNT+16:1';UNT+000022+93767'";
        System.out.println("Resultado 1 : " + CountTextAtStartLineInBlockTextDelimited(BlockText1,"DTM",';'));
        String BlockText2 = "DTM+132:201501030700:203';DTM+133:201501032300:203';NAD+CA+HSD:160:166';NAD+CF+HSD:160:166';EQD+CN+SUDU1910806+22G1:102:5++2+5'\n" +
";RFF+BN:4LIMES7540';RFF+ABT';TMD+3';DTM+203:201501032209:203';LOC+147+0191006:139:5';LOC+11+NLRTM:139:6'\n" +
";LOC+9+PECLL:139:6';MEA+AAE+G+KGM:23700';SEL+AFZ5046+SH+1';SEL+AHB6615+CA+1';SEL+AFL0243+CU+1'\n" +
";TDT+10+B5V764+3+31+20508368276:172:87:20508368276+++B5V764';CNT+16:1';UNT+000022+93767'";
        System.out.println("Resultado 2 : " + CountTextAtStartLineInBlockTextDelimited(BlockText2,"DTM",';'));
        String BlockText3 = "DTM+132:201501030700:203';DTM+133:201501032300:203'";
        System.out.println("Resultado 3 : " + CountTextAtStartLineInBlockTextDelimited(BlockText3,"DTM",';'));
        String BlockText4 = "DTM+132:201501030700:203';DTM+133:201501032300:203';";
        System.out.println("Resultado 4 : " + CountTextAtStartLineInBlockTextDelimited(BlockText4,"DTM",';'));
    }
    
    @Test
    public void PutLinesDelimitedInArray(){
        String BlockText1 = "UNH+93767+COARRI:D:95B:UN:ITG10';BGM+270++9';TDT+20+449N+1++HSD:172:166+++9227273:146::CAP TALBOT'\n" +
";DTM+132:201501030700:203';DTM+133:201501032300:203';NAD+CA+HSD:160:166';NAD+CF+HSD:160:166';EQD+CN+SUDU1910806+22G1:102:5++2+5'\n" +
";RFF+BN:4LIMES7540';RFF+ABT';TMD+3';DTM+203:201501032209:203';LOC+147+0191006:139:5';LOC+11+NLRTM:139:6'\n" +
";LOC+9+PECLL:139:6';MEA+AAE+G+KGM:23700';SEL+AFZ5046+SH+1';SEL+AHB6615+CA+1';SEL+AFL0243+CU+1'\n" +
";TDT+10+B5V764+3+31+20508368276:172:87:20508368276+++B5V764';CNT+16:1';UNT+000022+93767'";
        int numLines=CountCharacterInText(BlockText1,';') +1;
        System.out.println("Resultado 1 : " + Arrays.toString(PutLinesDelimitedInArray(BlockText1, numLines, ';')));
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
