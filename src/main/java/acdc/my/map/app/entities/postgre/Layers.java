
package acdc.my.map.app.entities.postgre;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author acdc
 */
@Entity
public class Layers  implements Serializable{
    
    @Id
    private long lrId;
    
    @ManyToOne
    private MyMaps myMap;
    
    private long treeNodeId;
    
    private String name;

    private int type;

    private String params;

    private String options;
    
    private String sourceUrls;
    
    private boolean isSelected;
    
    private boolean isBaseLr;
    
    private String tableName;
    
    private boolean isActive;
    
    private String base64Icon;
    
    private String cqlFilter;
    
    private String filter;
    
    private String sld;
    
    private int mapLrOrder;
    
    private int lrOrder;

    public boolean isIsBaseLr() {
        return isBaseLr;
    }

    public void setIsBaseLr(boolean isBaseLr) {
        this.isBaseLr = isBaseLr;
    }

    public MyMaps getMyMap() {
        return myMap;
    }

    public void setMyMap(MyMaps myMap) {
        this.myMap = myMap;
    }

    public long getLrId() {
        return lrId;
    }

    public void setLrId(long lrId) {
        this.lrId = lrId;
    }

    public long getTreeNodeId() {
        return treeNodeId;
    }

    public void setTreeNodeId(long treeNodeId) {
        this.treeNodeId = treeNodeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public String getSourceUrls() {
        return sourceUrls;
    }

    public void setSourceUrls(String sourceUrls) {
        this.sourceUrls = sourceUrls;
    }

    public boolean isIsSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getBase64Icon() {
        return base64Icon;
    }

    public void setBase64Icon(String base64Icon) {
        this.base64Icon = base64Icon;
    }

    public String getCqlFilter() {
        return cqlFilter;
    }

    public void setCqlFilter(String cqlFilter) {
        this.cqlFilter = cqlFilter;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getSld() {
        return sld;
    }

    public void setSld(String sld) {
        this.sld = sld;
    }

    public int getMapLrOrder() {
        return mapLrOrder;
    }

    public void setMapLrOrder(int mapLrOrder) {
        this.mapLrOrder = mapLrOrder;
    }

    public int getLrOrder() {
        return lrOrder;
    }

    public void setLrOrder(int lrOrder) {
        this.lrOrder = lrOrder;
    }
    
    
    
}
