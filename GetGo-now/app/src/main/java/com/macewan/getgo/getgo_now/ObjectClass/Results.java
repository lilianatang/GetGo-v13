package com.macewan.getgo.getgo_now.ObjectClass;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import com.macewan.getgo.getgo_now.R;
import java.util.*;

/**
 * Created by Siham on 2018-03-19.
 */

public class Results extends Activity {

    public Singleton s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_logic);
        s = Singleton.getInstance(this.getBaseContext());

        Intent intent = getIntent();
        String list = intent.getParcelableExtra("list");
        List<String> items = Arrays.asList(list.split("\\s*,\\s*"));

    }
}
