/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guruBankPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author RUBEN
 */
public class HomePOM {
    WebDriver driver;
    By mangerID = By.cssSelector("tr.heading3");
    
    public HomePOM(WebDriver driver){
        this.driver=driver;
    }   
    
    public String getMangerID(){
        String text = driver.findElement(mangerID).getText();
        System.out.println("ALERTA MENSAJE: " + text);
        return text;        
    }
}
