package com.example.app11;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

import androidx.databinding.DataBindingUtil;

import com.example.app11.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    private char CURRENT_ACTION;

    private double valueOne = Double.NaN;
    private double valueTwo;

    private DecimalFormat decimalFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        decimalFormat = new DecimalFormat("#.##########");

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.buttonDot.setOnClickListener(view -> binding.editText.setText(String.format("%s.", binding.editText.getText())));

        binding.buttonZero.setOnClickListener(view -> binding.editText.setText(String.format("%s0", binding.editText.getText())));

        binding.buttonOne.setOnClickListener(view -> binding.editText.setText(String.format("%s1", binding.editText.getText())));

        binding.buttonTwo.setOnClickListener(view -> binding.editText.setText(String.format("%s2", binding.editText.getText())));

        binding.buttonThree.setOnClickListener(view -> binding.editText.setText(String.format("%s3", binding.editText.getText())));

        binding.buttonFour.setOnClickListener(view -> binding.editText.setText(String.format("%s4", binding.editText.getText())));

        binding.buttonFive.setOnClickListener(view -> binding.editText.setText(String.format("%s5", binding.editText.getText())));

        binding.buttonSix.setOnClickListener(view -> binding.editText.setText(String.format("%s6", binding.editText.getText())));

        binding.buttonSeven.setOnClickListener(view -> binding.editText.setText(String.format("%s7", binding.editText.getText())));

        binding.buttonEight.setOnClickListener(view -> binding.editText.setText(String.format("%s8", binding.editText.getText())));

        binding.buttonNine.setOnClickListener(view -> binding.editText.setText(String.format("%s9", binding.editText.getText())));

        binding.buttonAdd.setOnClickListener(view -> {
            computeCalculation();
            CURRENT_ACTION = ADDITION;
            binding.textView.setText(String.format("%s+", decimalFormat.format(valueOne)));
            binding.editText.setText(null);
        });

        binding.buttonSubtract.setOnClickListener(view -> {
            computeCalculation();
            CURRENT_ACTION = SUBTRACTION;
            binding.textView.setText(String.format("%s-", decimalFormat.format(valueOne)));
            binding.editText.setText(null);
        });

        binding.buttonMultiply.setOnClickListener(view -> {
            computeCalculation();
            CURRENT_ACTION = MULTIPLICATION;
            binding.textView.setText(String.format("%s*", decimalFormat.format(valueOne)));
            binding.editText.setText(null);
        });

        binding.buttonDivide.setOnClickListener(view -> {
            computeCalculation();
            CURRENT_ACTION = DIVISION;
            binding.textView.setText(String.format("%s/", decimalFormat.format(valueOne)));
            binding.editText.setText(null);
        });

        binding.buttonEqual.setOnClickListener(view -> {
            computeCalculation();
            binding.textView.setText(String.format("%s%s = %s", binding.textView.getText().toString(), decimalFormat.format(valueTwo), decimalFormat.format(valueOne)));
            valueOne = Double.NaN;
            CURRENT_ACTION = '0';
        });

        binding.buttonClear.setOnClickListener(view -> {
            if (binding.editText.getText().length() > 0) {
                CharSequence currentText = binding.editText.getText();
                binding.editText.setText(currentText.subSequence(0, currentText.length() - 1));
            } else {
                valueOne = Double.NaN;
                valueTwo = Double.NaN;
                binding.editText.setText("");
                binding.textView.setText("");
            }
        });
    }

    private void computeCalculation() {
        if (!Double.isNaN(valueOne)) {
            valueTwo = Double.parseDouble(binding.editText.getText().toString());
            binding.editText.setText(null);

            if (CURRENT_ACTION == ADDITION)
                valueOne = this.valueOne + valueTwo;
            else if (CURRENT_ACTION == SUBTRACTION)
                valueOne = this.valueOne - valueTwo;
            else if (CURRENT_ACTION == MULTIPLICATION)
                valueOne = this.valueOne * valueTwo;
            else if (CURRENT_ACTION == DIVISION)
                valueOne = this.valueOne / valueTwo;
        } else {
            try {
                valueOne = Double.parseDouble(binding.editText.getText().toString());
            } catch (Exception ignored) {
            }
        }
    }
}