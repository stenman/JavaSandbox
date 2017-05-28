package com.example.sandbox.mains;
import com.sun.jna.IntegerType;
import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.Structure;
import com.sun.jna.FromNativeContext;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.StdCallLibrary.StdCallCallback;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.Library;
import com.sun.jna.win32.W32APITypeMapper;
import com.sun.jna.win32.W32APIFunctionMapper;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class JnaExperiment {
    static Map UNICODE_OPTIONS = new HashMap() {
        {
            put("type-mapper", W32APITypeMapper.UNICODE);
            put("function-mapper", W32APIFunctionMapper.UNICODE);
        }
    };

    public static class LONG_PTR extends IntegerType {
        public LONG_PTR() { this(0); }
        public LONG_PTR(long value) { super(Pointer.SIZE, value); }
    }

    public static class UINT_PTR extends IntegerType {
        public UINT_PTR() { super(Pointer.SIZE); }
        public UINT_PTR(long value) { super(Pointer.SIZE, value); }
        public Pointer toPointer() { return Pointer.createConstant(longValue()); }
    }

    public static class ULONG_PTR extends IntegerType {
        public ULONG_PTR() { this(0); }
        public ULONG_PTR(long value) { super(Pointer.SIZE, value); }
    }

    public static class LRESULT extends LONG_PTR {
        public LRESULT() { this(0); }
        public LRESULT(long value) { super(value); }
    }

    public static class WPARAM extends UINT_PTR {
        public WPARAM() { this(0); }
        public WPARAM(long value) { super(value); }
    }

    public static class LPARAM extends LONG_PTR {
        public LPARAM() { this(0); }
        public LPARAM(long value) { super(value); }
    }

    public static class KBDLLHOOKSTRUCT extends Structure {
        public int vkCode;
        public int scanCode;
        public int flags;
        public int time;
        public ULONG_PTR dwExtraInfo;

        @Override
        protected List<String> getFieldOrder() {
            return null;
        }
    }

    static HANDLE INVALID_HANDLE_VALUE = new HANDLE() {
        { super.setPointer(Pointer.createConstant(-1)); }
        public void setPointer(Pointer p) {
            throw new UnsupportedOperationException("Immutable reference");
        }
    };

    public static class HANDLE extends PointerType {
        public Object fromNative(Object nativeValue, FromNativeContext context) {
            Object o = super.fromNative(nativeValue, context);
            if (INVALID_HANDLE_VALUE.equals(o))
                return INVALID_HANDLE_VALUE;
            return o;
        }
    }

    public static class HHOOK extends HANDLE { }
    public static class HINSTANCE extends HANDLE { }
    public static class HMODULE extends HINSTANCE { }

    public interface User32 extends StdCallLibrary  {
        User32 INSTANCE = (User32)Native.loadLibrary("user32", User32.class, UNICODE_OPTIONS);

        static final int WH_KEYBOARD_LL = 13;

        public static interface HOOKPROC extends StdCallCallback  {
            LRESULT callback(int nCode, WPARAM wParam, KBDLLHOOKSTRUCT lParam);
        }

        HHOOK SetWindowsHookEx(int idHook, HOOKPROC lpfn, HMODULE hMod, int dwThreadId);
        LRESULT CallNextHookEx(HHOOK idHook, int nCode, WPARAM wParam, LPARAM lParam);
        LRESULT CallNextHookEx(HHOOK idHook, int nCode, WPARAM wParam, Pointer lParam);

        boolean UnhookWindowsHookEx(HHOOK idHook);
    }

    public interface Kernel32 extends StdCallLibrary {
        Kernel32 INSTANCE = (Kernel32)Native.loadLibrary("kernel32", Kernel32.class, UNICODE_OPTIONS);

        HMODULE GetModuleHandle(String name);
    }

    public static HHOOK hHook;
    public static User32.HOOKPROC lpfn;
    public static volatile boolean quit = false;

    public static void main(String[] args) throws Exception {
        HMODULE hMod = Kernel32.INSTANCE.GetModuleHandle(null);
        System.out.println(hMod);

        lpfn = new User32.HOOKPROC() {
            public LRESULT callback(int nCode, WPARAM wParam, KBDLLHOOKSTRUCT lParam) {
                System.out.println("here");
                quit = true;
                return User32.INSTANCE.CallNextHookEx(hHook, nCode, wParam, lParam.getPointer());
            }
        };

        hHook = User32.INSTANCE.SetWindowsHookEx(User32.WH_KEYBOARD_LL, lpfn, hMod, 0);
        System.out.println(hHook);

        if(hHook != null)
            System.out.println("Keyboard hooked, type anything to quit");

        while(!quit) {
            Thread.sleep(100);
        }

        if(User32.INSTANCE.UnhookWindowsHookEx(hHook))
            System.out.println("Unhooked");

    }
}