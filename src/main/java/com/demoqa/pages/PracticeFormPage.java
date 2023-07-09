package com.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormPage extends BasePage {
    public PracticeFormPage(WebDriver wd) {
        super(wd);
    }


    @FindBy(id = "firstName")
    WebElement firstName;
    @FindBy(id = "lastName")
    WebElement lastName;
    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "userNumber")
    WebElement userNumber;

    public PracticeFormPage enterPersonalData(String fName, String lName, String email, String phone) {
        type(firstName, fName);
        type(lastName, lName);
        type(userEmail, email);
        typeWithJSExecutor(userNumber, phone, 0, 200);

        return this;
    }

    @FindBy(css = "[for='gender-radio-1']")
    WebElement male;
    @FindBy(css = "[for='gender-radio-2']")
    WebElement female;
    @FindBy(css = "[for='gender-radio-3']")
    WebElement other;

    public PracticeFormPage selectGender(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            click(male);
        } else if (gender.equalsIgnoreCase("female")) {
            click(female);
        } else click(other);


        return this;
    }

    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirthInput;

    public PracticeFormPage typeData(String bDay) {
        click(dateOfBirthInput);
        selectOS(dateOfBirthInput);
        dateOfBirthInput.sendKeys(bDay);
        dateOfBirthInput.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id = "subjectsInput")
    WebElement subjectsInput;

    public PracticeFormPage addSubject(String[] subjects) {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] != null) {
                type(subjectsInput, subjects[i]);
                subjectsInput.sendKeys(Keys.ENTER);
            }
        }
        return this;
    }

    @FindBy(css = "[for='hobbies-checkbox-1']")
    WebElement sports;
    @FindBy(css = "[for='hobbies-checkbox-2']")
    WebElement reading;
    @FindBy(css = "[for='hobbies-checkbox-3']")
    WebElement music;

    public PracticeFormPage selectHobby(String[] hobbies) {
        for (int i = 0; i < hobbies.length; i++) {
            if (hobbies[i].equalsIgnoreCase("sports")) {
                click(sports);
            }
            if (hobbies[i].equalsIgnoreCase("reading")) {
                click(reading);
            }
            if (hobbies[i].equalsIgnoreCase("music")) {
                click(music);
            }
        }
        return this;
    }

    @FindBy(id = "uploadPicture")
    WebElement uploadPicture;

    public PracticeFormPage uploadFile(String path) {
        uploadPicture.sendKeys(path);
        return this;
    }

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    public PracticeFormPage enterAddress(String address) {
        typeWithJSExecutor(currentAddress, address, 0, 300);
        return this;
    }

    @FindBy(id = "state")
    WebElement stateContainer;
    @FindBy(id = "react-select-3-input")
    WebElement stateInput;

    public PracticeFormPage selectState(String state) {
        click(stateContainer);
        stateInput.sendKeys(state);
        stateInput.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id = "city")
    WebElement cityContainer;
    @FindBy(id = "react-select-4-input")
    WebElement cityInput;

    public PracticeFormPage selectCity(String city) {
        click(cityContainer);
        cityInput.sendKeys(city);
        cityInput.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id = "submit")
    WebElement submit;

    public PracticeFormPage submit() {
        clickWithRectangle(submit, 2, 3);
        return this;
    }

    @FindBy(css = ".react-datepicker__month-select")
    WebElement month;
    @FindBy(css = ".react-datepicker__year-select")
    WebElement year;

    public PracticeFormPage selectDate(String m, String y, String day) {
        click(dateOfBirthInput);

        Select select = new Select(month);
        select.selectByVisibleText(m);

        Select selectYear = new Select(year);
        selectYear.selectByVisibleText(y);

        wd.findElement(By.xpath("//div[.='" + day + "']")).click();

        return this;
    }


    @FindBy(id = "example-modal-sizes-title-lg")
    WebElement exampleModal;

    public PracticeFormPage assertNewWindowRegistrationMessage(String text) {
        wd.switchTo().parentFrame();
        Assert.assertTrue(shouldHaveText(exampleModal, text, 15));
        return this;
    }
}