package org.jaredsalinas.pages.hybrid;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.jaredsalinas.base.android.BasePage;
import org.jaredsalinas.pagesObjects.hybrid.WebBrowserPageObjects;
import org.jaredsalinas.utilities.GlobalVariables;
import org.jaredsalinas.utilities.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.ContextAware;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class WebBrowserPage extends BasePage {

    private AndroidDriver driver;

    @FindBy(name =WebBrowserPageObjects.NAME_SEARCH_BAR)
    private WebElement searchBar;

    public WebBrowserPage(AndroidDriver driver){
        Waits.sleep(GlobalVariables.DELAY_FIVE_SEC);

        Set<String> contexts =driver.getContextHandles();

        for(String contextName :contexts) {
            System.out.println(contextName);
        }

        //YOU NEED TO SET CHROME DRIVER
        driver.context("WEBVIEW_com.androidsample.generalstore");
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    public WebBrowserPage(){

    }

    public void searchInBrowser(String text){

        setText(searchBar,text);
        setText(searchBar,Keys.ENTER);

    }




    public void endBrowserNavigation(){
        Waits.sleep(GlobalVariables.DELAY_FIVE_SEC);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.context("NATIVE_APP");
    }

}
