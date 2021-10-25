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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CategoryEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CategoryEntry
 * @generated
 */
public class CategoryEntryWrapper
	extends BaseModelWrapper<CategoryEntry>
	implements CategoryEntry, ModelWrapper<CategoryEntry> {

	public CategoryEntryWrapper(CategoryEntry categoryEntry) {
		super(categoryEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("categoryId", getCategoryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("type", getType());
		attributes.put("name", getName());
		attributes.put("code", getCode());
		attributes.put("parentId", getParentId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
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

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Integer code = (Integer)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String parentId = (String)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}
	}

	/**
	 * Returns the category ID of this category entry.
	 *
	 * @return the category ID of this category entry
	 */
	@Override
	public long getCategoryId() {
		return model.getCategoryId();
	}

	/**
	 * Returns the code of this category entry.
	 *
	 * @return the code of this category entry
	 */
	@Override
	public int getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this category entry.
	 *
	 * @return the company ID of this category entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this category entry.
	 *
	 * @return the create date of this category entry
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this category entry.
	 *
	 * @return the group ID of this category entry
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this category entry.
	 *
	 * @return the modified date of this category entry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this category entry.
	 *
	 * @return the name of this category entry
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the parent ID of this category entry.
	 *
	 * @return the parent ID of this category entry
	 */
	@Override
	public String getParentId() {
		return model.getParentId();
	}

	/**
	 * Returns the primary key of this category entry.
	 *
	 * @return the primary key of this category entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the type of this category entry.
	 *
	 * @return the type of this category entry
	 */
	@Override
	public String getType() {
		return model.getType();
	}

	/**
	 * Returns the user ID of this category entry.
	 *
	 * @return the user ID of this category entry
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this category entry.
	 *
	 * @return the user name of this category entry
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this category entry.
	 *
	 * @return the user uuid of this category entry
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this category entry.
	 *
	 * @return the uuid of this category entry
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
	 * Sets the category ID of this category entry.
	 *
	 * @param categoryId the category ID of this category entry
	 */
	@Override
	public void setCategoryId(long categoryId) {
		model.setCategoryId(categoryId);
	}

	/**
	 * Sets the code of this category entry.
	 *
	 * @param code the code of this category entry
	 */
	@Override
	public void setCode(int code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this category entry.
	 *
	 * @param companyId the company ID of this category entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this category entry.
	 *
	 * @param createDate the create date of this category entry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this category entry.
	 *
	 * @param groupId the group ID of this category entry
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this category entry.
	 *
	 * @param modifiedDate the modified date of this category entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this category entry.
	 *
	 * @param name the name of this category entry
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the parent ID of this category entry.
	 *
	 * @param parentId the parent ID of this category entry
	 */
	@Override
	public void setParentId(String parentId) {
		model.setParentId(parentId);
	}

	/**
	 * Sets the primary key of this category entry.
	 *
	 * @param primaryKey the primary key of this category entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the type of this category entry.
	 *
	 * @param type the type of this category entry
	 */
	@Override
	public void setType(String type) {
		model.setType(type);
	}

	/**
	 * Sets the user ID of this category entry.
	 *
	 * @param userId the user ID of this category entry
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this category entry.
	 *
	 * @param userName the user name of this category entry
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this category entry.
	 *
	 * @param userUuid the user uuid of this category entry
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this category entry.
	 *
	 * @param uuid the uuid of this category entry
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
	protected CategoryEntryWrapper wrap(CategoryEntry categoryEntry) {
		return new CategoryEntryWrapper(categoryEntry);
	}

}