-- begin DEMO_PRODUCT
create table DEMO_PRODUCT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TITLE varchar(255) not null,
    SUMMARY longvarchar not null,
    --
    primary key (ID)
)^
-- end DEMO_PRODUCT
-- begin DEMO_COMMENT
create table DEMO_COMMENT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    USER_ID varchar(36),
    CONVERSATION varchar(36) not null,
    TEXT varchar(2000) not null,
    --
    primary key (ID)
)^
-- end DEMO_COMMENT
