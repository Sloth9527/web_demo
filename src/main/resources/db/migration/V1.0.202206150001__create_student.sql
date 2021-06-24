DROP TABLE IF EXISTS student;
CREATE TABLE student
(
    id         INTEGER(8)                    NOT NULL AUTO_INCREMENT,
    s_no       VARCHAR(3)                    NOT NULL,
    s_name     VARCHAR(4) CHARACTER SET utf8 NOT NULL,
    s_sex      VARCHAR(2) CHARACTER SET utf8 NOT NULL,
    s_birthday DATETIME,
    class_num  VARCHAR(5),
    CONSTRAINT pr_student_id PRIMARY KEY (id)
);

DROP TABLE IF EXISTS course;
CREATE TABLE course
(
    id     INTEGER(8)                     NOT NULL AUTO_INCREMENT,
    c_no   VARCHAR(5)                     NOT NULL,
    c_name VARCHAR(10) CHARACTER SET utf8 NOT NULL,
    t_no   VARCHAR(10)                    NOT NULL,
    CONSTRAINT pr_course_id PRIMARY KEY (id)
);

DROP TABLE IF EXISTS score;
CREATE TABLE score
(
    id     INTEGER(8)     NOT NULL AUTO_INCREMENT,
    s_no   VARCHAR(3)     NOT NULL,
    c_no   VARCHAR(5)     NOT NULL,
    degree NUMERIC(10, 1) NOT NULL,
    CONSTRAINT pr_score_id PRIMARY KEY (id)
);

DROP TABLE IF EXISTS teacher;
CREATE TABLE teacher
(
    id         INTEGER(8)                    NOT NULL AUTO_INCREMENT,
    t_no       VARCHAR(3)                    NOT NULL,
    t_name     VARCHAR(4) CHARACTER SET utf8 NOT NULL,
    t_sex      VARCHAR(2) CHARACTER SET utf8 NOT NULL,
    t_birthday DATETIME                      NOT NULL,
    prof       VARCHAR(6),
    depart     VARCHAR(10)                   NOT NULL,
    CONSTRAINT pr_teacher_id PRIMARY KEY (id)
);

DROP TABLE IF EXISTS grade;
create table grade
(
    id           INTEGER(8) NOT NULL AUTO_INCREMENT,
    low          NUMERIC(3, 0),
    up           NUMERIC(3),
    letter_grade char(1),
    CONSTRAINT pr_grade_id PRIMARY KEY (id)
);
insert into grade(low, up, letter_grade)
values (90, 100, 'A');
insert into grade(low, up, letter_grade)
values (80, 89, 'B');
insert into grade(low, up, letter_grade)
values (70, 79, 'C');
insert into grade(low, up, letter_grade)
values (60, 69, 'D');
insert into grade(low, up, letter_grade)
values (0, 59, 'D');

INSERT INTO student (s_no, s_name, s_sex, s_birthday, class_num)
VALUES ( 108, '曾华'
       , '男', '1977-09-01', 95033);
INSERT INTO student (s_no, s_name, s_sex, s_birthday, class_num)
VALUES ( 105, '匡明'
       , '男', '1975-10-02', 95031);
INSERT INTO student (s_no, s_name, s_sex, s_birthday, class_num)
VALUES ( 107, '王丽'
       , '女', '1976-01-23', 95033);
INSERT INTO student (s_no, s_name, s_sex, s_birthday, class_num)
VALUES ( 101, '李军'
       , '男', '1976-02-20', 95033);
INSERT INTO student (s_no, s_name, s_sex, s_birthday, class_num)
VALUES ( 109, '王芳'
       , '女', '1977-09-01', 95031);
INSERT INTO student (s_no, s_name, s_sex, s_birthday, class_num)
VALUES ( 103, '陆君'
       , '男', '1974-06-03', 95031);

INSERT INTO course(c_no, c_name, t_no)
VALUES ('3-105', '计算机导论', 825);
INSERT INTO course(c_no, c_name, t_no)
VALUES ('3-245', '操作系统', 804);
INSERT INTO course(c_no, c_name, t_no)
VALUES ('6-166', '数据电路', 856);
INSERT INTO course(c_no, c_name, t_no)
VALUES ('9-888', '高等数学', 100);

INSERT INTO score(s_no, c_no, degree)
VALUES (103, '3-245', 86);
INSERT INTO score(s_no, c_no, degree)
VALUES (105, '3-245', 75);
INSERT INTO score(s_no, c_no, degree)
VALUES (109, '3-245', 68);
INSERT INTO score(s_no, c_no, degree)
VALUES (103, '3-105', 92);
INSERT INTO score(s_no, c_no, degree)
VALUES (105, '3-105', 88);
INSERT INTO score(s_no, c_no, degree)
VALUES (109, '3-105', 76);
INSERT INTO score(s_no, c_no, degree)
VALUES (101, '3-105', 64);
INSERT INTO score(s_no, c_no, degree)
VALUES (107, '3-105', 91);
INSERT INTO score(s_no, c_no, degree)
VALUES (108, '3-105', 78);
INSERT INTO score(s_no, c_no, degree)
VALUES (101, '6-166', 85);
INSERT INTO score(s_no, c_no, degree)
VALUES (107, '6-106', 79);
INSERT INTO score(s_no, c_no, degree)
VALUES (108, '6-166', 81);

INSERT INTO teacher(t_no, t_name, t_sex, t_birthday, prof, depart)
VALUES (804, '李诚', '男', '1958-12-02', '副教授', '计算机系');
INSERT INTO teacher(t_no, t_name, t_sex, t_birthday, prof, depart)
VALUES (856, '张旭', '男', '1969-03-12', '讲师', '电子工程系');
INSERT INTO teacher(t_no, t_name, t_sex, t_birthday, prof, depart)
VALUES (825, '王萍', '女', '1972-05-05', '助教', '计算机系');
INSERT INTO teacher(t_no, t_name, t_sex, t_birthday, prof, depart)
VALUES (831, '刘冰', '女', '1977-08-14', '助教', '电子工程系');
