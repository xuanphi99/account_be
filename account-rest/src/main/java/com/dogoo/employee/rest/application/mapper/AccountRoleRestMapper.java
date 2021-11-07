package com.dogoo.employee.rest.application.mapper;

import com.dogoo.dataitem.model.DataItemEntry;
import com.dogoo.employee.rest.application.model.AccountRoleRest;
import com.dogoo.employee.rest.application.model.DataItemRest;
import com.dogoo.poc.account.model.AccountRoleEntry;
import org.osgi.service.component.annotations.Component;

import java.util.ArrayList;
import java.util.List;

@Component(immediate = true,service = AccountRoleRestMapper.class)
public class AccountRoleRestMapper {

    public AccountRoleRest mapFromAccountRoleEntryToAccountRest(AccountRoleEntry from){
        AccountRoleRest to = new AccountRoleRest();

        to.setAccountRoleId(from.getAccountRoleId());
        to.setAccountId(from.getAccountId());
        to.setName(from.getName());
        to.setCode(from.getCode());

        return to;
    }

    public List<AccountRoleRest> mapFromAccountRoleToList(List<AccountRoleEntry> from){
        List<AccountRoleRest> accountRoleRests = new ArrayList<>();

        for (AccountRoleEntry item: from) {
            accountRoleRests.add(mapFromAccountRoleEntryToAccountRest(item));
        }
        return  accountRoleRests;
    }

}
