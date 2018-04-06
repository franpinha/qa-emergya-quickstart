package com.emergya.pageobjects;

import java.util.logging.Level;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class TestingAlertsMainPage extends BasePageObject {

	/**
	 * Logger class initialization.
	 */
	static Logger log = Logger.getLogger(TestingAlertsMainPage.class);



	// Items keys without properties
	private static final String LOGO = "#header > div > div > div > div.col-sm-8.col-xs-8.col-md-8 > h1";
	protected static final String BUTTONALERTOK = "#OKTab > button";
	protected static final String TEXTBOX = "body > div.container.center > div > div > div > div.tabpane.pullleft > ul > li.active > a";
	protected static final String BUTTONDEMO = "#Textbox > button";

	/**
	 * Constructor method
	 * 
	 * @param driver
	 *            selenium webdriver
	 */
	public TestingAlertsMainPage(EmergyaWebDriver driver) {
		super(driver);

	}

	/**
	 * Checks that the PO is ready
	 * 
	 * @param pageObject
	 *            page object to be used
	 */
	@Override
	public boolean isReady() {

		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName() + " - Start isReady method");

		boolean status = driver.isElementDisplayed(By.cssSelector(LOGO));

		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName() + " - End isReady method");

		return status;
	}

	public boolean isTestingAlertsPageDisplayed() {

		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName() + "]- Start isTestingPageDisplayed method");
		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName() + "]- End isTestingPageDisplayed method");

		return driver.isElementDisplayed(By.cssSelector(LOGO));
	}

	public void clickOnButtonAlertOk() {

		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName() + "]- Start clickOnButtonAlertOk method");

		if (driver.isElementDisplayed(By.cssSelector(BUTTONALERTOK))) {
			log.info("The button alert OK is  visible");
			driver.findElement(By.cssSelector(BUTTONALERTOK)).click();
			driver.clickIfExists(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[3]/a"));
			
				driver.sleep(2);
				

		}
	}

	public void clickOnAlertTextbox() {
		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName() + "]- Start clickOnAlertTextbox method");

		if (driver.isElementDisplayed(By.cssSelector(TEXTBOX))) {
			log.info("the button Alert with Textbox is visible");
			driver.clickIfExists(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[3]/a"));
			if (driver.isElementDisplayed(By.cssSelector(BUTTONDEMO))) {
				log.info("The button to demonstrate the box is visible");
				try {
					driver.findElement(By.cssSelector(BUTTONDEMO)).click();
					Alert alert = driver.switchTo().alert();
					driver.sleep(5);
					alert.sendKeys("Test User");
					driver.sleep(3);
					alert.accept();
					driver.sleep(4);

				} catch (UnhandledAlertException ex1) {
					log.warn("the exception alert is catched");
					log.warn(Level.WARNING, ex1);
				

			}

		}
	}
}
}