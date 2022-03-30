package ru.netology;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class FellowOne {
    private  String fullName;
    private  String phone;
    private String oldDate;
    private String newDate;
    private String nativeCity;
}
