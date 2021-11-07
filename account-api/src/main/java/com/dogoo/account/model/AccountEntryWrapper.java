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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AccountEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AccountEntry
 * @generated
 */
public class AccountEntryWrapper
	extends BaseModelWrapper<AccountEntry>
	implements AccountEntry, ModelWrapper<AccountEntry> {

	public AccountEntryWrapper(AccountEntry accountEntry) {
		super(accountEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("accountId", getAccountId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("fullName", getFullName());
		attributes.put("email", getEmail());
		attributes.put("newUser", getNewUser());
		attributes.put("password", getPassword());
		attributes.put("phone", getPhone());
		attributes.put("departmentId", getDepartmentId());
		attributes.put("positionId", getPositionId());
		attributes.put("userIdMapping", getUserIdMapping());
		attributes.put("status", getStatus());
		attributes.put("avatarName", getAvatarName());
		attributes.put("avatarPath", getAvatarPath());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long accountId = (Long)attributes.get("accountId");

		if (accountId != null) {
			setAccountId(accountId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String fullName = (String)attributes.get("fullName");

		if (fullName != null) {
			setFullName(fullName);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String newUser = (String)attributes.get("newUser");

		if (newUser != null) {
			setNewUser(newUser);
		}

		String password = (String)attributes.get("password");

		if (password != null) {
			setPassword(password);
		}

		String phone = (String)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		Long departmentId = (Long)attributes.get("departmentId");

		if (departmentId != null) {
			setDepartmentId(departmentId);
		}

		Long positionId = (Long)attributes.get("positionId");

		if (positionId != null) {
			setPositionId(positionId);
		}

		Integer userIdMapping = (Integer)attributes.get("userIdMapping");

		if (userIdMapping != null) {
			setUserIdMapping(userIdMapping);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String avatarName = (String)attributes.get("avatarName");

		if (avatarName != null) {
			setAvatarName(avatarName);
		}

		String avatarPath = (String)attributes.get("avatarPath");

		if (avatarPath != null) {
			setAvatarPath(avatarPath);
		}
	}

	/**
	 * Returns the account ID of this account entry.
	 *
	 * @return the account ID of this account entry
	 */
	@Override
	public long getAccountId() {
		return model.getAccountId();
	}

	/**
	 * Returns the avatar name of this account entry.
	 *
	 * @return the avatar name of this account entry
	 */
	@Override
	public String getAvatarName() {
		return model.getAvatarName();
	}

	/**
	 * Returns the avatar path of this account entry.
	 *
	 * @return the avatar path of this account entry
	 */
	@Override
	public String getAvatarPath() {
		return model.getAvatarPath();
	}

	/**
	 * Returns the company ID of this account entry.
	 *
	 * @return the company ID of this account entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this account entry.
	 *
	 * @return the create date of this account entry
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the department ID of this account entry.
	 *
	 * @return the department ID of this account entry
	 */
	@Override
	public long getDepartmentId() {
		return model.getDepartmentId();
	}

	/**
	 * Returns the email of this account entry.
	 *
	 * @return the email of this account entry
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the full name of this account entry.
	 *
	 * @return the full name of this account entry
	 */
	@Override
	public String getFullName() {
		return model.getFullName();
	}

	/**
	 * Returns the group ID of this account entry.
	 *
	 * @return the group ID of this account entry
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this account entry.
	 *
	 * @return the modified date of this account entry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the new user of this account entry.
	 *
	 * @return the new user of this account entry
	 */
	@Override
	public String getNewUser() {
		return model.getNewUser();
	}

	/**
	 * Returns the password of this account entry.
	 *
	 * @return the password of this account entry
	 */
	@Override
	public String getPassword() {
		return model.getPassword();
	}

	/**
	 * Returns the phone of this account entry.
	 *
	 * @return the phone of this account entry
	 */
	@Override
	public String getPhone() {
		return model.getPhone();
	}

	/**
	 * Returns the position ID of this account entry.
	 *
	 * @return the position ID of this account entry
	 */
	@Override
	public long getPositionId() {
		return model.getPositionId();
	}

	/**
	 * Returns the primary key of this account entry.
	 *
	 * @return the primary key of this account entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this account entry.
	 *
	 * @return the status of this account entry
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this account entry.
	 *
	 * @return the user ID of this account entry
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user ID mapping of this account entry.
	 *
	 * @return the user ID mapping of this account entry
	 */
	@Override
	public int getUserIdMapping() {
		return model.getUserIdMapping();
	}

	/**
	 * Returns the user name of this account entry.
	 *
	 * @return the user name of this account entry
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this account entry.
	 *
	 * @return the user uuid of this account entry
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this account entry.
	 *
	 * @return the uuid of this account entry
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the account ID of this account entry.
	 *
	 * @param accountId the account ID of this account entry
	 */
	@Override
	public void setAccountId(long accountId) {
		model.setAccountId(accountId);
	}

	/**
	 * Sets the avatar name of this account entry.
	 *
	 * @param avatarName the avatar name of this account entry
	 */
	@Override
	public void setAvatarName(String avatarName) {
		model.setAvatarName(avatarName);
	}

	/**
	 * Sets the avatar path of this account entry.
	 *
	 * @param avatarPath the avatar path of this account entry
	 */
	@Override
	public void setAvatarPath(String avatarPath) {
		model.setAvatarPath(avatarPath);
	}

	/**
	 * Sets the company ID of this account entry.
	 *
	 * @param companyId the company ID of this account entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this account entry.
	 *
	 * @param createDate the create date of this account entry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the department ID of this account entry.
	 *
	 * @param departmentId the department ID of this account entry
	 */
	@Override
	public void setDepartmentId(long departmentId) {
		model.setDepartmentId(departmentId);
	}

	/**
	 * Sets the email of this account entry.
	 *
	 * @param email the email of this account entry
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the full name of this account entry.
	 *
	 * @param fullName the full name of this account entry
	 */
	@Override
	public void setFullName(String fullName) {
		model.setFullName(fullName);
	}

	/**
	 * Sets the group ID of this account entry.
	 *
	 * @param groupId the group ID of this account entry
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this account entry.
	 *
	 * @param modifiedDate the modified date of this account entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the new user of this account entry.
	 *
	 * @param newUser the new user of this account entry
	 */
	@Override
	public void setNewUser(String newUser) {
		model.setNewUser(newUser);
	}

	/**
	 * Sets the password of this account entry.
	 *
	 * @param password the password of this account entry
	 */
	@Override
	public void setPassword(String password) {
		model.setPassword(password);
	}

	/**
	 * Sets the phone of this account entry.
	 *
	 * @param phone the phone of this account entry
	 */
	@Override
	public void setPhone(String phone) {
		model.setPhone(phone);
	}

	/**
	 * Sets the position ID of this account entry.
	 *
	 * @param positionId the position ID of this account entry
	 */
	@Override
	public void setPositionId(long positionId) {
		model.setPositionId(positionId);
	}

	/**
	 * Sets the primary key of this account entry.
	 *
	 * @param primaryKey the primary key of this account entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this account entry.
	 *
	 * @param status the status of this account entry
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this account entry.
	 *
	 * @param userId the user ID of this account entry
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user ID mapping of this account entry.
	 *
	 * @param userIdMapping the user ID mapping of this account entry
	 */
	@Override
	public void setUserIdMapping(int userIdMapping) {
		model.setUserIdMapping(userIdMapping);
	}

	/**
	 * Sets the user name of this account entry.
	 *
	 * @param userName the user name of this account entry
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this account entry.
	 *
	 * @param userUuid the user uuid of this account entry
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this account entry.
	 *
	 * @param uuid the uuid of this account entry
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected AccountEntryWrapper wrap(AccountEntry accountEntry) {
		return new AccountEntryWrapper(accountEntry);
	}

}