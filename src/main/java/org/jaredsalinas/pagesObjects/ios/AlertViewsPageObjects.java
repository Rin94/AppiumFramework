package org.jaredsalinas.pagesObjects.ios;

import org.jaredsalinas.pages.ios.AlertViewsPage;

public class AlertViewsPageObjects extends AlertViewsPage {

    public static final String XPATH_BTN_NAME_ENTRY= "//XCUIElementTypeStaticText[@name='Text Entry']";

    public static final String CLASS_CHAIN_TXT_NAME_ENTRY= "**/XCUIElementTypeOther[2]";

    public static final String CLASS_CHAIN_BTN_OK="**/XCUIElementTypeButton[`name == 'OK'`]";
    public static final String PREDICATED_STRING_BTN_CONFIRM_CANCEL ="name == 'Confirm / Cancel'";

    public static final String PREDICATED_STRING_TXT_MESSAGE="name BEGINSWITH 'A message'";

    public static final String PREDICATED_STRING_BTN_CONFIRM ="name == 'Confirm'";





}
