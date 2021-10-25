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

import com.dogoo.poc.account.model.CategoryEntry;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for CategoryEntry. This utility wraps
 * <code>com.dogoo.poc.account.service.impl.CategoryEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CategoryEntryLocalService
 * @generated
 */
public class CategoryEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.dogoo.poc.account.service.impl.CategoryEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addAccountEntryCategoryEntries(
		long accountId, List<CategoryEntry> categoryEntries) {

		getService().addAccountEntryCategoryEntries(accountId, categoryEntries);
	}

	public static void addAccountEntryCategoryEntries(
		long accountId, long[] categoryIds) {

		getService().addAccountEntryCategoryEntries(accountId, categoryIds);
	}

	public static void addAccountEntryCategoryEntry(
		long accountId, CategoryEntry categoryEntry) {

		getService().addAccountEntryCategoryEntry(accountId, categoryEntry);
	}

	public static void addAccountEntryCategoryEntry(
		long accountId, long categoryId) {

		getService().addAccountEntryCategoryEntry(accountId, categoryId);
	}

	/**
	 * Adds the category entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CategoryEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param categoryEntry the category entry
	 * @return the category entry that was added
	 */
	public static CategoryEntry addCategoryEntry(CategoryEntry categoryEntry) {
		return getService().addCategoryEntry(categoryEntry);
	}

	public static void clearAccountEntryCategoryEntries(long accountId) {
		getService().clearAccountEntryCategoryEntries(accountId);
	}

	/**
	 * Creates a new category entry with the primary key. Does not add the category entry to the database.
	 *
	 * @param categoryId the primary key for the new category entry
	 * @return the new category entry
	 */
	public static CategoryEntry createCategoryEntry(long categoryId) {
		return getService().createCategoryEntry(categoryId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	public static void deleteAccountEntryCategoryEntries(
		long accountId, List<CategoryEntry> categoryEntries) {

		getService().deleteAccountEntryCategoryEntries(
			accountId, categoryEntries);
	}

	public static void deleteAccountEntryCategoryEntries(
		long accountId, long[] categoryIds) {

		getService().deleteAccountEntryCategoryEntries(accountId, categoryIds);
	}

	public static void deleteAccountEntryCategoryEntry(
		long accountId, CategoryEntry categoryEntry) {

		getService().deleteAccountEntryCategoryEntry(accountId, categoryEntry);
	}

	public static void deleteAccountEntryCategoryEntry(
		long accountId, long categoryId) {

		getService().deleteAccountEntryCategoryEntry(accountId, categoryId);
	}

	/**
	 * Deletes the category entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CategoryEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param categoryEntry the category entry
	 * @return the category entry that was removed
	 */
	public static CategoryEntry deleteCategoryEntry(
		CategoryEntry categoryEntry) {

		return getService().deleteCategoryEntry(categoryEntry);
	}

	/**
	 * Deletes the category entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CategoryEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param categoryId the primary key of the category entry
	 * @return the category entry that was removed
	 * @throws PortalException if a category entry with the primary key could not be found
	 */
	public static CategoryEntry deleteCategoryEntry(long categoryId)
		throws PortalException {

		return getService().deleteCategoryEntry(categoryId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.poc.account.model.impl.CategoryEntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.poc.account.model.impl.CategoryEntryModelImpl</code>.
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

	public static CategoryEntry fetchCategoryEntry(long categoryId) {
		return getService().fetchCategoryEntry(categoryId);
	}

	/**
	 * Returns the category entry matching the UUID and group.
	 *
	 * @param uuid the category entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching category entry, or <code>null</code> if a matching category entry could not be found
	 */
	public static CategoryEntry fetchCategoryEntryByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchCategoryEntryByUuidAndGroupId(uuid, groupId);
	}

	public static List<CategoryEntry> getAccountEntryCategoryEntries(
		long accountId) {

		return getService().getAccountEntryCategoryEntries(accountId);
	}

	public static List<CategoryEntry> getAccountEntryCategoryEntries(
		long accountId, int start, int end) {

		return getService().getAccountEntryCategoryEntries(
			accountId, start, end);
	}

	public static List<CategoryEntry> getAccountEntryCategoryEntries(
		long accountId, int start, int end,
		OrderByComparator<CategoryEntry> orderByComparator) {

		return getService().getAccountEntryCategoryEntries(
			accountId, start, end, orderByComparator);
	}

	public static int getAccountEntryCategoryEntriesCount(long accountId) {
		return getService().getAccountEntryCategoryEntriesCount(accountId);
	}

	/**
	 * Returns the accountIds of the account entries associated with the category entry.
	 *
	 * @param categoryId the categoryId of the category entry
	 * @return long[] the accountIds of account entries associated with the category entry
	 */
	public static long[] getAccountEntryPrimaryKeys(long categoryId) {
		return getService().getAccountEntryPrimaryKeys(categoryId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the category entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.poc.account.model.impl.CategoryEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of category entries
	 * @param end the upper bound of the range of category entries (not inclusive)
	 * @return the range of category entries
	 */
	public static List<CategoryEntry> getCategoryEntries(int start, int end) {
		return getService().getCategoryEntries(start, end);
	}

	/**
	 * Returns all the category entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the category entries
	 * @param companyId the primary key of the company
	 * @return the matching category entries, or an empty list if no matches were found
	 */
	public static List<CategoryEntry> getCategoryEntriesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getCategoryEntriesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of category entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the category entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of category entries
	 * @param end the upper bound of the range of category entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching category entries, or an empty list if no matches were found
	 */
	public static List<CategoryEntry> getCategoryEntriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CategoryEntry> orderByComparator) {

		return getService().getCategoryEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of category entries.
	 *
	 * @return the number of category entries
	 */
	public static int getCategoryEntriesCount() {
		return getService().getCategoryEntriesCount();
	}

	/**
	 * Returns the category entry with the primary key.
	 *
	 * @param categoryId the primary key of the category entry
	 * @return the category entry
	 * @throws PortalException if a category entry with the primary key could not be found
	 */
	public static CategoryEntry getCategoryEntry(long categoryId)
		throws PortalException {

		return getService().getCategoryEntry(categoryId);
	}

	/**
	 * Returns the category entry matching the UUID and group.
	 *
	 * @param uuid the category entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching category entry
	 * @throws PortalException if a matching category entry could not be found
	 */
	public static CategoryEntry getCategoryEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getCategoryEntryByUuidAndGroupId(uuid, groupId);
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

	public static boolean hasAccountEntryCategoryEntries(long accountId) {
		return getService().hasAccountEntryCategoryEntries(accountId);
	}

	public static boolean hasAccountEntryCategoryEntry(
		long accountId, long categoryId) {

		return getService().hasAccountEntryCategoryEntry(accountId, categoryId);
	}

	public static void setAccountEntryCategoryEntries(
		long accountId, long[] categoryIds) {

		getService().setAccountEntryCategoryEntries(accountId, categoryIds);
	}

	/**
	 * Updates the category entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CategoryEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param categoryEntry the category entry
	 * @return the category entry that was updated
	 */
	public static CategoryEntry updateCategoryEntry(
		CategoryEntry categoryEntry) {

		return getService().updateCategoryEntry(categoryEntry);
	}

	public static CategoryEntryLocalService getService() {
		return _service;
	}

	private static volatile CategoryEntryLocalService _service;

}