package org.jaredsalinas.base.android;

import org.jaredsalinas.utilities.GlobalVariables;
import org.jaredsalinas.utilities.Waits;
import org.openqa.selenium.*;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.AppiumBy;
import org.testng.Assert;


public class BasePage extends BaseTest {

	public static void switchToLandScape() {
		
		DeviceRotation landScape = new DeviceRotation(0,0, 90);
		driver.rotate(landScape);
	}

	public static void setText(WebElement element, String text){
		Waits.explicitWaitForVisibilityOfElement(element, driver, GlobalVariables.DELAY_MEDIUM);
		element.clear();
		element.sendKeys(text);
	}

	public static void setText(WebElement element, Keys k){
		Waits.explicitWaitForVisibilityOfElement(element, driver, GlobalVariables.DELAY_MEDIUM);
		element.sendKeys(k);
	}

	public Double getFormatedAmout(String amout) {

		Double price = Double.parseDouble(amout.replace(GlobalVariables.DOLAR_SIGN, GlobalVariables.EMPTY_SPACE).trim());
		return price;

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
		Waits.implicitWait(GlobalVariables.DELAY_MEDIUM);
	}

	public static WebElement findElementByXpath(String xpath){

		return driver.findElement(By.xpath(xpath));
	}

	public static WebElement findElementByID(String id){

		return driver.findElement(By.id(id));
	}
	
}
