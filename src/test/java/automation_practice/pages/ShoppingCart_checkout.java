package automation_practice.pages;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
@Setter
public class ShoppingCart_checkout {
    private WebDriver driver;

    @FindBy(xpath = "//ul[contains(@class,'step clearfix')] ")
    private WebElement summeryMenu;

    public ShoppingCart_checkout(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public List<WebElement> getListElements() {
        return summeryMenu.findElements(By.tagName("li"));
    }

    public WebElement getOptionFromMenuByName(String optionName) {

        return getListElements().stream()
                .filter(element -> element.findElement(By.tagName("a")).getText().equalsIgnoreCase(optionName))
                .findFirst()
                .orElseThrow(() -> new
                        RuntimeException("Such menu item does not exists - " + optionName));
    }
}


