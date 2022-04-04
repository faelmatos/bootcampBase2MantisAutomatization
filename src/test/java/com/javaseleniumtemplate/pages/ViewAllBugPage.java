package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class ViewAllBugPage extends PageBase {

    //Mapping
    By filterSelect = By.name("source_query_id");
    By useFilterButton = By.cssSelector("input[value='Use Filter']");
    By searchField = By.name("search");
    By applyFilterButton = By.cssSelector("input[value='Apply Filter']");
    By editIssueLink = By.xpath("//a[contains(@href, 'bug_update_page.php?bug_id=')]");
    By idIssueLink = By.xpath("//a[contains(@href, '/view.php?id=')]");
    By assignedToLink = By.xpath("//a[contains(@href, 'view_filters_page.php?for_screen=1&target_field=handler_id[]')]");
    By assignedToSelect = By.name("handler_id[]");
    By assignedToText = By.id("handler_id_filter_target");

    //Actions
    public void selectResetFilter(){comboBoxSelectByVisibleText(filterSelect,"[Reset Filter]");}
    public void clickOnUseFilter(){click(useFilterButton);}
    public void typeSearch(String issue) {sendKeys(searchField,issue);}
    public void clickOnApplyFilter() {click(applyFilterButton);}
    public void clickOnEditIssue(){click(editIssueLink);}
    public void clickOnIdIssue(){click(idIssueLink);}
    public void clickOnAssignedTo(){click(assignedToLink);}
    public void selectAssignedTo(String user){
        waitForElementToBeClickable(assignedToSelect);
        comboBoxSelectByVisibleText(assignedToSelect,user);
    }
    public String returnAssignedToText(){return getText(assignedToText);}
}
