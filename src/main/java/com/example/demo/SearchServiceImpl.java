package com.example.demo;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * Created by elvira.pratiwi on 08-Mar-21
 */
@Service
public class SearchServiceImpl implements SearchService {
  @Override
  public Phone searchById(String id) {
    Samsung samsung = new Samsung();
    samsung.setId("1");
    samsung.setName("Samsung Note 10");
    samsung.setAndroidVersion("Android 10");

    IPhone iPhone = new IPhone();
    iPhone.setId("2");
    iPhone.setName("Iphone 12");
    iPhone.setIosVersion("ios 12");

    if (StringUtils.equalsIgnoreCase(id, "1")) {
      return samsung;
    } else {
      return iPhone;
    }
  }
}
