-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 05, 2020 at 03:18 AM
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
('F007', 'Ikan Mas Bakar + Nasi', 19000),
('F008', 'Ikan Bawal Goreng + Nasi', 18000),
('F009', 'Ikan Bawal Bakar + Nasi', 19000),
('F010', 'Ati Ampela', 5000),
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
(1, 'M001', 18, 5),
(2, 'M002', 10, 5),
(3, 'M003', 12, 5),
(4, 'M004', 11, 24),
(5, 'M005', 3, 12),
(6, 'M006', 5, 2),
(7, 'M007', 5, 27),
(8, 'M008', 2, 30),
(9, 'M009', 5, 2),
(10, 'M010', 5, 2),
(11, 'M011', 24, 4),
(12, 'M012', 30, 8),
(13, 'M013', 8, 2),
(14, 'M014', 10, 3),
(15, 'M015', 9, 3),
(16, 'M016', 14, 2),
(17, 'M017', 16, 4),
(18, 'M018', 5, 1),
(19, 'M019', 11, 3),
(20, 'M020', 1, 0.1),
(21, 'M021', 1, 0.1),
(22, 'M022', 1, 0.2),
(23, 'M023', 1, 0.1),
(24, 'M024', 1, 0.1),
(25, 'M025', 3, 1);

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
('M003', 'Ikan Mas', 'Unit', 5000),
('M004', 'Ikan Bawal', 'Unit', 5750),
('M005', 'Tomat', 'Unit', 1400),
('M006', 'Ayam', 'Unit', 28000),
('M007', 'Ati Ampela', 'Unit', 2000),
('M008', 'Sun Kara', 'Unit', 5000),
('M009', 'Gula', 'Kg', 14000),
('M010', 'Gas LPG', 'Unit', 20000),
('M011', 'Ikan Lele', 'Unit', 4000),
('M012', 'AQUA Botol 450ml', 'Unit', 3500),
('M013', 'Beras', 'Kg', 14000),
('M014', 'Bumbu Bakar', 'Unit', 10000),
('M015', 'Bumbu Kuning', 'Unit', 10000),
('M016', 'Garam  Bata', 'Unit', 6000),
('M017', 'Tomat', 'Unit', 1250),
('M018', 'Sayur Kol', 'Unit', 7500),
('M019', 'Timun', 'Unit', 1250),
('M020', 'Bawang Merah', 'Kg', 20000),
('M021', ' Bawang Putih', 'Kg', 30000),
('M022', 'Kacang Mede', 'Kg', 150000),
('M023', 'Cabai Merah', 'Kg', 55000),
('M024', 'Daun Pohpohan', 'Kg', 97500),
('M025', 'Gula Merah', 'Kg', 20000);

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
-- Triggers `orderdetail`
--
DELIMITER $$
CREATE TRIGGER `updateInventory` BEFORE INSERT ON `orderdetail` FOR EACH ROW BEGIN
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
('F002', 'M006', 0.25),
('F002', 'M010', 0.05),
('F002', 'M013', 0.025),
('F002', 'M015', 0.1),
('F002', 'M018', 0.1),
('F002', 'M024', 0.001),
('F002', 'M019', 0.5),
('F002', 'M023', 0.015),
('F002', 'M017', 0.5),
('F002', 'M021', 0.015),
('F002', 'M022', 0.005),
('F002', 'M016', 0.003),
('F002', 'M025', 0.003),
('F003', 'M006', 0.25),
('F003', 'M010', 0.05),
('F003', 'M013', 0.025),
('F003', 'M014', 0.1),
('F003', 'M018', 0.1),
('F003', 'M024', 0.001),
('F003', 'M019', 0.5),
('F003', 'M023', 0.015),
('F003', 'M017', 0.5),
('F003', 'M021', 0.015),
('F003', 'M022', 0.005),
('F003', 'M016', 0.003),
('F003', 'M025', 0.025),
('F004', 'M015', 0.1),
('F004', 'M013', 0.025),
('F004', 'M010', 0.05),
('F004', 'M018', 0.1),
('F004', 'M024', 0.001),
('F004', 'M025', 0.003),
('F004', 'M016', 0.003),
('F004', 'M022', 0.005),
('F004', 'M021', 0.015),
('F004', 'M017', 0.5),
('F004', 'M019', 0.5),
('F004', 'M023', 0.015),
('F004', 'M011', 1),
('F005', 'M014', 0.1),
('F005', 'M011', 1),
('F005', 'M010', 0.05),
('F005', 'M013', 0.025),
('F005', 'M018', 0.1),
('F005', 'M019', 0.5),
('F005', 'M017', 0.5),
('F005', 'M023', 0.015),
('F005', 'M022', 0.003),
('F005', 'M016', 0.003),
('F005', 'M025', 0.003),
('F005', 'M024', 0.001),
('F005', 'M021', 0.015),
('F006', 'M003', 1),
('F006', 'M015', 0.1),
('F006', 'M013', 0.025),
('F006', 'M010', 0.05),
('F006', 'M018', 0.1),
('F006', 'M024', 0.001),
('F006', 'M019', 0.5),
('F006', 'M017', 0.5),
('F006', 'M023', 0.015),
('F006', 'M025', 0.003),
('F006', 'M016', 0.003),
('F006', 'M022', 0.005),
('F007', 'M003', 1),
('F007', 'M014', 0.1),
('F007', 'M010', 0.05),
('F007', 'M013', 0.025),
('F007', 'M018', 0.1),
('F007', 'M019', 0.5),
('F007', 'M017', 0.5),
('F007', 'M023', 0.015),
('F007', 'M022', 0.005),
('F007', 'M021', 0.015),
('F007', 'M025', 0.003),
('F007', 'M016', 0.003),
('F008', 'M004', 1),
('F008', 'M015', 0.1),
('F008', 'M013', 0.025),
('F008', 'M010', 0.05),
('F008', 'M018', 0.1),
('F008', 'M019', 0.5),
('F008', 'M017', 0.5),
('F008', 'M023', 0.015),
('F008', 'M021', 0.015),
('F008', 'M022', 0.005),
('F008', 'M025', 0.003),
('F008', 'M016', 0.003),
('F009', 'M004', 1),
('F009', 'M014', 0.1),
('F009', 'M013', 0.025),
('F009', 'M010', 0.05),
('F009', 'M019', 0.5),
('F009', 'M017', 0.5),
('F009', 'M021', 0.015),
('F009', 'M023', 0.015),
('F009', 'M025', 0.003),
('F009', 'M016', 0.003),
('F009', 'M022', 0.005),
('F009', 'M018', 0.1),
('F009', 'M024', 0.001),
('F010', 'M007', 2);

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
-- Table structure for table `supplyrecord`
--

