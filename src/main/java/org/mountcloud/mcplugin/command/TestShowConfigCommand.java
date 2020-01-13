package org.mountcloud.mcplugin.command;

import org.bukkit.command.CommandSender;
import org.mountcloud.mcplugin.TestPlugin;
import org.mountcloud.mcplugin.common.command.BaseCommand;
import org.mountcloud.mcplugin.common.command.BaseCommandSenderType;
import org.mountcloud.mcplugin.common.config.BaseConfig;
import org.mountcloud.mcplugin.common.service.config.BaseConfigService;

/**
 * @author zhanghaishan
 * @version 创建时间：2020/1/13 23:31
 * TODO:
 */
public class TestShowConfigCommand extends BaseCommand {

    /**
     * 构造函数，BaseCommand提供了含权限的构造函数，这个到时候再讲
     */
    public TestShowConfigCommand() {
        super("showconfig", BaseCommandSenderType.ARBITRARLIY, 0);
    }

    @Override
    public void run(CommandSender commandSender, String[] strings, BaseCommandSenderType baseCommandSenderType) {
        BaseConfig config = TestPlugin.getInstance().getBaseConfigService().getConfig("config.yml");
        String sayhello = config.getConfig().getString("sayhello");
        //向玩家发送 sayhello的配置
        TestPlugin.getInstance().getBaseMessageService().sendMessage(commandSender,"配置为："+sayhello);
    }
}
