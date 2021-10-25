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

package com.dogoo.poc.pet.model.impl;

import com.dogoo.poc.pet.model.CatEntry;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CatEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CatEntryCacheModel
	implements CacheModel<CatEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CatEntryCacheModel)) {
			return false;
		}

		CatEntryCacheModel catEntryCacheModel = (CatEntryCacheModel)object;

		if (petId == catEntryCacheModel.petId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, petId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", petId=");
		sb.append(petId);
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
		sb.append(", creatorId=");
		sb.append(creatorId);
		sb.append(", scopeOrgId=");
		sb.append(scopeOrgId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", tag=");
		sb.append(tag);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CatEntry toEntityModel() {
		CatEntryImpl catEntryImpl = new CatEntryImpl();

		if (uuid == null) {
			catEntryImpl.setUuid("");
		}
		else {
			catEntryImpl.setUuid(uuid);
		}

		catEntryImpl.setPetId(petId);
		catEntryImpl.setGroupId(groupId);
		catEntryImpl.setCompanyId(companyId);
		catEntryImpl.setUserId(userId);

		if (userName == null) {
			catEntryImpl.setUserName("");
		}
		else {
			catEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			catEntryImpl.setCreateDate(null);
		}
		else {
			catEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			catEntryImpl.setModifiedDate(null);
		}
		else {
			catEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		catEntryImpl.setCreatorId(creatorId);
		catEntryImpl.setScopeOrgId(scopeOrgId);

		if (name == null) {
			catEntryImpl.setName("");
		}
		else {
			catEntryImpl.setName(name);
		}

		if (tag == null) {
			catEntryImpl.setTag("");
		}
		else {
			catEntryImpl.setTag(tag);
		}

		if (status == null) {
			catEntryImpl.setStatus("");
		}
		else {
			catEntryImpl.setStatus(status);
		}

		if (statusDate == Long.MIN_VALUE) {
			catEntryImpl.setStatusDate(null);
		}
		else {
			catEntryImpl.setStatusDate(new Date(statusDate));
		}

		catEntryImpl.resetOriginalValues();

		return catEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		petId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		creatorId = objectInput.readLong();

		scopeOrgId = objectInput.readLong();
		name = objectInput.readUTF();
		tag = objectInput.readUTF();
		status = objectInput.readUTF();
		statusDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(petId);

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

		objectOutput.writeLong(creatorId);

		objectOutput.writeLong(scopeOrgId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (tag == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tag);
		}

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

		objectOutput.writeLong(statusDate);
	}

	public String uuid;
	public long petId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long creatorId;
	public long scopeOrgId;
	public String name;
	public String tag;
	public String status;
	public long statusDate;

}