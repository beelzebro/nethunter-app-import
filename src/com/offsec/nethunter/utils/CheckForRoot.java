package com.offsec.nethunter.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.offsec.nethunter.R;

import androidx.appcompat.app.AlertDialog;

import java.io.File;


public abstract class CheckForRoot {

    public static String BUSYBOX;
    private static final String MAGISK_BUSYBOX = "/sbin/.magisk/busybox/busybox";

    public static boolean isRoot() {
        ShellExecuter exe = new ShellExecuter();
        return !exe.Executer("su -c 'id'").isEmpty();
    }

    public static boolean isBusyboxInstalled() {
        ShellExecuter exe = new ShellExecuter();
        BUSYBOX = exe.RunAsRootOutput("which busybox | head -n1");
        if (BUSYBOX.isEmpty()) {
            if (new File(MAGISK_BUSYBOX).canExecute()){
                BUSYBOX = MAGISK_BUSYBOX;
                return true;
            }
            return false;
        }
        return true;
    }
}

