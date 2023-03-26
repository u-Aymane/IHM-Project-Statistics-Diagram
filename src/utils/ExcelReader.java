package utils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {
    private String filePath;

    public ExcelReader(String filePath) {
        this.filePath = filePath;
    }

    public List<Double> readDataFromColumn(int sheetIndex) throws IOException {
        List<Double> dataPoints = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(new File(filePath))) {
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(sheetIndex);
            int numRows = sheet.getPhysicalNumberOfRows();

            for (int i = 1; i < numRows; i++) {
                Row row = sheet.getRow(i);
                Cell cell = row.getCell(1);

                if (cell != null) {
                    switch (cell.getCellType()) {
                        case NUMERIC:
                            dataPoints.add(cell.getNumericCellValue());
                            break;
                        case STRING:
                            try {
                                Double value = Double.parseDouble(cell.getStringCellValue());
                                dataPoints.add(value);
                            } catch (NumberFormatException e) {
                                System.err.println("Non-numeric cell value encountered at row " + i + ", column 1");
                            }
                            break;
                        default:
                            System.err.println("Non-numeric cell value encountered at row " + i + ", column 1");
                    }
                }
            }
        }

        return dataPoints;
    }
}
