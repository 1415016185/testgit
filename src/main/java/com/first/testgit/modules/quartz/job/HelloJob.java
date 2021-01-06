package com.first.testgit.modules.quartz.job;

import org.mybatis.spring.annotation.MapperScan;
import org.quartz.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author:jiaxingxu
 **/
public class HelloJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        JobKey key = jobExecutionContext.getJobDetail().getKey();
        System.out.println("任务名称"+key.getName()+key.getGroup());
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        String message = jobDataMap.getString("message");
        System.out.println("getJobDetail   jobmessage"+message);

        JobDataMap jobDataMap1 = jobExecutionContext.getTrigger().getJobDataMap();
        String message1 = jobDataMap1.getString("message");
        System.out.println("getTrigger   jobmessage"+message1);
        //其他的一些值
        System.out.println("当前任务的执行时间"+simpleDateFormat.format(jobExecutionContext.getFireTime()));
        System.out.println("下一次任务的执行时间"+simpleDateFormat.format(jobExecutionContext.getNextFireTime()));

        String format = simpleDateFormat.format(date);
        System.out.println("现在时间是"+format);

    }
}
