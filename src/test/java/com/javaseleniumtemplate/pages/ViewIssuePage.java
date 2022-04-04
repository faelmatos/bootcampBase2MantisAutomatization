package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class ViewIssuePage extends PageBase {
    //Mapping
    By newStatusSelect = By.name("new_status");
    By changeStatusToButton = By.cssSelector("input[value='Change Status To:']");
    By statusField = By.xpath("//td[text()='Status']/following-sibling::td");

    //Actions
    public void selectNewStatus(String status) {
        waitForElement(newStatusSelect);
        comboBoxSelectByVisibleText(newStatusSelect,status);
    }

    public void clickOnChangeStatusTo(){click(changeStatusToButton);}
    public String returnStatusIssue(){return getText(statusField);}
}
