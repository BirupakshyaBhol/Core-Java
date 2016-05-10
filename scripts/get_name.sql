CREATE PROCEDURE get_name (IN id INT, OUT name VARCHAR(20))
BEGIN
	SELECT student.name INTO name FROM student WHERE student.id = id;
END;
