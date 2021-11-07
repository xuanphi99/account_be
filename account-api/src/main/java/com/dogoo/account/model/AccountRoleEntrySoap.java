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

package com.dogoo.account.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.dogoo.account.service.http.AccountRoleEntryServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class AccountRoleEntrySoap implements Serializable {

	public static AccountRoleEntrySoap toSoapModel(AccountRoleEntry model) {
		AccountRoleEntrySoap soapModel = new AccountRoleEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setAccountRoleId(model.getAccountRoleId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setAccountId(model.getAccountId());
		soapModel.setName(model.getName());
		soapModel.setCode(model.getCode());

		return soapModel;
	}

	public static AccountRoleEntrySoap[] toSoapModels(
		AccountRoleEntry[] models) {

		AccountRoleEntrySoap[] soapModels =
			new AccountRoleEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AccountRoleEntrySoap[][] toSoapModels(
		AccountRoleEntry[][] models) {

		AccountRoleEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new AccountRoleEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new AccountRoleEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AccountRoleEntrySoap[] toSoapModels(
		List<AccountRoleEntry> models) {

		List<AccountRoleEntrySoap> soapModels =
			new ArrayList<AccountRoleEntrySoap>(models.size());

		for (AccountRoleEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AccountRoleEntrySoap[soapModels.size()]);
	}

	public AccountRoleEntrySoap() {
	}

	public long getPrimaryKey() {
		return _AccountRoleId;
	}

	public void setPrimaryKey(long pk) {
		setAccountRoleId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getAccountRoleId() {
		return _AccountRoleId;
	}

	public void setAccountRoleId(long AccountRoleId) {
		_AccountRoleId = AccountRoleId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getAccountId() {
		return _AccountId;
	}

	public void setAccountId(long AccountId) {
		_AccountId = AccountId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	private String _uuid;
	private long _AccountRoleId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _AccountId;
	private String _name;
	private String _code;

}