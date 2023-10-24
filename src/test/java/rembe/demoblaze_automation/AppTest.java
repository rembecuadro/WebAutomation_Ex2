package rembe.demoblaze_automation;

import java.time.Duration;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Unit test for simple App.
 */
public class AppTest {

    WebDriver driver;
    WebDriverWait wait;

    @Test
    public void testDemoBlaze() throws InterruptedException {
        driver = new EdgeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        driver.get("https://demoblaze.com/");
        //driver.navigate().to("https://demoblaze.com/");
        driver.manage().window().maximize(); //Esto es para maximizar la pag
        WebElement logIn = driver.findElement(By.id("login2"));
        logIn.click(); // Accion para hacer click
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Cambiando a la ventana modal
        driver.switchTo().activeElement();

        //Agregando el nombre de usuario y la contraseña
        WebElement username = driver.findElement(By.id("loginusername"));
        WebElement passwd = driver.findElement(By.id("loginpassword"));
        
        wait.until((a)->username.isDisplayed());
        username.sendKeys("a");
        passwd.sendKeys("a");
        //wait.until(ExpectedConditions.textToBePresentInElement(username, "a"));
        //wait.until(ExpectedConditions.textToBePresentInElement(passwd, "a"));
        
        WebElement logInSubmit = driver.findElement(By.cssSelector("#logInModal > div > div > div.modal-footer > button.btn.btn-primary"));
        logInSubmit.click(); // Accion para hacer click
        
        driver.navigate().refresh();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));

        // Navegando en la seccion About Us
        

        WebElement aboutUsBtn = driver.findElement(By.cssSelector("#navbarExample > ul > li:nth-child(3) > a"));
        //wait.until(ExpectedConditions.stalenessOf(aboutUsBtn));
        aboutUsBtn.click();
        

//        try {
//            WebElement aboutUsBtn = driver.findElement(By.cssSelector("#navbarExample > ul > li:nth-child(3) > a"));
//            aboutUsBtn.click();
//        } catch (StaleElementReferenceException e) {
//            System.out.println(e);
//
//        }
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//        
        // Reproduciendo video
        WebElement play = driver.findElement(By.cssSelector("#example-video > button"));
        play.click();
        
        
        //Cerrando ventana del reproductor
        WebElement closeVideo = driver.findElement(By.cssSelector("#videoModal > div > div > div.modal-footer > button"));
        wait.until(ExpectedConditions.elementToBeClickable(closeVideo));
        closeVideo.click();
        
        // Comprando la laptop
        WebElement laptopNav = driver.findElement(By.cssSelector("#contcont > div > div > div > a:nth-child(3)"));
        laptopNav.click();
        
        WebElement vaioBuy = driver.findElement(By.cssSelector("#tbodyid > div:nth-child(2) > div > div > h4 > a"));
        vaioBuy.click();
        
    }
}
