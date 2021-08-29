package ru.model.io;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.model.classes.FullInfo;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;


public class XmlWriter {

    private static final Logger logger = LogManager.getLogger(XmlWriter.class);

    private XmlWriter() {
    }

    public static void generateXmlReq(FullInfo fullInfo) {
        logger.info("Marshalling started");

        try {
            //создание объекта Marshaller, который выполняет сериализацию
            JAXBContext context = JAXBContext.newInstance(FullInfo.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // создаем директорию для хранения файла xml
            try {
                Files.createDirectory(Paths.get("xmlReqs"));
                logger.info("Directory was created");
            } catch (IOException e) {
                logger.warn("Directory already created");
            }

            File requestFile = new File("xmlReqs/infoReq" + new Date().getTime() + ".xml");
            marshaller.marshal(fullInfo, requestFile);


        } catch (JAXBException e) {
            e.printStackTrace();
            logger.error("Marshalling xml failed");
        }

        logger.info("Marshalling finished");

    }
}
