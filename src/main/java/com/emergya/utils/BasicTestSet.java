package com.emergya.utils;

import com.emergya.pageObjects.LosArcosMainPage;
import com.emergya.pageObjects.LosArcosTiendasMainPage;
import com.emergya.pageObjects.NoTodoCodigoMainPage;
import com.emergya.pageObjects.LosArcosAccesosMainPage;
import com.emergya.pageObjects.EmergyaMainPage;
import com.emergya.pageObjects.GoogleMainPage;
import com.emergya.pageObjects.LosArcosCineMainPage;
import com.emergya.selenium.testSet.DefaultTestSet;

/**
 * PageObjects variable references
 * 
 * @author Jose Antonio Sanchez <jasanchez@emergya.com>
 */
public abstract class BasicTestSet extends DefaultTestSet {
	protected GoogleMainPage googleMainPage;
	protected EmergyaMainPage emergyaMainPage;
	protected LosArcosMainPage losArcosMainPage;
	protected LosArcosAccesosMainPage losArcosAccesosMainPage;
	protected LosArcosCineMainPage losArcosCineMainPage;
	protected LosArcosTiendasMainPage losArcosTiendasMainPage;
	protected NoTodoCodigoMainPage noTodoCodigoMainPage;
}
