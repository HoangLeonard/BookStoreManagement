DROP USER IF EXISTS `ClientPortal`@`localhost`;
CREATE USER `ClientPortal`@`localhost` IDENTIFIED BY 'client';
GRANT SELECT, UPDATE ON bookstoremanagement.account TO `ClientPortal`@`localhost`;
FLUSH PRIVILEGES;

SHOW GRANTS FOR `ClientPortal`@`localhost`;