/*
 * Copyright 2021 Damon Yu
 */

import java.io.Serializable;

/**
 * @author damonyu
 * @version 1.0
 * @since 24/10/2021
 */
public class HttpRequest implements Serializable {
    private String method;
    private String resource;
    private String protocolVersion;

    public HttpRequest(String method, String resource, String protocolVersion) {
        this.method = method;
        this.resource = resource;
        this.protocolVersion = protocolVersion;
    }


    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getProtocolVersion() {
        return protocolVersion;
    }

    public void setProtocolVersion(String protocolVersion) {
        this.protocolVersion = protocolVersion;
    }
}
