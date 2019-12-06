create table studentManagement.majors
(
    majorId      int auto_increment comment '专业编号'
        primary key,
    majorName    varchar(20) not null comment '专业名',
    departmentId int         not null comment '系号'
)
    comment '专业表' charset = utf8mb4;