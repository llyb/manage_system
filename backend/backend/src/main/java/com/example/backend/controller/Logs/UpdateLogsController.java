package com.example.backend.controller.Logs;

import com.example.backend.service.logs.UpdateLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UpdateLogsController {
    @Autowired
    private UpdateLogsService updateLogsService;
    @PostMapping("/update/logs")
    public String update(@RequestParam Map<String,String> map) {
        int goods_number = Integer.parseInt(map.get("goods_number"));
        int storage_id = Integer.parseInt(map.get("storage_id"));
        int user_id = Integer.parseInt(map.get("user_id"));
        System.out.println(goods_number + " " + storage_id + " " + user_id);
        return updateLogsService.update_info(goods_number, storage_id, user_id);
    }
}
