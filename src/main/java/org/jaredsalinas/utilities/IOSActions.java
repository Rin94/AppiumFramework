package org.jaredsalinas.utilities;

import org.jaredsalinas.base.ios.BasePage;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;

public class IOSActions extends BasePage {

    public void switchToLandScape() {

        DeviceRotation landScape = new DeviceRotation(0,0, 90);
        driver.rotate(landScape);
    }

    public static void touchAndHold(WebElement element) {

        Map<String, Object> params = new HashMap<>();
        params.put("element", ((RemoteWebElement)element).getId());
        params.put("duration",  2000);

        ((JavascriptExecutor)driver).executeScript("mobile: touchAndHold",
                params);

    }

    public static void scrollUntilElementAppear(WebElement element) {

        Map<String, Object> params = new HashMap<>();
        params.put("element", ((RemoteWebElement) element).getId());
        params.put("direction", "down");

        ((JavascriptExecutor)driver).executeScript("mobile: swipe",
                params);

    }


}
