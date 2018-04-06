package com.emergya.pageobjects;

import java.util.logging.Level;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class CheckBoxMainPage extends BasePageObject {

	/**
	 * Logger class initialization.
	 */
	static Logger log = Logger.getLogger(CheckBoxMainPage.class);

	private static final String LOGO = "cabecera";
	private static final String PARIS = "body > div > fieldset:nth-child(3) > label:nth-child(4)";

	public CheckBoxMainPage(EmergyaWebDriver driver) {
		super(driver);

	}

	@Override
	public boolean isReady() {

		return false;
	}

	public boolean isReadyLogoCheckbox() {
		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName()
				+ "]- Start isJQueryLogoSelectMenuDisplayed method");
		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName()
				+ "]- End isJQueryLogoSelectMenuDisplayed method");

		return this.isElementVisibleById(LOGO);
	}

	public void checkParis() {

		String xpathLink = "//*[@id=\"content\"]/iframe";
		WebElement frame = driver.findElementByXPath(xpathLink);
		driver.switchTo().frame(frame);

		boolean selected = driver.findElement(By.cssSelector(PARIS)).isSelected();
		if (!selected) {
			driver.findElement(By.cssSelector(PARIS)).click();
			
		} else {
			log.warn(Level.WARNING);
		}

		driver.sleep(2);

	}

}
