package pkg.base.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.orm.hibernate5.HibernateTemplate;

import pkg.base.entity.Admin;
import pkg.base.entity.Calculation;
import pkg.base.entity.Customer;
import pkg.base.entity.InsurancePolicy;

public interface DAO {

	// Getter to get "HibernateTemplate" object.
	HibernateTemplate getHibernateTemplate();

	// Setter to set "HibernateTemplate" object.
	void setHibernateTemplate(HibernateTemplate hibernateTemplate);

	// toString() to convert DAOImpl to String type.
	String toString();

	// Creating new "Customer" account.
	String createNewCustomerAccount(Customer newCustomer);

	// Update customer's data.
	void updateCustomersData(Customer customer);

	// Finding a "Customer" by "username".
	Customer getCustomerByUsername(String username);

	// Creating new "Admin" account.
	String createNewAdminAccount(Admin newAdmin);

	// Finding a "Admin" by "username".
	Admin getAdminByUsername(String username);

	// Add or update a policy.
	void addOrUpdateInsurancePolicy(InsurancePolicy insurancePolicy);

	// Delete an existing policy.
	boolean deletePolicyById(UUID policyId);

	// Get policy by policy id.
	InsurancePolicy getInsurancePolicyById(UUID policyId);

	// Get policy by policy name.
	List<InsurancePolicy> getInsurancePolicyByPolicyName(String policyName);

	// Get all policies.
	List<InsurancePolicy> getAllInsurancePolicies();

	// Get calculation by id.
	Calculation getCalculationById(UUID calculationId);

	// Delete calculation.
	public void deleteCalculation(Calculation calculation);

	// Delete all calculations of provided list.
	void deleteAllCalculations(List<Calculation> calculations);
}
