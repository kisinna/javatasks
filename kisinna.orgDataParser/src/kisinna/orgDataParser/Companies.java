package kisinna.orgDataParser;

import java.util.List;

public class Companies {
 private List<Company> companies;

public Companies(List<Company> companies) {
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
