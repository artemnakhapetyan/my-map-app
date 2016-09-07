
package acdc.my.map.app.entities.postgre;

import acdc.my.map.app.utils.spatial.GeometryDeserializer;
import acdc.my.map.app.utils.spatial.GeometrySerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vividsolutions.jts.geom.Geometry;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.Type;

/**
 *
 * @author acdc
 */
@Entity
public class LrCrimes implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    
    private int crimeType;
    
    private String crimeDescription;
    
    @Type(type="org.hibernate.spatial.GeometryType")
    @JsonSerialize(using = GeometrySerializer.class)
    @JsonDeserialize(using = GeometryDeserializer.class)
    private Geometry geometry;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCrimeType() {
        return crimeType;
    }

    public void setCrimeType(int crimeType) {
        this.crimeType = crimeType;
    }

    public String getCrimeDescription() {
        return crimeDescription;
    }

    public void setCrimeDescription(String crimeDescription) {
        this.crimeDescription = crimeDescription;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }
    
    
    
}
