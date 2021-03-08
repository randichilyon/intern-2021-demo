package com.example.demo;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

  @Override
  public Map<String, List<String>> findAllPhoneName() {
    Samsung samsung = new Samsung();
    samsung.setId("1");
    samsung.setName("Samsung Note 10");
    samsung.setAndroidVersion("Android 10");
    samsung.setType(PhoneType.SAMSUNG);

    Samsung samsung2 = new Samsung();
    samsung2.setId("3");
    samsung2.setName("Samsung S21");
    samsung2.setAndroidVersion("Android 10");
    samsung2.setType(PhoneType.SAMSUNG);

    IPhone iPhone = new IPhone();
    iPhone.setId("2");
    iPhone.setName("Iphone 12");
    iPhone.setIosVersion("ios 12");
    iPhone.setType(PhoneType.IPHONE);

    IPhone iPhone2 = new IPhone();
    iPhone2.setId("4");
    iPhone2.setName("Iphone 11");
    iPhone2.setIosVersion("ios 11");
    iPhone2.setType(PhoneType.IPHONE);

    //SAMSUNG, Sasmsung Note 10, Samsung S21
    //IPHONE, Iphone 12, Iphone 11

    List<Phone> phones = Arrays.asList(samsung, samsung2, iPhone, iPhone2);
    //    Map<String, List<String>> result = new HashMap<>();
    //    for (Phone phone : phones) {
    //      if (result.get(phone.getType().name()) != null) {
    //        result.get(phone.getType().name()).addAll(Collections.singletonList(phone.getName()));
    //      } else {
    //        List<String> names = new ArrayList<>();
    //        names.add(phone.getName());
    //        result.put(phone.getType().name(), names);
    //      }
    //    }

    return phones.stream()
        .collect(Collectors.groupingBy(phone -> phone.getType().name(),
            Collectors.mapping(Phone::getName, Collectors.toList())));
    //
    //    return result;
  }
}
