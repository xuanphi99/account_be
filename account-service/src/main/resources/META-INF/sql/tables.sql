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
	userIdMapping INTEGER,
	status VARCHAR(75) null,
	avatarName VARCHAR(75) null,
	avatarPath VARCHAR(75) null
);

create table DG_AccountRoleEntry (
	uuid_ VARCHAR(75) null,
	AccountRoleId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	AccountId LONG,
	name VARCHAR(75) null,
	code_ VARCHAR(75) null
);