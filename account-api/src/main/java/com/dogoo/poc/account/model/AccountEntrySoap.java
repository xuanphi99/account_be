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

package com.dogoo.poc.account.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.dogoo.poc.account.service.http.AccountEntryServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class AccountEntrySoap implements Serializable {

	public static AccountEntrySoap toSoapModel(AccountEntry model) {
		AccountEntrySoap soapModel = new AccountEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setAccountId(model.getAccountId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setFullName(model.getFullName());
		soapModel.setEmail(model.getEmail());
		soapModel.setNewUser(model.getNewUser());
		soapModel.setPassword(model.getPassword());
		soapModel.setPhone(model.getPhone());
		soapModel.setDepartmentId(model.getDepartmentId());
		soapModel.setPositionId(model.getPositionId());
		soapModel.setUserIdMapping(model.getUserIdMapping());
		soapModel.setStatus(model.getStatus());
		soapModel.setAvatarName(model.getAvatarName());
		soapModel.setAvatarPath(model.getAvatarPath());

		return soapModel;
	}

	public static AccountEntrySoap[] toSoapModels(AccountEntry[] models) {
		AccountEntrySoap[] soapModels = new AccountEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AccountEntrySoap[][] toSoapModels(AccountEntry[][] models) {
		AccountEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AccountEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new AccountEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AccountEntrySoap[] toSoapModels(List<AccountEntry> models) {
		List<AccountEntrySoap> soapModels = new ArrayList<AccountEntrySoap>(
			models.size());

		for (AccountEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AccountEntrySoap[soapModels.size()]);
	}

	public AccountEntrySoap() {
	}

	public long getPrimaryKey() {
		return _accountId;
	}

	public void setPrimaryKey(long pk) {
		setAccountId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getAccountId() {
		return _accountId;
	}

	public void setAccountId(long accountId) {
		_accountId = accountId;
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

	public String getFullName() {
		return _fullName;
	}

	public void setFullName(String fullName) {
		_fullName = fullName;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getNewUser() {
		return _newUser;
	}

	public void setNewUser(String newUser) {
		_newUser = newUser;
	}

	public String getPassword() {
		return _password;
	}

	public void setPassword(String password) {
		_password = password;
	}

	public String getPhone() {
		return _phone;
	}

	public void setPhone(String phone) {
		_phone = phone;
	}

	public long getDepartmentId() {
		return _departmentId;
	}

	public void setDepartmentId(long departmentId) {
		_departmentId = departmentId;
	}

	public long getPositionId() {
		return _positionId;
	}

	public void setPositionId(long positionId) {
		_positionId = positionId;
	}

	public int getUserIdMapping() {
		return _userIdMapping;
	}

	public void setUserIdMapping(int userIdMapping) {
		_userIdMapping = userIdMapping;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public String getAvatarName() {
		return _avatarName;
	}

	public void setAvatarName(String avatarName) {
		_avatarName = avatarName;
	}

	public String getAvatarPath() {
		return _avatarPath;
	}

	public void setAvatarPath(String avatarPath) {
		_avatarPath = avatarPath;
	}

	private String _uuid;
	private long _accountId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
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

}