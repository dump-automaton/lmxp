package llt.lmxp.xposed;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;

public class HookName {
    public static void hookName(ClassLoader realClassLoader){
        PackageManager pm = null;
        //pm.getApplicationLabel()
        ActivityInfo activityInfo = null;
        //activityInfo.loadLabel()
        ApplicationInfo ai = null;
        PackageItemInfo pii = null;
        XposedHelpers.findAndHookMethod("android.app.ApplicationPackageManager", realClassLoader, "getApplicationLabel", ApplicationInfo.class, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                if (((ApplicationInfo)param.args[0]).packageName.equals("com.netspace.myipad")){
                    param.setResult("潲年派");
                }
            }
        });
        XposedHelpers.findAndHookMethod(PackageItemInfo.class, "loadLabel", PackageManager.class, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                PackageItemInfo rpi = (PackageItemInfo) param.thisObject;
                if (param.getResult().equals("少年派")){
                    param.setResult("潲年派");
                }
            }
        });
    }
}
