package com.dogoo.employee.rest.application.validator;

import com.dogoo.employee.rest.application.model.EmployeeRest;
import com.poc.employee.model.EmployeeEntry;
import com.poc.employee.service.EmployeeEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;

@Component(immediate = true,service = EmployeeRestValidator.class)
public class EmployeeRestValidator {
    private static final String EMPLOYEE_NOT_FOUND = "Not found Employee";
    private static final String NAME_REQUEST  = "Employee Name is requested";
    private static final String BIRTHDAY_REQUEST  = "Birthday is requested";
    private static final String GENDER_REQUEST  = "Gender is requested";
    private static final String ADDRESS_REQUEST  = "Address is requested";
    private static final String HAS_ACCOUNT_REQUEST  = "Has account is requested";

    public  void  validatorForAddEmployeeRest(EmployeeRest employeeRest){
        checkRequiredField(employeeRest.getName(),NAME_REQUEST);
        checkRequiredField(employeeRest.getAddress(),ADDRESS_REQUEST);
        checkRequiredField(employeeRest.getBirthDay().toString(),BIRTHDAY_REQUEST);
        checkRequiredField(String.valueOf(employeeRest.getGender()),GENDER_REQUEST);
        checkRequiredField(String.valueOf(employeeRest.isHasAccount()),HAS_ACCOUNT_REQUEST);
    }
    public void validatorForUpdateEmployeeRest(long employeeId,EmployeeRest employeeRest){
        validatorEmployeeIsExists(employeeId);
        checkRequiredField(employeeRest.getName(),NAME_REQUEST);
        checkRequiredField(employeeRest.getAddress(),ADDRESS_REQUEST);
        checkRequiredField(employeeRest.getBirthDay().toString(),BIRTHDAY_REQUEST);
        checkRequiredField(String.valueOf(employeeRest.getGender()),GENDER_REQUEST);
        checkRequiredField(String.valueOf(employeeRest.isHasAccount()),HAS_ACCOUNT_REQUEST);

    }
    public void validatorEmployeeIsExists(long employeeId){
        EmployeeEntry employeeEntry = employeeEntryLocalService.fetchEmployeeEntry(employeeId);
        if (employeeEntry != null){
            return;
        }
        throw new NotFoundException(EMPLOYEE_NOT_FOUND);
    }
    private void checkRequiredField(String value,String erroMsg){
        if (null == value || value.trim().isEmpty()){
            throw  new BadRequestException(erroMsg);
        }
    }
    @Reference
    private EmployeeEntryLocalService employeeEntryLocalService ;
}
