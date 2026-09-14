package pagess;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class shopeasepage {
   WebDriver driver;
   @FindBy(name="email")WebElement username;
   @FindBy(name="password")WebElement password;
   @FindBy(xpath="/html/body/main/div/div/div/div/div/form/button")WebElement signinbutton;
   @FindBy(xpath="//div[contains(@class,'product-card')]//a[contains(.,'View Details')]")WebElement viewdetails;
   @FindBy(xpath="//button[contains(normalize-space(), 'Add to Cart')]")WebElement addtocart;
   @FindBy(xpath="/html/body/main/div/div/div[2]/div[2]/div/a")WebElement checkout;
   @FindBy(name="coupon_code")WebElement couponcode;
   @FindBy(name="phone")WebElement phonenumber;
   @FindBy(name="address")WebElement address;
   @FindBy(name="city")WebElement city;
   @FindBy(name="state")WebElement state;
   @FindBy(name="zip_code")WebElement zip;
   @FindBy(xpath="/html/body/main/div/form/div/div[2]/div/div[2]/button")WebElement placeorder;
 
   public shopeasepage(WebDriver driver) {
	    this.driver = driver;

	 PageFactory.initElements(driver, this);
	}

	public void Signin() {
		signinbutton.click();
	}
	 public void Signin(String username,String password) {
		this. username.sendKeys(username);
		this. password.sendKeys(password);
	 }
	 public void Signinclick() {
		 signinbutton.click();
	 }
	 public void viewdetails() {
		 viewdetails.click();
	 }
	 public void clickaddtocart() {
		 addtocart.click();
	 }
	 public void couponcode(String couponcode) {
		 this.couponcode.sendKeys(couponcode);
	 }
	 public void checkout() {
		 checkout.click();
	 }
	 public void filldetails(String phoneNumberValue, String addressValue,
             String cityValue, String stateValue, String zipValue) {

        phonenumber.sendKeys(phoneNumberValue);
         address.sendKeys(addressValue);
         city.sendKeys(cityValue);
         state.sendKeys(stateValue);
        zip.sendKeys(zipValue);
}
	 
	 public void placeorder() {
		 placeorder.click();
		
	 }

	  
	 
	 

}