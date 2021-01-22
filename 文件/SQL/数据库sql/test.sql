//////////////
create table test(
 uid int unsigned primary key auto_increment,
 sid int,
 tid int
)engine=innodb default charset=utf8;


create table revenue(
 rid int unsigned primary key auto_increment,
 uid int,
 revenue decimal(12,8)
)engine=innodb default charset=utf8;


drop procedure if exists init2;
 create procedure init2()
    begin
    declare n int default 0;
        while(n<2) do
            insert into test2(uid,sid,uname) values(n,n,'uname');
        set n = n + 1;
        end while;
   end;


call init_demo();


drop procedure if exists init3;
 create procedure init3()
    begin
    declare n int default 0;
        while(n<100000) do
            insert into revenue(uid,revenue) values(mod(n,3),'1.0');
        set n = n + 1;
        end while;
   end;


create index uid_index on `test2`(`uid`);

select * from(select t2.uid,t2.uname,t2.inviter_id from ( select @rr as _id,( select @rr := inviter_id from relation where uid = _id ) as inviter_id,@ll := @ll + 1 as lvl from ( select @rr := 7, @ll := 0 ) vars, relation h where @rr != 0) t1 join relation t2 on t1._id = t2.uid) y;

//内连接(未置索引) 998 rows in set (60.56 sec)
select * from(
select t2.uid,t2.uname,t2.sid from (
                  select @rr as _id,
                  ( select @rr := sid from test1 where uid = _id ) as sid,
                  @ll := @ll + 1 as lvl from 
                               ( select @rr := 998, @ll := 0 ) vars, test1 h where @rr != 0
                                          ) 
                               t1 join test1 t2 on t1._id = t2.uid) y;
//内连接(设置索引) 998 rows in set (1.04 sec)
select * from(
         select t2.uid,t2.uname,t2.sid from (
                              select @rr as _id,
                                    (select @rr := sid from test2 where uid = _id ) as sid,
                                    @ll := @ll + 1 as lvl from
                                        ( select @rr := 998, @ll := 0 ) vars, test2 h where @rr != 0
                                    )
                               t1 join test2 t2
                               on t1._id = t2.uid
               ) y;

//嵌套查询 (无索引) 998 rows in set (46.98 sec)
select t2._id, t2.sid, t2.unae from (
                    select @rr as _id,
                          ( select @rr := sid from test1 where uid = _id ) as sid,
                           @ll := @ll + 1 as lvl,
                           uname as unae
                           from
                           ( select @rr := 998, @ll := 0 ) vars, test1 h where @rr != 0
                    ) t2;

//嵌套查询(有索引) 998 rows in set (0.96 sec)
select t2._id, t2.sid, t2.unae from (
                    select @rr as _id,
                          ( select @rr := sid from test2 where uid = _id ) as sid,
                           @ll := @ll + 1 as lvl,
                           uname as unae
                           from
                           ( select @rr := 998, @ll := 0 ) vars, test2 h where @rr != 0
                    ) t2;


select * from(
         select t2.uid,t2.uname,t2.sid from (
                              select @rr as _id,
                                    (select @rr := sid from relation where uid = _id ) as sid
                                    from
                                     ( select @rr := 998) vars, relation h where @rr != 0
                                    )
                               t1 join relation t2
                               on t1._id = t2.uid
               ) y;




/////////////////////////////////// Every derived table must have its own alias
select t2.uid,t2.sid from (
                              select @rr as _id,
                                    (select @rr := sid from test2 where uid = _id ) as sid,
                                    @ll := @ll + 1 as lvevl from
                                        ( select @rr := 9, @ll := 0 ) vars, test2 h where @rr != 0
                          ) t1

 select t2.uid,t2.sid from (
                              select @rr as _id,
                                    (select @rr := sid from test where uid = _id ) as sid,
                                    from
                                    ( select @rr := 5) vars, test h where @rr != 0
                          ) t1;








///////////////////////////////////
select * from test1 t1,test2  t2 where t1.uid = t2.uid and t1.uid =5; //使用表别名
///////////////////////////////////
select 表2.uid,表2.sid from (
                              select @temp as _pid,
                                    ( select @temp := sid from <表名> where uid = _pid ) as sid,    //查询sid作为下一次的uid
                                                                        @ll := @ll + 1  as lvevl   //查询层级(次数)
                                              from
                                    ( select @temp := 9, @ll := 1 ) vars, <表名> hhh where @temp != 0
                            ) 表1
