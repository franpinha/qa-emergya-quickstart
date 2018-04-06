package com.emergya.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class JQueryControlGroupMainPage extends BasePageObject {

	static Logger log = Logger.getLogger(JQueryControlGroupMainPage.class);

	private static final String LOGO = "cabecera";
	private static final String LABELNUMBER = "labelnumber";
	private static final String LABELNUMBER2 = "labelnumber2";

	public JQueryControlGroupMainPage(EmergyaWebDriver driver) {
		super(driver);

	}

	@Override
	public boolean isReady() {

		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName() + " - Start isReady method");

		boolean status = this.isElementVisibleById(LOGO);

		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName() + " - End isReady method");

		return status;

	}

	public boolean isJQueryLogoControlGroupDisplayed() {
		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName()
				+ "]- Start isJQueryLogoControlGroupDisplayed method");
		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName()
				+ "]- End isJQueryLogoControlGroupDisplayed method");

		return this.isElementVisibleById(LOGO);

	}

	public void clickOnArrowUp() {

		String cssLink = "body > div.widget > fieldset:nth-child(4) > div > span.ui-widget.ui-widget-content.ui-spinner.ui-controlgroup-item > a.ui-button.ui-widget.ui-spinner-button.ui-button-icon-only.ui-spinner-up > span.ui-button-icon.ui-icon.ui-icon-triangle-1-n";
		String xpathlink = "//*[@id='content']/iframe";
		WebElement frame = driver.findElementByXPath(xpathlink);
		driver.switchTo().frame(frame);

		String numero = "";
		String numero2 = "";

		do {
			driver.clickIfExists(By.cssSelector(cssLink));

			driver.sleep(2);
			WebElement element = this.getElementById(LABELNUMBER);
			numero = element.getAttribute("aria-valuenow");
			WebElement element2 = this.getElementById(LABELNUMBER2);
			numero2 = element2.getAttribute("aria-valuenow");
			element2.sendKeys(Keys.BACK_SPACE);
			element2.sendKeys(numero);

		} while (!numero.equals("5"));

		driver.sleep(2);

	}

}
