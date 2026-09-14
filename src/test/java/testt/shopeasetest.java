package testt;

import org.testng.annotations.Test;

import baseclass.bbase;
import pagess.shopeasepage;

public class shopeasetest extends bbase{
	shopeasepage sn;
	@Test(priority=1)
	public void ValidcredentialsSignin() {
		test = extent.createTest("Validcredentials");
		 driver.get(url);

	        sn = new shopeasepage(driver);
	        sn.Signin("user_tihaj1@shopease.com",
	                  "Test@5037"
	        		 );
	  sn.Signinclick();
	}
	@Test(priority=2)
	public void viewdetails() {
	 test=extent.createTest("click view details");
	   shopeasepage sn=new shopeasepage(driver);
	   sn.viewdetails();
}
	@Test(priority=3)
	public void clickaddtocart() {
		 test=extent.createTest("click add to cart");
		   sn=new shopeasepage(driver);
		   sn.clickaddtocart();
	}
		  

	@Test(priority=4)
	public void couponcode() {
		test = extent.createTest("enter couponcode");
	        sn = new shopeasepage(driver);
	        sn.couponcode("FLAT50"
	        		 );
	}
	@Test(priority=5)
		public void checkout() {
			test=extent.createTest("click checkout");
			  shopeasepage sn=new shopeasepage(driver);
			   sn.checkout();
			  
		}
	@Test(priority=6)
	public void filldetails(){
		test = extent.createTest("filldetails");
		shopeasepage sn = new shopeasepage(driver);
		 sn.filldetails("6983254105","ABCD street London","Trivandrum","kerala","687790");
		       
	}
	@Test(priority=7)
	public void clickplaceorder() {
		test = extent.createTest("clickplaceorder");
		 sn = new shopeasepage(driver);
		 sn.placeorder();
		
	}
}
	    
	
