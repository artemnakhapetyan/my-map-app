
package acdc.my.map.app.entities.postgre;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author acdc
 */
@Entity
public class MyMaps implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    
    private String name;

    private String description;

    private String mapUrlName;

    private Float mapCenterX;
    
    private Float mapCenterY;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMapUrlName() {
        return mapUrlName;
    }

    public void setMapUrlName(String mapUrlName) {
        this.mapUrlName = mapUrlName;
    }

    public Float getMapCenterX() {
        return mapCenterX;
    }

    public void setMapCenterX(Float mapCenterX) {
        this.mapCenterX = mapCenterX;
    }

    public Float getMapCenterY() {
        return mapCenterY;
    }

    public void setMapCenterY(Float mapCenterY) {
        this.mapCenterY = mapCenterY;
    }

    
    
}

