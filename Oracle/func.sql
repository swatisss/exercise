CREATE OR REPLACE FUNCTION sample_func1
(p_val IN NUMBER)
RETURN VARCHAR2
IS
BEGIN
   IF MOD(p_val,2) = 0 THEN
      RETURN '偶数';
   ELSE
      RETURN '奇数';
   END IF;
END;
/

DECLARE
   v_func VARCHAR2(40);
   v_val NUMBER;
BEGIN
   v_val := 4;
   v_func := sample_func1(v_val);
   DBMS_OUTPUT.PUT_LINE('v_valは,'||v_func||'です');
END;
/

VARIABLE v_func VARCHAR2(40);
EXECUTE :v_func := sample_func1(4)
COL v_func FORMAT A40
PRINT v_func

SELECT sample_func1(4), sample_func1(5) FROM dual;

CREATE TABLE err_log(
   errdate DATE,
   errno NUMBER(3),
   errmsg VARCHAR2(500)
);

CREATE OR REPLACE FUNCTION sample_func2
RETURN NUMBER
IS
BEGIN
   INSERT INTO err_log(errdate, errno) VALUES(SYSDATE,1);
   RETURN 0;
END;
/
