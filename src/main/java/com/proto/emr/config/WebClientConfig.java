package com.proto.emr.config;

public class WebClientConfig {

    private final WebClientProperties properties;

    public WebClientConfig(WebClientProperties properties) {
        this.properties = properties;
        log.info("base-uri : {}", properties.getTokenServer().getBaseUri());
    }

    /*

    WebClient tokenServerClient() {
        return Webclient.builder().baseUri(properties.getTokenServer().getBaseUri()).build();
    }

     */

}
