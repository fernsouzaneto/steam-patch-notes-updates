package com.steam_api.patch_notes_updates.domain.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigInteger;

@Component
@Slf4j
public class SteamAPIService {

    @Value("${steam-api.url}")
    private String steamApiUrl;

    @Autowired
    private RestTemplate restTemplate;

    public String getPatchNoteInfoByAppId(BigInteger appId) {
        try {
            UriComponents uriComponents = UriComponentsBuilder.fromUriString(steamApiUrl)
                    .pathSegment("ISteamNews")
                    .pathSegment("GetNewsForApp")
                    .pathSegment("v0002")
                    .queryParam("appid", appId)
                    .queryParam("count", 1)
                    .queryParam("format", "json")
                    .build();


            ResponseEntity<String> response = restTemplate.getForEntity(uriComponents.toUri(), String.class);
            return response.getBody();
        } catch (Exception ex) {
            //log.error("Ocorreu um erro: " + ex.getMessage());
            throw ex;
        }
    }
}
