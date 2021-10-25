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

import com.dogoo.poc.account.model.AccountEntry;

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
 * The persistence utility for the account entry service. This utility wraps <code>com.dogoo.poc.account.service.persistence.impl.AccountEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AccountEntryPersistence
 * @generated
 */
public class AccountEntryUtil {

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
	public static void clearCache(AccountEntry accountEntry) {
		getPersistence().clearCache(accountEntry);
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
	public static Map<Serializable, AccountEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AccountEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AccountEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AccountEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AccountEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AccountEntry update(AccountEntry accountEntry) {
		return getPersistence().update(accountEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AccountEntry update(
		AccountEntry accountEntry, ServiceContext serviceContext) {

		return getPersistence().update(accountEntry, serviceContext);
	}

	/**
	 * Returns all the account entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching account entries
	 */
	public static List<AccountEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the account entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of account entries
	 * @param end the upper bound of the range of account entries (not inclusive)
	 * @return the range of matching account entries
	 */
	public static List<AccountEntry> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the account entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of account entries
	 * @param end the upper bound of the range of account entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching account entries
	 */
	public static List<AccountEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AccountEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the account entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of account entries
	 * @param end the upper bound of the range of account entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching account entries
	 */
	public static List<AccountEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AccountEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first account entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account entry
	 * @throws NoSuchAccountEntryException if a matching account entry could not be found
	 */
	public static AccountEntry findByUuid_First(
			String uuid, OrderByComparator<AccountEntry> orderByComparator)
		throws com.dogoo.poc.account.exception.NoSuchAccountEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first account entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account entry, or <code>null</code> if a matching account entry could not be found
	 */
	public static AccountEntry fetchByUuid_First(
		String uuid, OrderByComparator<AccountEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last account entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account entry
	 * @throws NoSuchAccountEntryException if a matching account entry could not be found
	 */
	public static AccountEntry findByUuid_Last(
			String uuid, OrderByComparator<AccountEntry> orderByComparator)
		throws com.dogoo.poc.account.exception.NoSuchAccountEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last account entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account entry, or <code>null</code> if a matching account entry could not be found
	 */
	public static AccountEntry fetchByUuid_Last(
		String uuid, OrderByComparator<AccountEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the account entries before and after the current account entry in the ordered set where uuid = &#63;.
	 *
	 * @param accountId the primary key of the current account entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account entry
	 * @throws NoSuchAccountEntryException if a account entry with the primary key could not be found
	 */
	public static AccountEntry[] findByUuid_PrevAndNext(
			long accountId, String uuid,
			OrderByComparator<AccountEntry> orderByComparator)
		throws com.dogoo.poc.account.exception.NoSuchAccountEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			accountId, uuid, orderByComparator);
	}

	/**
	 * Removes all the account entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of account entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching account entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the account entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAccountEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching account entry
	 * @throws NoSuchAccountEntryException if a matching account entry could not be found
	 */
	public static AccountEntry findByUUID_G(String uuid, long groupId)
		throws com.dogoo.poc.account.exception.NoSuchAccountEntryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the account entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching account entry, or <code>null</code> if a matching account entry could not be found
	 */
	public static AccountEntry fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the account entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching account entry, or <code>null</code> if a matching account entry could not be found
	 */
	public static AccountEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the account entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the account entry that was removed
	 */
	public static AccountEntry removeByUUID_G(String uuid, long groupId)
		throws com.dogoo.poc.account.exception.NoSuchAccountEntryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of account entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching account entries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the account entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching account entries
	 */
	public static List<AccountEntry> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the account entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of account entries
	 * @param end the upper bound of the range of account entries (not inclusive)
	 * @return the range of matching account entries
	 */
	public static List<AccountEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the account entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of account entries
	 * @param end the upper bound of the range of account entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching account entries
	 */
	public static List<AccountEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AccountEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the account entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of account entries
	 * @param end the upper bound of the range of account entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching account entries
	 */
	public static List<AccountEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AccountEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first account entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account entry
	 * @throws NoSuchAccountEntryException if a matching account entry could not be found
	 */
	public static AccountEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AccountEntry> orderByComparator)
		throws com.dogoo.poc.account.exception.NoSuchAccountEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first account entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account entry, or <code>null</code> if a matching account entry could not be found
	 */
	public static AccountEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AccountEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last account entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account entry
	 * @throws NoSuchAccountEntryException if a matching account entry could not be found
	 */
	public static AccountEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AccountEntry> orderByComparator)
		throws com.dogoo.poc.account.exception.NoSuchAccountEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last account entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account entry, or <code>null</code> if a matching account entry could not be found
	 */
	public static AccountEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AccountEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the account entries before and after the current account entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param accountId the primary key of the current account entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account entry
	 * @throws NoSuchAccountEntryException if a account entry with the primary key could not be found
	 */
	public static AccountEntry[] findByUuid_C_PrevAndNext(
			long accountId, String uuid, long companyId,
			OrderByComparator<AccountEntry> orderByComparator)
		throws com.dogoo.poc.account.exception.NoSuchAccountEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			accountId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the account entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of account entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching account entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the account entries where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @return the matching account entries
	 */
	public static List<AccountEntry> findByfullName(String fullName) {
		return getPersistence().findByfullName(fullName);
	}

	/**
	 * Returns a range of all the account entries where fullName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param fullName the full name
	 * @param start the lower bound of the range of account entries
	 * @param end the upper bound of the range of account entries (not inclusive)
	 * @return the range of matching account entries
	 */
	public static List<AccountEntry> findByfullName(
		String fullName, int start, int end) {

		return getPersistence().findByfullName(fullName, start, end);
	}

	/**
	 * Returns an ordered range of all the account entries where fullName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param fullName the full name
	 * @param start the lower bound of the range of account entries
	 * @param end the upper bound of the range of account entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching account entries
	 */
	public static List<AccountEntry> findByfullName(
		String fullName, int start, int end,
		OrderByComparator<AccountEntry> orderByComparator) {

		return getPersistence().findByfullName(
			fullName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the account entries where fullName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param fullName the full name
	 * @param start the lower bound of the range of account entries
	 * @param end the upper bound of the range of account entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching account entries
	 */
	public static List<AccountEntry> findByfullName(
		String fullName, int start, int end,
		OrderByComparator<AccountEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByfullName(
			fullName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first account entry in the ordered set where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account entry
	 * @throws NoSuchAccountEntryException if a matching account entry could not be found
	 */
	public static AccountEntry findByfullName_First(
			String fullName, OrderByComparator<AccountEntry> orderByComparator)
		throws com.dogoo.poc.account.exception.NoSuchAccountEntryException {

		return getPersistence().findByfullName_First(
			fullName, orderByComparator);
	}

	/**
	 * Returns the first account entry in the ordered set where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account entry, or <code>null</code> if a matching account entry could not be found
	 */
	public static AccountEntry fetchByfullName_First(
		String fullName, OrderByComparator<AccountEntry> orderByComparator) {

		return getPersistence().fetchByfullName_First(
			fullName, orderByComparator);
	}

	/**
	 * Returns the last account entry in the ordered set where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account entry
	 * @throws NoSuchAccountEntryException if a matching account entry could not be found
	 */
	public static AccountEntry findByfullName_Last(
			String fullName, OrderByComparator<AccountEntry> orderByComparator)
		throws com.dogoo.poc.account.exception.NoSuchAccountEntryException {

		return getPersistence().findByfullName_Last(
			fullName, orderByComparator);
	}

	/**
	 * Returns the last account entry in the ordered set where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account entry, or <code>null</code> if a matching account entry could not be found
	 */
	public static AccountEntry fetchByfullName_Last(
		String fullName, OrderByComparator<AccountEntry> orderByComparator) {

		return getPersistence().fetchByfullName_Last(
			fullName, orderByComparator);
	}

	/**
	 * Returns the account entries before and after the current account entry in the ordered set where fullName = &#63;.
	 *
	 * @param accountId the primary key of the current account entry
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account entry
	 * @throws NoSuchAccountEntryException if a account entry with the primary key could not be found
	 */
	public static AccountEntry[] findByfullName_PrevAndNext(
			long accountId, String fullName,
			OrderByComparator<AccountEntry> orderByComparator)
		throws com.dogoo.poc.account.exception.NoSuchAccountEntryException {

		return getPersistence().findByfullName_PrevAndNext(
			accountId, fullName, orderByComparator);
	}

	/**
	 * Removes all the account entries where fullName = &#63; from the database.
	 *
	 * @param fullName the full name
	 */
	public static void removeByfullName(String fullName) {
		getPersistence().removeByfullName(fullName);
	}

	/**
	 * Returns the number of account entries where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @return the number of matching account entries
	 */
	public static int countByfullName(String fullName) {
		return getPersistence().countByfullName(fullName);
	}

	/**
	 * Returns all the account entries where email = &#63;.
	 *
	 * @param email the email
	 * @return the matching account entries
	 */
	public static List<AccountEntry> findByemail(String email) {
		return getPersistence().findByemail(email);
	}

	/**
	 * Returns a range of all the account entries where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param email the email
	 * @param start the lower bound of the range of account entries
	 * @param end the upper bound of the range of account entries (not inclusive)
	 * @return the range of matching account entries
	 */
	public static List<AccountEntry> findByemail(
		String email, int start, int end) {

		return getPersistence().findByemail(email, start, end);
	}

	/**
	 * Returns an ordered range of all the account entries where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param email the email
	 * @param start the lower bound of the range of account entries
	 * @param end the upper bound of the range of account entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching account entries
	 */
	public static List<AccountEntry> findByemail(
		String email, int start, int end,
		OrderByComparator<AccountEntry> orderByComparator) {

		return getPersistence().findByemail(
			email, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the account entries where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param email the email
	 * @param start the lower bound of the range of account entries
	 * @param end the upper bound of the range of account entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching account entries
	 */
	public static List<AccountEntry> findByemail(
		String email, int start, int end,
		OrderByComparator<AccountEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByemail(
			email, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first account entry in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account entry
	 * @throws NoSuchAccountEntryException if a matching account entry could not be found
	 */
	public static AccountEntry findByemail_First(
			String email, OrderByComparator<AccountEntry> orderByComparator)
		throws com.dogoo.poc.account.exception.NoSuchAccountEntryException {

		return getPersistence().findByemail_First(email, orderByComparator);
	}

	/**
	 * Returns the first account entry in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account entry, or <code>null</code> if a matching account entry could not be found
	 */
	public static AccountEntry fetchByemail_First(
		String email, OrderByComparator<AccountEntry> orderByComparator) {

		return getPersistence().fetchByemail_First(email, orderByComparator);
	}

	/**
	 * Returns the last account entry in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account entry
	 * @throws NoSuchAccountEntryException if a matching account entry could not be found
	 */
	public static AccountEntry findByemail_Last(
			String email, OrderByComparator<AccountEntry> orderByComparator)
		throws com.dogoo.poc.account.exception.NoSuchAccountEntryException {

		return getPersistence().findByemail_Last(email, orderByComparator);
	}

	/**
	 * Returns the last account entry in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account entry, or <code>null</code> if a matching account entry could not be found
	 */
	public static AccountEntry fetchByemail_Last(
		String email, OrderByComparator<AccountEntry> orderByComparator) {

		return getPersistence().fetchByemail_Last(email, orderByComparator);
	}

	/**
	 * Returns the account entries before and after the current account entry in the ordered set where email = &#63;.
	 *
	 * @param accountId the primary key of the current account entry
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account entry
	 * @throws NoSuchAccountEntryException if a account entry with the primary key could not be found
	 */
	public static AccountEntry[] findByemail_PrevAndNext(
			long accountId, String email,
			OrderByComparator<AccountEntry> orderByComparator)
		throws com.dogoo.poc.account.exception.NoSuchAccountEntryException {

		return getPersistence().findByemail_PrevAndNext(
			accountId, email, orderByComparator);
	}

	/**
	 * Removes all the account entries where email = &#63; from the database.
	 *
	 * @param email the email
	 */
	public static void removeByemail(String email) {
		getPersistence().removeByemail(email);
	}

	/**
	 * Returns the number of account entries where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching account entries
	 */
	public static int countByemail(String email) {
		return getPersistence().countByemail(email);
	}

	/**
	 * Caches the account entry in the entity cache if it is enabled.
	 *
	 * @param accountEntry the account entry
	 */
	public static void cacheResult(AccountEntry accountEntry) {
		getPersistence().cacheResult(accountEntry);
	}

	/**
	 * Caches the account entries in the entity cache if it is enabled.
	 *
	 * @param accountEntries the account entries
	 */
	public static void cacheResult(List<AccountEntry> accountEntries) {
		getPersistence().cacheResult(accountEntries);
	}

	/**
	 * Creates a new account entry with the primary key. Does not add the account entry to the database.
	 *
	 * @param accountId the primary key for the new account entry
	 * @return the new account entry
	 */
	public static AccountEntry create(long accountId) {
		return getPersistence().create(accountId);
	}

	/**
	 * Removes the account entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param accountId the primary key of the account entry
	 * @return the account entry that was removed
	 * @throws NoSuchAccountEntryException if a account entry with the primary key could not be found
	 */
	public static AccountEntry remove(long accountId)
		throws com.dogoo.poc.account.exception.NoSuchAccountEntryException {

		return getPersistence().remove(accountId);
	}

	public static AccountEntry updateImpl(AccountEntry accountEntry) {
		return getPersistence().updateImpl(accountEntry);
	}

	/**
	 * Returns the account entry with the primary key or throws a <code>NoSuchAccountEntryException</code> if it could not be found.
	 *
	 * @param accountId the primary key of the account entry
	 * @return the account entry
	 * @throws NoSuchAccountEntryException if a account entry with the primary key could not be found
	 */
	public static AccountEntry findByPrimaryKey(long accountId)
		throws com.dogoo.poc.account.exception.NoSuchAccountEntryException {

		return getPersistence().findByPrimaryKey(accountId);
	}

	/**
	 * Returns the account entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param accountId the primary key of the account entry
	 * @return the account entry, or <code>null</code> if a account entry with the primary key could not be found
	 */
	public static AccountEntry fetchByPrimaryKey(long accountId) {
		return getPersistence().fetchByPrimaryKey(accountId);
	}

	/**
	 * Returns all the account entries.
	 *
	 * @return the account entries
	 */
	public static List<AccountEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the account entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of account entries
	 * @param end the upper bound of the range of account entries (not inclusive)
	 * @return the range of account entries
	 */
	public static List<AccountEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the account entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of account entries
	 * @param end the upper bound of the range of account entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of account entries
	 */
	public static List<AccountEntry> findAll(
		int start, int end, OrderByComparator<AccountEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the account entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of account entries
	 * @param end the upper bound of the range of account entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of account entries
	 */
	public static List<AccountEntry> findAll(
		int start, int end, OrderByComparator<AccountEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the account entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of account entries.
	 *
	 * @return the number of account entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	 * Returns the primaryKeys of category entries associated with the account entry.
	 *
	 * @param pk the primary key of the account entry
	 * @return long[] of the primaryKeys of category entries associated with the account entry
	 */
	public static long[] getCategoryEntryPrimaryKeys(long pk) {
		return getPersistence().getCategoryEntryPrimaryKeys(pk);
	}

	/**
	 * Returns all the account entry associated with the category entry.
	 *
	 * @param pk the primary key of the category entry
	 * @return the account entries associated with the category entry
	 */
	public static List<AccountEntry> getCategoryEntryAccountEntries(long pk) {
		return getPersistence().getCategoryEntryAccountEntries(pk);
	}

	/**
	 * Returns all the account entry associated with the category entry.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the category entry
	 * @param start the lower bound of the range of category entries
	 * @param end the upper bound of the range of category entries (not inclusive)
	 * @return the range of account entries associated with the category entry
	 */
	public static List<AccountEntry> getCategoryEntryAccountEntries(
		long pk, int start, int end) {

		return getPersistence().getCategoryEntryAccountEntries(pk, start, end);
	}

	/**
	 * Returns all the account entry associated with the category entry.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the category entry
	 * @param start the lower bound of the range of category entries
	 * @param end the upper bound of the range of category entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of account entries associated with the category entry
	 */
	public static List<AccountEntry> getCategoryEntryAccountEntries(
		long pk, int start, int end,
		OrderByComparator<AccountEntry> orderByComparator) {

		return getPersistence().getCategoryEntryAccountEntries(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of category entries associated with the account entry.
	 *
	 * @param pk the primary key of the account entry
	 * @return the number of category entries associated with the account entry
	 */
	public static int getCategoryEntriesSize(long pk) {
		return getPersistence().getCategoryEntriesSize(pk);
	}

	/**
	 * Returns <code>true</code> if the category entry is associated with the account entry.
	 *
	 * @param pk the primary key of the account entry
	 * @param categoryEntryPK the primary key of the category entry
	 * @return <code>true</code> if the category entry is associated with the account entry; <code>false</code> otherwise
	 */
	public static boolean containsCategoryEntry(long pk, long categoryEntryPK) {
		return getPersistence().containsCategoryEntry(pk, categoryEntryPK);
	}

	/**
	 * Returns <code>true</code> if the account entry has any category entries associated with it.
	 *
	 * @param pk the primary key of the account entry to check for associations with category entries
	 * @return <code>true</code> if the account entry has any category entries associated with it; <code>false</code> otherwise
	 */
	public static boolean containsCategoryEntries(long pk) {
		return getPersistence().containsCategoryEntries(pk);
	}

	/**
	 * Adds an association between the account entry and the category entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the account entry
	 * @param categoryEntryPK the primary key of the category entry
	 */
	public static void addCategoryEntry(long pk, long categoryEntryPK) {
		getPersistence().addCategoryEntry(pk, categoryEntryPK);
	}

	/**
	 * Adds an association between the account entry and the category entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the account entry
	 * @param categoryEntry the category entry
	 */
	public static void addCategoryEntry(
		long pk, com.dogoo.poc.account.model.CategoryEntry categoryEntry) {

		getPersistence().addCategoryEntry(pk, categoryEntry);
	}

	/**
	 * Adds an association between the account entry and the category entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the account entry
	 * @param categoryEntryPKs the primary keys of the category entries
	 */
	public static void addCategoryEntries(long pk, long[] categoryEntryPKs) {
		getPersistence().addCategoryEntries(pk, categoryEntryPKs);
	}

	/**
	 * Adds an association between the account entry and the category entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the account entry
	 * @param categoryEntries the category entries
	 */
	public static void addCategoryEntries(
		long pk,
		List<com.dogoo.poc.account.model.CategoryEntry> categoryEntries) {

		getPersistence().addCategoryEntries(pk, categoryEntries);
	}

	/**
	 * Clears all associations between the account entry and its category entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the account entry to clear the associated category entries from
	 */
	public static void clearCategoryEntries(long pk) {
		getPersistence().clearCategoryEntries(pk);
	}

	/**
	 * Removes the association between the account entry and the category entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the account entry
	 * @param categoryEntryPK the primary key of the category entry
	 */
	public static void removeCategoryEntry(long pk, long categoryEntryPK) {
		getPersistence().removeCategoryEntry(pk, categoryEntryPK);
	}

	/**
	 * Removes the association between the account entry and the category entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the account entry
	 * @param categoryEntry the category entry
	 */
	public static void removeCategoryEntry(
		long pk, com.dogoo.poc.account.model.CategoryEntry categoryEntry) {

		getPersistence().removeCategoryEntry(pk, categoryEntry);
	}

	/**
	 * Removes the association between the account entry and the category entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the account entry
	 * @param categoryEntryPKs the primary keys of the category entries
	 */
	public static void removeCategoryEntries(long pk, long[] categoryEntryPKs) {
		getPersistence().removeCategoryEntries(pk, categoryEntryPKs);
	}

	/**
	 * Removes the association between the account entry and the category entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the account entry
	 * @param categoryEntries the category entries
	 */
	public static void removeCategoryEntries(
		long pk,
		List<com.dogoo.poc.account.model.CategoryEntry> categoryEntries) {

		getPersistence().removeCategoryEntries(pk, categoryEntries);
	}

	/**
	 * Sets the category entries associated with the account entry, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the account entry
	 * @param categoryEntryPKs the primary keys of the category entries to be associated with the account entry
	 */
	public static void setCategoryEntries(long pk, long[] categoryEntryPKs) {
		getPersistence().setCategoryEntries(pk, categoryEntryPKs);
	}

	/**
	 * Sets the category entries associated with the account entry, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the account entry
	 * @param categoryEntries the category entries to be associated with the account entry
	 */
	public static void setCategoryEntries(
		long pk,
		List<com.dogoo.poc.account.model.CategoryEntry> categoryEntries) {

		getPersistence().setCategoryEntries(pk, categoryEntries);
	}

	public static AccountEntryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<AccountEntryPersistence, AccountEntryPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AccountEntryPersistence.class);

		ServiceTracker<AccountEntryPersistence, AccountEntryPersistence>
			serviceTracker =
				new ServiceTracker
					<AccountEntryPersistence, AccountEntryPersistence>(
						bundle.getBundleContext(),
						AccountEntryPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}