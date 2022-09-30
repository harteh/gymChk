-- 최대 수용 인원, 현재 시설을 이용중인 회원(인원수 체크용)
create table gymChk (
  gym_id number constraint gym_id_pk primary key,
  maxMem number,
  checkIn number
);

select * from gymChk;
 drop table gymChk;
insert into gymChk VALUES (1, 30, 0);

-- UPDATE gymChk  SET maxMem = 0, checkIn = 0  where gym_id = 1;
UPDATE gymChk  SET maxMem = 24  where gym_id = 1;
select maxMem from gymChk  where gym_id = 1;