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

import com.dogoo.poc.account.model.AccountEntry;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for AccountEntry. This utility wraps
 * <code>com.dogoo.poc.account.service.impl.AccountEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AccountEntryLocalService
 * @generated
 */
public class AccountEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.dogoo.poc.account.service.impl.AccountEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static AccountEntry addAccount(
			AccountEntry accountEntry, long[] roleIds,
			com.liferay.portal.kernel.service.ServiceContext context)
		throws PortalException {

		return getService().addAccount(accountEntry, roleIds, context);
	}

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
	public static AccountEntry addAccountEntry(AccountEntry accountEntry) {
		return getService().addAccountEntry(accountEntry);
	}

	public static void addCategoryEntryAccountEntries(
		long categoryId, List<AccountEntry> accountEntries) {

		getService().addCategoryEntryAccountEntries(categoryId, accountEntries);
	}

	public static void addCategoryEntryAccountEntries(
		long categoryId, long[] accountIds) {

		getService().addCategoryEntryAccountEntries(categoryId, accountIds);
	}

	public static void addCategoryEntryAccountEntry(
		long categoryId, AccountEntry accountEntry) {

		getService().addCategoryEntryAccountEntry(categoryId, accountEntry);
	}

	public static void addCategoryEntryAccountEntry(
		long categoryId, long accountId) {

		getService().addCategoryEntryAccountEntry(categoryId, accountId);
	}

	public static void clearCategoryEntryAccountEntries(long categoryId) {
		getService().clearCategoryEntryAccountEntries(categoryId);
	}

	/**
	 * Creates a new account entry with the primary key. Does not add the account entry to the database.
	 *
	 * @param accountId the primary key for the new account entry
	 * @return the new account entry
	 */
	public static AccountEntry createAccountEntry(long accountId) {
		return getService().createAccountEntry(accountId);
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
	 * Deletes the account entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AccountEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param accountEntry the account entry
	 * @return the account entry that was removed
	 */
	public static AccountEntry deleteAccountEntry(AccountEntry accountEntry) {
		return getService().deleteAccountEntry(accountEntry);
	}

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
	public static AccountEntry deleteAccountEntry(long accountId)
		throws PortalException {

		return getService().deleteAccountEntry(accountId);
	}

	public static void deleteCategoryEntryAccountEntries(
		long categoryId, List<AccountEntry> accountEntries) {

		getService().deleteCategoryEntryAccountEntries(
			categoryId, accountEntries);
	}

	public static void deleteCategoryEntryAccountEntries(
		long categoryId, long[] accountIds) {

		getService().deleteCategoryEntryAccountEntries(categoryId, accountIds);
	}

	public static void deleteCategoryEntryAccountEntry(
		long categoryId, AccountEntry accountEntry) {

		getService().deleteCategoryEntryAccountEntry(categoryId, accountEntry);
	}

	public static void deleteCategoryEntryAccountEntry(
		long categoryId, long accountId) {

		getService().deleteCategoryEntryAccountEntry(categoryId, accountId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.poc.account.model.impl.AccountEntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.poc.account.model.impl.AccountEntryModelImpl</code>.
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

	public static AccountEntry fetchAccountEntry(long accountId) {
		return getService().fetchAccountEntry(accountId);
	}

	/**
	 * Returns the account entry matching the UUID and group.
	 *
	 * @param uuid the account entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching account entry, or <code>null</code> if a matching account entry could not be found
	 */
	public static AccountEntry fetchAccountEntryByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchAccountEntryByUuidAndGroupId(uuid, groupId);
	}

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
	public static List<AccountEntry> getAccountEntries(int start, int end) {
		return getService().getAccountEntries(start, end);
	}

	/**
	 * Returns all the account entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the account entries
	 * @param companyId the primary key of the company
	 * @return the matching account entries, or an empty list if no matches were found
	 */
	public static List<AccountEntry> getAccountEntriesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getAccountEntriesByUuidAndCompanyId(
			uuid, companyId);
	}

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
	public static List<AccountEntry> getAccountEntriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AccountEntry> orderByComparator) {

		return getService().getAccountEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of account entries.
	 *
	 * @return the number of account entries
	 */
	public static int getAccountEntriesCount() {
		return getService().getAccountEntriesCount();
	}

	/**
	 * Returns the account entry with the primary key.
	 *
	 * @param accountId the primary key of the account entry
	 * @return the account entry
	 * @throws PortalException if a account entry with the primary key could not be found
	 */
	public static AccountEntry getAccountEntry(long accountId)
		throws PortalException {

		return getService().getAccountEntry(accountId);
	}

	/**
	 * Returns the account entry matching the UUID and group.
	 *
	 * @param uuid the account entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching account entry
	 * @throws PortalException if a matching account entry could not be found
	 */
	public static AccountEntry getAccountEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getAccountEntryByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<AccountEntry> getAllAccount(int start, int end) {
		return getService().getAllAccount(start, end);
	}

	public static List<AccountEntry> getCategoryEntryAccountEntries(
		long categoryId) {

		return getService().getCategoryEntryAccountEntries(categoryId);
	}

	public static List<AccountEntry> getCategoryEntryAccountEntries(
		long categoryId, int start, int end) {

		return getService().getCategoryEntryAccountEntries(
			categoryId, start, end);
	}

	public static List<AccountEntry> getCategoryEntryAccountEntries(
		long categoryId, int start, int end,
		OrderByComparator<AccountEntry> orderByComparator) {

		return getService().getCategoryEntryAccountEntries(
			categoryId, start, end, orderByComparator);
	}

	public static int getCategoryEntryAccountEntriesCount(long categoryId) {
		return getService().getCategoryEntryAccountEntriesCount(categoryId);
	}

	/**
	 * Returns the categoryIds of the category entries associated with the account entry.
	 *
	 * @param accountId the accountId of the account entry
	 * @return long[] the categoryIds of category entries associated with the account entry
	 */
	public static long[] getCategoryEntryPrimaryKeys(long accountId) {
		return getService().getCategoryEntryPrimaryKeys(accountId);
	}

	public static AccountEntry getDetailAccount(long accountId)
		throws com.dogoo.poc.account.exception.NoSuchAccountEntryException {

		return getService().getDetailAccount(accountId);
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

	public static boolean hasCategoryEntryAccountEntries(long categoryId) {
		return getService().hasCategoryEntryAccountEntries(categoryId);
	}

	public static boolean hasCategoryEntryAccountEntry(
		long categoryId, long accountId) {

		return getService().hasCategoryEntryAccountEntry(categoryId, accountId);
	}

	public static void setCategoryEntryAccountEntries(
		long categoryId, long[] accountIds) {

		getService().setCategoryEntryAccountEntries(categoryId, accountIds);
	}

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
	public static AccountEntry updateAccountEntry(AccountEntry accountEntry) {
		return getService().updateAccountEntry(accountEntry);
	}

	public static AccountEntryLocalService getService() {
		return _service;
	}

	private static volatile AccountEntryLocalService _service;

}