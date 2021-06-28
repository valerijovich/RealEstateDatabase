/**
 * A service layer that implements the interaction between the presentation and business logic layers.
 */

package org.realestate.service;

import org.realestate.model.RealEstate;

import java.util.List;

public interface RealEstateService {
    List<RealEstate> allRealEstates();
    void add(RealEstate realEstate);
    void delete(RealEstate realEstate);
    void edit(RealEstate realEstate);
    RealEstate getById(int id);
}
