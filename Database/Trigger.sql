-- -----------------------------------------------------
DROP TRIGGER IF EXISTS Before_Insert_PassWord;
CREATE Trigger Before_Insert_PassWord BEFORE INSERT ON `Account`
    FOR EACH ROW
    SET NEW.Password = PASSWORD(NEW.Password);

-- -----------------------------------------------------
DROP TRIGGER IF EXISTS Before_Update_PassWord;
CREATE Trigger Before_Update_PassWord BEFORE UPDATE ON `Account`
    FOR EACH ROW
    SET NEW.Password = PASSWORD(NEW.Password);

