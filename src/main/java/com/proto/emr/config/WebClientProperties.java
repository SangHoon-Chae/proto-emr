package com.proto.emr.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "emr.clients")
public class WebClientProperties {

    private TokenServer tokenServer = new TokenServer();

    static class TokenServer {

        private String baseUri;

        public String getBaseUri() {
            return baseUri;
        }

        public void setBaseUri(String baseUri) {
            this.baseUri = baseUri;
        }

    }

}
