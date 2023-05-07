package com.example.backend.controller.Logs;

import com.example.backend.service.logs.GetAllLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GetAllLogsController {
    @Autowired
    private GetAllLogsService getAllLogsService;

    @GetMapping("/getAll/logs")
    public List<Map<String,Object>> queryAll() {
        return getAllLogsService.getAllinfo();
    }
}
