package llt.lmxp.xposed;

import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedHelpers;

public class HookUsageThread {
    public static void hookUsageThread(ClassLoader realClassLoader){
        XposedHelpers.findAndHookMethod("com.netspace.library.threads.UsageDataUploadThread", realClassLoader, "run", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                return null;
            }
        });
        XposedHelpers.findAndHookMethod("com.netspace.library.threads.UsageDataUploadThread", realClassLoader, "startUpload", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                return null;
            }
        });
    }
}
