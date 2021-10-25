package com.dogoo.employee.rest.application.mapper;

import com.dogoo.employee.rest.application.model.EmployeeRest;
import com.liferay.portal.kernel.exception.PortalException;
import com.poc.employee.model.EmployeeEntry;
import org.osgi.service.component.annotations.Component;

@Component(immediate = true,service = EmployeeRestMapper.class)
public class EmployeeRestMapper {
    public EmployeeRest mapFromEmployeeEntryToEmployee(EmployeeEntry employeeEntry) throws PortalException{
        EmployeeRest to = new EmployeeRest();

        to.setEmployeeId(employeeEntry.getEmployeeId());
        to.setAddress(employeeEntry.getAddress());
        to.setBirthDay(employeeEntry.getBirthDay());
        to.setGender(employeeEntry.getGender());
        to.setName(employeeEntry.getName());
        to.setHasAccount(employeeEntry.isHasAccount());
        return to;
    }
}
