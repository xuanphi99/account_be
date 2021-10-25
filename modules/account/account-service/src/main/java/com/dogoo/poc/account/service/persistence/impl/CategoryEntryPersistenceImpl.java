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

package com.dogoo.poc.account.service.persistence.impl;

import com.dogoo.poc.account.exception.NoSuchCategoryEntryException;
import com.dogoo.poc.account.model.AccountEntry;
import com.dogoo.poc.account.model.CategoryEntry;
import com.dogoo.poc.account.model.CategoryEntryTable;
import com.dogoo.poc.account.model.impl.CategoryEntryImpl;
import com.dogoo.poc.account.model.impl.CategoryEntryModelImpl;
import com.dogoo.poc.account.service.persistence.CategoryEntryPersistence;
import com.dogoo.poc.account.service.persistence.impl.constants.DGPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.service.persistence.impl.TableMapper;
import com.liferay.portal.kernel.service.persistence.impl.TableMapperFactory;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the category entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {CategoryEntryPersistence.class, BasePersistence.class})
public class CategoryEntryPersistenceImpl
	extends BasePersistenceImpl<CategoryEntry>
	implements CategoryEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CategoryEntryUtil</code> to access the category entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CategoryEntryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the category entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching category entries
	 */
	@Override
	public List<CategoryEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CategoryEntry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<CategoryEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CategoryEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<CategoryEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CategoryEntry> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<CategoryEntry> list = null;

		if (useFinderCache) {
			list = (List<CategoryEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CategoryEntry categoryEntry : list) {
					if (!uuid.equals(categoryEntry.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_CATEGORYENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CategoryEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<CategoryEntry>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first category entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category entry
	 * @throws NoSuchCategoryEntryException if a matching category entry could not be found
	 */
	@Override
	public CategoryEntry findByUuid_First(
			String uuid, OrderByComparator<CategoryEntry> orderByComparator)
		throws NoSuchCategoryEntryException {

		CategoryEntry categoryEntry = fetchByUuid_First(
			uuid, orderByComparator);

		if (categoryEntry != null) {
			return categoryEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCategoryEntryException(sb.toString());
	}

	/**
	 * Returns the first category entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category entry, or <code>null</code> if a matching category entry could not be found
	 */
	@Override
	public CategoryEntry fetchByUuid_First(
		String uuid, OrderByComparator<CategoryEntry> orderByComparator) {

		List<CategoryEntry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last category entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category entry
	 * @throws NoSuchCategoryEntryException if a matching category entry could not be found
	 */
	@Override
	public CategoryEntry findByUuid_Last(
			String uuid, OrderByComparator<CategoryEntry> orderByComparator)
		throws NoSuchCategoryEntryException {

		CategoryEntry categoryEntry = fetchByUuid_Last(uuid, orderByComparator);

		if (categoryEntry != null) {
			return categoryEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCategoryEntryException(sb.toString());
	}

	/**
	 * Returns the last category entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category entry, or <code>null</code> if a matching category entry could not be found
	 */
	@Override
	public CategoryEntry fetchByUuid_Last(
		String uuid, OrderByComparator<CategoryEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CategoryEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CategoryEntry[] findByUuid_PrevAndNext(
			long categoryId, String uuid,
			OrderByComparator<CategoryEntry> orderByComparator)
		throws NoSuchCategoryEntryException {

		uuid = Objects.toString(uuid, "");

		CategoryEntry categoryEntry = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			CategoryEntry[] array = new CategoryEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, categoryEntry, uuid, orderByComparator, true);

			array[1] = categoryEntry;

			array[2] = getByUuid_PrevAndNext(
				session, categoryEntry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CategoryEntry getByUuid_PrevAndNext(
		Session session, CategoryEntry categoryEntry, String uuid,
		OrderByComparator<CategoryEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CATEGORYENTRY_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CategoryEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						categoryEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CategoryEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the category entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CategoryEntry categoryEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(categoryEntry);
		}
	}

	/**
	 * Returns the number of category entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching category entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CATEGORYENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"categoryEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(categoryEntry.uuid IS NULL OR categoryEntry.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the category entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCategoryEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching category entry
	 * @throws NoSuchCategoryEntryException if a matching category entry could not be found
	 */
	@Override
	public CategoryEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchCategoryEntryException {

		CategoryEntry categoryEntry = fetchByUUID_G(uuid, groupId);

		if (categoryEntry == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCategoryEntryException(sb.toString());
		}

		return categoryEntry;
	}

	/**
	 * Returns the category entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching category entry, or <code>null</code> if a matching category entry could not be found
	 */
	@Override
	public CategoryEntry fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the category entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching category entry, or <code>null</code> if a matching category entry could not be found
	 */
	@Override
	public CategoryEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs);
		}

		if (result instanceof CategoryEntry) {
			CategoryEntry categoryEntry = (CategoryEntry)result;

			if (!Objects.equals(uuid, categoryEntry.getUuid()) ||
				(groupId != categoryEntry.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CATEGORYENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<CategoryEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					CategoryEntry categoryEntry = list.get(0);

					result = categoryEntry;

					cacheResult(categoryEntry);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (CategoryEntry)result;
		}
	}

	/**
	 * Removes the category entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the category entry that was removed
	 */
	@Override
	public CategoryEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchCategoryEntryException {

		CategoryEntry categoryEntry = findByUUID_G(uuid, groupId);

		return remove(categoryEntry);
	}

	/**
	 * Returns the number of category entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching category entries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CATEGORYENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"categoryEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(categoryEntry.uuid IS NULL OR categoryEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"categoryEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the category entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching category entries
	 */
	@Override
	public List<CategoryEntry> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CategoryEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<CategoryEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CategoryEntry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<CategoryEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CategoryEntry> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<CategoryEntry> list = null;

		if (useFinderCache) {
			list = (List<CategoryEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CategoryEntry categoryEntry : list) {
					if (!uuid.equals(categoryEntry.getUuid()) ||
						(companyId != categoryEntry.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_CATEGORYENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CategoryEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<CategoryEntry>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public CategoryEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CategoryEntry> orderByComparator)
		throws NoSuchCategoryEntryException {

		CategoryEntry categoryEntry = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (categoryEntry != null) {
			return categoryEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCategoryEntryException(sb.toString());
	}

	/**
	 * Returns the first category entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category entry, or <code>null</code> if a matching category entry could not be found
	 */
	@Override
	public CategoryEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CategoryEntry> orderByComparator) {

		List<CategoryEntry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CategoryEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CategoryEntry> orderByComparator)
		throws NoSuchCategoryEntryException {

		CategoryEntry categoryEntry = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (categoryEntry != null) {
			return categoryEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCategoryEntryException(sb.toString());
	}

	/**
	 * Returns the last category entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category entry, or <code>null</code> if a matching category entry could not be found
	 */
	@Override
	public CategoryEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CategoryEntry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<CategoryEntry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CategoryEntry[] findByUuid_C_PrevAndNext(
			long categoryId, String uuid, long companyId,
			OrderByComparator<CategoryEntry> orderByComparator)
		throws NoSuchCategoryEntryException {

		uuid = Objects.toString(uuid, "");

		CategoryEntry categoryEntry = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			CategoryEntry[] array = new CategoryEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, categoryEntry, uuid, companyId, orderByComparator,
				true);

			array[1] = categoryEntry;

			array[2] = getByUuid_C_PrevAndNext(
				session, categoryEntry, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CategoryEntry getByUuid_C_PrevAndNext(
		Session session, CategoryEntry categoryEntry, String uuid,
		long companyId, OrderByComparator<CategoryEntry> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CATEGORYENTRY_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CategoryEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						categoryEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CategoryEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the category entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (CategoryEntry categoryEntry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(categoryEntry);
		}
	}

	/**
	 * Returns the number of category entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching category entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CATEGORYENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"categoryEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(categoryEntry.uuid IS NULL OR categoryEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"categoryEntry.companyId = ?";

	private FinderPath _finderPathWithPaginationFindBytype;
	private FinderPath _finderPathWithoutPaginationFindBytype;
	private FinderPath _finderPathCountBytype;

	/**
	 * Returns all the category entries where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching category entries
	 */
	@Override
	public List<CategoryEntry> findBytype(String type) {
		return findBytype(type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CategoryEntry> findBytype(String type, int start, int end) {
		return findBytype(type, start, end, null);
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
	@Override
	public List<CategoryEntry> findBytype(
		String type, int start, int end,
		OrderByComparator<CategoryEntry> orderByComparator) {

		return findBytype(type, start, end, orderByComparator, true);
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
	@Override
	public List<CategoryEntry> findBytype(
		String type, int start, int end,
		OrderByComparator<CategoryEntry> orderByComparator,
		boolean useFinderCache) {

		type = Objects.toString(type, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBytype;
				finderArgs = new Object[] {type};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBytype;
			finderArgs = new Object[] {type, start, end, orderByComparator};
		}

		List<CategoryEntry> list = null;

		if (useFinderCache) {
			list = (List<CategoryEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CategoryEntry categoryEntry : list) {
					if (!type.equals(categoryEntry.getType())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_CATEGORYENTRY_WHERE);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_TYPE_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_TYPE_TYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CategoryEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindType) {
					queryPos.add(type);
				}

				list = (List<CategoryEntry>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first category entry in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category entry
	 * @throws NoSuchCategoryEntryException if a matching category entry could not be found
	 */
	@Override
	public CategoryEntry findBytype_First(
			String type, OrderByComparator<CategoryEntry> orderByComparator)
		throws NoSuchCategoryEntryException {

		CategoryEntry categoryEntry = fetchBytype_First(
			type, orderByComparator);

		if (categoryEntry != null) {
			return categoryEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchCategoryEntryException(sb.toString());
	}

	/**
	 * Returns the first category entry in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category entry, or <code>null</code> if a matching category entry could not be found
	 */
	@Override
	public CategoryEntry fetchBytype_First(
		String type, OrderByComparator<CategoryEntry> orderByComparator) {

		List<CategoryEntry> list = findBytype(type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last category entry in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category entry
	 * @throws NoSuchCategoryEntryException if a matching category entry could not be found
	 */
	@Override
	public CategoryEntry findBytype_Last(
			String type, OrderByComparator<CategoryEntry> orderByComparator)
		throws NoSuchCategoryEntryException {

		CategoryEntry categoryEntry = fetchBytype_Last(type, orderByComparator);

		if (categoryEntry != null) {
			return categoryEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchCategoryEntryException(sb.toString());
	}

	/**
	 * Returns the last category entry in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category entry, or <code>null</code> if a matching category entry could not be found
	 */
	@Override
	public CategoryEntry fetchBytype_Last(
		String type, OrderByComparator<CategoryEntry> orderByComparator) {

		int count = countBytype(type);

		if (count == 0) {
			return null;
		}

		List<CategoryEntry> list = findBytype(
			type, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CategoryEntry[] findBytype_PrevAndNext(
			long categoryId, String type,
			OrderByComparator<CategoryEntry> orderByComparator)
		throws NoSuchCategoryEntryException {

		type = Objects.toString(type, "");

		CategoryEntry categoryEntry = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			CategoryEntry[] array = new CategoryEntryImpl[3];

			array[0] = getBytype_PrevAndNext(
				session, categoryEntry, type, orderByComparator, true);

			array[1] = categoryEntry;

			array[2] = getBytype_PrevAndNext(
				session, categoryEntry, type, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CategoryEntry getBytype_PrevAndNext(
		Session session, CategoryEntry categoryEntry, String type,
		OrderByComparator<CategoryEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CATEGORYENTRY_WHERE);

		boolean bindType = false;

		if (type.isEmpty()) {
			sb.append(_FINDER_COLUMN_TYPE_TYPE_3);
		}
		else {
			bindType = true;

			sb.append(_FINDER_COLUMN_TYPE_TYPE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CategoryEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindType) {
			queryPos.add(type);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						categoryEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CategoryEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the category entries where type = &#63; from the database.
	 *
	 * @param type the type
	 */
	@Override
	public void removeBytype(String type) {
		for (CategoryEntry categoryEntry :
				findBytype(type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(categoryEntry);
		}
	}

	/**
	 * Returns the number of category entries where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching category entries
	 */
	@Override
	public int countBytype(String type) {
		type = Objects.toString(type, "");

		FinderPath finderPath = _finderPathCountBytype;

		Object[] finderArgs = new Object[] {type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CATEGORYENTRY_WHERE);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_TYPE_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_TYPE_TYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindType) {
					queryPos.add(type);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TYPE_TYPE_2 =
		"categoryEntry.type = ?";

	private static final String _FINDER_COLUMN_TYPE_TYPE_3 =
		"(categoryEntry.type IS NULL OR categoryEntry.type = '')";

	private FinderPath _finderPathWithPaginationFindBycode;
	private FinderPath _finderPathWithoutPaginationFindBycode;
	private FinderPath _finderPathCountBycode;

	/**
	 * Returns all the category entries where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching category entries
	 */
	@Override
	public List<CategoryEntry> findBycode(int code) {
		return findBycode(code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CategoryEntry> findBycode(int code, int start, int end) {
		return findBycode(code, start, end, null);
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
	@Override
	public List<CategoryEntry> findBycode(
		int code, int start, int end,
		OrderByComparator<CategoryEntry> orderByComparator) {

		return findBycode(code, start, end, orderByComparator, true);
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
	@Override
	public List<CategoryEntry> findBycode(
		int code, int start, int end,
		OrderByComparator<CategoryEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBycode;
				finderArgs = new Object[] {code};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBycode;
			finderArgs = new Object[] {code, start, end, orderByComparator};
		}

		List<CategoryEntry> list = null;

		if (useFinderCache) {
			list = (List<CategoryEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CategoryEntry categoryEntry : list) {
					if (code != categoryEntry.getCode()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_CATEGORYENTRY_WHERE);

			sb.append(_FINDER_COLUMN_CODE_CODE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CategoryEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(code);

				list = (List<CategoryEntry>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first category entry in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category entry
	 * @throws NoSuchCategoryEntryException if a matching category entry could not be found
	 */
	@Override
	public CategoryEntry findBycode_First(
			int code, OrderByComparator<CategoryEntry> orderByComparator)
		throws NoSuchCategoryEntryException {

		CategoryEntry categoryEntry = fetchBycode_First(
			code, orderByComparator);

		if (categoryEntry != null) {
			return categoryEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("code=");
		sb.append(code);

		sb.append("}");

		throw new NoSuchCategoryEntryException(sb.toString());
	}

	/**
	 * Returns the first category entry in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category entry, or <code>null</code> if a matching category entry could not be found
	 */
	@Override
	public CategoryEntry fetchBycode_First(
		int code, OrderByComparator<CategoryEntry> orderByComparator) {

		List<CategoryEntry> list = findBycode(code, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last category entry in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category entry
	 * @throws NoSuchCategoryEntryException if a matching category entry could not be found
	 */
	@Override
	public CategoryEntry findBycode_Last(
			int code, OrderByComparator<CategoryEntry> orderByComparator)
		throws NoSuchCategoryEntryException {

		CategoryEntry categoryEntry = fetchBycode_Last(code, orderByComparator);

		if (categoryEntry != null) {
			return categoryEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("code=");
		sb.append(code);

		sb.append("}");

		throw new NoSuchCategoryEntryException(sb.toString());
	}

	/**
	 * Returns the last category entry in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category entry, or <code>null</code> if a matching category entry could not be found
	 */
	@Override
	public CategoryEntry fetchBycode_Last(
		int code, OrderByComparator<CategoryEntry> orderByComparator) {

		int count = countBycode(code);

		if (count == 0) {
			return null;
		}

		List<CategoryEntry> list = findBycode(
			code, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CategoryEntry[] findBycode_PrevAndNext(
			long categoryId, int code,
			OrderByComparator<CategoryEntry> orderByComparator)
		throws NoSuchCategoryEntryException {

		CategoryEntry categoryEntry = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			CategoryEntry[] array = new CategoryEntryImpl[3];

			array[0] = getBycode_PrevAndNext(
				session, categoryEntry, code, orderByComparator, true);

			array[1] = categoryEntry;

			array[2] = getBycode_PrevAndNext(
				session, categoryEntry, code, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CategoryEntry getBycode_PrevAndNext(
		Session session, CategoryEntry categoryEntry, int code,
		OrderByComparator<CategoryEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CATEGORYENTRY_WHERE);

		sb.append(_FINDER_COLUMN_CODE_CODE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CategoryEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(code);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						categoryEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CategoryEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the category entries where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	@Override
	public void removeBycode(int code) {
		for (CategoryEntry categoryEntry :
				findBycode(code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(categoryEntry);
		}
	}

	/**
	 * Returns the number of category entries where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching category entries
	 */
	@Override
	public int countBycode(int code) {
		FinderPath finderPath = _finderPathCountBycode;

		Object[] finderArgs = new Object[] {code};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CATEGORYENTRY_WHERE);

			sb.append(_FINDER_COLUMN_CODE_CODE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(code);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CODE_CODE_2 =
		"categoryEntry.code = ?";

	private FinderPath _finderPathFetchByCodeAndType;
	private FinderPath _finderPathCountByCodeAndType;

	/**
	 * Returns the category entry where code = &#63; and type = &#63; or throws a <code>NoSuchCategoryEntryException</code> if it could not be found.
	 *
	 * @param code the code
	 * @param type the type
	 * @return the matching category entry
	 * @throws NoSuchCategoryEntryException if a matching category entry could not be found
	 */
	@Override
	public CategoryEntry findByCodeAndType(int code, String type)
		throws NoSuchCategoryEntryException {

		CategoryEntry categoryEntry = fetchByCodeAndType(code, type);

		if (categoryEntry == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("code=");
			sb.append(code);

			sb.append(", type=");
			sb.append(type);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCategoryEntryException(sb.toString());
		}

		return categoryEntry;
	}

	/**
	 * Returns the category entry where code = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @param type the type
	 * @return the matching category entry, or <code>null</code> if a matching category entry could not be found
	 */
	@Override
	public CategoryEntry fetchByCodeAndType(int code, String type) {
		return fetchByCodeAndType(code, type, true);
	}

	/**
	 * Returns the category entry where code = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param type the type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching category entry, or <code>null</code> if a matching category entry could not be found
	 */
	@Override
	public CategoryEntry fetchByCodeAndType(
		int code, String type, boolean useFinderCache) {

		type = Objects.toString(type, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {code, type};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByCodeAndType, finderArgs);
		}

		if (result instanceof CategoryEntry) {
			CategoryEntry categoryEntry = (CategoryEntry)result;

			if ((code != categoryEntry.getCode()) ||
				!Objects.equals(type, categoryEntry.getType())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CATEGORYENTRY_WHERE);

			sb.append(_FINDER_COLUMN_CODEANDTYPE_CODE_2);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODEANDTYPE_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_CODEANDTYPE_TYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(code);

				if (bindType) {
					queryPos.add(type);
				}

				List<CategoryEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByCodeAndType, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {code, type};
							}

							_log.warn(
								"CategoryEntryPersistenceImpl.fetchByCodeAndType(int, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					CategoryEntry categoryEntry = list.get(0);

					result = categoryEntry;

					cacheResult(categoryEntry);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (CategoryEntry)result;
		}
	}

	/**
	 * Removes the category entry where code = &#63; and type = &#63; from the database.
	 *
	 * @param code the code
	 * @param type the type
	 * @return the category entry that was removed
	 */
	@Override
	public CategoryEntry removeByCodeAndType(int code, String type)
		throws NoSuchCategoryEntryException {

		CategoryEntry categoryEntry = findByCodeAndType(code, type);

		return remove(categoryEntry);
	}

	/**
	 * Returns the number of category entries where code = &#63; and type = &#63;.
	 *
	 * @param code the code
	 * @param type the type
	 * @return the number of matching category entries
	 */
	@Override
	public int countByCodeAndType(int code, String type) {
		type = Objects.toString(type, "");

		FinderPath finderPath = _finderPathCountByCodeAndType;

		Object[] finderArgs = new Object[] {code, type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CATEGORYENTRY_WHERE);

			sb.append(_FINDER_COLUMN_CODEANDTYPE_CODE_2);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODEANDTYPE_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_CODEANDTYPE_TYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(code);

				if (bindType) {
					queryPos.add(type);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CODEANDTYPE_CODE_2 =
		"categoryEntry.code = ? AND ";

	private static final String _FINDER_COLUMN_CODEANDTYPE_TYPE_2 =
		"categoryEntry.type = ?";

	private static final String _FINDER_COLUMN_CODEANDTYPE_TYPE_3 =
		"(categoryEntry.type IS NULL OR categoryEntry.type = '')";

	public CategoryEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("type", "type_");
		dbColumnNames.put("code", "code_");

		setDBColumnNames(dbColumnNames);

		setModelClass(CategoryEntry.class);

		setModelImplClass(CategoryEntryImpl.class);
		setModelPKClass(long.class);

		setTable(CategoryEntryTable.INSTANCE);
	}

	/**
	 * Caches the category entry in the entity cache if it is enabled.
	 *
	 * @param categoryEntry the category entry
	 */
	@Override
	public void cacheResult(CategoryEntry categoryEntry) {
		entityCache.putResult(
			CategoryEntryImpl.class, categoryEntry.getPrimaryKey(),
			categoryEntry);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {categoryEntry.getUuid(), categoryEntry.getGroupId()},
			categoryEntry);

		finderCache.putResult(
			_finderPathFetchByCodeAndType,
			new Object[] {categoryEntry.getCode(), categoryEntry.getType()},
			categoryEntry);
	}

	/**
	 * Caches the category entries in the entity cache if it is enabled.
	 *
	 * @param categoryEntries the category entries
	 */
	@Override
	public void cacheResult(List<CategoryEntry> categoryEntries) {
		for (CategoryEntry categoryEntry : categoryEntries) {
			if (entityCache.getResult(
					CategoryEntryImpl.class, categoryEntry.getPrimaryKey()) ==
						null) {

				cacheResult(categoryEntry);
			}
		}
	}

	/**
	 * Clears the cache for all category entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CategoryEntryImpl.class);

		finderCache.clearCache(CategoryEntryImpl.class);
	}

	/**
	 * Clears the cache for the category entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CategoryEntry categoryEntry) {
		entityCache.removeResult(CategoryEntryImpl.class, categoryEntry);
	}

	@Override
	public void clearCache(List<CategoryEntry> categoryEntries) {
		for (CategoryEntry categoryEntry : categoryEntries) {
			entityCache.removeResult(CategoryEntryImpl.class, categoryEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(CategoryEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CategoryEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CategoryEntryModelImpl categoryEntryModelImpl) {

		Object[] args = new Object[] {
			categoryEntryModelImpl.getUuid(),
			categoryEntryModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, categoryEntryModelImpl);

		args = new Object[] {
			categoryEntryModelImpl.getCode(), categoryEntryModelImpl.getType()
		};

		finderCache.putResult(
			_finderPathCountByCodeAndType, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByCodeAndType, args, categoryEntryModelImpl);
	}

	/**
	 * Creates a new category entry with the primary key. Does not add the category entry to the database.
	 *
	 * @param categoryId the primary key for the new category entry
	 * @return the new category entry
	 */
	@Override
	public CategoryEntry create(long categoryId) {
		CategoryEntry categoryEntry = new CategoryEntryImpl();

		categoryEntry.setNew(true);
		categoryEntry.setPrimaryKey(categoryId);

		String uuid = PortalUUIDUtil.generate();

		categoryEntry.setUuid(uuid);

		categoryEntry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return categoryEntry;
	}

	/**
	 * Removes the category entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the category entry
	 * @return the category entry that was removed
	 * @throws NoSuchCategoryEntryException if a category entry with the primary key could not be found
	 */
	@Override
	public CategoryEntry remove(long categoryId)
		throws NoSuchCategoryEntryException {

		return remove((Serializable)categoryId);
	}

	/**
	 * Removes the category entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the category entry
	 * @return the category entry that was removed
	 * @throws NoSuchCategoryEntryException if a category entry with the primary key could not be found
	 */
	@Override
	public CategoryEntry remove(Serializable primaryKey)
		throws NoSuchCategoryEntryException {

		Session session = null;

		try {
			session = openSession();

			CategoryEntry categoryEntry = (CategoryEntry)session.get(
				CategoryEntryImpl.class, primaryKey);

			if (categoryEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCategoryEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(categoryEntry);
		}
		catch (NoSuchCategoryEntryException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected CategoryEntry removeImpl(CategoryEntry categoryEntry) {
		categoryEntryToAccountEntryTableMapper.
			deleteLeftPrimaryKeyTableMappings(categoryEntry.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(categoryEntry)) {
				categoryEntry = (CategoryEntry)session.get(
					CategoryEntryImpl.class, categoryEntry.getPrimaryKeyObj());
			}

			if (categoryEntry != null) {
				session.delete(categoryEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (categoryEntry != null) {
			clearCache(categoryEntry);
		}

		return categoryEntry;
	}

	@Override
	public CategoryEntry updateImpl(CategoryEntry categoryEntry) {
		boolean isNew = categoryEntry.isNew();

		if (!(categoryEntry instanceof CategoryEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(categoryEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					categoryEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in categoryEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CategoryEntry implementation " +
					categoryEntry.getClass());
		}

		CategoryEntryModelImpl categoryEntryModelImpl =
			(CategoryEntryModelImpl)categoryEntry;

		if (Validator.isNull(categoryEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			categoryEntry.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (categoryEntry.getCreateDate() == null)) {
			if (serviceContext == null) {
				categoryEntry.setCreateDate(date);
			}
			else {
				categoryEntry.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!categoryEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				categoryEntry.setModifiedDate(date);
			}
			else {
				categoryEntry.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(categoryEntry);
			}
			else {
				categoryEntry = (CategoryEntry)session.merge(categoryEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CategoryEntryImpl.class, categoryEntryModelImpl, false, true);

		cacheUniqueFindersCache(categoryEntryModelImpl);

		if (isNew) {
			categoryEntry.setNew(false);
		}

		categoryEntry.resetOriginalValues();

		return categoryEntry;
	}

	/**
	 * Returns the category entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the category entry
	 * @return the category entry
	 * @throws NoSuchCategoryEntryException if a category entry with the primary key could not be found
	 */
	@Override
	public CategoryEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCategoryEntryException {

		CategoryEntry categoryEntry = fetchByPrimaryKey(primaryKey);

		if (categoryEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCategoryEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return categoryEntry;
	}

	/**
	 * Returns the category entry with the primary key or throws a <code>NoSuchCategoryEntryException</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the category entry
	 * @return the category entry
	 * @throws NoSuchCategoryEntryException if a category entry with the primary key could not be found
	 */
	@Override
	public CategoryEntry findByPrimaryKey(long categoryId)
		throws NoSuchCategoryEntryException {

		return findByPrimaryKey((Serializable)categoryId);
	}

	/**
	 * Returns the category entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the category entry
	 * @return the category entry, or <code>null</code> if a category entry with the primary key could not be found
	 */
	@Override
	public CategoryEntry fetchByPrimaryKey(long categoryId) {
		return fetchByPrimaryKey((Serializable)categoryId);
	}

	/**
	 * Returns all the category entries.
	 *
	 * @return the category entries
	 */
	@Override
	public List<CategoryEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CategoryEntry> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<CategoryEntry> findAll(
		int start, int end,
		OrderByComparator<CategoryEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<CategoryEntry> findAll(
		int start, int end, OrderByComparator<CategoryEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<CategoryEntry> list = null;

		if (useFinderCache) {
			list = (List<CategoryEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CATEGORYENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CATEGORYENTRY;

				sql = sql.concat(CategoryEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CategoryEntry>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the category entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CategoryEntry categoryEntry : findAll()) {
			remove(categoryEntry);
		}
	}

	/**
	 * Returns the number of category entries.
	 *
	 * @return the number of category entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CATEGORYENTRY);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the primaryKeys of account entries associated with the category entry.
	 *
	 * @param pk the primary key of the category entry
	 * @return long[] of the primaryKeys of account entries associated with the category entry
	 */
	@Override
	public long[] getAccountEntryPrimaryKeys(long pk) {
		long[] pks = categoryEntryToAccountEntryTableMapper.getRightPrimaryKeys(
			pk);

		return pks.clone();
	}

	/**
	 * Returns all the category entry associated with the account entry.
	 *
	 * @param pk the primary key of the account entry
	 * @return the category entries associated with the account entry
	 */
	@Override
	public List<CategoryEntry> getAccountEntryCategoryEntries(long pk) {
		return getAccountEntryCategoryEntries(
			pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
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
	@Override
	public List<CategoryEntry> getAccountEntryCategoryEntries(
		long pk, int start, int end) {

		return getAccountEntryCategoryEntries(pk, start, end, null);
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
	@Override
	public List<CategoryEntry> getAccountEntryCategoryEntries(
		long pk, int start, int end,
		OrderByComparator<CategoryEntry> orderByComparator) {

		return categoryEntryToAccountEntryTableMapper.getLeftBaseModels(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of account entries associated with the category entry.
	 *
	 * @param pk the primary key of the category entry
	 * @return the number of account entries associated with the category entry
	 */
	@Override
	public int getAccountEntriesSize(long pk) {
		long[] pks = categoryEntryToAccountEntryTableMapper.getRightPrimaryKeys(
			pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the account entry is associated with the category entry.
	 *
	 * @param pk the primary key of the category entry
	 * @param accountEntryPK the primary key of the account entry
	 * @return <code>true</code> if the account entry is associated with the category entry; <code>false</code> otherwise
	 */
	@Override
	public boolean containsAccountEntry(long pk, long accountEntryPK) {
		return categoryEntryToAccountEntryTableMapper.containsTableMapping(
			pk, accountEntryPK);
	}

	/**
	 * Returns <code>true</code> if the category entry has any account entries associated with it.
	 *
	 * @param pk the primary key of the category entry to check for associations with account entries
	 * @return <code>true</code> if the category entry has any account entries associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containsAccountEntries(long pk) {
		if (getAccountEntriesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the category entry and the account entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the category entry
	 * @param accountEntryPK the primary key of the account entry
	 */
	@Override
	public void addAccountEntry(long pk, long accountEntryPK) {
		CategoryEntry categoryEntry = fetchByPrimaryKey(pk);

		if (categoryEntry == null) {
			categoryEntryToAccountEntryTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, accountEntryPK);
		}
		else {
			categoryEntryToAccountEntryTableMapper.addTableMapping(
				categoryEntry.getCompanyId(), pk, accountEntryPK);
		}
	}

	/**
	 * Adds an association between the category entry and the account entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the category entry
	 * @param accountEntry the account entry
	 */
	@Override
	public void addAccountEntry(long pk, AccountEntry accountEntry) {
		CategoryEntry categoryEntry = fetchByPrimaryKey(pk);

		if (categoryEntry == null) {
			categoryEntryToAccountEntryTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk,
				accountEntry.getPrimaryKey());
		}
		else {
			categoryEntryToAccountEntryTableMapper.addTableMapping(
				categoryEntry.getCompanyId(), pk, accountEntry.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the category entry and the account entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the category entry
	 * @param accountEntryPKs the primary keys of the account entries
	 */
	@Override
	public void addAccountEntries(long pk, long[] accountEntryPKs) {
		long companyId = 0;

		CategoryEntry categoryEntry = fetchByPrimaryKey(pk);

		if (categoryEntry == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = categoryEntry.getCompanyId();
		}

		categoryEntryToAccountEntryTableMapper.addTableMappings(
			companyId, pk, accountEntryPKs);
	}

	/**
	 * Adds an association between the category entry and the account entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the category entry
	 * @param accountEntries the account entries
	 */
	@Override
	public void addAccountEntries(long pk, List<AccountEntry> accountEntries) {
		addAccountEntries(
			pk,
			ListUtil.toLongArray(
				accountEntries, AccountEntry.ACCOUNT_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the category entry and its account entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the category entry to clear the associated account entries from
	 */
	@Override
	public void clearAccountEntries(long pk) {
		categoryEntryToAccountEntryTableMapper.
			deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the category entry and the account entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the category entry
	 * @param accountEntryPK the primary key of the account entry
	 */
	@Override
	public void removeAccountEntry(long pk, long accountEntryPK) {
		categoryEntryToAccountEntryTableMapper.deleteTableMapping(
			pk, accountEntryPK);
	}

	/**
	 * Removes the association between the category entry and the account entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the category entry
	 * @param accountEntry the account entry
	 */
	@Override
	public void removeAccountEntry(long pk, AccountEntry accountEntry) {
		categoryEntryToAccountEntryTableMapper.deleteTableMapping(
			pk, accountEntry.getPrimaryKey());
	}

	/**
	 * Removes the association between the category entry and the account entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the category entry
	 * @param accountEntryPKs the primary keys of the account entries
	 */
	@Override
	public void removeAccountEntries(long pk, long[] accountEntryPKs) {
		categoryEntryToAccountEntryTableMapper.deleteTableMappings(
			pk, accountEntryPKs);
	}

	/**
	 * Removes the association between the category entry and the account entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the category entry
	 * @param accountEntries the account entries
	 */
	@Override
	public void removeAccountEntries(
		long pk, List<AccountEntry> accountEntries) {

		removeAccountEntries(
			pk,
			ListUtil.toLongArray(
				accountEntries, AccountEntry.ACCOUNT_ID_ACCESSOR));
	}

	/**
	 * Sets the account entries associated with the category entry, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the category entry
	 * @param accountEntryPKs the primary keys of the account entries to be associated with the category entry
	 */
	@Override
	public void setAccountEntries(long pk, long[] accountEntryPKs) {
		Set<Long> newAccountEntryPKsSet = SetUtil.fromArray(accountEntryPKs);
		Set<Long> oldAccountEntryPKsSet = SetUtil.fromArray(
			categoryEntryToAccountEntryTableMapper.getRightPrimaryKeys(pk));

		Set<Long> removeAccountEntryPKsSet = new HashSet<Long>(
			oldAccountEntryPKsSet);

		removeAccountEntryPKsSet.removeAll(newAccountEntryPKsSet);

		categoryEntryToAccountEntryTableMapper.deleteTableMappings(
			pk, ArrayUtil.toLongArray(removeAccountEntryPKsSet));

		newAccountEntryPKsSet.removeAll(oldAccountEntryPKsSet);

		long companyId = 0;

		CategoryEntry categoryEntry = fetchByPrimaryKey(pk);

		if (categoryEntry == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = categoryEntry.getCompanyId();
		}

		categoryEntryToAccountEntryTableMapper.addTableMappings(
			companyId, pk, ArrayUtil.toLongArray(newAccountEntryPKsSet));
	}

	/**
	 * Sets the account entries associated with the category entry, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the category entry
	 * @param accountEntries the account entries to be associated with the category entry
	 */
	@Override
	public void setAccountEntries(long pk, List<AccountEntry> accountEntries) {
		try {
			long[] accountEntryPKs = new long[accountEntries.size()];

			for (int i = 0; i < accountEntries.size(); i++) {
				AccountEntry accountEntry = accountEntries.get(i);

				accountEntryPKs[i] = accountEntry.getPrimaryKey();
			}

			setAccountEntries(pk, accountEntryPKs);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "categoryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CATEGORYENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CategoryEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the category entry persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new CategoryEntryModelArgumentsResolver(),
			new HashMapDictionary<>());

		categoryEntryToAccountEntryTableMapper =
			TableMapperFactory.getTableMapper(
				"DG_Account_Category#categoryId", "DG_Account_Category",
				"companyId", "categoryId", "accountId", this,
				AccountEntry.class);

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindBytype = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBytype",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"type_"}, true);

		_finderPathWithoutPaginationFindBytype = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBytype",
			new String[] {String.class.getName()}, new String[] {"type_"},
			true);

		_finderPathCountBytype = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBytype",
			new String[] {String.class.getName()}, new String[] {"type_"},
			false);

		_finderPathWithPaginationFindBycode = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycode",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"code_"}, true);

		_finderPathWithoutPaginationFindBycode = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycode",
			new String[] {Integer.class.getName()}, new String[] {"code_"},
			true);

		_finderPathCountBycode = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycode",
			new String[] {Integer.class.getName()}, new String[] {"code_"},
			false);

		_finderPathFetchByCodeAndType = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByCodeAndType",
			new String[] {Integer.class.getName(), String.class.getName()},
			new String[] {"code_", "type_"}, true);

		_finderPathCountByCodeAndType = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCodeAndType",
			new String[] {Integer.class.getName(), String.class.getName()},
			new String[] {"code_", "type_"}, false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(CategoryEntryImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		TableMapperFactory.removeTableMapper("DG_Account_Category#categoryId");
	}

	@Override
	@Reference(
		target = DGPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = DGPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = DGPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	protected TableMapper<CategoryEntry, AccountEntry>
		categoryEntryToAccountEntryTableMapper;

	private static final String _SQL_SELECT_CATEGORYENTRY =
		"SELECT categoryEntry FROM CategoryEntry categoryEntry";

	private static final String _SQL_SELECT_CATEGORYENTRY_WHERE =
		"SELECT categoryEntry FROM CategoryEntry categoryEntry WHERE ";

	private static final String _SQL_COUNT_CATEGORYENTRY =
		"SELECT COUNT(categoryEntry) FROM CategoryEntry categoryEntry";

	private static final String _SQL_COUNT_CATEGORYENTRY_WHERE =
		"SELECT COUNT(categoryEntry) FROM CategoryEntry categoryEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "categoryEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CategoryEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CategoryEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CategoryEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "type", "code"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class CategoryEntryModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return FINDER_ARGS_EMPTY;
				}

				return null;
			}

			CategoryEntryModelImpl categoryEntryModelImpl =
				(CategoryEntryModelImpl)baseModel;

			long columnBitmask = categoryEntryModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(categoryEntryModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						categoryEntryModelImpl.getColumnBitmask(columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
						finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(categoryEntryModelImpl, columnNames, original);
			}

			return null;
		}

		@Override
		public String getClassName() {
			return CategoryEntryImpl.class.getName();
		}

		@Override
		public String getTableName() {
			return CategoryEntryTable.INSTANCE.getTableName();
		}

		private static Object[] _getValue(
			CategoryEntryModelImpl categoryEntryModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						categoryEntryModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = categoryEntryModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

		private static final long _ORDER_BY_COLUMNS_BITMASK;

		static {
			long orderByColumnsBitmask = 0;

			orderByColumnsBitmask |= CategoryEntryModelImpl.getColumnBitmask(
				"type_");

			_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
		}

	}

}