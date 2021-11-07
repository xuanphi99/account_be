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

import com.dogoo.poc.account.exception.NoSuchAccountRoleEntryException;
import com.dogoo.poc.account.model.AccountRoleEntry;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the account role entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AccountRoleEntryUtil
 * @generated
 */
@ProviderType
public interface AccountRoleEntryPersistence
	extends BasePersistence<AccountRoleEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AccountRoleEntryUtil} to access the account role entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the account role entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching account role entries
	 */
	public java.util.List<AccountRoleEntry> findByUuid(String uuid);

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
	public java.util.List<AccountRoleEntry> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<AccountRoleEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AccountRoleEntry>
			orderByComparator);

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
	public java.util.List<AccountRoleEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AccountRoleEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first account role entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account role entry
	 * @throws NoSuchAccountRoleEntryException if a matching account role entry could not be found
	 */
	public AccountRoleEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AccountRoleEntry>
				orderByComparator)
		throws NoSuchAccountRoleEntryException;

	/**
	 * Returns the first account role entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account role entry, or <code>null</code> if a matching account role entry could not be found
	 */
	public AccountRoleEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AccountRoleEntry>
			orderByComparator);

	/**
	 * Returns the last account role entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account role entry
	 * @throws NoSuchAccountRoleEntryException if a matching account role entry could not be found
	 */
	public AccountRoleEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AccountRoleEntry>
				orderByComparator)
		throws NoSuchAccountRoleEntryException;

	/**
	 * Returns the last account role entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account role entry, or <code>null</code> if a matching account role entry could not be found
	 */
	public AccountRoleEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AccountRoleEntry>
			orderByComparator);

	/**
	 * Returns the account role entries before and after the current account role entry in the ordered set where uuid = &#63;.
	 *
	 * @param AccountRoleId the primary key of the current account role entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account role entry
	 * @throws NoSuchAccountRoleEntryException if a account role entry with the primary key could not be found
	 */
	public AccountRoleEntry[] findByUuid_PrevAndNext(
			long AccountRoleId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AccountRoleEntry>
				orderByComparator)
		throws NoSuchAccountRoleEntryException;

	/**
	 * Removes all the account role entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of account role entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching account role entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the account role entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAccountRoleEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching account role entry
	 * @throws NoSuchAccountRoleEntryException if a matching account role entry could not be found
	 */
	public AccountRoleEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchAccountRoleEntryException;

	/**
	 * Returns the account role entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching account role entry, or <code>null</code> if a matching account role entry could not be found
	 */
	public AccountRoleEntry fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the account role entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching account role entry, or <code>null</code> if a matching account role entry could not be found
	 */
	public AccountRoleEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the account role entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the account role entry that was removed
	 */
	public AccountRoleEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchAccountRoleEntryException;

	/**
	 * Returns the number of account role entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching account role entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the account role entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching account role entries
	 */
	public java.util.List<AccountRoleEntry> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<AccountRoleEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<AccountRoleEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AccountRoleEntry>
			orderByComparator);

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
	public java.util.List<AccountRoleEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AccountRoleEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first account role entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account role entry
	 * @throws NoSuchAccountRoleEntryException if a matching account role entry could not be found
	 */
	public AccountRoleEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AccountRoleEntry>
				orderByComparator)
		throws NoSuchAccountRoleEntryException;

	/**
	 * Returns the first account role entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account role entry, or <code>null</code> if a matching account role entry could not be found
	 */
	public AccountRoleEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AccountRoleEntry>
			orderByComparator);

	/**
	 * Returns the last account role entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account role entry
	 * @throws NoSuchAccountRoleEntryException if a matching account role entry could not be found
	 */
	public AccountRoleEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AccountRoleEntry>
				orderByComparator)
		throws NoSuchAccountRoleEntryException;

	/**
	 * Returns the last account role entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account role entry, or <code>null</code> if a matching account role entry could not be found
	 */
	public AccountRoleEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AccountRoleEntry>
			orderByComparator);

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
	public AccountRoleEntry[] findByUuid_C_PrevAndNext(
			long AccountRoleId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AccountRoleEntry>
				orderByComparator)
		throws NoSuchAccountRoleEntryException;

	/**
	 * Removes all the account role entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of account role entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching account role entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the account role entries where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching account role entries
	 */
	public java.util.List<AccountRoleEntry> findBycode(String code);

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
	public java.util.List<AccountRoleEntry> findBycode(
		String code, int start, int end);

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
	public java.util.List<AccountRoleEntry> findBycode(
		String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AccountRoleEntry>
			orderByComparator);

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
	public java.util.List<AccountRoleEntry> findBycode(
		String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AccountRoleEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first account role entry in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account role entry
	 * @throws NoSuchAccountRoleEntryException if a matching account role entry could not be found
	 */
	public AccountRoleEntry findBycode_First(
			String code,
			com.liferay.portal.kernel.util.OrderByComparator<AccountRoleEntry>
				orderByComparator)
		throws NoSuchAccountRoleEntryException;

	/**
	 * Returns the first account role entry in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account role entry, or <code>null</code> if a matching account role entry could not be found
	 */
	public AccountRoleEntry fetchBycode_First(
		String code,
		com.liferay.portal.kernel.util.OrderByComparator<AccountRoleEntry>
			orderByComparator);

	/**
	 * Returns the last account role entry in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account role entry
	 * @throws NoSuchAccountRoleEntryException if a matching account role entry could not be found
	 */
	public AccountRoleEntry findBycode_Last(
			String code,
			com.liferay.portal.kernel.util.OrderByComparator<AccountRoleEntry>
				orderByComparator)
		throws NoSuchAccountRoleEntryException;

	/**
	 * Returns the last account role entry in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account role entry, or <code>null</code> if a matching account role entry could not be found
	 */
	public AccountRoleEntry fetchBycode_Last(
		String code,
		com.liferay.portal.kernel.util.OrderByComparator<AccountRoleEntry>
			orderByComparator);

	/**
	 * Returns the account role entries before and after the current account role entry in the ordered set where code = &#63;.
	 *
	 * @param AccountRoleId the primary key of the current account role entry
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account role entry
	 * @throws NoSuchAccountRoleEntryException if a account role entry with the primary key could not be found
	 */
	public AccountRoleEntry[] findBycode_PrevAndNext(
			long AccountRoleId, String code,
			com.liferay.portal.kernel.util.OrderByComparator<AccountRoleEntry>
				orderByComparator)
		throws NoSuchAccountRoleEntryException;

	/**
	 * Removes all the account role entries where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public void removeBycode(String code);

	/**
	 * Returns the number of account role entries where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching account role entries
	 */
	public int countBycode(String code);

	/**
	 * Returns all the account role entries where AccountId = &#63;.
	 *
	 * @param AccountId the account ID
	 * @return the matching account role entries
	 */
	public java.util.List<AccountRoleEntry> findByAccountId(long AccountId);

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
	public java.util.List<AccountRoleEntry> findByAccountId(
		long AccountId, int start, int end);

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
	public java.util.List<AccountRoleEntry> findByAccountId(
		long AccountId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AccountRoleEntry>
			orderByComparator);

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
	public java.util.List<AccountRoleEntry> findByAccountId(
		long AccountId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AccountRoleEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first account role entry in the ordered set where AccountId = &#63;.
	 *
	 * @param AccountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account role entry
	 * @throws NoSuchAccountRoleEntryException if a matching account role entry could not be found
	 */
	public AccountRoleEntry findByAccountId_First(
			long AccountId,
			com.liferay.portal.kernel.util.OrderByComparator<AccountRoleEntry>
				orderByComparator)
		throws NoSuchAccountRoleEntryException;

	/**
	 * Returns the first account role entry in the ordered set where AccountId = &#63;.
	 *
	 * @param AccountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account role entry, or <code>null</code> if a matching account role entry could not be found
	 */
	public AccountRoleEntry fetchByAccountId_First(
		long AccountId,
		com.liferay.portal.kernel.util.OrderByComparator<AccountRoleEntry>
			orderByComparator);

	/**
	 * Returns the last account role entry in the ordered set where AccountId = &#63;.
	 *
	 * @param AccountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account role entry
	 * @throws NoSuchAccountRoleEntryException if a matching account role entry could not be found
	 */
	public AccountRoleEntry findByAccountId_Last(
			long AccountId,
			com.liferay.portal.kernel.util.OrderByComparator<AccountRoleEntry>
				orderByComparator)
		throws NoSuchAccountRoleEntryException;

	/**
	 * Returns the last account role entry in the ordered set where AccountId = &#63;.
	 *
	 * @param AccountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account role entry, or <code>null</code> if a matching account role entry could not be found
	 */
	public AccountRoleEntry fetchByAccountId_Last(
		long AccountId,
		com.liferay.portal.kernel.util.OrderByComparator<AccountRoleEntry>
			orderByComparator);

	/**
	 * Returns the account role entries before and after the current account role entry in the ordered set where AccountId = &#63;.
	 *
	 * @param AccountRoleId the primary key of the current account role entry
	 * @param AccountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account role entry
	 * @throws NoSuchAccountRoleEntryException if a account role entry with the primary key could not be found
	 */
	public AccountRoleEntry[] findByAccountId_PrevAndNext(
			long AccountRoleId, long AccountId,
			com.liferay.portal.kernel.util.OrderByComparator<AccountRoleEntry>
				orderByComparator)
		throws NoSuchAccountRoleEntryException;

	/**
	 * Removes all the account role entries where AccountId = &#63; from the database.
	 *
	 * @param AccountId the account ID
	 */
	public void removeByAccountId(long AccountId);

	/**
	 * Returns the number of account role entries where AccountId = &#63;.
	 *
	 * @param AccountId the account ID
	 * @return the number of matching account role entries
	 */
	public int countByAccountId(long AccountId);

	/**
	 * Caches the account role entry in the entity cache if it is enabled.
	 *
	 * @param accountRoleEntry the account role entry
	 */
	public void cacheResult(AccountRoleEntry accountRoleEntry);

	/**
	 * Caches the account role entries in the entity cache if it is enabled.
	 *
	 * @param accountRoleEntries the account role entries
	 */
	public void cacheResult(
		java.util.List<AccountRoleEntry> accountRoleEntries);

	/**
	 * Creates a new account role entry with the primary key. Does not add the account role entry to the database.
	 *
	 * @param AccountRoleId the primary key for the new account role entry
	 * @return the new account role entry
	 */
	public AccountRoleEntry create(long AccountRoleId);

	/**
	 * Removes the account role entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param AccountRoleId the primary key of the account role entry
	 * @return the account role entry that was removed
	 * @throws NoSuchAccountRoleEntryException if a account role entry with the primary key could not be found
	 */
	public AccountRoleEntry remove(long AccountRoleId)
		throws NoSuchAccountRoleEntryException;

	public AccountRoleEntry updateImpl(AccountRoleEntry accountRoleEntry);

	/**
	 * Returns the account role entry with the primary key or throws a <code>NoSuchAccountRoleEntryException</code> if it could not be found.
	 *
	 * @param AccountRoleId the primary key of the account role entry
	 * @return the account role entry
	 * @throws NoSuchAccountRoleEntryException if a account role entry with the primary key could not be found
	 */
	public AccountRoleEntry findByPrimaryKey(long AccountRoleId)
		throws NoSuchAccountRoleEntryException;

	/**
	 * Returns the account role entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param AccountRoleId the primary key of the account role entry
	 * @return the account role entry, or <code>null</code> if a account role entry with the primary key could not be found
	 */
	public AccountRoleEntry fetchByPrimaryKey(long AccountRoleId);

	/**
	 * Returns all the account role entries.
	 *
	 * @return the account role entries
	 */
	public java.util.List<AccountRoleEntry> findAll();

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
	public java.util.List<AccountRoleEntry> findAll(int start, int end);

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
	public java.util.List<AccountRoleEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AccountRoleEntry>
			orderByComparator);

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
	public java.util.List<AccountRoleEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AccountRoleEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the account role entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of account role entries.
	 *
	 * @return the number of account role entries
	 */
	public int countAll();

}