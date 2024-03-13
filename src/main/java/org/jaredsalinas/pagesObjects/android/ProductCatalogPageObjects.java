package org.jaredsalinas.pagesObjects.android;
import org.jaredsalinas.pages.android.ProductCatalogPage;
import org.openqa.selenium.WebElement;

import static org.jaredsalinas.utilities.AndroidActions.scrollViewUntilTextAppears;

public class ProductCatalogPageObjects extends ProductCatalogPage {

    public static final String ID_TXT_PRODUCT_NAME = "com.androidsample.generalstore:id/productName" ;

    public static final String BEFORE_XPATH_TXT_PRODUCT_NAME =
            "//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName'"
            + " and @text='";
    public static final String AFTER_XPATH_TXT_PRODUCT_NAME = "']";
    public static final String ID_LINK_ADD_TO_CART = "com.androidsample.generalstore:id/productAddCart";
    public static final String ID_BTN_SHOPPING_CART = "com.androidsample.generalstore:id/appbar_btn_cart";

    public static WebElement getWebElementByProductName(String productName) {

        scrollViewUntilTextAppears(productName);
        return findElementByXpath(BEFORE_XPATH_TXT_PRODUCT_NAME+productName+AFTER_XPATH_TXT_PRODUCT_NAME);


    }

}
