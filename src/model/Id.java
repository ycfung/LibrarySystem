package model;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

public class Id extends RecursiveTreeObject<Id> {
    private String ID;

    public Id() {

    }

    public Id(String id) {
        this.ID = id;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }
}
