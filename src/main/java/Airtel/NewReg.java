package Airtel;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import data.DataReader;


public class NewReg extends BaseTest {

	@Test (dataProvider = "getData")
	public void registration(HashMap<String, String> input) throws IOException, InterruptedException {
		LaunchApplication();

		User_Login Login = new User_Login(driver);
		Login.goTo();
		Login.userLoginCp(input.get("UsernameCp"), input.get("UserPassword"));

		Customer_Details CD = new Customer_Details(driver);
		CD.customerDetails(input.get("MSISDN"), input.get("SimSerialNumber"), input.get("FirstName"),
				input.get("LastName"), input.get("Address"), input.get("indexForAm"), input.get("indexForIdType"),
				input.get("IdNumber"), input.get("IdImagesFront"), input.get("PlaceOfBirth"));

		Login.userLoginDe(input.get("UsernameDe"), input.get("UserPassword"));
		Case_Management CM = new Case_Management(driver);
		CM.DEOpenCase(input.get("AMServiceForm"), input.get("Gender"), input.get("IdIssueAuthority"),
				input.get("month"), input.get("day"));
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		DataReader Reader = new DataReader();
		List<HashMap<String, String>> data = Reader.getJsonDataToMap();

		return new Object[][] { { data.get(0) } };
		
		
	}

}

