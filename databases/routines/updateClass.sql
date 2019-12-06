create
    definer = root@localhost function studentManagement.updateClass(num int, newNum int) returns int
begin
    declare ans int;
    update classes set classId = newNum where classId = num;
    update students set classId = newNum where classId = num;
    select classNumber from classes where classId = newNum into ans;
    return ans;
end;