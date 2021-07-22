package ks.hs.emirim.hyojin.ex14_15;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String [] fruitsArr = {"복숭아", "체리", "딸기"};
    boolean[] checkArr = {true,false,true};
    int[] imgsArr = {R.drawable.i01, R.drawable.i02, R.drawable.i03};
    Button btnFruits;
    ImageView imgV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnFruits = findViewById(R.id.btn_fruits);
        Button btnDialog = findViewById(R.id.btn_dialog);
        btnDialog.setOnClickListener(btnListener);
        btnFruits.setOnClickListener(btnListener);
        imgV = findViewById(R.id.imgv);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_dialog:
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle(R.string.dialog_title)
                            .setMessage(R.string.dialog_message)
                            .setIcon(R.drawable.warning)
                            .setPositiveButton(R.string.btn_positive, btnPositiveListener)
                            .show();
                    break;
                case R.id.btn_fruits:
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle(R.string.btn_fruits)
                            .setMultiChoiceItems(fruitsArr,checkArr,fruitsMultiItemListener)
                            .setIcon(R.drawable.peach)
                            .setPositiveButton("닫기",null)
                            .show();
                    break;
            }
        }
    };
    DialogInterface.OnMultiChoiceClickListener fruitsMultiItemListener = new DialogInterface.OnMultiChoiceClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
            btnFruits.setText(fruitsArr[which]);
            imgV.setImageResource(imgsArr[which]);
        }
    };
    DialogInterface.OnClickListener fruitsItemListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            btnFruits.setText(fruitsArr[which]);
            imgV.setImageResource(imgsArr[which]);
        }
    };

    DialogInterface.OnClickListener btnPositiveListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(MainActivity.this,"대화상자 확인 버튼을 클릭하셨어용",Toast.LENGTH_SHORT).show();
        }
    };
}