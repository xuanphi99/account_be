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

package com.dogoo.account.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AccountRoleEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AccountRoleEntryLocalService
 * @generated
 */
public class AccountRoleEntryLocalServiceWrapper
	implements AccountRoleEntryLocalService,
			   ServiceWrapper<AccountRoleEntryLocalService> {

	public AccountRoleEntryLocalServiceWrapper(
		AccountRoleEntryLocalService accountRoleEntryLocalService) {

		_accountRoleEntryLocalService = accountRoleEntryLocalService;
	}

	/**
	 * Adds the account role entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AccountRoleEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param accountRoleEntry the account role entry
	 * @return the account role entry that was added
	 */
	@Override
	public com.dogoo.account.model.AccountRoleEntry addAccountRoleEntry(
		com.dogoo.account.model.AccountRoleEntry accountRoleEntry) {

		return _accountRoleEntryLocalService.addAccountRoleEntry(
			accountRoleEntry);
	}

	/**
	 * Creates a new account role entry with the primary key. Does not add the account role entry to the database.
	 *
	 * @param AccountRoleId the primary key for the new account role entry
	 * @return the new account role entry
	 */
	@Override
	public com.dogoo.account.model.AccountRoleEntry createAccountRoleEntry(
		long AccountRoleId) {

		return _accountRoleEntryLocalService.createAccountRoleEntry(
			AccountRoleId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountRoleEntryLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the account role entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AccountRoleEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param accountRoleEntry the account role entry
	 * @return the account role entry that was removed
	 */
	@Override
	public com.dogoo.account.model.AccountRoleEntry deleteAccountRoleEntry(
		com.dogoo.account.model.AccountRoleEntry accountRoleEntry) {

		return _accountRoleEntryLocalService.deleteAccountRoleEntry(
			accountRoleEntry);
	}

	/**
	 * Deletes the account role entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AccountRoleEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param AccountRoleId the primary key of the account role entry
	 * @return the account role entry that was removed
	 * @throws PortalException if a account role entry with the primary key could not be found
	 */
	@Override
	public com.dogoo.account.model.AccountRoleEntry deleteAccountRoleEntry(
			long AccountRoleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountRoleEntryLocalService.deleteAccountRoleEntry(
			AccountRoleId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountRoleEntryLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _accountRoleEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _accountRoleEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _accountRoleEntryLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _accountRoleEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.account.model.impl.AccountRoleEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _accountRoleEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.account.model.impl.AccountRoleEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _accountRoleEntryLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _accountRoleEntryLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _accountRoleEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.dogoo.account.model.AccountRoleEntry fetchAccountRoleEntry(
		long AccountRoleId) {

		return _accountRoleEntryLocalService.fetchAccountRoleEntry(
			AccountRoleId);
	}

	/**
	 * Returns the account role entry matching the UUID and group.
	 *
	 * @param uuid the account role entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching account role entry, or <code>null</code> if a matching account role entry could not be found
	 */
	@Override
	public com.dogoo.account.model.AccountRoleEntry
		fetchAccountRoleEntryByUuidAndGroupId(String uuid, long groupId) {

		return _accountRoleEntryLocalService.
			fetchAccountRoleEntryByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the account role entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.account.model.impl.AccountRoleEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of account role entries
	 * @param end the upper bound of the range of account role entries (not inclusive)
	 * @return the range of account role entries
	 */
	@Override
	public java.util.List<com.dogoo.account.model.AccountRoleEntry>
		getAccountRoleEntries(int start, int end) {

		return _accountRoleEntryLocalService.getAccountRoleEntries(start, end);
	}

	/**
	 * Returns all the account role entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the account role entries
	 * @param companyId the primary key of the company
	 * @return the matching account role entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.dogoo.account.model.AccountRoleEntry>
		getAccountRoleEntriesByUuidAndCompanyId(String uuid, long companyId) {

		return _accountRoleEntryLocalService.
			getAccountRoleEntriesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of account role entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the account role entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of account role entries
	 * @param end the upper bound of the range of account role entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching account role entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.dogoo.account.model.AccountRoleEntry>
		getAccountRoleEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.dogoo.account.model.AccountRoleEntry> orderByComparator) {

		return _accountRoleEntryLocalService.
			getAccountRoleEntriesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of account role entries.
	 *
	 * @return the number of account role entries
	 */
	@Override
	public int getAccountRoleEntriesCount() {
		return _accountRoleEntryLocalService.getAccountRoleEntriesCount();
	}

	/**
	 * Returns the account role entry with the primary key.
	 *
	 * @param AccountRoleId the primary key of the account role entry
	 * @return the account role entry
	 * @throws PortalException if a account role entry with the primary key could not be found
	 */
	@Override
	public com.dogoo.account.model.AccountRoleEntry getAccountRoleEntry(
			long AccountRoleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountRoleEntryLocalService.getAccountRoleEntry(AccountRoleId);
	}

	/**
	 * Returns the account role entry matching the UUID and group.
	 *
	 * @param uuid the account role entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching account role entry
	 * @throws PortalException if a matching account role entry could not be found
	 */
	@Override
	public com.dogoo.account.model.AccountRoleEntry
			getAccountRoleEntryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountRoleEntryLocalService.
			getAccountRoleEntryByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _accountRoleEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _accountRoleEntryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _accountRoleEntryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _accountRoleEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountRoleEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the account role entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AccountRoleEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param accountRoleEntry the account role entry
	 * @return the account role entry that was updated
	 */
	@Override
	public com.dogoo.account.model.AccountRoleEntry updateAccountRoleEntry(
		com.dogoo.account.model.AccountRoleEntry accountRoleEntry) {

		return _accountRoleEntryLocalService.updateAccountRoleEntry(
			accountRoleEntry);
	}

	@Override
	public AccountRoleEntryLocalService getWrappedService() {
		return _accountRoleEntryLocalService;
	}

	@Override
	public void setWrappedService(
		AccountRoleEntryLocalService accountRoleEntryLocalService) {

		_accountRoleEntryLocalService = accountRoleEntryLocalService;
	}

	private AccountRoleEntryLocalService _accountRoleEntryLocalService;

}