///////////////////////////////////


select t2._id, t2.sid, t2.lvl from (
                    select @rr as _id,
                          ( select @rr := sid from test2 where uid = _id ) as sid,
                           @ll := @ll + 1 as lvl
                           from
                           ( select @rr := 5, @ll := 0 ) vars, test2 h where @rr != 0
                    ) t2;

//
select t2._id, t2.sid from (
                    select @rr as _id,
                          ( select @rr := sid from test2 where uid = _id ) as sid
                           from
                           ( select @rr := 5) vars, test2 h where @rr != 0
                    ) t2;


select t2._id, t2.sid, t2.unae from (
                    select @rr as _id,
                          ( select @rr := sid from test1 where uid = _id ) as sid,
                           @ll := @ll + 1 as lvl,
                           uname as unae
                           from
                           ( select @rr := 998, @ll := 0 ) vars, test1 h where @rr != 0
                    ) t2;




insert into statistic(revenues,revnumbere) values select sum(revenue_amount) as total,count(*) as numbers from revenue r1;

select concat(sum(sid),' , ',count(*)) from revenue where tid = 1;

insert into statistic (
start_date,
statistic_date,
calculate,
revenues,
orders,
users,
members,
managers,
partners)
values (
?,
?,
?,
(select concat(sum(revenue_amount),'  ',count(*)) from revenue where revenue_date >= ?),
(select concat(sum(revenue_amount),'  ',count(*)) from orders where order_date >= ?),
(select count(*) from relation where type_id = ?),
(select count(*) from relation where type_id = ?),
(select count(*) from relation where type_id = ?),
(select count(*) from relation where type_id = ?)
 )2020-06-01 11:50:18 Parameters: [2020-06-01 11:50:18, 100, 1590983418813, 1590983418813, 0, 1, 2, 3]


select ifnull((select 1 from user where uid = ? limit 1),0)


select * from (select * from user c inner join relation on c.uid = relation.uid where c.uid = 1 limit 1) u cross join
(select
(select sum(revenue_amount) from revenue where uid = 1 and withdrawal = false) as total,
(select sum(revenue_amount) from revenue where uid = 1 and withdrawal = false and revenue_date< 5) as withdrawed
) o;

select
(select sum(revenue_amount) from revenue where uid = 1 and withdrawal = false) as total,
(select sum(revenue_amount) from revenue where uid = 1 and withdrawal = false and revenue_date< 5) as withdrawed ,
(select ifnull((select 1 from certifie where uid = 1 and  certificate_audit = true limit 1),0)) as certifie ,
(select ifnull((select 1 from bankcard where uid = 1 and  bankcard_audit = true limit 1),0)) as bankcard ,
uid,username,phonenumber,portrait,regist_date,user_invite_code,inviter_id,type_id
from
(select c.uid as uid,username,phonenumber,portrait,regist_date,user_invite_code,inviter_id,type_id
from user c inner join relation on c.uid = relation.uid where c.uid = 1 ) u;

select u.username,b.card_number,c.real_name from  user u,bankcard b,certifie c where u.uid = 1 and b.uid = 1 and c.uid =1;


create index uid_index on `test2`(`uid`);
//创建联合索引


create table mytable(
id int not null,
username varchar(16) not null,
index [indexname] (username(length))
);

create table mytable(
id int not null,
username varchar(16) not null,
unique indexname (username(16),id)
);

CREATE TABLE `baitest` (
'aaa' varchar(16) NOT NULL default '',
'bbb' varchar(16) NOT NULL default '',
 'ccc' int(11) UNSIGNED NOT NULL default 0,
KEY `sindex` (`aaa`,`bbb`,`ccc`) ) ENGINE=MyISAM COMMENT='';



select * from (
select u.uid,u.username,u.phonenumber,u.portrait,u.regist_date,
b.card_name,b.card_number,b.bank_name,b.card_bank_name,b.card_bank_number,b.card_phone,b.card_update_date,b.bankcard_audit,
c.real_name,c.certificate_type,c.certificate_number,c.phone_number,c.certificate_photo,c.cert_update_date,c.certificate_audit
from user u,bankcard b,certifie c
where u.uid in (select uid from withdrawal where withdrawal_finished = false group  by b.uid )
and b.uid= u.uid and c.uid = u.uid) main
inner join withdrawal on main.uid = withdrawal.uid


