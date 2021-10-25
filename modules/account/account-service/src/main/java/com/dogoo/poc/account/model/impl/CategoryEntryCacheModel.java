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

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CategoryEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CategoryEntryCacheModel
	implements CacheModel<CategoryEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CategoryEntryCacheModel)) {
			return false;
		}

		CategoryEntryCacheModel categoryEntryCacheModel =
			(CategoryEntryCacheModel)object;

		if (categoryId == categoryEntryCacheModel.categoryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, categoryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", categoryId=");
		sb.append(categoryId);
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
		sb.append(", type=");
		sb.append(type);
		sb.append(", name=");
		sb.append(name);
		sb.append(", code=");
		sb.append(code);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CategoryEntry toEntityModel() {
		CategoryEntryImpl categoryEntryImpl = new CategoryEntryImpl();

		if (uuid == null) {
			categoryEntryImpl.setUuid("");
		}
		else {
			categoryEntryImpl.setUuid(uuid);
		}

		categoryEntryImpl.setCategoryId(categoryId);
		categoryEntryImpl.setGroupId(groupId);
		categoryEntryImpl.setCompanyId(companyId);
		categoryEntryImpl.setUserId(userId);

		if (userName == null) {
			categoryEntryImpl.setUserName("");
		}
		else {
			categoryEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			categoryEntryImpl.setCreateDate(null);
		}
		else {
			categoryEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			categoryEntryImpl.setModifiedDate(null);
		}
		else {
			categoryEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (type == null) {
			categoryEntryImpl.setType("");
		}
		else {
			categoryEntryImpl.setType(type);
		}

		if (name == null) {
			categoryEntryImpl.setName("");
		}
		else {
			categoryEntryImpl.setName(name);
		}

		categoryEntryImpl.setCode(code);

		if (parentId == null) {
			categoryEntryImpl.setParentId("");
		}
		else {
			categoryEntryImpl.setParentId(parentId);
		}

		categoryEntryImpl.resetOriginalValues();

		return categoryEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		categoryId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		type = objectInput.readUTF();
		name = objectInput.readUTF();

		code = objectInput.readInt();
		parentId = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(categoryId);

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

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeInt(code);

		if (parentId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(parentId);
		}
	}

	public String uuid;
	public long categoryId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String type;
	public String name;
	public int code;
	public String parentId;

}