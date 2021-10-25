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

import com.dogoo.poc.account.exception.NoSuchAccountEntryException;
import com.dogoo.poc.account.model.AccountEntry;
import com.dogoo.poc.account.model.CategoryEntry;
import com.dogoo.poc.account.service.base.AccountEntryLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.SystemEventConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.systemevent.SystemEvent;
import com.liferay.portal.kernel.util.LocaleUtil;
import org.osgi.service.component.annotations.Component;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the account entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.dogoo.poc.account.service.AccountEntryLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AccountEntryLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.dogoo.poc.account.model.AccountEntry",
	service = AopService.class
)
public class AccountEntryLocalServiceImpl
	extends AccountEntryLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.dogoo.poc.account.service.AccountEntryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.dogoo.poc.account.service.AccountEntryLocalServiceUtil</code>.
	 */

	@Indexable(type = IndexableType.REINDEX)
	@SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
	public AccountEntry addAccount(AccountEntry accountEntry, long[] roleIds, ServiceContext context) throws PortalException {

		User user = userLocalService.addUser(
				context.getUserId(), //creatorUserId
				context.getCompanyId(), //companyId
				true, //autoPassword
				accountEntry.getPassword(), //password1
				accountEntry.getPassword(), //password2
				false, //autoScreenName
				accountEntry.getUserName(), //screenName
				accountEntry.getEmail(), //emailAddress
				0, //facebookId
				null, //openId
				LocaleUtil.getDefault(), //locale
				accountEntry.getFullName(), //firstName
				accountEntry.getFullName(), //middleName
				accountEntry.getFullName(), //lastName
				0, //prefixId
				0, //suffixId
				false, //male
				0, //birthdayMonth
				1, //birthdayDay
				1970, //birthdayYear
				null, //jobTitle
				null, //groupIds
				null, //organizationIds
				roleIds, //roleIds
				null, //userGroupIds
				false, //sendEmail
				context); //serviceContext

		AccountEntry account = createAccountEntry(counterLocalService.increment(AccountEntry.class.getName()));
		Date current = new Date();
		updateModifierAudit(account,current,context);

		account.setGroupId(context.getScopeGroupId());
		account.setCompanyId(context.getCompanyId());
		account.setCreateDate(context.getCreateDate(current));
		account.setModifiedDate(context.getModifiedDate(current));

		account.setFullName(accountEntry.getFullName());
		account.setEmail(accountEntry.getEmail());
		account.setNewUser(accountEntry.getNewUser());
		account.setPassword(accountEntry.getPassword());
		account.setPhone(accountEntry.getPhone());
		account.setDepartmentId(accountEntry.getDepartmentId());
		account.setPositionId(accountEntry.getPositionId());
		account.setUserIdMapping((int) user.getUserId());

		//Save
		AccountEntry acc = addAccountEntry(account);
		// Save account-role
		for (Long i: roleIds) {
			CategoryEntry categoryEntry = categoryEntryPersistence.findByCodeAndType(Math.toIntExact(i),"ROLE");
			addCategoryEntryAccountEntry(categoryEntry.getCategoryId(), acc.getAccountId());
		}
		System.out.println("--------"+ acc.getUserIdMapping()+" "+ acc.getUserId());
		return acc;


	}


	@Indexable(type = IndexableType.REINDEX)
	public AccountEntry getDetailAccount(long accountId) throws  NoSuchAccountEntryException {
		return accountEntryPersistence.findByPrimaryKey(accountId);
	}

	@Indexable(type = IndexableType.REINDEX)
	public List<AccountEntry> getAllAccount(int start, int end) {
		return accountEntryPersistence.findAll(start, end);
	}



	private void updateModifierAudit(AccountEntry accountEntry, Date current, ServiceContext serviceContext) {
		User user = userLocalService.fetchUser(serviceContext.getUserId());

		if (user != null) {
			accountEntry.setUserName(user.getFullName());
			accountEntry.setUserUuid(user.getUserUuid());
		}

		accountEntry.setModifiedDate(serviceContext.getModifiedDate(current));
		accountEntry.setUserId(serviceContext.getUserId());

	}

}