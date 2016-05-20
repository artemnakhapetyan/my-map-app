
package ge.gov.msda.tbilisimap.utils.logging;

import java.util.Date;
import java.util.UUID;
import org.springframework.data.annotation.Id;

/**
 *
 * @author acdc
 */
public class AppLog {
    
    @Id
    private String appLogId;
    private String projectName;
    private String className;
    private String methodName;
    private String logData;
    private LogType logType;
    private Date logDate;
    
    public AppLog(){
        this.logDate = new Date();
        this.appLogId = UUID.randomUUID().toString();
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }
    
    public String getAppLogId() {
        return appLogId;
    }

    public void setAppLogId(String appLogId) {
        this.appLogId = appLogId;
    }
    
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getLogData() {
        return logData;
    }

    public void setLogData(String logData) {
        this.logData = logData;
    }

    public LogType getLogType() {
        return logType;
    }

    public void setLogType(LogType logType) {
        this.logType = logType;
    }
    
}
