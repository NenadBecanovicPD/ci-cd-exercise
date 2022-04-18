package com.productdock.fortest.simple;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Slf4j
@Data
public class FiscalReceipt {

  private LocalDate printDate;

  private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyMMdd");
  private static final String RECEIPT_FILENAME_PATTERN = "^BON[0-9]{6}_[0-9]{12}.xml";
  private static final int DATE_DIGITS_COUNT = 6;
  private static final String DELIMITER = "_";

  public FiscalReceipt(LocalDate printDate) {
    this.printDate = printDate;
  }

  public static FiscalReceipt from(String fileName) {
    if (!fileName.matches(RECEIPT_FILENAME_PATTERN)) {
      throw new RuntimeException("Invalid format of receipt file name: " + fileName);
    }

    int dateStartIndex = fileName.indexOf(DELIMITER) + 1;
    int dateEndIndex = dateStartIndex + DATE_DIGITS_COUNT;
    String date = fileName.substring(dateStartIndex, dateEndIndex);

    try {
      LocalDate printDate = LocalDate.parse(date, dateFormatter);
      return new FiscalReceipt(printDate);
    } catch (Exception e) {
      throw new RuntimeException(
              "Invalid format of receipt file name: " + fileName +". Match failed on date part [" + date + "]");
    }
  }

}

