-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 19, 2021 at 10:53 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.10

--
-- Database: `BookStoreManagement`
--
DROP DATABASE IF EXISTS BookStoreManagement;

CREATE DATABASE BookStoreManagement;
USE BookStoreManagement;

SET
    SQL_MODE = "NO_ZERO_DATE";
START TRANSACTION;
SET
    time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
SET NAMES 'utf8' COLLATE 'utf8_vietnamese_ci';

-- --------------------------------------------------------
--
-- Table structure for table `Model.Account`
--
CREATE TABLE `Account`
(
    `AccountID`   char(10)    NOT NULL,
    `UserAccount` varchar(20) NOT NULL,
    `Password`    varchar(50) NOT NULL,
    `Type`        varchar(10) NOT NULL,
    `Name`        char(30) NOT NULL,
    `Phone`       char(15) NOT NULL,
    `Address`     varchar(40) NOT NULL,
    `Email`       varchar(40) DEFAULT NULL,
    PRIMARY KEY (AccountID)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- --------------------------------------------------------
--
-- Table structure for table `Staff`
--
CREATE TABLE `Staff`
(
    `StaffID`       char(10) NOT NULL,
    `BasicSalary`   int      NOT NULL,
    `Office`        char(10) DEFAULT NULL,
    `Date`          date     DEFAULT DATE(2022-27-11),
    PRIMARY KEY (StaffID)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- --------------------------------------------------------
--
-- Table structure for table `Delivery`
--
CREATE TABLE `Delivery`
(
    `DeliveryID`    char(10) NOT NULL,
    `Delivery`      char(10) NOT NULL,
    `Fee`           int DEFAULT 10000,
    `Contact`       char(10) Default null,
    PRIMARY KEY (DeliveryID)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- --------------------------------------------------------
--
-- Table structure for table `Model.Bill`
--
CREATE TABLE `Bill`
(
    `BillID`    char(10) NOT NULL,
    `AccountID` char(10) NOT NULL,
    `StaffID`   char(10) NOT NULL,
    `Date`      date     DEFAULT '2022-11-27',
    `Status`    char(10) DEFAULT 'processing',
    `DeliveryID`char(10) DEFAULT NULL,
    PRIMARY KEY (BillID)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- --------------------------------------------------------
--
-- Table structure for table `BillDetail`
--
CREATE TABLE `BillDetail`
(
    `BillID`   char(10) NOT NULL,
    `BookID`   char(10) NOT NULL,
    `Quantity` int      NOT NULL,
    PRIMARY KEY (BillID, BookID)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- --------------------------------------------------------
--
-- Table structure for table `Author`
--
CREATE TABLE `Author`
(
    `AuthorID` char(10)    NOT NULL,
    `Name`     varchar(30) NOT NULL,
    `Contact`  varchar(20) default NULL,
    PRIMARY KEY (AuthorID)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- --------------------------------------------------------
--
-- Table structure for table `Publisher`
--
CREATE TABLE `Publisher`
(
    `PublisherID`   char(10) NOT NULL,
    `PublisherName` char(30) NOT NULL,
    `Contact`       char(35) DEFAULT NULL,
    PRIMARY KEY (PublisherID)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- --------------------------------------------------------
--
-- Table structure for table `Model.Book`
--
CREATE TABLE `Book`
(
    `BookID`      char(10)    NOT NULL,
    `BookName`    varchar(50) NOT NULL,
    `AuthorID`    char(10)    NOT NULL,
    `PublisherID` char(10)    NOT NULL,
    `Categories`  varchar(50) DEFAULT NULL,
    `Quantity`    int         DEFAULT 0,
    `UnitPrice`   int         NOT NULL,
    FULLTEXT INDEX (`BookName`, `Categories`),
    PRIMARY KEY (BookID)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- -------------------------------------------------------------------------
-- -------------------------------------------------------------------------
--
-- Indexes for table `Model.Account`
--
ALTER TABLE `Account`
    ADD CONSTRAINT `check_account_type`
        CHECK (`Type` IN ('client', 'staff', 'admin')),
    ADD CONSTRAINT `uni_useraccount`
        UNIQUE (UserAccount)
;

--
-- Indexes for table `Staff`
--
ALTER TABLE `Staff`
    ADD CONSTRAINT `fk_staff_staffid`
        FOREIGN KEY (StaffID)
            REFERENCES `Account`(AccountID)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    ADD CONSTRAINT `check_staff_salary`
        CHECK ( `BasicSalary` >= 0 )
;

--
-- Indexes for table `Delivery`
--
ALTER TABLE `Delivery`
    ADD CONSTRAINT `check_delivery_fee` CHECK ( Fee > 0 )
;

--
-- Indexes for table `Model.Bill`
--
ALTER TABLE `Bill`
    ADD CONSTRAINT `fk_bill_accountid`
        FOREIGN KEY (AccountID)
            REFERENCES `Account`(AccountID)
            ON DELETE NO ACTION
            ON UPDATE CASCADE,
    ADD CONSTRAINT `fk_bill_staffid`
        FOREIGN KEY (StaffID)
            REFERENCES `Staff`(StaffID)
            ON DELETE NO ACTION
            ON UPDATE CASCADE,
    ADD CONSTRAINT `fk_bill_deliveryid`
        FOREIGN KEY (DeliveryID)
            REFERENCES `Delivery`(DeliveryID)
            ON DELETE NO ACTION
            ON UPDATE CASCADE,
    ADD CONSTRAINT `check_status`
        CHECK (`Status` IN ('done', 'delivering', 'cancel', 'processing'))
;

--
-- Indexes for table `Model.Book`
--
ALTER TABLE `Book`
    ADD CONSTRAINT `fk_book_authorid` FOREIGN KEY (`AuthorID`)
        REFERENCES `Author`(`AuthorID`)
        ON DELETE NO ACTION
        ON UPDATE CASCADE,
    ADD CONSTRAINT `fk_book_publisherid` FOREIGN KEY (`PublisherID`)
        REFERENCES `Publisher`(`PublisherID`)
        ON DELETE NO ACTION
        ON UPDATE CASCADE,
    ADD CONSTRAINT `check_UnitPrice`
        CHECK (`UnitPrice` >= 0)
;

--
-- Indexes for table `BillDetail`
--
ALTER TABLE `BillDetail`
    ADD CONSTRAINT fk_billdetail_billid FOREIGN KEY (`BillID`)
        REFERENCES
            `Bill`(`BillID`)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    ADD CONSTRAINT fk_billdetail_bookid FOREIGN KEY (`BookID`)
        REFERENCES
            `Book`(`BookID`)
        ON DELETE NO ACTION
        ON UPDATE CASCADE
;

-- dumping data to Model.Account
INSERT INTO `Account` (`AccountID`, `UserAccount`, `Password`, `Type`, `Name`, `Phone`, `Address`, `Email`) VALUES
	('SID0006', 'minh123', 'Minh@123', 'staff', 'Đinh Bá Tùng', '0818704548', '118 Cống Quỳnh, Tp HCM', 'dinhbatung_UID01@gmail.com'),
	('SID0001', 'SID0001staff', 'SID0001@staff', 'staff', 'Đinh Bá Tiên', '0818704559', '119 Cống Quỳnh, Tp HCM', 'dinhbatien_UID01@gmail.com'),
	('SID0002', 'SID0002staff', 'SID0002@staff', 'staff', 'Nguyễn Thanh Tùng', '0239936536', '222 Nguyễn Văn Cừ, Tp HCM', 'nguyenthanhtung_UID02@gmail.com'),
	('SID0003', 'SID0003staff', 'SID0003@staff', 'staff', 'Nguyễn Ngọc Huyền', '0266457362', '223 Nguyễn Văn Cừ, Tp HCM', 'nguyenngochuyen@gmail.com'),
	('SID0004', 'SID0004staff', 'SID0004@staff', 'staff', 'Đinh Trọng Tiến', '0265685365', '224 Nguyễn Văn Cừ, Tp HCM', 'dinhtrongtien1221@gmail.com'),
	('SID0005', 'SID0005staff', 'SID0005@staff', 'staff', 'Bùi Ngọc Hằng', '0718225689', '332 Nguyễn Thái Học, Tp HCM', 'buingochang_UID03@gmail.com'),
	('CID0006', 'minh1234', 'Minh@1234', 'client', 'Lê Quỳnh Nhung', '0871171036', '290 Hồ Văn Huê, Tp HCM', 'lequynhnhung_UID04@gmail.com'),
	('CID0001', 'CID0001client', 'CID0001@client', 'client', 'Lê Quỳnh Như', '0871171047', '291 Hồ Văn Huê, Tp HCM', 'lequynhnhu_UID04@gmail.com'),
	('CID0002', 'CID0002client', 'CID0002@client', 'client', 'Nguyễn Mạnh Hùng', '0491735142', '95 Bà Rịa, Vũng Tàu', 'nguyenmanhhung_UID05@gmail.com'),
	('CID0003', 'CID0003client', 'CID0003@client', 'client', 'Trần Thanh Tâm', '0802342079', '34 Mai Thị Lự, Tp HCM', 'tranthanhtam_UID06@gmail.com'),
	('CID0004', 'CID0004client', 'CID0004@client', 'client', 'Trần Hồng Quang', '0114656132', '80 Lê Hồng Phong, Tp HCM', 'tranhongquang_UID07@gmail.com'),
	('CID0005', 'CID0005client', 'CID0005@client', 'client', 'Phạm Văn Vinh', '0126459679', '45 Trưng Vương, Hà Nội', 'phamvanvinh_UID08@gmail.com'),
	('AID0003', 'minh12345', 'Minh@12345', 'admin', 'Nguyễn Xuân Thông', '0862452677', '35 Miếu Đầm, Hà Nội', 'nguyenxuanthong_UID09@gmail.com'),
	('AID0001', 'AID0001admin', 'AID0001@admin', 'admin', 'Nguyễn Xuân Thắng', '0862452688', '36 Miếu Đầm, Hà Nội', 'nguyenxuanthang_UID09@gmail.com'),
	('AID0002', 'AID0002admin', 'AID0002@admin', 'admin', 'Hoàng Phúc Nhật Minh', '0372827009', '182 Lương Thế Vinh, Hà Nội', 'hoangphucnhatminh_UID10@gmail.com');
UPDATE Account SET `Password` = PASSWORD(`Password`) WHERE 1=1;
-- dumping data to Staff
INSERT INTO `Staff` (`StaffID`, `BasicSalary`, `Office`, `Date`) VALUES
	('SID0001', 7360000, 'manage', '2023-09-05'),
	('SID0002', 6430000, 'account', '2023-06-30'),
	('SID0003', 4780000, 'support', '2023-06-14'),
	('SID0004', 4540000, 'support', '2023-01-29'),
	('SID0005', 7160000, 'manage', '2023-05-02'),
	('SID0006', 7160000, 'support', '2023-05-03'),
	('AID0001', 7160000, 'admin', '2023-01-28'),
	('AID0002', 7160000, 'admin', '2023-01-06'),
	('AID0003', 7000000, 'admin', '2023-01-07');
-- dumping data to Delivery
INSERT INTO `Delivery` (`DeliveryID`, `Delivery`, `Fee`, `Contact`) VALUES
	('DID0001', 'Grab Express Delivery', 20000,'0987790790'),
	('DID0002', 'Viettel Post', 20000,'0987790791'),
	('DID0003', 'J&T Express', 10000,'0987790792'),
	('DID0004', 'Ahamove', 12000,'0987790793'),
	('DID0005', 'Lalamove', 14000,'0987790794'),
	('DID0006', 'Giao hàng nhanh', 15000,'0987790795'),
	('DID0007', 'Giao hàng tiết kiệm', 16000,'0987790796'),
	('DID0008', 'Nhất Tín logistics', 17000,'0987790797');
-- dumping data to Model.Bill
INSERT INTO `Bill` (`BillID`, `AccountID`, `StaffID`, `Date`, `Status`, `DeliveryID`) VALUES
	('BiID0001', 'CID0001', 'SID0003', '2022-11-20', 'done', 'DID0006'),
	('BiID0002', 'CID0001', 'SID0004', '2022-11-21', 'done', 'DID0003'),
	('BiID0003', 'CID0002', 'SID0006', '2022-11-22', 'processing', 'DID0004'),
	('BiID0004', 'CID0002', 'SID0006', '2022-11-23', 'cancel', 'DID0006'),
	('BiID0005', 'CID0003', 'SID0004', '2022-11-24', 'done', 'DID0007'),
	('BiID0006', 'CID0003', 'SID0003', '2022-11-25', 'processing', 'DID0008'),
	('BiID0007', 'CID0004', 'SID0003', '2022-11-26', 'delivering', 'DID0002'),
	('BiID0008', 'CID0005', 'SID0004', '2022-11-27', 'done', 'DID0007'),
	('BiID0009', 'CID0004', 'SID0006', '2022-11-28', 'done', 'DID0006'),
	('BiID0010', 'CID0004', 'SID0006', '2022-11-29', 'processing', 'DID0007'),
	('BiID0011', 'CID0001', 'SID0004', '2022-11-30', 'processing', 'DID0006'),
	('BiID0012', 'CID0001', 'SID0003', '2022-12-01', 'done', 'DID0007'),
	('BiID0013', 'CID0002', 'SID0004', '2022-12-02', 'delivering', 'DID0001'),
	('BiID0014', 'CID0002', 'SID0006', '2022-12-03', 'cancel', 'DID0008'),
	('BiID0015', 'CID0003', 'SID0003', '2022-12-04', 'done', 'DID0005'),
	('BiID0016', 'CID0003', 'SID0004', '2022-12-05', 'done', 'DID0008'),
	('BiID0017', 'CID0001', 'SID0003', '2022-12-06', 'cancel', 'DID0003'),
	('BiID0018', 'CID0002', 'SID0006', '2022-12-07', 'done', 'DID0004'),
	('BiID0019', 'CID0002', 'SID0006', '2022-12-08', 'processing', 'DID0005'),
	('BiID0020', 'CID0003', 'SID0004', '2022-12-09', 'done', 'DID0007'),
	('BiID0021', 'CID0003', 'SID0003', '2022-12-10', 'cancel', 'DID0006'),
	('BiID0022', 'CID0004', 'SID0003', '2022-12-11', 'done', 'DID0004'),
	('BiID0023', 'CID0005', 'SID0004', '2022-12-12', 'done', 'DID0008'),
	('BiID0024', 'CID0004', 'SID0006', '2022-12-13', 'cancel', 'DID0005'),
	('BiID0025', 'CID0004', 'SID0003', '2022-12-14', 'done', 'DID0006'),
	('BiID0026', 'CID0001', 'SID0004', '2022-12-15', 'processing', 'DID0004'),
	('BiID0027', 'CID0001', 'SID0006', '2022-12-16', 'done', 'DID0008'),
	('BiID0028', 'CID0002', 'SID0006', '2022-12-17', 'delivering', 'DID0003'),
	('BiID0029', 'CID0002', 'SID0004', '2022-12-18', 'done', 'DID0005'),
	('BiID0030', 'CID0003', 'SID0003', '2022-12-19', 'processing', 'DID0002'),
	('BiID0031', 'CID0003', 'SID0004', '2022-12-20', 'done', 'DID0005'),
	('BiID0032', 'CID0001', 'SID0003', '2022-12-21', 'delivering', 'DID0001'),
	('BiID0033', 'CID0002', 'SID0006', '2022-12-22', 'cancel', 'DID0004'),
	('BiID0034', 'CID0002', 'SID0004', '2022-12-23', 'done', 'DID0007'),
	('BiID0035', 'CID0003', 'SID0006', '2022-12-24', 'processing', 'DID0008'),
	('BiID0036', 'CID0003', 'SID0003', '2022-12-25', 'processing', 'DID0001'),
	('BiID0037', 'CID0004', 'SID0006', '2022-12-26', 'done', 'DID0004'),
	('BiID0038', 'CID0005', 'SID0004', '2022-12-27', 'processing', 'DID0005'),
	('BiID0039', 'CID0004', 'SID0003', '2022-12-28', 'delivering', 'DID0008'),
	('BiID0040', 'CID0004', 'SID0006', '2022-12-29', 'cancel', 'DID0002');
-- dumping data to Author
INSERT INTO `Author` (`AuthorID`, `Name`, `Contact`) VALUES
	('AuID0001', 'Acacia', '0489621708'),
	('AuID0002', 'Adela', '0123545045'),
	('AuID0003', 'Elfleda', '0709539819'),
	('AuID0004', 'Adelaide', '0811354082'),
	('AuID0005', 'Doris', '0599585660'),
	('AuID0006', 'Blanche', '0382560820'),
	('AuID0007', 'Fidelia', '0800983798'),
	('AuID0008', 'Genevieve', '0982297546'),
	('AuID0009', 'Helga', '0855373189'),
	('AuID0010', 'Imelda', '0643649162'),
	('AuID0011', 'Jezebel', '0777707663'),
	('AuID0012', 'Joyce', '0277407120'),
	('AuID0013', 'Kaylin', '0309987822'),
	('AuID0014', 'Ladonna', '0917321945'),
	('AuID0015', 'Mabel', '0714681169'),
	('AuID0016', 'HPNM', '0845412546'),
	('AuID0017', 'AnnaThang', '0154698716'),
	('AuID0018', 'Phạm Hải', '0843695874'),
	('AuID0019', 'Aoyama Gōshō', '0213659745'),
	('AuID0020', 'Team Teacher', '0215469699'),
	('AuID0021', 'Team IT', '0363265699'),
	('AuID0022', 'War Earth', '0846974554');
-- dumping data to Publisher
INSERT INTO `Publisher` (`PublisherID`, `PublisherName`, `Contact`) VALUES
	('PID0001', 'NXB Đại học Quốc gia', '0878781202'),
	('PID0002', 'NXB Sự thật', 'suthat123@gmail.com'),
	('PID0003', 'NXB Kim Đồng', 'kimdongbacvang@email.com'),
	('PID0004', 'NXB Giáo Dục', 'giaoduc@edu.com.vn'),
	('PID0005', 'NXB Thanh Niên ', 'ThanhnienVN@gmail.com'),
	('PID0006', 'NXB KHTN & CN', 'khtnvacongnghe@gmail.com'),
	('PID0007', 'NXB The Universe', 'world@space.earth.com'),
	('PID0008', 'NXB Thế Giới', 'thegioi132@gmail.com'),
	('PID0009', 'NXB CHiến Tranh', 'war@gmail.com'),
	('PID0010', 'RELX Group', 'relxgr@gmail.com'),
	('PID0011', 'Hachette Livre', 'hlivre@gmail.com'),
	('PID0012', 'Springer Nature', 'Snature1@gmail.com'),
	('PID0013', 'McGraw-Hill Education', 'mghilledu@edu.com.vn'),
	('PID0014', 'NXB Trung Quốc', 'chinabook@gmail.com');
-- dumping data to Model.Book
INSERT INTO `Book` (`BookID`, `BookName`, `AuthorID`, `PublisherID`, `Categories`, `Quantity`, `UnitPrice`) VALUES
    ('BID0001', 'Norwegian wood', 'AuID0001', 'PID0004', 'Happy ending,Gia đình', 15, 107500),
    ('BID0002', 'To kill a mockingbird', 'AuID0002', 'PID0004', 'Happy ending,Gia đình,Tiểu thuyết', 58, 258100),
    ('BID0003', 'The Alchemist', 'AuID0003', 'PID0005', 'Tiểu thuyết,Phiêu lưu,Giới hạn độ tuổi', 25, 293300),
    ('BID0004', 'Life Of Pi', 'AuID0004', 'PID0005', 'Tiểu thuyết,Phiêu lưu', 42, 185300),
    ('BID0005', 'Diary Of A Wimpy Kid', 'AuID0005', 'PID0002', 'Tiểu thuyết,Gia đình,Tuyển tập', 36, 294000),
    ('BID0006', 'To Kill A Mockingbird', 'AuID0006', 'PID0002', 'Tuyển tập,Khoa học viễn tưởng', 68, 368200),
    ('BID0007', 'Wonder', 'AuID0007', 'PID0002', 'Gia đình,Truyện ngắn', 79, 205200),
    ('BID0008', 'Moby Dick', 'AuID0008', 'PID0001', 'Phiêu lưu,Truyện ngắn', 82, 147500),
    ('BID0009', 'Peter Pan', 'AuID0009', 'PID0001', 'Tiểu thuyết,Phiêu lưu,Tuyển tập', 30, 274800),
    ('BID0010', 'Madame Bovary', 'AuID0010', 'PID0001', 'Tiểu thuyết,Phiêu lưu,Gia đình', 24, 189900),
    ('BID0011', 'Dear John', 'AuID0011', 'PID0003', 'Tuyển tập,Khoa học viễn tưởng,Giật gân', 28, 166500),
    ('BID0012', 'Me Before You', 'AuID0012', 'PID0003', 'Tuyển tập,Khoa học viễn tưởng,Lãn mạn', 76, 161900),
    ('BID0013', 'Thirteen Reasons Why', 'AuID0013', 'PID0003', 'Tuyển tập,Khoa học viễn tưởng,Happy ending', 63, 256700),
    ('BID0014', 'Tuesdays with Morrie', 'AuID0014', 'PID0005', 'Tuyển tập,Khoa học viễn tưởng,Giới hạn độ tuổi', 12, 394300),
    ('BID0015', 'Alice’s adventures in wonderland ', 'AuID0015', 'PID0005', 'Tuyển tập,Khoa học viễn tưởng,Truyện ngắn', 10, 311300),
    ('BID0016', 'Conan', 'AuID0020', 'PID0003', 'Rùng rợn,Giật gân,Giới hạn độ tuổi', 12, 183100),
    ('BID0017', 'Toán 1', 'AuID0021', 'PID0004', 'Sách giáo khoa', 100, 320600),
    ('BID0018', 'Toán 2', 'AuID0021', 'PID0004', 'Sách giáo khoa', 10, 203900),
    ('BID0019', 'Toán 3', 'AuID0021', 'PID0004', 'Sách giáo khoa', 12, 349600),
    ('BID0020', 'Toán 4', 'AuID0021', 'PID0004', 'Sách giáo khoa', 35, 368000),
    ('BID0021', 'Toán 5', 'AuID0021', 'PID0004', 'Sách giáo khoa', 15, 363200),
    ('BID0022', 'Toán 6', 'AuID0021', 'PID0004', 'Sách giáo khoa', 20, 115500),
    ('BID0023', 'Toán 7', 'AuID0021', 'PID0004', 'Sách giáo khoa', 25, 388900),
    ('BID0024', 'Toán 8', 'AuID0021', 'PID0004', 'Sách giáo khoa', 23, 258500),
    ('BID0025', 'Toán 9', 'AuID0021', 'PID0004', 'Sách giáo khoa', 220, 277600),
    ('BID0026', 'Toán 10', 'AuID0021', 'PID0004', 'Sách giáo khoa', 43, 382800),
    ('BID0027', 'Toán 11', 'AuID0021', 'PID0004', 'Sách giáo khoa', 212, 121900),
    ('BID0028', 'Toán 12', 'AuID0021', 'PID0004', 'Sách giáo khoa', 210, 208300),
    ('BID0029', 'Văn 1', 'AuID0021', 'PID0004', 'Sách giáo khoa', 80, 328600),
    ('BID0030', 'Văn 2', 'AuID0021', 'PID0004', 'Sách giáo khoa', 70, 194700),
    ('BID0031', 'Văn 3', 'AuID0021', 'PID0004', 'Sách giáo khoa', 91, 311100),
    ('BID0032', 'Văn 4', 'AuID0021', 'PID0004', 'Sách giáo khoa', 62, 248300),
    ('BID0033', 'Văn 5', 'AuID0021', 'PID0004', 'Sách giáo khoa', 42, 205600),
    ('BID0034', 'Văn 6', 'AuID0021', 'PID0004', 'Sách giáo khoa', 20, 268300),
    ('BID0035', 'Văn 7', 'AuID0021', 'PID0004', 'Sách giáo khoa', 33, 314900),
    ('BID0036', 'Văn 8', 'AuID0021', 'PID0004', 'Sách giáo khoa', 22, 163100),
    ('BID0037', 'Văn 9', 'AuID0021', 'PID0004', 'Sách giáo khoa', 44, 361100),
    ('BID0038', 'Văn 10', 'AuID0021', 'PID0004', 'Sách giáo khoa', 45, 124500),
    ('BID0039', 'Văn 11', 'AuID0021', 'PID0004', 'Sách giáo khoa', 98, 161100),
    ('BID0040', 'Văn 12', 'AuID0021', 'PID0004', 'Sách giáo khoa', 45, 327600),
    ('BID0041', 'English 1', 'AuID0021', 'PID0004', 'Sách giáo khoa', 72, 167500),
    ('BID0042', 'English 2', 'AuID0021', 'PID0004', 'Sách giáo khoa', 320, 287100),
    ('BID0043', 'English 3', 'AuID0021', 'PID0004', 'Sách giáo khoa', 20, 115600),
    ('BID0044', 'English 4', 'AuID0021', 'PID0004', 'Sách giáo khoa', 21, 268900),
    ('BID0045', 'English 5', 'AuID0021', 'PID0004', 'Sách giáo khoa', 36, 351200),
    ('BID0046', 'English 6', 'AuID0021', 'PID0004', 'Sách giáo khoa', 208, 161200),
    ('BID0047', 'English 7', 'AuID0021', 'PID0004', 'Sách giáo khoa', 100, 377800),
    ('BID0048', 'English 8', 'AuID0021', 'PID0004', 'Sách giáo khoa', 827, 230300),
    ('BID0049', 'English 9', 'AuID0021', 'PID0004', 'Sách giáo khoa', 923, 346700),
    ('BID0050', 'English 10', 'AuID0021', 'PID0004', 'Sách giáo khoa', 112, 201200),
    ('BID0051', 'English 11', 'AuID0021', 'PID0004', 'Sách giáo khoa', 20, 148100),
    ('BID0052', 'English 12', 'AuID0021', 'PID0004', 'Sách giáo khoa', 1520, 123200),
    ('BID0053', 'Công nghệ phần mềm 1', 'AuID0022', 'PID0006', 'Sách chuyên ngành', 90, 301100),
    ('BID0054', 'Công nghệ phần mềm 2', 'AuID0022', 'PID0006', 'Sách chuyên ngành', 99, 317900),
    ('BID0055', 'Công nghệ phần mềm 3', 'AuID0022', 'PID0006', 'Sách chuyên ngành', 66, 399500),
    ('BID0056', 'Công nghệ phần mềm 4', 'AuID0022', 'PID0006', 'Sách chuyên ngành', 48, 156900),
    ('BID0057', 'Công nghệ phần mềm 5', 'AuID0022', 'PID0006', 'Sách chuyên ngành', 58, 389100),
    ('BID0058', 'Công nghệ phần mềm 6', 'AuID0022', 'PID0006', 'Sách chuyên ngành', 75, 296500),
    ('BID0059', 'C++ dev', 'AuID0022', 'PID0006', 'Sách chuyên ngành', 95, 209900),
    ('BID0060', 'Python', 'AuID0022', 'PID0006', 'Sách chuyên ngành', 65, 130600),
    ('BID0061', 'Java Model.Book', 'AuID0022', 'PID0006', 'Sách chuyên ngành', 63, 181200),
    ('BID0062', 'Artificial Intelligence', 'AuID0022', 'PID0006', 'Sách chuyên ngành', 62, 383300),
    ('BID0063', 'Tớ học lập trình', 'AuID0022', 'PID0006', 'Sách chuyên ngành', 91, 257400),
    ('BID0064', 'Kiến trúc máy tính', 'AuID0022', 'PID0006', 'Sách chuyên ngành', 30, 274500),
    ('BID0065', 'Chinh phục lập trình', 'AuID0022', 'PID0006', 'Sách chuyên ngành', 22, 178200),
    ('BID0066', 'Giải tích 1', 'AuID0019', 'PID0004', 'Giáo trình', 54, 256100),
    ('BID0067', 'Giải tích 2', 'AuID0020', 'PID0004', 'Giáo trình', 25, 223200),
    ('BID0068', 'Giải tích 3', 'AuID0021', 'PID0004', 'Giáo trình', 15, 160700),
    ('BID0069', 'Giải tích 4', 'AuID0022', 'PID0004', 'Giáo trình', 68, 213200),
    ('BID0070', 'Lịch Sử Tổng Hợp 1', 'AuID0018', 'PID0001', 'Sách giáo khoa,Sách tham khảo,Giáo trình', 63, 316200),
    ('BID0071', 'Sinh Học Tế bào', 'AuID0018', 'PID0001', 'Sách tham khảo,Giáo trình,Sách chuyên ngành', 15, 331700),
    ('BID0072', 'Công nghệ Sinh Học', 'AuID0018', 'PID0001', 'Sách tham khảo,Giáo trình,Sách chuyên ngành', 14, 286200),
    ('BID0073', 'Hóa sinh Cơ bản', 'AuID0018', 'PID0001', 'Sách tham khảo,Giáo trình,Sách chuyên ngành', 25, 254000),
    ('BID0074', 'Đột phá tư duy 1', 'AuID0017', 'PID0001', 'Sách tham khảo,Giáo trình,Sách chuyên ngành', 61, 209100),
    ('BID0075', 'Đột phá tư duy 2', 'AuID0016', 'PID0001', 'Sách tham khảo,Giáo trình,Sách chuyên ngành', 45, 243500),
    ('BID0076', 'Đột phá tư duy 3', 'AuID0017', 'PID0001', 'Sách tham khảo,Giáo trình,Sách chuyên ngành', 44, 345800),
    ('BID0077', 'Bách Khoa Toàn Thư', 'AuID0017', 'PID0007', 'Sách không dành cho người thường', 56, 261700),
    ('BID0078', 'Bí Ẩn Vũ Trụ - Bí ẩn 3 6 9', 'AuID0017', 'PID0007', 'Sách không dành cho người thường', 78, 339600),
    ('BID0079', 'Xuyên Không Thời Gian', 'AuID0017', 'PID0007', 'Sách không dành cho người thường', 212, 370000),
    ('BID0080', 'Chiến Tranh Thế Giới 2 3', 'AuID0016', 'PID0009', 'Giới hạn độ tuổi,Sách tham khảo', 51, 273800),
    ('BID0081', 'Công Nghiệp Hóa Toàn Cầu', 'AuID0006', 'PID0008', 'Sách tham khảo', 51, 322000),
    ('BID0082', 'Ultimate Human', 'AuID0004', 'PID0010', 'Khoa học viễn tưởng', 25, 376300),
    ('BID0083', 'Relax Time', 'AuID0006', 'PID0011', 'Tiểu thuyết', 123, 109600),
    ('BID0084', 'The Eyes', 'AuID0022', 'PID0012', 'Phiêu lưu,Truyện ngắn', 72, 154800),
    ('BID0085', 'Iphone 11 Series', 'AuID0020', 'PID0013', 'Sách tham khảo', 155, 215500),
    ('BID0086', 'How To Creat EveryThings', 'AuID0015', 'PID0014', 'Sách tham khảo', 200, 387000);
-- dumping data to BillDetail
INSERT INTO `BillDetail` (`BillID`, `BookID`, `Quantity`) VALUES
    ('BiID0001', 'BID0041', 8),
    ('BiID0002', 'BID0069', 6),
    ('BiID0002', 'BID0020', 2),
    ('BiID0002', 'BID0051', 2),
    ('BiID0002', 'BID0072', 9),
    ('BiID0003', 'BID0039', 6),
    ('BiID0003', 'BID0028', 8),
    ('BiID0003', 'BID0067', 4),
    ('BiID0004', 'BID0005', 8),
    ('BiID0005', 'BID0034', 5),
    ('BiID0005', 'BID0024', 7),
    ('BiID0005', 'BID0031', 5),
    ('BiID0005', 'BID0019', 4),
    ('BiID0006', 'BID0058', 4),
    ('BiID0007', 'BID0036', 2),
    ('BiID0007', 'BID0072', 3),
    ('BiID0008', 'BID0071', 5),
    ('BiID0009', 'BID0077', 8),
    ('BiID0009', 'BID0048', 1),
    ('BiID0009', 'BID0039', 9),
    ('BiID0010', 'BID0074', 5),
    ('BiID0011', 'BID0043', 10),
    ('BiID0011', 'BID0022', 5),
    ('BiID0011', 'BID0031', 8),
    ('BiID0012', 'BID0058', 4),
    ('BiID0013', 'BID0011', 10),
    ('BiID0013', 'BID0044', 4),
    ('BiID0013', 'BID0067', 3),
    ('BiID0014', 'BID0010', 6),
    ('BiID0014', 'BID0017', 9),
    ('BiID0015', 'BID0077', 2),
    ('BiID0016', 'BID0060', 2),
    ('BiID0017', 'BID0032', 3),
    ('BiID0017', 'BID0007', 10),
    ('BiID0018', 'BID0029', 7),
    ('BiID0019', 'BID0027', 2),
    ('BiID0020', 'BID0035', 4),
    ('BiID0020', 'BID0008', 2),
    ('BiID0020', 'BID0033', 6),
    ('BiID0020', 'BID0003', 1),
    ('BiID0021', 'BID0061', 9),
    ('BiID0021', 'BID0026', 10),
    ('BiID0022', 'BID0015', 6),
    ('BiID0023', 'BID0017', 7),
    ('BiID0023', 'BID0054', 8),
    ('BiID0024', 'BID0032', 7),
    ('BiID0024', 'BID0061', 10),
    ('BiID0025', 'BID0079', 6),
    ('BiID0026', 'BID0077', 1),
    ('BiID0027', 'BID0050', 3),
    ('BiID0027', 'BID0053', 5),
    ('BiID0027', 'BID0051', 3),
    ('BiID0027', 'BID0009', 6),
    ('BiID0028', 'BID0001', 7),
    ('BiID0029', 'BID0010', 2),
    ('BiID0029', 'BID0061', 9),
    ('BiID0030', 'BID0003', 6),
    ('BiID0030', 'BID0076', 1),
    ('BiID0031', 'BID0041', 8),
    ('BiID0032', 'BID0072', 9),
    ('BiID0032', 'BID0024', 6),
    ('BiID0033', 'BID0026', 2),
    ('BiID0033', 'BID0058', 10),
    ('BiID0033', 'BID0078', 10),
    ('BiID0034', 'BID0022', 2),
    ('BiID0035', 'BID0040', 9),
    ('BiID0035', 'BID0022', 10),
    ('BiID0035', 'BID0032', 4),
    ('BiID0036', 'BID0008', 5),
    ('BiID0036', 'BID0040', 6),
    ('BiID0037', 'BID0061', 4),
    ('BiID0037', 'BID0060', 4),
    ('BiID0038', 'BID0065', 4),
    ('BiID0038', 'BID0072', 4),
    ('BiID0039', 'BID0052', 2),
    ('BiID0039', 'BID0035', 9),
    ('BiID0040', 'BID0003', 3),
    ('BiID0040', 'BID0015', 9),
    ('BiID0040', 'BID0066', 10);

COMMIT;