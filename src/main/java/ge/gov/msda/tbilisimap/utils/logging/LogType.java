
package ge.gov.msda.tbilisimap.utils.logging;

/**
 *
 * @author acdc
 */
public enum LogType {
    
    INFO(1), WARNING(2), ERROR(3);
    public final int value;
    
    private LogType(int value){
        this.value = value;
    }
    
}
