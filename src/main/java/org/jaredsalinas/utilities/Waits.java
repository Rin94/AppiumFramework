package org.jaredsalinas.utilities;

import java.nio.channels.InterruptedByTimeoutException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.jaredsalinas.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;

import java.time.Duration.*;

import static java.time.Duration.ofSeconds;

public class Waits extends BaseTest {
	
	public Waits() {
		
		throw new IllegalStateException("Waits Class");
	}
	
	
	public static void sleep (long time) {
		
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public static void implicitWait(int timeInSeconds) {
		
		driver.manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS);
	}
	
	public static void explicitWait(WebElement element, WebDriver driver, int timeInSecnonds, String condition,
			String locator) {
		
		WebDriverWait wait = new WebDriverWait(driver, ofSeconds(timeInSecnonds));
		
		try {
			switch (condition.toLowerCase()) {
			case "xpath":
				element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
				break;
				
			case "id":
				element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
				break;
				
			case "name":
				element = wait.until(ExpectedConditions.presenceOfElementLocated(By.name(locator)));
				break;
				
			case "class":
				element = wait.until(ExpectedConditions.presenceOfElementLocated(By.className(locator)));
				break;
				
			default:
				element =  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
				break;

			}
		}catch (NoSuchElementException ex) {
			
				
		}
		element.click();
		
		
	}
	
	public static void explicitWaitForVisibilityOfElement(WebElement element,WebDriver driver, int timeInSeconds) {
		
		WebDriverWait wait = new WebDriverWait(driver, ofSeconds(timeInSeconds));
		
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public static void explicitWaitForVisibilityOfElement(String xPath,WebDriver driver, int timeInSeconds) {
		
		WebDriverWait wait = new WebDriverWait(driver, ofSeconds(timeInSeconds));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
		
		
	}
	
	public static void explicitWaitTillElementIsClickable(WebElement element,WebDriver driver, int timeInSeconds) {
		
		WebDriverWait wait = new WebDriverWait(driver, ofSeconds(timeInSeconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	public static void explicitWaitForNotVisibilityOfElement(String xpath,WebDriver driver, int timeInSeconds) {
		
		WebDriverWait wait = new WebDriverWait(driver, ofSeconds(timeInSeconds));
		
		try {
			wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))));
			
		}catch(TimeoutException ex) {
			
		}
		
	}
	
	public static void generalTimeOut(AndroidDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(ofSeconds(GlobalVariables.DELAY_LOW));
		
		
	}
	
	

}
