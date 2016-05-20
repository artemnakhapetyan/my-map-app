package acdc.my.map.app.databeans;

import java.sql.Connection;
import java.util.HashMap;

/**
 *
 * @author acdc
 */
public class ApiRequest {

    public static final String apiPrefix = "{"
            + "\"sessionId\": \"12345abcd\", "
            + "\"clientToken\": \"90e9e9e3-7a29-425f-8840-9663e0ed1b8a\", "
            + "\"params\":{";
    public static final String apiSuffix = "}}";
    
    private String sessionId;
    private String clientToken;
    private Long clientId;
    private HashMap params;
    private Connection conn;
    private HashMap auctionSessionUser;

    public HashMap getAuctionSessionUser() {
        return auctionSessionUser;
    }

    public void setAuctionSessionUser(HashMap auctionSessionUser) {
        this.auctionSessionUser = auctionSessionUser;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
    
    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public String getClientToken() {
        return clientToken;
    }

    public void setClientToken(String clientToken) {
        this.clientToken = clientToken;
    }
    
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public HashMap getParams() {
        return params;
    }

    public void setParams(HashMap params) {
        this.params = params;
    }

}
