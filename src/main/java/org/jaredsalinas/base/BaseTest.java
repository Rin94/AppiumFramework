package org.jaredsalinas.base;


import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import org.jaredsalinas.utilities.GlobalVariables;
import org.jaredsalinas.utilities.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class BaseTest {
	
	public static AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() {
		
	
		service = new AppiumServiceBuilder().withAppiumJS(new File (GlobalVariables.APPIUM_PATH)).
				withIPAddress("127.0.0.1").usingPort(4723).build(); 
		service.start();
		
		//Create AndroidDriver object, iOSDriver
		//Appium code -> Appium Server - > Mobile
		UiAutomator2Options options= new UiAutomator2Options();
		options.setDeviceName("JaredSalinasEmulator");
		options.setChromedriverExecutable(GlobalVariables.CHROME_DRIVER_PATH);
		//options.setApp(GlobalVariables.ECLIPSE_PATH+GlobalVariables.APP_PATH);
		options.setApp(GlobalVariables.ECLIPSE_PATH+GlobalVariables.ECOMMERCE_APP_PATH);
		
		try {
			driver = new AndroidDriver(new URL(GlobalVariables.APPIUM_SERVER_URL),options);
			Waits.generalTimeOut(driver);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();		
		// stop the service
		service.stop();
		
		
	}

}
