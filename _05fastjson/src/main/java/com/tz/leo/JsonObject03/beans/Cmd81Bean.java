package com.tz.leo.JsonObject03.beans;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Author: tz_wl
 * Date: 2020/8/21 17:32
 * Content:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cmd81Bean  implements Comparable {
    private double EncryptLat;
    private String TerminalType;
    private double TotalEngineHours;
    private double EncryptLng;
    private long VehicleId;
    private long AdminDivisionCode;
    private List<TimeBean> TimeList;

    @Override
    public int compareTo(Object o) {
        if(o instanceof Cmd81Bean){
           Cmd81Bean e =  (Cmd81Bean) o;
           return ((Cmd81Bean) o).getTimeList().size()-this.getTimeList().size();
        }else{
            throw new RuntimeException("类型错误");
        }
    }



}
