package ru.easydonate.easypayments.nms.provider.v1_13_R1.interceptor;

import lombok.Getter;
import net.minecraft.server.v1_13_R1.CommandListenerWrapper;
import net.minecraft.server.v1_13_R1.IChatBaseComponent;
import net.minecraft.server.v1_13_R1.ICommandListener;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_13_R1.command.ServerCommandSender;
import org.bukkit.permissions.Permission;
import ru.easydonate.easypayments.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public final class InterceptedCommandListener extends ServerCommandSender implements ICommandListener {

    private final String username;
    private final List<String> feedbackMessages;

    public InterceptedCommandListener(String username) {
        this.username = username;
        this.feedbackMessages = new ArrayList<>();
    }

    @Override
    public void sendMessage(IChatBaseComponent iChatBaseComponent) {
        feedbackMessages.add(iChatBaseComponent.getString());
    }

    @Override
    public boolean a() {
        return Constants.COMMAND_SENDER_ACCEPTS_SUCCESS;
    }

    @Override
    public boolean b() {
        return Constants.COMMAND_SENDER_ACCEPTS_FAILURE;
    }

    @Override
    public boolean B_() {
        return Constants.COMMAND_SENDER_INFORM_ADMINS;
    }

    @Override
    public CommandSender getBukkitSender(CommandListenerWrapper commandListenerWrapper) {
        return this;
    }

    @Override
    public void sendMessage(String message) {
        feedbackMessages.add(message);
    }

    @Override
    public void sendMessage(String[] messages) {
        feedbackMessages.addAll(Arrays.asList(messages));
    }

    @Override
    public String getName() {
        return username;
    }

    @Override
    public boolean isOp() {
        return true;
    }

    @Override
    public void setOp(boolean value) {
    }

    @Override
    public boolean hasPermission(String name) {
        return true;
    }

    @Override
    public boolean hasPermission(Permission perm) {
        return true;
    }

    @Override
    public boolean isPermissionSet(String name) {
        return true;
    }

    @Override
    public boolean isPermissionSet(Permission perm) {
        return true;
    }

}
