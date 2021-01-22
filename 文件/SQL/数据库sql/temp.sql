


select u.uid,u.phonenumber,u.username,u.portrait,u.regist_date from user u where u.uid in (1,2,3) limit 0,1;


select u.uid,u.phonenumber,u.username,u.portrait,u.regist_date from
user u
inner join
(select uid from (
       select t1.uid,
              if(find_in_set(inviter_id, @pids) > 0, @pids := concat(@pids, ',', uid), 0) as ischild
         from
            ( select uid,inviter_id from relation t where t.type_id =1 ) t1,
            ( select @pids := 1) t2
               ) t3
where ischild != 0) m
on u.uid = m.uid limit 0,1;



//向上查询关系链
select t2.uid,t2.type_id,t2.inviter_id from
(
select @rr as _id,
( select @rr := inviter_id from relation where uid = _id ) as inviter_id
from ( select @rr := 12) vars, relation h where @rr != 0
) t1
join relation t2 on t1._id = t2.uid;


select t2.uid from
(
select @rr as _id,
( select @rr := inviter_id from relation where uid = _id ) as inviter_id
from ( select @rr := 12) vars, relation h where @rr != 0
) t1
join user t2 on t1._id = t2.uid;


select uid from
(select uid as mem_uid , (select count(*) from relation where inviter_id = mem_uid) as number from relation where type_id = 1)
where number >= 1;

select uid,mem_number,total from
(select uid,sum(revenue_amount) as total from estimate where revenue_type=1 or revenue_type=2 and revenue_date>= '2020-01-01' group by uid) est
inner join
(select mem_uid,mem_number from
(select uid as mem_uid , (select count(*) from relation where inviter_id = mem_uid) as mem_number from relation where type_id = 1) rel
where mem_number >= 1) mem on est.uid = mem.mem_uid;


select mem_uid,mem_number,
(select sum(revenue_amount) from estimate where uid = mem_uid ) as total
 from
(select mem_uid,mem_number from
(select uid as mem_uid , (select count(*) from relation where inviter_id = mem_uid) as mem_number from relation where type_id = 1) rel
where mem_number >= 1) mem;





select if((select @ft :=finishTime from orders where orders.orderId = 125799503954 limit 1)>0,@ft,0)

update revenue set revenue_date = (select if((select @ft :=finishTime from orders where orders.orderId = revenue.orderId limit 1)>0,@ft,0)) where orderId = 125799503954;




update estimate set revenue_amount = 1 where





DELETE p1 from estimate p1, estimate p2 WHERE p1.tag= p2.tag and p1.uid = p2.uid AND p1.e_id > p2.e_id;


delete p1 from estimate p1, estimate p2 where concat(p1.tag,p1.uid) = concat(p2.tag,p2.uid) and p1.e_id > p2.e_id;
delete p1 from revenue p1, revenue p2 where concat(p1.tag,p1.uid) = concat(p2.tag,p2.uid) and p1.r_id > p2.r_id;


select p1.e_id from estimate p1, estimate p2 where concat(p1.tag,p1.uid) = concat(p2.tag,p2.uid) and p1.e_id > p2.e_id;
select p1.r_id from revenue p1, revenue p2 where concat(p1.tag,p1.uid) = concat(p2.tag,p2.uid) and p1.r_id > p2.r_id;
select p1.r_id,from_unixtime(p1.revenue_date/1000) from revenue p1, revenue p2 where concat(p1.tag,p1.uid) = concat(p2.tag,p2.uid) and p1.r_id > p2.r_id;

select linkdate from link where find_in_set('{"$ref":"$[1]"}',link.link);
update link set link = replace (link.link,'{"$ref":"$[1]"},','') where find_in_set('{"$ref":"$[1]"}',link.link);

[{"decimal":1.14839999999999998969713033147854730486869812011718750,"inviter_id":21,"multiple":false,"revenue_type":1,"type":0,"type_id":1,"uid":31},{"decimal":0.229679999999999997939426066295709460973739624023437500,"inviter_id":18,"multiple":false,"revenue_type":2,"type":0,"type_id":2,"uid":21},{"$ref":"$[1]"},{"decimal":0.01148399999999999989697130331478547304868698120117187500,"inviter_id":0,"multiple":false,"revenue_type":3,"type":0,"type_id":3,"uid":18}]
[{"decimal":1.14839999999999998969713033147854730486869812011718750,"inviter_id":21,"multiple":false,"revenue_type":1,"type":0,"type_id":1,"uid":31},{"decimal":0.229679999999999997939426066295709460973739624023437500,"inviter_id":18,"multiple":false,"revenue_type":2,"type":0,"type_id":2,"uid":21},{"decimal":0.01148399999999999989697130331478547304868698120117187500,"inviter_id":0,"multiple":false,"revenue_type":3,"type":0,"type_id":3,"uid":18}]
















