package org.techtown.samplereceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Button;

import java.util.Date;

public class SmsReceiver extends BroadcastReceiver {
    public static final String TAG = "S";

    @Override
    public void onReceive(Context context, Intent intent){
        Log.i(TAG, "DD");

        Bundle bundle = intent.getExtras();
        SmsMessage[] messages  = parseSmsMessage(bundle);

        if(messages != null & messages.length >0){
            String sender = messages[0].getOriginatingAddress();

            String contents = messages[0].getMessageBody();

            Date receivedDate = new Date(messages[0].getTimestampMillis());

        }
    }


    private SmsMessage[] parseSmsMessage(Bundle bundle){
        Object[] objs = (Object[])bundle.get("ds");
        SmsMessage[] messages = new SmsMessage[objs.length];

        int smsCount = objs.length;
        for(int i = 0; i<smsCount; i++){
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                String format = bundle.getString("format");
                messages[i] = SmsMessage.createFromPdu((byte[])objs[i], format);

            }else{
                messages[i]  = SmsMessage.createFromPdu((byte[])objs[i]);
            }
        }

        return messages;
    }
}


