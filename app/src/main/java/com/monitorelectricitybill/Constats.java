package com.monitorelectricitybill;

import java.util.HashMap;
import java.util.Map;

public interface Constats {
    Map<String,Integer> devicesMap=new HashMap<String,Integer>(){{
        put("Air Conditioner",R.drawable.ac);
        put("Light",R.drawable.bulb);
        put("Coffee Maker",R.drawable.coffee_maker);
        put("Electric Cooker",R.drawable.cooker);
        put("DishWasher",R.drawable.dishwasher);
        put("Fan",R.drawable.fan);
        put("Fridge",R.drawable.fridge);
        put("Hair Straightener",R.drawable.drier);
        put("Iron",R.drawable.iron);
        put("Computer",R.drawable.laptop);
        put("Microwave",R.drawable.microwave);
        put("Mixer Grinder",R.drawable.mixer);
        put("Toaster",R.drawable.toaster);
        put("Washing Machine",R.drawable.washing_mashine);
        put("Other",R.drawable.socket);
        put("TV",R.drawable.tv);
        put("Vacuum Cleaner",R.drawable.sucker);
        put("Water Heater",R.drawable.water);
    }};
}
