package org.jaredsalinas.pages.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.jaredsalinas.base.ios.BasePage;
import org.jaredsalinas.pagesObjects.ios.AlertViewsPageObjects;
import org.jaredsalinas.pagesObjects.ios.HomePageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AlertViewsPage extends BasePage {


    private IOSDriver driver;
    public AlertViewsPage(){

    }
    public AlertViewsPage(IOSDriver driver){

        this.driver= driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(xpath = AlertViewsPageObjects.XPATH_BTN_NAME_ENTRY)
    private WebElement btnNameEntry;

    @iOSXCUITFindBy(iOSClassChain = AlertViewsPageObjects.CLASS_CHAIN_TXT_NAME_ENTRY)
    private WebElement txtNameEntry;

    @iOSXCUITFindBy(iOSClassChain = AlertViewsPageObjects.CLASS_CHAIN_BTN_OK)
    private WebElement btnOKButton;

    @iOSXCUITFindBy(xpath = AlertViewsPageObjects.PREDICATED_STRING_TXT_MESSAGE)
    private WebElement labelMessage;

    @iOSXCUITFindBy(xpath = AlertViewsPageObjects.PREDICATED_STRING_BTN_CONFIRM)
    private WebElement btnConfirm;

    @iOSXCUITFindBy(xpath = AlertViewsPageObjects.PREDICATED_STRING_BTN_CONFIRM_CANCEL)
    private WebElement btnCancelConfirm;


    public void clickOnTextEntry(){

        clickAndWait(btnNameEntry);
    }

    public  void clickOnOkButton(){
        clickAndWait(btnOKButton);
    }

    public void enterName(String name){

        setText(txtNameEntry,name);
    }

    public void verifyMessage(String expectedMessage){

        verifyEquals(getText(labelMessage), expectedMessage);

    }

    public void clickOnConfirmButton(){

        clickAndWait(btnConfirm);
    }






}
