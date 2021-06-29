/**
 * Data Access Object (DAO) is such a design pattern. The point is to create a special layer that will be responsible
 * solely for accessing data (working with a database or other storage mechanism). In the dao package, we will create
 * the RealEstateDAO interface in which there will be methods such as add, remove, etc. I named them a little differently,
 * but they correspond to the main CRUD operations (Create, Read, Update, Delete).
 */

package org.realestate.dao;

import org.realestate.model.RealEstate;

import java.util.List;

public interface RealEstateDAO {
    List<RealEstate> allRealEstates(int page);
    public int realEstatesCount();
    void add(RealEstate realEstate);
    void delete(RealEstate realEstate);
    void edit(RealEstate realEstate);
    RealEstate getById(int id);
}
