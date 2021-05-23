package pl.kinert.malgorzata.github.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonPropertyOrder({
        "id",
        "login",
        "name",
        "type",
        "avatarUrl",
        "createdAt",
        "calculations"
})
public class User {
    private long id;
    private String login;
    private String name;
    private String type;
    @JsonAlias("avatar_url")
    private String avatarUrl;
    @JsonAlias("created_at")
    private String createdAt;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private double calculations;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int followers;
    @JsonAlias("public_repos")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int publicRepos;
}
