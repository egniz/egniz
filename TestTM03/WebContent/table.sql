

select * from board

CREATE TABLE board(
num number(6) PRIMARY KEY,
id varchar2(10) not null,
title varchar2(90) not null,
content varchar2(1000) not null,
writeday date default sysdate,
readcnt number(6) default 0,
repRoot number(4),
repStep number(4),
repIndent number(4)
)

select * from board

CREATE TABLE member(
id varchar2(10) PRIMARY KEY,
pw varchar2(20) not null,
name varchar2(12) not null,
birthday varchar2(12) not null,
nkey number(4)
)

select * from member