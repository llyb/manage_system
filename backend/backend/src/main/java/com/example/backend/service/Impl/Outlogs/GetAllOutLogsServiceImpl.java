package com.example.backend.service.Impl.Outlogs;

import com.example.backend.mapper.In_LogsMapper;
import com.example.backend.mapper.Out_LogsMapper;
import com.example.backend.service.Inlogs.GetAllInLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GetAllOutLogsServiceImpl implements GetAllInLogsService {
    @Autowired
    private Out_LogsMapper logsMapper;
    @Override
    public List<Map<String, Object>> getAllinfo() {
        return logsMapper.getAll_info();
    }
}
