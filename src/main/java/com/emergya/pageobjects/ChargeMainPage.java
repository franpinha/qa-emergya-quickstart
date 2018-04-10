package com.emergya.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class ChargeMainPage extends BasePageObject {

	/**
	 * Logger class initialization.
	 */
	static Logger log = Logger.getLogger(ChargeMainPage.class);

	private static final String LOGO = "logo";
	private static final String BUTTONDOWNLOAD = "buttondownload";
	private static final String CLICKTORETURN = "clicktoreturn";

	public ChargeMainPage(EmergyaWebDriver driver) {
		super(driver);

	}

	@Override
	public boolean isReady() {

		return false;
	}

	public boolean isLogoChargeVisible() {

		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName()
				+ "]- Start isLogoChargeVisible method");

		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName()
				+ "]- End isLogoChargeVisible method");

		return this.isElementVisibleById(LOGO);

	}

	public void clickAndControlCharge() {
		WebElement circle = driver.findElement(By.className("percenttext"));
		String percentageCircle;

		if (this.isElementVisibleById(BUTTONDOWNLOAD)) {

			this.getElementById(BUTTONDOWNLOAD).click();
			log.info("Start download....waiting");
		}

		do {
			percentageCircle = circle.getText();

		} while ((percentageCircle.compareTo("100%") != 0));

		if (percentageCircle.compareTo("100%") == 0) {

			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript("window.confirm(('THE CHARGE IS COMPLETED ...'));");

			driver.sleep(5);
			driver.switchTo().alert().accept();

		}
	}

	public DemoMainPage returnToHome() {
		/**
		 * This method return to DemoHome Selenium Easy page
		 * 
		 * @return
		 */

		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName()
				+ "]- Start returnToHome method");

		this.getElementByXPath(CLICKTORETURN).click();

		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName()
				+ "]- End returnToHome method");
		return new DemoMainPage(driver);

	}

}
