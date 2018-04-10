package com.emergya.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;


public class UploadWithoutRobot extends BasePageObject{
	/**
	 * Logger class initialization.
	 */
	static Logger log = Logger.getLogger(UploadWithoutRobot.class);
	
	private static final String UPLOADBUTTON="uploadbutton";
	private static final String OMAYO="omayo";

	public UploadWithoutRobot(EmergyaWebDriver driver) {
		super(driver);
	
	}

	@Override
	public boolean isReady() {
		
		return false;
	}
	
	public void clickOnUploadFiles() {
	
		if(this.isElementVisibleById(UPLOADBUTTON)) {
		//this.getElementById(UPLOADBUTTON).click();
		driver.sleep(3);
		WebElement boton = this.getElementById(UPLOADBUTTON);
		boton.sendKeys("/home/fjmartinez/mis-proyectos/qa-emergya-quickstart/src/main/resources/files/tux.jpg");
		driver.sleep(3);
		}
	}
	public boolean isLogoDisplayedOmayo() {

		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName()
				+ "]- Start isTwoIframesLogoDisplayed method");
		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName()
				+ "]- End isTwoIframesLogoDisplayed method");

		return this.isElementVisibleById(OMAYO);

}
}
