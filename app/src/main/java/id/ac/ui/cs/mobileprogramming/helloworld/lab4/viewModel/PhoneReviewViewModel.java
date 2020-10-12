package id.ac.ui.cs.mobileprogramming.helloworld.lab4.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.helloworld.lab4.model.Phone;
import id.ac.ui.cs.mobileprogramming.helloworld.lab4.repository.PhoneRepository;

public class PhoneReviewViewModel extends ViewModel {

    MutableLiveData<List<Phone>> mPhones;
    PhoneRepository mRepo;
    MutableLiveData<Boolean> mIsUpdating = new MutableLiveData<>();

    public void init(){
        if (mPhones == null){
            return;
        }
        mRepo = PhoneRepository.getInstance();
        mPhones = mRepo.getPhones();
    }

    public MutableLiveData<List<Phone>> getPhones() {
        return mPhones;
    }

    public MutableLiveData<Boolean> getmIsUpdating() {
        return mIsUpdating;
    }

}
