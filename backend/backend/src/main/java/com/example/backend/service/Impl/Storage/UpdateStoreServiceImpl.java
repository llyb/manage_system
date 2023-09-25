package com.example.backend.service.Impl.Storage;

import com.example.backend.mapper.StorageMapper;
import com.example.backend.service.storage.UpdateStorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateStoreServiceImpl implements UpdateStorService {
    @Autowired
    StorageMapper storageMapper;
    @Override
    public String updateToStorage(int s_volume, int s_id) {
        return storageMapper.updateToStore(s_volume, s_id);
    }
}
