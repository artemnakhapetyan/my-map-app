
package acdc.my.map.app.entities.postgre;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Acdc
 */
@Entity
public class ObjectType {
    
    @Id
    private Long typeId;
    private String typeName;
    private Long groupId;

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    
    
    
}
