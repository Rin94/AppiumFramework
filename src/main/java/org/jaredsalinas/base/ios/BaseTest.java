package org.jaredsalinas.base.ios;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.jaredsalinas.utilities.GlobalVariables;
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
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import static java.time.Duration.ofSeconds;


public class
BaseTest {

    public static IOSDriver driver;
    public AppiumDriverLocalService service;
    @BeforeClass
    public void ConfigureAppium() {

        service = new AppiumServiceBuilder().withAppiumJS(new File (GlobalVariables.APPIUM_PATH)).
                withIPAddress("127.0.0.1").usingPort(4723).build();

        service.start();
        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone SE (3rd generation)");
        options.setApp(GlobalVariables.IOS_EMULATOR_PATH);
        options.setPlatformVersion("17.2");
        options.setWdaLaunchTimeout(ofSeconds(10));

        try {
            driver = new IOSDriver(new URL(GlobalVariables.APPIUM_SERVER_URL),options);

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @AfterClass
    public void tearDown() {

        driver.quit();
        service.stop();

    }

}

