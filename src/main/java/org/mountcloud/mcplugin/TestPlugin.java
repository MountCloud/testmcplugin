package org.mountcloud.mcplugin;

import org.mountcloud.mcplugin.command.TestCommandService;
import org.mountcloud.mcplugin.command.TestShowConfigCommand;
import org.mountcloud.mcplugin.command.TestShowLangCommand;
import org.mountcloud.mcplugin.common.BasePlugin;
import org.mountcloud.mcplugin.common.config.BaseConfig;
import org.mountcloud.mcplugin.common.config.BaseLanguageConfig;
import org.mountcloud.mcplugin.config.TestConfig;

/**
 * @author zhanghaishan
 * @version 创建时间：2020/1/13 22:53
 * TODO:
 */
public class TestPlugin extends BasePlugin {

    //这是插件运行时的实例
    private static TestPlugin testPlugin;

    @Override
    public boolean enable() {
        testPlugin = this;

        //创建命令服务
        TestCommandService testCommandService = new TestCommandService();

        //创建showconfig命令
        TestShowConfigCommand testShowConfigCommand = new TestShowConfigCommand();
        testCommandService.registerCommand(testShowConfigCommand);

        //创建showlang命令
        TestShowLangCommand testShowLangCommand = new TestShowLangCommand();
        testCommandService.registerCommand(testShowLangCommand);

        //必须注册配置文件
        this.getBaseConfigService().registerConfig(new TestConfig());
        //lang.yml对应的是BaseLanguageConfig，这个是封装好的，每个项目不一样，没法集体封装config.yml
        this.getBaseConfigService().registerConfig(new BaseLanguageConfig(this));
        //注册命令服务
        this.registerCommand(testCommandService);
        return true;
    }

    //返回实例
    public static TestPlugin getInstance(){
        return testPlugin;
    }


}
