package com.javaseleniumtemplate.flows;

import com.javaseleniumtemplate.GlobalParameters;
import com.javaseleniumtemplate.pages.LoginPage;

public class LoginFlows {
    //Objects and constructor
    LoginPage loginPage;

    public LoginFlows(){
        //Page and Steps Objects
        loginPage = new LoginPage();
    }

    //Parameters
    String user = GlobalParameters.USER;
    String password = GlobalParameters.PASSWORD;

    //Flows
    public void login(){
        loginPage.typeUser(user);
        loginPage.typePassword(password);
        loginPage.clickOnLogin();
    }
}
