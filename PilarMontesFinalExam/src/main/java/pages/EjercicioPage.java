package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class EjercicioPage extends BasePage {
    public static final By USER_ICON_CSS = By.id("global-user-trigger");


    public EjercicioPage(WebDriver pDriver) {
        super(pDriver, "https://www.espnqa.com/?src=com&_adblock=true&espn=cloud");
    }

    public void login(String user, String password) {
        useElementUntilClickable(USER_ICON_CSS).click();
        useElementUntilClickable((By.cssSelector(".user li:nth-child(7) a"))).click();
        getDriver().switchTo().frame("disneyid-iframe");
        useElementUntilClickable((By.cssSelector("input[type='email']"))).click();
        useElementUntilClickable(By.cssSelector("input[type='email']")).sendKeys(user);
        useElementUntilClickable(By.cssSelector("input[type='password']")).click();
        useElementUntilClickable(By.cssSelector("input[type='password']")).sendKeys(password);
        useElementUntilClickable(By.cssSelector("button[class^='btn']")).click();
    }

    public void logOut() {
        useElementUntilClickable(USER_ICON_CSS).click();
        useElementUntilClickable(By.cssSelector(".user li:nth-child(9) a")).click();
    }

    public void cancelAccount(String user, String password) {
        useElementUntilClickable(USER_ICON_CSS).click();
        useElementUntilClickable((By.cssSelector(".user li:nth-child(5) a"))).click();
        waitForFrameLoaded(By.id("disneyid-iframe"));
        useElementUntilClickable(By.id("cancel-account")).click();
        useElementUntilClickable(By.cssSelector("button[ng-click*='cancel")).click();
    }
    public String getName(){
        useElementUntilClickable(USER_ICON_CSS).click();
        WebElement element = getDriver().findElement(By.cssSelector("li .display-user span"));
        return getElementText(element);
    }

}


