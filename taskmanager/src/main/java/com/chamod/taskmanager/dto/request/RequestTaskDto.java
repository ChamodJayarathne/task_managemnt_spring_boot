package com.chamod.taskmanager.dto.request;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestTaskDto {
    private String name;
    private String employee;
    private Date startDate;
    private Date endDate;
    private String status;
}
