package TestNG;

import org.testng.annotations.DataProvider;

public class TestDataClass {
	@DataProvider
	public Object[][] loginData(){
		return new Object[][] {
			{"tnk","tnk@gmail.com"},
			{"nus","nus@gmail.com"}
		};
	}

}
