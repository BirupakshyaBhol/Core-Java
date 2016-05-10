CREATE  PROCEDURE insert_student(IN id INT, IN name VARCHAR(20))
BEGIN
insert into test.student values (id, name);
END
