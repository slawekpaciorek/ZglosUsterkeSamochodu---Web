package com.isa.zuswebapp.cdi;

import com.isa.zuswebapp.domain.Part;

public interface PartsCDISessionDao {

    Part getActuallPart();

    void setActuallPart(Part part);

}
