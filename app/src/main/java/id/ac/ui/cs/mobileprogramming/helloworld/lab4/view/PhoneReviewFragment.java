package id.ac.ui.cs.mobileprogramming.helloworld.lab4.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;





import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.helloworld.R;
import id.ac.ui.cs.mobileprogramming.helloworld.lab4.adapters.PhoneAdapter;
import id.ac.ui.cs.mobileprogramming.helloworld.lab4.model.Phone;
import id.ac.ui.cs.mobileprogramming.helloworld.lab4.viewModel.PhoneReviewViewModel;

public class PhoneReviewFragment extends Fragment implements FragmentInterface {

    private PhoneAdapter phoneAdapter;
    private PhoneReviewViewModel phoneReviewViewModel;
    private NavController navController;

    public PhoneReviewFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        phoneAdapter = new PhoneAdapter(this,phoneReviewViewModel.getPhones().getValue());
        phoneReviewViewModel = ViewModelProviders.of(this).get(PhoneReviewViewModel.class);
        phoneReviewViewModel.init();
        phoneReviewViewModel.getPhones().observe(getViewLifecycleOwner(), new Observer<List<Phone>>() {
            @Override
            public void onChanged(List<Phone> phones) {
                phoneAdapter.notifyDataSetChanged();
            }
        });
        navController = Navigation.findNavController(view);
    }

    @Override
    public void itemOnClick() {
        navController.navigate(R.id.action_rowOfPhonesFragment_to_phoneDetailFragment);
    }
}
