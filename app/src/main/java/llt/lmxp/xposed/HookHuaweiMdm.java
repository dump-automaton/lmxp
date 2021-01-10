package llt.lmxp.xposed;

import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedHelpers;

public class HookHuaweiMdm {
    public static void hookHuaweiMdm(ClassLoader realClassLoader){
        XposedHelpers.findAndHookMethod("com.netspace.myipad.MyiPadApplication", realClassLoader, "isActive", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                return true;
            }
        });
    }
}
