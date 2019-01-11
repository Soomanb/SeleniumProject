package com.training.utility;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class TestUtil {

public static ExcelReader excel = new ExcelReader("C:\\Users\\IBM_ADMIN\\Desktop\\Selenium\\SeleniumProject\\TestData.xlsx");

@DataProvider(name="dp")
public Object[][] getData(Method m) {

String sheetName = m.getName();
int rows = excel.getRowCount(sheetName);
int cols = excel.getColumnCount(sheetName);

Object[][] data = new Object[rows-1][cols];

for (int rowNum = 2; rowNum <= rows; rowNum++) {
for (int colNum = 0; colNum < cols; colNum++) {

// data[0][0]
data[rowNum-2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
}
}
return data;

} 
}

