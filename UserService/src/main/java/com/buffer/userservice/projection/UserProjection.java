package com.buffer.userservice.projection;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import com.buffer.commonservice.model.CardDetails;
import com.buffer.commonservice.model.TUser;
import com.buffer.commonservice.queries.GetUserPaymentDetailsQuery;

//@Component
public class UserProjection {

    //@QueryHandler
    public TUser getUserPaymentDetails(GetUserPaymentDetailsQuery query) {
        //Ideally Get the details from the DB
        CardDetails cardDetails
                = new CardDetails();
        cardDetails.setName("Shabbir Dawoodi");
        cardDetails.setValidUntilYear(2022);
        cardDetails.setValidUntilMonth(01);
        cardDetails.setCardNumber("123456789");
        cardDetails.setCvv(111);

        TUser tuser=new TUser();
        		tuser.setUserId(query.getUserId());
        		tuser.setFirstName("Shabbir");
        		tuser.setLastName("Dawoodi");
        		tuser.setCardDetails(cardDetails);
         return tuser;
    }
}
