package com.mrjeus.calculator;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorFragment extends Fragment {
    View view;
    private TextView mTxtInput;
    private TextView mTxtOutput;

    private Button mBtnNumber0;
    private Button mBtnNumber1;
    private Button mBtnNumber2;
    private Button mBtnNumber3;
    private Button mBtnNumber4;
    private Button mBtnNumber5;
    private Button mBtnNumber6;
    private Button mBtnNumber7;
    private Button mBtnNumber8;
    private Button mBtnNumber9;
    private Button mBtnDot;

    private Button mBtnAdd;
    private Button mBtnSub;
    private Button mBtnDiv;
    private Button mBtnMul;

    private Button mBtnResult;
    private Button mBtnPercent;
    private Button mBtnAC;
    private Button mBtnDEL;
    private Button mBtnNagPos;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_calculator,container,false);
        initWidget();
        setClick();
        return view;
    }

    public void initWidget() {
        mTxtInput = (TextView) view.findViewById(R.id.text_view_in_put);
        mTxtOutput = (TextView) view.findViewById(R.id.text_view_out_put);

        mBtnNumber0 = (Button) view.findViewById(R.id.button_0);
        mBtnNumber1 = (Button) view.findViewById(R.id.button_1);
        mBtnNumber2 = (Button) view.findViewById(R.id.button_2);
        mBtnNumber3 = (Button) view.findViewById(R.id.button_3);
        mBtnNumber4 = (Button) view.findViewById(R.id.button_4);
        mBtnNumber5 = (Button) view.findViewById(R.id.button_5);
        mBtnNumber6 = (Button) view.findViewById(R.id.button_6);
        mBtnNumber7 = (Button) view.findViewById(R.id.button_7);
        mBtnNumber8 = (Button) view.findViewById(R.id.button_8);
        mBtnNumber9 = (Button) view.findViewById(R.id.button_9);
        mBtnDot = (Button) view.findViewById(R.id.button_dot);

        mBtnAdd = (Button) view.findViewById(R.id.button_add);
        mBtnSub = (Button) view.findViewById(R.id.button_sub);
        mBtnDiv = (Button) view.findViewById(R.id.button_div);
        mBtnMul = (Button) view.findViewById(R.id.button_mul);

        mBtnResult = (Button) view.findViewById(R.id.button_result);
        mBtnPercent = (Button) view.findViewById(R.id.button_percent);
        mBtnNagPos = (Button) view.findViewById(R.id.button_neg_pos);
        mBtnAC = (Button) view.findViewById(R.id.button_ac);
        mBtnDEL = (Button) view.findViewById(R.id.button_del);
    }

    public void setClick(){
        mBtnNumber0.setOnClickListener(click);
        mBtnNumber1.setOnClickListener(click);
        mBtnNumber2.setOnClickListener(click);
        mBtnNumber3.setOnClickListener(click);
        mBtnNumber4.setOnClickListener(click);
        mBtnNumber5.setOnClickListener(click);
        mBtnNumber6.setOnClickListener(click);
        mBtnNumber7.setOnClickListener(click);
        mBtnNumber8.setOnClickListener(click);
        mBtnNumber9.setOnClickListener(click);
        mBtnDot.setOnClickListener(click);

        mBtnAdd.setOnClickListener(click);
        mBtnSub.setOnClickListener(click);
        mBtnDiv.setOnClickListener(click);
        mBtnMul.setOnClickListener(click);

        mBtnAC.setOnClickListener(click);
        mBtnPercent.setOnClickListener(click);
        mBtnNagPos.setOnClickListener(click);
        mBtnDEL.setOnClickListener(click);
        mBtnResult.setOnClickListener(click);
    }

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button_0:
                    mTxtInput.append("0");
                    break;
                case R.id.button_1:
                    mTxtInput.append("1");
                    break;
                case R.id.button_2:
                    mTxtInput.append("2");
                    break;
                case R.id.button_3:
                    mTxtInput.append("3");
                    break;
                case R.id.button_4:
                    mTxtInput.append("4");
                    break;
                case R.id.button_5:
                    mTxtInput.append("5");
                    break;
                case R.id.button_6:
                    mTxtInput.append("6");
                    break;
                case R.id.button_7:
                    mTxtInput.append("7");
                    break;
                case R.id.button_8:
                    mTxtInput.append("8");
                    break;
                case R.id.button_9:
                    mTxtInput.append("9");
                    break;
                case R.id.button_dot:
                    mTxtInput.append(".");
                    break;
                case R.id.button_add:
                    mTxtInput.append("+");
                    break;
                case R.id.button_sub:
                    mTxtInput.append("-");
                    break;
                case R.id.button_div:
                    mTxtInput.append("/");
                    break;
                case R.id.button_mul:
                    mTxtInput.append("*");
                    break;
                case R.id.button_result:
                    //todo some thing
                    mTxtOutput.setText(resultNumber(mTxtInput.getText().toString()));
                    break;
                case R.id.button_percent:

                    break;
                case R.id.button_neg_pos:

                    break;
                case R.id.button_ac:
                    mTxtInput.setText("");
                    break;
                case R.id.button_del:
                    String numberAffterRemove = deleteNumber(mTxtInput.getText().toString());
                    mTxtInput.setText(numberAffterRemove);
                    break;
            }
        }
    };
    public String deleteNumber(String number) {
        if (number.length() != 0) {
            int length = number.length();
            String mTem = number.substring(0, length - 1);
            return mTem;
        }
        return null;
    }

    public String resultNumber(String input) {
        String mNumber1 = "";
        String mNumber2 = "";
        double mResult = 0, mNum1, mNum2;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+') {
                mNumber1 = input.substring(0, i);
                mNum1 = Double.parseDouble(mNumber1);
                mNumber2 = input.substring(i + 1, input.length());
                mNum2 = Double.parseDouble(mNumber2);
                mResult = mNum1 + mNum2;
                return (String.valueOf(mResult));
            }
            if (input.charAt(i) == '-') {
                mNumber1 = input.substring(0, i);
                mNum1 = Double.parseDouble(mNumber1);
                mNumber2 = input.substring(i + 1, input.length());
                mNum2 = Double.parseDouble(mNumber2);
                mResult = mNum1 - mNum2;
                return (String.valueOf(mResult));
            }
            if (input.charAt(i) == '*') {
                mNumber1 = input.substring(0, i);
                mNum1 = Double.parseDouble(mNumber1);
                mNumber2 = input.substring(i + 1, input.length());
                mNum2 = Double.parseDouble(mNumber2);
                mResult = mNum1 * mNum2;
                return (String.valueOf(mResult));
            }
            if (input.charAt(i) == '/') {
                mNumber1 = input.substring(0, i);
                mNum1 = Double.parseDouble(mNumber1);
                mNumber2 = input.substring(i + 1, input.length());
                mNum2 = Double.parseDouble(mNumber2);
                mResult = mNum1 / mNum2;
                return (String.valueOf(mResult));
            }
        }
        return String.valueOf(mResult);
    }
}
