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
 * Provides a wrapper for {@link CategoryEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CategoryEntryLocalService
 * @generated
 */
public class CategoryEntryLocalServiceWrapper
	implements CategoryEntryLocalService,
			   ServiceWrapper<CategoryEntryLocalService> {

	public CategoryEntryLocalServiceWrapper(
		CategoryEntryLocalService categoryEntryLocalService) {

		_categoryEntryLocalService = categoryEntryLocalService;
	}

	@Override
	public void addAccountEntryCategoryEntries(
		long accountId,
		java.util.List<com.dogoo.poc.account.model.CategoryEntry>
			categoryEntries) {

		_categoryEntryLocalService.addAccountEntryCategoryEntries(
			accountId, categoryEntries);
	}

	@Override
	public void addAccountEntryCategoryEntries(
		long accountId, long[] categoryIds) {

		_categoryEntryLocalService.addAccountEntryCategoryEntries(
			accountId, categoryIds);
	}

	@Override
	public void addAccountEntryCategoryEntry(
		long accountId,
		com.dogoo.poc.account.model.CategoryEntry categoryEntry) {

		_categoryEntryLocalService.addAccountEntryCategoryEntry(
			accountId, categoryEntry);
	}

	@Override
	public void addAccountEntryCategoryEntry(long accountId, long categoryId) {
		_categoryEntryLocalService.addAccountEntryCategoryEntry(
			accountId, categoryId);
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
	@Override
	public com.dogoo.poc.account.model.CategoryEntry addCategoryEntry(
		com.dogoo.poc.account.model.CategoryEntry categoryEntry) {

		return _categoryEntryLocalService.addCategoryEntry(categoryEntry);
	}

	@Override
	public void clearAccountEntryCategoryEntries(long accountId) {
		_categoryEntryLocalService.clearAccountEntryCategoryEntries(accountId);
	}

	/**
	 * Creates a new category entry with the primary key. Does not add the category entry to the database.
	 *
	 * @param categoryId the primary key for the new category entry
	 * @return the new category entry
	 */
	@Override
	public com.dogoo.poc.account.model.CategoryEntry createCategoryEntry(
		long categoryId) {

		return _categoryEntryLocalService.createCategoryEntry(categoryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _categoryEntryLocalService.createPersistedModel(primaryKeyObj);
	}

	@Override
	public void deleteAccountEntryCategoryEntries(
		long accountId,
		java.util.List<com.dogoo.poc.account.model.CategoryEntry>
			categoryEntries) {

		_categoryEntryLocalService.deleteAccountEntryCategoryEntries(
			accountId, categoryEntries);
	}

	@Override
	public void deleteAccountEntryCategoryEntries(
		long accountId, long[] categoryIds) {

		_categoryEntryLocalService.deleteAccountEntryCategoryEntries(
			accountId, categoryIds);
	}

	@Override
	public void deleteAccountEntryCategoryEntry(
		long accountId,
		com.dogoo.poc.account.model.CategoryEntry categoryEntry) {

		_categoryEntryLocalService.deleteAccountEntryCategoryEntry(
			accountId, categoryEntry);
	}

	@Override
	public void deleteAccountEntryCategoryEntry(
		long accountId, long categoryId) {

		_categoryEntryLocalService.deleteAccountEntryCategoryEntry(
			accountId, categoryId);
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
	@Override
	public com.dogoo.poc.account.model.CategoryEntry deleteCategoryEntry(
		com.dogoo.poc.account.model.CategoryEntry categoryEntry) {

		return _categoryEntryLocalService.deleteCategoryEntry(categoryEntry);
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
	@Override
	public com.dogoo.poc.account.model.CategoryEntry deleteCategoryEntry(
			long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _categoryEntryLocalService.deleteCategoryEntry(categoryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _categoryEntryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _categoryEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _categoryEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _categoryEntryLocalService.dynamicQuery();
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

		return _categoryEntryLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _categoryEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _categoryEntryLocalService.dynamicQuery(
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

		return _categoryEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _categoryEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.dogoo.poc.account.model.CategoryEntry fetchCategoryEntry(
		long categoryId) {

		return _categoryEntryLocalService.fetchCategoryEntry(categoryId);
	}

	/**
	 * Returns the category entry matching the UUID and group.
	 *
	 * @param uuid the category entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching category entry, or <code>null</code> if a matching category entry could not be found
	 */
	@Override
	public com.dogoo.poc.account.model.CategoryEntry
		fetchCategoryEntryByUuidAndGroupId(String uuid, long groupId) {

		return _categoryEntryLocalService.fetchCategoryEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public java.util.List<com.dogoo.poc.account.model.CategoryEntry>
		getAccountEntryCategoryEntries(long accountId) {

		return _categoryEntryLocalService.getAccountEntryCategoryEntries(
			accountId);
	}

	@Override
	public java.util.List<com.dogoo.poc.account.model.CategoryEntry>
		getAccountEntryCategoryEntries(long accountId, int start, int end) {

		return _categoryEntryLocalService.getAccountEntryCategoryEntries(
			accountId, start, end);
	}

	@Override
	public java.util.List<com.dogoo.poc.account.model.CategoryEntry>
		getAccountEntryCategoryEntries(
			long accountId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.dogoo.poc.account.model.CategoryEntry> orderByComparator) {

		return _categoryEntryLocalService.getAccountEntryCategoryEntries(
			accountId, start, end, orderByComparator);
	}

	@Override
	public int getAccountEntryCategoryEntriesCount(long accountId) {
		return _categoryEntryLocalService.getAccountEntryCategoryEntriesCount(
			accountId);
	}

	/**
	 * Returns the accountIds of the account entries associated with the category entry.
	 *
	 * @param categoryId the categoryId of the category entry
	 * @return long[] the accountIds of account entries associated with the category entry
	 */
	@Override
	public long[] getAccountEntryPrimaryKeys(long categoryId) {
		return _categoryEntryLocalService.getAccountEntryPrimaryKeys(
			categoryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _categoryEntryLocalService.getActionableDynamicQuery();
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
	@Override
	public java.util.List<com.dogoo.poc.account.model.CategoryEntry>
		getCategoryEntries(int start, int end) {

		return _categoryEntryLocalService.getCategoryEntries(start, end);
	}

	/**
	 * Returns all the category entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the category entries
	 * @param companyId the primary key of the company
	 * @return the matching category entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.dogoo.poc.account.model.CategoryEntry>
		getCategoryEntriesByUuidAndCompanyId(String uuid, long companyId) {

		return _categoryEntryLocalService.getCategoryEntriesByUuidAndCompanyId(
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
	@Override
	public java.util.List<com.dogoo.poc.account.model.CategoryEntry>
		getCategoryEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.dogoo.poc.account.model.CategoryEntry> orderByComparator) {

		return _categoryEntryLocalService.getCategoryEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of category entries.
	 *
	 * @return the number of category entries
	 */
	@Override
	public int getCategoryEntriesCount() {
		return _categoryEntryLocalService.getCategoryEntriesCount();
	}

	/**
	 * Returns the category entry with the primary key.
	 *
	 * @param categoryId the primary key of the category entry
	 * @return the category entry
	 * @throws PortalException if a category entry with the primary key could not be found
	 */
	@Override
	public com.dogoo.poc.account.model.CategoryEntry getCategoryEntry(
			long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _categoryEntryLocalService.getCategoryEntry(categoryId);
	}

	/**
	 * Returns the category entry matching the UUID and group.
	 *
	 * @param uuid the category entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching category entry
	 * @throws PortalException if a matching category entry could not be found
	 */
	@Override
	public com.dogoo.poc.account.model.CategoryEntry
			getCategoryEntryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _categoryEntryLocalService.getCategoryEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _categoryEntryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _categoryEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _categoryEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _categoryEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public boolean hasAccountEntryCategoryEntries(long accountId) {
		return _categoryEntryLocalService.hasAccountEntryCategoryEntries(
			accountId);
	}

	@Override
	public boolean hasAccountEntryCategoryEntry(
		long accountId, long categoryId) {

		return _categoryEntryLocalService.hasAccountEntryCategoryEntry(
			accountId, categoryId);
	}

	@Override
	public void setAccountEntryCategoryEntries(
		long accountId, long[] categoryIds) {

		_categoryEntryLocalService.setAccountEntryCategoryEntries(
			accountId, categoryIds);
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
	@Override
	public com.dogoo.poc.account.model.CategoryEntry updateCategoryEntry(
		com.dogoo.poc.account.model.CategoryEntry categoryEntry) {

		return _categoryEntryLocalService.updateCategoryEntry(categoryEntry);
	}

	@Override
	public CategoryEntryLocalService getWrappedService() {
		return _categoryEntryLocalService;
	}

	@Override
	public void setWrappedService(
		CategoryEntryLocalService categoryEntryLocalService) {

		_categoryEntryLocalService = categoryEntryLocalService;
	}

	private CategoryEntryLocalService _categoryEntryLocalService;

}