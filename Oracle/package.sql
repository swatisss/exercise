-- 仕様部の作成
CREATE OR REPLACE PACKAGE man_hr_pkg IS
   pct_up NUMBER := 10;

   TYPE v_private IS RECORD(empno emp.empno%TYPE,
                            ename emp.ename%TYPE,
                            hiredate emp.hiredate%TYPE,
                            sal emp.sal%TYPE,
                            comm emp.comm%TYPE);

   FATAL_ERR EXCEPTION;
   PRAGMA EXCEPTION_INIT(FATAL_ERR,-600);

   PROCEDURE sel_emp(p_deptno IN emp.deptno%TYPE);

   FUNCTION get_manager(p_deptno IN emp.deptno%TYPE) RETURN NUMBER;
END man_hr_pkg;
/

-- 作成したパッケージの変数と例外を参照するプロシージャ
CREATE OR REPLACE PROCEDURE sal_up
(p_empno IN emp.empno%TYPE)
IS
   old_sal emp.sal%TYPE;
   new_sal emp.sal%TYPE;
BEGIN
   SELECT sal AS BEFORE,
          sal * (1+man_hr_pkg.pct_up/100) AS AFTER
   INTO old_sal,new_sal
   FROM emp WHERE empno = p_empno;
   DBMS_OUTPUT.PUT_LINE('変更前：'||old_sal||'　変更後：'||new_sal);
EXCEPTION
   WHEN man_hr_pkg.FATAL_ERR THEN
      RAISE_APPLICATION_ERROR(-20001,'DBの致命的なエラーです');
   WHEN OTHERS THEN
      RAISE_APPLICATION_ERROR(-20002,'アプリケーションのエラーです');
END;
/

-- パッケージ本体の作成
CREATE OR REPLACE PACKAGE BODY man_hr_pkg IS
   v_emp_rec v_private;

   PROCEDURE sel_emp(p_deptno IN emp.deptno%TYPE)
   IS
      CURSOR c1 IS SELECT empno, ename, hiredate, sal, comm FROM emp WHERE deptno = p_deptno;
   BEGIN
      OPEN c1;
      LOOP
         FETCH c1 INTO v_emp_rec;
         EXIT WHEN c1%NOTFOUND;
         DBMS_OUTPUT.PUT_LINE('EMPNO:'||v_emp_rec.empno||'ENAME'||v_emp_rec.ename||'HIREDATE:'||v_emp_rec.hiredate);
      END LOOP;
      CLOSE c1;
   EXCEPTION
      WHEN FATAL_ERR THEN
         RAISE_APPLICATION_ERROR(-20001,'DBの致命的なエラーです');
   END sel_emp;

   FUNCTION get_manager(p_deptno IN emp.deptno%TYPE)
   RETURN NUMBER
   IS
      v_empno emp.empno%TYPE;
   BEGIN
      SELECT empno INTO v_empno FROM emp WHERE job = '部長' AND deptno = p_deptno;
      RETURN v_empno;
   EXCEPTION
      WHEN OTHERS THEN
         RAISE_APPLICATION_ERROR(-20002, '値が不適切です');
      END get_manager;
END man_hr_pkg;
/
