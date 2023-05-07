package com.example.backend.service.Impl.logs;

import com.example.backend.mapper.LogsMapper;
import com.example.backend.service.logs.GetAllLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GetAllLogsServiceImpl implements GetAllLogsService {
    @Autowired
    private LogsMapper logsMapper;
    @Override
    public List<Map<String, Object>> getAllinfo() {
        return logsMapper.getAll_info();
    }
}
