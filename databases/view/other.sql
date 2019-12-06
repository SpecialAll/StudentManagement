create definer = root@localhost view studentManagement.other as
select `c`.`clubName` AS `clubName`, count(`d`.`studentId`) AS `count`
from `studentManagement`.`clubs` `c`
         join `studentManagement`.`clubDetails` `d`
where (`d`.`clubId` = `c`.`clubId`)
group by `c`.`clubName`;

-- comment on column studentManagement.other.clubName not supported: 学会名
