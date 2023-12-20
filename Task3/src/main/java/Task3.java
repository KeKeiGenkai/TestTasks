import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите путь к файлу tests.json: ");
        String testsJsonPath = scanner.nextLine();

        System.out.print("Введите путь к файлу values.json: ");
        String valuesJsonPath = scanner.nextLine();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enableDefaultTyping();

            JsonNode testsNode = objectMapper.readTree(new File(testsJsonPath));
            JsonNode valuesNode = objectMapper.readTree(new File(valuesJsonPath));

            generateReport((ArrayNode) testsNode.get("tests"), valuesNode);

            String documentsPath = System.getProperty("user.home") + File.separator + "Documents";
            File reportFile = new File(documentsPath, "report.json");

            objectMapper.writerWithDefaultPrettyPrinter().writeValue(reportFile, testsNode);

            System.out.println("Report generated successfully and saved in Documents.");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static void generateReport(ArrayNode testsNode, JsonNode valuesNode) {
        for (JsonNode test : testsNode) {
            JsonNode testIdNode = test.get("id");
            if (testIdNode != null && testIdNode.isInt()) {
                int testId = testIdNode.asInt();
                JsonNode valueNode = findValueNode(valuesNode, testId);

                if (valueNode != null) {
                    String value = valueNode.get("value").asText();
                    ((ObjectNode) test).put("value", value);
                }

                JsonNode nestedTestsNode = test.get("values");
                if (nestedTestsNode != null && nestedTestsNode.isArray()) {
                    generateReport((ArrayNode) nestedTestsNode, valuesNode);
                }
            }
        }
    }

    private static JsonNode findValueNode(JsonNode valuesNode, int testId) {
        for (JsonNode valueNode : valuesNode.get("values")) {
            JsonNode idNode = valueNode.get("id");
            if (idNode != null && idNode.isInt() && idNode.asInt() == testId) {
                return valueNode;
            }
        }
        return null;
    }
}