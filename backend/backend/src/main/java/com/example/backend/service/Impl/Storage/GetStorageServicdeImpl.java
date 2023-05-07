package com.example.backend.service.Impl.Storage;

import com.example.backend.mapper.StorageMapper;
import com.example.backend.service.storage.GetStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GetStorageServicdeImpl implements GetStorageService {
    @Autowired
    private StorageMapper storageMapper;
    @Override
    public List<Map<String, Object>> queryAll() {
        return storageMapper.queryAll();
    }
}
