package org.jaredsalinas.pages.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.jaredsalinas.base.android.BasePage;
import org.jaredsalinas.pagesObjects.android.CartPageObjects;
import org.jaredsalinas.utilities.GlobalVariables;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.time.Duration.ofSeconds;
import static org.jaredsalinas.utilities.AndroidActions.longPressAction;

public class CartPage extends BasePage {

    AndroidDriver driver;
    public CartPage(AndroidDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public CartPage(){

    }

    @AndroidFindBy(id=CartPageObjects.ID_TXT_CART_PRODUCT)
    private List<WebElement> txtShoppingCart;

    @AndroidFindBy(id=CartPageObjects.ID_TXT_PRODUCT_PRICE)
    private List<WebElement> txtProductPrice;

    @AndroidFindBy(id=CartPageObjects.ID_TXT_TOTAL_ORDER)
    private WebElement txtTotalOrder;

    @AndroidFindBy(id=CartPageObjects.ID_TXT_TITLE_NAME)
    private WebElement txtTitleName;

    @AndroidFindBy(id=CartPageObjects.ID_LINK_TERMS_OF_CONDITIONS)
    private WebElement linkTermsOfConditions;

    @AndroidFindBy(id=CartPageObjects.ID_BTN_CLOSE_BUTTON)
    private WebElement btnCloseButton;

    @AndroidFindBy(id= CartPageObjects.ID_BTN_COMPLETE_PURCHASE)
    private WebElement btnCompletePurchase;

    @AndroidFindBy(xpath=CartPageObjects.XPATH_CHECK_BOX_SEND_EMAILS)
    private WebElement checkBoxSendMeEmails;

    public void verifyShoppingCartProduct(String expectedProductName, int index) {

        String actualProductName = getText(txtShoppingCart.get(index));
        verifyEquals(actualProductName, expectedProductName);

    }

    public void verifyProductCount() {

        double sum =0;
        int productCount = txtProductPrice.size();
        for (int i =0; i<productCount; i++) {

            sum = sum + getFormatedAmout(getText(txtProductPrice.get(i)));

        }
        String actualQuantity = String.valueOf(sum);
        String expectedQuantity = String.valueOf(getFormatedAmout( getText(txtTotalOrder)));

        verifyEquals(actualQuantity, expectedQuantity);

    }
    public void waitUntilShoppingCartIsDisplayed() {

        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(GlobalVariables.DELAY_FIVE_SEC));
        wait.until(ExpectedConditions.attributeContains(txtTitleName, "text", "Cart"));
    }

    public void verifyTermsOfConditions() {
        // TODO Auto-generated method stub
        WebElement linkTermsOfConditions = CartPageObjects.getWebElementTermsOfConditions();
        longPressAction(linkTermsOfConditions);

    }

    public void clickOnCloseTermOfConditionPopup() {

        clickAndWait(btnCloseButton);

    }

    public void checkSendMeEmails() {

       clickAndWait(checkBoxSendMeEmails);

    }

    public void clickCompletePurchase() {

       clickAndWait(btnCompletePurchase);

    }


}
