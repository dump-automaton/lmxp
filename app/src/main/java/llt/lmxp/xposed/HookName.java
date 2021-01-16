package llt.lmxp.xposed;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;

public class HookName {
    public static void hookName(ClassLoader realClassLoader){
        PackageManager pm = null;
        //pm.getApplicationLabel()
        ActivityInfo activityInfo = null;
        //activityInfo.loadLabel()
        ApplicationInfo ai = null;
        PackageItemInfo pii = null;
        Class InnerPackage = XposedHelpers.findClass("android.content.pm.PackageParser$Package",realClassLoader);
        XposedHelpers.findAndHookMethod("android.content.pm.PackageParser", realClassLoader, "parsePackageItemInfo",
                InnerPackage,
                PackageItemInfo.class,
                String[].class,
                String.class,
                TypedArray.class,
                boolean.class,
                int.class, int.class, int.class, int.class, int.class, int.class,
                new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        PackageItemInfo packageItemInfo = (PackageItemInfo) param.args[1];
                        XposedBridge.log(packageItemInfo.name != null ? packageItemInfo.name : "null name");
                        if(packageItemInfo.nonLocalizedLabel == null){
                            return;
                        }
                        if (packageItemInfo.nonLocalizedLabel.equals("少年派")){
                            packageItemInfo.nonLocalizedLabel = "潲年派";
                        }
                    }
                }
        );
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
