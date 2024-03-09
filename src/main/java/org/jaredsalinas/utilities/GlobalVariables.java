package org.jaredsalinas.utilities;

import org.jaredsalinas.common.CurrentDateAndTime;

public class GlobalVariables {

	public static String ECLIPSE_PATH ="//Users//jaredsalinas//eclipse-workspace//appiumTutorial";
	public static String LOCAL_MACHINE_PATH= "//Users//jaredsalinas//";
	public static String APPIUM_PATH = "//usr//local//lib//node_modules//appium//build//lib//main.js";
	public static String APP_PATH ="//AppiumQA//src//test//java//resources//ApiDemos-debug.apk";
	public static String ECOMMERCE_APP_PATH ="//AppiumQA//src//test//java//resources//General-Store.apk";
	public static String APPIUM_SERVER_URL ="http://127.0.0.1:4723";
	public static String CHROME_DRIVER_PATH = "//Users//jaredsalinas//eclipse-workspace//appiumTutorial//AppiumQA//src//test//java//driver//chromedriver";


	public static final String CURRENT_DATE_TIME = CurrentDateAndTime.getCurrentDateTime();
	public static final String CURRENT_DATE = CurrentDateAndTime.getCurrentDate();
	public static final String CURRENT_TIME = CurrentDateAndTime.getCurrentTime();
	public static final String CUSTOM_DATE = CurrentDateAndTime.customizeDate();

	public static boolean REPORT_COMPARISON_MANUALLY;

	public static final int DELAY_FOR_A_SEC = 1;
	public static final int DELAY_VERYLOW = 2;
	public static final int DELAY_FIVE_SEC = 5;
	public static final int DELAY_LOW = 10;
	public static final int DELAY_MEDIUM = 15;
	public static final int DELAY_HIGH = 20;
	public static final int DELAY_VERYHIGH = 40;
	public static final int PAGE_LOADING_TIME = 40;

	public static final String SCROLL_DOWN = "Down";

	public static String CURRENT_TEST_DESCRIPTION;

	public static final String EXTENT_REPORTS_FOLDER_PATH = "\\extent-Reports\\";

	// Get System property
	public static final String SYSTEM_DIR = System.getProperty("user.dir");

	// Locators or Objects Find By operators
	public static final String FIND_BY_XPATH = "xpath";
	public static final String FIND_BY_ID = "id";
	public static final String FIND_BY_NAME = "name";
	public static final String FIND_BY_CLASS = "class";

	// Failed Test Scenario screenshot folder path
	public static final String SCREENSHOT_FOLDER_PATH = "\\test-output\\failTestScenarioScreenshots\\";

	public static final String SCREENSHOT_TYPE_STORE_INSIDE_FOLDER = "Store inside Folder";
	public static final String SCREENSHOT_TYPE_BASE64 = "Base64";

	public static final String DOWNLOAD_IMAGE_FILE_PATH = "\\src\\test\\resources\\downloadImages\\";
	public static final String STORED_IMAGE_FILE_PATH = "\\src\\test\\resources\\storedImages\\";
	public static final String DOLAR_SIGN = "$";
	public static final String EMPTY_SPACE = "";
	public static final String GOOGLE_PATH = "http://google.com";
	public static final String ANGULAR_WEB_APP_PATH = "https://rahulshettyacademy.com/angularAppdemo/";
	public static final String IOS_EMULATOR_PATH = "/Users/jaredsalinas/Library/Developer/Xcode/DerivedData/UIKitCatalog-dacpbpoipeblmycnclmqxtchfaun/Build/Products/Debug-iphonesimulator/UIKitCatalog.app";
	public static final String IOS_TEST_APP_3_PATH = "AppiumQA/src/test/java/resources/TestApp 3.app";




}
