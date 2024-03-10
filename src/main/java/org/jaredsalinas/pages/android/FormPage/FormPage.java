package org.jaredsalinas.pages.android.FormPage;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.jaredsalinas.base.BasePage;
import org.jaredsalinas.pagesObjects.android.FormPageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FormPage extends BasePage {

    AndroidDriver driver;
    public FormPage(AndroidDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public FormPage(){

    }
    @AndroidFindBy(id = FormPageObjects.ID_TXT_FIELD_NAME)
    private WebElement txtNameField;

    @AndroidFindBy( id=FormPageObjects.ID_RADIO_MALE_FIELD)
    private WebElement radioMaleField;

    @AndroidFindBy(id=FormPageObjects.ID_RADIO_MALE_FIELD)
    private WebElement radioFemaleField;

    @AndroidFindBy(id=FormPageObjects.ID_SPINNE_COUNTRY_FIELD)
    private WebElement spinnerCountry;

    @AndroidFindBy(id=FormPageObjects.ID_BTN_LETSSHOP)
    private WebElement btnLetShop;

    @AndroidFindBy(xpath=FormPageObjects.XPATH_TXT_TOAST_MESSAGE)
    private WebElement txtToastErrorMessage;

    //////METHODS //////////
    public void setName(String name) {

       setText(txtNameField,name);
    }

    public void selectCountry(String countryName) {

        //Select selector =new Select(spinnerCountry);
        clickAndWait(spinnerCountry);
        scrollViewUntilTextAppears(countryName);
        WebElement txtCountryName= FormPageObjects.getWebElementByCountryName(countryName, driver);
        clickAndWait(txtCountryName);
    }

    public void verifyErrorMesagge(String expectedText) {

        String actualText = getAttributeValue(txtToastErrorMessage,"name");
        verifyEquals(expectedText,actualText);
    }

    public void clickOnMaleRadio() {
        clickAndWait(radioMaleField);
    }

    public void clickOnFemaleRadio() {
        clickAndWait(radioFemaleField);
    }

    public void clickOnLetShopButton() {

       clickAndWait(btnLetShop);
    }



}
