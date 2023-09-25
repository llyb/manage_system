package com.example.backend.controller.storage;

import com.example.backend.service.storage.UpdateStorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UpdateStorageContoller {
    @Autowired
    UpdateStorService updateStorService;

    @PostMapping("/update/storage")
    public String updateToStore(@RequestParam Map<String,String> mp) {
        int s_volume = Integer.parseInt(mp.get("s_volume"));
        int s_id = Integer.parseInt(mp.get("s_id"));
        System.out.println("aaaaaaaaaaaaaaaaaaa" + "s_volume" + s_volume + " " + "s_id" + s_id);
        return updateStorService.updateToStorage(s_volume, s_id);
    }
}
