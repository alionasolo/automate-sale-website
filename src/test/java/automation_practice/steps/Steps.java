package automation_practice.steps;

import automation_practice.actions.CommonActions;
import automation_practice.browsers.Driver;
import automation_practice.pages.AutomationPracticePage;
import automation_practice.pages.ShoppingCart_checkout;
import automation_practice.scenario_context.ScenarioContext;
import automation_practice.scenario_context.ScreenShots;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import screenshots.MakeScreenShots;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static automation_practice.browsers.Driver.getDriver;


public class Steps {
    CommonActions commonActions = new CommonActions();
    AutomationPracticePage automationPracticePage = new AutomationPracticePage(Driver.getDriver());
    MakeScreenShots makeScreenShots = new MakeScreenShots();


    @Given("User navigate to store page")
    public void accessSite(){
        getDriver().get("http://automationpractice.com/index.php'");

    }
    @Given("User click on {string} menu")
    public void accessWomenMenu(String menuName){

        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    commonActions.moveToElement(automationPracticePage.getCategoryMenu());
    makeScreenShots.makeAShot("CURRENT_PAGE");
    automationPracticePage.getCategoriesFromMenuByName(menuName).click();
    }
    @Given("User click on {string}  submenu")
    public void chooseSubcategory(String subCategoryName ){
        commonActions.moveToElement(automationPracticePage.getWomenMenuOptions());
        automationPracticePage.getOptionsFromMenuByName(subCategoryName).click();
    }
    @Given("User click on {string} item")
    public void selectAnItem(String itemTitle){
        commonActions.moveToElement(automationPracticePage.getDressesSubmenu());
        automationPracticePage.getTypeOfDres(itemTitle).click();
    }
    @Given("{string} category page is displayed")
    public void displayItemsPage(String itemPage){
        Assert.assertEquals("Item page is displayed",automationPracticePage.getDressName(),
                itemPage);
    }

    @When("User click on More button from product preview")
    public void clickToViewProduct(){
        commonActions.scrollToElement(automationPracticePage.getProductContainer());
        commonActions.moveToElement(automationPracticePage.getProductContainer());
        automationPracticePage.getMoreButton().click();

        Assert.assertEquals("Product page is displayed","Casual Dresses",automationPracticePage.getProductPage());
    }

    @When("User selects size of product")
    public void customizeProduct(){
        commonActions.waitUntilElementDisplayed(automationPracticePage.getProductPage());
        WebElement size = getDriver().findElement(By.xpath("//select"));
        Select select = new Select(size);
        select.selectByValue("2");

    }
    @When("User click on Add to cart button")
    public void addToCart(){
        WebElement button = getDriver().findElement(By.xpath("//span[contains(text(),'Add to cart')]"));
        button.click();
    }

    @Then("A popup with a success message is displayed")
    public void productAddedToVCart(){
        Assert.assertEquals("Product added to cart","Product successfully added to your shopping cart",
                getDriver().findElement(By.xpath("//div[contains(@class,'layer_cart_product')]//h2")));
    }
    @When("User click on Proceed to checkout button from popup")
            public void checkoutButton(){
        WebElement checkout = getDriver().findElement(By.xpath("//a[contains(@title,'Proceed to checkout')]"));
        checkout.click();
    }
    ShoppingCart_checkout shoppingCart_checkout = new ShoppingCart_checkout(Driver.getDriver());
    @When("User click on Proceed to checkout button from {string}")
    public void continueCheckout(String firstOption){
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals("Summary tab is displayed","Shopping-cart summary\n" +
                "\t\t\tYour shopping cart contains:\n" +
                "\t\t\t4 Products",getDriver().findElement(By.xpath("//h1")));
        WebElement continueCheckout = getDriver().findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]"));
        continueCheckout.click();
    }

    @When("User log in from sign in page with valid data")
    public void login(DataTable data){
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        commonActions.moveToElement(getDriver().findElement(By.xpath("//h3[contains(text(),'Already registered?')] ")));
            List<String> insertedValue = data.asList();
            getDriver().findElement(By.xpath("//input[@id='email']")).sendKeys(insertedValue.get(0));
            getDriver().findElement(By.xpath("//input[@id='passwd']")).sendKeys(insertedValue.get(1));
            getDriver().findElement(By.xpath("//span[contains(text(),'Sign in')] ")).click();

    }
    @When("User click on proceed to checkout button from {string} tab")
    public void addressAndCheckout(String address){
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement checkout  = getDriver().findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]"));
        commonActions.scrollToElement(checkout);
        checkout.click();

    }
    @When("User continue checkout from {string} tab")
    public void shippingAndCheckout(String shipping){
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        getDriver().findElement(By.xpath("//input[@type='checkbox'] ")).click();
        WebElement checkout  = getDriver().findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]"));
        commonActions.scrollToElement(checkout);
        checkout.click();

    }
    @Then("User proceed to payment on {string} tab")
    public void payment(String paymentPage){
        Assert.assertEquals("User is on Payment page",getDriver().findElement(By.xpath("//span[contains(text(),'Payment')]")),paymentPage);
    }



}
