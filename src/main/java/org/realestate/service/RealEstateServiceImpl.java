/**
 * Implementation of service layer.
 */

package org.realestate.service;

import org.realestate.dao.RealEstateDAO;
import org.realestate.model.RealEstate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealEstateServiceImpl implements RealEstateService {

    private final RealEstateDAO realEstateDAO;

    /**
     * It is not recommended to use auto-linking on the field, it is better to use constructor or setter.
     * @param realEstateDAO is the DAO class object.
     */
    @Autowired
    public RealEstateServiceImpl(RealEstateDAO realEstateDAO) {
        this.realEstateDAO = realEstateDAO;
    }

    @Override
    public List<RealEstate> allRealEstates() {
        return realEstateDAO.allRealEstates();
    }

    @Override
    public void add(RealEstate realEstate) {
        realEstateDAO.add(realEstate);
    }

    @Override
    public void delete(RealEstate realEstate) {
        realEstateDAO.delete(realEstate);
    }

    @Override
    public void edit(RealEstate realEstate) {
        realEstateDAO.edit(realEstate);
    }

    @Override
    public RealEstate getById(int id) {
        return realEstateDAO.getById(id);
    }
}
