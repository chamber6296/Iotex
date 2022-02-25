package com.iotex.ethereumtracker.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class EthereumBranch {
    @JsonProperty("protected")
    private Boolean protectedX;
    @JsonProperty("name")
    private String name;
    @JsonProperty("commit")
    private CommitDTO commit;

    @NoArgsConstructor
    @Data
    public static class CommitDTO {
        @JsonProperty("sha")
        private String sha;
        @JsonProperty("url")
        private String url;
    }

}
