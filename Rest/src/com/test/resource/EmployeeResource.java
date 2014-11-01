package com.test.resource;

import com.test.Employee;
import com.test.EmployeeResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class EmployeeResource {

	@GET
	@Path("/getemployee")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployee() {
		Employee emp1 = new Employee();
		emp1.setDesignation("Pirate");
		emp1.setFirstName("James");
		emp1.setLastName("Bond");
		emp1.setEmployeeNumber(1);
		return emp1;
	}

	@POST
	@Path("/updateemployee")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	
	public EmployeeResponse updateEmployee(Employee emp) {
		EmployeeResponse response = new EmployeeResponse();
		// Just check for employee number and return a test json message back
		if (emp.getEmployeeNumber() > 0) {
			response.setSuccess(true);
			response.setErrorMessage("");
		} else {
			response.setSuccess(false);
			response.setErrorMessage("Employee number is invalid");
		}
		return response;
	}

}
