--SEQUENCE
CREATE SEQUENCE dept_deptid_seq;

DROP SEQUENCE dept_deptid_seq;;

CREATE SEQUENCE dept_deptid_seq
                INCREMENT BY 10
                START WITH 120
                MAXVALUE 9999
                NOCACHE
                NOCYCLE;
INSERT INTO departments(department_id, department_name, location_id)
VALUES      (dept_deptid_seq.NEXTVAL, 'Support', 2500);


SELECT	dept_deptid_seq.CURRVAL
FROM	dual;

ALTER SEQUENCE dept_deptid_seq
               INCREMENT BY 20
               MAXVALUE 999999
               NOCACHE
               NOCYCLE;

DROP SEQUENCE dept_deptid_seq;

--INDEX
CREATE INDEX 	emp_last_name_idx
ON 		employees(last_name);

DROP INDEX emp_last_name_idx;

--SYNONYM
CREATE SYNONYM  d_sum
FOR  dept_sum_vu;

DROP SYNONYM d_sum;
