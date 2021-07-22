package ru.model.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ru.model.classes.Student;
import ru.model.classes.University;

import java.util.List;


public class JsonUtil {

    private JsonUtil() {
    }

    /*
     методы сериализации
     */

    public static String SerializeStudentToJson(Student student) {
        //создаем объект Json в форматированном виде (PrettyPrinting)
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // возвращаем сериализованный в строку объект класса Student
        return gson.toJson(student);
    }

    public static String SerializeUniversityToJson(University university) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(university);
    }

    public static String SerializedCollectionStudents(List<Student> students) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        // возвращаем сериализованную в строки коллекцию объектов класса Student
        return gson.toJson(students);
    }

    public static String SerializedCollectionUniversity(List<University> university) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(university);

    }

   /*
     методы десериализации
     */

    public static Student DeserializeStudentFromJson(String json) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        // возвращаем десериализованную строку в формате Json в объект класса Student
        return gson.fromJson(json, Student.class);
    }

    public static University DeserializeUniversityFromJson(String json) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        // возвращаем десериализованную строку в формате Json в объект класса University
        return gson.fromJson(json,University.class);
    }

    public static List DeserializeCollectionStudents(String json) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        // возвращаем сериализованную в строки коллекцию объектов класса Student
        return gson.fromJson(json, new TypeToken<List<Student>>() {}.getType());
    }

    public static List<University> DeserializeCollectionUniversity(String json) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.fromJson(json, new TypeToken<List<University>>() {}.getType());

    }
}
