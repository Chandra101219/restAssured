package api.payloads;

public class Employee {
	String emp_id;
	String emp_name;
    String Designation;
    String Company;
    String[] Skills;
	
    public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public String getCompany() {
		return Company;
	}
	public void setCompany(String company) {
		Company = company;
	}
	public String[] getSkills() {
		return Skills;
	}
	public void setSkills(String[] skills) {
		Skills = skills;
	}
	

}
