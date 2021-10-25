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

import com.dogoo.poc.account.exception.NoSuchAccountEntryException;
import com.dogoo.poc.account.model.AccountEntry;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.model.SystemEventConstants;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.systemevent.SystemEvent;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for AccountEntry. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see AccountEntryLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface AccountEntryLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.dogoo.poc.account.service.impl.AccountEntryLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the account entry local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link AccountEntryLocalServiceUtil} if injection and service tracking are not available.
	 */
	@Indexable(type = IndexableType.REINDEX)
	@SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
	public AccountEntry addAccount(
			AccountEntry accountEntry, long[] roleIds, ServiceContext context)
		throws PortalException;

	/**
	 * Adds the account entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AccountEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param accountEntry the account entry
	 * @return the account entry that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public AccountEntry addAccountEntry(AccountEntry accountEntry);

	public void addCategoryEntryAccountEntries(
		long categoryId, List<AccountEntry> accountEntries);

	public void addCategoryEntryAccountEntries(
		long categoryId, long[] accountIds);

	public void addCategoryEntryAccountEntry(
		long categoryId, AccountEntry accountEntry);

	public void addCategoryEntryAccountEntry(long categoryId, long accountId);

	public void clearCategoryEntryAccountEntries(long categoryId);

	/**
	 * Creates a new account entry with the primary key. Does not add the account entry to the database.
	 *
	 * @param accountId the primary key for the new account entry
	 * @return the new account entry
	 */
	@Transactional(enabled = false)
	public AccountEntry createAccountEntry(long accountId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the account entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AccountEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param accountEntry the account entry
	 * @return the account entry that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public AccountEntry deleteAccountEntry(AccountEntry accountEntry);

	/**
	 * Deletes the account entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AccountEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param accountId the primary key of the account entry
	 * @return the account entry that was removed
	 * @throws PortalException if a account entry with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public AccountEntry deleteAccountEntry(long accountId)
		throws PortalException;

	public void deleteCategoryEntryAccountEntries(
		long categoryId, List<AccountEntry> accountEntries);

	public void deleteCategoryEntryAccountEntries(
		long categoryId, long[] accountIds);

	public void deleteCategoryEntryAccountEntry(
		long categoryId, AccountEntry accountEntry);

	public void deleteCategoryEntryAccountEntry(
		long categoryId, long accountId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int dslQueryCount(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.poc.account.model.impl.AccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.poc.account.model.impl.AccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AccountEntry fetchAccountEntry(long accountId);

	/**
	 * Returns the account entry matching the UUID and group.
	 *
	 * @param uuid the account entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching account entry, or <code>null</code> if a matching account entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AccountEntry fetchAccountEntryByUuidAndGroupId(
		String uuid, long groupId);

	/**
	 * Returns a range of all the account entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.poc.account.model.impl.AccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of account entries
	 * @param end the upper bound of the range of account entries (not inclusive)
	 * @return the range of account entries
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AccountEntry> getAccountEntries(int start, int end);

	/**
	 * Returns all the account entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the account entries
	 * @param companyId the primary key of the company
	 * @return the matching account entries, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AccountEntry> getAccountEntriesByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of account entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the account entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of account entries
	 * @param end the upper bound of the range of account entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching account entries, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AccountEntry> getAccountEntriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AccountEntry> orderByComparator);

	/**
	 * Returns the number of account entries.
	 *
	 * @return the number of account entries
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAccountEntriesCount();

	/**
	 * Returns the account entry with the primary key.
	 *
	 * @param accountId the primary key of the account entry
	 * @return the account entry
	 * @throws PortalException if a account entry with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AccountEntry getAccountEntry(long accountId) throws PortalException;

	/**
	 * Returns the account entry matching the UUID and group.
	 *
	 * @param uuid the account entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching account entry
	 * @throws PortalException if a matching account entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AccountEntry getAccountEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Indexable(type = IndexableType.REINDEX)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AccountEntry> getAllAccount(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AccountEntry> getCategoryEntryAccountEntries(long categoryId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AccountEntry> getCategoryEntryAccountEntries(
		long categoryId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AccountEntry> getCategoryEntryAccountEntries(
		long categoryId, int start, int end,
		OrderByComparator<AccountEntry> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCategoryEntryAccountEntriesCount(long categoryId);

	/**
	 * Returns the categoryIds of the category entries associated with the account entry.
	 *
	 * @param accountId the accountId of the account entry
	 * @return long[] the categoryIds of category entries associated with the account entry
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getCategoryEntryPrimaryKeys(long accountId);

	@Indexable(type = IndexableType.REINDEX)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AccountEntry getDetailAccount(long accountId)
		throws NoSuchAccountEntryException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasCategoryEntryAccountEntries(long categoryId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasCategoryEntryAccountEntry(
		long categoryId, long accountId);

	public void setCategoryEntryAccountEntries(
		long categoryId, long[] accountIds);

	/**
	 * Updates the account entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AccountEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param accountEntry the account entry
	 * @return the account entry that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public AccountEntry updateAccountEntry(AccountEntry accountEntry);

}