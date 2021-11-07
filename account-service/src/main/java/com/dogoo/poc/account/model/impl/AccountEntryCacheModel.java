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

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AccountEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AccountEntryCacheModel
	implements CacheModel<AccountEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AccountEntryCacheModel)) {
			return false;
		}

		AccountEntryCacheModel accountEntryCacheModel =
			(AccountEntryCacheModel)object;

		if (accountId == accountEntryCacheModel.accountId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, accountId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", accountId=");
		sb.append(accountId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", fullName=");
		sb.append(fullName);
		sb.append(", email=");
		sb.append(email);
		sb.append(", newUser=");
		sb.append(newUser);
		sb.append(", password=");
		sb.append(password);
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", departmentId=");
		sb.append(departmentId);
		sb.append(", positionId=");
		sb.append(positionId);
		sb.append(", userIdMapping=");
		sb.append(userIdMapping);
		sb.append(", status=");
		sb.append(status);
		sb.append(", avatarName=");
		sb.append(avatarName);
		sb.append(", avatarPath=");
		sb.append(avatarPath);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AccountEntry toEntityModel() {
		AccountEntryImpl accountEntryImpl = new AccountEntryImpl();

		if (uuid == null) {
			accountEntryImpl.setUuid("");
		}
		else {
			accountEntryImpl.setUuid(uuid);
		}

		accountEntryImpl.setAccountId(accountId);
		accountEntryImpl.setGroupId(groupId);
		accountEntryImpl.setCompanyId(companyId);
		accountEntryImpl.setUserId(userId);

		if (userName == null) {
			accountEntryImpl.setUserName("");
		}
		else {
			accountEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			accountEntryImpl.setCreateDate(null);
		}
		else {
			accountEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			accountEntryImpl.setModifiedDate(null);
		}
		else {
			accountEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (fullName == null) {
			accountEntryImpl.setFullName("");
		}
		else {
			accountEntryImpl.setFullName(fullName);
		}

		if (email == null) {
			accountEntryImpl.setEmail("");
		}
		else {
			accountEntryImpl.setEmail(email);
		}

		if (newUser == null) {
			accountEntryImpl.setNewUser("");
		}
		else {
			accountEntryImpl.setNewUser(newUser);
		}

		if (password == null) {
			accountEntryImpl.setPassword("");
		}
		else {
			accountEntryImpl.setPassword(password);
		}

		if (phone == null) {
			accountEntryImpl.setPhone("");
		}
		else {
			accountEntryImpl.setPhone(phone);
		}

		accountEntryImpl.setDepartmentId(departmentId);
		accountEntryImpl.setPositionId(positionId);
		accountEntryImpl.setUserIdMapping(userIdMapping);

		if (status == null) {
			accountEntryImpl.setStatus("");
		}
		else {
			accountEntryImpl.setStatus(status);
		}

		if (avatarName == null) {
			accountEntryImpl.setAvatarName("");
		}
		else {
			accountEntryImpl.setAvatarName(avatarName);
		}

		if (avatarPath == null) {
			accountEntryImpl.setAvatarPath("");
		}
		else {
			accountEntryImpl.setAvatarPath(avatarPath);
		}

		accountEntryImpl.resetOriginalValues();

		return accountEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		accountId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		fullName = objectInput.readUTF();
		email = objectInput.readUTF();
		newUser = objectInput.readUTF();
		password = objectInput.readUTF();
		phone = objectInput.readUTF();

		departmentId = objectInput.readLong();

		positionId = objectInput.readLong();

		userIdMapping = objectInput.readInt();
		status = objectInput.readUTF();
		avatarName = objectInput.readUTF();
		avatarPath = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(accountId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (fullName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fullName);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (newUser == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(newUser);
		}

		if (password == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(password);
		}

		if (phone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(phone);
		}

		objectOutput.writeLong(departmentId);

		objectOutput.writeLong(positionId);

		objectOutput.writeInt(userIdMapping);

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

		if (avatarName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(avatarName);
		}

		if (avatarPath == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(avatarPath);
		}
	}

	public String uuid;
	public long accountId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String fullName;
	public String email;
	public String newUser;
	public String password;
	public String phone;
	public long departmentId;
	public long positionId;
	public int userIdMapping;
	public String status;
	public String avatarName;
	public String avatarPath;

}