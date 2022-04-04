package com.javaseleniumtemplate.tests;

import com.javaseleniumtemplate.GlobalParameters;
import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.pages.LoginPage;
import com.javaseleniumtemplate.pages.MyViewPage;
import org.junit.Assert;
import org.junit.Test;
//import org.testng.Assert;
//import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    //Objects
    LoginPage loginPage;
    MyViewPage myViewPage;

    //Tests
    @Test
    public void loginWithSuccess(){

        //Objects instances
        loginPage = new LoginPage();
        myViewPage = new MyViewPage();

        //Parameteres
        String user = GlobalParameters.USER;
        String password = GlobalParameters.PASSWORD;
        String expectedLoggedUserMessage = "Logged in as: ";

        //Test
        loginPage.typeUser(user);
        loginPage.typePassword(password);
        loginPage.clickOnLogin();

        Assert.assertTrue(myViewPage.returnMessageFromUserLoggedWithSuccess().contains(expectedLoggedUserMessage));
    }

    @Test
    public void loginWithInvalidCredentials(){
        //Objects instances
        loginPage = new LoginPage();

        //Parameteres
        String user = "incorrectemail@me.com";
        String password = "123456";
        String expectedErrorMessage = "Your account may be disabled or blocked or the username/password";

        //Test
        loginPage.typeUser(user);
        loginPage.typePassword(password);
        loginPage.clickOnLogin();

        Assert.assertTrue(loginPage.returnErrorMessageLogin().contains(expectedErrorMessage));
    }
}
