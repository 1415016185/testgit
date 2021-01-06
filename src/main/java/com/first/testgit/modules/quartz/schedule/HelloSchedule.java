package com.first.testgit.modules.quartz.schedule;

import com.first.testgit.modules.quartz.job.HelloJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author:jiaxingxu
 **/
public class HelloSchedule {
    public static void main(String[] args) throws SchedulerException {

        //调度器从工厂获取调度器的实例
        Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();
        //任务实例 jobdetails  这个和job 不一样
        //withIdentity 有多种构造方式 多个参数或一个参数 有分组的概念
        //参数一名字 参数二组名
        JobDetail build = JobBuilder.newJob(HelloJob.class)
                .withIdentity("name1", "group1")
                .usingJobData("message","我是jobdetail")
                .build();
        //触发器
        SimpleTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .usingJobData("message","我是触发器")
                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(30)).build();
        //让调度器关联 触发器和任务
        defaultScheduler.scheduleJob(build,trigger);
        defaultScheduler.start();


    }
}
