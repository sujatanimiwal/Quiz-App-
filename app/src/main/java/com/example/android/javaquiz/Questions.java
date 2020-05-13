package com.example.android.javaquiz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Questions extends AppCompatActivity {
int total_score;
boolean flag1, flag2, flag3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_questions);
    }

    //Method to display the result as toast message
    public void showToast(View view)
    {

        checkFlag();
        updateInventorScore();
        updateGasScore();

        Context context = getApplicationContext();
        CharSequence text = total_score+"";
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, "Marks"+" obtained:"+text, duration);
        toast.show();
        total_score=0;
    }

    //Method for radio buttons
    public void updateRadioScore(View view)
    {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.ques1_2: {
                if (checked)
                    ++total_score;
                break;
            }
            case R.id.ques2_2: {
                if (checked)
                    ++total_score;
                break;
            }
        }


    }

    //Method for Checkbox
    public void updateCheckScore(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.ques3_1: {
                if (checked) {
                    flag1 = true;
                } else {
                    flag1 = false;
                }
                break;
            }
            case R.id.ques3_3: {
                if (checked) {
                    flag2 = true;
                } else {
                    flag2 = false;
                }
                break;
            }

            case R.id.ques3_4: {
                if (checked) {
                    flag3 = true;
                } else {
                    flag3 = false;
                }
                break;
            }
            case R.id.ques3_2: {


                flag1=flag2=flag3 = false;

                break;
            }


        }
    }

    //Methods for checking the correct answer in the text based answer
    public void updateInventorScore()
    {
        EditText name= (EditText)findViewById(R.id.name);
        String discoverer= (name.getText()).toString();
        if(discoverer.equals("madam curie"))
        {
            ++total_score;
        }
    }

    public void updateGasScore()
    {
        EditText name= (EditText)findViewById(R.id.gas);
        String discoverer= (name.getText()).toString();
        if(discoverer.equals("nitrous oxide"))
        {
            ++total_score;
        }
    }

    //Method to check if user has ticked all the correct ans in the checkboxes or not
    public void checkFlag()
    {
        if(flag1 && flag2 && flag3 )
        {
            ++total_score;
        }

    }

}
