package com.emergya.pageObjects;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class RegisterTestMainPage extends BasePageObject {

	public RegisterTestMainPage(EmergyaWebDriver driver) {
		super(driver);
		
	}

	@Override
	public boolean isReady() {
	
		return false;
	}

}
