create table studentManagement.students
(
    studentId    bigint      not null comment '学号',
    name         varchar(20) not null comment '姓名',
    age          int         not null comment '年龄',
    sex          varchar(10) not null comment '性别',
    majorId      int         not null comment '专业号',
    departmentId int         not null comment '系号',
    classId      int         not null comment '班级号',
    dormitory    varchar(20) not null comment '宿舍区',
    constraint studentId
        unique (studentId)
)
    comment '学生表' charset = utf8mb4;

create definer = root@localhost trigger studentManagement.deleteNum
    after DELETE
    on studentManagement.students
    for each row
begin
    update classes set classNumber = classNumber - 1 where classId = OLD.classId;
    update departments set departmentNumber = departmentNumber - 1 where departmentId = OLD.departmentId;
end;

create definer = root@localhost trigger studentManagement.updateNum
    after INSERT
    on studentManagement.students
    for each row
begin
    update classes set classNumber = classNumber + 1 where classId = NEW.classId;
    update departments set departmentNumber = departmentNumber + 1 where departmentId = NEW.departmentId;
end;
