-- 使用部の宣言
CREATE OR REPLACE PACKAGE calc_sal_pkg IS
   FUNCTION ann_sal(p_sal IN emp.sal%TYPE, p_comm IN emp.comm%TYPE)
      RETURN NUMBER;

   FUNCTION ann_sal(p_sal IN emp.sal%TYPE)
      RETURN NUMBER;
END calc_sal_pkg;
/

-- 本体の定義
CREATE OR REPLACE PACKAGE BODY calc_sal_pkg IS
   FUNCTION ann_sal(p_sal IN emp.sal%TYPE, p_comm IN emp.comm%TYPE)
      RETURN NUMBER
   IS
      cal_month CONSTANT NUMBER := 16;
   BEGIN
      RETURN(p_sal+p_comm)*cal_month;
   END;

   FUNCTION ann_sal(P_sal IN emp.sal%TYPE)
      RETURN NUMBER
   IS
      cal_month CONSTANT NUMBER := 17;
   BEGIN
      RETURN p_sal*cal_month;
   END;
END calc_sal_pkg;
/
