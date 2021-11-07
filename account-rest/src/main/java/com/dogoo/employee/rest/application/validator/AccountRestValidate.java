package com.dogoo.employee.rest.application.validator;

import com.dogoo.employee.rest.application.model.AccountRest;
import com.dogoo.exception.api.BadRequestException;
import com.dogoo.exception.api.NotFoundException;
import com.dogoo.poc.account.exception.NoSuchAccountEntryException;
import com.dogoo.poc.account.model.AccountEntry;
import com.dogoo.poc.account.service.AccountEntryLocalService;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;
import java.util.Objects;

@Component(immediate = true,service = AccountRestValidate.class)
public class AccountRestValidate {
    private static final String ACCOUNT_NOT_FOUND = "Not found account";
    private static final String ACCOUNT_DUPLICATE = "Email or UserName is exist";
    private static final String SCREEN_NAME_IS_EXIST = "User Name is exist";
    private static final String FULL_NAME_REQUEST = "Full Name request";
    private static final String EMAIL_REQUEST = "Email request";
    private static final String NEW_USER_REQUEST = "User Name request";
    private static final String PASSWORD_REQUEST = "Password request";
    private static final String PHONE_REQUEST = "Phone request";
    private static final String DEPARTMENT_REQUEST = "Department request";
    private static final String POSITION_REQUEST = "Position request";


    public  void  validatorForAddAccountRest(AccountRest accountRest) throws BadRequestException {
        checkRequiredField(accountRest.getFullName(),FULL_NAME_REQUEST);
        checkRequiredField(accountRest.getEmail(),EMAIL_REQUEST);
        checkRequiredField(accountRest.getNewUser(),NEW_USER_REQUEST);
        checkRequiredField(accountRest.getPassword(),PASSWORD_REQUEST);
        checkRequiredField(accountRest.getPhone(),PHONE_REQUEST);
        checkRequiredField(accountRest.getDepartmentId(),DEPARTMENT_REQUEST);
        checkRequiredField(accountRest.getPositionId(),POSITION_REQUEST);
    }

    public void validatorIsExists(long accountId) throws NotFoundException {
        AccountEntry accountEntry = accountEntryLocalService.fetchAccountEntry(accountId);
        if (accountEntry != null){
            return;
        }
        throw new NotFoundException("DG-404",ACCOUNT_NOT_FOUND);
    }

    public void validateUseNameIsExists(String userName,String email) throws BadRequestException, NoSuchAccountEntryException {
        List<Objects[]> list = accountEntryLocalService.checkAccountExist(email,userName);
        if ( list.size() == 0){
            return;
        }
        throw new BadRequestException("DG-500",ACCOUNT_DUPLICATE);
    }

    public void validateScreeNameExists(long companyId,String screeName) throws BadRequestException {
       User user = userLocalService.fetchUserByScreenName(companyId,screeName) ;
        if (null != user)
       throw  new BadRequestException("DG-500",SCREEN_NAME_IS_EXIST);

        return;
    }

    private void checkRequiredField(Object value,String msg) throws BadRequestException {
        if (value instanceof String) {
            String str = (String) value;
            if (null == str || str.trim().isEmpty()) {
                throw new BadRequestException("DG-400",msg);
            }
        }
        if (value instanceof  Long && null == value ){

                throw new BadRequestException("DG-122",msg);
        }

    }

    @Reference
    private AccountEntryLocalService accountEntryLocalService;

    @Reference
    private UserLocalService userLocalService;

}
