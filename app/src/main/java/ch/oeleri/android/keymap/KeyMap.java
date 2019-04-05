package ch.oeleri.android.keymap;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;


public class KeyMap extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.text);
    }

    TextView text;
    int backCount;

    @Override
    public boolean onKeyDown(int keycode, KeyEvent event) {
        String keyCodeToString = KeyEvent.keyCodeToString(keycode);

        keyCodeToString = keyCodeToString.substring(keyCodeToString.indexOf("_") + 1);

        String keyPressInfo =
                "\n   Key Code: " + keyCodeToString +
                        "\nScan Code: " + Integer.toString(event.getScanCode()) +
                        "\n\n    deviceID: " + event.getDeviceId(); //use lsusb to get product/vendorid's

        text.setText(keyPressInfo);

        Log.d("keyPress", keyPressInfo);

        if (keycode == 4)
            backCount++;
        else
            backCount = 0;

        if (backCount == 5)
            finish();

        return true;
    }
}