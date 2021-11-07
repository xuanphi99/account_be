package com.dogoo.poc.account.internal.mapper;

import com.dogoo.poc.account.dto.v1_0.Account;
import com.dogoo.poc.account.model.AccountEntry;
import com.liferay.portal.kernel.exception.PortalException;
import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = com.dogoo.poc.account.internal.mapper.AccountMapper.class)
public class AccountMapper {
    public Account mapFromAccountEntryToAccount(AccountEntry from) throws PortalException {
        Account to = new Account();

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