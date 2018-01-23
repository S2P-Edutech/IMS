package com.ims.dao;

import java.util.List;

import com.ims.actions.Organization;
import com.ims.actions.OrganizationDetails;


public interface IOrganizationDao {

	List<Organization> readDataFromDb();
	List<Organization> getAllData();
	OrganizationDetails addOrganization(OrganizationDetails org);
}
