package org.jaredsalinas.test.android;

import java.util.Set;

import org.jaredsalinas.base.android.BaseTest;
import org.jaredsalinas.pages.android.CartPage;
import org.jaredsalinas.pages.android.FormPage;
import org.jaredsalinas.pages.android.ProductCatalogPage;
import org.jaredsalinas.pages.hybrid.WebBrowserPage;
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
private FormPage formPage;
private ProductCatalogPage productsPage;
private CartPage cartPage;
private String productName2;
private String productName1;
	
	
	
	@BeforeClass
	public void intializeTabInstances() {
		
		className = this.getClass().getSimpleName();
		formPage = new FormPage(driver);
		productsPage = new ProductCatalogPage(driver);
		cartPage = new CartPage(driver);
		productName1="Air Jordan 4 Retro";
		productName2="Jordan 6 Rings";


	}
	
	@Test(priority = 5, enabled = true)
	public void FillForm() {
		//verify error message
		formPage.clickOnLetShopButton();
		formPage.verifyErrorMesagge("Please enter your name");
		formPage.selectCountry("Belgium");
		formPage.setName("Jared");
		driver.hideKeyboard();
		formPage.clickOnMaleRadio();
		formPage.clickOnLetShopButton();
		Waits.sleep(GlobalVariables.DELAY_VERYLOW);

	}
	
	@Test(priority = 10, enabled = true )
	public void AddProductToCart() {

		productsPage.addProductToCart(productName1);
		productsPage.addProductToCart(productName2);
		Waits.sleep(GlobalVariables.DELAY_VERYLOW);
		productsPage.clickOnShoppingCart();
		Waits.sleep(GlobalVariables.DELAY_VERYLOW);

	}

	@Test(priority = 20, enabled = true)
	public void verifyProductInCart() {

		cartPage.waitUntilShoppingCartIsDisplayed();
		cartPage.verifyShoppingCartProduct(productName1,0);
		cartPage.verifyShoppingCartProduct(productName2,1);
		cartPage.verifyProductCount();

	}
	
	@Test(priority = 25, enabled = true)
	public void completePurchase() {

		cartPage.verifyTermsOfConditions();
		cartPage.clickOnCloseTermOfConditionPopup();
		cartPage.checkSendMeEmails();
		cartPage.clickCompletePurchase();
		Waits.sleep(GlobalVariables.DELAY_FIVE_SEC);

	}
	
	@Test(priority= 30, enabled = true)
	public void hybridAppTest() {

		WebBrowserPage webPage = new WebBrowserPage(driver);
		webPage.searchInBrowser("Jared Salinas");
		webPage.endBrowserNavigation();
	}

}
