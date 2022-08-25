package com.example.printer;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugins.GeneratedPluginRegistrant;
import io.flutter.plugin.common.MethodChannel;
import android.content.Intent;

public class MainActivity extends FlutterActivity {
  
    private static final String CHANNEL="channel.test.event";

    @Override
    public void configureFlutterEngine(FlutterEngine flutterEngine){
        GeneratedPluginRegistrant.registerWith(flutterEngine);


        new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(),CHANNEL)
        .setMethodCallHandler((call,result)->{
             if(call.method.equals("openCamera")){
                openCamera();
              
             }
        });
    }
    

    public void openCamera(){
        Intent intent=new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(intent);
        System.out.println("Hello there!");
    }

}
