package com.dogoo.poc.account.application.validator;

import com.dogoo.poc.account.application.model.AccountRest;
import com.dogoo.poc.account.model.AccountEntry;
import com.dogoo.poc.account.service.AccountEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;

@Component(immediate = true,service = AccountRestValidate.class)
public class AccountRestValidate {
    private static final String ACCOUNT_NOT_FOUND = "Not found account";
    private static final String FULLNAME_REQUEST = "Full name request";


    public  void  validatorForAddAccountRest(AccountRest accountRest){
        checkRequiredField(accountRest.getFullName(),FULLNAME_REQUEST);
        checkRequiredField(accountRest.getEmail(),FULLNAME_REQUEST);
        checkRequiredField(accountRest.getNewUser(),FULLNAME_REQUEST);
        checkRequiredField(String.valueOf(accountRest.getPassword()),FULLNAME_REQUEST);
        checkRequiredField(String.valueOf(accountRest.getPhone()),FULLNAME_REQUEST);
    }

    public void validatorIsExists(long accountId){
        AccountEntry accountEntry = accountEntryLocalService.fetchAccountEntry(accountId);
        if (accountEntry != null){
            return;
        }
        throw new NotFoundException(ACCOUNT_NOT_FOUND);
    }

    private void checkRequiredField(String value,String erroMsg){
        if (null == value || value.trim().isEmpty()){
            throw  new BadRequestException(erroMsg);
        }
    }

    @Reference
    private AccountEntryLocalService accountEntryLocalService;


}
