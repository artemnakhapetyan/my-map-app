
package acdc.my.map.app.entities.postgre;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Acdc
 */
@Entity
public class ObjectGroup {
    
    @Id
    private Long groupId;
    private String groupName;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

}
