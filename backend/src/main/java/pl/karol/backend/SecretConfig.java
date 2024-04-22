package pl.karol.backend;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "secret")
public record SecretConfig (String secretKey, Integer expirationTime, Integer refreshExpirationTime) {
}
