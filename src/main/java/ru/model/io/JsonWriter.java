package ru.model.io;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.model.classes.FullInfo;
import ru.model.util.JsonUtil;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonWriter {

    private static final Logger logger = LogManager.getLogger(JsonWriter.class);


    private JsonWriter() {
    }

    public static void writeJsonReq(FullInfo fullInfo) {
        logger.info("Json writing started");

        try {
            Files.createDirectory(Paths.get("jsonReqs"));
            logger.info("Directory was created");
        } catch (IOException e) {
            logger.warn("Directory already created ", e);
        }

        writeStudents(fullInfo);
        writeUniversities(fullInfo);
        writeStatistic(fullInfo);

        logger.info("Json writing finished");
    }

    private static void writeStatistic(FullInfo fullInfo) {
        String statisticJson = JsonUtil.serializeListToJson(fullInfo.getStatisticsList());

        try {
            FileOutputStream fos = new FileOutputStream("jsonReqs/statistics"
                    + fullInfo.getProcessDate().getTime() + ".json");
            fos.write(statisticJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.error("Statistic Json writing failed", e);
        }
    }

    private static void writeUniversities(FullInfo fullInfo) {
        String universitiesJson = JsonUtil.serializeListToJson(fullInfo.getUniversityList());

        try {
            FileOutputStream fos = new FileOutputStream("jsonReqs/universities"
                    + fullInfo.getProcessDate().getTime() + ".json");
            fos.write(universitiesJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.error("Universities Json writing failed", e);
        }
    }

    private static void writeStudents(FullInfo fullInfo) {
        String studentsJson = JsonUtil.serializeListToJson(fullInfo.getStudentList());

        try {
            FileOutputStream fos = new FileOutputStream("jsonReqs/students" + fullInfo.getProcessDate().getTime() +
                    ".json");
            fos.write(studentsJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.error("Student Json writing failed", e);
        }
    }
}
