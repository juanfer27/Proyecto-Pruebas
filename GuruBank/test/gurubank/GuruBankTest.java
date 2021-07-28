/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gurubank;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import guruBankPOM.HomePOM;
import guruBankPOM.LoginPOM;

/**
 *
 * @author RUBEN
 */
public class GuruBankTest {
    private WebDriver driver;
    
    LoginPOM login;
    HomePOM home;
    
    public GuruBankTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        driver = new ChromeDriver();        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
        driver.get("http://demo.guru99.com/V4/"); 
        driver.manage().window().maximize(); 
        home = new HomePOM(driver);
        login = new LoginPOM(driver);
    }
    
    @After
    public void tearDown() {
        driver.quit();
    }

    /**
     * Test of main method, of class GuruBank.
     */
    @Test
    public void loginRight() {
        System.out.println("loginRight");
        login.login("mgr123", "mgr!23");
        String text = home.getMangerID();
        assertEquals("No es igual", "Manger Id : mgr123", text);
    }    

    @Test
    public void validationUserNotRight() {
        System.out.println("validationUserNotRight");
        login.login("userNoRight", "mgr!23");
        String text = login.getTextAlert();
        assertEquals("No es igual", "User or Password is not valid", text);
    }  
    
}
