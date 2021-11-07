package com.dogoo.employee.rest.application.service;

import com.dogoo.dataitem.service.DataItemEntryLocalService;
import com.dogoo.department.service.DepartmentEntryLocalService;
import com.dogoo.employee.rest.application.mapper.AccountRestMapper;
import com.dogoo.employee.rest.application.mapper.AccountRoleRestMapper;
import com.dogoo.employee.rest.application.mapper.DataItemRestMapper;
import com.dogoo.employee.rest.application.mapper.DepartmentRestMapper;
import com.dogoo.employee.rest.application.model.AccountRest;
import com.dogoo.employee.rest.application.model.PageRest;
import com.dogoo.poc.account.model.AccountEntry;
import com.dogoo.poc.account.service.AccountEntryLocalService;
import com.dogoo.poc.account.service.AccountRoleEntryLocalService;
import com.liferay.portal.kernel.exception.PortalException;
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component(immediate = true,service = AccountRestService.class)
public class AccountRestService {

    private static final String DEPARTMENT = "DEPARTMENT";
    private static final String POSITION = "POSITION";

    public AccountRest getDetailAccount(long accountId) throws PortalException {
        AccountEntry accountEntry = accountEntryLocalService.getDetailAccount(accountId);
        AccountRest accountRest = accountRestMapper.mapFromAccountEntryToAccount(accountEntry);
        // set data-items

        accountRest.setAccountRole( accountRoleRestMapper.mapFromAccountRoleToList(accountRoleEntryLocalService.findAllByAccountId(accountRest.getAccountId())));

        accountRest.setCategoryDepartment(departmentRestMapper.mapFromDepartmentEntryToDepartment(departmentEntryLocalService.getDepartmentEntry(accountEntry.getDepartmentId())));
        accountRest.setCategoryPosition(dataItemRestMapper.mapFromCategoryEntryToCategory(dataItemEntryLocalService.findByCodeAndType(POSITION, String.valueOf(accountEntry.getPositionId() ))));

        return  accountRest;
    }
    public AccountRest addAccount(AccountRest entry, long[] roles,
                                   ServiceContext serviceContext)throws PortalException {
        AccountEntry accountEntry = accountEntryLocalService.addAccount(
                entry.getFullName(),entry.getEmail(),
                entry.getNewUser(),entry.getPassword(), entry.getPhone(), entry.getDepartmentId(),
                entry.getPositionId(),roles,serviceContext);
        AccountRest accountRest = accountRestMapper.mapFromAccountEntryToAccount(accountEntry);
        accountRest.setAccountRole( accountRoleRestMapper.mapFromAccountRoleToList(accountRoleEntryLocalService.findAllByAccountId(accountRest.getAccountId())));

        accountRest.setCategoryDepartment(departmentRestMapper.mapFromDepartmentEntryToDepartment(departmentEntryLocalService.getDepartmentEntry(accountEntry.getDepartmentId())));
        accountRest.setCategoryPosition(dataItemRestMapper.mapFromCategoryEntryToCategory(dataItemEntryLocalService.findByCodeAndType(POSITION, String.valueOf(accountEntry.getPositionId() ))));

        return accountRest;
    }

    public PageRest pagination(int page, int pageSize) throws NoSuchCategoryEntryException {
        int pageCurrent = (page-1) * pageSize;
        List<AccountEntry> entryList = accountEntryLocalService.getAllAccount(pageCurrent,pageSize+pageCurrent);
        List<AccountRest> accountRests = new ArrayList<>();

        for (AccountEntry item: entryList) {
            AccountRest accountRest = accountRestMapper.mapFromAccountEntryToAccount(item);
            // List Roles
            accountRest.setCategoryRole(dataItemRestMapper.mapFromCategoryRestToList(categoryEntryLocalService.getAllCategoryByAccount(item.getAccountId())));

            //  Department , Position

          accountRest.setCategoryDepartment(dataItemRestMapper.mapFromCategoryEntryToCategory(categoryEntryLocalService.getDepartmentDetail(item.getDepartmentId(),DEPARTMENT )));

          accountRest.setCategoryPosition(dataItemRestMapper.mapFromCategoryEntryToCategory(categoryEntryLocalService.getDepartmentDetail(item.getPositionId(),POSITION )));

          accountRests.add(accountRest);


        }

        return PageRest.getPagingInfo(accountEntryLocalService.getAccountEntriesCount(), pageSize,page,accountRests);
    }


    public Page<AccountRest> getAllAccounts(String search, Filter filter,
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
                document -> accountRestMapper.mapFromAccountEntryToAccount(
                        accountEntryLocalService.getAccountEntry(
                                GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)))));
    }

    public  AccountRest getRoles(AccountRest rest){
        rest.setCategoryRole(dataItemRestMapper.mapFromCategoryRestToList(categoryEntryLocalService.getAllCategoryByAccount(rest.getAccountId())));
        return rest;
    }

    @Reference
    private AccountRoleEntryLocalService accountRoleEntryLocalService;

    @Reference
    private DataItemEntryLocalService dataItemEntryLocalService;

    @Reference
    private DepartmentEntryLocalService departmentEntryLocalService;

    @Reference
    private AccountEntryLocalService accountEntryLocalService;

    @Reference
    private AccountRestMapper accountRestMapper;


    @Reference
    private DataItemRestMapper dataItemRestMapper;

    @Reference
    private DepartmentRestMapper departmentRestMapper;

    @Reference
    private AccountRoleRestMapper accountRoleRestMapper;


}
