/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.dogoo.poc.account.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AccountRoleEntryService}.
 *
 * @author Brian Wing Shun Chan
 * @see AccountRoleEntryService
 * @generated
 */
public class AccountRoleEntryServiceWrapper
	implements AccountRoleEntryService,
			   ServiceWrapper<AccountRoleEntryService> {

	public AccountRoleEntryServiceWrapper(
		AccountRoleEntryService accountRoleEntryService) {

		_accountRoleEntryService = accountRoleEntryService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _accountRoleEntryService.getOSGiServiceIdentifier();
	}

	@Override
	public AccountRoleEntryService getWrappedService() {
		return _accountRoleEntryService;
	}

	@Override
	public void setWrappedService(
		AccountRoleEntryService accountRoleEntryService) {

		_accountRoleEntryService = accountRoleEntryService;
	}

	private AccountRoleEntryService _accountRoleEntryService;

}