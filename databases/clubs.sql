create table studentManagement.clubs
(
    clubId          bigint auto_increment comment '学会号'
        primary key,
    clubName        varchar(20) not null comment '学会名',
    establishedTime bigint      not null comment '成立年份',
    clubPlace       varchar(20) not null comment '地点'
)
    comment '学会表' charset = utf8mb4;

