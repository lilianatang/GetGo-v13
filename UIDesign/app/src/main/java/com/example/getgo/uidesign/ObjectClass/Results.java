package com.example.getgo.uidesign.ObjectClass;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import com.example.getgo.uidesign.R;
import java.util.*;
import com.example.getgo.uidesign.UIHelpers.*;

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
