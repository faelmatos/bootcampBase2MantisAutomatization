package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class LoginPage extends PageBase {
    //Mapping
    By usernameField = By.name("username");
    By passwordField = By.name("password");
    By loginButton = By.xpath("//input[@type='submit']");
    By errorMessageText = By.xpath("//font");

    //Actions
    public void typeUser(String usuario){
        sendKeys(usernameField, usuario);
    }
    public void typePassword(String senha){
        sendKeys(passwordField, senha);
    }
    public void clickOnLogin(){
        click(loginButton);
    }
    public String returnErrorMessageLogin(){
        waitForElement(errorMessageText);
        return getText(errorMessageText);
    }

}
