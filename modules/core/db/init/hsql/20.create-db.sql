-- begin DEMO_COMMENT
alter table DEMO_COMMENT add constraint FK_DEMO_COMMENT_ON_USER foreign key (USER_ID) references SEC_USER(ID)^
create index IDX_DEMO_COMMENT_ON_USER on DEMO_COMMENT (USER_ID)^
-- end DEMO_COMMENT
