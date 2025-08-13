package AbstractComponents;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	
	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(css= "myorders") 
	WebElement myOrders;

	public void waitForElementToAppear(By findBy)
	{
		
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}
	public void waitForElementToAppearElement(WebElement clickElement)
	{
		
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOf(clickElement));

	}
	public WebDriver waitForElementToDisappear(WebElement ele) throws InterruptedException
	{
	Thread.sleep(1000);	
	return driver;
	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	//wait.until(ExpectedConditions.invisibilityOf(ele));

	}
	public OrderPage goToOrderPage()
	{
		myOrders.click();
		OrderPage orderPage = new OrderPage(driver);
		return orderPage;
	}
}

