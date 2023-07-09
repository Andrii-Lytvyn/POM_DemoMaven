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
    }

    @Test
    public void OnButtonClick5Sec() {
        new AlertsPage(wd).clickTimerAlertButton();
    }

    @Test
    public void onButtonClickConfirmBoxTest() {
        new AlertsPage(wd).onButtonClickConfirmBox(false);
    }

}
