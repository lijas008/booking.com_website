package testPkg;

import org.testng.annotations.Test;

import basePkg.baseClass;
import pagePkg.pageClass;

public class testClass extends baseClass {
	
	
	@Test
	public void test() {
		pageClass b = new pageClass(driver);
		b.destination();
		b.checkinoutDetails();
		b.personalData();
		b.search();
	}
	

}
