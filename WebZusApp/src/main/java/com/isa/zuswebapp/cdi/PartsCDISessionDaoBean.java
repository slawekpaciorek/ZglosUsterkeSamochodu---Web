package com.isa.zuswebapp.cdi;

import com.isa.zuswebapp.domain.Part;

public class PartsCDISessionDaoBean implements PartsCDISessionDao {

    private Part part;

    @Override
    public Part getActuallPart() {
        return this.part;
    }

    @Override
    public void setActuallPart(Part part) {
        this.part = part;
    }
}
