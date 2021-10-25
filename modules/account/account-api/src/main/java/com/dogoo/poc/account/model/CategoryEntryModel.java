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
 * The base model interface for the CategoryEntry service. Represents a row in the &quot;DG_CategoryEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.dogoo.poc.account.model.impl.CategoryEntryModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.dogoo.poc.account.model.impl.CategoryEntryImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CategoryEntry
 * @generated
 */
@ProviderType
public interface CategoryEntryModel
	extends BaseModel<CategoryEntry>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a category entry model instance should use the {@link CategoryEntry} interface instead.
	 */

	/**
	 * Returns the primary key of this category entry.
	 *
	 * @return the primary key of this category entry
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this category entry.
	 *
	 * @param primaryKey the primary key of this category entry
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this category entry.
	 *
	 * @return the uuid of this category entry
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this category entry.
	 *
	 * @param uuid the uuid of this category entry
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the category ID of this category entry.
	 *
	 * @return the category ID of this category entry
	 */
	public long getCategoryId();

	/**
	 * Sets the category ID of this category entry.
	 *
	 * @param categoryId the category ID of this category entry
	 */
	public void setCategoryId(long categoryId);

	/**
	 * Returns the group ID of this category entry.
	 *
	 * @return the group ID of this category entry
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this category entry.
	 *
	 * @param groupId the group ID of this category entry
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this category entry.
	 *
	 * @return the company ID of this category entry
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this category entry.
	 *
	 * @param companyId the company ID of this category entry
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this category entry.
	 *
	 * @return the user ID of this category entry
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this category entry.
	 *
	 * @param userId the user ID of this category entry
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this category entry.
	 *
	 * @return the user uuid of this category entry
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this category entry.
	 *
	 * @param userUuid the user uuid of this category entry
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this category entry.
	 *
	 * @return the user name of this category entry
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this category entry.
	 *
	 * @param userName the user name of this category entry
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this category entry.
	 *
	 * @return the create date of this category entry
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this category entry.
	 *
	 * @param createDate the create date of this category entry
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this category entry.
	 *
	 * @return the modified date of this category entry
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this category entry.
	 *
	 * @param modifiedDate the modified date of this category entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the type of this category entry.
	 *
	 * @return the type of this category entry
	 */
	@AutoEscape
	public String getType();

	/**
	 * Sets the type of this category entry.
	 *
	 * @param type the type of this category entry
	 */
	public void setType(String type);

	/**
	 * Returns the name of this category entry.
	 *
	 * @return the name of this category entry
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this category entry.
	 *
	 * @param name the name of this category entry
	 */
	public void setName(String name);

	/**
	 * Returns the code of this category entry.
	 *
	 * @return the code of this category entry
	 */
	public int getCode();

	/**
	 * Sets the code of this category entry.
	 *
	 * @param code the code of this category entry
	 */
	public void setCode(int code);

	/**
	 * Returns the parent ID of this category entry.
	 *
	 * @return the parent ID of this category entry
	 */
	@AutoEscape
	public String getParentId();

	/**
	 * Sets the parent ID of this category entry.
	 *
	 * @param parentId the parent ID of this category entry
	 */
	public void setParentId(String parentId);

}