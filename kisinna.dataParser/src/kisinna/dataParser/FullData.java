package kisinna.dataParser;

import java.util.List;

public class FullData {
 private List<Company> companies;

public FullData(List<Company> companies) {
	super();
	this.companies = companies;
}

public List<Company> getCompanies() {
	return companies;
}

public void setCompanies(List<Company> companies) {
	this.companies = companies;
}
}
