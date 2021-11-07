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

package com.dogoo.account.model.impl;

import com.dogoo.account.model.AccountRoleEntry;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AccountRoleEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AccountRoleEntryCacheModel
	implements CacheModel<AccountRoleEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AccountRoleEntryCacheModel)) {
			return false;
		}

		AccountRoleEntryCacheModel accountRoleEntryCacheModel =
			(AccountRoleEntryCacheModel)object;

		if (AccountRoleId == accountRoleEntryCacheModel.AccountRoleId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, AccountRoleId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", AccountRoleId=");
		sb.append(AccountRoleId);
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
		sb.append(", AccountId=");
		sb.append(AccountId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", code=");
		sb.append(code);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AccountRoleEntry toEntityModel() {
		AccountRoleEntryImpl accountRoleEntryImpl = new AccountRoleEntryImpl();

		if (uuid == null) {
			accountRoleEntryImpl.setUuid("");
		}
		else {
			accountRoleEntryImpl.setUuid(uuid);
		}

		accountRoleEntryImpl.setAccountRoleId(AccountRoleId);
		accountRoleEntryImpl.setGroupId(groupId);
		accountRoleEntryImpl.setCompanyId(companyId);
		accountRoleEntryImpl.setUserId(userId);

		if (userName == null) {
			accountRoleEntryImpl.setUserName("");
		}
		else {
			accountRoleEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			accountRoleEntryImpl.setCreateDate(null);
		}
		else {
			accountRoleEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			accountRoleEntryImpl.setModifiedDate(null);
		}
		else {
			accountRoleEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		accountRoleEntryImpl.setAccountId(AccountId);

		if (name == null) {
			accountRoleEntryImpl.setName("");
		}
		else {
			accountRoleEntryImpl.setName(name);
		}

		if (code == null) {
			accountRoleEntryImpl.setCode("");
		}
		else {
			accountRoleEntryImpl.setCode(code);
		}

		accountRoleEntryImpl.resetOriginalValues();

		return accountRoleEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		AccountRoleId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		AccountId = objectInput.readLong();
		name = objectInput.readUTF();
		code = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(AccountRoleId);

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

		objectOutput.writeLong(AccountId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(code);
		}
	}

	public String uuid;
	public long AccountRoleId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long AccountId;
	public String name;
	public String code;

}