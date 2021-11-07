create index IX_7C549D45 on DG_AccountEntry (email[$COLUMN_LENGTH:75$]);
create index IX_F6722595 on DG_AccountEntry (fullName[$COLUMN_LENGTH:75$]);
create index IX_97F30F18 on DG_AccountEntry (newUser[$COLUMN_LENGTH:75$], email[$COLUMN_LENGTH:75$]);
create index IX_CB628A5B on DG_AccountEntry (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_912FEB9D on DG_AccountEntry (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_C51FF9C7 on DG_AccountRoleEntry (AccountId);
create index IX_38D3A1D1 on DG_AccountRoleEntry (code_[$COLUMN_LENGTH:75$]);
create index IX_B80ACB05 on DG_AccountRoleEntry (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_B9644EC7 on DG_AccountRoleEntry (uuid_[$COLUMN_LENGTH:75$], groupId);