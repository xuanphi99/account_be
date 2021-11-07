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

import com.dogoo.poc.account.model.AccountEntry;
import com.dogoo.poc.account.model.AccountEntryModel;
import com.dogoo.poc.account.model.AccountEntrySoap;

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
 * The base model implementation for the AccountEntry service. Represents a row in the &quot;DG_AccountEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>AccountEntryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AccountEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AccountEntryImpl
 * @generated
 */
@JSON(strict = true)
public class AccountEntryModelImpl
	extends BaseModelImpl<AccountEntry> implements AccountEntryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a account entry model instance should use the <code>AccountEntry</code> interface instead.
	 */
	public static final String TABLE_NAME = "DG_AccountEntry";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"accountId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"fullName", Types.VARCHAR}, {"email", Types.VARCHAR},
		{"newUser", Types.VARCHAR}, {"password_", Types.VARCHAR},
		{"phone", Types.VARCHAR}, {"departmentId", Types.BIGINT},
		{"positionId", Types.BIGINT}, {"userIdMapping", Types.INTEGER},
		{"status", Types.VARCHAR}, {"avatarName", Types.VARCHAR},
		{"avatarPath", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("accountId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("fullName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("email", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("newUser", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("password_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("phone", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("departmentId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("positionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userIdMapping", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("status", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("avatarName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("avatarPath", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table DG_AccountEntry (uuid_ VARCHAR(75) null,accountId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,fullName VARCHAR(75) null,email VARCHAR(75) null,newUser VARCHAR(75) null,password_ VARCHAR(75) null,phone VARCHAR(75) null,departmentId LONG,positionId LONG,userIdMapping INTEGER,status VARCHAR(75) null,avatarName VARCHAR(75) null,avatarPath VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table DG_AccountEntry";

	public static final String ORDER_BY_JPQL =
		" ORDER BY accountEntry.fullName ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY DG_AccountEntry.fullName ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long EMAIL_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long FULLNAME_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long NEWUSER_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 32L;

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
	public static AccountEntry toModel(AccountEntrySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		AccountEntry model = new AccountEntryImpl();

		model.setUuid(soapModel.getUuid());
		model.setAccountId(soapModel.getAccountId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setFullName(soapModel.getFullName());
		model.setEmail(soapModel.getEmail());
		model.setNewUser(soapModel.getNewUser());
		model.setPassword(soapModel.getPassword());
		model.setPhone(soapModel.getPhone());
		model.setDepartmentId(soapModel.getDepartmentId());
		model.setPositionId(soapModel.getPositionId());
		model.setUserIdMapping(soapModel.getUserIdMapping());
		model.setStatus(soapModel.getStatus());
		model.setAvatarName(soapModel.getAvatarName());
		model.setAvatarPath(soapModel.getAvatarPath());

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
	public static List<AccountEntry> toModels(AccountEntrySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<AccountEntry> models = new ArrayList<AccountEntry>(
			soapModels.length);

		for (AccountEntrySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public AccountEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _accountId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAccountId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _accountId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return AccountEntry.class;
	}

	@Override
	public String getModelClassName() {
		return AccountEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<AccountEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<AccountEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AccountEntry, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((AccountEntry)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<AccountEntry, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<AccountEntry, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(AccountEntry)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<AccountEntry, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<AccountEntry, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, AccountEntry>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			AccountEntry.class.getClassLoader(), AccountEntry.class,
			ModelWrapper.class);

		try {
			Constructor<AccountEntry> constructor =
				(Constructor<AccountEntry>)proxyClass.getConstructor(
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

	private static final Map<String, Function<AccountEntry, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<AccountEntry, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<AccountEntry, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<AccountEntry, Object>>();
		Map<String, BiConsumer<AccountEntry, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<AccountEntry, ?>>();

		attributeGetterFunctions.put("uuid", AccountEntry::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<AccountEntry, String>)AccountEntry::setUuid);
		attributeGetterFunctions.put("accountId", AccountEntry::getAccountId);
		attributeSetterBiConsumers.put(
			"accountId",
			(BiConsumer<AccountEntry, Long>)AccountEntry::setAccountId);
		attributeGetterFunctions.put("groupId", AccountEntry::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<AccountEntry, Long>)AccountEntry::setGroupId);
		attributeGetterFunctions.put("companyId", AccountEntry::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<AccountEntry, Long>)AccountEntry::setCompanyId);
		attributeGetterFunctions.put("userId", AccountEntry::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<AccountEntry, Long>)AccountEntry::setUserId);
		attributeGetterFunctions.put("userName", AccountEntry::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<AccountEntry, String>)AccountEntry::setUserName);
		attributeGetterFunctions.put("createDate", AccountEntry::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<AccountEntry, Date>)AccountEntry::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", AccountEntry::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<AccountEntry, Date>)AccountEntry::setModifiedDate);
		attributeGetterFunctions.put("fullName", AccountEntry::getFullName);
		attributeSetterBiConsumers.put(
			"fullName",
			(BiConsumer<AccountEntry, String>)AccountEntry::setFullName);
		attributeGetterFunctions.put("email", AccountEntry::getEmail);
		attributeSetterBiConsumers.put(
			"email", (BiConsumer<AccountEntry, String>)AccountEntry::setEmail);
		attributeGetterFunctions.put("newUser", AccountEntry::getNewUser);
		attributeSetterBiConsumers.put(
			"newUser",
			(BiConsumer<AccountEntry, String>)AccountEntry::setNewUser);
		attributeGetterFunctions.put("password", AccountEntry::getPassword);
		attributeSetterBiConsumers.put(
			"password",
			(BiConsumer<AccountEntry, String>)AccountEntry::setPassword);
		attributeGetterFunctions.put("phone", AccountEntry::getPhone);
		attributeSetterBiConsumers.put(
			"phone", (BiConsumer<AccountEntry, String>)AccountEntry::setPhone);
		attributeGetterFunctions.put(
			"departmentId", AccountEntry::getDepartmentId);
		attributeSetterBiConsumers.put(
			"departmentId",
			(BiConsumer<AccountEntry, Long>)AccountEntry::setDepartmentId);
		attributeGetterFunctions.put("positionId", AccountEntry::getPositionId);
		attributeSetterBiConsumers.put(
			"positionId",
			(BiConsumer<AccountEntry, Long>)AccountEntry::setPositionId);
		attributeGetterFunctions.put(
			"userIdMapping", AccountEntry::getUserIdMapping);
		attributeSetterBiConsumers.put(
			"userIdMapping",
			(BiConsumer<AccountEntry, Integer>)AccountEntry::setUserIdMapping);
		attributeGetterFunctions.put("status", AccountEntry::getStatus);
		attributeSetterBiConsumers.put(
			"status",
			(BiConsumer<AccountEntry, String>)AccountEntry::setStatus);
		attributeGetterFunctions.put("avatarName", AccountEntry::getAvatarName);
		attributeSetterBiConsumers.put(
			"avatarName",
			(BiConsumer<AccountEntry, String>)AccountEntry::setAvatarName);
		attributeGetterFunctions.put("avatarPath", AccountEntry::getAvatarPath);
		attributeSetterBiConsumers.put(
			"avatarPath",
			(BiConsumer<AccountEntry, String>)AccountEntry::setAvatarPath);

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
	public long getAccountId() {
		return _accountId;
	}

	@Override
	public void setAccountId(long accountId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_accountId = accountId;
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
	public String getFullName() {
		if (_fullName == null) {
			return "";
		}
		else {
			return _fullName;
		}
	}

	@Override
	public void setFullName(String fullName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fullName = fullName;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalFullName() {
		return getColumnOriginalValue("fullName");
	}

	@JSON
	@Override
	public String getEmail() {
		if (_email == null) {
			return "";
		}
		else {
			return _email;
		}
	}

	@Override
	public void setEmail(String email) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_email = email;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalEmail() {
		return getColumnOriginalValue("email");
	}

	@JSON
	@Override
	public String getNewUser() {
		if (_newUser == null) {
			return "";
		}
		else {
			return _newUser;
		}
	}

	@Override
	public void setNewUser(String newUser) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_newUser = newUser;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalNewUser() {
		return getColumnOriginalValue("newUser");
	}

	@JSON
	@Override
	public String getPassword() {
		if (_password == null) {
			return "";
		}
		else {
			return _password;
		}
	}

	@Override
	public void setPassword(String password) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_password = password;
	}

	@JSON
	@Override
	public String getPhone() {
		if (_phone == null) {
			return "";
		}
		else {
			return _phone;
		}
	}

	@Override
	public void setPhone(String phone) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_phone = phone;
	}

	@JSON
	@Override
	public long getDepartmentId() {
		return _departmentId;
	}

	@Override
	public void setDepartmentId(long departmentId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_departmentId = departmentId;
	}

	@JSON
	@Override
	public long getPositionId() {
		return _positionId;
	}

	@Override
	public void setPositionId(long positionId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_positionId = positionId;
	}

	@JSON
	@Override
	public int getUserIdMapping() {
		return _userIdMapping;
	}

	@Override
	public void setUserIdMapping(int userIdMapping) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userIdMapping = userIdMapping;
	}

	@JSON
	@Override
	public String getStatus() {
		if (_status == null) {
			return "";
		}
		else {
			return _status;
		}
	}

	@Override
	public void setStatus(String status) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_status = status;
	}

	@JSON
	@Override
	public String getAvatarName() {
		if (_avatarName == null) {
			return "";
		}
		else {
			return _avatarName;
		}
	}

	@Override
	public void setAvatarName(String avatarName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_avatarName = avatarName;
	}

	@JSON
	@Override
	public String getAvatarPath() {
		if (_avatarPath == null) {
			return "";
		}
		else {
			return _avatarPath;
		}
	}

	@Override
	public void setAvatarPath(String avatarPath) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_avatarPath = avatarPath;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(AccountEntry.class.getName()));
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
			getCompanyId(), AccountEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public AccountEntry toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, AccountEntry>
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
		AccountEntryImpl accountEntryImpl = new AccountEntryImpl();

		accountEntryImpl.setUuid(getUuid());
		accountEntryImpl.setAccountId(getAccountId());
		accountEntryImpl.setGroupId(getGroupId());
		accountEntryImpl.setCompanyId(getCompanyId());
		accountEntryImpl.setUserId(getUserId());
		accountEntryImpl.setUserName(getUserName());
		accountEntryImpl.setCreateDate(getCreateDate());
		accountEntryImpl.setModifiedDate(getModifiedDate());
		accountEntryImpl.setFullName(getFullName());
		accountEntryImpl.setEmail(getEmail());
		accountEntryImpl.setNewUser(getNewUser());
		accountEntryImpl.setPassword(getPassword());
		accountEntryImpl.setPhone(getPhone());
		accountEntryImpl.setDepartmentId(getDepartmentId());
		accountEntryImpl.setPositionId(getPositionId());
		accountEntryImpl.setUserIdMapping(getUserIdMapping());
		accountEntryImpl.setStatus(getStatus());
		accountEntryImpl.setAvatarName(getAvatarName());
		accountEntryImpl.setAvatarPath(getAvatarPath());

		accountEntryImpl.resetOriginalValues();

		return accountEntryImpl;
	}

	@Override
	public int compareTo(AccountEntry accountEntry) {
		int value = 0;

		value = getFullName().compareTo(accountEntry.getFullName());

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

		if (!(object instanceof AccountEntry)) {
			return false;
		}

		AccountEntry accountEntry = (AccountEntry)object;

		long primaryKey = accountEntry.getPrimaryKey();

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
	public CacheModel<AccountEntry> toCacheModel() {
		AccountEntryCacheModel accountEntryCacheModel =
			new AccountEntryCacheModel();

		accountEntryCacheModel.uuid = getUuid();

		String uuid = accountEntryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			accountEntryCacheModel.uuid = null;
		}

		accountEntryCacheModel.accountId = getAccountId();

		accountEntryCacheModel.groupId = getGroupId();

		accountEntryCacheModel.companyId = getCompanyId();

		accountEntryCacheModel.userId = getUserId();

		accountEntryCacheModel.userName = getUserName();

		String userName = accountEntryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			accountEntryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			accountEntryCacheModel.createDate = createDate.getTime();
		}
		else {
			accountEntryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			accountEntryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			accountEntryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		accountEntryCacheModel.fullName = getFullName();

		String fullName = accountEntryCacheModel.fullName;

		if ((fullName != null) && (fullName.length() == 0)) {
			accountEntryCacheModel.fullName = null;
		}

		accountEntryCacheModel.email = getEmail();

		String email = accountEntryCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			accountEntryCacheModel.email = null;
		}

		accountEntryCacheModel.newUser = getNewUser();

		String newUser = accountEntryCacheModel.newUser;

		if ((newUser != null) && (newUser.length() == 0)) {
			accountEntryCacheModel.newUser = null;
		}

		accountEntryCacheModel.password = getPassword();

		String password = accountEntryCacheModel.password;

		if ((password != null) && (password.length() == 0)) {
			accountEntryCacheModel.password = null;
		}

		accountEntryCacheModel.phone = getPhone();

		String phone = accountEntryCacheModel.phone;

		if ((phone != null) && (phone.length() == 0)) {
			accountEntryCacheModel.phone = null;
		}

		accountEntryCacheModel.departmentId = getDepartmentId();

		accountEntryCacheModel.positionId = getPositionId();

		accountEntryCacheModel.userIdMapping = getUserIdMapping();

		accountEntryCacheModel.status = getStatus();

		String status = accountEntryCacheModel.status;

		if ((status != null) && (status.length() == 0)) {
			accountEntryCacheModel.status = null;
		}

		accountEntryCacheModel.avatarName = getAvatarName();

		String avatarName = accountEntryCacheModel.avatarName;

		if ((avatarName != null) && (avatarName.length() == 0)) {
			accountEntryCacheModel.avatarName = null;
		}

		accountEntryCacheModel.avatarPath = getAvatarPath();

		String avatarPath = accountEntryCacheModel.avatarPath;

		if ((avatarPath != null) && (avatarPath.length() == 0)) {
			accountEntryCacheModel.avatarPath = null;
		}

		return accountEntryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<AccountEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<AccountEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AccountEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((AccountEntry)this));
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
		Map<String, Function<AccountEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<AccountEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AccountEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((AccountEntry)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, AccountEntry>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private long _accountId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _fullName;
	private String _email;
	private String _newUser;
	private String _password;
	private String _phone;
	private long _departmentId;
	private long _positionId;
	private int _userIdMapping;
	private String _status;
	private String _avatarName;
	private String _avatarPath;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<AccountEntry, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((AccountEntry)this);
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
		_columnOriginalValues.put("accountId", _accountId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("fullName", _fullName);
		_columnOriginalValues.put("email", _email);
		_columnOriginalValues.put("newUser", _newUser);
		_columnOriginalValues.put("password_", _password);
		_columnOriginalValues.put("phone", _phone);
		_columnOriginalValues.put("departmentId", _departmentId);
		_columnOriginalValues.put("positionId", _positionId);
		_columnOriginalValues.put("userIdMapping", _userIdMapping);
		_columnOriginalValues.put("status", _status);
		_columnOriginalValues.put("avatarName", _avatarName);
		_columnOriginalValues.put("avatarPath", _avatarPath);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");
		attributeNames.put("password_", "password");

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

		columnBitmasks.put("accountId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("userId", 16L);

		columnBitmasks.put("userName", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		columnBitmasks.put("fullName", 256L);

		columnBitmasks.put("email", 512L);

		columnBitmasks.put("newUser", 1024L);

		columnBitmasks.put("password_", 2048L);

		columnBitmasks.put("phone", 4096L);

		columnBitmasks.put("departmentId", 8192L);

		columnBitmasks.put("positionId", 16384L);

		columnBitmasks.put("userIdMapping", 32768L);

		columnBitmasks.put("status", 65536L);

		columnBitmasks.put("avatarName", 131072L);

		columnBitmasks.put("avatarPath", 262144L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private AccountEntry _escapedModel;

}