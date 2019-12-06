create table studentManagement.clubDetails
(
    studentId int                                 not null comment '学会学生学号',
    clubId    int                                 not null comment '学会编号',
    year      timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '入会时间'
)
    comment '学会人员表' charset = utf8mb4;