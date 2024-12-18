package com.fpt.vanguard.service;

public interface PDFService {
    byte[] generateEmployeeCardPdf(String employeeCode, String employeeName, String employeeRole) throws Exception;
}
