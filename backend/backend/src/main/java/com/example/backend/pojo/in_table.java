package com.example.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class in_table {
    private int id;
    private int goods_number;
    private int storage_id;
    private Date in_time;
    private int user_id;
}
