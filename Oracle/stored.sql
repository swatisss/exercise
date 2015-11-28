SET SERVEROUTPUT ON

CREATE OR REPLACE PROCEDURE sample_proc1
(p_val1 IN NUMBER)
IS
BEGIN
   DBMS_OUTPUT.PUT_LINE('INパラメータ'||p_val1);
END;
/

CREATE OR REPLACE PROCEDURE sample_proc2
(p_val2 OUT NUMBER)
IS
BEGIN
   DBMS_OUTPUT.PUT_LINE('OUTパラメータ'||p_val2);
END;
/

CREATE OR REPLACE PROCEDURE sample_proc2
(p_val2 OUT NUMBER)
IS
BEGIN
   p_val2 := 2345;
END;
/

CREATE OR REPLACE PROCEDURE sample_proc3
(p_val3 IN OUT NUMBER)
IS
BEGIN
   DBMS_OUTPUT.PUT_LINE('IN OUTパラメータ'||p_val3);
   p_val3 := p_val3+2345;
END;
/


DECLARE
   v_val NUMBER := 0;
BEGIN
   sample_proc3(v_val);
   DBMS_OUTPUT.PUT_LINE('OUTパラメータ'||v_val);
END;
/

SET SERVEROUTPUT ON
BEGIN
   sample_proc2(2345);
END;
/

CREATE OR REPLACE PROCEDURE sample_proc3
(p_val4 IN NUMBER := 100,
 p_val5 IN NUMBER := 200)
IS
BEGIN
   DBMS_OUTPUT.PUT_LINE('p_val4'||p_val4);
   DBMS_OUTPUT.PUT_LINE('p_val5'||p_val5);
END;
/

BEGIN
   sample_proc3(p_val4 => 600,700);
END;
/

SELECT OBJECT_NAME, object_type,status
FROM USER_OBJECTS
WHERE OBJECT_NAME LIKE '%';

CREATE TABLE work(
   col1 NUMBER(4),
   col2 VARCHAR2(5)
);

CREATE OR REPLACE PROCEDURE sample_proc3
(p_col1 IN work.col1%TYPE,
 p_col2 IN work.col2%TYPE)
IS
BEGIN
   INSERT INTO work(col1,col2) VALUES(p_col1,p_col2);
   DBMS_OUTPUT.PUT_LINE('OK.'||p_col1||','||p_col2);
   EXCEPTION
      WHEN OTHERS THEN
         DBMS_OUTPUT.PUT_LINE('N.G'||p_col1||','||p_col2);
END;
/

CREATE OR REPLACE PROCEDURE sample_proc3
(p_col1 IN work.col1%TYPE,
 p_col2 IN work.col2%TYPE)
IS
BEGIN
   INSERT INTO work(col1,col2) VALUES(p_col1,p_col2);
   DBMS_OUTPUT.PUT_LINE('OK.'||p_col1||','||p_col2);
   -- EXCEPTION
   --    WHEN OTHERS THEN
   --       DBMS_OUTPUT.PUT_LINE('N.G'||p_col1||','||p_col2);
END;
/

BEGIN
   sample_proc3(1,'New1');
   sample_proc3(22222,'New2');
   sample_proc3(3,'New3');
END;
/

BEGIN
   sample_proc3(1,'New1');
   sample_proc3(22222,'New2');
   sample_proc3(3,'New3');
   EXCEPTION
      WHEN OTHERS THEN
         DBMS_OUTPUT.PUT_LINE('N.G プロシージャで例外が発生しました。');
END;
/
