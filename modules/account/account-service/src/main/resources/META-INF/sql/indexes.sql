create index IX_7C549D45 on DG_AccountEntry (email[$COLUMN_LENGTH:75$]);
create index IX_F6722595 on DG_AccountEntry (fullName[$COLUMN_LENGTH:75$]);
create index IX_CB628A5B on DG_AccountEntry (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_912FEB9D on DG_AccountEntry (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_1E167BFF on DG_Account_Category (categoryId);
create index IX_C90E04D6 on DG_Account_Category (companyId);

create index IX_82B385D1 on DG_CategoryEntry (code_, type_[$COLUMN_LENGTH:75$]);
create index IX_9ADC6B4B on DG_CategoryEntry (type_[$COLUMN_LENGTH:75$], code_);
create index IX_420DC772 on DG_CategoryEntry (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_9EE58274 on DG_CategoryEntry (uuid_[$COLUMN_LENGTH:75$], groupId);