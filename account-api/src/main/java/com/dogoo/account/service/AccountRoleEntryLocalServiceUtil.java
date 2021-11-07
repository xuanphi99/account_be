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

import com.dogoo.account.model.AccountRoleEntry;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for AccountRoleEntry. This utility wraps
 * <code>com.dogoo.account.service.impl.AccountRoleEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AccountRoleEntryLocalService
 * @generated
 */
public class AccountRoleEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.dogoo.account.service.impl.AccountRoleEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static AccountRoleEntry addAccountRoleEntry(
		AccountRoleEntry accountRoleEntry) {

		return getService().addAccountRoleEntry(accountRoleEntry);
	}

	/**
	 * Creates a new account role entry with the primary key. Does not add the account role entry to the database.
	 *
	 * @param AccountRoleId the primary key for the new account role entry
	 * @return the new account role entry
	 */
	public static AccountRoleEntry createAccountRoleEntry(long AccountRoleId) {
		return getService().createAccountRoleEntry(AccountRoleId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	public static AccountRoleEntry deleteAccountRoleEntry(
		AccountRoleEntry accountRoleEntry) {

		return getService().deleteAccountRoleEntry(accountRoleEntry);
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
	public static AccountRoleEntry deleteAccountRoleEntry(long AccountRoleId)
		throws PortalException {

		return getService().deleteAccountRoleEntry(AccountRoleId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static AccountRoleEntry fetchAccountRoleEntry(long AccountRoleId) {
		return getService().fetchAccountRoleEntry(AccountRoleId);
	}

	/**
	 * Returns the account role entry matching the UUID and group.
	 *
	 * @param uuid the account role entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching account role entry, or <code>null</code> if a matching account role entry could not be found
	 */
	public static AccountRoleEntry fetchAccountRoleEntryByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchAccountRoleEntryByUuidAndGroupId(
			uuid, groupId);
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
	public static List<AccountRoleEntry> getAccountRoleEntries(
		int start, int end) {

		return getService().getAccountRoleEntries(start, end);
	}

	/**
	 * Returns all the account role entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the account role entries
	 * @param companyId the primary key of the company
	 * @return the matching account role entries, or an empty list if no matches were found
	 */
	public static List<AccountRoleEntry>
		getAccountRoleEntriesByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getAccountRoleEntriesByUuidAndCompanyId(
			uuid, companyId);
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
	public static List<AccountRoleEntry>
		getAccountRoleEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<AccountRoleEntry> orderByComparator) {

		return getService().getAccountRoleEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of account role entries.
	 *
	 * @return the number of account role entries
	 */
	public static int getAccountRoleEntriesCount() {
		return getService().getAccountRoleEntriesCount();
	}

	/**
	 * Returns the account role entry with the primary key.
	 *
	 * @param AccountRoleId the primary key of the account role entry
	 * @return the account role entry
	 * @throws PortalException if a account role entry with the primary key could not be found
	 */
	public static AccountRoleEntry getAccountRoleEntry(long AccountRoleId)
		throws PortalException {

		return getService().getAccountRoleEntry(AccountRoleId);
	}

	/**
	 * Returns the account role entry matching the UUID and group.
	 *
	 * @param uuid the account role entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching account role entry
	 * @throws PortalException if a matching account role entry could not be found
	 */
	public static AccountRoleEntry getAccountRoleEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getAccountRoleEntryByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
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
	public static AccountRoleEntry updateAccountRoleEntry(
		AccountRoleEntry accountRoleEntry) {

		return getService().updateAccountRoleEntry(accountRoleEntry);
	}

	public static AccountRoleEntryLocalService getService() {
		return _service;
	}

	private static volatile AccountRoleEntryLocalService _service;

}