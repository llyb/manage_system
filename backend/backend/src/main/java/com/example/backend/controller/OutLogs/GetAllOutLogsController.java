package com.example.backend.controller.OutLogs;

import com.example.backend.service.Inlogs.GetAllInLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GetAllOutLogsController {
    @Qualifier("getAllOutLogsServiceImpl")
    @Autowired
    private GetAllInLogsService getAllLogsService;

    @GetMapping("/getAll/outlogs")
    public List<Map<String,Object>> queryAll() {
        return getAllLogsService.getAllinfo();
    }
}