package org.spr.hbr.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.spr.hbr.model.Employee;
import org.springframework.stereotype.Repository;

@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao<Integer, Employee> implements EmployeeDao {

	public Employee findById(int id) {
		return getByKey(id);
	}

	public void saveEmployee(Employee employee) {
		persist(employee);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> findAllEmployees() {
		Criteria criteria = createEntityCriteria();
		return (List<Employee>) criteria.list();
	}


}
