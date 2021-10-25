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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;DG_Account_Category&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see AccountEntry
 * @see CategoryEntry
 * @generated
 */
public class DG_Account_CategoryTable
	extends BaseTable<DG_Account_CategoryTable> {

	public static final DG_Account_CategoryTable INSTANCE =
		new DG_Account_CategoryTable();

	public final Column<DG_Account_CategoryTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DG_Account_CategoryTable, Long> accountId =
		createColumn(
			"accountId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DG_Account_CategoryTable, Long> categoryId =
		createColumn(
			"categoryId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);

	private DG_Account_CategoryTable() {
		super("DG_Account_Category", DG_Account_CategoryTable::new);
	}

}