package com.example.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class goods {
    private Integer goodsnumber;
    private String goodsname;
    private Integer goodsprice;
}
