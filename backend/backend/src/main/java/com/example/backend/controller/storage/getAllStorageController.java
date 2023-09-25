package com.example.backend.controller.storage;

import com.example.backend.service.storage.GetStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class getAllStorageController {
    @Autowired
    private GetStorageService getStorageService;
    @GetMapping("/get/storage")
    public List<Map<String,Object>> queryAll() {
        return getStorageService.queryAll();
    }
}
