package org.jaredsalinas.base.ios;

import org.jaredsalinas.base.ios.BaseTest;
import org.jaredsalinas.utilities.GlobalVariables;
import org.jaredsalinas.utilities.Waits;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class BasePage extends BaseTest {

    public static void setText(WebElement element, String text){
        Waits.explicitWaitForVisibilityOfElement(element, driver, GlobalVariables.DELAY_MEDIUM);
        element.clear();
        element.sendKeys(text);
    }

    public static void setText(WebElement element, Keys k){
        Waits.explicitWaitForVisibilityOfElement(element, driver, GlobalVariables.DELAY_MEDIUM);
        element.sendKeys(k);
    }

    public static String getText(WebElement element){
        Waits.explicitWaitForVisibilityOfElement(element, driver, GlobalVariables.DELAY_MEDIUM);
        return element.getText();
    }

    public static String getAttributeValue(WebElement element, String value){
        //Waits.explicitWaitForVisibilityOfElement(element, driver, GlobalVariables.DELAY_MEDIUM);
        return element.getAttribute(value);
    }

    public static void verifyEquals(String expectedText, String actualText){
        Assert.assertEquals(expectedText, actualText);
    }

    public static void clickAndWait(WebElement element){
        Waits.explicitWaitForVisibilityOfElement(element, driver, GlobalVariables.DELAY_MEDIUM);
        element.click();
        Waits.sleep(GlobalVariables.DELAY_FOR_A_SEC);
    }

}
