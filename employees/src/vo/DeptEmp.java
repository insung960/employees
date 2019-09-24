package vo;

public class DeptEmp 
{
	private String fromDate;
	private String toDate;
	private Employees employees;
	private Departments departments;
	public String getFromDate() 
	{
		return fromDate;
	}
	public void setFromDate(String fromDate) 
	{
		this.fromDate = fromDate;
	}
	public String getToDate()
	{
		return toDate;
	}
	public void setToDate(String toDate) 
	{
		this.toDate = toDate;
	}
	public Employees getEmployees() 
	{
		return employees;
	}
	public void setEmployees(Employees employees) 
	{
		this.employees = employees;
	}
	public Departments getDepartments()
	{
		return departments;
	}
	public void setDepartments(Departments departments) 
	{
		this.departments = departments;
	}
}
