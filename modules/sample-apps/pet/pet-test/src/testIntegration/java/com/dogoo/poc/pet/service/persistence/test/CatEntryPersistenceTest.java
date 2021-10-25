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

package com.dogoo.poc.pet.service.persistence.test;

import com.dogoo.poc.pet.exception.NoSuchCatEntryException;
import com.dogoo.poc.pet.model.CatEntry;
import com.dogoo.poc.pet.service.CatEntryLocalServiceUtil;
import com.dogoo.poc.pet.service.persistence.CatEntryPersistence;
import com.dogoo.poc.pet.service.persistence.CatEntryUtil;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class CatEntryPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.dogoo.poc.pet.service"));

	@Before
	public void setUp() {
		_persistence = CatEntryUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<CatEntry> iterator = _catEntries.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CatEntry catEntry = _persistence.create(pk);

		Assert.assertNotNull(catEntry);

		Assert.assertEquals(catEntry.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		CatEntry newCatEntry = addCatEntry();

		_persistence.remove(newCatEntry);

		CatEntry existingCatEntry = _persistence.fetchByPrimaryKey(
			newCatEntry.getPrimaryKey());

		Assert.assertNull(existingCatEntry);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCatEntry();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CatEntry newCatEntry = _persistence.create(pk);

		newCatEntry.setUuid(RandomTestUtil.randomString());

		newCatEntry.setGroupId(RandomTestUtil.nextLong());

		newCatEntry.setCompanyId(RandomTestUtil.nextLong());

		newCatEntry.setUserId(RandomTestUtil.nextLong());

		newCatEntry.setUserName(RandomTestUtil.randomString());

		newCatEntry.setCreateDate(RandomTestUtil.nextDate());

		newCatEntry.setModifiedDate(RandomTestUtil.nextDate());

		newCatEntry.setCreatorId(RandomTestUtil.nextLong());

		newCatEntry.setScopeOrgId(RandomTestUtil.nextLong());

		newCatEntry.setName(RandomTestUtil.randomString());

		newCatEntry.setTag(RandomTestUtil.randomString());

		newCatEntry.setStatus(RandomTestUtil.randomString());

		newCatEntry.setStatusDate(RandomTestUtil.nextDate());

		_catEntries.add(_persistence.update(newCatEntry));

		CatEntry existingCatEntry = _persistence.findByPrimaryKey(
			newCatEntry.getPrimaryKey());

		Assert.assertEquals(existingCatEntry.getUuid(), newCatEntry.getUuid());
		Assert.assertEquals(
			existingCatEntry.getPetId(), newCatEntry.getPetId());
		Assert.assertEquals(
			existingCatEntry.getGroupId(), newCatEntry.getGroupId());
		Assert.assertEquals(
			existingCatEntry.getCompanyId(), newCatEntry.getCompanyId());
		Assert.assertEquals(
			existingCatEntry.getUserId(), newCatEntry.getUserId());
		Assert.assertEquals(
			existingCatEntry.getUserName(), newCatEntry.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingCatEntry.getCreateDate()),
			Time.getShortTimestamp(newCatEntry.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingCatEntry.getModifiedDate()),
			Time.getShortTimestamp(newCatEntry.getModifiedDate()));
		Assert.assertEquals(
			existingCatEntry.getCreatorId(), newCatEntry.getCreatorId());
		Assert.assertEquals(
			existingCatEntry.getScopeOrgId(), newCatEntry.getScopeOrgId());
		Assert.assertEquals(existingCatEntry.getName(), newCatEntry.getName());
		Assert.assertEquals(existingCatEntry.getTag(), newCatEntry.getTag());
		Assert.assertEquals(
			existingCatEntry.getStatus(), newCatEntry.getStatus());
		Assert.assertEquals(
			Time.getShortTimestamp(existingCatEntry.getStatusDate()),
			Time.getShortTimestamp(newCatEntry.getStatusDate()));
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByUUID_G() throws Exception {
		_persistence.countByUUID_G("", RandomTestUtil.nextLong());

		_persistence.countByUUID_G("null", 0L);

		_persistence.countByUUID_G((String)null, 0L);
	}

	@Test
	public void testCountByUuid_C() throws Exception {
		_persistence.countByUuid_C("", RandomTestUtil.nextLong());

		_persistence.countByUuid_C("null", 0L);

		_persistence.countByUuid_C((String)null, 0L);
	}

	@Test
	public void testCountByT_S() throws Exception {
		_persistence.countByT_S("");

		_persistence.countByT_S("null");

		_persistence.countByT_S((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		CatEntry newCatEntry = addCatEntry();

		CatEntry existingCatEntry = _persistence.findByPrimaryKey(
			newCatEntry.getPrimaryKey());

		Assert.assertEquals(existingCatEntry, newCatEntry);
	}

	@Test(expected = NoSuchCatEntryException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<CatEntry> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"DG_CatEntry", "uuid", true, "petId", true, "groupId", true,
			"companyId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true, "creatorId", true, "scopeOrgId", true,
			"name", true, "tag", true, "status", true, "statusDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		CatEntry newCatEntry = addCatEntry();

		CatEntry existingCatEntry = _persistence.fetchByPrimaryKey(
			newCatEntry.getPrimaryKey());

		Assert.assertEquals(existingCatEntry, newCatEntry);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CatEntry missingCatEntry = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingCatEntry);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		CatEntry newCatEntry1 = addCatEntry();
		CatEntry newCatEntry2 = addCatEntry();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCatEntry1.getPrimaryKey());
		primaryKeys.add(newCatEntry2.getPrimaryKey());

		Map<Serializable, CatEntry> catEntries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, catEntries.size());
		Assert.assertEquals(
			newCatEntry1, catEntries.get(newCatEntry1.getPrimaryKey()));
		Assert.assertEquals(
			newCatEntry2, catEntries.get(newCatEntry2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, CatEntry> catEntries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(catEntries.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		CatEntry newCatEntry = addCatEntry();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCatEntry.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, CatEntry> catEntries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, catEntries.size());
		Assert.assertEquals(
			newCatEntry, catEntries.get(newCatEntry.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, CatEntry> catEntries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(catEntries.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		CatEntry newCatEntry = addCatEntry();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCatEntry.getPrimaryKey());

		Map<Serializable, CatEntry> catEntries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, catEntries.size());
		Assert.assertEquals(
			newCatEntry, catEntries.get(newCatEntry.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			CatEntryLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<CatEntry>() {

				@Override
				public void performAction(CatEntry catEntry) {
					Assert.assertNotNull(catEntry);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		CatEntry newCatEntry = addCatEntry();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CatEntry.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("petId", newCatEntry.getPetId()));

		List<CatEntry> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		CatEntry existingCatEntry = result.get(0);

		Assert.assertEquals(existingCatEntry, newCatEntry);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CatEntry.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("petId", RandomTestUtil.nextLong()));

		List<CatEntry> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		CatEntry newCatEntry = addCatEntry();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CatEntry.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("petId"));

		Object newPetId = newCatEntry.getPetId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("petId", new Object[] {newPetId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingPetId = result.get(0);

		Assert.assertEquals(existingPetId, newPetId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CatEntry.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("petId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"petId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		CatEntry newCatEntry = addCatEntry();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newCatEntry.getPrimaryKey()));
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromDatabase()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(true);
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromSession()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(false);
	}

	private void _testResetOriginalValuesWithDynamicQuery(boolean clearSession)
		throws Exception {

		CatEntry newCatEntry = addCatEntry();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CatEntry.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("petId", newCatEntry.getPetId()));

		List<CatEntry> result = _persistence.findWithDynamicQuery(dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(CatEntry catEntry) {
		Assert.assertEquals(
			catEntry.getUuid(),
			ReflectionTestUtil.invoke(
				catEntry, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(catEntry.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				catEntry, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected CatEntry addCatEntry() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CatEntry catEntry = _persistence.create(pk);

		catEntry.setUuid(RandomTestUtil.randomString());

		catEntry.setGroupId(RandomTestUtil.nextLong());

		catEntry.setCompanyId(RandomTestUtil.nextLong());

		catEntry.setUserId(RandomTestUtil.nextLong());

		catEntry.setUserName(RandomTestUtil.randomString());

		catEntry.setCreateDate(RandomTestUtil.nextDate());

		catEntry.setModifiedDate(RandomTestUtil.nextDate());

		catEntry.setCreatorId(RandomTestUtil.nextLong());

		catEntry.setScopeOrgId(RandomTestUtil.nextLong());

		catEntry.setName(RandomTestUtil.randomString());

		catEntry.setTag(RandomTestUtil.randomString());

		catEntry.setStatus(RandomTestUtil.randomString());

		catEntry.setStatusDate(RandomTestUtil.nextDate());

		_catEntries.add(_persistence.update(catEntry));

		return catEntry;
	}

	private List<CatEntry> _catEntries = new ArrayList<CatEntry>();
	private CatEntryPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}