package com.dogoo.employee.rest.application.mapper;

import com.dogoo.employee.rest.application.model.AccountRest;
import com.dogoo.poc.account.model.AccountEntry;
import org.osgi.service.component.annotations.Component;

@Component(immediate = true,service = AccountRestMapper.class)
public class AccountRestMapper {

    public AccountRest mapFromAccountEntryToAccount(AccountEntry from){
        AccountRest to = new AccountRest();
        to.setAccountId(from.getAccountId());
        to.setFullName(from.getFullName());
        to.setEmail(from.getEmail());
        to.setNewUser(from.getNewUser());
        to.setPassword(from.getPassword());
        to.setPhone(from.getPhone());
        to.setDepartmentId(from.getDepartmentId());
        to.setPositionId(from.getPositionId());
        to.setUserIdMapping(from.getUserIdMapping());

        return to;
    }



}
