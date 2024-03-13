package org.jaredsalinas.pagesObjects.android;

import org.jaredsalinas.pages.android.CartPage;
import org.openqa.selenium.WebElement;

public class CartPageObjects extends CartPage {

    public static final String ID_TXT_CART_PRODUCT = "com.androidsample.generalstore:id/productName";

    public static final String ID_TXT_TITLE_NAME = "com.androidsample.generalstore:id/toolbar_title";

    public static final String ID_TXT_PRODUCT_PRICE = "com.androidsample.generalstore:id/productPrice";

    public static final String ID_TXT_TOTAL_ORDER = "com.androidsample.generalstore:id/totalAmountLbl";

    public static final String ID_LINK_TERMS_OF_CONDITIONS = "com.androidsample.generalstore:id/termsButton";

    public static final String ID_BTN_CLOSE_BUTTON = "android:id/button1";

    public static final String ID_BTN_COMPLETE_PURCHASE = "com.androidsample.generalstore:id/btnProceed";

    public static final String XPATH_CHECK_BOX_SEND_EMAILS
            = "//android.widget.CheckBox[@text='Send me e-mails on discounts related to selected products in future']";

    public static WebElement getWebElementTermsOfConditions(){

       return findElementByID(ID_LINK_TERMS_OF_CONDITIONS);
    }

}
