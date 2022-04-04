package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class BugChangeStatusPage extends PageBase {
    //Mapping
    By resolutionSelect = By.name("resolution");
    By addNoteField = By.name("bugnote_text");
    By resolveIssueButton = By.cssSelector("input[value='Resolve Issue']");

    //Actions
    public void selectResolution(String resolution){comboBoxSelectByVisibleText(resolutionSelect,resolution);}
    public void typeNewNote(String note){sendKeys(addNoteField,note);}
    public void clickOnResolveIssueButton() {click(resolveIssueButton);}
}
