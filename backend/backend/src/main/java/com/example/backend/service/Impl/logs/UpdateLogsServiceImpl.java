package com.example.backend.service.Impl.logs;

import com.example.backend.mapper.LogsMapper;
import com.example.backend.service.logs.UpdateLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateLogsServiceImpl implements UpdateLogsService {
    @Autowired
    private LogsMapper logsMapper;
    @Override
    public String update_info(int goods_numebr, int storage_id, int user_id) {
        return logsMapper.update_info(goods_numebr, storage_id, user_id);
    }
}
