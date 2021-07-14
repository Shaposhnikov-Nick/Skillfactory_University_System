package ru.model.io;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ru.model.Classes.Student;
import ru.model.Classes.University;
import ru.model.builder.StudentBuilder;
import ru.model.builder.UniversityBuilder;
import ru.model.enums.StudyProfile;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XlsxReader {
    static StudentBuilder studentBuilder;
    static UniversityBuilder universityBuilder;

    // путь к EXCEL - файлу с данными
    private static final File file = new File("D:\\Java\\IdeaProjects\\UniversitySystem\\src\\main" +
            "\\resources\\universityinfo.xlsx");

    // приватный конструктор
    private XlsxReader() {
    }

    // метод для чтения студентов
    public static List<Student> readXlsStudents() throws IOException {
        // создаем лист для хранения студентов
        List<Student> students = new ArrayList<>();

        // Получаем содержимое файла как FileInputStream.
        FileInputStream reader = new FileInputStream(file);

        //Создаём экземпляр класса XSSFWorkbook, передав его конструктору на вход стрим файла
        XSSFWorkbook workbook = new XSSFWorkbook(reader);

        // получаем лист из файла
        XSSFSheet sheet = workbook.getSheet("Студенты");

        //Создаём итератор, который перебирает строки листа
        Iterator<Row> iterator = sheet.iterator();

        // пропускаем заголовок листа
        iterator.next();

        // итерируемся по строкам из файла "universityinfo.xlsx" по листу "Студенты"
        while (iterator.hasNext()) {

            // итератор возвращает каждую строку
            Row currentRow = iterator.next();

            // создаем объект класса Student
            StudentBuilder studentBuilder = new StudentBuilder();

            // заполняем поля класса полученными из ячеек строки данными. Взятие ячейки из строки происходит с
            // помощью метода row.getCell() по индексу ячейки. Для получения значения из ячейки используем методы,
            // позволяющие прочитать значения различных типов. Например, getNumericCellValue(), getStringCellValue().
            studentBuilder.setUniversityId(currentRow.getCell(0).getStringCellValue());
            studentBuilder.setFullName(currentRow.getCell(1).getStringCellValue());
            studentBuilder.setCurrentCourseNumber((int) currentRow.getCell(2).getNumericCellValue());
            studentBuilder.setAvgExamScore((float) currentRow.getCell(3).getNumericCellValue());
            Student student = studentBuilder.createStudent();

            //добавляем объект в лист
            students.add(student);
        }
        return students;
    }

    // метод для чтения университетов
    public static List<University> readXlsUniversities() throws IOException {
        // создаем лист для хранения университетов
        List<University> universities = new ArrayList<>();

        // Получаем содержимое файла как FileInputStream.
        FileInputStream reader = new FileInputStream(file);

        //Создаём экземпляр класса XSSFWorkbook, передав его конструктору на вход стрим файла
        XSSFWorkbook workbook = new XSSFWorkbook(reader);

        // получаем лист из файла
        XSSFSheet sheet = workbook.getSheet("Университеты");

        //Создаём итератор, который перебирает строки листа
        Iterator<Row> iterator = sheet.iterator();

        // пропускаем заголовок листа
        iterator.next();

        // итерируемся по строкам из файла "universityinfo.xlsx" по листу "Университеты"
        while (iterator.hasNext()) {

            // итератор возвращает каждую строку
            Row currentRow = iterator.next();

            // создаем объект класса University
            UniversityBuilder universityBuilder = new UniversityBuilder();

            // заполняем поля класса полученными из ячеек строки данными. Взятие ячейки из строки происходит с
            // помощью метода row.getCell() по индексу ячейки. Для получения значения из ячейки используем методы,
            // позволяющие прочитать значения различных типов. Например, getNumericCellValue(), getStringCellValue().
            universityBuilder.setId(currentRow.getCell(0).getStringCellValue());
            universityBuilder.setFullName(currentRow.getCell(1).getStringCellValue());
            universityBuilder.setShortName( currentRow.getCell(2).getStringCellValue());
            universityBuilder.setYearOfFoundation((int) currentRow.getCell(3).getNumericCellValue());
            universityBuilder.setMainProfile(StudyProfile.valueOf(
                    StudyProfile.class, currentRow.getCell(4).getStringCellValue()));
            University university = universityBuilder.createUniversity();

            //добавляем объект в лист
            universities.add(university);
        }
        return universities;
    }
}
