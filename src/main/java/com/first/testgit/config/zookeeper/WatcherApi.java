package com.first.testgit.config.zookeeper;

import cn.hutool.core.io.watch.Watcher;
import org.apache.zookeeper.WatchedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.nio.file.WatchEvent;

/**
 * @author:jiaxingxu
 **/
public class WatcherApi implements Watcher {

    private static final Logger logger = LoggerFactory.getLogger(WatcherApi.class);

    public void process(WatchedEvent event) {
        logger.info("【Watcher监听事件】={}",event.getState());
        logger.info("【监听路径为】={}",event.getPath());
        logger.info("【监听的类型为】={}",event.getType()); //  三种监听类型： 创建，删除，更新
    }

    @Override
    public void onCreate(WatchEvent<?> watchEvent, Path path) {

    }

    @Override
    public void onModify(WatchEvent<?> watchEvent, Path path) {

    }

    @Override
    public void onDelete(WatchEvent<?> watchEvent, Path path) {

    }

    @Override
    public void onOverflow(WatchEvent<?> watchEvent, Path path) {

    }
}
