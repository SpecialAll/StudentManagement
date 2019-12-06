create
    definer = root@localhost procedure studentManagement.checkDepartmentNumber()
BEGIN
    declare c int;
    declare realNum int;
    declare done int default false;
    declare cur cursor for select departmentId, count(departmentId) from students group by (departmentId);
    declare continue HANDLER for not found set done = true;
    open cur;
--    fetch cur into c,n;
    while(not done)
        do
            fetch cur into c,realNum;
            select departmentId, departmentName, departmentNumber, realNum
            from departments
            where departmentNumber != realNum
              and departmentId = c;
            update departments set departmentNumber = realNum where departmentId = c;

        end while;
    close cur;
END;
