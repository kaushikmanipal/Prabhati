package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPOM {

private WebDriver driver;
	
	public ProductPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@id=\"ProductsSystem_YD9pMDOx\"]/div[1]/div[1]/div/div[3]/div/div/div[1]/h4/a")
	private WebElement vitaeProduct;
	
	@FindBy(xpath="/html/body/div/section[2]/div/div/div[1]/div/div/div/nav/div/div[3]/select")
	private WebElement sortByListBox;           
	
	public void clickVitaeProductLink() {
		this.vitaeProduct.click(); 
	}
	
	public void clickSortByListBox() {
		this.sortByListBox.click();
	}
	  
	public void selectSortByListBox() {
	Select s1 = new Select(sortByListBox);
	s1.selectByVisibleText("Name (A - Z)");
	}
	
	public void selectSortByListBoxRating() {
	Select s1 = new Select(sortByListBox);
	s1.selectByVisibleText("Rating (Highest)");
		
	}
}
