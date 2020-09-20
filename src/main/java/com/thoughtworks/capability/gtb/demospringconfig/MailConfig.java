package com.thoughtworks.capability.gtb.demospringconfig;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties("mail")
public class MailConfig {

    private String hostname;

    private int port;

    private String from;

}
