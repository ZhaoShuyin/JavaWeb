
id	pid	name
1	2	徒孙
2	3	徒弟
3	0	师傅
SELECT * FROM (
                SELECT T2.id,T2.name,T2.pid
                    FROM (
                        SELECT @rr AS _id,
                             (
                             SELECT @rr := pid FROM test WHERE id = _id
                             ) AS pid,
                                 @ll := @ll + 1 AS lvl
                              FROM (
                                      SELECT @rr := 7, @ll := 0
                                    )
                                    vars, test h
                        WHERE @rr != 0
                         )
                         T1
                         JOIN test T2 ON T1._id = T2.id
               ) Y;

 //向上查询关系链
select * from(select t2.uid,t2.type_id,t2.inviter_id from
               ( select @rr as _id,(
                              select @rr := inviter_id from relation where uid = _id
                              ) as inviter_id,@ll := @ll + 1 as lvl from ( select @rr := ?, @ll := 0 ) vars, relation h where @rr != 0)
                              t1 join relation t2 on t1._id = t2.uid) y
//每个派生表必须有自己的别名
//https://blog.csdn.net/jiwubai8849/article/details/83375220

//循环向上查询(参数1:起始账号 参数2:停止类型)(已验证)
create function `findup`(useruid int,usertype int)
returns int
begin
declare tempuid int;
declare temptype int;
declare tempinviter int;
declare tempnumber int;
set tempinviter = useruid;
set temptype = -1;
while ((tempinviter>0)&(temptype!=usertype)) do
select uid,type_id,inviter_id into tempuid,temptype,tempinviter from relation where uid = tempinviter;
set tempnumber = tempnumber+1;
end while;
return tempuid;
end

//查询中必须再套一层才能修改()
update store
set store_commodity =
(select hh.store_name from (select store_commodity from store where uid = 2 limit 1) hh)
where uid = 2;


//子查询临时列
select m.username, (select sum(uid) from revenue)from user as m;
select m.username, (select sum(uid) from revenue where uid  =1) as amout from user as m where m.uid = 1;
//混合查询加子表临时列查询
select d.uid,d.username,d.type_id,(select sum(uid) from revenue where uid  =d.uid) as amout from (select c.uid,c.username,relation.type_id from user c inner join relation on c.uid = relation.uid) as d;

//查询并修改某列
update store
set store_commodity = concat('a',',',
(select hh.store_commodity from (select store_commodity from store where uid = 2 limit 1) hh)
)
where uid = 2;

 //查询一个店长(收益者)方法1
select * from relation where uid in (select * from (select inviter_id from relation where uid = ? limit 1 )as t) limit 1

 //查询一个店长(收益者)方法2 不支持limit
select * from relation where uid in (select inviter_id from relation where uid = 10) limit 1;



  select * from relation where uid in (select * from (select inviter_id from relation where uid = ? limit 1 )as t) limit 1
  select * from user c inner join relation on c.uid = relation.uid
  select * from user c inner join relation on c.uid in (select * from (select uid from relation where inviter_id = ?)

//已验证
create function `fff`(uidstart int,usertype int)
returns int
begin
declare tempuid int;
declare temptype int;
declare tempinviter int;
declare tempnumber int;
set tempuid = uidstart;
set tempnumber = 0;
select uid,type_id,inviter_id into @puid,@ptype,@pinviter from relation where uid = tempuid limit 1;
set tempnumber = tempnumber+1;
set tempuid = @puid;
set temptype = @ptype;
set tempinviter = @pinviter;
return tempinviter;
end

//查询数据是否存在
select ifnull((select 'y' from wxdb.user where uid = 2 limit 1),'n')

//on duplicate key update 语句
insert into search(search_info)values('1,2,3,4,5')on duplicate key update uid = 2;


//查询子表超过一定数量,修改主表列
select uid,count(uid) from orders group by uid;
//把子表中超过1条记录且在主表中type=1的修改为999
update relation r inner join
(select relation.uid from relation inner join (select uid,count(*) as promote from orders group by uid)as lev on relation.uid = lev.uid and lev.promote >1 and relation.type_id =1)
as stay on r.uid = stay.uid set type_id = 999;
//where要在group by之前
select count(*) from relation where inviter_id = 0 group by inviter_id;
select inviter_id,count(*) as mems from relation where inviter_id = 0 group by inviter_id;
select hh.inviter_id from (select inviter_id,count(*) as mems from relation group by inviter_id) as hh where hh.mems>0;
select hh.inviter_id from (select inviter_id,count(*), as mems from relation where inviter_id = 0 group by inviter_id) as hh where hh.mems>0;

//查询原type_id = ? 且 他邀请的类型为 ? 的数量超过了 ?
select relation.uid from relation inner join (select hh.inviter_id as uid from (select inviter_id,count(*) as mems from relation where type_id = 1 group by inviter_id) as hh where hh.mems > 0) as ts on ts.uid = relation.uid and relation.type_id = 2;


create table invite_code(
user_invite_code varchar(255) unique not null
)engine=innodb default charset=utf8;