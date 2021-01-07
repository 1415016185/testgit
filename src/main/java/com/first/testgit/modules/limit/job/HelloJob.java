package com.first.testgit.modules.limit.job;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author:jiaxingxu
 * 没错都是一个getJobDataMap
 **/
@PersistJobDataAfterExecution
public class HelloJob implements Job {

    /*
    * 用get set 方法传递参数
    */
    private  String message;


    /*
     * 用set  传递count
     */
    private  Integer count;


    public void setCount(Integer count) {
        this.count = count;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        JobKey key = jobExecutionContext.getJobDetail().getKey();
        System.out.println("任务名称"+key.getName()+key.getGroup());

        //这些传参 可以用其他方式搞 pojo类
         /* JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        String message = jobDataMap.getString("message");
        System.out.println("getJobDetail   jobmessage"+message);

        JobDataMap jobDataMap1 = jobExecutionContext.getTrigger().getJobDataMap();
        String message1 = jobDataMap1.getString("message");
        System.out.println("getTrigger   jobmessage"+message1);*/
        //其他的一些值

        System.out.println("注意 tragger 里面的值 如果和jobdetails  重名的话 会覆盖"+message);

        System.out.println("当前任务的执行时间"+simpleDateFormat.format(jobExecutionContext.getFireTime()));
        System.out.println("下一次任务的执行时间"+simpleDateFormat.format(jobExecutionContext.getNextFireTime()));

        String format = simpleDateFormat.format(date);
        System.out.println("现在时间是"+format);
        ++count;
        //无状态的job  没次都会new 一个 getJobDataMap
        jobExecutionContext.getJobDetail()
                .getJobDataMap().put("count",count);
        System.out.println(count);

    }
}
