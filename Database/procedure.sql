drop procedure if exists CurrentAccountID;
create
    definer = root@localhost procedure CurrentAccountID(
    IN accountType char(10),
    IN prefix int
    )
BEGIN
    select CAST(SUBSTR(`AccountID`, prefix + 1) AS SIGNED) as `thelastest`
    from account WHERE accountType = `Type`
    ORDER BY thelastest DESC
    LIMIT 0,1;
END;

-- -----------------------------------------------------
drop procedure if exists CurrentBillID;
create
    definer = root@localhost procedure CurrentBillID(
        IN prefix INT
    )
BEGIN
    select CAST(SUBSTR(`BillID`, prefix+1) AS SIGNED) as `thelastest`
    from bill
    ORDER BY thelastest DESC
    LIMIT 0,1;
END;

-- -----------------------------------------------------
drop procedure if exists CurrentAuthorID;
create
    definer = root@localhost procedure CurrentAuthorID(
        IN prefix INT
    )
BEGIN
    select CAST(SUBSTR(`AuthorID`, prefix+1) AS SIGNED) as `thelastest`
    from author
    ORDER BY thelastest DESC
    LIMIT 0,1;
END;

-- -----------------------------------------------------
drop procedure if exists CurrentPublisherID;
create
    definer = root@localhost procedure CurrentPublisherID(
        IN prefix INT
    )
BEGIN
    select CAST(SUBSTR(`PublisherID`, prefix+1) AS SIGNED) as `thelastest`
    from publisher
    ORDER BY thelastest DESC
    LIMIT 0,1;
END;

-- -----------------------------------------------------
drop procedure if exists CurrentBookID;
create
    definer = root@localhost procedure CurrentBookID(
    IN prefix INT
    )
BEGIN
    select CAST(SUBSTR(`BookID`, prefix+1) AS Signed) as `thelastest`
    from book
    ORDER BY thelastest DESC
    LIMIT 0,1;
END;

