package jwt.opa.poc.prodreg;

import jwt.opa.poc.dto.SaleDTOAvro;
import org.apache.avro.Schema;
import org.apache.avro.compiler.specific.SpecificCompiler;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumWriter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
public class AvroClassGeneratorController {

    @PostMapping("/avro/class")
    public ResponseEntity<String> generateClass(@RequestBody String schemaStr,
                                                @RequestParam String outputPath) throws IOException {
        Schema schema = new Schema.Parser().parse(schemaStr);
        String className = schema.getName();
        SpecificCompiler compiler = new SpecificCompiler(schema);
        compiler.setOutputCharacterEncoding("UTF-8");
        compiler.setStringType(GenericData.StringType.String);

        DatumWriter<GenericRecord> datumWriter = new GenericDatumWriter<>(schema);
        String filePath;
        try (
                DataFileWriter<GenericRecord> dataFileWriter = new DataFileWriter<>(datumWriter)
        ) {
            File avroFile = new File(outputPath + "column.avro");

            Path tempDir = Files.createTempDirectory("prefix");
            Path tempFile = tempDir.resolve("column.avro").toFile().toPath();
            dataFileWriter.create(schema, avroFile);
            filePath = outputPath + File.separator + className + ".java";
            compiler.compileToDestination(avroFile, new File(filePath));
            Files.deleteIfExists(tempFile);

            SaleDTOAvro saleDTOAvro=new SaleDTOAvro("abc","cds","jddskjsk");

        }
        return new ResponseEntity<>("Class generated and saved to " + filePath, HttpStatus.OK);


    }
}