package com.example.sandbox.mains;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;

/**
 * Created by stenman on 2017-05-28.
 */
public interface User32 extends StdCallLibrary {
    User32 INSTANCE = (User32) Native.loadLibrary("User32", User32.class, W32APIOptions.UNICODE_OPTIONS);


    // dwWakeMask Constants
    public static final int QS_ALLEVENTS = 0x04BF;
    public static final int QS_ALLINPUT = 0x04FF;
    public static final int QS_ALLPOSTMESSAGE = 0x0100;
    public static final int QS_HOTKEY = 0x0080;
    public static final int QS_INPUT = 0x407;
    public static final int QS_KEY = 0x0001;
    public static final int QS_MOUSE = 0x0006;
    public static final int QS_MOUSEBUTTON = 0x0004;
    public static final int QS_MOUSEMOVE = 0x0002;
    public static final int QS_PAINT = 0x0020;
    public static final int QS_POSTMESSAGE = 0x0008;
    public static final int QS_RAWINPUT = 0x0400;
    public static final int QS_SENDMESSAGE = 0x0040;
    public static final int QS_TIMER = 0x0010;


    public static final int INFINITE = 0xFFFFFFFF;


    /*
    DWORD WINAPI MsgWaitForMultipleObjects(
    __in  DWORD nCount,
    __in  const HANDLE *pHandles,
    __in  BOOL bWaitAll,
    __in  DWORD dwMilliseconds,
    __in  DWORD dwWakeMask
    );*/


    int MsgWaitForMultipleObjects(int nCount, Pointer pHandles, boolean bWaitAll, int dwMilliSeconds, int dwWakeMask);


    /* fsModifiers vaues */
    public static final int MOD_ALT = 0x0001;
    public static final int MOD_CONTROL = 0x0002;
    public static final int MOD_NOREPEAT = 0x4000;
    public static final int MOD_SHIFT = 0x0004;
    public static final int MOD_WIN = 0x0008;


    /* BOOL WINAPI RegisterHotKey(
    __in_opt  HWND hWnd,
    __in      int id,
    __in      UINT fsModifiers,
    __in      UINT vk
    );
    */
    boolean RegisterHotKey(Pointer hWnd, int id, int fsModifiers, int vk);
}
