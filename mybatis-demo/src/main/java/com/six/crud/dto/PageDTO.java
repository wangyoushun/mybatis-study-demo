package com.six.crud.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PageDTO {
    private String id;
    private Integer pageNum;
    private Integer pageSize;
}
