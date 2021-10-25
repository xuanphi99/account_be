create table DG_AccountEntry (
	uuid_ VARCHAR(75) null,
	accountId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	fullName VARCHAR(75) null,
	email VARCHAR(75) null,
	newUser VARCHAR(75) null,
	password_ VARCHAR(75) null,
	phone VARCHAR(75) null,
	departmentId LONG,
	positionId LONG,
	userIdMapping INTEGER
);

create table DG_Account_Category (
	companyId LONG not null,
	accountId LONG not null,
	categoryId LONG not null,
	primary key (accountId, categoryId)
);

create table DG_CategoryEntry (
	uuid_ VARCHAR(75) null,
	categoryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	type_ VARCHAR(75) null,
	name VARCHAR(75) null,
	code_ INTEGER,
	parentId VARCHAR(75) null
);