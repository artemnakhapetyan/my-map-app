package acdc.my.map.app.utils.spatial;
 
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.WKTWriter;
import java.io.IOException;
 
public class GeometryWktSerializer extends JsonSerializer<Geometry> {
 
    @Override
    public void serialize(Geometry value, JsonGenerator generator, SerializerProvider provider) throws IOException,
            JsonProcessingException {
        writeGeometry(value, generator);
    }
 
    void writeGeometry(Geometry geom, JsonGenerator gen) throws JsonGenerationException, IOException {
        WKTWriter wktWriter = new WKTWriter();
        String geomWkt = wktWriter.write(geom);
        gen.writeString(geomWkt);
    }
 
}