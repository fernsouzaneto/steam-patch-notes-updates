package com.steam_api.patch_notes_updates.controller;

import com.steam_api.patch_notes_updates.domain.service.SteamAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;

@Controller
@RequestMapping(value = "/game/")
public class PatchNotesController {

    @Autowired
    private SteamAPIService service;

    @GetMapping("/getInfo")
    public ResponseEntity<String> getGameInfo(@RequestParam("appID") BigInteger appId){
        String response = service.getPatchNoteInfoByAppId(appId);
        return ResponseEntity.ok(response);
    }
}
