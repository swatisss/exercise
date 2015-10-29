CREATE OR REPLACE FUNCTION disp_dname(f_deptno IN dept.deptno%TYPE)
RETURN VARCHAR2
IS
   CURSOR f1 IS SELECT dname FROM dept WHERE deptno = f_deptno;
   f_dname dept.dname%TYPE;
   BEGIN
      OPEN f1;
      FETCH f1 INTO f_dname;
      RETURN f_dname;
   CLOSE f1;
   END;
/
