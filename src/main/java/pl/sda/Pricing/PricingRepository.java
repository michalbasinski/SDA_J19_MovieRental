package pl.sda.Pricing;

import java.util.ArrayList;
import java.util.List;

public class PricingRepository {

    private List<Pricing> pricingList = new ArrayList<>();

    public PricingRepository() {
        pricingList.add(new Pricing());
    }


    Pricing save(Pricing price) {
        return null;
    }

    //void delete(Pricing Price) {}

    //Pricing update(Pricing Price) {}

    //find(){}

}
