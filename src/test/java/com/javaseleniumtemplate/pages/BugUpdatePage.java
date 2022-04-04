package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class BugUpdatePage extends PageBase {
    //Mapping
    By statusSelect = By.name("status");
    By addNoteField = By.name("bugnote_text");
    By updateInformationButton = By.cssSelector("input[value='Update Information']");
    By hourOfUpdateIssue = By.xpath("//table[1]//tr/td[2]/span");


    //Actions
    public void selectStatus(String status){comboBoxSelectByVisibleText(statusSelect,status);}
    public void typeNewNote(String note){sendKeys(addNoteField,note);}
    public void clickOnUpdateInformationButton() {click(updateInformationButton);}
    public String returnHourOfUpdateIssue(){return getText(hourOfUpdateIssue);}
}
