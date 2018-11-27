package com.pritam.mytry;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PopUpFragment extends DialogFragment implements View.OnClickListener {

    private TextView tv_display;

    public PopUpFragment() {
        // Empty constructor is required for DialogFragment
        // Make sure not to add arguments to the constructor
        // Use `newInstance` instead as shown below
    }


    public static PopUpFragment newInstance(Integer itemPos, Integer itemQty, String title ) {
        PopUpFragment frag = new PopUpFragment();
        Bundle args = new Bundle();
        args.putInt("itempostion", 0);
        args.putInt("qty", 10);
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public void onStart() {
        super.onStart();
        getDialog().getWindow().setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
        getDialog().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_edit_name, container, false);
        view.findViewById(R.id.bt_0).setOnClickListener(this);
        view.findViewById(R.id.bt_1).setOnClickListener(this);
        view.findViewById(R.id.bt_2).setOnClickListener(this);
        view.findViewById(R.id.bt_3).setOnClickListener(this);
        view.findViewById(R.id.bt_4).setOnClickListener(this);
        view.findViewById(R.id.bt_5).setOnClickListener(this);
        view.findViewById(R.id.bt_6).setOnClickListener(this);
        view.findViewById(R.id.bt_7).setOnClickListener(this);
        view.findViewById(R.id.bt_8).setOnClickListener(this);
        view.findViewById(R.id.bt_9).setOnClickListener(this);
        view.findViewById(R.id.bt_add).setOnClickListener(this);
        view.findViewById(R.id.bt_sub).setOnClickListener(this);
        view.findViewById(R.id.bt_clear).setOnClickListener(this);
        view.findViewById(R.id.bt_del).setOnClickListener(this);

        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        // Get field from view
        tv_display = (TextView) view.findViewById(R.id.tv_display);
        TextView tv_supply_name = (TextView) view.findViewById(R.id.tv_supply_name);

        // Fetch arguments from bundle and set title
        Integer qty = getArguments().getInt("qty", 0);
        tv_display.setText(qty.toString());
        Integer itempostion = getArguments().getInt("itempostion", 0);
        String title = getArguments().getString("title", "");
        tv_supply_name.setText(title);

//        getDialog().setTitle(title);
//        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);

//        // Show soft keyboard automatically and request focus to field
//        mEditText.requestFocus();
//        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    @Override
    public void onClick(View v) {
        String s = tv_display.getText().toString();

        switch (v.getId()) {
            case R.id.bt_add: {
                try {
                    if (s != null) {
                        Integer sno = Integer.parseInt(s);
                        s = String.valueOf(sno + 1);
                    }
                } catch (NumberFormatException e) {
                    s = "0";
                }

            }
            break;
            case R.id.bt_sub: {
                try {
                    if (s != null) {
                        Integer sno = Integer.parseInt(s);
                        if (sno > 0) {
                            sno--;
                            s = sno.toString();
                        } else {
                            s = "0";
                        }
                    }
                } catch (NumberFormatException e) {
                    s = "0";
                }
            }
            break;
            case R.id.bt_clear:
                s = null;
                break;
            case R.id.bt_del:
                if (s != null && s.length() > 1) {
                    s = s.substring(0, s.length() - 1);
                } else {
                    s = null;
                }
                break;
            case R.id.bt_0:
                s = s + "0";
                break;
            case R.id.bt_1:
                s = s + "1";
                break;
            case R.id.bt_2:
                s = s + "2";
                break;
            case R.id.bt_3:
                s = s + "3";
                break;
            case R.id.bt_4:
                s = s + "4";
                break;
            case R.id.bt_5:
                s = s + "5";
                break;
            case R.id.bt_6:
                s = s + "6";
                break;
            case R.id.bt_7:
                s = s + "7";
                break;
            case R.id.bt_8:
                s = s + "8";
                break;
            case R.id.bt_9:
                s = s + "9";
                break;
            default:
                break;
        }

        if (s != null && s.length() > 0 && (!s.equals("0"))) {
            if (s.startsWith("0")) {
                s = s.substring(1, s.length());
                tv_display.setText(s);
            }
            tv_display.setText(s);
        } else {
            tv_display.setText("0");
        }

    }
}