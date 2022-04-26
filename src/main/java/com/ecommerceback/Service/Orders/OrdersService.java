package com.ecommerceback.Service.Orders;

import com.ecommerceback.Model.Card.CardOrders;
import com.ecommerceback.Model.User.CheckoutRequest;
import com.ecommerceback.Model.User.Request.OrderListDto;
import com.ecommerceback.Model.User.Request.OrdersDtoRequest;
import com.ecommerceback.Model.User.UserModel;
import com.ecommerceback.Repository.Orders.OrderCardsRepository;
import com.ecommerceback.Repository.Orders.OrdersRequestRepository;
import com.ecommerceback.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class OrdersService {

    @Autowired
    private OrdersRequestRepository ordersRequestRepository;
    @Autowired
    private OrderCardsRepository cardsRepository;
    @Autowired
    private UserService userService;

    public ResponseEntity<?> saveOrders(OrdersDtoRequest request){
        UserModel user = userService.findByID(request.getId_user());
        List<CardOrders> cardOrders = new ArrayList<>();
        double total=0.0;
        for(OrderListDto orderListDto: request.getListOrders()) {
            CardOrders card = new CardOrders();
            card.setName_card(orderListDto.getName_card());
            card.setPrice(orderListDto.getPrice());
            card.setQty(orderListDto.getQty());
            card.setImg_url(orderListDto.getImg_url());
            card.setId_card(orderListDto.getId_card());
            total+=Double.parseDouble(card.getPrice())*Integer.parseInt(card.getQty());
            cardOrders.add(card);
        }
        CheckoutRequest check = new CheckoutRequest();
        check.setUserId(user);
        check.setCodOrders(codAuth());
        check.setDateShopp(formatDate());
        check.setHourShopp(formatHour());
        check.setTotalValue(String.valueOf(total));
        List <CardOrders> card =cardsRepository.saveAll(cardOrders);
        check.setCardOrders(card);
        ordersRequestRepository.save(check);
    return ResponseEntity.status(HttpStatus.OK).body("Comprado");
    }

    private String formatDate(){
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dtf2.format(LocalDateTime.now());
    }
    private String formatHour(){
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm");
        return dtf2.format(LocalDateTime.now());
    }

    private String codAuth(){
        DateTimeFormatter day = DateTimeFormatter.ofPattern("dd");
        DateTimeFormatter month = DateTimeFormatter.ofPattern("MM");
        DateTimeFormatter year = DateTimeFormatter.ofPattern("yyyy");
        DateTimeFormatter hour = DateTimeFormatter.ofPattern("HH");
        DateTimeFormatter minute = DateTimeFormatter.ofPattern("mm");
        DateTimeFormatter seconds = DateTimeFormatter.ofPattern("ss");

    return getRandomString(2)+ day.format(LocalDateTime.now())+getRandomString(2)
            +month.format(LocalDateTime.now())+getRandomString(2)+year.format(LocalDateTime.now())+
            getRandomString(2)+ hour.format(LocalDateTime.now())+getRandomString(2)+
            minute.format(LocalDateTime.now())+getRandomString(2)+ seconds.format(LocalDateTime.now());

    }
    static String getRandomString(int i) {
        String theAlphaNumericS;
        StringBuilder builder;

        theAlphaNumericS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+ "0123456789";
        builder = new StringBuilder(i);
        for (int m = 0; m < i; m++) {
            int myindex= (int)(theAlphaNumericS.length()
                    * Math.random());
            builder.append(theAlphaNumericS
                    .charAt(myindex));
        }

        return builder.toString();
    }

    public ResponseEntity<?> getOrdersUser(Long id){
        List<CheckoutRequest> list =ordersRequestRepository.findAllByUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
    public ResponseEntity<?> getOrders(){
        List<CheckoutRequest> list =ordersRequestRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
}
