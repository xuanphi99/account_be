package com.dogoo.poc.account.internal.service;


import com.dogoo.poc.account.dto.v1_0.Account;
import com.dogoo.poc.account.internal.mapper.AccountMapper;
import com.dogoo.poc.account.model.AccountEntry;
import com.dogoo.poc.account.service.AccountEntryLocalService;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.SearchUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Collections;

@Component(immediate = true, service = com.dogoo.poc.account.internal.service.AccountService.class)
public class AccountService {

    public Page<Account> getAccounts(String search, Filter filter,
                                     Pagination pagination, Sort[] sorts,
                                     ServiceContext serviceContext) throws Exception {
        return SearchUtil.search(
                Collections.emptyMap(),
                booleanQuery -> {
                },
                filter, AccountEntry.class, search, pagination,
                queryConfig -> queryConfig.setSelectedFieldNames(
                        Field.ENTRY_CLASS_PK), searchContext -> searchContext.setCompanyId(
                        serviceContext.getCompanyId()),
                sorts,
                document -> accountMapper.mapFromAccountEntryToAccount(
                        accountEntryLocalService.getAccountEntry(
                                GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)))));
    }

    @Reference
    private AccountMapper accountMapper;

    @Reference
    private AccountEntryLocalService accountEntryLocalService;
}
