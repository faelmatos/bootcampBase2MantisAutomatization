package com.javaseleniumtemplate.tests;

import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.flows.IssueFlows;
import com.javaseleniumtemplate.flows.LoginFlows;
import com.javaseleniumtemplate.pages.*;
import com.javaseleniumtemplate.utils.Utils;
import org.junit.Assert;
import org.junit.Test;

public class IssueTests extends TestBase {

    //Objects
    LoginFlows loginFlows;
    IssueFlows issueFlows;
    MyViewPage myViewPage;
    BugReportPage bugReportPage;
    ViewAllBugPage viewAllBugPage;
    BugUpdatePage bugUpdatePage;
    ViewIssuePage viewIssuePage;
    BugChangeStatusPage bugChangeStatusPage;

    //Tests
    @Test
    public void createIssueWithSuccess(){
        //Object Instances
        loginFlows = new LoginFlows();
        myViewPage = new MyViewPage();
        bugReportPage = new BugReportPage();

        //Parameteres
        String operationSucessfulMessage = "Operation successful.";
        String category = "[All Projects] Teste Rafael Matos";
        String reproducibility = "have not tried";
        String severity = "feature";
        String priority = "high";
        String profile = "Desktop Windows 10";
        String platform = "Desktop";
        String os = "Windows";
        String osVersion = "10";
        String assignTo = "rafael.matos";
        String summary = "Issue de Teste";
        String description = "Descrição da Issue de Teste";
        String stepsToReproduce = "Passo1\nPasso2\nPasso3";
        String additionalInformation = "Informações adicionais";

        //Tests
        loginFlows.login();
        myViewPage.clickOnReportIssue();

        bugReportPage.selectCategory(category);
        bugReportPage.selectReproducibility(reproducibility);
        bugReportPage.selectSeverity(severity);
        bugReportPage.selectPriority(priority);
        bugReportPage.selectProfile(profile);
        bugReportPage.typePlatform(platform);
        bugReportPage.typeOs(os);
        bugReportPage.typeOsVersion(osVersion);
        bugReportPage.selectAssignTo(assignTo);
        bugReportPage.typeSummary(summary);
        bugReportPage.typeDescription(description);
        bugReportPage.typeStepsToReproduce(stepsToReproduce);
        bugReportPage.typeAdditionalInformation(additionalInformation);
        bugReportPage.clickOnSubmitReportButton();

        Assert.assertTrue(bugReportPage.returnOperationSuccessfulMessage().contains(operationSucessfulMessage));
    }

    @Test
    public void editIssueWithSuccess(){
        //Object Instances
        loginFlows = new LoginFlows();
        issueFlows = new IssueFlows();
        myViewPage = new MyViewPage();
        viewAllBugPage = new ViewAllBugPage();
        bugUpdatePage = new BugUpdatePage();

        //Parameters
        String status = "confirmed";
        String note = "Anotação do usuário";

        //Tests
        loginFlows.login();
        issueFlows.goToViewIssuesAndSearchIssue();

        viewAllBugPage.clickOnEditIssue();
        bugUpdatePage.selectStatus(status);
        bugUpdatePage.typeNewNote(note);
        bugUpdatePage.clickOnUpdateInformationButton();

        Assert.assertTrue(bugUpdatePage.returnHourOfUpdateIssue().contains(Utils.getNowDate("yyyy-MM-dd HH:mm")));
    }

    @Test
    public void changeStatusIssueToResolveWithSuccess(){
        //Object Instances
        loginFlows = new LoginFlows();
        issueFlows = new IssueFlows();
        viewAllBugPage = new ViewAllBugPage();
        viewIssuePage = new ViewIssuePage();
        bugChangeStatusPage = new BugChangeStatusPage();

        //Parameters
        String newStatus = "resolved";
        String resolution = "fixed";
        String note = "Issue implemented successfully ";

        //Tests
        loginFlows.login();
        issueFlows.goToViewIssuesAndSearchIssue();
        viewAllBugPage.clickOnIdIssue();
        viewIssuePage.selectNewStatus(newStatus);
        viewIssuePage.clickOnChangeStatusTo();
        bugChangeStatusPage.selectResolution(resolution);
        bugChangeStatusPage.typeNewNote(note);
        bugChangeStatusPage.clickOnResolveIssueButton();

        Assert.assertEquals(newStatus,viewIssuePage.returnStatusIssue());
    }

    @Test
    public void searchIssuesAssignToUserWithSuccess(){
        //Object Instances
        loginFlows = new LoginFlows();
        viewAllBugPage = new ViewAllBugPage();
        myViewPage = new MyViewPage();

        //Parameters
        String user = "rafael.matos";

        loginFlows.login();
        myViewPage.clickOnViewIssues();
        viewAllBugPage.selectResetFilter();
        viewAllBugPage.clickOnUseFilter();
        viewAllBugPage.clickOnAssignedTo();
        viewAllBugPage.selectAssignedTo(user);
        viewAllBugPage.clickOnApplyFilter();

        Assert.assertEquals(user,viewAllBugPage.returnAssignedToText());
    }
}
