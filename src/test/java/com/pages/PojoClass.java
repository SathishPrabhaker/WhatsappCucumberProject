package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class PojoClass extends BaseClass   {
public PojoClass() {
	PageFactory.initElements(driver,this);
}
@FindBy(xpath="//div[contains(text(),'WhatsApp is open in another window')]")
private WebElement mess;
@FindBy(xpath="(//div[contains(text(),'Use Here')])[2]")
private WebElement useHere;
@FindBy(xpath="//div[contains(text(),'Close')]")
private WebElement close;
public WebElement getMess() {
	return mess;
}
public WebElement getUseHere() {
	return useHere;
}
public WebElement getClose() {
	return close;
}

}
