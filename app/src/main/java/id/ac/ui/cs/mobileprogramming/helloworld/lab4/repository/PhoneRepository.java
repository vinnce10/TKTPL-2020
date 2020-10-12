package id.ac.ui.cs.mobileprogramming.helloworld.lab4.repository;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import id.ac.ui.cs.mobileprogramming.helloworld.lab4.model.Phone;

public class PhoneRepository {



    private static PhoneRepository instance;
    private ArrayList<Phone> dataSet = new ArrayList<>();

    public static PhoneRepository getInstance(){
        if (instance == null){
            instance = new PhoneRepository();
        }
        return instance;
    }

    public MutableLiveData<List<Phone>> getPhones(){
        setPhones();;
        MutableLiveData<List<Phone>> phones = new MutableLiveData<>();
        phones.setValue(dataSet);
        return phones;
    }

    private void setPhones(){
        dataSet.add(new Phone("ROG Phone 3","Asus","Asus has figured out how to make a gaming phone that also excels as a regular smartphone. The ROG Phone 3 is one of the fastest phones on the market right now, and its killer battery life and simple interface make it a great device for anyone.","https://fdn.gsmarena.com/imgroot/reviews/20/asus-rog-phone-3/lifestyle/-727w2/gsmarena_021.jpg"));
        dataSet.add(new Phone("Mi 10 Ultra","Xiaomi","The Xiaomi Mi 10 Ultra is an impressive smartphone. It sets new benchmarks for charging speeds in both wired and wireless form. With top specs and a solid camera system, there's not much to dislike about the device. The Xiaomi Mi 10 Ultra is an impressive smartphone.","https://cdn.dxomark.com/wp-content/uploads/medias/post-50844/xiaomimi10ultra.jpg"));
        dataSet.add(new Phone("F17","Oppo","The square-ish rear camera module includes a 16MP Main (F2. 2) sensor, an 8MP Wide Angle (F2. 2) sensor, and two 2MP monochrome sensors. ... So, overall, the camera performance is decent for the price but the Oppo F17 falls short of phones like Galaxy M31 and Realme 7 Pro in this regard.","https://i.gadgets360cdn.com/large/oppo_f17_pro_review_screen_1599743181794.jpg?downsize=950:*&output-quality=80"));
    }
}
