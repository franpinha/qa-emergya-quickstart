package com.emergya.pageobjects;

import java.util.logging.Level;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class TestingSliderMainPage extends BasePageObject {

	/**
	 * Logger class initialization.
	 */
	static Logger log = Logger.getLogger(TestingSliderMainPage.class);

	/**
	 * Items keys selectors from properties.
	 */

	private static final String SLIDER = "slider";

	public TestingSliderMainPage(EmergyaWebDriver driver) {
		super(driver);

	}

	@Override
	public boolean isReady() {

		return false;
	}

	public boolean isTestingSliderPageDisplayed() {

		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName()
				+ "]- Start isTestingPageDisplayed method");

		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName()
				+ "]- End isTestingPageDisplayed method");

		return this.isElementVisibleById(SLIDER);

	}

	public void moveToSlider() {
		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName()
				+ "]- Start moveToSlider method");
		int x = 90;
		WebElement slider = driver.findElementById(SLIDER);

		int longitudSlider = slider.getSize().getWidth();

		if (this.isElementVisibleById(SLIDER)) {
			driver.clickOnWithMouse(By.id(SLIDER));

			Actions action = new Actions(driver);
			action.moveToElement(slider, ((longitudSlider * x) / 100), 0).click();

			action.build().perform();

			
				driver.sleep(4);
		
		}

		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName()
				+ "]- End moveToSlider method");
	}

}
