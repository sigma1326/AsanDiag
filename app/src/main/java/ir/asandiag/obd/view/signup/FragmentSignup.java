package ir.asandiag.obd.view.signup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import ir.asandiag.obd.R;

public class FragmentSignup extends Fragment {

    private NavController navController;
    private AppCompatButton btnRegister;
    public FragmentSignup() {
        // Required empty public constructor
    }

    @NonNull
    public static FragmentSignup newInstance(String param1, String param2) {
        FragmentSignup fragment = new FragmentSignup();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        btnRegister = view.findViewById(R.id.btn_signup_register);
        navController = NavHostFragment.findNavController(this);
        btnRegister.setOnClickListener(v -> {
            navController.navigate(FragmentSignupDirections.actionFragmentSignupToFragmentLoading());
        });
        return view;
    }
}