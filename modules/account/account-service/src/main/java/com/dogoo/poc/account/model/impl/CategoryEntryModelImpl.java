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

package com.dogoo.poc.account.model.impl;

import com.dogoo.poc.account.model.CategoryEntry;
import com.dogoo.poc.account.model.CategoryEntryModel;
import com.dogoo.poc.account.model.CategoryEntrySoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the CategoryEntry service. Represents a row in the &quot;DG_CategoryEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CategoryEntryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CategoryEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CategoryEntryImpl
 * @generated
 */
@JSON(strict = true)
public class CategoryEntryModelImpl
	extends BaseModelImpl<CategoryEntry> implements CategoryEntryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a category entry model instance should use the <code>CategoryEntry</code> interface instead.
	 */
	public static final String TABLE_NAME = "DG_CategoryEntry";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"categoryId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"type_", Types.VARCHAR}, {"name", Types.VARCHAR},
		{"code_", Types.INTEGER}, {"parentId", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("categoryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("type_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("code_", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("parentId", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table DG_CategoryEntry (uuid_ VARCHAR(75) null,categoryId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,type_ VARCHAR(75) null,name VARCHAR(75) null,code_ INTEGER,parentId VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table DG_CategoryEntry";

	public static final String ORDER_BY_JPQL =
		" ORDER BY categoryEntry.type ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY DG_CategoryEntry.type_ ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CODE_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long TYPE_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static CategoryEntry toModel(CategoryEntrySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CategoryEntry model = new CategoryEntryImpl();

		model.setUuid(soapModel.getUuid());
		model.setCategoryId(soapModel.getCategoryId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setType(soapModel.getType());
		model.setName(soapModel.getName());
		model.setCode(soapModel.getCode());
		model.setParentId(soapModel.getParentId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static List<CategoryEntry> toModels(CategoryEntrySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CategoryEntry> models = new ArrayList<CategoryEntry>(
			soapModels.length);

		for (CategoryEntrySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final String MAPPING_TABLE_DG_ACCOUNT_CATEGORY_NAME =
		"DG_Account_Category";

	public static final Object[][] MAPPING_TABLE_DG_ACCOUNT_CATEGORY_COLUMNS = {
		{"companyId", Types.BIGINT}, {"accountId", Types.BIGINT},
		{"categoryId", Types.BIGINT}
	};

	public static final String MAPPING_TABLE_DG_ACCOUNT_CATEGORY_SQL_CREATE =
		"create table DG_Account_Category (companyId LONG not null,accountId LONG not null,categoryId LONG not null,primary key (accountId, categoryId))";

	public CategoryEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _categoryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCategoryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _categoryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CategoryEntry.class;
	}

	@Override
	public String getModelClassName() {
		return CategoryEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CategoryEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CategoryEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CategoryEntry, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CategoryEntry)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CategoryEntry, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CategoryEntry, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CategoryEntry)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CategoryEntry, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CategoryEntry, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CategoryEntry>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CategoryEntry.class.getClassLoader(), CategoryEntry.class,
			ModelWrapper.class);

		try {
			Constructor<CategoryEntry> constructor =
				(Constructor<CategoryEntry>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<CategoryEntry, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CategoryEntry, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CategoryEntry, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<CategoryEntry, Object>>();
		Map<String, BiConsumer<CategoryEntry, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<CategoryEntry, ?>>();

		attributeGetterFunctions.put("uuid", CategoryEntry::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<CategoryEntry, String>)CategoryEntry::setUuid);
		attributeGetterFunctions.put(
			"categoryId", CategoryEntry::getCategoryId);
		attributeSetterBiConsumers.put(
			"categoryId",
			(BiConsumer<CategoryEntry, Long>)CategoryEntry::setCategoryId);
		attributeGetterFunctions.put("groupId", CategoryEntry::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<CategoryEntry, Long>)CategoryEntry::setGroupId);
		attributeGetterFunctions.put("companyId", CategoryEntry::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<CategoryEntry, Long>)CategoryEntry::setCompanyId);
		attributeGetterFunctions.put("userId", CategoryEntry::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<CategoryEntry, Long>)CategoryEntry::setUserId);
		attributeGetterFunctions.put("userName", CategoryEntry::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<CategoryEntry, String>)CategoryEntry::setUserName);
		attributeGetterFunctions.put(
			"createDate", CategoryEntry::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<CategoryEntry, Date>)CategoryEntry::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", CategoryEntry::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<CategoryEntry, Date>)CategoryEntry::setModifiedDate);
		attributeGetterFunctions.put("type", CategoryEntry::getType);
		attributeSetterBiConsumers.put(
			"type", (BiConsumer<CategoryEntry, String>)CategoryEntry::setType);
		attributeGetterFunctions.put("name", CategoryEntry::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<CategoryEntry, String>)CategoryEntry::setName);
		attributeGetterFunctions.put("code", CategoryEntry::getCode);
		attributeSetterBiConsumers.put(
			"code", (BiConsumer<CategoryEntry, Integer>)CategoryEntry::setCode);
		attributeGetterFunctions.put("parentId", CategoryEntry::getParentId);
		attributeSetterBiConsumers.put(
			"parentId",
			(BiConsumer<CategoryEntry, String>)CategoryEntry::setParentId);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public long getCategoryId() {
		return _categoryId;
	}

	@Override
	public void setCategoryId(long categoryId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_categoryId = categoryId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getType() {
		if (_type == null) {
			return "";
		}
		else {
			return _type;
		}
	}

	@Override
	public void setType(String type) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_type = type;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalType() {
		return getColumnOriginalValue("type_");
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_name = name;
	}

	@JSON
	@Override
	public int getCode() {
		return _code;
	}

	@Override
	public void setCode(int code) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_code = code;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public int getOriginalCode() {
		return GetterUtil.getInteger(
			this.<Integer>getColumnOriginalValue("code_"));
	}

	@JSON
	@Override
	public String getParentId() {
		if (_parentId == null) {
			return "";
		}
		else {
			return _parentId;
		}
	}

	@Override
	public void setParentId(String parentId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_parentId = parentId;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(CategoryEntry.class.getName()));
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), CategoryEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CategoryEntry toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CategoryEntry>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CategoryEntryImpl categoryEntryImpl = new CategoryEntryImpl();

		categoryEntryImpl.setUuid(getUuid());
		categoryEntryImpl.setCategoryId(getCategoryId());
		categoryEntryImpl.setGroupId(getGroupId());
		categoryEntryImpl.setCompanyId(getCompanyId());
		categoryEntryImpl.setUserId(getUserId());
		categoryEntryImpl.setUserName(getUserName());
		categoryEntryImpl.setCreateDate(getCreateDate());
		categoryEntryImpl.setModifiedDate(getModifiedDate());
		categoryEntryImpl.setType(getType());
		categoryEntryImpl.setName(getName());
		categoryEntryImpl.setCode(getCode());
		categoryEntryImpl.setParentId(getParentId());

		categoryEntryImpl.resetOriginalValues();

		return categoryEntryImpl;
	}

	@Override
	public int compareTo(CategoryEntry categoryEntry) {
		int value = 0;

		value = getType().compareTo(categoryEntry.getType());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CategoryEntry)) {
			return false;
		}

		CategoryEntry categoryEntry = (CategoryEntry)object;

		long primaryKey = categoryEntry.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<CategoryEntry> toCacheModel() {
		CategoryEntryCacheModel categoryEntryCacheModel =
			new CategoryEntryCacheModel();

		categoryEntryCacheModel.uuid = getUuid();

		String uuid = categoryEntryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			categoryEntryCacheModel.uuid = null;
		}

		categoryEntryCacheModel.categoryId = getCategoryId();

		categoryEntryCacheModel.groupId = getGroupId();

		categoryEntryCacheModel.companyId = getCompanyId();

		categoryEntryCacheModel.userId = getUserId();

		categoryEntryCacheModel.userName = getUserName();

		String userName = categoryEntryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			categoryEntryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			categoryEntryCacheModel.createDate = createDate.getTime();
		}
		else {
			categoryEntryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			categoryEntryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			categoryEntryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		categoryEntryCacheModel.type = getType();

		String type = categoryEntryCacheModel.type;

		if ((type != null) && (type.length() == 0)) {
			categoryEntryCacheModel.type = null;
		}

		categoryEntryCacheModel.name = getName();

		String name = categoryEntryCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			categoryEntryCacheModel.name = null;
		}

		categoryEntryCacheModel.code = getCode();

		categoryEntryCacheModel.parentId = getParentId();

		String parentId = categoryEntryCacheModel.parentId;

		if ((parentId != null) && (parentId.length() == 0)) {
			categoryEntryCacheModel.parentId = null;
		}

		return categoryEntryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CategoryEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CategoryEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CategoryEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((CategoryEntry)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<CategoryEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CategoryEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CategoryEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((CategoryEntry)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CategoryEntry>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private long _categoryId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _type;
	private String _name;
	private int _code;
	private String _parentId;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<CategoryEntry, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((CategoryEntry)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("categoryId", _categoryId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("type_", _type);
		_columnOriginalValues.put("name", _name);
		_columnOriginalValues.put("code_", _code);
		_columnOriginalValues.put("parentId", _parentId);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");
		attributeNames.put("type_", "type");
		attributeNames.put("code_", "code");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("categoryId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("userId", 16L);

		columnBitmasks.put("userName", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		columnBitmasks.put("type_", 256L);

		columnBitmasks.put("name", 512L);

		columnBitmasks.put("code_", 1024L);

		columnBitmasks.put("parentId", 2048L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private CategoryEntry _escapedModel;

}