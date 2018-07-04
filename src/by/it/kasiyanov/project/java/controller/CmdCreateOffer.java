package by.it.kasiyanov.project.java.controller;

import by.it.kasiyanov.project.java.beans.TravelOffers;
import by.it.kasiyanov.project.java.beans.User;
import by.it.kasiyanov.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

class CmdCreateOffer extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws Exception {
        HttpSession session = req.getSession();
        Object oUser = session.getAttribute("user");
        if (oUser == null){
            return Action.LOGIN;
        }
        User user = (User) oUser;

        if (Util.isPost(req)){
            String description = Util.getString(req, "description");
            String typeOfTravel = Util.getString(req, "typeOfTravel");
            String destination = Util.getString(req, "destination");
            String hotel = Util.getString(req, "hotel");
            String levelOfAccommodation = Util.getString(req, "levelOfAccommodation");
            int numberOfNights = Util.getInteger(req, "numberOfNights");
            double price = Util.getDouble(req, "price");
            TravelOffers travelOffers = new TravelOffers(0,
                    description,
                    typeOfTravel,
                    destination,
                    hotel,
                    levelOfAccommodation,
                    numberOfNights,
                    price,
                    user.getId());
            Dao.getDao().travelOffers.create(travelOffers);
            return Action.PROFILE;
        }
        return null;
    }
}
