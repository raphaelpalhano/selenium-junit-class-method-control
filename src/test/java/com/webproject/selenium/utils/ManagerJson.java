package com.webproject.selenium.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.webproject.selenium.constants.Environment;
import com.webproject.selenium.core.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class ManagerJson {

    private static final Logger logger = LogManager.getLogger(ManagerJson.class);

    public static JsonNode readJson(String filename) {
        ObjectMapper objectMapper;
        JsonNode jsonNode;

        try {
            objectMapper = new ObjectMapper();
            File file = FileManager.getRecursiveFiles(Environment.STATIC_DATA, filename);
            jsonNode = objectMapper.readTree(new File(String.format("%s", file)));
            logger.info(String.format("O arquivo %s foi lido com sucesso", filename));
            return jsonNode;

        } catch (Exception e) {
            logger.info(String.format("Erro ao ler o arquivo %s\n %s", filename, e));
            e.printStackTrace();

        }
        return null;


    }

}
