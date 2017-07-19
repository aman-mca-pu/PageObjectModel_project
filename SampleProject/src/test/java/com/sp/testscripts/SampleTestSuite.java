package com.sp.testscripts;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;





import com.sp.datainitialization.DataInt;
//import com.yp.pagefactory.YPBase;
import com.sp.utilities.Util;
import com.sp.utilities.Xls_Reader;


public class SampleTestSuite extends Base {
	
	public static final Logger LOG = Logger.getLogger(SampleTestSuite.class);
	String testDataPath = System.getProperty("user.dir")
			+ "\\src\\main\\java\\com\\sp\\test\\data\\TestData.xlsx";
	public Xls_Reader xls = new Xls_Reader(testDataPath);

	
	
	@Test(description = "Login", dataProvider = "getLogin", priority = 0)
	public void Login(DataInt dataInt) throws Exception {
			login= driverhome.getLogin();
			login.accountlogin(dataInt);			
	}
	
	
	
	
	
			@DataProvider
			public Iterator<Object[]> getLogin() {
				return Util.getLoginData("Login", xls).iterator();

			}
			
			
			
			
}


