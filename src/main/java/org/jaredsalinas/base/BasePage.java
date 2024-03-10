package org.jaredsalinas.base;

import java.lang.reflect.Method;

import net.bytebuddy.agent.builder.AgentBuilder;
import org.jaredsalinas.utilities.GlobalVariables;
import org.jaredsalinas.utilities.Waits;
import org.openqa.selenium.*;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.testng.Assert;


public class BasePage extends BaseTest {
	
	
public void switchToLandScape() {
		
		DeviceRotation landScape = new DeviceRotation(0,0, 90);
		driver.rotate(landScape);
	}
	
	public static void setText(WebElement element, String text){
		Waits.explicitWaitForVisibilityOfElement(element, driver, GlobalVariables.DELAY_MEDIUM);
		element.clear();
		element.sendKeys(text);
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
	
	public static void longPressAction(WebElement element) {
		
		
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId",
				((RemoteWebElement)element).getId(),
				"duration", 2000));
			
		
	}
	
	public void startActivity(String intent) {
        ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of(
				//right or right, percent how mucho you put your tumb to swipe
				"intent", intent
				));
	}
	
	public Double getFormatedAmout(String amout) {

		Double price = Double.parseDouble(amout.replace(GlobalVariables.DOLAR_SIGN, GlobalVariables.EMPTY_SPACE).trim());
		return price;
		
	}
	
	public static void scrollViewUntilTextAppears(String expectedText) {
		
		driver.findElement(AppiumBy.androidUIAutomator
				("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+expectedText+"\"));"));
		Waits.sleep(GlobalVariables.DELAY_VERYLOW);
	}
	
	public static boolean scrollView(int left, int top, int width, int height, String direction) {
		
		return(Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", left, "top", top, "width", width, "height", height,
			    "direction", direction,
			    "percent", 3.0
			));
		
	}
	
	public static void scrollToEnd() {
		boolean canScrollMore;
		do {
			
			canScrollMore=(Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				    "left", 100, "top", 100, "width", 200, "height", 200,
				    "direction", "down",
				    "percent", 3.0));
		}while(canScrollMore);
		Waits.sleep(GlobalVariables.DELAY_LOW*100);
	}
	
	
	public static void swipeAction(WebElement element, String direction) {
		
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				//right or right, percent how mucho you put your tumb to swipe
				"elementId",((RemoteWebElement)element).getId(), 
				"direction",direction,
				"percent", 0.75
				));
		Waits.sleep(GlobalVariables.DELAY_LOW*100);
		
	}
	
	public static void dragAndDrop(WebElement element) {
		// Java
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
		    "elementId", ((RemoteWebElement) element).getId(),
		    "endX", 836,
		    "endY", 740

		));
	}

	public static WebElement findElementByXpath(String xpath){

		return driver.findElement(By.xpath(xpath));
	}
	
}
