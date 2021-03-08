package com.example.demo;

import java.util.List;
import java.util.Map;

/**
 * Created by elvira.pratiwi on 08-Mar-21
 */
public interface SearchService {
  Phone searchById(String id);

  Map<String, List<String>> findAllPhoneName();
}
