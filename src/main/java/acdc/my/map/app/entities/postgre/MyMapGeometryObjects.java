
package acdc.my.map.app.entities.postgre;

import com.vividsolutions.jts.geom.Geometry;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.Type;

/**
 *
 * @author acdc
 */
@Entity
public class MyMapGeometryObjects implements Serializable {
    
    @Id
    private long id;
    
    private int geometryObjType;
    
    @Type(type="org.hibernate.spatial.GeometryType")
    private Geometry geometry;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getGeometryObjType() {
        return geometryObjType;
    }

    public void setGeometryObjType(int geometryObjType) {
        this.geometryObjType = geometryObjType;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }
    
}
