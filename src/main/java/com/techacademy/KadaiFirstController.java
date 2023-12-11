package com.techacademy;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController {

    //八桁の数列から日付を取得し、曜日に変更する
    @GetMapping("/dayofweek/{val1}")
    public String dispDayOfWeek(@PathVariable String val1) {

        // 西暦と月と日に分解して、数値型に変換する。
        int y = Integer.parseInt(val1.substring(0, 4));
        int m = Integer.parseInt(val1.substring(4, 6));
        int d = Integer.parseInt(val1.substring(6, 8));

        // 日付を取得する
        LocalDate ld = LocalDate.of(y, m, d);
        // 曜日を取得する
        DayOfWeek w = ld.getDayOfWeek();

        // 頭文字は大文字、それ以外は、小文字
        String result = null;
        switch(w) {
        case SUNDAY:
            result = "Sunday";
            break;
        case MONDAY:
            result = "Monday";
            break;
        case TUESDAY:
            result = "Tuesday";
            break;
        case WEDNESDAY:
            result = "Wednesday";
            break;
        case THURSDAY:
            result = "Thursday";
            break;
        case FRIDAY:
            result = "Friday";
            break;
        case SATURDAY:
            result = "Statuday";
            break;
    }
        return result;
    }

    //足し算
    @GetMapping("/plus/{val1}/{val2}")
    public int calcPlus(@PathVariable int val1, @PathVariable int val2) {
        int result = val1 + val2;
        return result;
    }

    //引き算
    @GetMapping("/minus/{val1}/{val2}")
    public int calcMinus(@PathVariable int val1, @PathVariable int val2) {
        int result = val1 - val2;
        return result;
    }

    //掛け算
    @GetMapping("/times/{val1}/{val2}")
    public int calcTimes(@PathVariable int val1, @PathVariable int val2) {
        int result = val1 * val2;
        return result;
    }

    //割り算
    @GetMapping("/divide/{val1}/{val2}")
    public int calcDivide(@PathVariable int val1, @PathVariable int val2) {
        int result = val1 / val2;
        return result;
    }

}
