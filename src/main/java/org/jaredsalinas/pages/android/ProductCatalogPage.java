package org.jaredsalinas.pages.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.jaredsalinas.base.android.BasePage;
import org.jaredsalinas.pagesObjects.android.FormPageObjects;
import org.jaredsalinas.pagesObjects.android.ProductCatalogPageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.jaredsalinas.utilities.AndroidActions.scrollViewUntilTextAppears;

public class ProductCatalogPage extends BasePage {

    AndroidDriver driver;
    public ProductCatalogPage(AndroidDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public ProductCatalogPage(){

    }
    @AndroidFindBy(id= ProductCatalogPageObjects.ID_TXT_PRODUCT_NAME)
    private List<WebElement> productNameList;

    @AndroidFindBy(id=ProductCatalogPageObjects.ID_LINK_ADD_TO_CART)
    private List <WebElement> linkAddToCartList;

    @AndroidFindBy(id=ProductCatalogPageObjects.ID_BTN_SHOPPING_CART)
    private WebElement btnShoppingCart;

    public void addProductToCart(String productName) {

        int productCount= productNameList.size();
        scrollViewUntilTextAppears(productName);
        for (int i = 0; i<productCount; i++) {

            String actualProductName = getText(productNameList.get(i));
            if (actualProductName.equals(productName)) {
                clickAndWait(linkAddToCartList.get(i));
            }
        }
    }

    public void clickOnShoppingCart() {

       clickAndWait(btnShoppingCart);
    }

}
