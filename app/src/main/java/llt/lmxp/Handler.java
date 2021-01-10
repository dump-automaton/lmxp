package llt.lmxp;

import android.app.Application;
import android.content.Context;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import llt.lmxp.xposed.*;
public class Handler implements IXposedHookLoadPackage, IXposedHookZygoteInit {

    @Override
    public void initZygote(StartupParam startupParam) throws Throwable {
        startupParam.
    }

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        HookName.hookName(lpparam.classLoader);
        if(lpparam.packageName.startsWith("com.netspace.")){
            XposedHelpers.findAndHookMethod("android.app.Instrumentation", lpparam.classLoader, "newApplication",ClassLoader.class, String.class, Context.class, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    Application realApplication = (Application) param.getResult();
                    ClassLoader realClassLoader = realApplication.getClassLoader();
                    HookDialog.hookDialog(realClassLoader);
                    HookHuaweiMdm.hookHuaweiMdm(realClassLoader);
                    HookNetwork.hookNetwork(realClassLoader);
                }
            });
        }
    }
}
