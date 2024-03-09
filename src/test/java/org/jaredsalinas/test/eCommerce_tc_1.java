package org.jaredsalinas.test;

import java.util.Set;

import org.jaredsalinas.base.BaseTest;
import org.jaredsalinas.utilities.GlobalVariables;
import org.jaredsalinas.utilities.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;



public class eCommerce_tc_1 extends BaseTest{
	
	
private String className;
private HomePage homePage;
private ProductsPage productsPage;
private CartPage cartPage;
private String productName2;
private String productName1;
	
	
	
	@BeforeClass
	public void intializeTabInstances() {
		
		className = this.getClass().getSimpleName();
		
		productName1="Air Jordan 4 Retro";
		productName2="Jordan 6 Rings";
		
		
		
	}
	
	@Test(priority = 5)
	public void FillForm() {
		
		//verify error message
		Waits.sleep(GlobalVariables.DELAY_VERYLOW);
		homePage.clickOnLetShopButton();
		homePage.verifyErrorMesagge("Please enter your name");
		Waits.sleep(GlobalVariables.DELAY_VERYLOW);
		homePage.selectCountry("Belgium");
		homePage.setName("Jared");
		driver.hideKeyboard();
		homePage.clickOnMaleRadio();
		homePage.clickOnLetShopButton();
		Waits.sleep(GlobalVariables.DELAY_VERYLOW);
		
		
		
	}
	
	@Test(priority = 10 )
	public void AddProductToCart() {
	
		productsPage.addProductToCart(productName1);
		
		
	}
	
	
	@Test(priority = 15 )
	public void AddingAnotherProductToCart() {
	
		productsPage.addProductToCart(productName2);
		
	}
	
	@Test(priority = 20)
	public void verifyProductInCart() {
		
		productsPage.clickOnShoppingCart();
		cartPage.waitUntilShoppingCartIsDisplayed();
		cartPage.verifyShoppingCartProduct(productName1,0);
		cartPage.verifyShoppingCartProduct(productName2,1);
		cartPage.verifyProductCount();
		
		
	}
	
	@Test(priority = 25)
	public void completePurchase() {
		
		cartPage.verifyTermsOfConditions();
		cartPage.clickOnCloseTermOfConditionPopup();
		cartPage.checkSendMeEmails();
		cartPage.clickCompletePurchase();
		Waits.sleep(GlobalVariables.DELAY_FIVE_SEC);
	}
	
	@Test(priority= 30)
	public void hybridAppTest() {
		
		Waits.sleep(GlobalVariables.DELAY_FIVE_SEC);
		Set <String> contexts =driver.getContextHandles();
		
		for(String contextName :contexts) {
			System.out.println(contextName);
		}
		
		//YOU NEED TO SET CHROME DRIVER
		
		driver.context("WEBVIEW_com.androidsample.generalstore");
		
		
		driver.findElement(By.name("q")).sendKeys("Jared Daniel Salinas");
	
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Waits.sleep(GlobalVariables.DELAY_FIVE_SEC);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
	}
	

}
