package com.emergya.pageObjects;



import org.apache.log4j.Logger;
import org.openqa.selenium.By;


import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class LosArcosCineMainPage extends BasePageObject {

	/**
	 * Items keys selectors.
	 */
	private static final String CINES = "cine";

	/**
	 * Logger class initialization.
	 */
	static Logger log = Logger.getLogger(LosArcosCineMainPage.class);

	public LosArcosCineMainPage(EmergyaWebDriver driver) {
		super(driver);

	}

	@Override
	public boolean isReady() {

		return false;
	}

	// Page object methods
	/**
	 * Check if los Arcos cines is displayed
	 * 
	 * @return
	 */
	public boolean isLosArcosCinesDisplayed() {

		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- Start isLosArcosCinesDisplayed method");
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- End isLosArcosCinesDisplayed method");

		return this.isElementVisibleByXPath(CINES);
	}

	/**
	 * This method click on LosArcos tiendas/deportes page
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public LosArcosTiendasMainPage moveOnLosArcosTiendasPage() throws InterruptedException {
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- Start clickOnPage method");

		String xpathLink = "//*[@id='pictoHome']/li[1]/a";

		driver.moveMouseOverElement(By.xpath(xpathLink));

		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- End clickOnPage method");
		return new LosArcosTiendasMainPage(driver);

	}

	public LosArcosTiendasMainPage clickOnLosArcosTiendasPage() {
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- Start clickOnPage method");

		String xpathLink = "//*[@id='pictoHome']/li[1]/ul/li[6]/a";

		driver.clickIfExists(By.xpath(xpathLink));

		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- End clickOnPage method");
		return new LosArcosTiendasMainPage(driver);

	}
	

}
