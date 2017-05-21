package pl.stormit.json.schema;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.google.gson.JsonObject;
import java.io.IOException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class JsonSchemaValidatorTest {

    private static JsonSchema schema;

    @BeforeClass
    public static void setUpClass() throws IOException, ProcessingException {
        JsonNode jsonSchema = JsonLoader.fromResource("/pl/stormit/json/schema/test.schema.json");
        final JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
        schema = factory.getJsonSchema(jsonSchema);
    }

    @Test
    public void testValidateCorrectJsonMessage() throws IOException, ProcessingException {
        final JsonNode messageNode = JsonLoader.fromString(getCorrectJsonMessage());
        ProcessingReport report = schema.validate(messageNode);
        Assert.assertTrue(report.isSuccess());
    }

    @Test
    public void testValidateIncorrectJsonMessage() throws IOException, ProcessingException {
        final JsonNode messageNode = JsonLoader.fromString(getIncorrectJsonMessage());
        ProcessingReport report = schema.validate(messageNode);
        Assert.assertFalse(report.isSuccess());
        
        System.out.println(report);
    }

    private String getCorrectJsonMessage() {
        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("name", "XyZ");
        jsonObject.addProperty("id", 123);

        return jsonObject.toString();
    }

    private String getIncorrectJsonMessage() {
        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("x", "y");

        return jsonObject.toString();
    }
}
