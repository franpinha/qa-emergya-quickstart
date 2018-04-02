package com.emergya.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class TestingSliderMainPage extends BasePageObject{
	
	/**
	 * Logger class initialization.
	 */
	static Logger log = Logger.getLogger(TestingSliderMainPage.class);
	
	/**
	 * Items keys selectors from properties.
	 */

	private static final String SLIDER = "slider";
	//private static final String MOVESLIDER="#slider > a";

	public TestingSliderMainPage(EmergyaWebDriver driver) {
		super(driver);
	
	}

	@Override
	public boolean isReady() {
		
		return false;
	}
	
	public boolean isTestingSliderPageDisplayed() {

		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- Start isTestingPageDisplayed method");
	
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- End isTestingPageDisplayed method");
	
		return this.isElementVisibleById(SLIDER);
		
	}
	
	public void moveToSlider() {
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- Start moveToSlider method");
		int x=90;
		WebElement slider = driver.findElementById(SLIDER);
		//WebElement slider2 = driver.findElement(By.cssSelector(MOVESLIDER));
		int longitudSlider= slider.getSize().getWidth();
		
		/*if(this.isElementVisibleById(SLIDER)) {
			for(int i=0;i<=90; i++) {
				slider2.sendKeys(Keys.ARROW_RIGHT);
				slider2.sendKeys(Keys.ARROW_LEFT);
			}
		}*/
		if(this.isElementVisibleById(SLIDER)) {
			driver.clickOnWithMouse(By.id(SLIDER));
			
			Actions action = new Actions(driver);
			action.moveToElement(slider, ((longitudSlider * x)/100),0).click();
			
			action.build().perform();
			
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}
		}
		
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- End moveToSlider method");
	}

}
