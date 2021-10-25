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

package com.dogoo.poc.account.service.persistence;

import com.dogoo.poc.account.model.CategoryEntry;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the category entry service. This utility wraps <code>com.dogoo.poc.account.service.persistence.impl.CategoryEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CategoryEntryPersistence
 * @generated
 */
public class CategoryEntryUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(CategoryEntry categoryEntry) {
		getPersistence().clearCache(categoryEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, CategoryEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CategoryEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CategoryEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CategoryEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CategoryEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CategoryEntry update(CategoryEntry categoryEntry) {
		return getPersistence().update(categoryEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CategoryEntry update(
		CategoryEntry categoryEntry, ServiceContext serviceContext) {

		return getPersistence().update(categoryEntry, serviceContext);
	}

	/**
	 * Returns all the category entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching category entries
	 */
	public static List<CategoryEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the category entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of category entries
	 * @param end the upper bound of the range of category entries (not inclusive)
	 * @return the range of matching category entries
	 */
	public static List<CategoryEntry> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the category entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of category entries
	 * @param end the upper bound of the range of category entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching category entries
	 */
	public static List<CategoryEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CategoryEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the category entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of category entries
	 * @param end the upper bound of the range of category entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching category entries
	 */
	public static List<CategoryEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CategoryEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first category entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category entry
	 * @throws NoSuchCategoryEntryException if a matching category entry could not be found
	 */
	public static CategoryEntry findByUuid_First(
			String uuid, OrderByComparator<CategoryEntry> orderByComparator)
		throws com.dogoo.poc.account.exception.NoSuchCategoryEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first category entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category entry, or <code>null</code> if a matching category entry could not be found
	 */
	public static CategoryEntry fetchByUuid_First(
		String uuid, OrderByComparator<CategoryEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last category entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category entry
	 * @throws NoSuchCategoryEntryException if a matching category entry could not be found
	 */
	public static CategoryEntry findByUuid_Last(
			String uuid, OrderByComparator<CategoryEntry> orderByComparator)
		throws com.dogoo.poc.account.exception.NoSuchCategoryEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last category entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category entry, or <code>null</code> if a matching category entry could not be found
	 */
	public static CategoryEntry fetchByUuid_Last(
		String uuid, OrderByComparator<CategoryEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the category entries before and after the current category entry in the ordered set where uuid = &#63;.
	 *
	 * @param categoryId the primary key of the current category entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category entry
	 * @throws NoSuchCategoryEntryException if a category entry with the primary key could not be found
	 */
	public static CategoryEntry[] findByUuid_PrevAndNext(
			long categoryId, String uuid,
			OrderByComparator<CategoryEntry> orderByComparator)
		throws com.dogoo.poc.account.exception.NoSuchCategoryEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			categoryId, uuid, orderByComparator);
	}

	/**
	 * Removes all the category entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of category entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching category entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the category entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCategoryEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching category entry
	 * @throws NoSuchCategoryEntryException if a matching category entry could not be found
	 */
	public static CategoryEntry findByUUID_G(String uuid, long groupId)
		throws com.dogoo.poc.account.exception.NoSuchCategoryEntryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the category entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching category entry, or <code>null</code> if a matching category entry could not be found
	 */
	public static CategoryEntry fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the category entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching category entry, or <code>null</code> if a matching category entry could not be found
	 */
	public static CategoryEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the category entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the category entry that was removed
	 */
	public static CategoryEntry removeByUUID_G(String uuid, long groupId)
		throws com.dogoo.poc.account.exception.NoSuchCategoryEntryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of category entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching category entries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the category entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching category entries
	 */
	public static List<CategoryEntry> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the category entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of category entries
	 * @param end the upper bound of the range of category entries (not inclusive)
	 * @return the range of matching category entries
	 */
	public static List<CategoryEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the category entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of category entries
	 * @param end the upper bound of the range of category entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching category entries
	 */
	public static List<CategoryEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CategoryEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the category entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of category entries
	 * @param end the upper bound of the range of category entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching category entries
	 */
	public static List<CategoryEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CategoryEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first category entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category entry
	 * @throws NoSuchCategoryEntryException if a matching category entry could not be found
	 */
	public static CategoryEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CategoryEntry> orderByComparator)
		throws com.dogoo.poc.account.exception.NoSuchCategoryEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first category entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category entry, or <code>null</code> if a matching category entry could not be found
	 */
	public static CategoryEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CategoryEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last category entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category entry
	 * @throws NoSuchCategoryEntryException if a matching category entry could not be found
	 */
	public static CategoryEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CategoryEntry> orderByComparator)
		throws com.dogoo.poc.account.exception.NoSuchCategoryEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last category entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category entry, or <code>null</code> if a matching category entry could not be found
	 */
	public static CategoryEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CategoryEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the category entries before and after the current category entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param categoryId the primary key of the current category entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category entry
	 * @throws NoSuchCategoryEntryException if a category entry with the primary key could not be found
	 */
	public static CategoryEntry[] findByUuid_C_PrevAndNext(
			long categoryId, String uuid, long companyId,
			OrderByComparator<CategoryEntry> orderByComparator)
		throws com.dogoo.poc.account.exception.NoSuchCategoryEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			categoryId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the category entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of category entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching category entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the category entries where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching category entries
	 */
	public static List<CategoryEntry> findBytype(String type) {
		return getPersistence().findBytype(type);
	}

	/**
	 * Returns a range of all the category entries where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryEntryModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of category entries
	 * @param end the upper bound of the range of category entries (not inclusive)
	 * @return the range of matching category entries
	 */
	public static List<CategoryEntry> findBytype(
		String type, int start, int end) {

		return getPersistence().findBytype(type, start, end);
	}

	/**
	 * Returns an ordered range of all the category entries where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryEntryModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of category entries
	 * @param end the upper bound of the range of category entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching category entries
	 */
	public static List<CategoryEntry> findBytype(
		String type, int start, int end,
		OrderByComparator<CategoryEntry> orderByComparator) {

		return getPersistence().findBytype(type, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the category entries where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryEntryModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of category entries
	 * @param end the upper bound of the range of category entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching category entries
	 */
	public static List<CategoryEntry> findBytype(
		String type, int start, int end,
		OrderByComparator<CategoryEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBytype(
			type, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first category entry in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category entry
	 * @throws NoSuchCategoryEntryException if a matching category entry could not be found
	 */
	public static CategoryEntry findBytype_First(
			String type, OrderByComparator<CategoryEntry> orderByComparator)
		throws com.dogoo.poc.account.exception.NoSuchCategoryEntryException {

		return getPersistence().findBytype_First(type, orderByComparator);
	}

	/**
	 * Returns the first category entry in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category entry, or <code>null</code> if a matching category entry could not be found
	 */
	public static CategoryEntry fetchBytype_First(
		String type, OrderByComparator<CategoryEntry> orderByComparator) {

		return getPersistence().fetchBytype_First(type, orderByComparator);
	}

	/**
	 * Returns the last category entry in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category entry
	 * @throws NoSuchCategoryEntryException if a matching category entry could not be found
	 */
	public static CategoryEntry findBytype_Last(
			String type, OrderByComparator<CategoryEntry> orderByComparator)
		throws com.dogoo.poc.account.exception.NoSuchCategoryEntryException {

		return getPersistence().findBytype_Last(type, orderByComparator);
	}

	/**
	 * Returns the last category entry in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category entry, or <code>null</code> if a matching category entry could not be found
	 */
	public static CategoryEntry fetchBytype_Last(
		String type, OrderByComparator<CategoryEntry> orderByComparator) {

		return getPersistence().fetchBytype_Last(type, orderByComparator);
	}

	/**
	 * Returns the category entries before and after the current category entry in the ordered set where type = &#63;.
	 *
	 * @param categoryId the primary key of the current category entry
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category entry
	 * @throws NoSuchCategoryEntryException if a category entry with the primary key could not be found
	 */
	public static CategoryEntry[] findBytype_PrevAndNext(
			long categoryId, String type,
			OrderByComparator<CategoryEntry> orderByComparator)
		throws com.dogoo.poc.account.exception.NoSuchCategoryEntryException {

		return getPersistence().findBytype_PrevAndNext(
			categoryId, type, orderByComparator);
	}

	/**
	 * Removes all the category entries where type = &#63; from the database.
	 *
	 * @param type the type
	 */
	public static void removeBytype(String type) {
		getPersistence().removeBytype(type);
	}

	/**
	 * Returns the number of category entries where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching category entries
	 */
	public static int countBytype(String type) {
		return getPersistence().countBytype(type);
	}

	/**
	 * Returns all the category entries where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching category entries
	 */
	public static List<CategoryEntry> findBycode(int code) {
		return getPersistence().findBycode(code);
	}

	/**
	 * Returns a range of all the category entries where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryEntryModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of category entries
	 * @param end the upper bound of the range of category entries (not inclusive)
	 * @return the range of matching category entries
	 */
	public static List<CategoryEntry> findBycode(int code, int start, int end) {
		return getPersistence().findBycode(code, start, end);
	}

	/**
	 * Returns an ordered range of all the category entries where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryEntryModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of category entries
	 * @param end the upper bound of the range of category entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching category entries
	 */
	public static List<CategoryEntry> findBycode(
		int code, int start, int end,
		OrderByComparator<CategoryEntry> orderByComparator) {

		return getPersistence().findBycode(code, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the category entries where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryEntryModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of category entries
	 * @param end the upper bound of the range of category entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching category entries
	 */
	public static List<CategoryEntry> findBycode(
		int code, int start, int end,
		OrderByComparator<CategoryEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBycode(
			code, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first category entry in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category entry
	 * @throws NoSuchCategoryEntryException if a matching category entry could not be found
	 */
	public static CategoryEntry findBycode_First(
			int code, OrderByComparator<CategoryEntry> orderByComparator)
		throws com.dogoo.poc.account.exception.NoSuchCategoryEntryException {

		return getPersistence().findBycode_First(code, orderByComparator);
	}

	/**
	 * Returns the first category entry in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category entry, or <code>null</code> if a matching category entry could not be found
	 */
	public static CategoryEntry fetchBycode_First(
		int code, OrderByComparator<CategoryEntry> orderByComparator) {

		return getPersistence().fetchBycode_First(code, orderByComparator);
	}

	/**
	 * Returns the last category entry in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category entry
	 * @throws NoSuchCategoryEntryException if a matching category entry could not be found
	 */
	public static CategoryEntry findBycode_Last(
			int code, OrderByComparator<CategoryEntry> orderByComparator)
		throws com.dogoo.poc.account.exception.NoSuchCategoryEntryException {

		return getPersistence().findBycode_Last(code, orderByComparator);
	}

	/**
	 * Returns the last category entry in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category entry, or <code>null</code> if a matching category entry could not be found
	 */
	public static CategoryEntry fetchBycode_Last(
		int code, OrderByComparator<CategoryEntry> orderByComparator) {

		return getPersistence().fetchBycode_Last(code, orderByComparator);
	}

	/**
	 * Returns the category entries before and after the current category entry in the ordered set where code = &#63;.
	 *
	 * @param categoryId the primary key of the current category entry
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category entry
	 * @throws NoSuchCategoryEntryException if a category entry with the primary key could not be found
	 */
	public static CategoryEntry[] findBycode_PrevAndNext(
			long categoryId, int code,
			OrderByComparator<CategoryEntry> orderByComparator)
		throws com.dogoo.poc.account.exception.NoSuchCategoryEntryException {

		return getPersistence().findBycode_PrevAndNext(
			categoryId, code, orderByComparator);
	}

	/**
	 * Removes all the category entries where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public static void removeBycode(int code) {
		getPersistence().removeBycode(code);
	}

	/**
	 * Returns the number of category entries where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching category entries
	 */
	public static int countBycode(int code) {
		return getPersistence().countBycode(code);
	}

	/**
	 * Returns the category entry where code = &#63; and type = &#63; or throws a <code>NoSuchCategoryEntryException</code> if it could not be found.
	 *
	 * @param code the code
	 * @param type the type
	 * @return the matching category entry
	 * @throws NoSuchCategoryEntryException if a matching category entry could not be found
	 */
	public static CategoryEntry findByCodeAndType(int code, String type)
		throws com.dogoo.poc.account.exception.NoSuchCategoryEntryException {

		return getPersistence().findByCodeAndType(code, type);
	}

	/**
	 * Returns the category entry where code = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @param type the type
	 * @return the matching category entry, or <code>null</code> if a matching category entry could not be found
	 */
	public static CategoryEntry fetchByCodeAndType(int code, String type) {
		return getPersistence().fetchByCodeAndType(code, type);
	}

	/**
	 * Returns the category entry where code = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param type the type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching category entry, or <code>null</code> if a matching category entry could not be found
	 */
	public static CategoryEntry fetchByCodeAndType(
		int code, String type, boolean useFinderCache) {

		return getPersistence().fetchByCodeAndType(code, type, useFinderCache);
	}

	/**
	 * Removes the category entry where code = &#63; and type = &#63; from the database.
	 *
	 * @param code the code
	 * @param type the type
	 * @return the category entry that was removed
	 */
	public static CategoryEntry removeByCodeAndType(int code, String type)
		throws com.dogoo.poc.account.exception.NoSuchCategoryEntryException {

		return getPersistence().removeByCodeAndType(code, type);
	}

	/**
	 * Returns the number of category entries where code = &#63; and type = &#63;.
	 *
	 * @param code the code
	 * @param type the type
	 * @return the number of matching category entries
	 */
	public static int countByCodeAndType(int code, String type) {
		return getPersistence().countByCodeAndType(code, type);
	}

	/**
	 * Caches the category entry in the entity cache if it is enabled.
	 *
	 * @param categoryEntry the category entry
	 */
	public static void cacheResult(CategoryEntry categoryEntry) {
		getPersistence().cacheResult(categoryEntry);
	}

	/**
	 * Caches the category entries in the entity cache if it is enabled.
	 *
	 * @param categoryEntries the category entries
	 */
	public static void cacheResult(List<CategoryEntry> categoryEntries) {
		getPersistence().cacheResult(categoryEntries);
	}

	/**
	 * Creates a new category entry with the primary key. Does not add the category entry to the database.
	 *
	 * @param categoryId the primary key for the new category entry
	 * @return the new category entry
	 */
	public static CategoryEntry create(long categoryId) {
		return getPersistence().create(categoryId);
	}

	/**
	 * Removes the category entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the category entry
	 * @return the category entry that was removed
	 * @throws NoSuchCategoryEntryException if a category entry with the primary key could not be found
	 */
	public static CategoryEntry remove(long categoryId)
		throws com.dogoo.poc.account.exception.NoSuchCategoryEntryException {

		return getPersistence().remove(categoryId);
	}

	public static CategoryEntry updateImpl(CategoryEntry categoryEntry) {
		return getPersistence().updateImpl(categoryEntry);
	}

	/**
	 * Returns the category entry with the primary key or throws a <code>NoSuchCategoryEntryException</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the category entry
	 * @return the category entry
	 * @throws NoSuchCategoryEntryException if a category entry with the primary key could not be found
	 */
	public static CategoryEntry findByPrimaryKey(long categoryId)
		throws com.dogoo.poc.account.exception.NoSuchCategoryEntryException {

		return getPersistence().findByPrimaryKey(categoryId);
	}

	/**
	 * Returns the category entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the category entry
	 * @return the category entry, or <code>null</code> if a category entry with the primary key could not be found
	 */
	public static CategoryEntry fetchByPrimaryKey(long categoryId) {
		return getPersistence().fetchByPrimaryKey(categoryId);
	}

	/**
	 * Returns all the category entries.
	 *
	 * @return the category entries
	 */
	public static List<CategoryEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the category entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of category entries
	 * @param end the upper bound of the range of category entries (not inclusive)
	 * @return the range of category entries
	 */
	public static List<CategoryEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the category entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of category entries
	 * @param end the upper bound of the range of category entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of category entries
	 */
	public static List<CategoryEntry> findAll(
		int start, int end,
		OrderByComparator<CategoryEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the category entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of category entries
	 * @param end the upper bound of the range of category entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of category entries
	 */
	public static List<CategoryEntry> findAll(
		int start, int end, OrderByComparator<CategoryEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the category entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of category entries.
	 *
	 * @return the number of category entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	 * Returns the primaryKeys of account entries associated with the category entry.
	 *
	 * @param pk the primary key of the category entry
	 * @return long[] of the primaryKeys of account entries associated with the category entry
	 */
	public static long[] getAccountEntryPrimaryKeys(long pk) {
		return getPersistence().getAccountEntryPrimaryKeys(pk);
	}

	/**
	 * Returns all the category entry associated with the account entry.
	 *
	 * @param pk the primary key of the account entry
	 * @return the category entries associated with the account entry
	 */
	public static List<CategoryEntry> getAccountEntryCategoryEntries(long pk) {
		return getPersistence().getAccountEntryCategoryEntries(pk);
	}

	/**
	 * Returns all the category entry associated with the account entry.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryEntryModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the account entry
	 * @param start the lower bound of the range of account entries
	 * @param end the upper bound of the range of account entries (not inclusive)
	 * @return the range of category entries associated with the account entry
	 */
	public static List<CategoryEntry> getAccountEntryCategoryEntries(
		long pk, int start, int end) {

		return getPersistence().getAccountEntryCategoryEntries(pk, start, end);
	}

	/**
	 * Returns all the category entry associated with the account entry.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryEntryModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the account entry
	 * @param start the lower bound of the range of account entries
	 * @param end the upper bound of the range of account entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of category entries associated with the account entry
	 */
	public static List<CategoryEntry> getAccountEntryCategoryEntries(
		long pk, int start, int end,
		OrderByComparator<CategoryEntry> orderByComparator) {

		return getPersistence().getAccountEntryCategoryEntries(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of account entries associated with the category entry.
	 *
	 * @param pk the primary key of the category entry
	 * @return the number of account entries associated with the category entry
	 */
	public static int getAccountEntriesSize(long pk) {
		return getPersistence().getAccountEntriesSize(pk);
	}

	/**
	 * Returns <code>true</code> if the account entry is associated with the category entry.
	 *
	 * @param pk the primary key of the category entry
	 * @param accountEntryPK the primary key of the account entry
	 * @return <code>true</code> if the account entry is associated with the category entry; <code>false</code> otherwise
	 */
	public static boolean containsAccountEntry(long pk, long accountEntryPK) {
		return getPersistence().containsAccountEntry(pk, accountEntryPK);
	}

	/**
	 * Returns <code>true</code> if the category entry has any account entries associated with it.
	 *
	 * @param pk the primary key of the category entry to check for associations with account entries
	 * @return <code>true</code> if the category entry has any account entries associated with it; <code>false</code> otherwise
	 */
	public static boolean containsAccountEntries(long pk) {
		return getPersistence().containsAccountEntries(pk);
	}

	/**
	 * Adds an association between the category entry and the account entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the category entry
	 * @param accountEntryPK the primary key of the account entry
	 */
	public static void addAccountEntry(long pk, long accountEntryPK) {
		getPersistence().addAccountEntry(pk, accountEntryPK);
	}

	/**
	 * Adds an association between the category entry and the account entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the category entry
	 * @param accountEntry the account entry
	 */
	public static void addAccountEntry(
		long pk, com.dogoo.poc.account.model.AccountEntry accountEntry) {

		getPersistence().addAccountEntry(pk, accountEntry);
	}

	/**
	 * Adds an association between the category entry and the account entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the category entry
	 * @param accountEntryPKs the primary keys of the account entries
	 */
	public static void addAccountEntries(long pk, long[] accountEntryPKs) {
		getPersistence().addAccountEntries(pk, accountEntryPKs);
	}

	/**
	 * Adds an association between the category entry and the account entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the category entry
	 * @param accountEntries the account entries
	 */
	public static void addAccountEntries(
		long pk,
		List<com.dogoo.poc.account.model.AccountEntry> accountEntries) {

		getPersistence().addAccountEntries(pk, accountEntries);
	}

	/**
	 * Clears all associations between the category entry and its account entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the category entry to clear the associated account entries from
	 */
	public static void clearAccountEntries(long pk) {
		getPersistence().clearAccountEntries(pk);
	}

	/**
	 * Removes the association between the category entry and the account entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the category entry
	 * @param accountEntryPK the primary key of the account entry
	 */
	public static void removeAccountEntry(long pk, long accountEntryPK) {
		getPersistence().removeAccountEntry(pk, accountEntryPK);
	}

	/**
	 * Removes the association between the category entry and the account entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the category entry
	 * @param accountEntry the account entry
	 */
	public static void removeAccountEntry(
		long pk, com.dogoo.poc.account.model.AccountEntry accountEntry) {

		getPersistence().removeAccountEntry(pk, accountEntry);
	}

	/**
	 * Removes the association between the category entry and the account entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the category entry
	 * @param accountEntryPKs the primary keys of the account entries
	 */
	public static void removeAccountEntries(long pk, long[] accountEntryPKs) {
		getPersistence().removeAccountEntries(pk, accountEntryPKs);
	}

	/**
	 * Removes the association between the category entry and the account entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the category entry
	 * @param accountEntries the account entries
	 */
	public static void removeAccountEntries(
		long pk,
		List<com.dogoo.poc.account.model.AccountEntry> accountEntries) {

		getPersistence().removeAccountEntries(pk, accountEntries);
	}

	/**
	 * Sets the account entries associated with the category entry, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the category entry
	 * @param accountEntryPKs the primary keys of the account entries to be associated with the category entry
	 */
	public static void setAccountEntries(long pk, long[] accountEntryPKs) {
		getPersistence().setAccountEntries(pk, accountEntryPKs);
	}

	/**
	 * Sets the account entries associated with the category entry, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the category entry
	 * @param accountEntries the account entries to be associated with the category entry
	 */
	public static void setAccountEntries(
		long pk,
		List<com.dogoo.poc.account.model.AccountEntry> accountEntries) {

		getPersistence().setAccountEntries(pk, accountEntries);
	}

	public static CategoryEntryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CategoryEntryPersistence, CategoryEntryPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CategoryEntryPersistence.class);

		ServiceTracker<CategoryEntryPersistence, CategoryEntryPersistence>
			serviceTracker =
				new ServiceTracker
					<CategoryEntryPersistence, CategoryEntryPersistence>(
						bundle.getBundleContext(),
						CategoryEntryPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}