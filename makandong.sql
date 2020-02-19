-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2020 at 03:51 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `makandong`
--

-- --------------------------------------------------------

--
-- Table structure for table `foodbeve`
--

CREATE TABLE `foodbeve` (
  `fbCode` varchar(4) NOT NULL DEFAULT '' COMMENT 'Awalan F untuk makanan, Awalan D untuk Minuman',
  `Deskripsi` varchar(50) DEFAULT NULL,
  `Harga` double DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `foodbeve`
--

INSERT INTO `foodbeve` (`fbCode`, `Deskripsi`, `Harga`) VALUES
('D001', 'Hangat / Es Teh Manis', 3000),
('D002', 'Hangat / Es Jeruk', 5000),
('D003', 'AQUA Botol 450ml', 4000),
('D004', 'Freshtea', 5000),
('D005', 'Teh Botol Sosro', 5000),
('F001', 'Nasi Putih / Uduk', 5000),
('F002', 'Ayam Goreng + Nasi', 18000),
('F003', 'Ayam Bakar + Nasi', 19000),
('F004', 'Ikan Lele Goreng + Nasi', 15000),
('F005', 'Ikan Lele Bakar + Nasi', 16000),
('F006', 'Ikan Mas Goreng + Nasi', 18000),
('F007', 'Ikan Bawal Goreng + Nasi', 18000),
('F008', 'Ikan Bawal Bakar + Nasi', 19000),
('F009', 'Ati Ampela', 5000),
('F010', 'Usus', 5000),
('F011', 'Kulit', 5000),
('F012', 'Ceker / Kepala Ayam', 1000),
('F013', 'Terong', 5000),
('F014', 'Tahu / Tempe', 1000),
('F015', 'Cah Kangkung', 10000);

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

CREATE TABLE `inventory` (
  `no` int(3) NOT NULL,
  `mCode` varchar(4) NOT NULL COMMENT 'kode material',
  `stock` double NOT NULL DEFAULT 0,
  `needRestock` double NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inventory`
--

INSERT INTO `inventory` (`no`, `mCode`, `stock`, `needRestock`) VALUES
(1, 'M001', 13, 5),
(2, 'M002', 9.6, 5),
(3, 'M003', 12, 5),
(4, 'M004', 11, 24),
(5, 'M005', 3, 12),
(6, 'M006', 3.25, 2),
(7, 'M007', 5, 27),
(8, 'M008', 11.6, 30),
(9, 'M009', 5, 2),
(10, 'M010', 4.65, 2),
(11, 'M011', 24, 4),
(12, 'M012', 30, 8),
(13, 'M013', 5.775, 2);

-- --------------------------------------------------------

--
-- Table structure for table `material`
--

CREATE TABLE `material` (
  `mCode` varchar(4) NOT NULL COMMENT 'Format Mxxx , X = angka',
  `Deskripsi` varchar(30) NOT NULL,
  `Satuan` enum('Kg','Ikat','Potong','Unit') NOT NULL,
  `Harga` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `material`
--

INSERT INTO `material` (`mCode`, `Deskripsi`, `Satuan`, `Harga`) VALUES
('M001', 'Tahu', 'Unit', 500),
('M002', 'Tempe', 'Potong', 5000),
('M003', 'Ikan Mas', 'Unit', 10000),
('M004', 'Ikan Bawal', 'Unit', 5750),
('M005', 'Tomat', 'Unit', 1400),
('M006', 'Ayam', 'Unit', 28000),
('M007', 'Ati Ampela', 'Unit', 2000),
('M008', 'Sun Kara', 'Unit', 5000),
('M009', 'Gula', 'Kg', 14000),
('M010', 'Gas LPG', 'Unit', 20000),
('M011', 'Ikan Lele', 'Unit', 4000),
('M012', 'AQUA Botol 450ml', 'Unit', 3500),
('M013', 'Beras', 'Kg', 14000);

-- --------------------------------------------------------

--
-- Table structure for table `orderdetail`
--

CREATE TABLE `orderdetail` (
  `orderID` varchar(4) NOT NULL COMMENT 'kode Order',
  `fbCode` varchar(4) NOT NULL COMMENT 'kode id foodbeve',
  `Qty` smallint(6) NOT NULL COMMENT 'Kuantitas'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orderdetail`
--

INSERT INTO `orderdetail` (`orderID`, `fbCode`, `Qty`) VALUES
('1337', 'F001', 2),
('1337', 'F002', 7),
('1337', 'D003', 4);

--
-- Triggers `orderdetail`
--
DELIMITER $$
CREATE TRIGGER `Coba` BEFORE INSERT ON `orderdetail` FOR EACH ROW BEGIN
	DECLARE done INT DEFAULT FALSE;
	DECLARE cmCode varchar(4);
	DECLARE cQty double;
	DECLARE matCode CURSOR FOR SELECT mCode, Qty FROM recipe WHERE recipe.fbCode = new.fbCode;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
    
	OPEN matCode;
		ins_loop: LOOP
			FETCH matCode INTO cmCode, cQty;
			IF done THEN
				LEAVE ins_loop;
			END IF;
			UPDATE inventory SET inventory.stock = inventory.stock - (new.Qty * cQty) WHERE inventory.mCode = cmCode;
		END LOOP;
	CLOSE matCode;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `orderhead`
--

CREATE TABLE `orderhead` (
  `orderID` varchar(4) NOT NULL,
  `orderType` enum('Normal','Cathering') NOT NULL DEFAULT 'Normal',
  `orderName` varchar(16) NOT NULL,
  `orderDate` date NOT NULL,
  `orderDP` double NOT NULL DEFAULT 0 COMMENT 'DownPayment ',
  `orderTotal` double NOT NULL DEFAULT 0 COMMENT 'Total Cost Order'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orderhead`
--

INSERT INTO `orderhead` (`orderID`, `orderType`, `orderName`, `orderDate`, `orderDP`, `orderTotal`) VALUES
('1337', 'Normal', 'Cobalah Mengerti', '2020-02-19', 0, 152000);

-- --------------------------------------------------------

--
-- Table structure for table `recipe`
--

CREATE TABLE `recipe` (
  `fbCode` varchar(4) NOT NULL COMMENT 'kode id foodbeve',
  `mCode` varchar(4) NOT NULL COMMENT 'kode material',
  `Qty` double DEFAULT 0 COMMENT 'kuantitas'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `recipe`
--

INSERT INTO `recipe` (`fbCode`, `mCode`, `Qty`) VALUES
('F001', 'M013', 0.025),
('F001', 'M002', 0.2),
('F001', 'M008', 0.2),
('F002', 'M013', 0.025),
('F002', 'M006', 0.25),
('F002', 'M010', 0.05);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `sCode` varchar(4) NOT NULL COMMENT 'kode supplier',
  `Deskripsi` varchar(50) NOT NULL,
  `mCode` varchar(4) NOT NULL COMMENT 'kode material',
  `Alamat` text NOT NULL,
  `Telephone` varchar(12) NOT NULL COMMENT 'nomor telfon'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`sCode`, `Deskripsi`, `mCode`, `Alamat`, `Telephone`) VALUES
('S001', 'AQUA Golden Factory Bekasi', 'M012', 'Jl. Raya Bekasi No.KM.27, RT.007/RW.007, Medan Satria, Kecamatan Medan Satria, Kota Bks, Jawa Barat 17132', '021-82743484'),
('S002', 'Sentra Produksi PRIMKOPTI Tahu', 'M001', 'Jl. Sonton No.57, Lenteng Agung, Kec. Jagakarsa, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 12530', ''),
('S003', 'Sentra Produksi PRIMKOPTI Tempe', 'M002', 'Jl. Sonton No.57, Lenteng Agung, Kec. Jagakarsa, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 12530', ''),
('S004', 'Lele Sangkuriang Bintara Jaya', 'M011', 'Jln. Bintara Jaya Raya blok H no.1\r\nRt 06 / Rw 02 kelurahan bintara jaya\r\nkecamatan bekasi barat, bekasi 17136\r\nBekasi, Jawa Barat, Indonesia', '081318328169'),
('S005', 'Cirata FISH', 'M003', 'Waduk Cirata, Kec. Mande, Kab. Cianjur, Jawa Barat - Indonesia. ', '085723253600'),
('S006', 'GULAKU', 'M009', 'Wisma GKBI, Jln Jend. Sudirman No. 28, Suite #505, RT.14/RW.1, Bendungan Hilir, RT.14/RW.1, Bend. Hilir, Kota Jakarta Pusat, Daerah Khusus Ibukota Jakarta 10210', '08001567899');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `UID` varchar(4) NOT NULL COMMENT 'User ID',
  `Username` varchar(10) NOT NULL,
  `Password` varchar(12) NOT NULL,
  `Level` tinyint(1) NOT NULL COMMENT 'Level Pengguna, 0 untuk Administrator, 1 Staff'
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='table autentikasi pengguna aplikasi makandong';

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`UID`, `Username`, `Password`, `Level`) VALUES
('1337', '0day', 'root', 0),
('ST01', 'kiki', '123456', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `foodbeve`
--
ALTER TABLE `foodbeve`
  ADD PRIMARY KEY (`fbCode`);

--
-- Indexes for table `inventory`
--
ALTER TABLE `inventory`
  ADD PRIMARY KEY (`no`),
  ADD UNIQUE KEY `mCode` (`mCode`);

--
-- Indexes for table `material`
--
ALTER TABLE `material`
  ADD PRIMARY KEY (`mCode`);

--
-- Indexes for table `orderdetail`
--
ALTER TABLE `orderdetail`
  ADD KEY `orderID` (`orderID`),
  ADD KEY `fkOrderDetail_fbCode` (`fbCode`);

--
-- Indexes for table `orderhead`
--
ALTER TABLE `orderhead`
  ADD PRIMARY KEY (`orderID`);

--
-- Indexes for table `recipe`
--
ALTER TABLE `recipe`
  ADD KEY `fkRecipe_fbCode` (`fbCode`),
  ADD KEY `fkRecipe_mCode` (`mCode`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`sCode`),
  ADD KEY `fkSupplier_mCode` (`mCode`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`UID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `inventory`
--
ALTER TABLE `inventory`
  MODIFY `no` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `inventory`
--
ALTER TABLE `inventory`
  ADD CONSTRAINT `inventory_ibfk_1` FOREIGN KEY (`mCode`) REFERENCES `material` (`mCode`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `orderdetail`
--
ALTER TABLE `orderdetail`
  ADD CONSTRAINT `fkOrderDetail_fbCode` FOREIGN KEY (`fbCode`) REFERENCES `foodbeve` (`fbCode`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fkOrderDetail_orderID` FOREIGN KEY (`orderID`) REFERENCES `orderhead` (`orderID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `recipe`
--
ALTER TABLE `recipe`
  ADD CONSTRAINT `fkRecipe_fbCode` FOREIGN KEY (`fbCode`) REFERENCES `foodbeve` (`fbCode`),
  ADD CONSTRAINT `fkRecipe_mCode` FOREIGN KEY (`mCode`) REFERENCES `material` (`mCode`);

--
-- Constraints for table `supplier`
--
ALTER TABLE `supplier`
  ADD CONSTRAINT `fkSupplier_mCode` FOREIGN KEY (`mCode`) REFERENCES `material` (`mCode`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
