package kisinna.orgDataParser;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		List<Company> data = new OrgDataParser().getCompanyList("data.json");
for (Company company:data) {
	System.out.println(company.getName());
}
	}

}
