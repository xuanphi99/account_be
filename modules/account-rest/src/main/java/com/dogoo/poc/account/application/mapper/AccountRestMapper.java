package com.dogoo.poc.account.application.mapper;

import com.dogoo.poc.account.application.model.AccountRest;
import com.dogoo.poc.account.model.AccountEntry;
import com.liferay.portal.kernel.model.Account;
import org.osgi.service.component.annotations.Component;

@Component(immediate = true,service = AccountRestMapper.class)
public class AccountRestMapper {
    public AccountRest mapFromAccountEntryToAccount(AccountEntry from){
        AccountRest to = new AccountRest();
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
    public AccountEntry mapFromAccountRestToAccountEntry(AccountRest from){
        AccountEntry to = null;
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
