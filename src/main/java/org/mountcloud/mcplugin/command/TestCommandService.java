package org.mountcloud.mcplugin.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.mountcloud.mcplugin.TestPlugin;
import org.mountcloud.mcplugin.common.BasePlugin;
import org.mountcloud.mcplugin.common.command.BaseCommand;
import org.mountcloud.mcplugin.common.command.BaseCommandSenderType;
import org.mountcloud.mcplugin.common.service.command.BaseCommandeSercvice;

/**
 * @author zhanghaishan
 * @version 创建时间：2020/1/14 0:04
 * TODO:
 */
public class TestCommandService extends BaseCommandeSercvice {
    public TestCommandService() {
        //跟命令，因为允许存在多个跟命令，所以多个跟命令需要多个实例，第二个参数是插件的main类
        super("test", TestPlugin.getInstance());
    }

    //执行命令，如果需要特殊执行，就在这里定制执行，
    @Override
    public boolean execCommand(CommandSender commandSender, BaseCommand baseCommand, String[] args, BaseCommandSenderType baseCommandSenderType) {
        baseCommand.run(commandSender, args, baseCommandSenderType);
        return true;
    }

    //找不到命令的话执行什么
    @Override
    public boolean notFoundCommand(CommandSender commandSender, Command command, String[] args) {
        TestPlugin.getInstance().getBaseMessageService().sendMessage(commandSender,"未知命令");
        return true;
    }
}
