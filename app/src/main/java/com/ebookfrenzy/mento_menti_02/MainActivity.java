package com.ebookfrenzy.mento_menti_02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private  Button[] buttons=new Button[16];
    private  int[] buttonId=new int[16];
    private TextView textView;
    float num1,num2,res;
    int cal_sym=0;
    int pre_input_state=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i=0; i<16;i++){
            buttonId[i]=getResources().getIdentifier("button"+i,"id",getPackageName());
            buttons[i]=(Button)findViewById((buttonId[i]));
            buttons[i].setTag(i);
            buttons[i].setOnClickListener(this);
        }
        textView=(TextView)findViewById(R.id.textView);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==buttonId[10]){
            textView.append("+");
            cal_sym=1; pre_input_state=0;
        }
        else if(view.getId()==buttonId[11]){
            textView.append("-");
            cal_sym=2; pre_input_state=0;
        }
        else if(view.getId()==buttonId[12]){
            textView.append("X");
            cal_sym=3; pre_input_state=0;
        }
        else if(view.getId()==buttonId[13]){
            textView.append("/");
            cal_sym=4; pre_input_state=0;
        }
        else if(view.getId()==buttonId[14]){
            switch (cal_sym) {
                case 1:
                    res = num1 + num2;
                    break;
                case 2:
                    res = num1 - num2;
                    break;
                case 3:
                    res = num1 * num2;
                    break;
                case 4:
                    res = num1 / num2;
                    break;
                default:
                    break;
            }
            textView.append("="+res);
            num1=res;
            num2=res=0;
            cal_sym=0;
        }
        else if(view.getId()==buttonId[15]){
            textView.setText("");
            num1=num2=res=0;
            cal_sym=0;
//            String text = textView.getText().toString();
//            if(text.length()>0) {
//                textView.setText(text.subSequence(0, text.length() - 1));
//            }
        }
        else{
            float a;
            int b=Integer.parseInt(view.getTag().toString());
            textView.append(view.getTag().toString());
            if(pre_input_state==1){
                a=10*num1+b;
            }
            else a=b;

            if(cal_sym==0){
                num1 = a;
            }
            else{
                num2=a;
            }
            pre_input_state=1;
        }
    }
}
