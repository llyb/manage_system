package com.example.backend.controller.InLogs;

import com.example.backend.service.Inlogs.GetAllInLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GetAllInLogsController {
    @Qualifier("getAllInLogsServiceImpl")
    @Autowired
    private GetAllInLogsService getAllLogsService;

    @GetMapping("/getAll/inlogs")
    public List<Map<String,Object>> queryAll() {
        return getAllLogsService.getAllinfo();
    }
}
