package com.tz.leo.JsonObject03.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * Author: tz_wl
 * Date: 2020/8/21 17:35
 * Content:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cmd81Beans   {
    //private Cmd81Bean[] list;
    private ArrayList<Cmd81Bean> list;
}
