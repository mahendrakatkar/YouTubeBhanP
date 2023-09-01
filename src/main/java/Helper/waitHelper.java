package Helper;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.math3.geometry.euclidean.oned.Interval;
import org.apache.log4j.Logger;
import org.apache.poi.util.Units;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waitHelper {
	private WebDriver driver;

	private Logger log = LoggerHelper.getLogger(waitHelper.class);

	public waitHelper(WebDriver driver) {
		this.driver = driver;
	}

	
	//This is implicit method
		public void setImplicitWait(int timeout, TimeUnit unit) {
		log.info("Implicit wait is set to :" + timeout);

		driver.manage().timeouts().implicitlyWait(timeout, unit);
	}

		//This  will help to get webdriver wait object

	private WebDriverWait getWait(Duration timeoutInSeconds, int pollingEveryInMillSec) {
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.pollingEvery(Duration.ofMillis(pollingEveryInMillSec));
		/*
		 * wait.pollingEvery(timeoutInSeconds); //
		 * wait.pollingEvery(PollingEveryInMillSec, TimeUnit.SECONDS);
		 * wait.pollingEvery(pollingEveryInMillSec);
		 */
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotInteractableException.class); // cnat find not visibleexception
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
	}

	//This method will make sure element is visible
	public void WaitFOrElementVisibleWithPollingTime(WebElement element, int timeoutInSeconds,
			int PollingEveryInMillSec) {
		log.info("waiting for : " + element.toString() + " for :" + timeoutInSeconds + "seconds");
		WebDriverWait wait = getWait(timeoutInSeconds, PollingEveryInMillSec);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("element is visible now");
	}

	private WebDriverWait getWait(int timeoutInSeconds, int pollingEveryInMillSec) {
		// TODO Auto-generated method stub
		return null;
	}

	//This method will make sure element is clickable
	public void WaitFOrElementToBeClickable(WebElement element, Duration timeoutInSeconds) {
		log.info("waiting for : " + element.toString() + " for :" + timeoutInSeconds + "seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		log.info("element is clickable now");
	}

	
	//This method will make invisiblility of element
	public Boolean waitForElementNotPresent(WebElement element, Duration timeoutInSeconds) {
		log.info("waiting for : " + element.toString() + " for :" + timeoutInSeconds + "seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		Boolean status = wait.until(ExpectedConditions.invisibilityOf(element));
		log.info("element is invisible now");
		return status;
	}
	
	
	//This method will wait for frameToBeAvailableAndSwitchToIt
	public void waitForframetoAvailableandSwitch(WebElement element, Duration timeoutInSeconds) {
		log.info("waiting for : " + element.toString() + " for :" + timeoutInSeconds + "seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		log.info("frame is inviavailable and swithecd");
		
	}
	public void getfluentWait
}
