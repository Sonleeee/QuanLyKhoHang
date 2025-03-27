-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th3 28, 2025 lúc 12:14 AM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quanlikhohang`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
--

CREATE TABLE `account` (
  `fullName` varchar(50) DEFAULT NULL,
  `userName` varchar(50) NOT NULL,
  `password` varchar(60) DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `account`
--

INSERT INTO `account` (`fullName`, `userName`, `password`, `role`, `status`, `email`) VALUES
('Admin', 'admin', '$2a$12$233PassqoiZ/L5PwxV/0a.V95gkzPXdnYg1BFyASE5HdXSxlzbcMC', 'Admin', 1, 'lson24122003@gmail.com');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietphieunhap`
--

CREATE TABLE `chitietphieunhap` (
  `maPhieu` varchar(36) NOT NULL,
  `maHang` varchar(50) NOT NULL,
  `soLuong` int(11) DEFAULT NULL,
  `donGia` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `chitietphieunhap`
--

INSERT INTO `chitietphieunhap` (`maPhieu`, `maHang`, `soLuong`, `donGia`) VALUES
('PN1', 'DT01', 1, 23490000),
('PN1', 'DT02', 1, 19490000),
('PN12', 'DT01', 1, 21490000),
('PN12', 'DT02', 1, 18390000),
('PN13', 'DT01', 1, 21490000),
('PN13', 'DT03', 1, 17490000),
('PN14', 'DT02', 1, 19490000),
('PN14', 'DT03', 1, 20790000),
('PN14', 'VL02', 1, 10690000),
('PN15', 'DT01', 1, 22490000),
('PN15', 'DT03', 1, 17490000),
('PN16', 'DT02', 1, 23190000),
('PN16', 'DT03', 1, 19290000),
('PN17', 'DT02', 1, 19490000),
('PN17', 'VL02', 1, 10690000),
('PN19', 'DT01', 1, 24990000),
('PN19', 'DT02', 1, 21490000),
('PN19', 'VL02', 1, 10690000),
('PN19', 'VL03', 1, 9690000),
('PN2', 'DT01', 1, 25990000),
('PN2', 'DT03', 1, 20790000),
('PN20', '34E250328060751', 50, 55000000),
('PN26', 'DT03', 20, 15990000),
('PN27', 'VL01', 20, 135000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietphieuxuat`
--

CREATE TABLE `chitietphieuxuat` (
  `maPhieu` varchar(36) NOT NULL,
  `maHang` varchar(50) NOT NULL,
  `soLuong` int(11) DEFAULT NULL,
  `donGia` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `chitietphieuxuat`
--

INSERT INTO `chitietphieuxuat` (`maPhieu`, `maHang`, `soLuong`, `donGia`) VALUES
('PX1', 'DT01', 1, 23490000),
('PX1', 'DT02', 13, 19490000),
('PX1', 'DT03', 1, 15000000),
('PX10', 'DT01', 1, 20790000),
('PX10', 'DT02', 1, 18390000),
('PX10', 'VL01', 1, 10690000),
('PX10', 'VL02', 1, 9690000),
('PX10', 'VL03', 1, 8290000),
('PX12', 'DT01', 1, 20790000),
('PX12', 'DT02', 1, 17490000),
('PX12', 'VL01', 1, 7090000),
('PX13', 'DT01', 1, 24990000),
('PX13', 'DT02', 2, 19290000),
('PX13', 'DT03', 1, 17490000),
('PX13', 'VL01', 4, 7090000),
('PX14', 'DT01', 1, 20790000),
('PX14', 'DT02', 1, 21490000),
('PX14', 'DT03', 1, 18390000),
('PX14', 'VL02', 1, 9690000),
('PX14', 'VL03', 1, 8290000),
('PX15', 'DT01', 7, 23190000),
('PX15', 'DT02', 14, 20790000),
('PX15', 'DT03', 2, 19290000),
('PX15', 'VL01', 1, 7090000),
('PX16', 'DT01', 4, 22490000),
('PX16', 'DT02', 1, 20790000),
('PX16', 'DT03', 1, 25990000),
('PX17', 'DT01', 2, 25990000),
('PX18', 'DT02', 5, 22990000),
('PX18', 'DT03', 2, 18390000),
('PX19', 'DT01', 1, 24990000),
('PX19', 'VL01', 1, 15690000),
('PX19', 'VL02', 1, 9690000),
('PX19', 'VL03', 1, 8990000),
('PX2', 'DT01', 1, 25990000),
('PX2', 'DT02', 2, 17490000),
('PX2', 'VL02', 1, 9690000),
('PX20', 'DT01', 2, 17490000),
('PX20', 'DT02', 1, 16490000),
('PX20', 'VL02', 1, 9690000),
('PX20', 'VL03', 2, 8990000),
('PX21', 'DT01', 1, 17490000),
('PX21', 'VL01', 1, 15690000),
('PX21', 'VL02', 2, 9690000),
('PX21', 'VL03', 1, 8290000),
('PX22', 'DT01', 1, 19290000),
('PX22', 'DT02', 1, 16490000),
('PX23', 'DT01', 1, 8990000),
('PX23', 'VL01', 1, 15690000),
('PX23', 'VL02', 1, 9690000),
('PX23', 'VL03', 1, 7090000),
('PX24', 'DT02', 1, 19490000),
('PX24', 'DT03', 1, 18390000),
('PX24', 'VL01', 1, 16490000),
('PX24', 'VL03', 1, 8990000),
('PX25', 'DT01', 1, 19490000),
('PX25', 'DT02', 2, 17490000),
('PX25', 'VL01', 1, 7090000),
('PX26', 'DT01', 1, 19490000),
('PX26', 'DT02', 1, 23490000),
('PX26', 'DT03', 1, 15000000),
('PX26', 'VL01', 1, 19290000),
('PX26', 'VL02', 1, 17490000),
('PX27', 'DT03', 10, 15990000),
('PX3', 'DT01', 1, 23490000),
('PX3', 'DT02', 1, 18390000),
('PX3', 'VL01', 1, 10690000),
('PX4', 'DT03', 1, 23190000),
('PX4', 'VL01', 1, 17490000),
('PX4', 'VL02', 1, 17490000),
('PX5', 'DT01', 1, 22990000),
('PX5', 'DT02', 1, 19290000),
('PX5', 'DT03', 1, 17490000),
('PX5', 'VL01', 1, 16490000),
('PX5', 'VL03', 1, 8990000),
('PX6', 'DT01', 1, 13090000),
('PX6', 'DT02', 1, 9990000),
('PX6', 'DT03', 1, 25190000),
('PX6', 'VL01', 1, 23190000),
('PX7', 'DT01', 1, 25990000),
('PX7', 'DT02', 1, 19290000),
('PX7', 'VL01', 1, 7090000),
('PX8', 'DT01', 1, 21490000),
('PX8', 'DT02', 1, 15000000),
('PX8', 'DT03', 1, 19290000),
('PX8', 'VL01', 1, 18390000),
('PX8', 'VL02', 1, 7090000),
('PX9', 'DT01', 1, 25990000),
('PX9', 'DT02', 1, 23490000),
('PX9', 'VL01', 1, 10690000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hang`
--

CREATE TABLE `hang` (
  `maHang` varchar(50) NOT NULL,
  `tenHang` varchar(100) DEFAULT NULL,
  `soLuong` int(11) NOT NULL DEFAULT 0,
  `gia` double NOT NULL DEFAULT 0,
  `xuatXu` varchar(50) DEFAULT NULL,
  `trangThai` int(11) DEFAULT NULL,
  `IDloai` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `hang`
--

INSERT INTO `hang` (`maHang`, `tenHang`, `soLuong`, `gia`, `xuatXu`, `trangThai`, `IDloai`) VALUES
('34E250328060751', 'AirBlade', 50, 55000000, 'Việt Nam', 1, 1),
('DT01', 'Điện thoại iPhone 15 Pro Max 256GB', 44, 34990000, 'Mỹ', 0, 2),
('DT02', 'Điện thoại Samsung Galaxy S24 Ultra', 22, 31990000, 'Hàn Quốc', 1, 2),
('DT03', 'Điện thoại Xiaomi 13T Pro', 49, 15990000, 'Trung Quốc', 1, 2),
('VL01', 'Gạch men Prime 60x60', 220, 135000, 'Việt Nam', 1, 3),
('VL02', 'Xi măng Hà Tiên PCB40', 500, 95000, 'Việt Nam', 1, 3),
('VL03', 'Thép Hòa Phát D10 CB300', 299, 210000, 'Việt Nam', 1, 3),
('XM01', 'Xe máy Honda Vision 2024', 15, 32000000, 'Việt Nam', 1, 1),
('XM02', 'Xe máy Yamaha Exciter 155', 20, 47000000, 'Việt Nam', 1, 1),
('XM03', 'Xe máy Suzuki Raider 150', 10, 49000000, 'Việt Nam', 1, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `maNhaCungCap` varchar(50) NOT NULL,
  `tenNhaCungCap` varchar(50) DEFAULT NULL,
  `sdt` varchar(50) DEFAULT NULL,
  `diaChi` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nhacungcap`
--

INSERT INTO `nhacungcap` (`maNhaCungCap`, `tenNhaCungCap`, `sdt`, `diaChi`) VALUES
('APPLE', 'Công Ty TNHH Apple Việt Nam', '02899999999', 'Saigon Centre, Quận 1, TP. Hồ Chí Minh'),
('HATIEN', 'Công Ty CP Xi Măng Hà Tiên', '02996666666', 'Thủ Đức, TP. Hồ Chí Minh'),
('HOAPHAT', 'Công Ty CP Thép Hòa Phát', '02333333333', 'KCN Dung Quất, Quảng Ngãi'),
('HONDA', 'Công Ty TNHH Honda Việt Nam', '02113888888', 'Phúc Thắng, Phúc Yên, Vĩnh Phúc'),
('PRIME', 'Công Ty TNHH Gạch Men Prime', '02555555555', 'Tam Điệp, Ninh Bình'),
('SAMSUNG', 'Công Ty TNHH Samsung Electronics Việt Nam', '02222222222', 'KCN Yên Phong, Bắc Ninh'),
('XIAOMI', 'Công Ty TNHH Xiaomi Việt Nam', '02888888888', 'Tòa nhà Landmark 81, TP. Hồ Chí Minh'),
('YAMAHA', 'Công Ty TNHH Yamaha Motor Việt Nam', '02437867687', 'Từ Sơn, Bắc Ninh');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phanloai`
--

CREATE TABLE `phanloai` (
  `IDloai` int(11) NOT NULL,
  `TenLoai` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `phanloai`
--

INSERT INTO `phanloai` (`IDloai`, `TenLoai`) VALUES
(1, 'Xe'),
(2, 'Điện tử'),
(3, 'Vật liệu xây dựng');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieunhap`
--

CREATE TABLE `phieunhap` (
  `maPhieu` varchar(36) NOT NULL DEFAULT uuid(),
  `thoiGianTao` timestamp NULL DEFAULT NULL,
  `nguoiTao` varchar(50) DEFAULT NULL,
  `maNhaCungCap` varchar(50) DEFAULT NULL,
  `tongTien` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `phieunhap`
--

INSERT INTO `phieunhap` (`maPhieu`, `thoiGianTao`, `nguoiTao`, `maNhaCungCap`, `tongTien`) VALUES
('PN1', '2025-03-20 13:59:09', 'admin', 'APPLE', 42980000),
('PN12', '2025-03-20 02:19:48', 'admin', 'SAMSUNG', 39880000),
('PN13', '2025-03-20 02:19:36', 'admin', 'YAMAHA', 38980000),
('PN14', '2025-03-20 12:28:57', 'admin', 'APPLE', 50970000),
('PN15', '2025-03-20 12:36:25', 'admin', 'APPLE', 39980000),
('PN16', '2025-03-27 20:23:25', 'admin', 'HOAPHAT', 42480000),
('PN17', '2025-03-20 14:29:43', 'admin', 'APPLE', 30180000),
('PN19', '2025-03-20 07:09:21', 'admin', 'YAMAHA', 66860000),
('PN2', '2025-03-20 13:59:23', 'admin', 'APPLE', 46780000),
('PN20', '2025-03-27 23:09:00', 'admin', 'HONDA', 2750000000),
('PN21', '2025-03-20 11:54:21', 'admin', 'YAMAHA', 1536180000),
('PN22', '2025-03-20 12:32:09', 'admin', 'APPLE', 89660000),
('PN26', '2025-03-20 07:32:58', 'admin', 'APPLE', 319800000),
('PN27', '2025-03-27 20:21:58', 'admin', 'APPLE', 2700000),
('PN28', '2025-03-20 10:43:36', 'admin', 'HONDA', 71870000),
('PN29', '2025-03-20 02:19:55', 'admin', 'PRIME', 10690000),
('PN32', '2025-03-20 02:19:27', 'admin', 'HOAPHAT', 80260000),
('PN37', '2025-03-20 01:02:09', 'admin', 'HONDA', 85350000),
('PN38', '2025-03-20 01:08:48', 'admin', 'HONDA', 838500000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieuxuat`
--

CREATE TABLE `phieuxuat` (
  `maPhieu` varchar(36) NOT NULL DEFAULT uuid(),
  `thoiGianTao` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `nguoiTao` varchar(50) NOT NULL,
  `tongTien` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `phieuxuat`
--

INSERT INTO `phieuxuat` (`maPhieu`, `thoiGianTao`, `nguoiTao`, `tongTien`) VALUES
('PX1', '2025-03-20 14:10:44', 'admin', 291860000),
('PX10', '2025-03-20 18:41:08', 'admin', 57160000),
('PX12', '2025-03-20 19:06:56', 'admin', 45370000),
('PX13', '2025-03-20 12:31:48', 'admin', 109420000),
('PX14', '2025-03-20 16:30:10', 'admin', 78650000),
('PX15', '2025-03-27 22:30:01', 'admin', 499060000),
('PX16', '2025-03-20 15:04:47', 'admin', 136740000),
('PX17', '2025-03-20 15:34:07', 'admin', 51980000),
('PX18', '2025-03-20 20:32:57', 'admin', 151730000),
('PX19', '2025-03-20 02:20:15', 'Admin', 59360000),
('PX2', '2025-03-20 16:45:43', 'admin', 70660000),
('PX20', '2025-03-20 13:26:33', 'Admin', 79140000),
('PX21', '2025-03-20 13:36:43', 'Admin', 60850000),
('PX22', '2025-03-20 16:39:41', 'Admin', 35780000),
('PX23', '2025-03-20 17:18:54', 'Admin', 41460000),
('PX24', '2025-03-20 17:25:10', 'Admin', 63360000),
('PX25', '2025-03-20 18:51:31', 'Admin', 92550000),
('PX26', '2025-03-20 00:19:47', 'Admin', 94760000),
('PX27', '2025-03-20 07:34:38', 'Admin', 159900000),
('PX3', '2025-03-20 16:45:52', 'admin', 89350000),
('PX4', '2025-03-20 16:45:59', 'admin', 58170000),
('PX5', '2025-03-20 19:10:13', 'admin', 85250000),
('PX6', '2025-03-20 19:19:12', 'admin', 71460000),
('PX7', '2025-03-20 19:25:43', 'admin', 52370000),
('PX8', '2025-03-20 18:39:54', 'admin', 39880000),
('PX9', '2025-03-20 18:40:22', 'admin', 36680000);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`userName`) USING BTREE;

--
-- Chỉ mục cho bảng `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD PRIMARY KEY (`maPhieu`,`maHang`),
  ADD KEY `FK_ChiTietPhieuNhap_MayTinh` (`maHang`);

--
-- Chỉ mục cho bảng `chitietphieuxuat`
--
ALTER TABLE `chitietphieuxuat`
  ADD PRIMARY KEY (`maPhieu`,`maHang`),
  ADD KEY `FK_ChiTietPhieuXuat_MayTinh` (`maHang`);

--
-- Chỉ mục cho bảng `hang`
--
ALTER TABLE `hang`
  ADD PRIMARY KEY (`maHang`),
  ADD KEY `IDloai` (`IDloai`);

--
-- Chỉ mục cho bảng `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`maNhaCungCap`);

--
-- Chỉ mục cho bảng `phanloai`
--
ALTER TABLE `phanloai`
  ADD PRIMARY KEY (`IDloai`);

--
-- Chỉ mục cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`maPhieu`),
  ADD KEY `FK_PhieuNhap_NhaCungCap` (`maNhaCungCap`),
  ADD KEY `FK_PhieuNhap_Account` (`nguoiTao`);

--
-- Chỉ mục cho bảng `phieuxuat`
--
ALTER TABLE `phieuxuat`
  ADD PRIMARY KEY (`maPhieu`),
  ADD KEY `FK_PhieuXuat_Account` (`nguoiTao`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `phanloai`
--
ALTER TABLE `phanloai`
  MODIFY `IDloai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD CONSTRAINT `FK_ChiTietPhieuNhap_MayTinh` FOREIGN KEY (`maHang`) REFERENCES `hang` (`maHang`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_ChiTietPhieuNhap_PhieuNhap` FOREIGN KEY (`maPhieu`) REFERENCES `phieunhap` (`maPhieu`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `chitietphieuxuat`
--
ALTER TABLE `chitietphieuxuat`
  ADD CONSTRAINT `FK_ChiTietPhieuXuat_MayTinh` FOREIGN KEY (`maHang`) REFERENCES `hang` (`maHang`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_ChiTietPhieuXuat_PhieuXuat` FOREIGN KEY (`maPhieu`) REFERENCES `phieuxuat` (`maPhieu`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `hang`
--
ALTER TABLE `hang`
  ADD CONSTRAINT `hang_ibfk_1` FOREIGN KEY (`IDloai`) REFERENCES `phanloai` (`IDloai`);

--
-- Các ràng buộc cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `FK_PhieuNhap_Account` FOREIGN KEY (`nguoiTao`) REFERENCES `account` (`userName`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_PhieuNhap_NhaCungCap` FOREIGN KEY (`maNhaCungCap`) REFERENCES `nhacungcap` (`maNhaCungCap`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Các ràng buộc cho bảng `phieuxuat`
--
ALTER TABLE `phieuxuat`
  ADD CONSTRAINT `FK_PhieuXuat_Account` FOREIGN KEY (`nguoiTao`) REFERENCES `account` (`userName`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
