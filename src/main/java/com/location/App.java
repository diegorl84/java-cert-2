package com.location;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.ResourceBundle;

public class App {

  public static void main(String[] args) {
    Locale locale = Locale.getDefault();
    System.out.println(locale);

    int customer = 3_200_000;
    int monthly = customer/12;


    //NUMBERS
    var us = NumberFormat.getInstance(Locale.US);
    System.out.println(us.format(monthly));

    var gr= NumberFormat.getInstance(Locale.GERMANY);
    System.out.println(gr.format(monthly));

    var ca = NumberFormat.getInstance(Locale.CANADA_FRENCH);
    System.out.println(ca.format(monthly));

    //CURRENCY
    BigDecimal price = new BigDecimal(48);

    var usCurrency = NumberFormat.getCurrencyInstance(Locale.US);
    System.out.println(usCurrency.format(price));

    var ukCurrency = NumberFormat.getCurrencyInstance(Locale.UK);
    System.out.println(ukCurrency.format(price));

    var grCurrency = NumberFormat.getCurrencyInstance(Locale.GERMANY);
    System.out.println(grCurrency.format(price));

    // DATE
    Locale.setDefault(new Locale("en", "US"));
    var italy = new Locale("it", "IT");
    var dt = LocalDateTime.now();

    print(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT), dt, italy);
    print(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT), dt, italy);
    print(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT, FormatStyle.SHORT), dt, italy);

    var usa = new Locale("en", "US");
    var france = new Locale("fr", "FR");
    printWelcomeMessage(usa);
    printWelcomeMessage(france);

    ResourceBundle rb = ResourceBundle.getBundle("Zoo", usa);
    rb.keySet().stream()
        .map(k -> k + ": " + rb.getString(k))
        .forEach(System.out::println);




  }

  public static void printWelcomeMessage(Locale locale) {
    var rb = ResourceBundle.getBundle("Zoo", locale);
    System.out.println(rb.getString("hello") + ", " + rb.getString("open"));
  }

  public static void print(DateTimeFormatter dtf, LocalDateTime dateTime, Locale locale) {
    System.out.println("With Locale US: " + dtf.format(dateTime) + " | With Locale ITALY: " + dtf.withLocale(locale).format(dateTime));
  }
}
