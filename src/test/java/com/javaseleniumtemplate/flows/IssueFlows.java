package com.javaseleniumtemplate.flows;

import com.javaseleniumtemplate.GlobalParameters;
import com.javaseleniumtemplate.pages.BugReportPage;
import com.javaseleniumtemplate.pages.BugUpdatePage;
import com.javaseleniumtemplate.pages.MyViewPage;
import com.javaseleniumtemplate.pages.ViewAllBugPage;

public class IssueFlows {
    //Objects and constructor
    MyViewPage myViewPage;
    ViewAllBugPage viewAllBugPage;
    BugUpdatePage bugUpdatePage;

    public IssueFlows() {
        myViewPage = new MyViewPage();
        viewAllBugPage = new ViewAllBugPage();
        bugUpdatePage = new BugUpdatePage();
    }
    //Parameters
    String issue = GlobalParameters.ISSUE;

    public void goToViewIssuesAndSearchIssue(){
        myViewPage.clickOnViewIssues();

        viewAllBugPage.selectResetFilter();
        viewAllBugPage.clickOnUseFilter();
        viewAllBugPage.typeSearch(issue);
        viewAllBugPage.clickOnApplyFilter();
    }

}
