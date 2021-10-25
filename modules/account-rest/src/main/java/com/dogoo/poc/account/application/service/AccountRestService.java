package com.dogoo.poc.account.application.service;

import com.dogoo.poc.account.application.mapper.AccountRestMapper;
import com.dogoo.poc.account.application.model.AccountRest;
import com.dogoo.poc.account.model.AccountEntry;
import com.dogoo.poc.account.service.AccountEntryLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true,service = AccountRestService.class)
public class AccountRestService {

    public AccountRest getDetailAccount(long accountId) throws PortalException {
        AccountEntry employeeEntry = accountEntryLocalService.getDetailAccount(accountId);
        AccountRest accountRest = accountRestMapper.mapFromAccountEntryToAccount(employeeEntry);
        // set role
        return  accountRest;
    }
    public AccountRest addEmployee(AccountRest accountRest, long[] roleIds, ServiceContext serviceContext)throws PortalException {
        AccountEntry accountEntry = accountRestMapper.mapFromAccountRestToAccountEntry(accountRest);
        AccountEntry employeeEntry = accountEntryLocalService.addAccount(accountEntry,roleIds,serviceContext);
        return accountRestMapper.mapFromAccountEntryToAccount(employeeEntry);
    }

    @Reference
    private AccountEntryLocalService accountEntryLocalService;



    @Reference
    private AccountRestMapper accountRestMapper;
}
