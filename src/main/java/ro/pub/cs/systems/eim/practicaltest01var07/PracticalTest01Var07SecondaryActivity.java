package ro.pub.cs.systems.eim.practicaltest01var07;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var07SecondaryActivity extends AppCompatActivity {

    private TextView leftUp, leftDown, rightUp, rightDown;
    private Button sumButton, productButton;
    int numberLeftUp, numberLeftDown, numberRightUp, numberRightDown;

    private final ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @SuppressLint("NonConstantResourceId")
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.left_button:
                    setResult(RESULT_OK, null);
                    Toast.makeText(getApplicationContext(), Integer.toString(numberLeftUp + numberRightUp), Toast.LENGTH_LONG).show();
                    break;
                case R.id.right_button:
                    setResult(RESULT_OK, null);
                    Toast.makeText(getApplicationContext(), Integer.toString(numberLeftDown * numberRightDown), Toast.LENGTH_LONG).show();
                    break;
            }
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var07_secondary);

        leftUp = (TextView)findViewById(R.id.left_second_edit_up_text);
        leftDown = (TextView)findViewById(R.id.left_second_edit_down_text);
        rightUp = (TextView)findViewById(R.id.right_second_edit_up_text);
        rightDown = (TextView)findViewById(R.id.right_second_edit_down_text);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("leftUp")) {
            numberLeftUp = intent.getIntExtra("leftUp", 0);
            leftUp.setText(String.valueOf(numberLeftUp));
        }
        if (intent != null && intent.getExtras().containsKey("leftDown")) {
            numberLeftDown = intent.getIntExtra("leftDown", 0);
            leftDown.setText(String.valueOf(numberLeftDown));
        }
        if (intent != null && intent.getExtras().containsKey("rightUp")) {
            numberRightUp = intent.getIntExtra("rightUp", 1);
            rightUp.setText(String.valueOf(numberRightUp));
        }
        if (intent != null && intent.getExtras().containsKey("rightDown")) {
            numberRightDown = intent.getIntExtra("rightDown", 1);
            rightDown.setText(String.valueOf(numberRightDown));
        }

        sumButton = (Button)findViewById(R.id.left_button);
        sumButton.setOnClickListener(buttonClickListener);
        productButton = (Button)findViewById(R.id.right_button);
        productButton.setOnClickListener(buttonClickListener);
    }
}