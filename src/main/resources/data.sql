create table task(
    id int primary key auto_increment,
    title varchar(200),
    description text,
    points int
);

insert into task values(1,'Task 1', 'Task 1 description', 100);
insert into task values(2,'Task 2', 'Task 2 description', 50);
insert into task values(3,'Task 3', 'Task 3 description', 10);
insert into task values(4,'Task 4', 'Repeat task 3', 10);