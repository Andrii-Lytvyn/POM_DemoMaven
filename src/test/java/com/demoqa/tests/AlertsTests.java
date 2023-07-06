package com.demoqa.tests;

import com.demoqa.pages.AlertsPage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AlertsTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(wd).getAlertsFrameWindows();
        new SidePanel(wd).selectAlerts();
    }

    @Test
    public void sendMessageToAlertTest() {
        new AlertsPage(wd).sendMessageToAlert("Hello world")
                .assertMessage("Hello world");
    }

    @Test
    public void clickButtonToSeeAlert() {
        new AlertsPage(wd).clickAllertButton();
        wd.switchTo().alert().accept();
    }

    @Test
    public void OnButtonClick5Sec() {
        new AlertsPage(wd).clickTimerAlertButton();

    }

    @Test
    public void onButtonClickConfirmBoxTest() {
        AlertsPage AP = new AlertsPage(wd).onButtonClickConfirmBox();
        wd.switchTo().alert().accept();
        Assert.assertTrue(AP.isTextCorrect());
    }
    @Test
    public void onButtonClickCancelBoxTest() {
        AlertsPage AP = new AlertsPage(wd).onButtonClickConfirmBox();
        wd.switchTo().alert().dismiss();
        Assert.assertTrue(AP.isTextCancelCorrect());
    }

}
