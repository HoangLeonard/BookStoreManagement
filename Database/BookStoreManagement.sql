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


-- --------------------------------------------------------
--
-- Table structure for table `Account`
--
CREATE TABLE `Account`
(
    `AccountID`   char(10)    NOT NULL,
    `UserAccount` varchar(20) NOT NULL,
    `Password`    varchar(50) NOT NULL,
    `Type`        varchar(10) NOT NULL,
    `Name`        char(30) NOT NULL,
    `Phone`       char(15) NOT NULL,
    `Address`     varchar(40) DEFAULT NULL,
    `Email`       varchar(40) DEFAULT NULL,
    PRIMARY KEY (AccountID)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

-- --------------------------------------------------------
--
-- Table structure for table `Bill`
--
CREATE TABLE `Bill`
(
    `BillID`    char(10) NOT NULL,
    `AccountID` char(10) NOT NULL,
    `Date`      date     NOT NULL,
    `Status`    char(10) DEFAULT 'delivery',
    PRIMARY KEY (BillID)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

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
  DEFAULT CHARSET = utf8mb4;

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
  DEFAULT CHARSET = utf8mb4;

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
  DEFAULT CHARSET = utf8mb4;

-- --------------------------------------------------------
--
-- Table structure for table `Book`
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
    PRIMARY KEY (BookID)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

-- --------------------------------------------------------
--
-- Table structure for table `Staff`
--
CREATE TABLE `Staff`
(
    `StaffID`       char(10)    NOT NULL,
    `BasicSalary`   int         NOT NULL,
    `Office`        char(10)    NOT NULL,
    `Date`          char(10)    NOT NULL,
    PRIMARY KEY (StaffID)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

-- --------------------------------------------------------
--
-- Indexes for dumped tables
--

--
-- Indexes for table `Account`
--
ALTER TABLE `Account`
    ADD CONSTRAINT `check_account_type`
        CHECK (`Type` IN ('client', 'staff', 'admin')),
    ADD CONSTRAINT `uni_useraccount`
        UNIQUE (UserAccount)
;

--
-- Indexes for table `Bill`
--
ALTER TABLE `Bill`
    ADD CONSTRAINT `fk_bill_accountid`
        FOREIGN KEY (AccountID)
            REFERENCES `Account`(AccountID)
            ON DELETE NO ACTION
            ON UPDATE CASCADE,
    ADD CONSTRAINT `check_status`
        CHECK (`Status` IN ('done', 'delivery', 'cancel'))
;

--
-- Indexes for table `Book`
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

--
-- Indexes for table `BillDetail`
--
ALTER TABLE `Staff`
    ADD CONSTRAINT `check_salary`
        CHECK (`BasicSalary` > 0),
    ADD CONSTRAINT `fk_staffid`FOREIGN KEY (`StaffID`)
        REFERENCES
            `Account`(`AccountID`)
        ON DELETE CASCADE
        ON UPDATE CASCADE
;

-- dumping data to Account
INSERT INTO `Account` (`AccountID`, `UserAccount`, `Password`, `Type`, `Name`, `Phone`, `Address`, `Email`) VALUES
('SID01', 'SID01staff', 2077035, 'staff', 'Đinh Bá Tiên', '0818704559', '119 Cống Quỳnh, Tp HCM', 'dinhbatien_UID01@gmail.com'),
('SID02', 'SID02staff', 533292, 'staff', 'Nguyễn Thanh Tùng', '0239936536', '222 Nguyễn Văn Cừ, Tp HCM', 'nguyenthanhtung_UID02@gmail.com'),
('SID03', 'SID03staff', 454646, 'staff', 'Nguyễn Ngọc Huyền', '0266457362', '223 Nguyễn Văn Cừ, Tp HCM', 'nguyenngochuyen@gmail.com'),
('SID04', 'SID04staff', 329565, 'staff', 'Đinh Trọng Tiến', '0265685365', '224 Nguyễn Văn Cừ, Tp HCM', 'dinhtrongtien1221@gmail.com'),
('SID05', 'SID05staff', 918511, 'staff', 'Bùi Ngọc Hằng', '0718225689', '332 Nguyễn Thái Học, Tp HCM', 'buingochang_UID03@gmail.com'),
('CID01', 'CID01client', 150226, 'client', 'Lê Quỳnh Như', '0871171047', '291 Hồ Văn Huê, Tp HCM', 'lequynhnhu_UID04@gmail.com'),
('CID02', 'CID02client', 938302, 'client', 'Nguyễn Mạnh Hùng', '0491735142', '95 Bà Rịa, Vũng Tàu', 'nguyenmanhhung_UID05@gmail.com'),
('CID03', 'CID03client', 411896, 'client', 'Trần Thanh Tâm', '0802342079', '34 Mai Thị Lự, Tp HCM', 'tranthanhtam_UID06@gmail.com'),
('CID04', 'CID04client', 396778, 'client', 'Trần Hồng Quang', '0114656132', '80 Lê Hồng Phong, Tp HCM', 'tranhongquang_UID07@gmail.com'),
('CID05', 'CID05client', 497644, 'client', 'Phạm Văn Vinh', '0126459679', '45 Trưng Vương, Hà Nội', 'phamvanvinh_UID08@gmail.com'),
('AID01', 'AID01admin', 806967, 'admin', 'Nguyễn Xuân Thắng', '0862452688', '36 Miếu Đầm, Hà Nội', 'nguyenxuanthang_UID09@gmail.com'),
('AID02', 'AID02admin', 144107, 'admin', 'Hoàng Phúc Nhật Minh', '0372827009', '182 Lương Thế Vinh, Hà Nội', 'hoangphucnhatminh_UID10@gmail.com');
update account set Password = PASSWORD(account.Password);

-- dumping data to Staff
INSERT INTO `Staff` (`StaffID`, `BasicSalary`, `Office`, `Date`) VALUES
('SID01', 7360000, 'manage', '2023-09-05'),
('SID02', 6430000, 'account', '2023-06-30'),
('SID03', 4780000, 'support', '2023-06-14'),
('SID04', 4540000, 'support', '2023-01-29'),
('SID05', 7160000, 'manage', '2023-05-02'),
('AID01', 7160000, 'admin', '2023-01-28'),
('AID02', 7160000, 'admin', '2023-01-06');
-- dumping data to Bill
INSERT INTO `Bill` (`BillID`, `AccountID`, `Date`, `Status`) VALUES
('BiID01', 'CID01', '2022-11-20', 'done'),
('BiID02', 'CID01', '2022-11-21', 'done'),
('BiID03', 'CID02', '2022-11-22', 'done'),
('BiID04', 'CID02', '2022-11-23', 'cancel'),
('BiID05', 'CID03', '2022-11-24', 'done'),
('BiID06', 'CID03', '2022-11-25', 'done'),
('BiID07', 'CID04', '2022-11-26', 'delivery'),
('BiID08', 'CID05', '2022-11-27', 'done'),
('BiID09', 'CID04', '2022-11-28', 'done'),
('BiID10', 'CID04', '2022-11-29', 'done'),
('BiID11', 'CID01', '2022-11-30', 'delivery'),
('BiID12', 'CID01', '2022-12-01', 'done'),
('BiID13', 'CID02', '2022-12-02', 'delivery'),
('BiID14', 'CID02', '2022-12-03', 'cancel'),
('BiID15', 'CID03', '2022-12-04', 'done'),
('BiID16', 'CID03', '2022-12-05', 'done'),
('BiID17', 'CID01', '2022-12-06', 'cancel'),
('BiID18', 'CID02', '2022-12-07', 'done'),
('BiID19', 'CID02', '2022-12-08', 'done'),
('BiID20', 'CID03', '2022-12-09', 'done'),
('BiID21', 'CID03', '2022-12-10', 'cancel'),
('BiID22', 'CID04', '2022-12-11', 'done'),
('BiID23', 'CID05', '2022-12-12', 'done'),
('BiID24', 'CID04', '2022-12-13', 'cancel'),
('BiID25', 'CID04', '2022-12-14', 'done'),
('BiID26', 'CID01', '2022-12-15', 'done'),
('BiID27', 'CID01', '2022-12-16', 'done'),
('BiID28', 'CID02', '2022-12-17', 'delivery'),
('BiID29', 'CID02', '2022-12-18', 'done'),
('BiID30', 'CID03', '2022-12-19', 'done'),
('BiID31', 'CID03', '2022-12-20', 'done'),
('BiID32', 'CID01', '2022-12-21', 'delivery'),
('BiID33', 'CID02', '2022-12-22', 'cancel'),
('BiID34', 'CID02', '2022-12-23', 'done'),
('BiID35', 'CID03', '2022-12-24', 'done'),
('BiID36', 'CID03', '2022-12-25', 'delivery'),
('BiID37', 'CID04', '2022-12-26', 'done'),
('BiID38', 'CID05', '2022-12-27', 'done'),
('BiID39', 'CID04', '2022-12-28', 'delivery'),
('BiID40', 'CID04', '2022-12-29', 'cancel');
-- dumping data to BillDetail
INSERT INTO `BillDetail` (`BillID`, `BookID`, `Quantity`) VALUES
('BiID01', 'BID41', 8),
('BiID02', 'BID69', 6),
('BiID02', 'BID20', 2),
('BiID02', 'BID51', 2),
('BiID02', 'BID72', 9),
('BiID03', 'BID39', 6),
('BiID03', 'BID28', 8),
('BiID03', 'BID67', 4),
('BiID04', 'BID05', 8),
('BiID05', 'BID34', 5),
('BiID05', 'BID24', 7),
('BiID05', 'BID31', 5),
('BiID05', 'BID19', 4),
('BiID06', 'BID58', 4),
('BiID07', 'BID36', 2),
('BiID07', 'BID72', 3),
('BiID08', 'BID71', 5),
('BiID09', 'BID77', 8),
('BiID09', 'BID48', 1),
('BiID09', 'BID39', 9),
('BiID10', 'BID74', 5),
('BiID11', 'BID43', 10),
('BiID11', 'BID22', 5),
('BiID11', 'BID31', 8),
('BiID12', 'BID58', 4),
('BiID13', 'BID11', 10),
('BiID13', 'BID44', 4),
('BiID13', 'BID67', 3),
('BiID14', 'BID10', 6),
('BiID14', 'BID17', 9),
('BiID15', 'BID77', 2),
('BiID16', 'BID60', 2),
('BiID17', 'BID32', 3),
('BiID17', 'BID07', 10),
('BiID18', 'BID29', 7),
('BiID19', 'BID27', 2),
('BiID20', 'BID35', 4),
('BiID20', 'BID08', 2),
('BiID20', 'BID33', 6),
('BiID20', 'BID03', 1),
('BiID21', 'BID61', 9),
('BiID21', 'BID26', 10),
('BiID22', 'BID15', 6),
('BiID23', 'BID17', 7),
('BiID23', 'BID54', 8),
('BiID24', 'BID32', 7),
('BiID24', 'BID61', 10),
('BiID25', 'BID79', 6),
('BiID26', 'BID77', 1),
('BiID27', 'BID50', 3),
('BiID27', 'BID53', 5),
('BiID27', 'BID51', 3),
('BiID27', 'BID09', 6),
('BiID28', 'BID01', 7),
('BiID29', 'BID10', 2),
('BiID29', 'BID61', 9),
('BiID30', 'BID03', 6),
('BiID30', 'BID76', 1),
('BiID31', 'BID41', 8),
('BiID32', 'BID72', 9),
('BiID32', 'BID24', 6),
('BiID33', 'BID26', 2),
('BiID33', 'BID58', 10),
('BiID33', 'BID78', 10),
('BiID34', 'BID22', 2),
('BiID35', 'BID40', 9),
('BiID35', 'BID22', 10),
('BiID35', 'BID32', 4),
('BiID36', 'BID08', 5),
('BiID36', 'BID40', 6),
('BiID37', 'BID06', 4),
('BiID37', 'BID60', 4),
('BiID38', 'BID65', 4),
('BiID38', 'BID72', 4),
('BiID39', 'BID52', 2),
('BiID39', 'BID35', 9),
('BiID40', 'BID03', 3),
('BiID40', 'BID15', 9),
('BiID40', 'BID66', 10);
-- dumping data to Author
INSERT INTO `Author` (`AuthorID`, `Name`, `Contact`) VALUES
('AuID01', 'Acacia', '0489621708'),
('AuID02', 'Adela', '0123545045'),
('AuID03', 'Elfleda', '0709539819'),
('AuID04', 'Adelaide', '0811354082'),
('AuID05', 'Doris', '0599585660'),
('AuID06', 'Blanche', '0382560820'),
('AuID07', 'Fidelia', '0800983798'),
('AuID08', 'Genevieve', '0982297546'),
('AuID09', 'Helga', '0855373189'),
('AuID10', 'Imelda', '0643649162'),
('AuID11', 'Jezebel', '0777707663'),
('AuID12', 'Joyce', '0277407120'),
('AuID13', 'Kaylin', '0309987822'),
('AuID14', 'Ladonna', '0917321945'),
('AuID15', 'Mabel', '0714681169'),
('AuID17', 'HPNM', '0845412546'),
('AuID18', 'AnnaThang', '0154698716'),
('AuID19', 'Phạm Hải', '0843695874'),
('AuID20', 'Aoyama Gōshō', '0213659745'),
('AuID21', 'Team Teacher', '0215469699'),
('AuID22', 'Team IT', '0363265699'),
('AuID23', 'War Earth', '0846974554');
-- dumping data to Publisher
INSERT INTO `Publisher` (`PublisherID`, `PublisherName`, `Contact`) VALUES
('PID01', 'NXB Đại học Quốc gia', '0878781202'),
('PID02', 'NXB Sự thật', 'suthat123@gmail.com'),
('PID03', 'NXB Kim Đồng', 'kimdongbacvang@email.com'),
('PID04', 'NXB Giáo Dục', 'giaoduc@edu.com.vn'),
('PID05', 'NXB Thanh Niên ', 'ThanhnienVN@gmail.com'),
('PID06', 'NXB KHTN & CN', 'khtnvacongnghe@gmail.com'),
('PID07', 'NXB The Universe', 'world@space.earth.com'),
('PID08', 'NXB Thế Giới', 'thegioi132@gmail.com'),
('PID09', 'NXB CHiến Tranh', 'war@gmail.com'),
('PID10', 'RELX Group', 'relxgr@gmail.com'),
('PID11', 'Hachette Livre', 'hlivre@gmail.com'),
('PID12', 'Springer Nature', 'Snature1@gmail.com'),
('PID13', 'McGraw-Hill Education', 'mghilledu@edu.com.vn'),
('PID14', 'NXB Trung Quốc', 'chinabook@gmail.com');
-- dumping data to Book
INSERT INTO `Book` (`BookID`, `BookName`, `AuthorID`, `PublisherID`, `Categories`, `Quantity`, `UnitPrice`) VALUES
('BID01', 'Norwegian wood', 'AuID01', 'PID04', 'Happy ending,Gia đình', 15, 107500),
('BID02', 'To kill a mockingbird', 'AuID02', 'PID04', 'Happy ending,Gia đình,Tiểu thuyết', 58, 258100),
('BID03', 'The Alchemist', 'AuID03', 'PID05', 'Tiểu thuyết,Phiêu lưu,Giới hạn độ tuổi', 25, 293300),
('BID04', 'Life Of Pi', 'AuID04', 'PID05', 'Tiểu thuyết,Phiêu lưu', 42, 185300),
('BID05', 'Diary Of A Wimpy Kid', 'AuID05', 'PID02', 'Tiểu thuyết,Gia đình,Tuyển tập', 36, 294000),
('BID06', 'To Kill A Mockingbird', 'AuID06', 'PID02', 'Tuyển tập,Khoa học viễn tưởng', 68, 368200),
('BID07', 'Wonder', 'AuID07', 'PID02', 'Gia đình,Truyện ngắn', 79, 205200),
('BID08', 'Moby Dick', 'AuID08', 'PID01', 'Phiêu lưu,Truyện ngắn', 82, 147500),
('BID09', 'Peter Pan', 'AuID09', 'PID01', 'Tiểu thuyết,Phiêu lưu,Tuyển tập', 30, 274800),
('BID10', 'Madame Bovary', 'AuID10', 'PID01', 'Tiểu thuyết,Phiêu lưu,Gia đình', 24, 189900),
('BID11', 'Dear John', 'AuID11', 'PID03', 'Tuyển tập,Khoa học viễn tưởng,Giật gân', 28, 166500),
('BID12', 'Me Before You', 'AuID12', 'PID03', 'Tuyển tập,Khoa học viễn tưởng,Lãn mạn', 76, 161900),
('BID13', 'Thirteen Reasons Why', 'AuID13', 'PID03', 'Tuyển tập,Khoa học viễn tưởng,Happy ending', 63, 256700),
('BID14', 'Tuesdays with Morrie', 'AuID14', 'PID05', 'Tuyển tập,Khoa học viễn tưởng,Giới hạn độ tuổi', 12, 394300),
('BID15', 'Alice’s adventures in wonderland ', 'AuID15', 'PID05', 'Tuyển tập,Khoa học viễn tưởng,Truyện ngắn', 10, 311300),
('BID16', 'Conan', 'AuID20', 'PID03', 'Rùng rợn,Giật gân,Giới hạn độ tuổi', 12, 183100),
('BID17', 'Toán 1', 'AuID21', 'PID04', 'Sách giáo khoa', 100, 320600),
('BID18', 'Toán 2', 'AuID21', 'PID04', 'Sách giáo khoa', 10, 203900),
('BID19', 'Toán 3', 'AuID21', 'PID04', 'Sách giáo khoa', 12, 349600),
('BID20', 'Toán 4', 'AuID21', 'PID04', 'Sách giáo khoa', 35, 368000),
('BID21', 'Toán 5', 'AuID21', 'PID04', 'Sách giáo khoa', 15, 363200),
('BID22', 'Toán 6', 'AuID21', 'PID04', 'Sách giáo khoa', 20, 115500),
('BID23', 'Toán 7', 'AuID21', 'PID04', 'Sách giáo khoa', 25, 388900),
('BID24', 'Toán 8', 'AuID21', 'PID04', 'Sách giáo khoa', 23, 258500),
('BID25', 'Toán 9', 'AuID21', 'PID04', 'Sách giáo khoa', 220, 277600),
('BID26', 'Toán 10', 'AuID21', 'PID04', 'Sách giáo khoa', 43, 382800),
('BID27', 'Toán 11', 'AuID21', 'PID04', 'Sách giáo khoa', 212, 121900),
('BID28', 'Toán 12', 'AuID21', 'PID04', 'Sách giáo khoa', 210, 208300),
('BID29', 'Văn 1', 'AuID21', 'PID04', 'Sách giáo khoa', 80, 328600),
('BID30', 'Văn 2', 'AuID21', 'PID04', 'Sách giáo khoa', 70, 194700),
('BID31', 'Văn 3', 'AuID21', 'PID04', 'Sách giáo khoa', 91, 311100),
('BID32', 'Văn 4', 'AuID21', 'PID04', 'Sách giáo khoa', 62, 248300),
('BID33', 'Văn 5', 'AuID21', 'PID04', 'Sách giáo khoa', 42, 205600),
('BID34', 'Văn 6', 'AuID21', 'PID04', 'Sách giáo khoa', 20, 268300),
('BID35', 'Văn 7', 'AuID21', 'PID04', 'Sách giáo khoa', 33, 314900),
('BID36', 'Văn 8', 'AuID21', 'PID04', 'Sách giáo khoa', 22, 163100),
('BID37', 'Văn 9', 'AuID21', 'PID04', 'Sách giáo khoa', 44, 361100),
('BID38', 'Văn 10', 'AuID21', 'PID04', 'Sách giáo khoa', 45, 124500),
('BID39', 'Văn 11', 'AuID21', 'PID04', 'Sách giáo khoa', 98, 161100),
('BID40', 'Văn 12', 'AuID21', 'PID04', 'Sách giáo khoa', 45, 327600),
('BID41', 'English 1', 'AuID21', 'PID04', 'Sách giáo khoa', 72, 167500),
('BID42', 'English 2', 'AuID21', 'PID04', 'Sách giáo khoa', 320, 287100),
('BID43', 'English 3', 'AuID21', 'PID04', 'Sách giáo khoa', 20, 115600),
('BID44', 'English 4', 'AuID21', 'PID04', 'Sách giáo khoa', 21, 268900),
('BID45', 'English 5', 'AuID21', 'PID04', 'Sách giáo khoa', 36, 351200),
('BID46', 'English 6', 'AuID21', 'PID04', 'Sách giáo khoa', 208, 161200),
('BID47', 'English 7', 'AuID21', 'PID04', 'Sách giáo khoa', 100, 377800),
('BID48', 'English 8', 'AuID21', 'PID04', 'Sách giáo khoa', 827, 230300),
('BID49', 'English 9', 'AuID21', 'PID04', 'Sách giáo khoa', 923, 346700),
('BID50', 'English 10', 'AuID21', 'PID04', 'Sách giáo khoa', 112, 201200),
('BID51', 'English 11', 'AuID21', 'PID04', 'Sách giáo khoa', 20, 148100),
('BID52', 'English 12', 'AuID21', 'PID04', 'Sách giáo khoa', 1520, 123200),
('BID53', 'Công nghệ phần mềm 1', 'AuID22', 'PID06', 'Sách chuyên ngành', 90, 301100),
('BID54', 'Công nghệ phần mềm 2', 'AuID22', 'PID06', 'Sách chuyên ngành', 99, 317900),
('BID55', 'Công nghệ phần mềm 3', 'AuID22', 'PID06', 'Sách chuyên ngành', 66, 399500),
('BID56', 'Công nghệ phần mềm 4', 'AuID22', 'PID06', 'Sách chuyên ngành', 48, 156900),
('BID57', 'Công nghệ phần mềm 5', 'AuID22', 'PID06', 'Sách chuyên ngành', 58, 389100),
('BID58', 'Công nghệ phần mềm 6', 'AuID22', 'PID06', 'Sách chuyên ngành', 75, 296500),
('BID59', 'C++ dev', 'AuID22', 'PID06', 'Sách chuyên ngành', 95, 209900),
('BID60', 'Python', 'AuID22', 'PID06', 'Sách chuyên ngành', 65, 130600),
('BID61', 'Java Book', 'AuID22', 'PID06', 'Sách chuyên ngành', 63, 181200),
('BID62', 'Artificial Intelligence', 'AuID22', 'PID06', 'Sách chuyên ngành', 62, 383300),
('BID63', 'Tớ học lập trình', 'AuID22', 'PID06', 'Sách chuyên ngành', 91, 257400),
('BID64', 'Kiến trúc máy tính', 'AuID22', 'PID06', 'Sách chuyên ngành', 30, 274500),
('BID65', 'Chinh phục lập trình', 'AuID22', 'PID06', 'Sách chuyên ngành', 22, 178200),
('BID66', 'Giải tích 1', 'AuID19', 'PID04', 'Giáo trình', 54, 256100),
('BID67', 'Giải tích 2', 'AuID20', 'PID04', 'Giáo trình', 25, 223200),
('BID68', 'Giải tích 3', 'AuID21', 'PID04', 'Giáo trình', 15, 160700),
('BID69', 'Giải tích 4', 'AuID22', 'PID04', 'Giáo trình', 68, 213200),
('BID70', 'Lịch Sử Tổng Hợp 1', 'AuID18', 'PID01', 'Sách giáo khoa,Sách tham khảo,Giáo trình', 63, 316200),
('BID71', 'Sinh Học Tế bào', 'AuID18', 'PID01', 'Sách tham khảo,Giáo trình,Sách chuyên ngành', 15, 331700),
('BID72', 'Công nghệ Sinh Học', 'AuID18', 'PID01', 'Sách tham khảo,Giáo trình,Sách chuyên ngành', 14, 286200),
('BID73', 'Hóa sinh Cơ bản', 'AuID18', 'PID01', 'Sách tham khảo,Giáo trình,Sách chuyên ngành', 25, 254000),
('BID74', 'Đột phá tư duy 1', 'AuID17', 'PID01', 'Sách tham khảo,Giáo trình,Sách chuyên ngành', 61, 209100),
('BID75', 'Đột phá tư duy 2', 'AuID17', 'PID01', 'Sách tham khảo,Giáo trình,Sách chuyên ngành', 45, 243500),
('BID76', 'Đột phá tư duy 3', 'AuID17', 'PID01', 'Sách tham khảo,Giáo trình,Sách chuyên ngành', 44, 345800),
('BID77', 'Bách Khoa Toàn Thư', 'AuID17', 'PID07', 'Sách không dành cho người thường', 56, 261700),
('BID78', 'Bí Ẩn Vũ Trụ - Bí ẩn 3 6 9', 'AuID17', 'PID07', 'Sách không dành cho người thường', 78, 339600),
('BID79', 'Xuyên Không Thời Gian', 'AuID17', 'PID07', 'CaID22', 212, 370000),
('BID80', 'Chiến Tranh Thế Giới 2 3', 'AuID23', 'PID09', 'Giới hạn độ tuổi,Sách tham khảo', 51, 273800),
('BID81', 'Công Nghiệp Hóa Toàn Cầu', 'AuID06', 'PID08', 'Sách tham khảo', 51, 322000),
('BID82', 'Ultimate Human', 'AuID04', 'PID10', 'Khoa học viễn tưởng', 25, 376300),
('BID83', 'Relax Time', 'AuID06', 'PID11', 'Tiểu thuyết', 123, 109600),
('BID84', 'The Eyes', 'AuID22', 'PID12', 'Phiêu lưu,Truyện ngắn', 72, 154800),
('BID85', 'Iphone 11 Series', 'AuID20', 'PID13', 'Sách tham khảo', 155, 215500),
('BID86', 'How To Creat EveryThings', 'AuID15', 'PID14', 'Sách tham khảo', 200, 387000);


COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

