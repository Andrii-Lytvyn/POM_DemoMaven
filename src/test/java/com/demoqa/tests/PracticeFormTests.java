package com.demoqa.tests;

import com.demoqa.data.StudentData;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.PracticeFormPage;
import com.demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(wd).getForms();
        new SidePanel(wd).selectPracticeForm().hideIFrames();
    }

    @Test
    public void fillPracticeFormTest() {
        new PracticeFormPage(wd).hideAd();
        new PracticeFormPage(wd).enterPersonalData("John", "Wick", "boogieman@gmail.com", "0123456789")
                .selectGender("Male")
               // .typeData("17 May 2000")
                .selectDate("May","1963","13")
                .addSubject(new String[]{"Math", "English", "Chemistry"})
                .selectHobby(new String[]{"Sports", "Reading", "Music"})
                .uploadFile("C:/Tools/vine.jpg")
                .enterAddress("victory strasse, 2")
                .selectState("NCR")
                .selectCity("Delhi")
                .submit();

    }

    @Test
    public void fillPracticeFormWithFinalData() {
        new PracticeFormPage(wd).hideAd();
        new PracticeFormPage(wd).enterPersonalData(StudentData.FIRST_NAME, StudentData.LAST_NAME, StudentData.EMAIL,
                        StudentData.PHONE_NUMBER)
                .selectGender(StudentData.GENDER)
                .typeData(StudentData.B_DAY)
                .addSubject(StudentData.SUBJECTS)
                .selectHobby(StudentData.HOBBIES)
                .uploadFile(StudentData.PHOTO_PATH)
                .enterAddress(StudentData.ADDRESS)
                .selectState(StudentData.STATE)
                .selectCity(StudentData.CITY)
                .submit();

    }
}