SELECT
    i.id,
    i.title,
    SUM(ivs.user_visits) AS uv,
    its.item_num * i.price AS turnover
FROM
    (
        items AS i
        RIGHT JOIN item_visit_stats AS ivs ON i.id = ivs.id
    )
LEFT JOIN (
    SELECT
        id,
        SUM(item_num) AS item_num
    FROM
        item_trade_stats
    WHERE
        seller_nick = "XXXX"
    GROUP BY
        id
) AS its ON its.id = ivs.id
WHERE
    i.nick = "XXXX"
GROUP BY
    i.id
ORDER BY
    uv DESC



select sum(revenue_amount) as amount,uid from revenue where uid = 1 group by revenue_type;

SELECT t1.id,t1.nodecontent,t2.nodecontent parentnodecontent FROM nodelist t1
LEFT JOIN nodelist t2
ON t1.pid = t2.id;

SELECT
    t3.college_code
FROM
    (
    SELECT
    t1.college_code,
IF
    ( find_in_set( t1.parent_org_code, @pids ) > 0, @pids := concat( @pids, ',', t1.college_code ), 0 ) AS ischild
FROM
    ( SELECT college_code, parent_org_code FROM t_college t WHERE t.STATUS = 1 ORDER BY parent_org_code, college_code ) t1,
    ( SELECT @pids := '22300' college_code ) t2
    ) t3
WHERE
    t3.ischild != 0


-- 表结构：  t_college:      id,   college_code (机构编码),   parent_org_code （父机构编码）
  /*
    uid
    inviter_id
    type_id
  */

select count(*) from (
       select t1.uid,
              if(find_in_set(inviter_id, @pids) > 0, @pids := concat(@pids, ',', uid), 0) as ischild
         from
            ( select uid,inviter_id from rel t where t.type_id =2 order by inviter_id, uid ) t1,
            ( select @pids := 1) t2
               ) t3
where ischild != 0;


select c.uid,c.phonenumber,c.username,c.portrait,c.regist_date,relation.type_id from
user c
inner join relation
on c.uid = relation.uid where relation.inviter_id = ? and type_id = ? order by c.uid desc limit ?,?

select u.uid,u.phonenumber,u.username,u.portrait,u.regist_date from
user u
inner join
(select uid from (
       select t1.uid,
              if(find_in_set(inviter_id, @pids) > 0, @pids := concat(@pids, ',', uid), 0) as ischild
         from
            ( select uid,inviter_id from relation t where t.type_id =2 ) t1,
            ( select @pids := 1) t2
               ) t3
where ischild != 0) m
on u.uid = m.uid ;



SELECT GROUP_CONCAT(id) FROM ( SELECT t1.id, IF(FIND_IN_SET(parentid, @pids) > 0, @pids := CONCAT(@pids, ',', id), 0) AS ischild FROM
( SELECT id,parentid FROM AREA t WHERE t.level <=3 ORDER BY parentid, id ) t1, (SELECT @pids := 820000) t2 ) t3 WHERE ischild != 0





select * from (
 select withdrawal.uid as uid,
 withdrawal.withdrawal_id as withdrawal_id,
 withdrawal.withdrawal_date as withdrawal_date,
 withdrawal.withdrawal_number as withdrawal_number,
 withdrawal.withdrawal_finished as withdrawal_finished,
 withdrawal.withdrawal_type as withdrawal_type,
 username as username, phonenumber as phonenumber,
 portrait as portrait, regist_date as regist_date
 from withdrawal
 inner join user on withdrawal.uid = user.uid
 and withdrawal_finished = false) draw
 left join bankcard on (bankcard.uid = draw.uid)
 left join certifie on (certifie.uid = draw.uid)


 select * from
 (
 select withdrawal.uid as uid,
 withdrawal.withdrawal_id as withdrawal_id,
  withdrawal.withdrawal_date as withdrawal_date,
  withdrawal.withdrawal_number as withdrawal_number,
  withdrawal.withdrawal_finished as withdrawal_finished,
   withdrawal.withdrawal_type as withdrawal_type,
  u.username as username,
  u.phonenumber as phonenumber,
  u.portrait as portrait,
  u.regist_date as regist_date
   from withdrawal inner join user u on
   withdrawal.uid = u.uid and withdrawal_finished = 1 and withdrawal_date >= 1 and withdrawal_date<=10 order by withdrawal_date desc
   )
    draw
   left join bankcard on (bankcard.uid = draw.uid)
   left join certifie on (certifie.uid = draw.uid);



