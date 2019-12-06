create table studentManagement.departments
(
    departmentId     int auto_increment comment '系号'
        primary key,
    departmentName   varchar(20) not null comment '系名',
    departmentPlace  varchar(20) not null comment '办公室地点',
    departmentNumber bigint      not null comment '系人数'
)
    comment '系表' charset = utf8mb4;