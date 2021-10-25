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

package com.dogoo.poc.pet.service.persistence;

import com.dogoo.poc.pet.model.CatEntry;

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
 * The persistence utility for the cat entry service. This utility wraps <code>com.dogoo.poc.pet.service.persistence.impl.CatEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CatEntryPersistence
 * @generated
 */
public class CatEntryUtil {

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
	public static void clearCache(CatEntry catEntry) {
		getPersistence().clearCache(catEntry);
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
	public static Map<Serializable, CatEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CatEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CatEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CatEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CatEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CatEntry update(CatEntry catEntry) {
		return getPersistence().update(catEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CatEntry update(
		CatEntry catEntry, ServiceContext serviceContext) {

		return getPersistence().update(catEntry, serviceContext);
	}

	/**
	 * Returns all the cat entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cat entries
	 */
	public static List<CatEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the cat entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cat entries
	 * @param end the upper bound of the range of cat entries (not inclusive)
	 * @return the range of matching cat entries
	 */
	public static List<CatEntry> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the cat entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cat entries
	 * @param end the upper bound of the range of cat entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cat entries
	 */
	public static List<CatEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CatEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cat entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cat entries
	 * @param end the upper bound of the range of cat entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cat entries
	 */
	public static List<CatEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CatEntry> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cat entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cat entry
	 * @throws NoSuchCatEntryException if a matching cat entry could not be found
	 */
	public static CatEntry findByUuid_First(
			String uuid, OrderByComparator<CatEntry> orderByComparator)
		throws com.dogoo.poc.pet.exception.NoSuchCatEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first cat entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cat entry, or <code>null</code> if a matching cat entry could not be found
	 */
	public static CatEntry fetchByUuid_First(
		String uuid, OrderByComparator<CatEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last cat entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cat entry
	 * @throws NoSuchCatEntryException if a matching cat entry could not be found
	 */
	public static CatEntry findByUuid_Last(
			String uuid, OrderByComparator<CatEntry> orderByComparator)
		throws com.dogoo.poc.pet.exception.NoSuchCatEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last cat entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cat entry, or <code>null</code> if a matching cat entry could not be found
	 */
	public static CatEntry fetchByUuid_Last(
		String uuid, OrderByComparator<CatEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the cat entries before and after the current cat entry in the ordered set where uuid = &#63;.
	 *
	 * @param petId the primary key of the current cat entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cat entry
	 * @throws NoSuchCatEntryException if a cat entry with the primary key could not be found
	 */
	public static CatEntry[] findByUuid_PrevAndNext(
			long petId, String uuid,
			OrderByComparator<CatEntry> orderByComparator)
		throws com.dogoo.poc.pet.exception.NoSuchCatEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			petId, uuid, orderByComparator);
	}

	/**
	 * Removes all the cat entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of cat entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cat entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the cat entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCatEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching cat entry
	 * @throws NoSuchCatEntryException if a matching cat entry could not be found
	 */
	public static CatEntry findByUUID_G(String uuid, long groupId)
		throws com.dogoo.poc.pet.exception.NoSuchCatEntryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the cat entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching cat entry, or <code>null</code> if a matching cat entry could not be found
	 */
	public static CatEntry fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the cat entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cat entry, or <code>null</code> if a matching cat entry could not be found
	 */
	public static CatEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the cat entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the cat entry that was removed
	 */
	public static CatEntry removeByUUID_G(String uuid, long groupId)
		throws com.dogoo.poc.pet.exception.NoSuchCatEntryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of cat entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching cat entries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the cat entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching cat entries
	 */
	public static List<CatEntry> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the cat entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of cat entries
	 * @param end the upper bound of the range of cat entries (not inclusive)
	 * @return the range of matching cat entries
	 */
	public static List<CatEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the cat entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of cat entries
	 * @param end the upper bound of the range of cat entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cat entries
	 */
	public static List<CatEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CatEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cat entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of cat entries
	 * @param end the upper bound of the range of cat entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cat entries
	 */
	public static List<CatEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CatEntry> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cat entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cat entry
	 * @throws NoSuchCatEntryException if a matching cat entry could not be found
	 */
	public static CatEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CatEntry> orderByComparator)
		throws com.dogoo.poc.pet.exception.NoSuchCatEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first cat entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cat entry, or <code>null</code> if a matching cat entry could not be found
	 */
	public static CatEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CatEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last cat entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cat entry
	 * @throws NoSuchCatEntryException if a matching cat entry could not be found
	 */
	public static CatEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CatEntry> orderByComparator)
		throws com.dogoo.poc.pet.exception.NoSuchCatEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last cat entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cat entry, or <code>null</code> if a matching cat entry could not be found
	 */
	public static CatEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CatEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the cat entries before and after the current cat entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param petId the primary key of the current cat entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cat entry
	 * @throws NoSuchCatEntryException if a cat entry with the primary key could not be found
	 */
	public static CatEntry[] findByUuid_C_PrevAndNext(
			long petId, String uuid, long companyId,
			OrderByComparator<CatEntry> orderByComparator)
		throws com.dogoo.poc.pet.exception.NoSuchCatEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			petId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the cat entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of cat entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching cat entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the cat entries where tag = &#63;.
	 *
	 * @param tag the tag
	 * @return the matching cat entries
	 */
	public static List<CatEntry> findByT_S(String tag) {
		return getPersistence().findByT_S(tag);
	}

	/**
	 * Returns a range of all the cat entries where tag = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tag the tag
	 * @param start the lower bound of the range of cat entries
	 * @param end the upper bound of the range of cat entries (not inclusive)
	 * @return the range of matching cat entries
	 */
	public static List<CatEntry> findByT_S(String tag, int start, int end) {
		return getPersistence().findByT_S(tag, start, end);
	}

	/**
	 * Returns an ordered range of all the cat entries where tag = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tag the tag
	 * @param start the lower bound of the range of cat entries
	 * @param end the upper bound of the range of cat entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cat entries
	 */
	public static List<CatEntry> findByT_S(
		String tag, int start, int end,
		OrderByComparator<CatEntry> orderByComparator) {

		return getPersistence().findByT_S(tag, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cat entries where tag = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tag the tag
	 * @param start the lower bound of the range of cat entries
	 * @param end the upper bound of the range of cat entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cat entries
	 */
	public static List<CatEntry> findByT_S(
		String tag, int start, int end,
		OrderByComparator<CatEntry> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByT_S(
			tag, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cat entry in the ordered set where tag = &#63;.
	 *
	 * @param tag the tag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cat entry
	 * @throws NoSuchCatEntryException if a matching cat entry could not be found
	 */
	public static CatEntry findByT_S_First(
			String tag, OrderByComparator<CatEntry> orderByComparator)
		throws com.dogoo.poc.pet.exception.NoSuchCatEntryException {

		return getPersistence().findByT_S_First(tag, orderByComparator);
	}

	/**
	 * Returns the first cat entry in the ordered set where tag = &#63;.
	 *
	 * @param tag the tag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cat entry, or <code>null</code> if a matching cat entry could not be found
	 */
	public static CatEntry fetchByT_S_First(
		String tag, OrderByComparator<CatEntry> orderByComparator) {

		return getPersistence().fetchByT_S_First(tag, orderByComparator);
	}

	/**
	 * Returns the last cat entry in the ordered set where tag = &#63;.
	 *
	 * @param tag the tag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cat entry
	 * @throws NoSuchCatEntryException if a matching cat entry could not be found
	 */
	public static CatEntry findByT_S_Last(
			String tag, OrderByComparator<CatEntry> orderByComparator)
		throws com.dogoo.poc.pet.exception.NoSuchCatEntryException {

		return getPersistence().findByT_S_Last(tag, orderByComparator);
	}

	/**
	 * Returns the last cat entry in the ordered set where tag = &#63;.
	 *
	 * @param tag the tag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cat entry, or <code>null</code> if a matching cat entry could not be found
	 */
	public static CatEntry fetchByT_S_Last(
		String tag, OrderByComparator<CatEntry> orderByComparator) {

		return getPersistence().fetchByT_S_Last(tag, orderByComparator);
	}

	/**
	 * Returns the cat entries before and after the current cat entry in the ordered set where tag = &#63;.
	 *
	 * @param petId the primary key of the current cat entry
	 * @param tag the tag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cat entry
	 * @throws NoSuchCatEntryException if a cat entry with the primary key could not be found
	 */
	public static CatEntry[] findByT_S_PrevAndNext(
			long petId, String tag,
			OrderByComparator<CatEntry> orderByComparator)
		throws com.dogoo.poc.pet.exception.NoSuchCatEntryException {

		return getPersistence().findByT_S_PrevAndNext(
			petId, tag, orderByComparator);
	}

	/**
	 * Removes all the cat entries where tag = &#63; from the database.
	 *
	 * @param tag the tag
	 */
	public static void removeByT_S(String tag) {
		getPersistence().removeByT_S(tag);
	}

	/**
	 * Returns the number of cat entries where tag = &#63;.
	 *
	 * @param tag the tag
	 * @return the number of matching cat entries
	 */
	public static int countByT_S(String tag) {
		return getPersistence().countByT_S(tag);
	}

	/**
	 * Caches the cat entry in the entity cache if it is enabled.
	 *
	 * @param catEntry the cat entry
	 */
	public static void cacheResult(CatEntry catEntry) {
		getPersistence().cacheResult(catEntry);
	}

	/**
	 * Caches the cat entries in the entity cache if it is enabled.
	 *
	 * @param catEntries the cat entries
	 */
	public static void cacheResult(List<CatEntry> catEntries) {
		getPersistence().cacheResult(catEntries);
	}

	/**
	 * Creates a new cat entry with the primary key. Does not add the cat entry to the database.
	 *
	 * @param petId the primary key for the new cat entry
	 * @return the new cat entry
	 */
	public static CatEntry create(long petId) {
		return getPersistence().create(petId);
	}

	/**
	 * Removes the cat entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param petId the primary key of the cat entry
	 * @return the cat entry that was removed
	 * @throws NoSuchCatEntryException if a cat entry with the primary key could not be found
	 */
	public static CatEntry remove(long petId)
		throws com.dogoo.poc.pet.exception.NoSuchCatEntryException {

		return getPersistence().remove(petId);
	}

	public static CatEntry updateImpl(CatEntry catEntry) {
		return getPersistence().updateImpl(catEntry);
	}

	/**
	 * Returns the cat entry with the primary key or throws a <code>NoSuchCatEntryException</code> if it could not be found.
	 *
	 * @param petId the primary key of the cat entry
	 * @return the cat entry
	 * @throws NoSuchCatEntryException if a cat entry with the primary key could not be found
	 */
	public static CatEntry findByPrimaryKey(long petId)
		throws com.dogoo.poc.pet.exception.NoSuchCatEntryException {

		return getPersistence().findByPrimaryKey(petId);
	}

	/**
	 * Returns the cat entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param petId the primary key of the cat entry
	 * @return the cat entry, or <code>null</code> if a cat entry with the primary key could not be found
	 */
	public static CatEntry fetchByPrimaryKey(long petId) {
		return getPersistence().fetchByPrimaryKey(petId);
	}

	/**
	 * Returns all the cat entries.
	 *
	 * @return the cat entries
	 */
	public static List<CatEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the cat entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cat entries
	 * @param end the upper bound of the range of cat entries (not inclusive)
	 * @return the range of cat entries
	 */
	public static List<CatEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the cat entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cat entries
	 * @param end the upper bound of the range of cat entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cat entries
	 */
	public static List<CatEntry> findAll(
		int start, int end, OrderByComparator<CatEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cat entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CatEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cat entries
	 * @param end the upper bound of the range of cat entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cat entries
	 */
	public static List<CatEntry> findAll(
		int start, int end, OrderByComparator<CatEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the cat entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of cat entries.
	 *
	 * @return the number of cat entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CatEntryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CatEntryPersistence, CatEntryPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CatEntryPersistence.class);

		ServiceTracker<CatEntryPersistence, CatEntryPersistence>
			serviceTracker =
				new ServiceTracker<CatEntryPersistence, CatEntryPersistence>(
					bundle.getBundleContext(), CatEntryPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}