package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class MyViewPage extends PageBase {
    //Mapping
    By loggedInAsText = By.xpath("//td[text()= 'Logged in as: ']");
    By reportIssueLink = By.linkText("Report Issue");
    By viewIssuesLink = By.linkText("View Issues");

    //Actions
    public String returnMessageFromUserLoggedWithSuccess(){
        return getText(loggedInAsText);
    }
    public void clickOnReportIssue(){
        click(reportIssueLink);
    }
    public void clickOnViewIssues(){click(viewIssuesLink);}
}
