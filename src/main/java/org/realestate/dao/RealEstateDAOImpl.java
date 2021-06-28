/**
 * Implementation of the RealEstateDAO interface.
 */

package org.realestate.dao;

import org.realestate.model.RealEstate;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class RealEstateDAOImpl implements RealEstateDAO {

    private static final AtomicInteger AUTO_ID = new AtomicInteger(1);
    private static Map<Integer, RealEstate> realEstates = new HashMap<>();

    static {
        RealEstate realEstate1 = new RealEstate();
        realEstate1.setId(AUTO_ID.getAndIncrement());
        realEstate1.setFloor(3);
        realEstate1.setRooms(2);
        realEstate1.setTotalArea(55.24f);
        realEstate1.setLivingArea(35.32f);
        realEstate1.setKitchenArea(5.43f);
        realEstate1.setDistrict("West");
        realEstates.put(realEstate1.getId(), realEstate1);

        RealEstate realEstate2 = new RealEstate();
        realEstate2.setId(AUTO_ID.getAndIncrement());
        realEstate2.setFloor(6);
        realEstate2.setRooms(3);
        realEstate2.setTotalArea(75.24f);
        realEstate2.setLivingArea(55.32f);
        realEstate2.setKitchenArea(9.43f);
        realEstate2.setDistrict("East");
        realEstates.put(realEstate2.getId(), realEstate2);

        RealEstate realEstate3 = new RealEstate();
        realEstate3.setId(AUTO_ID.getAndIncrement());
        realEstate3.setFloor(2);
        realEstate3.setRooms(1);
        realEstate3.setTotalArea(30.24f);
        realEstate3.setLivingArea(24.32f);
        realEstate3.setKitchenArea(3.43f);
        realEstate3.setDistrict("Center");
        realEstates.put(realEstate3.getId(), realEstate3);

        RealEstate realEstate4 = new RealEstate();
        realEstate4.setId(AUTO_ID.getAndIncrement());
        realEstate4.setFloor(14);
        realEstate4.setRooms(2);
        realEstate4.setTotalArea(45.24f);
        realEstate4.setLivingArea(36.32f);
        realEstate4.setKitchenArea(4.05f);
        realEstate4.setDistrict("South");
        realEstates.put(realEstate4.getId(), realEstate4);
    }

    @Override
    public List<RealEstate> allRealEstates() {
        return new ArrayList<>(realEstates.values());
    }

    @Override
    public void add(RealEstate realEstate) {
        realEstate.setId(AUTO_ID.getAndIncrement());
        realEstates.put(realEstate.getId(), realEstate);
    }

    @Override
    public void delete(RealEstate realEstate) {
        realEstates.remove(realEstate.getId());
    }

    @Override
    public void edit(RealEstate realEstate) {
        realEstates.put(realEstate.getId(), realEstate);
    }

    @Override
    public RealEstate getById(int id) {
        return realEstates.get(id);
    }
}
