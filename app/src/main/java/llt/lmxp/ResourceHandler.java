package llt.lmxp;

import android.content.res.XResources;

import de.robv.android.xposed.IXposedHookInitPackageResources;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_InitPackageResources;

public class ResourceHandler implements IXposedHookInitPackageResources {

    @Override
    public void handleInitPackageResources(XC_InitPackageResources.InitPackageResourcesParam resparam) throws Throwable {
        if (resparam.packageName.equals("com.netspace.myipad")){
            resparam.res.setReplacement("com.netspace.myipad","string","app_name","潲年派");
        }
    }
/*
    @Override
    public void initZygote(StartupParam startupParam) throws Throwable {
        XResources.setSystemWideReplacement("com.netspace.myipad","string","app_name","潲年派");
    }*/
}
