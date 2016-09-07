package acdc.my.map.app.utils.spatial;

import java.io.IOException;
 
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
 
public class GeometryWktDeserializer extends JsonDeserializer<Geometry> {
 
    @Override
    public Geometry deserialize(JsonParser jsonParser, DeserializationContext arg1) throws IOException,
            JsonProcessingException {
        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);
        Geometry result;
        try {
            result = geometry(node);
        } catch (ParseException ex) {
            String err = ex.getMessage()==null?"error reading wkt geometry": ex.getMessage();
            throw new RuntimeException(err);
        }
        return result;
    }
 
    Geometry geometry(JsonNode node) throws ParseException {
        return GeometryUtil.fromWkt(node.toString());
    }
 
}