package com.dogoo.poc.account.internal.resource.v1_0;

import com.dogoo.poc.account.dto.v1_0.Account;
import com.dogoo.poc.account.internal.odata.v1_0.AccountEntityIndexModel;
import com.dogoo.poc.account.internal.service.AccountService;
import com.dogoo.poc.account.internal.validator.AccountValidator;
import com.dogoo.poc.account.resource.v1_0.AccountResource;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import javax.ws.rs.core.MultivaluedMap;

/**
 * @author phidx
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/account.properties",
	scope = ServiceScope.PROTOTYPE, service = AccountResource.class
)
public class AccountResourceImpl extends BaseAccountResourceImpl {

	private AccountEntityIndexModel accountEntityIndexModel = new AccountEntityIndexModel();

	@Override
	public EntityModel getEntityModel(MultivaluedMap multivaluedMap) {
		return accountEntityIndexModel;
	}

	@Override
	public Page<Account> getAllAccount(String search, Filter filter,
									 Pagination pagination, Sort[] sorts) throws Exception {

		accountValidator.validatorForSearch(pagination);
		Page<Account> roles = accountService.getAccounts(search, filter, pagination, sorts, getServiceContext());


		return accountService.getAccounts(search, filter, pagination, sorts, getServiceContext());
	}

	public ServiceContext getServiceContext() {
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setCompanyId(contextCompany.getCompanyId());
		serviceContext.setUserId(contextUser.getUserId());
		serviceContext.setScopeGroupId(contextUser.getGroupId());

		return serviceContext;
	}
	@Reference
	private AccountService accountService;

	@Reference
	private AccountValidator accountValidator;

}