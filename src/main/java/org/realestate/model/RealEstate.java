/**
 * Create model. Simple POJO class.
 */

package org.realestate.model;

public class RealEstate {
    private int id;
    private int rooms;
    private int floor;
    private float totalArea;
    private float livingArea;
    private float kitchenArea;
    private String district;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public float getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(float totalArea) {
        this.totalArea = totalArea;
    }

    public float getLivingArea() {
        return livingArea;
    }

    public void setLivingArea(float livingArea) {
        this.livingArea = livingArea;
    }

    public float getKitchenArea() {
        return kitchenArea;
    }

    public void setKitchenArea(float kitchenArea) {
        this.kitchenArea = kitchenArea;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * Override the toString() method for normal mapping on the display.
     * @return user-friendly mapping of the real estate object.
     */
    @Override
    public String toString() {
        return "RealEstate{" +
                "id=" + id +
                ", rooms=" + rooms +
                ", floor=" + floor +
                ", totalArea=" + totalArea +
                ", livingArea=" + livingArea +
                ", kitchenArea=" + kitchenArea +
                ", district='" + district + '\'' +
                '}';
    }
}
