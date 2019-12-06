create table studentManagement.classes
(
    classId      int    not null comment '班级号',
    majorId      int    null,
    yearOfClass  bigint not null comment '入校年份',
    departmentId int    not null comment '系号',
    classNumber  bigint not null comment '人数',
    constraint classId
        unique (classId)
)
    comment '班级表' charset = utf8mb4;

