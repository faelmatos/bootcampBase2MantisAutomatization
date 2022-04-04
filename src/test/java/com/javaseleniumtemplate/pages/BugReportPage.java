package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class BugReportPage extends PageBase {
    //Mapping
    By categorySelect = By.name("category_id");
    By reproducibilitySelect = By.name("reproducibility");
    By severitySelect = By.name("severity");
    By prioritySelect = By.name("priority");
    By profileSelect = By.name("profile_id");
    By platformField = By.id("platform");
    By osField = By.id("os");
    By osVersionField = By.id("os");
    By assignToSelect = By.name("handler_id");
    By summaryField = By.name("summary");
    By descriptionField = By.name("description");
    By stepsToReproduceField = By.name("steps_to_reproduce");
    By additionalInformationField = By.name("additional_info");
    By submitReportButton = By.cssSelector("input[value='Submit Report']");
    By operationSuccessfulMessageLabel = By.xpath("//div[@align='center']");

    public void selectCategory(String category){comboBoxSelectByVisibleText(categorySelect,category);}
    public void selectReproducibility(String reproducibility){comboBoxSelectByVisibleText(reproducibilitySelect,reproducibility);}
    public void selectSeverity(String severity) {comboBoxSelectByVisibleText(severitySelect,severity);}
    public void selectPriority(String priority) {comboBoxSelectByVisibleText(prioritySelect,priority);}
    public void selectProfile(String profile) {comboBoxSelectByVisibleText(profileSelect,profile);}
    public void typePlatform(String platform) {sendKeys(platformField,platform);}
    public void typeOs(String os) {sendKeys(osField,os);}
    public void typeOsVersion(String osVersion) {sendKeys(osVersionField,osVersion);}
    public void selectAssignTo(String assignTo){comboBoxSelectByVisibleText(assignToSelect,assignTo);}
    public void typeSummary(String summary){sendKeys(summaryField,summary);}
    public void typeDescription(String description) {sendKeys(descriptionField,description);}
    public void typeStepsToReproduce(String stepsToReproduce) {sendKeys(stepsToReproduceField,stepsToReproduce);}
    public void typeAdditionalInformation(String additionalInformation) {sendKeys(additionalInformationField,additionalInformation);}
    public  void clickOnSubmitReportButton() {click(submitReportButton);}

    public String returnOperationSuccessfulMessage(){
        waitForElement(operationSuccessfulMessageLabel);
        return getText(operationSuccessfulMessageLabel);
    }


}
