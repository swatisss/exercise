create sequence gw start with 6001;

create or replace procedure insert_emp
is begin
   insert into emp values(gw.nextval,'‚Ô‚é[','analyst',3333,sysdate,1500,0,30);
end;
/
