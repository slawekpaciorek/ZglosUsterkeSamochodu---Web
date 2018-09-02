package com.isa.zuswebapp.cdi;

import com.isa.zuswebapp.domain.Part;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
public class PartsCDISessionDaoBean implements PartsCDISessionDao, Serializable {

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
