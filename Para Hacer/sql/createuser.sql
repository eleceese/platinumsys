-- Create the user 
create user sad
  identified by "sad"
  default tablespace USERS
  temporary tablespace TEMP
  profile DEFAULT;
-- Grant/Revoke role privileges 
grant aq_administrator_role to sad with admin option;
grant connect to sad with admin option;
grant dba to sad;
-- Grant/Revoke system privileges 
grant administer any sql tuning set to sad;
grant administer database trigger to sad;
grant alter any index to sad;
grant alter any role to sad;
grant unlimited tablespace to sad;