/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acdc.my.map.app.entities.postgre;

import acdc.my.map.app.utils.spatial.GeometryDeserializer;
import acdc.my.map.app.utils.spatial.GeometrySerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vividsolutions.jts.geom.Geometry;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.Type;

/**
 *
 * @author acdc
 */
@Entity
public class QmAdmRaionipolygon implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long gid;

    private String saxeli;

    @Type(type = "org.hibernate.spatial.GeometryType")
    @JsonSerialize(using = GeometrySerializer.class)
    @JsonDeserialize(using = GeometryDeserializer.class)
    private Geometry geom;

    private Integer crimesCount;
    
    private Integer infrastructureIndex;
    
    private Integer combinedAnalysisIndex;

    public Integer getCombinedAnalysisIndex() {
        return combinedAnalysisIndex;
    }

    public void setCombinedAnalysisIndex(Integer combinedAnalysisIndex) {
        this.combinedAnalysisIndex = combinedAnalysisIndex;
    }

    public Integer getInfrastructureIndex() {
        return infrastructureIndex;
    }

    public void setInfrastructureIndex(Integer infrastructureIndex) {
        this.infrastructureIndex = infrastructureIndex;
    }

    public QmAdmRaionipolygon() {
    }

    public QmAdmRaionipolygon(Long gid) {
        this.gid = gid;
    }

    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }

    public String getSaxeli() {
        return saxeli;
    }

    public void setSaxeli(String saxeli) {
        this.saxeli = saxeli;
    }

    public Object getGeom() {
        return geom;
    }

    public void setGeom(Geometry geom) {
        this.geom = geom;
    }

    public Integer getCrimesCount() {
        return crimesCount;
    }

    public void setCrimesCount(Integer crimesCount) {
        this.crimesCount = crimesCount;
    }

}
