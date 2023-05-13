DROP TABLE IF EXISTS tmp_Book;
CREATE TABLE tmp_Book (
                          `BookID`      char(10)    NOT NULL,
                          `BookName`    varchar(50) NOT NULL,
                          `AuthorID`    char(10)    NOT NULL,
                          `AuthorName`  char(50)    NOT NULL,
                          `PublisherID` char(10)    NOT NULL,
                          `PublisherName`char(40)   NOT NULL,
                          `Categories`  varchar(50) DEFAULT NULL,
                          `Quantity`    int         DEFAULT 0,
                          `UnitPrice`   int         NOT NULL,
                          FULLTEXT INDEX (`BookName`, `Categories`, `AuthorName`, `PublisherName`),
                          FULLTEXT INDEX (`Categories`),
                          PRIMARY KEY (BookID)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO tmp_Book(BookID, BookName, AuthorID, AuthorName, PublisherID, PublisherName, Categories, Quantity, UnitPrice)
SELECT BookID, BookName, a.AuthorID, Name as AuthorName, p.PublisherID, PublisherName, Categories, Quantity, UnitPrice
FROM book JOIN publisher p on p.PublisherID = book.PublisherID
          JOIN author a on a.AuthorID = book.AuthorID;

SELECT * FROM tmp_Book
where MATCH (BookName, Categories, AuthorName, PublisherName)
             AGAINST ('tuyển khoa' IN NATURAL LANGUAGE MODE )
AND MATCH (Categories) AGAINST ('+(tuyển tập)' IN BOOLEAN MODE ) AND PublisherName LIKE '%Thanh Niên%';