CREATE TABLE `supplyrecord` (
  `sCode` varchar(4) CHARACTER SET latin1 NOT NULL,
  `date` date DEFAULT NULL,
  `Qty` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `supplyrecord`
--

INSERT INTO `supplyrecord` (`sCode`, `date`, `Qty`) VALUES
('S002', '2020-03-05', 5);

--
-- Triggers `supplyrecord`
--
DELIMITER $$
CREATE TRIGGER `reStockInventory` AFTER INSERT ON `supplyrecord` FOR EACH ROW BEGIN
	DECLARE done INT DEFAULT FALSE;
	DECLARE cmCode varchar(4);
	DECLARE matCode CURSOR FOR SELECT mCode FROM supplier WHERE supplier.sCode = new.sCode;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
    
	OPEN matCode;
		ins_loop: LOOP
			FETCH matCode INTO cmCode;
			IF done THEN
				LEAVE ins_loop;
			END IF;
			UPDATE inventory SET inventory.stock = (inventory.stock + new.Qty) WHERE inventory.mCode = cmCode;
		END LOOP;
	CLOSE matCode;
END
$$
DELIMITER ;

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
-- Indexes for table `supplyrecord`
--
ALTER TABLE `supplyrecord`
  ADD KEY `supplyrecord_ibfk_1` (`sCode`);

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
  MODIFY `no` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

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

--
-- Constraints for table `supplyrecord`
--
ALTER TABLE `supplyrecord`
  ADD CONSTRAINT `supplyrecord_ibfk_1` FOREIGN KEY (`sCode`) REFERENCES `supplier` (`sCode`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
