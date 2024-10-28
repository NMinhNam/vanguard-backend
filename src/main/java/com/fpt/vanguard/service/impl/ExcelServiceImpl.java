package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.response.NhanVienDtoResponse;
import com.fpt.vanguard.service.ExcelService;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExcelServiceImpl implements ExcelService {

    @Override
    public List<NhanVienDtoResponse> getNhanVienFromExcel(MultipartFile file) throws IOException {
        List<NhanVienDtoResponse> employees = new ArrayList<>();
        Workbook workbook = WorkbookFactory.create(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            if (row.getRowNum() == 0) continue;

            NhanVienDtoResponse employee = new NhanVienDtoResponse();

            Cell hoTenCell = row.getCell(0);
            if (hoTenCell != null && hoTenCell.getCellType() == CellType.STRING) {
                employee.setHoTen(hoTenCell.getStringCellValue());
            }

            Cell gioiTinhCell = row.getCell(1);
            if (gioiTinhCell != null && gioiTinhCell.getCellType() == CellType.STRING) {
                String gioiTinh = gioiTinhCell.getStringCellValue().trim();
                if ("Nam".equalsIgnoreCase(gioiTinh)) {
                    employee.setGioiTinh(true);
                } else if ("Nữ".equalsIgnoreCase(gioiTinh)) {
                    employee.setGioiTinh(false);
                }
            }


            Cell ngaySinhCell = row.getCell(2);
            if (ngaySinhCell != null && ngaySinhCell.getCellType() == CellType.NUMERIC) {
                employee.setNgaySinh(String.valueOf(ngaySinhCell.getLocalDateTimeCellValue().toLocalDate()));
            }

            Cell dienThoaiCell = row.getCell(3);
            if (dienThoaiCell != null && dienThoaiCell.getCellType() == CellType.STRING) {
                employee.setDienThoai(dienThoaiCell.getStringCellValue());
            } else if (dienThoaiCell != null && dienThoaiCell.getCellType() == CellType.NUMERIC) {
                employee.setDienThoai(String.valueOf((long) dienThoaiCell.getNumericCellValue()));
            }

            Cell cccdCell = row.getCell(4);
            if (cccdCell != null && cccdCell.getCellType() == CellType.STRING) {
                employee.setCccd(cccdCell.getStringCellValue());
            }

            Cell diaChiCell = row.getCell(5);
            if (diaChiCell != null && diaChiCell.getCellType() == CellType.STRING) {
                employee.setDiaChi(diaChiCell.getStringCellValue());
            }

            Cell emailCell = row.getCell(6);
            if (emailCell != null && emailCell.getCellType() == CellType.STRING) {
                employee.setEmail(emailCell.getStringCellValue());
            }

            Cell maPhongBanCell = row.getCell(7);
            if (maPhongBanCell != null && maPhongBanCell.getCellType() == CellType.STRING) {
                employee.setMaPhongBan(maPhongBanCell.getStringCellValue());
            }

            Cell maBoPhanCell = row.getCell(8);
            if (maBoPhanCell != null && maBoPhanCell.getCellType() == CellType.STRING) {
                employee.setMaBoPhan(maBoPhanCell.getStringCellValue());
            }

            Cell maChucVuCell = row.getCell(9);
            if (maChucVuCell != null && maChucVuCell.getCellType() == CellType.STRING) {
                employee.setMaChucVu(maChucVuCell.getStringCellValue());
            }

            employees.add(employee);
            workbook.close();
        }
        return employees;
    }
}
