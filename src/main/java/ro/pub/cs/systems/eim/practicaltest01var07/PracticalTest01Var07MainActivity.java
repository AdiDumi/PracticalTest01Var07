package ro.pub.cs.systems.eim.practicaltest01var07;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var07MainActivity extends AppCompatActivity {

    private TextView leftUp, leftDown, rightUp, rightDown;
    private Button setButton;

    private final ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (!leftUp.getText().toString().isEmpty() && !leftDown.getText().toString().isEmpty() && !rightUp.getText().toString().isEmpty() && !rightDown.getText().toString().isEmpty()) {
                int leftUpNumber = Integer.parseInt(leftUp.getText().toString());
                int rightUpNumber = Integer.parseInt(rightUp.getText().toString());
                int leftDownNumber = Integer.parseInt(leftDown.getText().toString());
                int rightDownNumber = Integer.parseInt(rightDown.getText().toString());

                if (view.getId() == R.id.center_button) {
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var07SecondaryActivity.class);
                    intent.putExtra("leftUp", leftUpNumber);
                    intent.putExtra("leftDown", leftDownNumber);
                    intent.putExtra("rightUp", rightUpNumber);
                    intent.putExtra("rightDown", rightDownNumber);
                    startActivityForResult(intent, 1);
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var07_main);

        leftUp = (TextView)findViewById(R.id.left_edit_up_text);
        leftDown = (TextView)findViewById(R.id.left_edit_down_text);
        rightUp = (TextView)findViewById(R.id.right_edit_up_text);
        rightDown = (TextView)findViewById(R.id.right_edit_down_text);

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("leftUpNumber")) {
                leftUp.setText(savedInstanceState.getString("leftUpNumber"));
            } else {
                leftUp.setText(String.valueOf(0));
            }
            if (savedInstanceState.containsKey("leftDownNumber")) {
                leftDown.setText(savedInstanceState.getString("leftDownNumber"));
            } else {
                leftDown.setText(String.valueOf(0));
            }
            if (savedInstanceState.containsKey("rightUpNumber")) {
                rightUp.setText(savedInstanceState.getString("rightUpNumber"));
            } else {
                rightUp.setText(String.valueOf(0));
            }
            if (savedInstanceState.containsKey("rightDownNumber")) {
                rightDown.setText(savedInstanceState.getString("rightDownNumber"));
            } else {
                rightDown.setText(String.valueOf(0));
            }
        } else {
            leftUp.setText(String.valueOf(0));
            leftDown.setText(String.valueOf(0));
            rightUp.setText(String.valueOf(0));
            rightDown.setText(String.valueOf(0));
        }

        setButton = (Button)findViewById(R.id.center_button);
        setButton.setOnClickListener(buttonClickListener);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("leftUpNumber", leftUp.getText().toString());
        savedInstanceState.putString("leftDownNumber", leftDown.getText().toString());
        savedInstanceState.putString("rightUpNumber", rightUp.getText().toString());
        savedInstanceState.putString("rightDownNumber", rightDown.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("leftUpNumber")) {
            leftUp.setText(savedInstanceState.getString("leftUpNumber"));
        } else {
            leftUp.setText(String.valueOf(0));
        }
        if (savedInstanceState.containsKey("leftDownNumber")) {
            leftDown.setText(savedInstanceState.getString("leftDownNumber"));
        } else {
            leftDown.setText(String.valueOf(0));
        }
        if (savedInstanceState.containsKey("rightUpNumber")) {
            rightUp.setText(savedInstanceState.getString("rightUpNumber"));
        } else {
            rightUp.setText(String.valueOf(0));
        }
        if (savedInstanceState.containsKey("rightDownNumber")) {
            rightDown.setText(savedInstanceState.getString("rightDownNumber"));
        } else {
            rightDown.setText(String.valueOf(0));
        }
    }
}