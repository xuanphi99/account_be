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

package com.dogoo.poc.pet.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CatEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CatEntryLocalService
 * @generated
 */
public class CatEntryLocalServiceWrapper
	implements CatEntryLocalService, ServiceWrapper<CatEntryLocalService> {

	public CatEntryLocalServiceWrapper(
		CatEntryLocalService catEntryLocalService) {

		_catEntryLocalService = catEntryLocalService;
	}

	/**
	 * Adds the cat entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CatEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param catEntry the cat entry
	 * @return the cat entry that was added
	 */
	@Override
	public com.dogoo.poc.pet.model.CatEntry addCatEntry(
		com.dogoo.poc.pet.model.CatEntry catEntry) {

		return _catEntryLocalService.addCatEntry(catEntry);
	}

	/**
	 * Creates a new cat entry with the primary key. Does not add the cat entry to the database.
	 *
	 * @param petId the primary key for the new cat entry
	 * @return the new cat entry
	 */
	@Override
	public com.dogoo.poc.pet.model.CatEntry createCatEntry(long petId) {
		return _catEntryLocalService.createCatEntry(petId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _catEntryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the cat entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CatEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param catEntry the cat entry
	 * @return the cat entry that was removed
	 */
	@Override
	public com.dogoo.poc.pet.model.CatEntry deleteCatEntry(
		com.dogoo.poc.pet.model.CatEntry catEntry) {

		return _catEntryLocalService.deleteCatEntry(catEntry);
	}

	/**
	 * Deletes the cat entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CatEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param petId the primary key of the cat entry
	 * @return the cat entry that was removed
	 * @throws PortalException if a cat entry with the primary key could not be found
	 */
	@Override
	public com.dogoo.poc.pet.model.CatEntry deleteCatEntry(long petId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _catEntryLocalService.deleteCatEntry(petId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _catEntryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _catEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _catEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _catEntryLocalService.dynamicQuery();
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

		return _catEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.poc.pet.model.impl.CatEntryModelImpl</code>.
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

		return _catEntryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.poc.pet.model.impl.CatEntryModelImpl</code>.
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

		return _catEntryLocalService.dynamicQuery(
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

		return _catEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _catEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.dogoo.poc.pet.model.CatEntry fetchCatEntry(long petId) {
		return _catEntryLocalService.fetchCatEntry(petId);
	}

	/**
	 * Returns the cat entry matching the UUID and group.
	 *
	 * @param uuid the cat entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching cat entry, or <code>null</code> if a matching cat entry could not be found
	 */
	@Override
	public com.dogoo.poc.pet.model.CatEntry fetchCatEntryByUuidAndGroupId(
		String uuid, long groupId) {

		return _catEntryLocalService.fetchCatEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _catEntryLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the cat entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.poc.pet.model.impl.CatEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cat entries
	 * @param end the upper bound of the range of cat entries (not inclusive)
	 * @return the range of cat entries
	 */
	@Override
	public java.util.List<com.dogoo.poc.pet.model.CatEntry> getCatEntries(
		int start, int end) {

		return _catEntryLocalService.getCatEntries(start, end);
	}

	/**
	 * Returns all the cat entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the cat entries
	 * @param companyId the primary key of the company
	 * @return the matching cat entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.dogoo.poc.pet.model.CatEntry>
		getCatEntriesByUuidAndCompanyId(String uuid, long companyId) {

		return _catEntryLocalService.getCatEntriesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of cat entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the cat entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of cat entries
	 * @param end the upper bound of the range of cat entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching cat entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.dogoo.poc.pet.model.CatEntry>
		getCatEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.dogoo.poc.pet.model.CatEntry> orderByComparator) {

		return _catEntryLocalService.getCatEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of cat entries.
	 *
	 * @return the number of cat entries
	 */
	@Override
	public int getCatEntriesCount() {
		return _catEntryLocalService.getCatEntriesCount();
	}

	/**
	 * Returns the cat entry with the primary key.
	 *
	 * @param petId the primary key of the cat entry
	 * @return the cat entry
	 * @throws PortalException if a cat entry with the primary key could not be found
	 */
	@Override
	public com.dogoo.poc.pet.model.CatEntry getCatEntry(long petId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _catEntryLocalService.getCatEntry(petId);
	}

	/**
	 * Returns the cat entry matching the UUID and group.
	 *
	 * @param uuid the cat entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching cat entry
	 * @throws PortalException if a matching cat entry could not be found
	 */
	@Override
	public com.dogoo.poc.pet.model.CatEntry getCatEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _catEntryLocalService.getCatEntryByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _catEntryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _catEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _catEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _catEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the cat entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CatEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param catEntry the cat entry
	 * @return the cat entry that was updated
	 */
	@Override
	public com.dogoo.poc.pet.model.CatEntry updateCatEntry(
		com.dogoo.poc.pet.model.CatEntry catEntry) {

		return _catEntryLocalService.updateCatEntry(catEntry);
	}

	@Override
	public CatEntryLocalService getWrappedService() {
		return _catEntryLocalService;
	}

	@Override
	public void setWrappedService(CatEntryLocalService catEntryLocalService) {
		_catEntryLocalService = catEntryLocalService;
	}

	private CatEntryLocalService _catEntryLocalService;

}