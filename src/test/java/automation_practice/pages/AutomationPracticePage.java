package automation_practice.pages;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
@Setter
@Getter
public class AutomationPracticePage {
    private WebDriver driver;

    @FindBy(xpath = "//ul[contains(@class,'sf-menu clearfix menu-content')]")
    private WebElement categoryMenu;
    public List<WebElement> getListOfCategories(){
        return categoryMenu.findElements(By.tagName("li"));
    }

    public WebElement getCategoriesFromMenuByName(String categoryName ){

        return getListOfCategories().stream()
                .filter(element -> element.findElement(By.tagName("a")).getText().equalsIgnoreCase(categoryName))
                .findFirst()
                .orElseThrow(()-> new
                        RuntimeException("Such menu item does not exists - " + categoryName));}


    @FindBy(xpath = "//a[@title = 'Women']")
    private WebElement womenMenu;
    @FindBy(xpath = "//h2[contains(text(), 'Women')]")
    private WebElement menuTitle;
    @FindBy(xpath = "//ul[contains(@class,'tree dynamized')]")
    private WebElement womenMenuOptions;

    public List<WebElement> getListOfOptions(){
            return womenMenuOptions.findElements(By.tagName("li"));
        }

        public WebElement getOptionsFromMenuByName(String optionName){

            return getListOfOptions().stream()
                    .filter(element -> element.findElement(By.tagName("a")).getText().equalsIgnoreCase(optionName))
                    .findFirst()
                    .orElseThrow(() -> new
                            RuntimeException("Such menu item does not exists - " + optionName));
        }

    @FindBy(xpath = "//a[@title = 'Dresses']")
    private WebElement dresses;
    @FindBy(xpath = "//h2[contains(text(), 'Dresses')]")//validation
    private WebElement DisplayOptionDresses;//after these 2 click on dresses option
    @FindBy(xpath = "//ul[contains(@class,'tree dynamized')]")
    private WebElement dressesSubmenu;

    public List<WebElement> getDressesTypesFromDresCategory(){
        return dressesSubmenu.findElements(By.tagName("li"));
    }
    public WebElement getTypeOfDres(String dresType){
        return getDressesTypesFromDresCategory().stream()
                .filter(element-> element.findElement(By.tagName("a")).getText().equalsIgnoreCase(dresType))
                .findFirst()
                .orElseThrow(() -> new
                        RuntimeException("Such menu item does not exists - "+dresType));
    }
    @FindBy(xpath = "//a[contains(text(),'Casual Dresses')]")
    private WebElement selectedDress;
    @FindBy(xpath = "//span[contains(@class, 'cat-name')]")
    private WebElement dressName;
    @FindBy(xpath = "//div[contains(@class, 'product-container')]")
    private WebElement productContainer;
    @FindBy(xpath = "//span[contains(text(),'More')] ")//5
    private WebElement MoreButton;
    @FindBy(xpath = "//h1 ")
    private WebElement productPage;//6 validation
    //add button //span[contains(text(),'Add to cart')]
//step with message
    ////span[contains(text(),'Proceed to checkout')] button
    //
    @FindBy(xpath = "//a[@title='Casual Dresses']")
    private WebElement category;


       public AutomationPracticePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    }
    
    




    

//    @FindBy(xpath = "//select ")
//    private WebElement dropdown;
   // for select also span(S, M, L)
    ////span[contains(text(),'Add to cart')]
    // //ul[contains(@class,'sf-menu clearfix menu-content')]//li//a
////a[@title = 'Women']
// //ul[contains(@class,'submenu-container clearfix')]//li//a
    ////a[@title = 'Dresses']
    // //ul[contains(@style,'display: none;')]//li//a
    ////a[@title = 'Casual Dresses']





