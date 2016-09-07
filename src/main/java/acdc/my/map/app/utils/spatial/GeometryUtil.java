package acdc.my.map.app.utils.spatial;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import com.vividsolutions.jts.io.WKTWriter;

/**
 *
 * @author acdc
 */
public class GeometryUtil {

    public static class SRID {

        public static String EPSG900913 = "EPSG:900913";
        public static String EPSG32638 = "EPSG:32638";
        public static String EPSG4326 = "EPSG:4326";

        public static int EPSG900913INT = 900913;
        public static int EPSG32638INT = 32638;
        public static int EPSG4326INT = 4326;

    }

    public static String toWkt(Geometry geom){

        WKTWriter wkt = new WKTWriter();
        return wkt.write(geom);

    }

    public static Geometry fromWkt(String geomWkt) throws ParseException {

        WKTReader wkt = new WKTReader();
        return wkt.read(geomWkt);

    }

}
