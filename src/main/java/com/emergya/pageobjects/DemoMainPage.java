package com.emergya.pageobjects;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class DemoMainPage extends BasePageObject{

	public DemoMainPage(EmergyaWebDriver driver) {
		super(driver);
		
	}

	@Override
	public boolean isReady() {
		
		return false;
	}

}