select * from
(
select
withdrawal.uid as uid,
withdrawal.withdrawal_id as withdrawal_id,
withdrawal.withdrawal_date as withdrawal_date,
withdrawal.withdrawal_number as withdrawal_number,
withdrawal.withdrawal_finished as withdrawal_finished,
withdrawal.withdrawal_type as withdrawal_type
from
withdrawal
where
withdrawal_finished = false
and withdrawal_date >= 0
and withdrawal_date<=999
order by withdrawal_date desc
limit 0,10
) draw
left join user on (user.uid = draw.uid)
left join bankcard on (bankcard.uid = draw.uid)
left join certifie on (certifie.uid = draw.uid);


select * from
(
select
t1.uid,
inviter_id,
type_id,
  if (
     find_in_set(inviter_id, @pids) > 0, @pids := concat(@pids, ',', uid), 0
     ) as ischild,
  if (@link=1||(type_id=2&uid!=2), @link := @link+1, @link := 1) as link
from
( select uid,inviter_id,type_id from relation t ) t1,
( select @pids := 2) t2,
( select @link := 0) t3
) t4
where ischild != 0;

select * from
(
select
t5.uid,
inviter_id,
type_id,
 if (@link=1&(type_id!=2|uid=2), @link := 1, @link := @link+1) as link
from
(select * from
              (
              select
              t1.uid,
              inviter_id,
              type_id,
                if (
                   find_in_set(inviter_id, @pids) > 0, @pids := concat(@pids, ',', uid), 0
                   ) as ischild
              from
              ( select uid,inviter_id,type_id from relation t ) t1,
              ( select @pids := 2) t2
              ) t4
where ischild != 0) t5,
( select @link := 0) t6
) t7;





select * from ( select t1.uid, t1.inviter_id, t1.type_id, if ( find_in_set(inviter_id, @pids) > 0, @pids := concat(@pids, ',', uid), 0 ) as ischild from ( select uid,inviter_id,type_id from relation t ) t1, ( select @pids := 1) t2 ) t4 where ischild != 0;














select c.uid, c.username,c.portrait,c.regist_date from user c inner join (select uid,type_id from ( select t1.uid,t1.type_id, if(find_in_set(inviter_id, @pids) > 0, @pids := concat(@pids,',',uid), 0) as ischild from ( select uid,inviter_id,type_id from relation t ) t1, ( select @pids := 2) t2 ) t3 where ischild != 0 and type_id = 2 limit 0,1) m on c.uid = m.uid order by c.uid desc;


select uid,sum(revenue_amount) from estimate where revenue_type=1 or revenue_type=2 and revenue>= '2020-01-01' group by uid


select uid,sum(revenue_amount) from estimate where revenue_type=1 or revenue_type=2 and revenue>= '2020-01-01' and (select type_id from relation where uid = uid) group by uid;

select mem_uid from
(select (select count(*) from relation where inviter_id = mem_uid) as number, uid as mem_uid from relation where type_id = 1 )





select c.uid, m.inviter_id,m.type_id,c.username,c.portrait,c.regist_date
from user c inner join
(select uid,type_id,inviter_id from
     ( select
     t1.uid,t1.type_id,t1.inviter_id,
     if(find_in_set(inviter_id, @pids) > 0, @pids := concat(@pids,',',uid), 0) as ischild
     from ( select uid,inviter_id,type_id from relation t ) t1, ( select @pids := 21) t2
     ) t3
  where ischild != 0 and (inviter_id != 21 or type_id != 1)
     )
 m on c.uid = m.uid order by c.uid desc limit 0,10;


update a
inner join ( select yy from b ) c on a.id = c.id
set a.xx = c.yy

update estimate a
inner join (
select uid,type_id from relation where type_id =3
) b on a.uid = b.uid
set a.revenue_amount = (select sum (revenue_amount)*0.05 from estimate e where a.tag = e.tag);





