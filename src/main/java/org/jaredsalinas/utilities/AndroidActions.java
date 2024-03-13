    package org.jaredsalinas.utilities;

    import com.google.common.collect.ImmutableMap;
    import io.appium.java_client.AppiumBy;
    import org.jaredsalinas.base.android.BasePage;
    import org.openqa.selenium.JavascriptExecutor;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.remote.RemoteWebElement;

    public class AndroidActions extends BasePage {

        public static void longPressAction(WebElement element) {

            ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
                    ImmutableMap.of("elementId",
                            ((RemoteWebElement)element).getId(),
                            "duration", 2000));

        }
        public void startActivity(String intent) {

            ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of(
                    //right or right, percent how mucho you put your tumb to swipe
                    "intent", intent
            ));
        }

        public static void scrollViewUntilTextAppears(String expectedText) {
            driver.findElement(AppiumBy.androidUIAutomator
                    ("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+expectedText+"\"));"));

        }

        public static boolean scrollView(int left, int top, int width, int height, String direction) {

            return(Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", left, "top", top, "width", width, "height", height,
                    "direction", direction,
                    "percent", 3.0
            ));

        }

        public static void scrollToEnd() {

            boolean canScrollMore;
            do {

                canScrollMore=(Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                        "left", 100, "top", 100, "width", 200, "height", 200,
                        "direction", "down",
                        "percent", 3.0));
            }while(canScrollMore);
        }


        public static void swipeAction(WebElement element, String direction) {

            ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                    //right or right, percent how mucho you put your tumb to swipe
                    "elementId",((RemoteWebElement)element).getId(),
                    "direction",direction,
                    "percent", 0.75
            ));
        }

        public static void dragAndDrop(WebElement element) {

            ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) element).getId(),
                    "endX", 836,
                    "endY", 740
            ));
        }
    }
