package com.productdock.fortest.simple;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FiscalReceiptShould {

    @Test
    void throwException_whenPatternIsNotMatched() {
        assertThatThrownBy(() -> FiscalReceipt.from("BON12345_12345.xml"))
                .hasMessage("Invalid format of receipt file name: BON12345_12345.xml");
    }

    @Test
    void createFiscalReceipt(){
        //When
        FiscalReceipt receipt = FiscalReceipt.from("BON123456_220322123456.xml");
        //Then
        assertThat(receipt.getPrintDate()).isEqualTo("2022-03-22");
    }

    @Test
    void throwException_whenDateIsInvalid(){
        assertThatThrownBy(() -> FiscalReceipt.from("BON123456_123456789123.xml"))
                .hasMessage("Invalid format of receipt file name: BON123456_123456789123.xml. Match failed on date part [123456]");
    }

    @ParameterizedTest
    @MethodSource("parametersProvider")
    void createFiscalReceiptFromParameters(String input, String output){
        //When
        FiscalReceipt receipt = FiscalReceipt.from(input);
        //Then
        assertThat(receipt.getPrintDate()).isEqualTo(output);
    }

    static Stream<Arguments> parametersProvider(){
        return Stream.of(
                Arguments.of("BON123456_220322123456.xml","2022-03-22"),
                Arguments.of("BON123456_220101123456.xml","2022-01-01"));
    }

    @ParameterizedTest
    @CsvSource({"BON123456_220322123456.xml,2022-03-22",
                "BON123456_220101123456.xml,2022-01-01"})
    void createFiscalReceiptFromCsv(String input, String output){
        //When
        FiscalReceipt receipt = FiscalReceipt.from(input);
        //Then
        assertThat(receipt.getPrintDate()).isEqualTo(output);
    }

}