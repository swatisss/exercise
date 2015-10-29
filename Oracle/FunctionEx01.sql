CREATE OR REPLACE FUNCTION stat_sales(p_year IN NUMBER, p_month IN NUMBER)
RETURN NUMBER
IS
   v_day DATE;
   v_sales_total NUMBER;

   IF (p_year >= 0 && p_year <= 99)
      IF (p_month >= 1 && p_month <= 12)
         v_day := TO_DATE(LPAD(p_year,2,'0')||'-'||LPAD(p_month,2,'0'));
      ELSE
         DBMS_OUTPUT.PUT_LINE('月の入力が間違ってんよ');
      END IF;
   ELSE
      DBMS_OUTPUT.PUT_LINE('年の入力が間違ってんよ');
   END IF;

   CURSOR f1 IS SELECT SUM(sales_total) FROM sales WHERE TRUNC(time_id, 'mm') = v_day;
   BEGIN
      OPEN f1;
      FETCH f1 INTO v_sales_total;

      IF v_sales_total IS NULL
         
      ELSE
      RETURN f_dname;
   CLOSE f1;
   END;
/
