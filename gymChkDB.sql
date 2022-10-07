-- 최대 수용 인원, 현재 시설을 이용중인 회원(인원수 체크용)
-- 시설ID, 정원, 체크인한 인원수,  누적인원수
create table gymChk (
  gym_id number constraint gym_id_pk primary key,
  maxMem number DEFAULT 0,
  checkIn number DEFAULT 0,
  sumMem number DEFAULT 0
);

select * from gymChk;
-- drop table gymChk;
insert into gymChk VALUES (1, 0, 0, 0);
-- alter table gymChk add sumMem number;
-- ALTER TABLE gymChk MODIFY (sumMem DEFAULT 0);

-- UPDATE gymChk  SET maxMem = 0, checkIn = 0  where gym_id = 1;
UPDATE gymChk  SET maxMem = 24  where gym_id = 1;
select maxMem from gymChk  where gym_id = 1;