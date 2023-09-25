package com.example.backend.controller.OutLogs;

import com.example.backend.service.Inlogs.UpdateInLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UpdateOutLogsController {
    @Qualifier("updateOutLogsServiceImpl")
    @Autowired
    private UpdateInLogsService updateLogsService;
    @PostMapping("/update/outlogs")
    public String update(@RequestParam Map<String,String> map) {
        int goods_number = Integer.parseInt(map.get("goods_number"));
        int storage_id = Integer.parseInt(map.get("in_storage"));
        int user_id = Integer.parseInt(map.get("user_id"));
        int good_num = Integer.parseInt(map.get("good_num"));
        return updateLogsService.update_info(goods_number, storage_id, user_id, good_num);
    }
}
