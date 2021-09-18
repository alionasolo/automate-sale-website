package automation_practice.actions;

import automation_practice.browsers.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonActions {
    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void moveToElement(WebElement element) {
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(element);
        action.perform();
    }
    public void waitUntilElementDisplayed(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until((ExpectedCondition<Boolean>) arg -> element.isDisplayed());
    }
    
}
