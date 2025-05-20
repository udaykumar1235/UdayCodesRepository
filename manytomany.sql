use manyToManyDB;

create table programmer(
id int PRIMARY KEY AUTO_INCREMENT,
name varchar(20),
salary int
)

create table project(
id int PRIMARY KEY AUTO_INCREMENT,
name varchar(20)
)

create table programmers_projects(
programmer_id int,
project_id int,
FOREIGN KEY (programmer_id)
REFERENCES programmer(id),
FOREIGN KEY (project_id)
REFERENCES project(id)
)

select * from programmer
select * from project
select * from programmers_projects


Query
=====
select p1_0.id,p1_0.name,p2_0.programmer_id,p2_1.id,p2_1.name,p1_0.salary from programmer p1_0 left join programmers_projects p2_0 on p1_0.id=p2_0.programmer_id left join project p2_1 on p2_1.id=p2_0.project_id where p1_0.id=?





