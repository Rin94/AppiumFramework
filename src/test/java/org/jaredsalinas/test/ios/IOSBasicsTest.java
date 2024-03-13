package org.jaredsalinas.test.ios;


import org.jaredsalinas.base.ios.BaseTest;
import org.jaredsalinas.pages.android.CartPage;
import org.jaredsalinas.pages.android.FormPage;
import org.jaredsalinas.pages.android.ProductCatalogPage;
import org.jaredsalinas.pages.ios.AlertViewsPage;
import org.jaredsalinas.pages.ios.HomePage;
import org.jaredsalinas.utilities.GlobalVariables;
import org.jaredsalinas.utilities.Waits;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import io.appium.java_client.AppiumBy;


public class IOSBasicsTest extends BaseTest {

    private String className;
    HomePage homePage;

    AlertViewsPage alertViewsPage;

    @BeforeClass
    public void intializeTabInstances() {

        className = this.getClass().getSimpleName();
        homePage= new HomePage(driver);
        alertViewsPage = new AlertViewsPage(driver);

    }

    @Test
    public void IOSBasicsDemo() {

        homePage.clickOnAlertViewLink();
        alertViewsPage.clickOnTextEntry();
        alertViewsPage.enterName("Hello World");
        alertViewsPage.clickOnOkButton();
        Waits.sleep(GlobalVariables.DELAY_FIVE_SEC);


    }


}
