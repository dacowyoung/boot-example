package com.young.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: young
 * @create: 2020/5/21 16:31
 * @desc: 定时任务测试类
 */

@Component
public class TestTask {

    private int count = 0;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * 秒（0~59）
     * 分钟（0~59）
     * 小时（0~23）
     * 天（月）（0~31，但是你需要考虑你月的天数）
     * 月（0~11）
     * 天（星期）（1~7 1=SUN 或 SUN，MON，TUE，WED，THU，FRI，SAT）
     * 年份（1970－2099）
     */
    @Scheduled(cron = "*/6 * * * * ?")
    private void process() {
        System.out.println("this is scheduler task running  " + (count++));
    }

    /**
     * fixedRate = 6000 ：上一次开始执行时间点之后6秒再执行
     * fixedDelay = 6000 ：上一次执行完毕时间点之后6秒再执行
     * initialDelay=1000, fixedRate=6000：第一次延迟1秒后执行，之后按 fixedRate 的规则每6秒执行一次
     */
    @Scheduled(fixedRate = 6000)
    public void reportCurrentTime() {
        System.out.println("current time : " + dateFormat.format(new Date()));
    }
}
