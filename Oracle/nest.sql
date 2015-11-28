-- LOOPへのラベル
SET SERVEROUTPUT ON

DECLARE
   v_cnt_out NUMBER := 1;
   v_cnt_in NUMBER := 1;
BEGIN
   <<OUTER>>
   LOOP
      EXIT WHEN v_cnt_out = 4;
      DBMS_OUTPUT.PUT_LINE('OUTR: 処理'||v_cnt_out||'回目の処理');
      v_cnt_out := v_cnt_out+1;
      <<INNER>>
      LOOP
         EXIT OUTER WHEN(v_cnt_out = 3 AND v_cnt_in = 3);
         EXIT WHEN v_cnt_in = 3;
         DBMS_OUTPUT.PUT_LINE('**INNER: 処理'||v_cnt_in||'回目');
         v_cnt_in := v_cnt_in+1;
      END LOOP INNER;
      v_cnt_in := 1;
   END LOOP OUTER;
END;
/


   D:\app\koyama\product\11.1.0\db_1\bin;C:\Program Files (x86)\Intel\iCLS Client\;C:\Program Files\Intel\iCLS Client\;%SystemRoot%\system32;%SystemRoot%;%SystemRoot%\System32\Wbem;%SYSTEMROOT%\System32\WindowsPowerShell\v1.0\;C:\Program Files\Intel\Intel(R) Management Engine Components\DAL;C:\Program Files\Intel\Intel(R) Management Engine Components\IPT;C:\Program Files (x86)\Intel\Intel(R) Management Engine Components\DAL;C:\Program Files (x86)\Intel\Intel(R) Management Engine Components\IPT;C:\Program Files (x86)\Intel\OpenCL SDK\2.0\bin\x86;C:\Program Files (x86)\Intel\OpenCL SDK\2.0\bin\x64;C:\Program Files (x86)\Common Files\Roxio Shared\DLLShared\;C:\Program Files (x86)\Common Files\Roxio Shared\OEM\12.0\DLLShared\;C:\Program Files (x86)\Roxio 2010\OEM\AudioCore;c:\borland\bcc55\bin;%JAVA_HOME%\bin;%CATALINA_HOME%\bin;C:\Program Files\Microsoft SQL Server\110\Tools\Binn\;C:\Program Files\TortoiseSVN\bin;C:\Program Files (x86)\Windows Kits\8.1\Windows Performance Toolkit\;C:\Program Files (x86)\Microsoft SDKs\TypeScript\1.0\;C:\Program Files\Microsoft SQL Server\120\Tools\Binn\;C:\HashiCorp\Vagrant\bin;%MAVEN_HOME%\bin;%JENKINS_HOME%
