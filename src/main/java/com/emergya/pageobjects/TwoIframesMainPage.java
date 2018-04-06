package com.emergya.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class TwoIframesMainPage extends BasePageObject {

	/**
	 * Logger class initialization.
	 */
	static Logger log = Logger.getLogger(TwoIframesMainPage.class);

	private static final String LOGOHEADER = "logoheader";
	private static final String INPUTUSERNAME = "username";

	public TwoIframesMainPage(EmergyaWebDriver driver) {
		super(driver);

	}

	@Override
	public boolean isReady() {

		return false;
	}

	public boolean isTwoIframesLogoDisplayed() {

		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName()
				+ "]- Start isTwoIframesLogoDisplayed method");
		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName()
				+ "]- End isTwoIframesLogoDisplayed method");

		return this.isElementVisibleById(LOGOHEADER);
	}

	public void writeName() {

		/*
		 * Selectors
		 */

		String idSelectorFrame1 = "#iframe1";

		WebElement frame = driver.findElement(By.cssSelector(idSelectorFrame1));
		driver.switchTo().frame(frame);

		/*
		 * ASSERTION assertTrue(this.isElementVisibleByXPath(INPUTUSERNAME),
		 * "ASSERTION FAILED");
		 */

		if (this.isElementVisibleByXPath(INPUTUSERNAME)) {
			this.getElementByXPath(INPUTUSERNAME).sendKeys("PRUEBA");
			driver.sleep(2);
		}

	}

	public void identifyButtons() {

		if (driver.isElementDisplayed(By.name("samename"))) {

			WebElement buttonSubmit = driver.findElement(By.name("samename"));
			String typeSubmit = buttonSubmit.getAttribute("type");
			String textobotonSubmit = buttonSubmit.getText();
			log.info(typeSubmit);
			log.info(textobotonSubmit);

		}
	}

}
