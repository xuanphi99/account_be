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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the AccountEntry service. Represents a row in the &quot;DG_AccountEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.dogoo.poc.account.model.impl.AccountEntryModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.dogoo.poc.account.model.impl.AccountEntryImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AccountEntry
 * @generated
 */
@ProviderType
public interface AccountEntryModel
	extends BaseModel<AccountEntry>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a account entry model instance should use the {@link AccountEntry} interface instead.
	 */

	/**
	 * Returns the primary key of this account entry.
	 *
	 * @return the primary key of this account entry
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this account entry.
	 *
	 * @param primaryKey the primary key of this account entry
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this account entry.
	 *
	 * @return the uuid of this account entry
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this account entry.
	 *
	 * @param uuid the uuid of this account entry
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the account ID of this account entry.
	 *
	 * @return the account ID of this account entry
	 */
	public long getAccountId();

	/**
	 * Sets the account ID of this account entry.
	 *
	 * @param accountId the account ID of this account entry
	 */
	public void setAccountId(long accountId);

	/**
	 * Returns the group ID of this account entry.
	 *
	 * @return the group ID of this account entry
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this account entry.
	 *
	 * @param groupId the group ID of this account entry
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this account entry.
	 *
	 * @return the company ID of this account entry
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this account entry.
	 *
	 * @param companyId the company ID of this account entry
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this account entry.
	 *
	 * @return the user ID of this account entry
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this account entry.
	 *
	 * @param userId the user ID of this account entry
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this account entry.
	 *
	 * @return the user uuid of this account entry
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this account entry.
	 *
	 * @param userUuid the user uuid of this account entry
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this account entry.
	 *
	 * @return the user name of this account entry
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this account entry.
	 *
	 * @param userName the user name of this account entry
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this account entry.
	 *
	 * @return the create date of this account entry
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this account entry.
	 *
	 * @param createDate the create date of this account entry
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this account entry.
	 *
	 * @return the modified date of this account entry
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this account entry.
	 *
	 * @param modifiedDate the modified date of this account entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the full name of this account entry.
	 *
	 * @return the full name of this account entry
	 */
	@AutoEscape
	public String getFullName();

	/**
	 * Sets the full name of this account entry.
	 *
	 * @param fullName the full name of this account entry
	 */
	public void setFullName(String fullName);

	/**
	 * Returns the email of this account entry.
	 *
	 * @return the email of this account entry
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this account entry.
	 *
	 * @param email the email of this account entry
	 */
	public void setEmail(String email);

	/**
	 * Returns the new user of this account entry.
	 *
	 * @return the new user of this account entry
	 */
	@AutoEscape
	public String getNewUser();

	/**
	 * Sets the new user of this account entry.
	 *
	 * @param newUser the new user of this account entry
	 */
	public void setNewUser(String newUser);

	/**
	 * Returns the password of this account entry.
	 *
	 * @return the password of this account entry
	 */
	@AutoEscape
	public String getPassword();

	/**
	 * Sets the password of this account entry.
	 *
	 * @param password the password of this account entry
	 */
	public void setPassword(String password);

	/**
	 * Returns the phone of this account entry.
	 *
	 * @return the phone of this account entry
	 */
	@AutoEscape
	public String getPhone();

	/**
	 * Sets the phone of this account entry.
	 *
	 * @param phone the phone of this account entry
	 */
	public void setPhone(String phone);

	/**
	 * Returns the department ID of this account entry.
	 *
	 * @return the department ID of this account entry
	 */
	public long getDepartmentId();

	/**
	 * Sets the department ID of this account entry.
	 *
	 * @param departmentId the department ID of this account entry
	 */
	public void setDepartmentId(long departmentId);

	/**
	 * Returns the position ID of this account entry.
	 *
	 * @return the position ID of this account entry
	 */
	public long getPositionId();

	/**
	 * Sets the position ID of this account entry.
	 *
	 * @param positionId the position ID of this account entry
	 */
	public void setPositionId(long positionId);

	/**
	 * Returns the user ID mapping of this account entry.
	 *
	 * @return the user ID mapping of this account entry
	 */
	public int getUserIdMapping();

	/**
	 * Sets the user ID mapping of this account entry.
	 *
	 * @param userIdMapping the user ID mapping of this account entry
	 */
	public void setUserIdMapping(int userIdMapping);

	/**
	 * Returns the status of this account entry.
	 *
	 * @return the status of this account entry
	 */
	@AutoEscape
	public String getStatus();

	/**
	 * Sets the status of this account entry.
	 *
	 * @param status the status of this account entry
	 */
	public void setStatus(String status);

	/**
	 * Returns the avatar name of this account entry.
	 *
	 * @return the avatar name of this account entry
	 */
	@AutoEscape
	public String getAvatarName();

	/**
	 * Sets the avatar name of this account entry.
	 *
	 * @param avatarName the avatar name of this account entry
	 */
	public void setAvatarName(String avatarName);

	/**
	 * Returns the avatar path of this account entry.
	 *
	 * @return the avatar path of this account entry
	 */
	@AutoEscape
	public String getAvatarPath();

	/**
	 * Sets the avatar path of this account entry.
	 *
	 * @param avatarPath the avatar path of this account entry
	 */
	public void setAvatarPath(String avatarPath);

}