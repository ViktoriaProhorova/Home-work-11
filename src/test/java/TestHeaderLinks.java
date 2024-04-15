import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHeaderLinks {
    @Test
    public void checkClickingHomeSign() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://litecart.stqa.ru/en/");

        WebElement homeSign = driver.findElement(By.cssSelector("i.fa-home"));
        homeSign.click();

        String pageTitle = driver.getTitle();
        Assert.assertEquals
                (pageTitle, "Online Store | My Store", "Page title is not Online Store | My Store");

        driver.quit();
    }

    @Test
    public void checkClickingRubberDucks() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://litecart.stqa.ru/en/");

        WebElement rubberDucksFromPageHeader = driver.findElement
                (By.xpath("//div[@id='site-menu-wrapper']//a[text()='Rubber Ducks']"));
        rubberDucksFromPageHeader.click();

        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Rubber Ducks | My Store", "Page title is not Rubber Ducks");

        driver.quit();
    }

    @Test
    public void checkClickingSubcategory() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://litecart.stqa.ru/en/");

        Actions builder = new Actions(driver);

        WebElement rubberDucksFromPageHeader = driver.findElement
                (By.xpath("//div[@id='site-menu-wrapper']//a[text()='Rubber Ducks']"));
        builder.moveToElement(rubberDucksFromPageHeader).perform();

        WebElement subcategoryFromPageHeader = driver.findElement
                (By.xpath("//a[@href='https://litecart.stqa.ru/en/rubber-ducks-c-1/subcategory-c-2/']"));
        builder.moveToElement(subcategoryFromPageHeader).perform();
        subcategoryFromPageHeader.click();



        String pageTitle = driver.getTitle();
        Assert.assertEquals
                (pageTitle, "Subcategory | My Store", "Page title is not Subcategory | My Store");

        driver.quit();
    }
}

