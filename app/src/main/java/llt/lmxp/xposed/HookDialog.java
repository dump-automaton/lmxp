package llt.lmxp.xposed;

import android.content.Context;
import android.content.DialogInterface;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedHelpers;

public class HookDialog {
    public static void hookDialog(ClassLoader realClassLoader){
        XposedHelpers.findAndHookMethod("com.netspace.library.utilities.Utilities", realClassLoader, "showAlertMessageMustClick",
                Context.class,String.class,String.class, DialogInterface.OnClickListener.class,
        new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                return null;
            }
        });
        XposedHelpers.findAndHookMethod("com.netspace.library.utilities.Utilities", realClassLoader, "showAlertMessageMustClick",
                Context.class,String.class,String.class,
                new XC_MethodReplacement() {
                    @Override
                    protected Object replaceHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                        return null;
                    }
                });
    }
}
