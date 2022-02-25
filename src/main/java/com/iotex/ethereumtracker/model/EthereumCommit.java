package com.iotex.ethereumtracker.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class EthereumCommit {

    @JsonProperty("sha")
    private String sha;
    @JsonProperty("node_id")
    private String nodeId;
    @JsonProperty("commit")
    private CommitDTO commit;
    @JsonProperty("url")
    private String url;
    @JsonProperty("html_url")
    private String htmlUrl;
    @JsonProperty("comments_url")
    private String commentsUrl;
    @JsonProperty("author")
    private AuthorDTO author;
    @JsonProperty("committer")
    private CommitterDTO committer;
    @JsonProperty("parents")
    private List<ParentsDTO> parents;

    @NoArgsConstructor
    @Data
    public static class CommitDTO {
        @JsonProperty("author")
        private AuthorDTO author;
        @JsonProperty("committer")
        private CommitterDTO committer;
        @JsonProperty("message")
        private String message;
        @JsonProperty("tree")
        private TreeDTO tree;
        @JsonProperty("url")
        private String url;
        @JsonProperty("comment_count")
        private Integer commentCount;
        @JsonProperty("verification")
        private VerificationDTO verification;

        @NoArgsConstructor
        @Data
        public static class AuthorDTO {
            @JsonProperty("name")
            private String name;
            @JsonProperty("email")
            private String email;
            @JsonProperty("date")
            private String date;
        }

        @NoArgsConstructor
        @Data
        public static class CommitterDTO {
            @JsonProperty("name")
            private String name;
            @JsonProperty("email")
            private String email;
            @JsonProperty("date")
            private String date;
        }

        @NoArgsConstructor
        @Data
        public static class TreeDTO {
            @JsonProperty("sha")
            private String sha;
            @JsonProperty("url")
            private String url;
        }

        @NoArgsConstructor
        @Data
        public static class VerificationDTO {
            @JsonProperty("verified")
            private Boolean verified;
            @JsonProperty("reason")
            private String reason;
            @JsonProperty("signature")
            private String signature;
            @JsonProperty("payload")
            private String payload;
        }
    }

    @NoArgsConstructor
    @Data
    public static class AuthorDTO {
        @JsonProperty("login")
        private String login;
        @JsonProperty("id")
        private Integer id;
        @JsonProperty("node_id")
        private String nodeId;
        @JsonProperty("avatar_url")
        private String avatarUrl;
        @JsonProperty("gravatar_id")
        private String gravatarId;
        @JsonProperty("url")
        private String url;
        @JsonProperty("html_url")
        private String htmlUrl;
        @JsonProperty("followers_url")
        private String followersUrl;
        @JsonProperty("following_url")
        private String followingUrl;
        @JsonProperty("gists_url")
        private String gistsUrl;
        @JsonProperty("starred_url")
        private String starredUrl;
        @JsonProperty("subscriptions_url")
        private String subscriptionsUrl;
        @JsonProperty("organizations_url")
        private String organizationsUrl;
        @JsonProperty("repos_url")
        private String reposUrl;
        @JsonProperty("events_url")
        private String eventsUrl;
        @JsonProperty("received_events_url")
        private String receivedEventsUrl;
        @JsonProperty("type")
        private String type;
        @JsonProperty("site_admin")
        private Boolean siteAdmin;
    }

    @NoArgsConstructor
    @Data
    public static class CommitterDTO {
        @JsonProperty("login")
        private String login;
        @JsonProperty("id")
        private Integer id;
        @JsonProperty("node_id")
        private String nodeId;
        @JsonProperty("avatar_url")
        private String avatarUrl;
        @JsonProperty("gravatar_id")
        private String gravatarId;
        @JsonProperty("url")
        private String url;
        @JsonProperty("html_url")
        private String htmlUrl;
        @JsonProperty("followers_url")
        private String followersUrl;
        @JsonProperty("following_url")
        private String followingUrl;
        @JsonProperty("gists_url")
        private String gistsUrl;
        @JsonProperty("starred_url")
        private String starredUrl;
        @JsonProperty("subscriptions_url")
        private String subscriptionsUrl;
        @JsonProperty("organizations_url")
        private String organizationsUrl;
        @JsonProperty("repos_url")
        private String reposUrl;
        @JsonProperty("events_url")
        private String eventsUrl;
        @JsonProperty("received_events_url")
        private String receivedEventsUrl;
        @JsonProperty("type")
        private String type;
        @JsonProperty("site_admin")
        private Boolean siteAdmin;
    }

    @NoArgsConstructor
    @Data
    public static class ParentsDTO {
        @JsonProperty("sha")
        private String sha;
        @JsonProperty("url")
        private String url;
        @JsonProperty("html_url")
        private String htmlUrl;
    }
}
