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

import com.dogoo.poc.account.exception.NoSuchAccountRoleEntryException;
import com.dogoo.poc.account.model.AccountRoleEntry;
import com.dogoo.poc.account.model.AccountRoleEntryTable;
import com.dogoo.poc.account.model.impl.AccountRoleEntryImpl;
import com.dogoo.poc.account.model.impl.AccountRoleEntryModelImpl;
import com.dogoo.poc.account.service.persistence.AccountRoleEntryPersistence;
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
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
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
 * The persistence implementation for the account role entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {AccountRoleEntryPersistence.class, BasePersistence.class})
public class AccountRoleEntryPersistenceImpl
	extends BasePersistenceImpl<AccountRoleEntry>
	implements AccountRoleEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AccountRoleEntryUtil</code> to access the account role entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AccountRoleEntryImpl.class.getName();

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
	 * Returns all the account role entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching account role entries
	 */
	@Override
	public List<AccountRoleEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AccountRoleEntry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<AccountRoleEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AccountRoleEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<AccountRoleEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AccountRoleEntry> orderByComparator,
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

		List<AccountRoleEntry> list = null;

		if (useFinderCache) {
			list = (List<AccountRoleEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AccountRoleEntry accountRoleEntry : list) {
					if (!uuid.equals(accountRoleEntry.getUuid())) {
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

			sb.append(_SQL_SELECT_ACCOUNTROLEENTRY_WHERE);

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
				sb.append(AccountRoleEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<AccountRoleEntry>)QueryUtil.list(
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
	 * Returns the first account role entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account role entry
	 * @throws NoSuchAccountRoleEntryException if a matching account role entry could not be found
	 */
	@Override
	public AccountRoleEntry findByUuid_First(
			String uuid, OrderByComparator<AccountRoleEntry> orderByComparator)
		throws NoSuchAccountRoleEntryException {

		AccountRoleEntry accountRoleEntry = fetchByUuid_First(
			uuid, orderByComparator);

		if (accountRoleEntry != null) {
			return accountRoleEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAccountRoleEntryException(sb.toString());
	}

	/**
	 * Returns the first account role entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account role entry, or <code>null</code> if a matching account role entry could not be found
	 */
	@Override
	public AccountRoleEntry fetchByUuid_First(
		String uuid, OrderByComparator<AccountRoleEntry> orderByComparator) {

		List<AccountRoleEntry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last account role entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account role entry
	 * @throws NoSuchAccountRoleEntryException if a matching account role entry could not be found
	 */
	@Override
	public AccountRoleEntry findByUuid_Last(
			String uuid, OrderByComparator<AccountRoleEntry> orderByComparator)
		throws NoSuchAccountRoleEntryException {

		AccountRoleEntry accountRoleEntry = fetchByUuid_Last(
			uuid, orderByComparator);

		if (accountRoleEntry != null) {
			return accountRoleEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAccountRoleEntryException(sb.toString());
	}

	/**
	 * Returns the last account role entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account role entry, or <code>null</code> if a matching account role entry could not be found
	 */
	@Override
	public AccountRoleEntry fetchByUuid_Last(
		String uuid, OrderByComparator<AccountRoleEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<AccountRoleEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AccountRoleEntry[] findByUuid_PrevAndNext(
			long AccountRoleId, String uuid,
			OrderByComparator<AccountRoleEntry> orderByComparator)
		throws NoSuchAccountRoleEntryException {

		uuid = Objects.toString(uuid, "");

		AccountRoleEntry accountRoleEntry = findByPrimaryKey(AccountRoleId);

		Session session = null;

		try {
			session = openSession();

			AccountRoleEntry[] array = new AccountRoleEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, accountRoleEntry, uuid, orderByComparator, true);

			array[1] = accountRoleEntry;

			array[2] = getByUuid_PrevAndNext(
				session, accountRoleEntry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AccountRoleEntry getByUuid_PrevAndNext(
		Session session, AccountRoleEntry accountRoleEntry, String uuid,
		OrderByComparator<AccountRoleEntry> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ACCOUNTROLEENTRY_WHERE);

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
			sb.append(AccountRoleEntryModelImpl.ORDER_BY_JPQL);
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
						accountRoleEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AccountRoleEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the account role entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (AccountRoleEntry accountRoleEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(accountRoleEntry);
		}
	}

	/**
	 * Returns the number of account role entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching account role entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ACCOUNTROLEENTRY_WHERE);

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
		"accountRoleEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(accountRoleEntry.uuid IS NULL OR accountRoleEntry.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the account role entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAccountRoleEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching account role entry
	 * @throws NoSuchAccountRoleEntryException if a matching account role entry could not be found
	 */
	@Override
	public AccountRoleEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchAccountRoleEntryException {

		AccountRoleEntry accountRoleEntry = fetchByUUID_G(uuid, groupId);

		if (accountRoleEntry == null) {
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

			throw new NoSuchAccountRoleEntryException(sb.toString());
		}

		return accountRoleEntry;
	}

	/**
	 * Returns the account role entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching account role entry, or <code>null</code> if a matching account role entry could not be found
	 */
	@Override
	public AccountRoleEntry fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the account role entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching account role entry, or <code>null</code> if a matching account role entry could not be found
	 */
	@Override
	public AccountRoleEntry fetchByUUID_G(
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

		if (result instanceof AccountRoleEntry) {
			AccountRoleEntry accountRoleEntry = (AccountRoleEntry)result;

			if (!Objects.equals(uuid, accountRoleEntry.getUuid()) ||
				(groupId != accountRoleEntry.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ACCOUNTROLEENTRY_WHERE);

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

				List<AccountRoleEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					AccountRoleEntry accountRoleEntry = list.get(0);

					result = accountRoleEntry;

					cacheResult(accountRoleEntry);
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
			return (AccountRoleEntry)result;
		}
	}

	/**
	 * Removes the account role entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the account role entry that was removed
	 */
	@Override
	public AccountRoleEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchAccountRoleEntryException {

		AccountRoleEntry accountRoleEntry = findByUUID_G(uuid, groupId);

		return remove(accountRoleEntry);
	}

	/**
	 * Returns the number of account role entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching account role entries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ACCOUNTROLEENTRY_WHERE);

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
		"accountRoleEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(accountRoleEntry.uuid IS NULL OR accountRoleEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"accountRoleEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the account role entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching account role entries
	 */
	@Override
	public List<AccountRoleEntry> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AccountRoleEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<AccountRoleEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AccountRoleEntry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<AccountRoleEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AccountRoleEntry> orderByComparator,
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

		List<AccountRoleEntry> list = null;

		if (useFinderCache) {
			list = (List<AccountRoleEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AccountRoleEntry accountRoleEntry : list) {
					if (!uuid.equals(accountRoleEntry.getUuid()) ||
						(companyId != accountRoleEntry.getCompanyId())) {

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

			sb.append(_SQL_SELECT_ACCOUNTROLEENTRY_WHERE);

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
				sb.append(AccountRoleEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<AccountRoleEntry>)QueryUtil.list(
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
	 * Returns the first account role entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account role entry
	 * @throws NoSuchAccountRoleEntryException if a matching account role entry could not be found
	 */
	@Override
	public AccountRoleEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AccountRoleEntry> orderByComparator)
		throws NoSuchAccountRoleEntryException {

		AccountRoleEntry accountRoleEntry = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (accountRoleEntry != null) {
			return accountRoleEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAccountRoleEntryException(sb.toString());
	}

	/**
	 * Returns the first account role entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account role entry, or <code>null</code> if a matching account role entry could not be found
	 */
	@Override
	public AccountRoleEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AccountRoleEntry> orderByComparator) {

		List<AccountRoleEntry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AccountRoleEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AccountRoleEntry> orderByComparator)
		throws NoSuchAccountRoleEntryException {

		AccountRoleEntry accountRoleEntry = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (accountRoleEntry != null) {
			return accountRoleEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAccountRoleEntryException(sb.toString());
	}

	/**
	 * Returns the last account role entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account role entry, or <code>null</code> if a matching account role entry could not be found
	 */
	@Override
	public AccountRoleEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AccountRoleEntry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<AccountRoleEntry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AccountRoleEntry[] findByUuid_C_PrevAndNext(
			long AccountRoleId, String uuid, long companyId,
			OrderByComparator<AccountRoleEntry> orderByComparator)
		throws NoSuchAccountRoleEntryException {

		uuid = Objects.toString(uuid, "");

		AccountRoleEntry accountRoleEntry = findByPrimaryKey(AccountRoleId);

		Session session = null;

		try {
			session = openSession();

			AccountRoleEntry[] array = new AccountRoleEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, accountRoleEntry, uuid, companyId, orderByComparator,
				true);

			array[1] = accountRoleEntry;

			array[2] = getByUuid_C_PrevAndNext(
				session, accountRoleEntry, uuid, companyId, orderByComparator,
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

	protected AccountRoleEntry getByUuid_C_PrevAndNext(
		Session session, AccountRoleEntry accountRoleEntry, String uuid,
		long companyId, OrderByComparator<AccountRoleEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_ACCOUNTROLEENTRY_WHERE);

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
			sb.append(AccountRoleEntryModelImpl.ORDER_BY_JPQL);
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
						accountRoleEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AccountRoleEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the account role entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (AccountRoleEntry accountRoleEntry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(accountRoleEntry);
		}
	}

	/**
	 * Returns the number of account role entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching account role entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ACCOUNTROLEENTRY_WHERE);

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
		"accountRoleEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(accountRoleEntry.uuid IS NULL OR accountRoleEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"accountRoleEntry.companyId = ?";

	private FinderPath _finderPathWithPaginationFindBycode;
	private FinderPath _finderPathWithoutPaginationFindBycode;
	private FinderPath _finderPathCountBycode;

	/**
	 * Returns all the account role entries where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching account role entries
	 */
	@Override
	public List<AccountRoleEntry> findBycode(String code) {
		return findBycode(code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AccountRoleEntry> findBycode(String code, int start, int end) {
		return findBycode(code, start, end, null);
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
	@Override
	public List<AccountRoleEntry> findBycode(
		String code, int start, int end,
		OrderByComparator<AccountRoleEntry> orderByComparator) {

		return findBycode(code, start, end, orderByComparator, true);
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
	@Override
	public List<AccountRoleEntry> findBycode(
		String code, int start, int end,
		OrderByComparator<AccountRoleEntry> orderByComparator,
		boolean useFinderCache) {

		code = Objects.toString(code, "");

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

		List<AccountRoleEntry> list = null;

		if (useFinderCache) {
			list = (List<AccountRoleEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AccountRoleEntry accountRoleEntry : list) {
					if (!code.equals(accountRoleEntry.getCode())) {
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

			sb.append(_SQL_SELECT_ACCOUNTROLEENTRY_WHERE);

			boolean bindCode = false;

			if (code.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODE_CODE_3);
			}
			else {
				bindCode = true;

				sb.append(_FINDER_COLUMN_CODE_CODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AccountRoleEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCode) {
					queryPos.add(code);
				}

				list = (List<AccountRoleEntry>)QueryUtil.list(
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
	 * Returns the first account role entry in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account role entry
	 * @throws NoSuchAccountRoleEntryException if a matching account role entry could not be found
	 */
	@Override
	public AccountRoleEntry findBycode_First(
			String code, OrderByComparator<AccountRoleEntry> orderByComparator)
		throws NoSuchAccountRoleEntryException {

		AccountRoleEntry accountRoleEntry = fetchBycode_First(
			code, orderByComparator);

		if (accountRoleEntry != null) {
			return accountRoleEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("code=");
		sb.append(code);

		sb.append("}");

		throw new NoSuchAccountRoleEntryException(sb.toString());
	}

	/**
	 * Returns the first account role entry in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account role entry, or <code>null</code> if a matching account role entry could not be found
	 */
	@Override
	public AccountRoleEntry fetchBycode_First(
		String code, OrderByComparator<AccountRoleEntry> orderByComparator) {

		List<AccountRoleEntry> list = findBycode(code, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last account role entry in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account role entry
	 * @throws NoSuchAccountRoleEntryException if a matching account role entry could not be found
	 */
	@Override
	public AccountRoleEntry findBycode_Last(
			String code, OrderByComparator<AccountRoleEntry> orderByComparator)
		throws NoSuchAccountRoleEntryException {

		AccountRoleEntry accountRoleEntry = fetchBycode_Last(
			code, orderByComparator);

		if (accountRoleEntry != null) {
			return accountRoleEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("code=");
		sb.append(code);

		sb.append("}");

		throw new NoSuchAccountRoleEntryException(sb.toString());
	}

	/**
	 * Returns the last account role entry in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account role entry, or <code>null</code> if a matching account role entry could not be found
	 */
	@Override
	public AccountRoleEntry fetchBycode_Last(
		String code, OrderByComparator<AccountRoleEntry> orderByComparator) {

		int count = countBycode(code);

		if (count == 0) {
			return null;
		}

		List<AccountRoleEntry> list = findBycode(
			code, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AccountRoleEntry[] findBycode_PrevAndNext(
			long AccountRoleId, String code,
			OrderByComparator<AccountRoleEntry> orderByComparator)
		throws NoSuchAccountRoleEntryException {

		code = Objects.toString(code, "");

		AccountRoleEntry accountRoleEntry = findByPrimaryKey(AccountRoleId);

		Session session = null;

		try {
			session = openSession();

			AccountRoleEntry[] array = new AccountRoleEntryImpl[3];

			array[0] = getBycode_PrevAndNext(
				session, accountRoleEntry, code, orderByComparator, true);

			array[1] = accountRoleEntry;

			array[2] = getBycode_PrevAndNext(
				session, accountRoleEntry, code, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AccountRoleEntry getBycode_PrevAndNext(
		Session session, AccountRoleEntry accountRoleEntry, String code,
		OrderByComparator<AccountRoleEntry> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ACCOUNTROLEENTRY_WHERE);

		boolean bindCode = false;

		if (code.isEmpty()) {
			sb.append(_FINDER_COLUMN_CODE_CODE_3);
		}
		else {
			bindCode = true;

			sb.append(_FINDER_COLUMN_CODE_CODE_2);
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
			sb.append(AccountRoleEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCode) {
			queryPos.add(code);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						accountRoleEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AccountRoleEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the account role entries where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	@Override
	public void removeBycode(String code) {
		for (AccountRoleEntry accountRoleEntry :
				findBycode(code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(accountRoleEntry);
		}
	}

	/**
	 * Returns the number of account role entries where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching account role entries
	 */
	@Override
	public int countBycode(String code) {
		code = Objects.toString(code, "");

		FinderPath finderPath = _finderPathCountBycode;

		Object[] finderArgs = new Object[] {code};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ACCOUNTROLEENTRY_WHERE);

			boolean bindCode = false;

			if (code.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODE_CODE_3);
			}
			else {
				bindCode = true;

				sb.append(_FINDER_COLUMN_CODE_CODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCode) {
					queryPos.add(code);
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

	private static final String _FINDER_COLUMN_CODE_CODE_2 =
		"accountRoleEntry.code = ?";

	private static final String _FINDER_COLUMN_CODE_CODE_3 =
		"(accountRoleEntry.code IS NULL OR accountRoleEntry.code = '')";

	private FinderPath _finderPathWithPaginationFindByAccountId;
	private FinderPath _finderPathWithoutPaginationFindByAccountId;
	private FinderPath _finderPathCountByAccountId;

	/**
	 * Returns all the account role entries where AccountId = &#63;.
	 *
	 * @param AccountId the account ID
	 * @return the matching account role entries
	 */
	@Override
	public List<AccountRoleEntry> findByAccountId(long AccountId) {
		return findByAccountId(
			AccountId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AccountRoleEntry> findByAccountId(
		long AccountId, int start, int end) {

		return findByAccountId(AccountId, start, end, null);
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
	@Override
	public List<AccountRoleEntry> findByAccountId(
		long AccountId, int start, int end,
		OrderByComparator<AccountRoleEntry> orderByComparator) {

		return findByAccountId(AccountId, start, end, orderByComparator, true);
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
	@Override
	public List<AccountRoleEntry> findByAccountId(
		long AccountId, int start, int end,
		OrderByComparator<AccountRoleEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByAccountId;
				finderArgs = new Object[] {AccountId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByAccountId;
			finderArgs = new Object[] {
				AccountId, start, end, orderByComparator
			};
		}

		List<AccountRoleEntry> list = null;

		if (useFinderCache) {
			list = (List<AccountRoleEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AccountRoleEntry accountRoleEntry : list) {
					if (AccountId != accountRoleEntry.getAccountId()) {
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

			sb.append(_SQL_SELECT_ACCOUNTROLEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_ACCOUNTID_ACCOUNTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AccountRoleEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(AccountId);

				list = (List<AccountRoleEntry>)QueryUtil.list(
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
	 * Returns the first account role entry in the ordered set where AccountId = &#63;.
	 *
	 * @param AccountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account role entry
	 * @throws NoSuchAccountRoleEntryException if a matching account role entry could not be found
	 */
	@Override
	public AccountRoleEntry findByAccountId_First(
			long AccountId,
			OrderByComparator<AccountRoleEntry> orderByComparator)
		throws NoSuchAccountRoleEntryException {

		AccountRoleEntry accountRoleEntry = fetchByAccountId_First(
			AccountId, orderByComparator);

		if (accountRoleEntry != null) {
			return accountRoleEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("AccountId=");
		sb.append(AccountId);

		sb.append("}");

		throw new NoSuchAccountRoleEntryException(sb.toString());
	}

	/**
	 * Returns the first account role entry in the ordered set where AccountId = &#63;.
	 *
	 * @param AccountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account role entry, or <code>null</code> if a matching account role entry could not be found
	 */
	@Override
	public AccountRoleEntry fetchByAccountId_First(
		long AccountId, OrderByComparator<AccountRoleEntry> orderByComparator) {

		List<AccountRoleEntry> list = findByAccountId(
			AccountId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last account role entry in the ordered set where AccountId = &#63;.
	 *
	 * @param AccountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account role entry
	 * @throws NoSuchAccountRoleEntryException if a matching account role entry could not be found
	 */
	@Override
	public AccountRoleEntry findByAccountId_Last(
			long AccountId,
			OrderByComparator<AccountRoleEntry> orderByComparator)
		throws NoSuchAccountRoleEntryException {

		AccountRoleEntry accountRoleEntry = fetchByAccountId_Last(
			AccountId, orderByComparator);

		if (accountRoleEntry != null) {
			return accountRoleEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("AccountId=");
		sb.append(AccountId);

		sb.append("}");

		throw new NoSuchAccountRoleEntryException(sb.toString());
	}

	/**
	 * Returns the last account role entry in the ordered set where AccountId = &#63;.
	 *
	 * @param AccountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account role entry, or <code>null</code> if a matching account role entry could not be found
	 */
	@Override
	public AccountRoleEntry fetchByAccountId_Last(
		long AccountId, OrderByComparator<AccountRoleEntry> orderByComparator) {

		int count = countByAccountId(AccountId);

		if (count == 0) {
			return null;
		}

		List<AccountRoleEntry> list = findByAccountId(
			AccountId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AccountRoleEntry[] findByAccountId_PrevAndNext(
			long AccountRoleId, long AccountId,
			OrderByComparator<AccountRoleEntry> orderByComparator)
		throws NoSuchAccountRoleEntryException {

		AccountRoleEntry accountRoleEntry = findByPrimaryKey(AccountRoleId);

		Session session = null;

		try {
			session = openSession();

			AccountRoleEntry[] array = new AccountRoleEntryImpl[3];

			array[0] = getByAccountId_PrevAndNext(
				session, accountRoleEntry, AccountId, orderByComparator, true);

			array[1] = accountRoleEntry;

			array[2] = getByAccountId_PrevAndNext(
				session, accountRoleEntry, AccountId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AccountRoleEntry getByAccountId_PrevAndNext(
		Session session, AccountRoleEntry accountRoleEntry, long AccountId,
		OrderByComparator<AccountRoleEntry> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ACCOUNTROLEENTRY_WHERE);

		sb.append(_FINDER_COLUMN_ACCOUNTID_ACCOUNTID_2);

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
			sb.append(AccountRoleEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(AccountId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						accountRoleEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AccountRoleEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the account role entries where AccountId = &#63; from the database.
	 *
	 * @param AccountId the account ID
	 */
	@Override
	public void removeByAccountId(long AccountId) {
		for (AccountRoleEntry accountRoleEntry :
				findByAccountId(
					AccountId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(accountRoleEntry);
		}
	}

	/**
	 * Returns the number of account role entries where AccountId = &#63;.
	 *
	 * @param AccountId the account ID
	 * @return the number of matching account role entries
	 */
	@Override
	public int countByAccountId(long AccountId) {
		FinderPath finderPath = _finderPathCountByAccountId;

		Object[] finderArgs = new Object[] {AccountId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ACCOUNTROLEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_ACCOUNTID_ACCOUNTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(AccountId);

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

	private static final String _FINDER_COLUMN_ACCOUNTID_ACCOUNTID_2 =
		"accountRoleEntry.AccountId = ?";

	public AccountRoleEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("code", "code_");

		setDBColumnNames(dbColumnNames);

		setModelClass(AccountRoleEntry.class);

		setModelImplClass(AccountRoleEntryImpl.class);
		setModelPKClass(long.class);

		setTable(AccountRoleEntryTable.INSTANCE);
	}

	/**
	 * Caches the account role entry in the entity cache if it is enabled.
	 *
	 * @param accountRoleEntry the account role entry
	 */
	@Override
	public void cacheResult(AccountRoleEntry accountRoleEntry) {
		entityCache.putResult(
			AccountRoleEntryImpl.class, accountRoleEntry.getPrimaryKey(),
			accountRoleEntry);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				accountRoleEntry.getUuid(), accountRoleEntry.getGroupId()
			},
			accountRoleEntry);
	}

	/**
	 * Caches the account role entries in the entity cache if it is enabled.
	 *
	 * @param accountRoleEntries the account role entries
	 */
	@Override
	public void cacheResult(List<AccountRoleEntry> accountRoleEntries) {
		for (AccountRoleEntry accountRoleEntry : accountRoleEntries) {
			if (entityCache.getResult(
					AccountRoleEntryImpl.class,
					accountRoleEntry.getPrimaryKey()) == null) {

				cacheResult(accountRoleEntry);
			}
		}
	}

	/**
	 * Clears the cache for all account role entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AccountRoleEntryImpl.class);

		finderCache.clearCache(AccountRoleEntryImpl.class);
	}

	/**
	 * Clears the cache for the account role entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AccountRoleEntry accountRoleEntry) {
		entityCache.removeResult(AccountRoleEntryImpl.class, accountRoleEntry);
	}

	@Override
	public void clearCache(List<AccountRoleEntry> accountRoleEntries) {
		for (AccountRoleEntry accountRoleEntry : accountRoleEntries) {
			entityCache.removeResult(
				AccountRoleEntryImpl.class, accountRoleEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AccountRoleEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AccountRoleEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		AccountRoleEntryModelImpl accountRoleEntryModelImpl) {

		Object[] args = new Object[] {
			accountRoleEntryModelImpl.getUuid(),
			accountRoleEntryModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, accountRoleEntryModelImpl);
	}

	/**
	 * Creates a new account role entry with the primary key. Does not add the account role entry to the database.
	 *
	 * @param AccountRoleId the primary key for the new account role entry
	 * @return the new account role entry
	 */
	@Override
	public AccountRoleEntry create(long AccountRoleId) {
		AccountRoleEntry accountRoleEntry = new AccountRoleEntryImpl();

		accountRoleEntry.setNew(true);
		accountRoleEntry.setPrimaryKey(AccountRoleId);

		String uuid = PortalUUIDUtil.generate();

		accountRoleEntry.setUuid(uuid);

		accountRoleEntry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return accountRoleEntry;
	}

	/**
	 * Removes the account role entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param AccountRoleId the primary key of the account role entry
	 * @return the account role entry that was removed
	 * @throws NoSuchAccountRoleEntryException if a account role entry with the primary key could not be found
	 */
	@Override
	public AccountRoleEntry remove(long AccountRoleId)
		throws NoSuchAccountRoleEntryException {

		return remove((Serializable)AccountRoleId);
	}

	/**
	 * Removes the account role entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the account role entry
	 * @return the account role entry that was removed
	 * @throws NoSuchAccountRoleEntryException if a account role entry with the primary key could not be found
	 */
	@Override
	public AccountRoleEntry remove(Serializable primaryKey)
		throws NoSuchAccountRoleEntryException {

		Session session = null;

		try {
			session = openSession();

			AccountRoleEntry accountRoleEntry = (AccountRoleEntry)session.get(
				AccountRoleEntryImpl.class, primaryKey);

			if (accountRoleEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAccountRoleEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(accountRoleEntry);
		}
		catch (NoSuchAccountRoleEntryException noSuchEntityException) {
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
	protected AccountRoleEntry removeImpl(AccountRoleEntry accountRoleEntry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(accountRoleEntry)) {
				accountRoleEntry = (AccountRoleEntry)session.get(
					AccountRoleEntryImpl.class,
					accountRoleEntry.getPrimaryKeyObj());
			}

			if (accountRoleEntry != null) {
				session.delete(accountRoleEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (accountRoleEntry != null) {
			clearCache(accountRoleEntry);
		}

		return accountRoleEntry;
	}

	@Override
	public AccountRoleEntry updateImpl(AccountRoleEntry accountRoleEntry) {
		boolean isNew = accountRoleEntry.isNew();

		if (!(accountRoleEntry instanceof AccountRoleEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(accountRoleEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					accountRoleEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in accountRoleEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AccountRoleEntry implementation " +
					accountRoleEntry.getClass());
		}

		AccountRoleEntryModelImpl accountRoleEntryModelImpl =
			(AccountRoleEntryModelImpl)accountRoleEntry;

		if (Validator.isNull(accountRoleEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			accountRoleEntry.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (accountRoleEntry.getCreateDate() == null)) {
			if (serviceContext == null) {
				accountRoleEntry.setCreateDate(date);
			}
			else {
				accountRoleEntry.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!accountRoleEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				accountRoleEntry.setModifiedDate(date);
			}
			else {
				accountRoleEntry.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(accountRoleEntry);
			}
			else {
				accountRoleEntry = (AccountRoleEntry)session.merge(
					accountRoleEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AccountRoleEntryImpl.class, accountRoleEntryModelImpl, false, true);

		cacheUniqueFindersCache(accountRoleEntryModelImpl);

		if (isNew) {
			accountRoleEntry.setNew(false);
		}

		accountRoleEntry.resetOriginalValues();

		return accountRoleEntry;
	}

	/**
	 * Returns the account role entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the account role entry
	 * @return the account role entry
	 * @throws NoSuchAccountRoleEntryException if a account role entry with the primary key could not be found
	 */
	@Override
	public AccountRoleEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAccountRoleEntryException {

		AccountRoleEntry accountRoleEntry = fetchByPrimaryKey(primaryKey);

		if (accountRoleEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAccountRoleEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return accountRoleEntry;
	}

	/**
	 * Returns the account role entry with the primary key or throws a <code>NoSuchAccountRoleEntryException</code> if it could not be found.
	 *
	 * @param AccountRoleId the primary key of the account role entry
	 * @return the account role entry
	 * @throws NoSuchAccountRoleEntryException if a account role entry with the primary key could not be found
	 */
	@Override
	public AccountRoleEntry findByPrimaryKey(long AccountRoleId)
		throws NoSuchAccountRoleEntryException {

		return findByPrimaryKey((Serializable)AccountRoleId);
	}

	/**
	 * Returns the account role entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param AccountRoleId the primary key of the account role entry
	 * @return the account role entry, or <code>null</code> if a account role entry with the primary key could not be found
	 */
	@Override
	public AccountRoleEntry fetchByPrimaryKey(long AccountRoleId) {
		return fetchByPrimaryKey((Serializable)AccountRoleId);
	}

	/**
	 * Returns all the account role entries.
	 *
	 * @return the account role entries
	 */
	@Override
	public List<AccountRoleEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AccountRoleEntry> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<AccountRoleEntry> findAll(
		int start, int end,
		OrderByComparator<AccountRoleEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<AccountRoleEntry> findAll(
		int start, int end,
		OrderByComparator<AccountRoleEntry> orderByComparator,
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

		List<AccountRoleEntry> list = null;

		if (useFinderCache) {
			list = (List<AccountRoleEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ACCOUNTROLEENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ACCOUNTROLEENTRY;

				sql = sql.concat(AccountRoleEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AccountRoleEntry>)QueryUtil.list(
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
	 * Removes all the account role entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AccountRoleEntry accountRoleEntry : findAll()) {
			remove(accountRoleEntry);
		}
	}

	/**
	 * Returns the number of account role entries.
	 *
	 * @return the number of account role entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ACCOUNTROLEENTRY);

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
		return "AccountRoleId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ACCOUNTROLEENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AccountRoleEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the account role entry persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new AccountRoleEntryModelArgumentsResolver(),
			new HashMapDictionary<>());

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

		_finderPathWithPaginationFindBycode = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycode",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"code_"}, true);

		_finderPathWithoutPaginationFindBycode = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycode",
			new String[] {String.class.getName()}, new String[] {"code_"},
			true);

		_finderPathCountBycode = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycode",
			new String[] {String.class.getName()}, new String[] {"code_"},
			false);

		_finderPathWithPaginationFindByAccountId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAccountId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"AccountId"}, true);

		_finderPathWithoutPaginationFindByAccountId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAccountId",
			new String[] {Long.class.getName()}, new String[] {"AccountId"},
			true);

		_finderPathCountByAccountId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAccountId",
			new String[] {Long.class.getName()}, new String[] {"AccountId"},
			false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(AccountRoleEntryImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();
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

	private static final String _SQL_SELECT_ACCOUNTROLEENTRY =
		"SELECT accountRoleEntry FROM AccountRoleEntry accountRoleEntry";

	private static final String _SQL_SELECT_ACCOUNTROLEENTRY_WHERE =
		"SELECT accountRoleEntry FROM AccountRoleEntry accountRoleEntry WHERE ";

	private static final String _SQL_COUNT_ACCOUNTROLEENTRY =
		"SELECT COUNT(accountRoleEntry) FROM AccountRoleEntry accountRoleEntry";

	private static final String _SQL_COUNT_ACCOUNTROLEENTRY_WHERE =
		"SELECT COUNT(accountRoleEntry) FROM AccountRoleEntry accountRoleEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "accountRoleEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AccountRoleEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AccountRoleEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AccountRoleEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "code"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class AccountRoleEntryModelArgumentsResolver
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

			AccountRoleEntryModelImpl accountRoleEntryModelImpl =
				(AccountRoleEntryModelImpl)baseModel;

			long columnBitmask = accountRoleEntryModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					accountRoleEntryModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						accountRoleEntryModelImpl.getColumnBitmask(columnName);
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
				return _getValue(
					accountRoleEntryModelImpl, columnNames, original);
			}

			return null;
		}

		@Override
		public String getClassName() {
			return AccountRoleEntryImpl.class.getName();
		}

		@Override
		public String getTableName() {
			return AccountRoleEntryTable.INSTANCE.getTableName();
		}

		private static Object[] _getValue(
			AccountRoleEntryModelImpl accountRoleEntryModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						accountRoleEntryModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = accountRoleEntryModelImpl.getColumnValue(
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

			orderByColumnsBitmask |= AccountRoleEntryModelImpl.getColumnBitmask(
				"code_");

			_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
		}

	}

}