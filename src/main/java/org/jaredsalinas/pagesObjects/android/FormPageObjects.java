package org.jaredsalinas.pagesObjects.android;

import org.jaredsalinas.pages.android.FormPage;
import org.openqa.selenium.WebElement;

public class FormPageObjects extends FormPage {

    public static final String ID_TXT_FIELD_NAME= "com.androidsample.generalstore:id/nameField";
    public static final String ID_RADIO_MALE_FIELD = "com.androidsample.generalstore:id/radioMale";
    public static final String ID_RADIO_FEMALE_FIELD = "com.androidsample.generalstore:id/radioFemale";
    public static final String ID_SPINNE_COUNTRY_FIELD = "com.androidsample.generalstore:id/spinnerCountry";
    public static final String ID_BTN_LETSSHOP = "com.androidsample.generalstore:id/btnLetsShop";
    public static final String XPATH_TXT_TOAST_MESSAGE= "(//android.widget.Toast)[1]";

    public static final String BEFORE_XPATH_WIDGET_TEXT_VIEW = "//android.widget.TextView[@text='";

    public static final String AFTER_XPATH_WIDGET_TEXT_VIEW = "']";


    public static WebElement getWebElementByCountryName(String option){

        return findElementByXpath(BEFORE_XPATH_WIDGET_TEXT_VIEW+option+AFTER_XPATH_WIDGET_TEXT_VIEW);
    }
}
