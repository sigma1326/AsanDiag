package ir.asandiag.obd.view.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;

import ir.asandiag.obd.R;
import ir.asandiag.obd.adapter.CarPartConfigAdapter;
import ir.asandiag.obd.adapter.EqualSpacingItemDecoration;
import ir.asandiag.obd.model.CarPartConfigItem;

public class DialogFragmentCarPartConfigs extends BottomSheetDialogFragment implements CarPartConfigAdapter.OnCarPartConfigItemClickListener {
    private NavController navController;
    private final List<CarPartConfigItem> carPartConfigItems = new ArrayList<>();


    public DialogFragmentCarPartConfigs() {
        // Required empty public constructor
    }

    @NonNull
    public static DialogFragmentCarPartConfigs newInstance(String param1, String param2) {
        DialogFragmentCarPartConfigs fragment = new DialogFragmentCarPartConfigs();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
        CarPartConfigItem checkSensors = new CarPartConfigItem(0, "بررسی سنسورها");
        CarPartConfigItem fuelConsumption = new CarPartConfigItem(1, "مصرف سوخت");
        CarPartConfigItem unitSpecs = new CarPartConfigItem(2, "مشخصات unit");
        CarPartConfigItem repair = new CarPartConfigItem(3, "عیب‌یابی");
        CarPartConfigItem checkParams = new CarPartConfigItem(4, "بررسی پارامترها");
        CarPartConfigItem checkFunction = new CarPartConfigItem(5, "بررسی عملکرد");
        CarPartConfigItem reset = new CarPartConfigItem(6, "ریست");
        CarPartConfigItem config = new CarPartConfigItem(7, "پیکربندی");
        CarPartConfigItem specialOps = new CarPartConfigItem(8, "عملیات ویژه");
        carPartConfigItems.add(checkSensors);
        carPartConfigItems.add(fuelConsumption);
        carPartConfigItems.add(unitSpecs);
        carPartConfigItems.add(repair);
        carPartConfigItems.add(checkParams);
        carPartConfigItems.add(checkFunction);
        carPartConfigItems.add(reset);
        carPartConfigItems.add(config);
        carPartConfigItems.add(specialOps);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.dialog_fragment_car_part_configs, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final RecyclerView recyclerView = view.findViewById(R.id.rv_dialog_fragment_car_part_configs);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new CarPartConfigAdapter(new CarPartConfigAdapter.ItemDiffCallBack(), this));
        recyclerView.addItemDecoration(new EqualSpacingItemDecoration(-10));
        ((CarPartConfigAdapter) recyclerView.getAdapter()).submitList(carPartConfigItems);
        navController = NavHostFragment.findNavController(this);
    }

    @Override
    public int getTheme() {
        return R.style.BottomSheetDialogTheme;
    }

    @Override
    public void onCarPartConfigItemClick(@NonNull CarPartConfigItem carPartConfigItem, int pos) {
        if (carPartConfigItem.getId() == 0 && navController != null) {
            navController.navigate(DialogFragmentCarPartConfigsDirections.actionDialogFragmentCarPartConfigsToFragmentCheckSensors());
        }
    }
}