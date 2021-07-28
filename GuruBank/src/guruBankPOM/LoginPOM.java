/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guruBankPOM;

import java.util.HashSet;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 *
 * @author RUBEN
 */
public class LoginPOM {
    WebDriver driver;
    By userID = By.name("uid");
    By password = By.name("password");
    By btnLogin = By.name("btnLogin");
    
    public LoginPOM(WebDriver driver){
        this.driver=driver;
    }
    
    public void setUserID(String textUserID){
        driver.findElement(userID).sendKeys(textUserID);
    }   

    public void setPassword(String textUserID){
        driver.findElement(password).sendKeys(textUserID);
    } 
    
    public void clickLogin(){
        driver.findElement(btnLogin).click();
    }      
    
    public String getTextAlert(){
        Alert alert = driver.switchTo().alert();
        String alertMessage= driver.switchTo().alert().getText();		        		
        // Displaying alert message		
        System.out.println(alertMessage);	        		
        // Accepting alert		
        alert.accept();	  
        return alertMessage;
    }
    
    public void login(String textUserID, String password){
        this.setUserID(textUserID);
        this.setPassword(password);
        this.clickLogin();     
    }
    
}
