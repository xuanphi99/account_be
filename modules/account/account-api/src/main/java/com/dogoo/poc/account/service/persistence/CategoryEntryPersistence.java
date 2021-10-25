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

import com.dogoo.poc.account.exception.NoSuchCategoryEntryException;
import com.dogoo.poc.account.model.CategoryEntry;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the category entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CategoryEntryUtil
 * @generated
 */
@ProviderType
public interface CategoryEntryPersistence
	extends BasePersistence<CategoryEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CategoryEntryUtil} to access the category entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the category entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching category entries
	 */
	public java.util.List<CategoryEntry> findByUuid(String uuid);

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
	public java.util.List<CategoryEntry> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<CategoryEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CategoryEntry>
			orderByComparator);

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
	public java.util.List<CategoryEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CategoryEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first category entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category entry
	 * @throws NoSuchCategoryEntryException if a matching category entry could not be found
	 */
	public CategoryEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CategoryEntry>
				orderByComparator)
		throws NoSuchCategoryEntryException;

	/**
	 * Returns the first category entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category entry, or <code>null</code> if a matching category entry could not be found
	 */
	public CategoryEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CategoryEntry>
			orderByComparator);

	/**
	 * Returns the last category entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category entry
	 * @throws NoSuchCategoryEntryException if a matching category entry could not be found
	 */
	public CategoryEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CategoryEntry>
				orderByComparator)
		throws NoSuchCategoryEntryException;

	/**
	 * Returns the last category entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category entry, or <code>null</code> if a matching category entry could not be found
	 */
	public CategoryEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CategoryEntry>
			orderByComparator);

	/**
	 * Returns the category entries before and after the current category entry in the ordered set where uuid = &#63;.
	 *
	 * @param categoryId the primary key of the current category entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category entry
	 * @throws NoSuchCategoryEntryException if a category entry with the primary key could not be found
	 */
	public CategoryEntry[] findByUuid_PrevAndNext(
			long categoryId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CategoryEntry>
				orderByComparator)
		throws NoSuchCategoryEntryException;

	/**
	 * Removes all the category entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of category entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching category entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the category entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCategoryEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching category entry
	 * @throws NoSuchCategoryEntryException if a matching category entry could not be found
	 */
	public CategoryEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchCategoryEntryException;

	/**
	 * Returns the category entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching category entry, or <code>null</code> if a matching category entry could not be found
	 */
	public CategoryEntry fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the category entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching category entry, or <code>null</code> if a matching category entry could not be found
	 */
	public CategoryEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the category entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the category entry that was removed
	 */
	public CategoryEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchCategoryEntryException;

	/**
	 * Returns the number of category entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching category entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the category entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching category entries
	 */
	public java.util.List<CategoryEntry> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<CategoryEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<CategoryEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CategoryEntry>
			orderByComparator);

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
	public java.util.List<CategoryEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CategoryEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first category entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category entry
	 * @throws NoSuchCategoryEntryException if a matching category entry could not be found
	 */
	public CategoryEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CategoryEntry>
				orderByComparator)
		throws NoSuchCategoryEntryException;

	/**
	 * Returns the first category entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category entry, or <code>null</code> if a matching category entry could not be found
	 */
	public CategoryEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CategoryEntry>
			orderByComparator);

	/**
	 * Returns the last category entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category entry
	 * @throws NoSuchCategoryEntryException if a matching category entry could not be found
	 */
	public CategoryEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CategoryEntry>
				orderByComparator)
		throws NoSuchCategoryEntryException;

	/**
	 * Returns the last category entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category entry, or <code>null</code> if a matching category entry could not be found
	 */
	public CategoryEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CategoryEntry>
			orderByComparator);

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
	public CategoryEntry[] findByUuid_C_PrevAndNext(
			long categoryId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CategoryEntry>
				orderByComparator)
		throws NoSuchCategoryEntryException;

	/**
	 * Removes all the category entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of category entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching category entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the category entries where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching category entries
	 */
	public java.util.List<CategoryEntry> findBytype(String type);

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
	public java.util.List<CategoryEntry> findBytype(
		String type, int start, int end);

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
	public java.util.List<CategoryEntry> findBytype(
		String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CategoryEntry>
			orderByComparator);

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
	public java.util.List<CategoryEntry> findBytype(
		String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CategoryEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first category entry in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category entry
	 * @throws NoSuchCategoryEntryException if a matching category entry could not be found
	 */
	public CategoryEntry findBytype_First(
			String type,
			com.liferay.portal.kernel.util.OrderByComparator<CategoryEntry>
				orderByComparator)
		throws NoSuchCategoryEntryException;

	/**
	 * Returns the first category entry in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category entry, or <code>null</code> if a matching category entry could not be found
	 */
	public CategoryEntry fetchBytype_First(
		String type,
		com.liferay.portal.kernel.util.OrderByComparator<CategoryEntry>
			orderByComparator);

	/**
	 * Returns the last category entry in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category entry
	 * @throws NoSuchCategoryEntryException if a matching category entry could not be found
	 */
	public CategoryEntry findBytype_Last(
			String type,
			com.liferay.portal.kernel.util.OrderByComparator<CategoryEntry>
				orderByComparator)
		throws NoSuchCategoryEntryException;

	/**
	 * Returns the last category entry in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category entry, or <code>null</code> if a matching category entry could not be found
	 */
	public CategoryEntry fetchBytype_Last(
		String type,
		com.liferay.portal.kernel.util.OrderByComparator<CategoryEntry>
			orderByComparator);

	/**
	 * Returns the category entries before and after the current category entry in the ordered set where type = &#63;.
	 *
	 * @param categoryId the primary key of the current category entry
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category entry
	 * @throws NoSuchCategoryEntryException if a category entry with the primary key could not be found
	 */
	public CategoryEntry[] findBytype_PrevAndNext(
			long categoryId, String type,
			com.liferay.portal.kernel.util.OrderByComparator<CategoryEntry>
				orderByComparator)
		throws NoSuchCategoryEntryException;

	/**
	 * Removes all the category entries where type = &#63; from the database.
	 *
	 * @param type the type
	 */
	public void removeBytype(String type);

	/**
	 * Returns the number of category entries where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching category entries
	 */
	public int countBytype(String type);

	/**
	 * Returns all the category entries where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching category entries
	 */
	public java.util.List<CategoryEntry> findBycode(int code);

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
	public java.util.List<CategoryEntry> findBycode(
		int code, int start, int end);

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
	public java.util.List<CategoryEntry> findBycode(
		int code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CategoryEntry>
			orderByComparator);

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
	public java.util.List<CategoryEntry> findBycode(
		int code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CategoryEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first category entry in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category entry
	 * @throws NoSuchCategoryEntryException if a matching category entry could not be found
	 */
	public CategoryEntry findBycode_First(
			int code,
			com.liferay.portal.kernel.util.OrderByComparator<CategoryEntry>
				orderByComparator)
		throws NoSuchCategoryEntryException;

	/**
	 * Returns the first category entry in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category entry, or <code>null</code> if a matching category entry could not be found
	 */
	public CategoryEntry fetchBycode_First(
		int code,
		com.liferay.portal.kernel.util.OrderByComparator<CategoryEntry>
			orderByComparator);

	/**
	 * Returns the last category entry in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category entry
	 * @throws NoSuchCategoryEntryException if a matching category entry could not be found
	 */
	public CategoryEntry findBycode_Last(
			int code,
			com.liferay.portal.kernel.util.OrderByComparator<CategoryEntry>
				orderByComparator)
		throws NoSuchCategoryEntryException;

	/**
	 * Returns the last category entry in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category entry, or <code>null</code> if a matching category entry could not be found
	 */
	public CategoryEntry fetchBycode_Last(
		int code,
		com.liferay.portal.kernel.util.OrderByComparator<CategoryEntry>
			orderByComparator);

	/**
	 * Returns the category entries before and after the current category entry in the ordered set where code = &#63;.
	 *
	 * @param categoryId the primary key of the current category entry
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category entry
	 * @throws NoSuchCategoryEntryException if a category entry with the primary key could not be found
	 */
	public CategoryEntry[] findBycode_PrevAndNext(
			long categoryId, int code,
			com.liferay.portal.kernel.util.OrderByComparator<CategoryEntry>
				orderByComparator)
		throws NoSuchCategoryEntryException;

	/**
	 * Removes all the category entries where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public void removeBycode(int code);

	/**
	 * Returns the number of category entries where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching category entries
	 */
	public int countBycode(int code);

	/**
	 * Returns the category entry where code = &#63; and type = &#63; or throws a <code>NoSuchCategoryEntryException</code> if it could not be found.
	 *
	 * @param code the code
	 * @param type the type
	 * @return the matching category entry
	 * @throws NoSuchCategoryEntryException if a matching category entry could not be found
	 */
	public CategoryEntry findByCodeAndType(int code, String type)
		throws NoSuchCategoryEntryException;

	/**
	 * Returns the category entry where code = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @param type the type
	 * @return the matching category entry, or <code>null</code> if a matching category entry could not be found
	 */
	public CategoryEntry fetchByCodeAndType(int code, String type);

	/**
	 * Returns the category entry where code = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param type the type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching category entry, or <code>null</code> if a matching category entry could not be found
	 */
	public CategoryEntry fetchByCodeAndType(
		int code, String type, boolean useFinderCache);

	/**
	 * Removes the category entry where code = &#63; and type = &#63; from the database.
	 *
	 * @param code the code
	 * @param type the type
	 * @return the category entry that was removed
	 */
	public CategoryEntry removeByCodeAndType(int code, String type)
		throws NoSuchCategoryEntryException;

	/**
	 * Returns the number of category entries where code = &#63; and type = &#63;.
	 *
	 * @param code the code
	 * @param type the type
	 * @return the number of matching category entries
	 */
	public int countByCodeAndType(int code, String type);

	/**
	 * Caches the category entry in the entity cache if it is enabled.
	 *
	 * @param categoryEntry the category entry
	 */
	public void cacheResult(CategoryEntry categoryEntry);

	/**
	 * Caches the category entries in the entity cache if it is enabled.
	 *
	 * @param categoryEntries the category entries
	 */
	public void cacheResult(java.util.List<CategoryEntry> categoryEntries);

	/**
	 * Creates a new category entry with the primary key. Does not add the category entry to the database.
	 *
	 * @param categoryId the primary key for the new category entry
	 * @return the new category entry
	 */
	public CategoryEntry create(long categoryId);

	/**
	 * Removes the category entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the category entry
	 * @return the category entry that was removed
	 * @throws NoSuchCategoryEntryException if a category entry with the primary key could not be found
	 */
	public CategoryEntry remove(long categoryId)
		throws NoSuchCategoryEntryException;

	public CategoryEntry updateImpl(CategoryEntry categoryEntry);

	/**
	 * Returns the category entry with the primary key or throws a <code>NoSuchCategoryEntryException</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the category entry
	 * @return the category entry
	 * @throws NoSuchCategoryEntryException if a category entry with the primary key could not be found
	 */
	public CategoryEntry findByPrimaryKey(long categoryId)
		throws NoSuchCategoryEntryException;

	/**
	 * Returns the category entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the category entry
	 * @return the category entry, or <code>null</code> if a category entry with the primary key could not be found
	 */
	public CategoryEntry fetchByPrimaryKey(long categoryId);

	/**
	 * Returns all the category entries.
	 *
	 * @return the category entries
	 */
	public java.util.List<CategoryEntry> findAll();

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
	public java.util.List<CategoryEntry> findAll(int start, int end);

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
	public java.util.List<CategoryEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CategoryEntry>
			orderByComparator);

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
	public java.util.List<CategoryEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CategoryEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the category entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of category entries.
	 *
	 * @return the number of category entries
	 */
	public int countAll();

	/**
	 * Returns the primaryKeys of account entries associated with the category entry.
	 *
	 * @param pk the primary key of the category entry
	 * @return long[] of the primaryKeys of account entries associated with the category entry
	 */
	public long[] getAccountEntryPrimaryKeys(long pk);

	/**
	 * Returns all the category entry associated with the account entry.
	 *
	 * @param pk the primary key of the account entry
	 * @return the category entries associated with the account entry
	 */
	public java.util.List<CategoryEntry> getAccountEntryCategoryEntries(
		long pk);

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
	public java.util.List<CategoryEntry> getAccountEntryCategoryEntries(
		long pk, int start, int end);

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
	public java.util.List<CategoryEntry> getAccountEntryCategoryEntries(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CategoryEntry>
			orderByComparator);

	/**
	 * Returns the number of account entries associated with the category entry.
	 *
	 * @param pk the primary key of the category entry
	 * @return the number of account entries associated with the category entry
	 */
	public int getAccountEntriesSize(long pk);

	/**
	 * Returns <code>true</code> if the account entry is associated with the category entry.
	 *
	 * @param pk the primary key of the category entry
	 * @param accountEntryPK the primary key of the account entry
	 * @return <code>true</code> if the account entry is associated with the category entry; <code>false</code> otherwise
	 */
	public boolean containsAccountEntry(long pk, long accountEntryPK);

	/**
	 * Returns <code>true</code> if the category entry has any account entries associated with it.
	 *
	 * @param pk the primary key of the category entry to check for associations with account entries
	 * @return <code>true</code> if the category entry has any account entries associated with it; <code>false</code> otherwise
	 */
	public boolean containsAccountEntries(long pk);

	/**
	 * Adds an association between the category entry and the account entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the category entry
	 * @param accountEntryPK the primary key of the account entry
	 */
	public void addAccountEntry(long pk, long accountEntryPK);

	/**
	 * Adds an association between the category entry and the account entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the category entry
	 * @param accountEntry the account entry
	 */
	public void addAccountEntry(
		long pk, com.dogoo.poc.account.model.AccountEntry accountEntry);

	/**
	 * Adds an association between the category entry and the account entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the category entry
	 * @param accountEntryPKs the primary keys of the account entries
	 */
	public void addAccountEntries(long pk, long[] accountEntryPKs);

	/**
	 * Adds an association between the category entry and the account entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the category entry
	 * @param accountEntries the account entries
	 */
	public void addAccountEntries(
		long pk,
		java.util.List<com.dogoo.poc.account.model.AccountEntry>
			accountEntries);

	/**
	 * Clears all associations between the category entry and its account entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the category entry to clear the associated account entries from
	 */
	public void clearAccountEntries(long pk);

	/**
	 * Removes the association between the category entry and the account entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the category entry
	 * @param accountEntryPK the primary key of the account entry
	 */
	public void removeAccountEntry(long pk, long accountEntryPK);

	/**
	 * Removes the association between the category entry and the account entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the category entry
	 * @param accountEntry the account entry
	 */
	public void removeAccountEntry(
		long pk, com.dogoo.poc.account.model.AccountEntry accountEntry);

	/**
	 * Removes the association between the category entry and the account entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the category entry
	 * @param accountEntryPKs the primary keys of the account entries
	 */
	public void removeAccountEntries(long pk, long[] accountEntryPKs);

	/**
	 * Removes the association between the category entry and the account entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the category entry
	 * @param accountEntries the account entries
	 */
	public void removeAccountEntries(
		long pk,
		java.util.List<com.dogoo.poc.account.model.AccountEntry>
			accountEntries);

	/**
	 * Sets the account entries associated with the category entry, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the category entry
	 * @param accountEntryPKs the primary keys of the account entries to be associated with the category entry
	 */
	public void setAccountEntries(long pk, long[] accountEntryPKs);

	/**
	 * Sets the account entries associated with the category entry, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the category entry
	 * @param accountEntries the account entries to be associated with the category entry
	 */
	public void setAccountEntries(
		long pk,
		java.util.List<com.dogoo.poc.account.model.AccountEntry>
			accountEntries);

}