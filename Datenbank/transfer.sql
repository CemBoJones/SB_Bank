DROP procedure IF EXISTS mydb.TRANSFER;
DELIMITER ||
CREATE procedure mydb.TRANSFER(sender INT, destiny INT, amount DOUBLE)
BEGIN

DECLARE SENDERBALANCE DOUBLE;
DECLARE DESTINYBALANCE DOUBLE;

declare exit handler for sqlexception
begin
	rollback;
    /*return 'FAILURE';*/
end;

start transaction;

select kontostand into senderbalance from mydb.user where iduser=sender;
select kontostand into destinybalance from mydb.user where iduser=destiny;

select senderbalance-amount into senderbalance;
select destinybalance+amount into destinybalance;

update mydb.user set kontostand = senderbalance where idUSER = sender;
update mydb.user set kontostand = destinybalance where idUSER = destiny;

commit;

/*return 'SUCCESS';*/


END||
DELIMITER ; 
