package com.demoqa.tests;

import com.demoqa.pages.DroppablePage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SelectMenuPage;
import com.demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(wd).getWidgets();
        new SidePanel(wd).selectSelectMenu();
    }

    @Test
    public void selectOldStyleTest() {
        new SelectMenuPage(wd).selectOldStyle("Blue");
    }

    @Test
    public void multiSelectTest() {
        new SelectMenuPage(wd).multiSelect(new String[]{"Blue", "Black", "Red"});
    }

    @Test
    public void standartMultiSelectTest(){
        new SelectMenuPage(wd).standartMultiSelect(2);
    }

    @Test
    public void selectValueTest() {
        new SelectMenuPage(wd).selectValue(new String[]{"Group 1, option 1",
                "Group 1, option 2",
                "Group 2, option 1",
                "Group 2, option 2",
                "A root option",
                "Another root option"
        } , 5);
    }
    @Test
    public void selectOneTest() {
        new SelectMenuPage(wd).selectOne(new String[]{"Dr.",
                "Mr.",
                "Mrs.",
                "Prof.",
                "Other",
        } , 4);
    }

}
