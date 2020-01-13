package org.mountcloud.mcplugin.command;

import org.bukkit.command.CommandSender;
import org.mountcloud.mcplugin.TestPlugin;
import org.mountcloud.mcplugin.common.command.BaseCommand;
import org.mountcloud.mcplugin.common.command.BaseCommandSenderType;

/**
 * @author zhanghaishan
 * @version 创建时间：2020/1/13 23:59
 * TODO:
 */
public class TestShowLangCommand extends BaseCommand {
    public TestShowLangCommand() {
        super("showlang", BaseCommandSenderType.ARBITRARLIY, 0);
    }

    @Override
    public void run(CommandSender commandSender, String[] strings, BaseCommandSenderType baseCommandSenderType) {
        //取到刚刚配置的国际化，default参数为取不到的情况下返回什么话，一般为英文，配置文件中为中文或者其他语言的。
        String testLang = TestPlugin.getInstance().getBaseLanguageService().getLanguage("TEST_LANG_HELLO","test lang default.");
        TestPlugin.getInstance().getBaseMessageService().sendMessage(commandSender,"配置为："+testLang);
    }
}
