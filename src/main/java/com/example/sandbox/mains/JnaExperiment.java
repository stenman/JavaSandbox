package com.example.sandbox.mains;

import com.sun.jna.Pointer;

public class JnaExperiment {
    public static void main(String args[]) {
        User32 user32 = User32.INSTANCE;
        boolean res = user32.RegisterHotKey(Pointer.NULL, 9999, User32.MOD_ALT | User32.MOD_CONTROL, 0x25);

        if (!res)
        {
            System.out.println("Couldn't register hotkey");

        }

        System.out.println("Starting and waiting");
        user32.MsgWaitForMultipleObjects(0, Pointer.NULL, true, User32.INFINITE, User32.QS_HOTKEY);
        System.out.println("Ending");
    }
}