package org.mountcloud.mcplugin.config;

import org.mountcloud.mcplugin.TestPlugin;
import org.mountcloud.mcplugin.common.BasePlugin;
import org.mountcloud.mcplugin.common.config.BaseConfig;

/**
 * @author zhanghaishan
 * @version 创建时间：2020/1/14 0:16
 * TODO:
 */
public class TestConfig extends BaseConfig {
    public TestConfig() {
        super("config.yml", TestPlugin.getInstance());
    }

    //是否自动创建配置文件到 plugin目录中的插件名目录
    @Override
    protected boolean createConfig() {
        return true;
    }

    @Override
    public void loadConfig() {
        //可以写一些预加载，比如，这个类可以定义一些属性，然后可以在此处初始化这些属性，reload也可以重新初始化。
    }
}
