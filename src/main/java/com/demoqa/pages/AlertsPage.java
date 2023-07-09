package com.demoqa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AlertsPage extends BasePage {

    public AlertsPage(WebDriver wd) {
        super(wd);
    }

    public boolean isAlertPresent(int duration) {

        Alert alert = new WebDriverWait(wd, Duration.ofSeconds(duration))
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        } else {
            wd.switchTo().alert();
            alert.accept();
            return true;
        }
    }

    @FindBy(id = "promtButton")
    WebElement promtButton;

    public AlertsPage sendMessageToAlert(String message) {
        clickWithJSExecutor(promtButton, 0, 300);
        if (message != null) {
            wd.switchTo().alert().sendKeys(message);
            wd.switchTo().alert().accept();
        }
        return this;
    }

    @FindBy(id = "promptResult")
    WebElement promptResult;

    public AlertsPage assertMessage(String message) {
        Assert.assertTrue(promptResult.getText().contains(message));
        return this;
    }

    @FindBy(id = "alertButton")
    WebElement alertButton;

    public AlertsPage clickAllertButton() {
        clickWithJSExecutor(alertButton, 0, 300);
        wd.switchTo().alert().accept();
        return this;
    }

    @FindBy(id = "timerAlertButton")
    WebElement timerAlertButton;

    public AlertsPage clickTimerAlertButton() {
        clickWithJSExecutor(timerAlertButton, 0, 300);
        Assert.assertTrue(isAlertPresent(6));
        return this;
    }

    @FindBy(id = "confirmButton")
    WebElement confirmButton;
    @FindBy(id = "confirmResult")
    WebElement confirmResult;

    public AlertsPage onButtonClickConfirmBox(boolean solution) {
        AlertsPage AP = new AlertsPage(wd);
        clickWithJSExecutor(confirmButton, 0, 300);
        if (solution) {
            wd.switchTo().alert().accept();
            Assert.assertTrue(AP.isTextCorrect(solution));
        } else {
            wd.switchTo().alert().dismiss();
            Assert.assertTrue(AP.isTextCorrect(solution));
        }
        return this;
    }

    public boolean isTextCorrect(boolean solution) {
        String text = confirmResult.getText();
        if (solution) {
            if (text.equalsIgnoreCase("You selected Ok")) {
                return true;
            }
        } else {
            if (text.equalsIgnoreCase("You selected Cancel")) {
                return true;
            }
        }
        return false;
    }
}

