package com.hoc.util;


import com.alibaba.fastjson.JSONArray;
import com.hoc.entity.Data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataUtil {
    public static List<Data> dataHandler(String rawData) {
        List<Data> data = new ArrayList<>();
        String temp = rawData.substring(rawData.indexOf("records")).replaceAll("records\":", "");
        JSONArray array = JSONArray.parseArray(temp.replace("}", ""));
        for (int i = 0; i < array.size(); i++) {
            Data d = new Data();
            String[] temp2 = array.getString(i).replace("[", "").replace("]", "").split(",");
            d.setTimestamp(Long.parseLong(temp2[0]));
            d.setOpen(Double.parseDouble(temp2[1]));
            d.setHigh(Double.parseDouble(temp2[2]));
            d.setLow(Double.parseDouble(temp2[3]));
            d.setClose(Double.parseDouble(temp2[4]));
            d.setVolume(Double.parseDouble(temp2[5]));
            data.add(d);
        }
        return data;
    }
    //MACD cal
    public static List<Double> maCalc(List<Data> data, int MA_X) {
        List<Double> numListMA = new ArrayList<>();
        outer:for (int i = 0; i < data.size(); i++) {
                //计算ma
                double MA = 0;
                for (int p = 0; p < MA_X; p++) {
                    if(i+p == data.size()){
                        break outer;
                    }
                    MA += data.get(i + p).getClose();
                }
                MA = MA/MA_X;
                numListMA.add(MA);
        }
        return numListMA;
    }
    // KDJ calc

    // BOLL calc

    // TOW calc
    public static void main(String[] args) throws IOException {
        System.out.println(maCalc(dataHandler(FileUtil.dataReader("data1.json")),6));
    }
}
