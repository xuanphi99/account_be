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

package com.dogoo.account.service.persistence;

import com.dogoo.account.model.AccountRoleEntry;

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
 * The persistence utility for the account role entry service. This utility wraps <code>com.dogoo.account.service.persistence.impl.AccountRoleEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AccountRoleEntryPersistence
 * @generated
 */
public class AccountRoleEntryUtil {

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
	public static void clearCache(AccountRoleEntry accountRoleEntry) {
		getPersistence().clearCache(accountRoleEntry);
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
	public static Map<Serializable, AccountRoleEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AccountRoleEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AccountRoleEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AccountRoleEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AccountRoleEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AccountRoleEntry update(AccountRoleEntry accountRoleEntry) {
		return getPersistence().update(accountRoleEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AccountRoleEntry update(
		AccountRoleEntry accountRoleEntry, ServiceContext serviceContext) {

		return getPersistence().update(accountRoleEntry, serviceContext);
	}

	/**
	 * Returns all the account role entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching account role entries
	 */
	public static List<AccountRoleEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the account role entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountRoleEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of account role entries
	 * @param end the upper bound of the range of account role entries (not inclusive)
	 * @return the range of matching account role entries
	 */
	public static List<AccountRoleEntry> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the account role entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountRoleEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of account role entries
	 * @param end the upper bound of the range of account role entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching account role entries
	 */
	public static List<AccountRoleEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AccountRoleEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the account role entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountRoleEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of account role entries
	 * @param end the upper bound of the range of account role entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching account role entries
	 */
	public static List<AccountRoleEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AccountRoleEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first account role entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account role entry
	 * @throws NoSuchAccountRoleEntryException if a matching account role entry could not be found
	 */
	public static AccountRoleEntry findByUuid_First(
			String uuid, OrderByComparator<AccountRoleEntry> orderByComparator)
		throws com.dogoo.account.exception.NoSuchAccountRoleEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first account role entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account role entry, or <code>null</code> if a matching account role entry could not be found
	 */
	public static AccountRoleEntry fetchByUuid_First(
		String uuid, OrderByComparator<AccountRoleEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last account role entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account role entry
	 * @throws NoSuchAccountRoleEntryException if a matching account role entry could not be found
	 */
	public static AccountRoleEntry findByUuid_Last(
			String uuid, OrderByComparator<AccountRoleEntry> orderByComparator)
		throws com.dogoo.account.exception.NoSuchAccountRoleEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last account role entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account role entry, or <code>null</code> if a matching account role entry could not be found
	 */
	public static AccountRoleEntry fetchByUuid_Last(
		String uuid, OrderByComparator<AccountRoleEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the account role entries before and after the current account role entry in the ordered set where uuid = &#63;.
	 *
	 * @param AccountRoleId the primary key of the current account role entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account role entry
	 * @throws NoSuchAccountRoleEntryException if a account role entry with the primary key could not be found
	 */
	public static AccountRoleEntry[] findByUuid_PrevAndNext(
			long AccountRoleId, String uuid,
			OrderByComparator<AccountRoleEntry> orderByComparator)
		throws com.dogoo.account.exception.NoSuchAccountRoleEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			AccountRoleId, uuid, orderByComparator);
	}

	/**
	 * Removes all the account role entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of account role entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching account role entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the account role entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAccountRoleEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching account role entry
	 * @throws NoSuchAccountRoleEntryException if a matching account role entry could not be found
	 */
	public static AccountRoleEntry findByUUID_G(String uuid, long groupId)
		throws com.dogoo.account.exception.NoSuchAccountRoleEntryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the account role entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching account role entry, or <code>null</code> if a matching account role entry could not be found
	 */
	public static AccountRoleEntry fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the account role entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching account role entry, or <code>null</code> if a matching account role entry could not be found
	 */
	public static AccountRoleEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the account role entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the account role entry that was removed
	 */
	public static AccountRoleEntry removeByUUID_G(String uuid, long groupId)
		throws com.dogoo.account.exception.NoSuchAccountRoleEntryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of account role entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching account role entries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the account role entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching account role entries
	 */
	public static List<AccountRoleEntry> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the account role entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountRoleEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of account role entries
	 * @param end the upper bound of the range of account role entries (not inclusive)
	 * @return the range of matching account role entries
	 */
	public static List<AccountRoleEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the account role entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountRoleEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of account role entries
	 * @param end the upper bound of the range of account role entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching account role entries
	 */
	public static List<AccountRoleEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AccountRoleEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the account role entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountRoleEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of account role entries
	 * @param end the upper bound of the range of account role entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching account role entries
	 */
	public static List<AccountRoleEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AccountRoleEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first account role entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account role entry
	 * @throws NoSuchAccountRoleEntryException if a matching account role entry could not be found
	 */
	public static AccountRoleEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AccountRoleEntry> orderByComparator)
		throws com.dogoo.account.exception.NoSuchAccountRoleEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first account role entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account role entry, or <code>null</code> if a matching account role entry could not be found
	 */
	public static AccountRoleEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AccountRoleEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last account role entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account role entry
	 * @throws NoSuchAccountRoleEntryException if a matching account role entry could not be found
	 */
	public static AccountRoleEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AccountRoleEntry> orderByComparator)
		throws com.dogoo.account.exception.NoSuchAccountRoleEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last account role entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account role entry, or <code>null</code> if a matching account role entry could not be found
	 */
	public static AccountRoleEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AccountRoleEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the account role entries before and after the current account role entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param AccountRoleId the primary key of the current account role entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account role entry
	 * @throws NoSuchAccountRoleEntryException if a account role entry with the primary key could not be found
	 */
	public static AccountRoleEntry[] findByUuid_C_PrevAndNext(
			long AccountRoleId, String uuid, long companyId,
			OrderByComparator<AccountRoleEntry> orderByComparator)
		throws com.dogoo.account.exception.NoSuchAccountRoleEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			AccountRoleId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the account role entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of account role entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching account role entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the account role entries where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching account role entries
	 */
	public static List<AccountRoleEntry> findBycode(String code) {
		return getPersistence().findBycode(code);
	}

	/**
	 * Returns a range of all the account role entries where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountRoleEntryModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of account role entries
	 * @param end the upper bound of the range of account role entries (not inclusive)
	 * @return the range of matching account role entries
	 */
	public static List<AccountRoleEntry> findBycode(
		String code, int start, int end) {

		return getPersistence().findBycode(code, start, end);
	}

	/**
	 * Returns an ordered range of all the account role entries where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountRoleEntryModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of account role entries
	 * @param end the upper bound of the range of account role entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching account role entries
	 */
	public static List<AccountRoleEntry> findBycode(
		String code, int start, int end,
		OrderByComparator<AccountRoleEntry> orderByComparator) {

		return getPersistence().findBycode(code, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the account role entries where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountRoleEntryModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of account role entries
	 * @param end the upper bound of the range of account role entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching account role entries
	 */
	public static List<AccountRoleEntry> findBycode(
		String code, int start, int end,
		OrderByComparator<AccountRoleEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBycode(
			code, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first account role entry in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account role entry
	 * @throws NoSuchAccountRoleEntryException if a matching account role entry could not be found
	 */
	public static AccountRoleEntry findBycode_First(
			String code, OrderByComparator<AccountRoleEntry> orderByComparator)
		throws com.dogoo.account.exception.NoSuchAccountRoleEntryException {

		return getPersistence().findBycode_First(code, orderByComparator);
	}

	/**
	 * Returns the first account role entry in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account role entry, or <code>null</code> if a matching account role entry could not be found
	 */
	public static AccountRoleEntry fetchBycode_First(
		String code, OrderByComparator<AccountRoleEntry> orderByComparator) {

		return getPersistence().fetchBycode_First(code, orderByComparator);
	}

	/**
	 * Returns the last account role entry in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account role entry
	 * @throws NoSuchAccountRoleEntryException if a matching account role entry could not be found
	 */
	public static AccountRoleEntry findBycode_Last(
			String code, OrderByComparator<AccountRoleEntry> orderByComparator)
		throws com.dogoo.account.exception.NoSuchAccountRoleEntryException {

		return getPersistence().findBycode_Last(code, orderByComparator);
	}

	/**
	 * Returns the last account role entry in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account role entry, or <code>null</code> if a matching account role entry could not be found
	 */
	public static AccountRoleEntry fetchBycode_Last(
		String code, OrderByComparator<AccountRoleEntry> orderByComparator) {

		return getPersistence().fetchBycode_Last(code, orderByComparator);
	}

	/**
	 * Returns the account role entries before and after the current account role entry in the ordered set where code = &#63;.
	 *
	 * @param AccountRoleId the primary key of the current account role entry
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account role entry
	 * @throws NoSuchAccountRoleEntryException if a account role entry with the primary key could not be found
	 */
	public static AccountRoleEntry[] findBycode_PrevAndNext(
			long AccountRoleId, String code,
			OrderByComparator<AccountRoleEntry> orderByComparator)
		throws com.dogoo.account.exception.NoSuchAccountRoleEntryException {

		return getPersistence().findBycode_PrevAndNext(
			AccountRoleId, code, orderByComparator);
	}

	/**
	 * Removes all the account role entries where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public static void removeBycode(String code) {
		getPersistence().removeBycode(code);
	}

	/**
	 * Returns the number of account role entries where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching account role entries
	 */
	public static int countBycode(String code) {
		return getPersistence().countBycode(code);
	}

	/**
	 * Returns all the account role entries where AccountId = &#63;.
	 *
	 * @param AccountId the account ID
	 * @return the matching account role entries
	 */
	public static List<AccountRoleEntry> findByAccountId(long AccountId) {
		return getPersistence().findByAccountId(AccountId);
	}

	/**
	 * Returns a range of all the account role entries where AccountId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountRoleEntryModelImpl</code>.
	 * </p>
	 *
	 * @param AccountId the account ID
	 * @param start the lower bound of the range of account role entries
	 * @param end the upper bound of the range of account role entries (not inclusive)
	 * @return the range of matching account role entries
	 */
	public static List<AccountRoleEntry> findByAccountId(
		long AccountId, int start, int end) {

		return getPersistence().findByAccountId(AccountId, start, end);
	}

	/**
	 * Returns an ordered range of all the account role entries where AccountId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountRoleEntryModelImpl</code>.
	 * </p>
	 *
	 * @param AccountId the account ID
	 * @param start the lower bound of the range of account role entries
	 * @param end the upper bound of the range of account role entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching account role entries
	 */
	public static List<AccountRoleEntry> findByAccountId(
		long AccountId, int start, int end,
		OrderByComparator<AccountRoleEntry> orderByComparator) {

		return getPersistence().findByAccountId(
			AccountId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the account role entries where AccountId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountRoleEntryModelImpl</code>.
	 * </p>
	 *
	 * @param AccountId the account ID
	 * @param start the lower bound of the range of account role entries
	 * @param end the upper bound of the range of account role entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching account role entries
	 */
	public static List<AccountRoleEntry> findByAccountId(
		long AccountId, int start, int end,
		OrderByComparator<AccountRoleEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByAccountId(
			AccountId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first account role entry in the ordered set where AccountId = &#63;.
	 *
	 * @param AccountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account role entry
	 * @throws NoSuchAccountRoleEntryException if a matching account role entry could not be found
	 */
	public static AccountRoleEntry findByAccountId_First(
			long AccountId,
			OrderByComparator<AccountRoleEntry> orderByComparator)
		throws com.dogoo.account.exception.NoSuchAccountRoleEntryException {

		return getPersistence().findByAccountId_First(
			AccountId, orderByComparator);
	}

	/**
	 * Returns the first account role entry in the ordered set where AccountId = &#63;.
	 *
	 * @param AccountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account role entry, or <code>null</code> if a matching account role entry could not be found
	 */
	public static AccountRoleEntry fetchByAccountId_First(
		long AccountId, OrderByComparator<AccountRoleEntry> orderByComparator) {

		return getPersistence().fetchByAccountId_First(
			AccountId, orderByComparator);
	}

	/**
	 * Returns the last account role entry in the ordered set where AccountId = &#63;.
	 *
	 * @param AccountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account role entry
	 * @throws NoSuchAccountRoleEntryException if a matching account role entry could not be found
	 */
	public static AccountRoleEntry findByAccountId_Last(
			long AccountId,
			OrderByComparator<AccountRoleEntry> orderByComparator)
		throws com.dogoo.account.exception.NoSuchAccountRoleEntryException {

		return getPersistence().findByAccountId_Last(
			AccountId, orderByComparator);
	}

	/**
	 * Returns the last account role entry in the ordered set where AccountId = &#63;.
	 *
	 * @param AccountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account role entry, or <code>null</code> if a matching account role entry could not be found
	 */
	public static AccountRoleEntry fetchByAccountId_Last(
		long AccountId, OrderByComparator<AccountRoleEntry> orderByComparator) {

		return getPersistence().fetchByAccountId_Last(
			AccountId, orderByComparator);
	}

	/**
	 * Returns the account role entries before and after the current account role entry in the ordered set where AccountId = &#63;.
	 *
	 * @param AccountRoleId the primary key of the current account role entry
	 * @param AccountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account role entry
	 * @throws NoSuchAccountRoleEntryException if a account role entry with the primary key could not be found
	 */
	public static AccountRoleEntry[] findByAccountId_PrevAndNext(
			long AccountRoleId, long AccountId,
			OrderByComparator<AccountRoleEntry> orderByComparator)
		throws com.dogoo.account.exception.NoSuchAccountRoleEntryException {

		return getPersistence().findByAccountId_PrevAndNext(
			AccountRoleId, AccountId, orderByComparator);
	}

	/**
	 * Removes all the account role entries where AccountId = &#63; from the database.
	 *
	 * @param AccountId the account ID
	 */
	public static void removeByAccountId(long AccountId) {
		getPersistence().removeByAccountId(AccountId);
	}

	/**
	 * Returns the number of account role entries where AccountId = &#63;.
	 *
	 * @param AccountId the account ID
	 * @return the number of matching account role entries
	 */
	public static int countByAccountId(long AccountId) {
		return getPersistence().countByAccountId(AccountId);
	}

	/**
	 * Caches the account role entry in the entity cache if it is enabled.
	 *
	 * @param accountRoleEntry the account role entry
	 */
	public static void cacheResult(AccountRoleEntry accountRoleEntry) {
		getPersistence().cacheResult(accountRoleEntry);
	}

	/**
	 * Caches the account role entries in the entity cache if it is enabled.
	 *
	 * @param accountRoleEntries the account role entries
	 */
	public static void cacheResult(List<AccountRoleEntry> accountRoleEntries) {
		getPersistence().cacheResult(accountRoleEntries);
	}

	/**
	 * Creates a new account role entry with the primary key. Does not add the account role entry to the database.
	 *
	 * @param AccountRoleId the primary key for the new account role entry
	 * @return the new account role entry
	 */
	public static AccountRoleEntry create(long AccountRoleId) {
		return getPersistence().create(AccountRoleId);
	}

	/**
	 * Removes the account role entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param AccountRoleId the primary key of the account role entry
	 * @return the account role entry that was removed
	 * @throws NoSuchAccountRoleEntryException if a account role entry with the primary key could not be found
	 */
	public static AccountRoleEntry remove(long AccountRoleId)
		throws com.dogoo.account.exception.NoSuchAccountRoleEntryException {

		return getPersistence().remove(AccountRoleId);
	}

	public static AccountRoleEntry updateImpl(
		AccountRoleEntry accountRoleEntry) {

		return getPersistence().updateImpl(accountRoleEntry);
	}

	/**
	 * Returns the account role entry with the primary key or throws a <code>NoSuchAccountRoleEntryException</code> if it could not be found.
	 *
	 * @param AccountRoleId the primary key of the account role entry
	 * @return the account role entry
	 * @throws NoSuchAccountRoleEntryException if a account role entry with the primary key could not be found
	 */
	public static AccountRoleEntry findByPrimaryKey(long AccountRoleId)
		throws com.dogoo.account.exception.NoSuchAccountRoleEntryException {

		return getPersistence().findByPrimaryKey(AccountRoleId);
	}

	/**
	 * Returns the account role entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param AccountRoleId the primary key of the account role entry
	 * @return the account role entry, or <code>null</code> if a account role entry with the primary key could not be found
	 */
	public static AccountRoleEntry fetchByPrimaryKey(long AccountRoleId) {
		return getPersistence().fetchByPrimaryKey(AccountRoleId);
	}

	/**
	 * Returns all the account role entries.
	 *
	 * @return the account role entries
	 */
	public static List<AccountRoleEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the account role entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountRoleEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of account role entries
	 * @param end the upper bound of the range of account role entries (not inclusive)
	 * @return the range of account role entries
	 */
	public static List<AccountRoleEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the account role entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountRoleEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of account role entries
	 * @param end the upper bound of the range of account role entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of account role entries
	 */
	public static List<AccountRoleEntry> findAll(
		int start, int end,
		OrderByComparator<AccountRoleEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the account role entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountRoleEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of account role entries
	 * @param end the upper bound of the range of account role entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of account role entries
	 */
	public static List<AccountRoleEntry> findAll(
		int start, int end,
		OrderByComparator<AccountRoleEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the account role entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of account role entries.
	 *
	 * @return the number of account role entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AccountRoleEntryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<AccountRoleEntryPersistence, AccountRoleEntryPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			AccountRoleEntryPersistence.class);

		ServiceTracker<AccountRoleEntryPersistence, AccountRoleEntryPersistence>
			serviceTracker =
				new ServiceTracker
					<AccountRoleEntryPersistence, AccountRoleEntryPersistence>(
						bundle.getBundleContext(),
						AccountRoleEntryPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}