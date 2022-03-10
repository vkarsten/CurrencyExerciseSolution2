package com.example.demo;

import com.example.demo.rest.ConvertModel;
import com.example.demo.rest.Data;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Route("/")
public class CurrencyView extends VerticalLayout {

    public CurrencyView(CurrencyService service) {
        var grid = new Grid<ConvertModel>(ConvertModel.class);
        TextField firstCurr = new TextField();
        TextField amount = new TextField();
        TextField otherCurr = new TextField();

        firstCurr.setPlaceholder("Convert from");
        otherCurr.setPlaceholder("Convert to");
        amount.setPlaceholder("Amount");

        Button convertButton = new Button("Exchange");
        convertButton.addClickListener(
              click -> {
                  // Read input from text fields
                  String curr1 = firstCurr.getValue();
                  Double amountValue = Double.valueOf(amount.getValue());
                  String curr2 = otherCurr.getValue();
                  // Get rates from API
                  Data data = service.getLatestRates().getData();
                  // calculate the exchange
                  Double exchange = exchange(data, amountValue, curr1, curr2);

                  ConvertModel model = new ConvertModel(curr1, curr2, amountValue, exchange);
                  // set grid items
                  grid.setItems(model);
                  grid.setColumns("firstCurrency", "amount", "otherCurrency", "convertedAmount");
              }
        );

        convertButton.addClickShortcut(Key.ENTER);
        // add all components to the layout
        add(new H1("Currency App"),
                grid,
                new HorizontalLayout(firstCurr, amount, otherCurr, convertButton)
        );
    }

    public Double exchange(Data data, Double amount, String curr1, String curr2) {
        // convert c1 to USD (base_currency)
        // convert the result in USD to c2
        Double factor1 = 1.0;
        Double factor2 = 0.0;

        // convert data from Data to Map<String, Object>
        // dictionary.getCurrency("AED") -> Object : {code:"AED", value:3.631}
        factor1 = data.getProperty(curr1).getValue();
        factor2 = data.getProperty(curr2).getValue();

        return (amount / factor1) * factor2;
    }
}
