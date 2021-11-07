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

package com.dogoo.poc.account.service.impl;

import com.dogoo.dataitem.exception.NoSuchDataItemEntryException;
import com.dogoo.dataitem.model.DataItemEntry;
import com.dogoo.dataitem.service.DataItemEntryLocalServiceUtil;
import com.dogoo.poc.account.model.AccountEntry;
import com.dogoo.poc.account.model.AccountRoleEntry;
import com.dogoo.poc.account.service.base.AccountRoleEntryLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.model.SystemEventConstants;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.systemevent.SystemEvent;
import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * The implementation of the account role entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.dogoo.poc.account.service.AccountRoleEntryLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AccountRoleEntryLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.dogoo.account.model.AccountRoleEntry",
	service = AopService.class
)
public class AccountRoleEntryLocalServiceImpl
	extends AccountRoleEntryLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.dogoo.poc.account.service.AccountRoleEntryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.dogoo.poc.account.service.AccountRoleEntryLocalServiceUtil</code>.
	 */
	@Indexable(type = IndexableType.REINDEX)
	@SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
	public void addRoles(AccountEntry accountEntry,long[] roleIds) throws NoSuchDataItemEntryException {

		for (Long i: roleIds) {
			DataItemEntry dataItemEntry = DataItemEntryLocalServiceUtil.findByCodeAndType(String.valueOf(i),"ROLE");

			AccountRoleEntry accountRoleEntry = createAccountRoleEntry(counterLocalService.increment(AccountRoleEntry.class.getName()));
			accountRoleEntry.setAccountId(accountEntry.getAccountId());
			accountRoleEntry.setCode(dataItemEntry.getCode());
			accountRoleEntry.setName(dataItemEntry.getName());
			addAccountRoleEntry(accountRoleEntry);
		}



	}

	@Indexable(type = IndexableType.REINDEX)
	@SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
	public List<AccountRoleEntry> findAllByAccountId(long accountId){

		return 	accountRoleEntryPersistence.findByAccountId(accountId);
	}


}