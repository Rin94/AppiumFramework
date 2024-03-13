package org.jaredsalinas.pages.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.jaredsalinas.base.ios.BasePage;
import org.jaredsalinas.pagesObjects.ios.HomePageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    //IOSDriver driver;

    @iOSXCUITFindBy(id = HomePageObjects.ID_LINK_ALERT_VIEWS)
    private WebElement linkAlertViews;

    public HomePage(IOSDriver driver){

        //this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public HomePage(){

    }

    public void clickOnAlertViewLink(){

        clickAndWait(linkAlertViews);
    }



}
