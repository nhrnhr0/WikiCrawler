package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WikiEngine {

    // methods:

    public static WikiEngine Instance() {
        if(instance == null) {
            instance = new WikiEngine();
        }
        return instance;
    }

    public WikiPage get(String url) {
        driver.get(BASE_URL + url);
        WikiPage page = new WikiPage();
        page.url = url;
        WebElement content = driver.findElement(By.id("mw-content-text"));
        List<WebElement> links = content.findElements(By.xpath("//a[starts-with(@href, \"/wiki/\") and not(contains(@href, \":\"))]"));
        for(int i = 0;i < links.size(); i++) {
            String linkUrl = links.get(i).getAttribute("href").substring("https://en.wikipedia.org/wiki/".length());
            if(linkUrl.equals(url) == false)
                page.links.add(linkUrl);
        }
        return page;
    }

    private WikiEngine() {
        System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver76.exe");
        driver = new ChromeDriver();
    }


    // variables:
    private static WikiEngine instance = null;
    private ChromeDriver driver;
    private final String BASE_URL = "https://en.wikipedia.org/wiki/";

}
