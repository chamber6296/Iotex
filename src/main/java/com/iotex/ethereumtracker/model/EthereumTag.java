package com.iotex.ethereumtracker.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class EthereumTag {
    @JsonProperty("name")
    private String name;
    @JsonProperty("zipball_url")
    private String zipballUrl;
    @JsonProperty("tarball_url")
    private String tarballUrl;
    @JsonProperty("commit")
    private CommitDTO commit;
    @JsonProperty("node_id")
    private String nodeId;

    @NoArgsConstructor
    @Data
    public static class CommitDTO {
        @JsonProperty("sha")
        private String sha;
        @JsonProperty("url")
        private String url;
    }
}
