package ru.model.io;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.*;
import ru.model.statistics.Statistics;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class XlsxWriter {
    // путь к EXCEL-файлу с данными
    private static final File dataFile = new File("D:\\Java\\IdeaProjects\\UniversitySystem\\src\\main" +
            "\\resources\\statistics.xlsx");

    private XlsxWriter() {
    }

    // создаем шрифт ячеек заголовка
    private static Font createTitleFont(Workbook workbook) {
        XSSFFont font = (XSSFFont) workbook.createFont();
        font.setBold(true);
        font.setFontName("Arial");
        font.setFontHeightInPoints((short) 12);
        return font;
    }

    // создаем шрифт ячеек статистики
    private static Font createFont(Workbook workbook) {
        XSSFFont font = (XSSFFont) workbook.createFont();
        font.setFontName("Arial");
        font.setFontHeightInPoints((short) 11);
        return font;
    }

    // создаем стиль ячеек заголовка
    private static XSSFCellStyle createTitleCellStyle(Workbook workbook, Font font) {
        XSSFCellStyle titleCellStyle = (XSSFCellStyle) workbook.createCellStyle();
        titleCellStyle.setBorderBottom(BorderStyle.MEDIUM);
        titleCellStyle.setBorderLeft(BorderStyle.MEDIUM);
        titleCellStyle.setBorderRight(BorderStyle.MEDIUM);
        titleCellStyle.setBorderTop(BorderStyle.MEDIUM);
        titleCellStyle.setFont(font);
        return titleCellStyle;
    }

    // создаем стиль ячеек  статистики
    private static XSSFCellStyle createCellStyle(Workbook workbook, Font font) {
        XSSFCellStyle titleCellStyle = (XSSFCellStyle) workbook.createCellStyle();
        titleCellStyle.setBorderBottom(BorderStyle.THIN);
        titleCellStyle.setBorderLeft(BorderStyle.THIN);
        titleCellStyle.setBorderRight(BorderStyle.THIN);
        titleCellStyle.setBorderTop(BorderStyle.THIN);
        titleCellStyle.setFont(font);
        return titleCellStyle;
    }

    // создаем ячейки заголовка
    private static Cell createTitleCell(Row titleRow, XSSFCellStyle titleCellStyle, String cellName, int cellNum) {
        Cell titleCell = titleRow.createCell(cellNum);
        titleCell.setCellValue(cellName); //устанавливаем содержимое ячейки
        titleCell.setCellStyle(titleCellStyle); //устанавливаем стиль ячейки
        return titleCell;
    }


    // создаем файл со статистикой
    public static void createStatisticSheet(List<Statistics> statistics) {
        //Создаём экземпляр класса XSSFWorkbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        // создаем в файле страницу для составления статистики
        XSSFSheet statisticSheet = workbook.createSheet("Статистика");

        // создаем шрифт ячеек заголовка
        Font titleFont = createTitleFont(workbook);

        // создаем стиль ячеек заголовка
        XSSFCellStyle titleCellStyle = createTitleCellStyle(workbook, titleFont);

        // создаем строку - заголовок
        Row titleRow = statisticSheet.createRow(0);

        /* создаем ячейки в строке-заголовке */
        Cell titleStudyProfile = createTitleCell(titleRow, titleCellStyle, "Профиль обучения", 0);
        Cell titleNumStudentsByProfile = createTitleCell(titleRow, titleCellStyle, "Количество студентов " +
                "по профилю", 1);
        Cell titleNumUniversitiesByProfile = createTitleCell(titleRow, titleCellStyle, "Количество " +
                "университетов по профилю", 2);
        Cell titleAvgExamScore = createTitleCell(titleRow, titleCellStyle, "Средний балл за экзамен", 3);
        Cell titleUniversityName = createTitleCell(titleRow, titleCellStyle, "Названия университетов", 4);

        /* создаем и заполняем строки данными статистики */
        for (int i = 0; i < statistics.size(); i++) {

            // получаем из коллекции экземпляр статистики
            Statistics statistic = statistics.get(i);

            // создаем строку
            Row currentRow = statisticSheet.createRow(i + 1);

            // создаем шрифт ячеек статистики
            Font cellFont = createFont(workbook);

            // создаем стиль ячеек статистики
            XSSFCellStyle cellStyle = createCellStyle(workbook, cellFont);

            // создаем и заполняем ячейки данными статистики
            Cell studyProfile = currentRow.createCell(0);
            studyProfile.setCellValue(statistic.getStudyProfile().getProfileName());
            studyProfile.setCellStyle(cellStyle);

            Cell numStudentsByProfile = currentRow.createCell(1);
            numStudentsByProfile.setCellValue(statistic.getNumStudentsByProfile());
            numStudentsByProfile.setCellStyle(cellStyle);


            Cell numUniversitiesByProfile = currentRow.createCell(2);
            numUniversitiesByProfile.setCellValue(statistic.getNumUniversitiesByProfile());
            numUniversitiesByProfile.setCellStyle(cellStyle);


            Cell avgExamScore = currentRow.createCell(3);
            avgExamScore.setCellValue(statistic.getAvgExamScore());
            avgExamScore.setCellStyle(cellStyle);


            Cell universityName = currentRow.createCell(4);
            universityName.setCellValue(statistic.getUniversityName());
            universityName.setCellStyle(cellStyle);

        }

        // выравниваем столбцы по ширине содержимого
        statisticSheet.autoSizeColumn(0);
        statisticSheet.autoSizeColumn(1);
        statisticSheet.autoSizeColumn(2);
        statisticSheet.autoSizeColumn(3);
        statisticSheet.autoSizeColumn(4);

        // запись в файл
        try (FileOutputStream fos = new FileOutputStream(dataFile)) {
            workbook.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
