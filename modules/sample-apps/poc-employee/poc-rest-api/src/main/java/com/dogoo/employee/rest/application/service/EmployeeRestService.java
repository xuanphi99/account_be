package com.dogoo.employee.rest.application.service;

import com.dogoo.employee.rest.application.mapper.EmployeeRestMapper;
import com.dogoo.employee.rest.application.model.EmployeeRest;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.poc.employee.model.EmployeeEntry;
import com.poc.employee.service.EmployeeEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true,service = EmployeeRestService.class)
public class EmployeeRestService {

    public EmployeeRest getEmployee(long employeeId) throws PortalException{
        EmployeeEntry employeeEntry = employeeEntryLocalService.getEmployeeEntry(employeeId);
        return employeeRestMapper.mapFromEmployeeEntryToEmployee(employeeEntry);
    }
    public EmployeeRest addEmployee(EmployeeRest employeeRest, ServiceContext serviceContext)throws PortalException {
        EmployeeEntry employeeEntry = employeeEntryLocalService.addEmployee(employeeRest.getName(),employeeRest.getBirthDay(),
                employeeRest.getGender(),employeeRest.getAddress(),employeeRest.isHasAccount(),serviceContext);
        return employeeRestMapper.mapFromEmployeeEntryToEmployee(employeeEntry);
    }
    public void deleteEmployee(long employeeId)throws  PortalException{
        employeeEntryLocalService.deleteEmployeeEntry(employeeId);
    }
    public EmployeeRest updateEmployee(long employeeId,EmployeeRest employeeRest,ServiceContext serviceContext)throws PortalException{
        EmployeeEntry employeeEntry = employeeEntryLocalService.updateEmployee(employeeId,employeeRest.getName(),
                employeeRest.getBirthDay(),employeeRest.getGender(),employeeRest.getAddress(),employeeRest.isHasAccount(),serviceContext);
        return employeeRestMapper.mapFromEmployeeEntryToEmployee(employeeEntry);
    }
   @Reference
   private EmployeeRestMapper employeeRestMapper ;
    @Reference
    private EmployeeEntryLocalService employeeEntryLocalService;
}
