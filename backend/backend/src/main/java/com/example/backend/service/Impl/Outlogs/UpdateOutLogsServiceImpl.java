package com.example.backend.service.Impl.Outlogs;

import com.example.backend.mapper.In_LogsMapper;
import com.example.backend.mapper.Out_LogsMapper;
import com.example.backend.service.Inlogs.UpdateInLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateOutLogsServiceImpl implements UpdateInLogsService {
    @Autowired
    private Out_LogsMapper logsMapper;
    @Override
    public String update_info(int goods_numebr, int storage_id, int user_id, int good_num) {
        return logsMapper.update_info(goods_numebr, storage_id, user_id, good_num);
    }
}