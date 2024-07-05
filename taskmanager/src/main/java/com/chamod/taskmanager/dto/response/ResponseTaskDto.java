package com.chamod.taskmanager.dto.response;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseTaskDto {
    private Long id;
    private String name;
    private String employee;
    private Date startDate;
    private Date endDate;
    private String status;
}