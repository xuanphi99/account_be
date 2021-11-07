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

import com.dogoo.account.exception.NoSuchAccountEntryException;
import com.dogoo.account.model.AccountEntry;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the account entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AccountEntryUtil
 * @generated
 */
@ProviderType
public interface AccountEntryPersistence extends BasePersistence<AccountEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AccountEntryUtil} to access the account entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the account entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching account entries
	 */
	public java.util.List<AccountEntry> findByUuid(String uuid);

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
	public java.util.List<AccountEntry> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<AccountEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AccountEntry>
			orderByComparator);

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
	public java.util.List<AccountEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AccountEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first account entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account entry
	 * @throws NoSuchAccountEntryException if a matching account entry could not be found
	 */
	public AccountEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AccountEntry>
				orderByComparator)
		throws NoSuchAccountEntryException;

	/**
	 * Returns the first account entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account entry, or <code>null</code> if a matching account entry could not be found
	 */
	public AccountEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AccountEntry>
			orderByComparator);

	/**
	 * Returns the last account entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account entry
	 * @throws NoSuchAccountEntryException if a matching account entry could not be found
	 */
	public AccountEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AccountEntry>
				orderByComparator)
		throws NoSuchAccountEntryException;

	/**
	 * Returns the last account entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account entry, or <code>null</code> if a matching account entry could not be found
	 */
	public AccountEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AccountEntry>
			orderByComparator);

	/**
	 * Returns the account entries before and after the current account entry in the ordered set where uuid = &#63;.
	 *
	 * @param accountId the primary key of the current account entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account entry
	 * @throws NoSuchAccountEntryException if a account entry with the primary key could not be found
	 */
	public AccountEntry[] findByUuid_PrevAndNext(
			long accountId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AccountEntry>
				orderByComparator)
		throws NoSuchAccountEntryException;

	/**
	 * Removes all the account entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of account entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching account entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the account entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAccountEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching account entry
	 * @throws NoSuchAccountEntryException if a matching account entry could not be found
	 */
	public AccountEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchAccountEntryException;

	/**
	 * Returns the account entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching account entry, or <code>null</code> if a matching account entry could not be found
	 */
	public AccountEntry fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the account entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching account entry, or <code>null</code> if a matching account entry could not be found
	 */
	public AccountEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the account entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the account entry that was removed
	 */
	public AccountEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchAccountEntryException;

	/**
	 * Returns the number of account entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching account entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the account entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching account entries
	 */
	public java.util.List<AccountEntry> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<AccountEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<AccountEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AccountEntry>
			orderByComparator);

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
	public java.util.List<AccountEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AccountEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first account entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account entry
	 * @throws NoSuchAccountEntryException if a matching account entry could not be found
	 */
	public AccountEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AccountEntry>
				orderByComparator)
		throws NoSuchAccountEntryException;

	/**
	 * Returns the first account entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account entry, or <code>null</code> if a matching account entry could not be found
	 */
	public AccountEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AccountEntry>
			orderByComparator);

	/**
	 * Returns the last account entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account entry
	 * @throws NoSuchAccountEntryException if a matching account entry could not be found
	 */
	public AccountEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AccountEntry>
				orderByComparator)
		throws NoSuchAccountEntryException;

	/**
	 * Returns the last account entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account entry, or <code>null</code> if a matching account entry could not be found
	 */
	public AccountEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AccountEntry>
			orderByComparator);

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
	public AccountEntry[] findByUuid_C_PrevAndNext(
			long accountId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AccountEntry>
				orderByComparator)
		throws NoSuchAccountEntryException;

	/**
	 * Removes all the account entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of account entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching account entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the account entries where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @return the matching account entries
	 */
	public java.util.List<AccountEntry> findByfullName(String fullName);

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
	public java.util.List<AccountEntry> findByfullName(
		String fullName, int start, int end);

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
	public java.util.List<AccountEntry> findByfullName(
		String fullName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AccountEntry>
			orderByComparator);

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
	public java.util.List<AccountEntry> findByfullName(
		String fullName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AccountEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first account entry in the ordered set where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account entry
	 * @throws NoSuchAccountEntryException if a matching account entry could not be found
	 */
	public AccountEntry findByfullName_First(
			String fullName,
			com.liferay.portal.kernel.util.OrderByComparator<AccountEntry>
				orderByComparator)
		throws NoSuchAccountEntryException;

	/**
	 * Returns the first account entry in the ordered set where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account entry, or <code>null</code> if a matching account entry could not be found
	 */
	public AccountEntry fetchByfullName_First(
		String fullName,
		com.liferay.portal.kernel.util.OrderByComparator<AccountEntry>
			orderByComparator);

	/**
	 * Returns the last account entry in the ordered set where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account entry
	 * @throws NoSuchAccountEntryException if a matching account entry could not be found
	 */
	public AccountEntry findByfullName_Last(
			String fullName,
			com.liferay.portal.kernel.util.OrderByComparator<AccountEntry>
				orderByComparator)
		throws NoSuchAccountEntryException;

	/**
	 * Returns the last account entry in the ordered set where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account entry, or <code>null</code> if a matching account entry could not be found
	 */
	public AccountEntry fetchByfullName_Last(
		String fullName,
		com.liferay.portal.kernel.util.OrderByComparator<AccountEntry>
			orderByComparator);

	/**
	 * Returns the account entries before and after the current account entry in the ordered set where fullName = &#63;.
	 *
	 * @param accountId the primary key of the current account entry
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account entry
	 * @throws NoSuchAccountEntryException if a account entry with the primary key could not be found
	 */
	public AccountEntry[] findByfullName_PrevAndNext(
			long accountId, String fullName,
			com.liferay.portal.kernel.util.OrderByComparator<AccountEntry>
				orderByComparator)
		throws NoSuchAccountEntryException;

	/**
	 * Removes all the account entries where fullName = &#63; from the database.
	 *
	 * @param fullName the full name
	 */
	public void removeByfullName(String fullName);

	/**
	 * Returns the number of account entries where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @return the number of matching account entries
	 */
	public int countByfullName(String fullName);

	/**
	 * Returns the account entry where newUser = &#63; or throws a <code>NoSuchAccountEntryException</code> if it could not be found.
	 *
	 * @param newUser the new user
	 * @return the matching account entry
	 * @throws NoSuchAccountEntryException if a matching account entry could not be found
	 */
	public AccountEntry findByUserName(String newUser)
		throws NoSuchAccountEntryException;

	/**
	 * Returns the account entry where newUser = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param newUser the new user
	 * @return the matching account entry, or <code>null</code> if a matching account entry could not be found
	 */
	public AccountEntry fetchByUserName(String newUser);

	/**
	 * Returns the account entry where newUser = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param newUser the new user
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching account entry, or <code>null</code> if a matching account entry could not be found
	 */
	public AccountEntry fetchByUserName(String newUser, boolean useFinderCache);

	/**
	 * Removes the account entry where newUser = &#63; from the database.
	 *
	 * @param newUser the new user
	 * @return the account entry that was removed
	 */
	public AccountEntry removeByUserName(String newUser)
		throws NoSuchAccountEntryException;

	/**
	 * Returns the number of account entries where newUser = &#63;.
	 *
	 * @param newUser the new user
	 * @return the number of matching account entries
	 */
	public int countByUserName(String newUser);

	/**
	 * Returns all the account entries where email = &#63;.
	 *
	 * @param email the email
	 * @return the matching account entries
	 */
	public java.util.List<AccountEntry> findByemail(String email);

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
	public java.util.List<AccountEntry> findByemail(
		String email, int start, int end);

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
	public java.util.List<AccountEntry> findByemail(
		String email, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AccountEntry>
			orderByComparator);

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
	public java.util.List<AccountEntry> findByemail(
		String email, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AccountEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first account entry in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account entry
	 * @throws NoSuchAccountEntryException if a matching account entry could not be found
	 */
	public AccountEntry findByemail_First(
			String email,
			com.liferay.portal.kernel.util.OrderByComparator<AccountEntry>
				orderByComparator)
		throws NoSuchAccountEntryException;

	/**
	 * Returns the first account entry in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account entry, or <code>null</code> if a matching account entry could not be found
	 */
	public AccountEntry fetchByemail_First(
		String email,
		com.liferay.portal.kernel.util.OrderByComparator<AccountEntry>
			orderByComparator);

	/**
	 * Returns the last account entry in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account entry
	 * @throws NoSuchAccountEntryException if a matching account entry could not be found
	 */
	public AccountEntry findByemail_Last(
			String email,
			com.liferay.portal.kernel.util.OrderByComparator<AccountEntry>
				orderByComparator)
		throws NoSuchAccountEntryException;

	/**
	 * Returns the last account entry in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account entry, or <code>null</code> if a matching account entry could not be found
	 */
	public AccountEntry fetchByemail_Last(
		String email,
		com.liferay.portal.kernel.util.OrderByComparator<AccountEntry>
			orderByComparator);

	/**
	 * Returns the account entries before and after the current account entry in the ordered set where email = &#63;.
	 *
	 * @param accountId the primary key of the current account entry
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account entry
	 * @throws NoSuchAccountEntryException if a account entry with the primary key could not be found
	 */
	public AccountEntry[] findByemail_PrevAndNext(
			long accountId, String email,
			com.liferay.portal.kernel.util.OrderByComparator<AccountEntry>
				orderByComparator)
		throws NoSuchAccountEntryException;

	/**
	 * Removes all the account entries where email = &#63; from the database.
	 *
	 * @param email the email
	 */
	public void removeByemail(String email);

	/**
	 * Returns the number of account entries where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching account entries
	 */
	public int countByemail(String email);

	/**
	 * Caches the account entry in the entity cache if it is enabled.
	 *
	 * @param accountEntry the account entry
	 */
	public void cacheResult(AccountEntry accountEntry);

	/**
	 * Caches the account entries in the entity cache if it is enabled.
	 *
	 * @param accountEntries the account entries
	 */
	public void cacheResult(java.util.List<AccountEntry> accountEntries);

	/**
	 * Creates a new account entry with the primary key. Does not add the account entry to the database.
	 *
	 * @param accountId the primary key for the new account entry
	 * @return the new account entry
	 */
	public AccountEntry create(long accountId);

	/**
	 * Removes the account entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param accountId the primary key of the account entry
	 * @return the account entry that was removed
	 * @throws NoSuchAccountEntryException if a account entry with the primary key could not be found
	 */
	public AccountEntry remove(long accountId)
		throws NoSuchAccountEntryException;

	public AccountEntry updateImpl(AccountEntry accountEntry);

	/**
	 * Returns the account entry with the primary key or throws a <code>NoSuchAccountEntryException</code> if it could not be found.
	 *
	 * @param accountId the primary key of the account entry
	 * @return the account entry
	 * @throws NoSuchAccountEntryException if a account entry with the primary key could not be found
	 */
	public AccountEntry findByPrimaryKey(long accountId)
		throws NoSuchAccountEntryException;

	/**
	 * Returns the account entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param accountId the primary key of the account entry
	 * @return the account entry, or <code>null</code> if a account entry with the primary key could not be found
	 */
	public AccountEntry fetchByPrimaryKey(long accountId);

	/**
	 * Returns all the account entries.
	 *
	 * @return the account entries
	 */
	public java.util.List<AccountEntry> findAll();

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
	public java.util.List<AccountEntry> findAll(int start, int end);

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
	public java.util.List<AccountEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AccountEntry>
			orderByComparator);

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
	public java.util.List<AccountEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AccountEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the account entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of account entries.
	 *
	 * @return the number of account entries
	 */
	public int countAll();

}